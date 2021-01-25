package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerSesionesV;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grow Data PC
 */
//@PropertySource("classpath:parametros.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Service
public class SesionesServicioImpl implements SesionesServicio {

    @Autowired
    private SesionesDAO sesionesDAO;
    @Autowired
    private Environment env;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;

    @Override
    @Transactional
    public List<Sesiones> getSesiones() {
        try {
            return sesionesDAO.getSesiones();
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }

    /**
     * Servicio traer sesiones por funcionario.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Respuesta si fue exitóso o no el cambio, y lista de sesiones que
     * cumplan con el criterio de búsqueda.
     */
    @Override
    @Transactional
    public ResponseTraerSesiones getSesionesXFuncionario(long idFuncionario) {
        ResponseTraerSesiones response = new ResponseTraerSesiones();
        try {
            List<Sesiones> sesiones = sesionesDAO.getSesionesXFuncionario(idFuncionario);
            List<SesionesDTO> sesionesDTO = new ArrayList<>();

            List<Sesiones> sesiones2 = new ArrayList();
            Date date = new Date();
            //para validar que la fecha de la sesion sea mayor a la actual
            for (Sesiones s : sesiones) {
                if (date.compareTo(s.getFechainicio()) < 0) {
                    sesiones2.add(s);
                }
            }

            for (Sesiones s : sesiones2) {
                sesionesDTO.add(EntityToDTO.sesionesToSesionesDTO(s));
            }
            response.setDescripcion(Mensajes.ERROR_NO_HAY_SESIONES_S);
            response.setStatus("0");
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Servicio traer una sesión por idsesion.
     *
     * @param saveIdSesion Identificador de la sesión
     * @return Sesión que cumpla con los criterios de búsqueda
     */
    @Override
    @Transactional
    public Sesiones getSesiones(long saveIdSesion) {
        try {
            return sesionesDAO.getSesiones(saveIdSesion);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }

    /**
     * Servicio encargado de guardar las sesiones de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento.
     *
     * @param sesiones Sesión a crear
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO saveSesiones(Sesiones sesiones) {
        ResponseDTO response = new ResponseDTO();
        try {
            long id = sesionesDAO.saveSesiones(sesiones);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_PROGRAMAR_SESIONES);
            response.setAccion(Acciones.REGISTRAR_SESION);
            response.setId(id);
        } catch (HibernateException e) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EXISTE SOLAPE":
                    response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONES);
                    break;
                default:
                    log.writeToLogFile(ex);
                    response.setDescripcion(Mensajes.ERROR_PROGRAMAR_SESIONES);
            }
        }
        return response;
    }

    /**
     * Servicio que se utiliza para actualizar sesiones de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento.
     *
     * @param sesion Sesión con los parametros que se desean actualizar
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO updateSesiones(Sesiones sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            sesionesDAO.updateSesiones(sesion);
            mail.notificaBeneficiariosGenerica(10, sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_SESIONES);
            response.setAccion(Acciones.MODIFICAR_SESION);
        } catch (HibernateException ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EXISTE SOLAPE":
                    response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONES);
                    break;
                default:
                    log.writeToLogFile(ex);
                    response.setDescripcion(Mensajes.ERROR_ACTUALIZAR_SESIONES);
            }

        }
        return response;
    }

    /**
     * Servicio encargado de cancelar las sesiones de tipo: Sensibilización,
     * Valoración, Evaluación y Seguimiento.
     *
     * @param sesion Sesión que se desea cancelar
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO deleteSesiones(Sesiones sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            mail.notificaBeneficiariosGenerica(7, sesion);
            sesionesDAO.deleteSesiones(sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ELIMINAR_SESIONES);
            response.setAccion(Acciones.ELIMINAR_SESION);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        }
        return response;
    }

    /**
     * Metodo que trae las sesiones de un funcionario a partir de su id
     *
     * @param idFuncionario El id del funcionario
     * @return Una lista con las sesiones del funcionario
     */
    public ResponseTraerSesiones getSesionesPorFuncionario(long idFuncionario) {

        ResponseTraerSesiones response = new ResponseTraerSesiones();
        try {
            List<Sesiones> sesiones = sesionesDAO.getSesionesXFuncionario(idFuncionario);
            if (sesiones.size() > 0) {
                List<SesionesDTO> sesionesDTO = new ArrayList<>();
                response = new ResponseTraerSesiones();

                for (Sesiones s : sesiones) {
                    sesionesDTO.add(EntityToDTO.sesionesToSesionesDTO(s));
                }
                response.setSesiones(sesionesDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_SESIONES_S);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_NO_HAY_SESIONES_S);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

    public ResponseTraerSesiones getSesionesVXFuncionario(RequestTraerSesionesV request) {
        ResponseTraerSesiones response = new ResponseTraerSesiones();
        List<SesionesDTO> sesionesDTO = new ArrayList<>();
        try {
            List<Sesiones> sesiones = sesionesDAO.getSesionesVXFuncionario(request.getIdFuncionario());
            for (Sesiones s : sesiones) {
                sesionesDTO.add(EntityToDTO.sesionesToSesionesDTO(s));
            }
            response.setSesiones(sesionesDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_SESIONES_V);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Servicio encargado de cargar las sesiones que cumplan con los parametros.
     *
     * @param idFuncionario Identificador del Funcionario
     * @param tiposesion Tipo de Sesión
     * @param desde Fecha de inicio de búsqueda
     * @param todos Parámetro que indica si se deben traer todas las sesiones o
     * solo las Disponibles
     * @return Respuesta si fue exitóso o no el cambio, y lista de sesiones que
     * cumplan con el criterio de búsqueda.
     */
    @Override
    public ResponseTraerSesiones getSesionesPorFuncionarioTipoSesion(long idFuncionario,
            BigDecimal tiposesion, Date desde, int todos) {
        ResponseTraerSesiones response = new ResponseTraerSesiones();
        try {
            if (desde == null) {
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, Integer.parseInt(env.getProperty("meses.muestra.calendario.programacion.sesion")));
                desde = cal.getTime();
            }

            List<Sesiones> sesiones = sesionesDAO.getSesionesPorFuncionarioTipoSesion(
                    idFuncionario, tiposesion, desde, todos);
            List<SesionesDTO> sesionesDTO = new ArrayList<>();

            for (Sesiones s : sesiones) {
                sesionesDTO.add(EntityToDTO.sesionesToSesionesDTO(s));
            }
            response.setSesiones(sesionesDTO);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setSesiones(new ArrayList<>());
        }
        return response;
    }

    /**
     * Servicio encargado de liberar las sesiones de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento.
     *
     * @param sesion Sesión a liberar
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO liberarSesiones(Sesiones sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            mail.notificaBeneficiariosGenerica(11, sesion);
            sesionesDAO.liberarSesiones(sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_LIBERAR_SESIONES);
            response.setAccion(Acciones.LIBERAR_SESION);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        }
        return response;
    }
}

package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerSesionesComite;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesioncomiteDTO;
import com.growdata.emprendimiento.business.servicio.SesionesComiteServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesComiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Fecha: 04/12/2018
 *
 * @author Juan Carlos Franco
 */
//@PropertySource("classpath:parametros.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Service
public class SesionesComiteServicioImpl implements SesionesComiteServicio {

    @Autowired
    private Environment env;
    @Autowired
    private SesionesComiteDAO sesionesComiteDAO;
    @Autowired
    private PlantillaMailDAO plantillaMailDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio encargado de ubicar las sesiones comité que cumplan con los
     * parámetros de entrada.
     *
     * @param idFuncionario Id Funcionario
     * @param desde Fecha de Inicio de búsqueda
     * @param hasta Fecha Fin de búsqueda
     * @param todas Parámetro para indicar si se ubican todas las sesiones o
     * solo las Disponibles
     * @return Respuesta si fue exitósa o no la búsqueda
     */
    @Override
    public ResponseTraerSesionesComite getSesionesFuncionario(long idFuncionario,
            Date desde, Date hasta, int todas) {
        ResponseTraerSesionesComite response = new ResponseTraerSesionesComite();
        try {
            if (desde == null) {
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, Integer.parseInt(env.getProperty("meses.muestra.calendario.programacion.sesion")));
                desde = cal.getTime();
            }

            List<Sesioncomite> sesiones = sesionesComiteDAO.getSesionesFuncionario(idFuncionario, desde, hasta, todas);
            List<SesioncomiteDTO> sesionesDTO = new ArrayList<>();

            for (Sesioncomite s : sesiones) {
                sesionesDTO.add(EntityToDTO.sesionesComiteToSesionesComiteDTO(s));
            }
            response.setSesiones(sesionesDTO);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
            response.setSesiones(new ArrayList<>());
        }
        return response;
    }

    /**
     * Metodo que trae las sesiones de un funcionario en base a su id
     *
     * @param idFuncionario El id del funcionario
     * @param desde La fecha desde que se traen las sesiones
     * @param hasta La fecha hasta que se traen las sesiones
     * @param todas Entero que define desde que fecha se traen las sesiones
     * @return Una lista con sesiones de comité
     */
    @Override
    public ResponseTraerSesionesComite getSesionesFuncionarioComite(long idFuncionario,
            Date desde, Date hasta, int todas) {
        ResponseTraerSesionesComite response = new ResponseTraerSesionesComite();
        try {
            if (desde == null) {
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, Integer.parseInt(env.getProperty("meses.muestra.calendario.programacion.sesion")));
                desde = cal.getTime();
            }

            List<Sesioncomite> sesiones = sesionesComiteDAO.getSesionesFuncionarioComite(idFuncionario, desde, hasta, todas);
            List<SesioncomiteDTO> sesionesDTO = new ArrayList<>();

            for (Sesioncomite s : sesiones) {
                sesionesDTO.add(EntityToDTO.sesionesComiteToSesionesComiteDTO(s));
            }
            response.setSesiones(sesionesDTO);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
            response.setSesiones(new ArrayList<>());
        }
        return response;
    }

    /**
     * Servicio encargado de crear una nueva Sesión Comité.
     *
     * @param sesiones Sesión Comité a ser guardada
     * @param emprendimientos Lista de Emprendimientos a revisar durante la
     * sesión
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO saveSesiones(Sesioncomite sesiones, List<String> emprendimientos) {
        ResponseDTO response = new ResponseDTO();
        List<Emprendimiento> lEmp = new ArrayList<>();
        try {
            for (String e : emprendimientos) {
                Emprendimiento emp = emprendimientoDAO.getEmprendimientoPorId(Long.valueOf(e));
                if (emp == null) {
                    response.setStatus("0");
                    response.setDescripcion(Mensajes.ERROR_IDEMPRENDIMIENTO_NOENCONTRADO + e);
                    return response;
                }
                lEmp.add(emp);
            }
            long id = sesionesComiteDAO.saveSesiones(sesiones, lEmp);
            notificaBeneficiariosGenerica(14, sesiones);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_PROGRAMAR_SESIONES);
            response.setAccion(Acciones.REGISTRAR_SESION_COMITE);
            response.setId(id);
        } catch (HibernateException ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EXISTE SOLAPE":
                    response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONES);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_PROGRAMAR_SESIONES);
            }
        }
        return response;
    }

    /**
     * Servicio encargado de cancelar una Sesión Comité.
     *
     * @param sesion Sesión Comité que se desea cancelar.
     * @return Respuesta si fue exitóso o no el cambio
     */
    @Override
    public ResponseDTO deleteSesiones(Sesioncomite sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            notificaBeneficiariosGenerica(13, sesion);
            sesionesComiteDAO.deleteSesiones(sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ELIMINAR_SESIONES);
            response.setAccion(Acciones.ELIMINAR_SESION_COMITE);

        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        }
        return response;
    }

    /**
     * Servicio encargado de actualizar una Sesiòn Comité.
     *
     * @param sesion Sesión Comité actualizada
     * @return Respuesta si fue exitóso o no el cambio
     */
    @Override
    public ResponseDTO updateSesiones(Sesioncomite sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            sesionesComiteDAO.updateSesiones(sesion);
            notificaBeneficiariosGenerica(15, sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_SESIONES);
            response.setAccion(Acciones.MODIFICAR_SESION_COMITE);
        } catch (HibernateException ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_ACTUALIZAR_SESIONES);
        }
        return response;
    }

    /**
     * Servicio encargado de ubicar una sesión comité por su idsesioncomite.
     *
     * @param id Id de la sesión comité a consultar
     * @return Respueta si fue exitóso o no el cambio
     */
    @Override
    public SesioncomiteDTO getSesiones(long id) {
        try {
            return EntityToDTO.sesionesComiteToSesionesComiteDTO(sesionesComiteDAO.getSesiones(id));
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            return null;
        }
    }

    /**
     * Notifica a los funcionarios integrantes sobre los cambios generados en
     * las sesiones.
     *
     * @param idPlantilla que se debe utilizar para enviar los email
     * @param sesion la sesión que fue modificada para extraer los funcionarios
     * integrantes.
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    private void notificaBeneficiariosGenerica(long idPlantilla, Sesioncomite sesion) throws Exception {
//        EnviarEmail mail = new EnviarEmail();
        try {
            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
            if (plantilla == null) {
                throw new Exception("");
            }
            String tipoSesion = "Comité Evaluación";
            sesion = sesionesComiteDAO.getSesiones(sesion.getIdsesioncomite());
            for (Integrantescomite i : sesion.getComiteevaluacion().getIntegrantescomites()) {
//                String tempPlantilla = new String(plantilla.getPlantilla());
//                tempPlantilla = tempPlantilla.replace("<#nombres#>", i.getFuncionario().getPrimernombre() + " " + (i.getFuncionario().getSegundonombre() != null ? i.getFuncionario().getSegundonombre() : ""));
//                tempPlantilla = tempPlantilla.replace("<#apellidos#>", i.getFuncionario().getPrimerapellido() + " " + (i.getFuncionario().getSegundoapellido() != null ? i.getFuncionario().getSegundoapellido() : ""));
//                tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", sesion.getFechainicio().toString());
//                tempPlantilla = tempPlantilla.replace("<#fechaFin#>", sesion.getFechafinal().toString());
//                tempPlantilla = tempPlantilla.replace("<#tipoSesion#>", tipoSesion);
//                final String email = i.getFuncionario().getEmail();
//                final String asunto = plantilla.getAsunto();
//                final String plantillaFinal = tempPlantilla;
////                Runnable runnable = () -> {
////                    mail.enviarEmail(email, asunto, plantillaFinal);
////                };
////                new Thread(runnable).start();
//                mail.enviarEmail(email, asunto, plantillaFinal);

                mail.setNombres(i.getFuncionario().getPrimernombre() + " " + (i.getFuncionario().getSegundonombre() != null ? i.getFuncionario().getSegundonombre() : ""));
                mail.setApellidos(i.getFuncionario().getPrimerapellido() + " " + (i.getFuncionario().getSegundoapellido() != null ? i.getFuncionario().getSegundoapellido() : ""));
                mail.setFechaInicio(sesion.getFechainicio().toString());
                mail.setFechaFin(sesion.getFechafinal().toString());
                mail.setTipoSesion(tipoSesion);
                mail.notificarGenerica(idPlantilla, i.getFuncionario().getEmail());
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            throw ex;
        }
    }
}

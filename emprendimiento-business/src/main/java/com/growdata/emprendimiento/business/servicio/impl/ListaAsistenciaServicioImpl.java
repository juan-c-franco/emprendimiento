package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroInasistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroInasistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestAsociarBeneficiariosValoracion;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaLisAsistenciaToListaLisAsistenciaDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.ListaAsistenciaDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.commons.AsistenciasValor2;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Tipoencuesta;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Properties;
import javax.persistence.PersistenceException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
//@PropertySource("classpath:parametros.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Service
public class ListaAsistenciaServicioImpl implements ListaAsistenciaServicio {

    @Autowired
    private ListaAsistenciaDAO listaAsistenciaDAO;
    @Autowired
    private SesionesDAO sesionesDAO;
    @Autowired
    private Environment env;
    @Autowired
    private EnviarEmail enviar;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;

    private Properties prop = new Properties();

//    EnviarEmail enviar = new EnviarEmail();
    private Listaasistencia lista;

    /**
     * Metodo que trae una lista de asistencias a partir de un id de sesión
     *
     * @param request Contiene el id de la sesión
     * @return Una lista de asistencias
     */
    @Override
    @Transactional
    public ResponseTraerAsistentes getLista(RequestTraerAsistentes request) {
        ResponseTraerAsistentes response = new ResponseTraerAsistentes();
        List<ListaasistenciaDTO> asistenciasDTO = new ArrayList();
        try {
            List<Listaasistencia> asistencias = listaAsistenciaDAO.getLista(request.getIdsesion());
            //valido que efectivamente se hayan traido las cajas del DAO
            if (asistencias.size() > 0) {
                asistenciasDTO = EntityToDTO.listaLisAsistenciaToListaLisAsistenciaDTO(asistencias);
                response.setAsistenciaDTO(asistenciasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_ASISTENTES_SESION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ASISTENTES_SESION);
                response.setStatus("0");
                response.setAsistenciaDTO(asistenciasDTO);
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;

    }

    /**
     * Metodo que registra las asistencias de una sesion
     *
     * @param request Contiene el id de la sesión, el id del funcionario y el
     * valor de las asistencia
     * @return La respuesta si se registrarion las asistencias
     * satisfactoriamente o no
     */
    @Override
    @Transactional
    @Modifying
    public ResponseRegistroAsistencias registroAsistencias(RequestRegistroAsistencias request) {
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
        List<AsistenciasValor> asistencias1 = request.getAsistencias();
        List<AsistenciasValor2> asistencias = new ArrayList();
        for (int i = 0; i < asistencias1.size(); i++) {
            AsistenciasValor2 asistencia = new AsistenciasValor2();
            asistencia.setIdasistencia(asistencias1.get(i).getIdasistencia());
            asistencia.setValor(asistencias1.get(i).getValor());
            asistencias.add(asistencia);
        }
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            Tipoencuesta tipoencuesta = new Tipoencuesta();
            tipoencuesta.setIdtipoencuesta(new BigDecimal(1));
            correos = listaAsistenciaDAO.registroAsistencias(asistencias,
                    Integer.parseInt(env.getProperty("vigencia.encuesta.sensibilizacion")),
                    request.getIdsesion(), tipoencuesta);
            for (CorreosAsistencias c : correos) {
                enviar.setApellidos(c.getPrimerApellido() + " " + (c.getSegundoApellido() != null ? c.getSegundoApellido() : ""));
                enviar.setNombres(c.getPrimerNombre() + " " + (c.getSegundoNombre() != null ? c.getSegundoNombre() : ""));
                enviar.setMeses(env.getProperty("vigencia.encuesta.sensibilizacion"));
                enviar.setIdBeneficiario(String.valueOf(c.getIdBeneficiario()));
                enviar.setIdFuncionario(String.valueOf(request.getIdfuncionario()));
                enviar.setIdEncuesta(String.valueOf(c.getIdEncuesta()));
                enviar.setFechaCaducidad(new Timestamp(System.currentTimeMillis()).toString());
                if (c.getValor().equals("Si")) {
                    enviar.notificarGenerica(29, c.getCorreo());
                } else {
                    enviar.notificarGenerica(26, c.getCorreo());
                }

            }
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA);
            response.setDescripcion(Mensajes.EXITO_REGISTRO_ASISTENCIA);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    @Override
    @Transactional
    public ResponseRegistroInasistentes getListaInasistentes(RequestRegistroInasistentes request) {
        int idsesion = request.getIdsesion();
        ResponseRegistroInasistentes response = new ResponseRegistroInasistentes();
        try {
            List<Listaasistencia> asistencias = listaAsistenciaDAO.getListaInasistentes(request.getIdsesion());
            //valido que efectivamente se hayan traido los inasistenes del DAO
            if (asistencias != null) {
                List<ListaasistenciaDTO> asistenciasDTO = listaLisAsistenciaToListaLisAsistenciaDTO(asistencias);
                response.setAsistenciasDTO(asistenciasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_ASISTENTES_SESION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ASISTENTES_SESION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;

    }

    /**
     * Servicio encargado de asociar un beneficiario a una sesión de
     * Sensibilización.
     *
     * @param listaDTO Lista de Asistencia con el beneficiario y la sesión a
     * donde se va a vincular.
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    @Transactional
    public ResponseAsociarBeneficiarioSesion asociarBeneficiario(ListaasistenciaDTO listaDTO) {
        ResponseAsociarBeneficiarioSesion response = new ResponseAsociarBeneficiarioSesion();

        try {
            Listaasistencia listaAsist = DTOToEntity.dtoListaasistenciaToListaasistencia(listaDTO);
            Date date = new Date();
            listaAsist.setFecharegistro(date);
            listaAsistenciaDAO.asociarBeneficiario(listaAsist, Integer.parseInt(env
                    .getProperty("tiempo.espera.nuevo.emprendimiento")));
            Beneficiario beneficiario = beneficiarioDAO.getBeneficiario(listaAsist.getBeneficiario().getIdbeneficiario());
            Sesiones s = sesionesDAO.getSesiones(listaAsist.getSesiones().getIdsesion());
            enviar.setNombres(beneficiario.getPrimernombre() + " "
                    + (beneficiario.getSegundonombre() != null ? beneficiario.getSegundonombre() : ""));
            enviar.setApellidos(beneficiario.getPrimerapellido() + " "
                    + (beneficiario.getSegundoapellido() != null ? beneficiario.getSegundoapellido() : ""));
            enviar.setTipoSesion("Sensibilización");
            enviar.setFechaInicio(s.getFechainicio().toString());
            enviar.setFechaFin(s.getFechafinal().toString());
            enviar.setUbicacionSesion(s.getUbicacion());
            enviar.notificarGenerica(8, beneficiario.getEmail());
            response.setDescripcion(Mensajes.EXITO_ASOCIACION_BENEFICIARIO_SESION);
            response.setStatus("1");
            response.setAccion(Acciones.ASOCIAR_BENEFICIARIO_SESION);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "NO HAY CUPO":
                    response.setDescripcion(Mensajes.ERROR_SIN_CUPO_SESIONES);
                    break;
                case "SESION NO DISPONIBLE":
                    response.setDescripcion(Mensajes.ERROR_SESION_NO_DISPONIBLE);
                    break;
                case "EL BENEFICIARIO DEBE ESPERAR 3 MESES DESDE QUE AGENDO SU ULTIMO EMPRENDIMIENTO":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO);
                    break;
                case "BENEFICIARIO YA ASIGNADO Ó PENDIENTE POR REGISTRAR ASISTENCIA":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_OTRA_SESION);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_DESCONOCIDO_AGENDAR_SESION + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * Metodo que registra las asistencias de una sesion
     *
     * @param request Contiene el id de la sesión, el id del funcionario y el
     * valor de las asistencia
     * @return La respuesta si se registrarion las asistencias
     * satisfactoriamente o no
     */
    @Override
    public ResponseRegistroAsistencias registroAsistenciasV(RequestRegistroAsistencias request) {
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
        List<AsistenciasValor> asistencias1 = request.getAsistencias();
        List<AsistenciasValor2> asistencias = new ArrayList();
        for (int i = 0; i < asistencias1.size(); i++) {
            AsistenciasValor2 asistencia = new AsistenciasValor2();
            asistencia.setIdasistencia(asistencias1.get(i).getIdasistencia());
            asistencia.setValor(asistencias1.get(i).getValor());
            asistencias.add(asistencia);
        }
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            Tipoencuesta tipoencuesta = new Tipoencuesta();
            tipoencuesta.setIdtipoencuesta(new BigDecimal(2));
            correos = listaAsistenciaDAO.registroAsistencias(asistencias,
                    Integer.parseInt(env.getProperty("vigencia.encuesta.sensibilizacion")),
                    request.getIdsesion(), tipoencuesta);
            for (CorreosAsistencias c : correos) {
                enviar.setApellidos(c.getPrimerApellido() + " " + (c.getSegundoApellido() != null ? c.getSegundoApellido() : ""));
                enviar.setNombres(c.getPrimerNombre() + " " + (c.getSegundoNombre() != null ? c.getSegundoNombre() : ""));
                enviar.setMeses(env.getProperty("vigencia.encuesta.sensibilizacion"));
                enviar.setIdBeneficiario(String.valueOf(c.getIdBeneficiario()));
                enviar.setIdFuncionario(String.valueOf(request.getIdfuncionario()));
                enviar.setIdEncuesta(String.valueOf(c.getIdEncuesta()));
                enviar.setFechaCaducidad(new Timestamp(System.currentTimeMillis()).toString());
                if (c.getValor().equals("Si")) {
                    enviar.notificarGenerica(27, c.getCorreo());
                } else {
                    enviar.notificarGenerica(28, c.getCorreo());
                }

            }
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA);
            response.setDescripcion(Mensajes.EXITO_REGISTRO_ASISTENCIA);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    /**
     * Servicio encargado de asociar un beneficiario a una sesión de Valoración.
     *
     * @param request Datos de los beneficiarios y la sesión de Valoración a
     * donde se vincularán.
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseAsociarBeneficiarioSesion asociarBeneficiarioValoracion(
            RequestAsociarBeneficiariosValoracion request) {
        ResponseAsociarBeneficiarioSesion response = new ResponseAsociarBeneficiarioSesion();

        try {
            List<Beneficiario> beneficiarios = listaAsistenciaDAO.asociarBeneficiarioValoracion(
                    request.getIdSesion(), request.getBeneficiarios(), Integer.
                    parseInt(env.getProperty("tiempo.espera.nuevo.emprendimiento")));
            Sesiones s = sesionesDAO.getSesiones(request.getIdSesion());
            enviar.notificaBeneficiariosGenerica(8, s);
            response.setDescripcion(Mensajes.EXITO_ASOCIACION_BENEFICIARIO_SESION);
            response.setStatus("1");
            response.setAccion(Acciones.ASOCIAR_BENEFICIARIO_SESION);
        } catch (PersistenceException ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(Mensajes.ERROR_ASOCIACION_BENEFICIARIO_V + ex.getMessage());
            response.setStatus("0");
        } catch (Exception ex) {
            response.setStatus("0");

            if (ex.getCause() != null && "EMAIL INVALIDO".equals(ex.getCause().getMessage())) {
                response.setDescripcion(Mensajes.ERROR_EMAIL_INVALIDO + ex.getMessage());
                return response;
            }
            switch (ex.getMessage()) {
                case "NO HAY CUPO":
                    response.setDescripcion(Mensajes.ERROR_SIN_CUPO_SESIONES);
                    break;
                case "SESION NO DISPONIBLE":
                    response.setDescripcion(Mensajes.ERROR_SESION_NO_DISPONIBLE);
                    break;
                case "EL BENEFICIARIO DEBE ESPERAR 3 MESES DESDE QUE AGENDO SU ULTIMO EMPRENDIMIENTO":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO);
                    break;
                case "BENEFICIARIO YA ASIGNADO Ó PENDIENTE POR REGISTRAR ASISTENCIA":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_OTRA_SESION);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_DESCONOCIDO_AGENDAR_SESION + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * Servicio encargado de asociar a un beneficiario a una sesión de tipo:
     * Evaluacion y Financiación, o Puesta en Marcha y Seguimiento.
     *
     * @param request Datos de la sesión y los beneficiarios a asociar
     * @return Respuestá si fue exitóso o no el cambio.
     */
    @Override
    public ResponseAsociarBeneficiarioSesion asociarBeneficiarioEvaluacionSeguimiento(
            RequestAsociarBeneficiariosValoracion request) {
        ResponseAsociarBeneficiarioSesion response = new ResponseAsociarBeneficiarioSesion();

        try {
            List<Beneficiario> beneficiarios = listaAsistenciaDAO.asociarBeneficiarioEvaluacionSeguimiento(
                    request.getIdSesion(), request.getBeneficiarios(), request.getTipoSesion(),
                    request.getEstadoEmprendimiento());
            Sesiones s = sesionesDAO.getSesiones(request.getIdSesion());
            enviar.notificaBeneficiariosGenerica(8, s);
            response.setDescripcion(Mensajes.EXITO_ASOCIACION_BENEFICIARIO_SESION);
            response.setStatus("1");
            response.setAccion(Acciones.ASOCIAR_BENEFICIARIO_SESION);
            response.setId(request.getIdSesion());
        } catch (PersistenceException ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(Mensajes.ERROR_ASOCIACION_BENEFICIARIO_V + ex.getMessage());
            response.setStatus("0");
        } catch (Exception ex) {

            response.setStatus("0");
            if (ex.getCause() != null && "EMAIL INVALIDO".equals(ex.getCause().getMessage())) {
                response.setDescripcion(Mensajes.ERROR_EMAIL_INVALIDO + ex.getMessage());
                return response;
            }

            switch (ex.getMessage()) {
                case "EL BENEFICIARIO DEBE ESPERAR 3 MESES DESDE QUE AGENDO SU ULTIMO EMPRENDIMIENTO":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO);
                    break;
                case "NO HAY CUPO":
                    response.setDescripcion(Mensajes.ERROR_SIN_CUPO_SESIONES);
                    break;
                case "SESION NO DISPONIBLE":
                    response.setDescripcion(Mensajes.ERROR_SESION_NO_DISPONIBLE);
                    break;
                case "EL BENEFICIARIO NO TIENE UNA IDEA DE EMPRENDIMIENTO EN EL ESTADO NECESARIO.":
                    response.setDescripcion(Mensajes.ERROR_ESTADO_EMPRENDIMIENTO);
                    break;
                case "BENEFICIARIO YA ASIGNADO Ó PENDIENTE POR REGISTRAR ASISTENCIA":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_OTRA_SESION);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_DESCONOCIDO_AGENDAR_SESION + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * Metodo que registra las asistencias de una sesion
     *
     * @param request Contiene el id de la sesión, el id del funcionario y el
     * valor de las asistencia
     * @return La respuesta si se registrarion las asistencias
     * satisfactoriamente o no
     */
    @Override
    public ResponseRegistroAsistencias registroAsistenciasE(RequestRegistroAsistencias request) {
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
        List<AsistenciasValor> asistencias1 = request.getAsistencias();
        List<AsistenciasValor2> asistencias = new ArrayList();
        for (int i = 0; i < asistencias1.size(); i++) {
            AsistenciasValor2 asistencia = new AsistenciasValor2();
            asistencia.setIdasistencia(asistencias1.get(i).getIdasistencia());
            asistencia.setValor(asistencias1.get(i).getValor());
            asistencias.add(asistencia);
        }
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            correos = listaAsistenciaDAO.registroAsistenciasE(asistencias, Integer.parseInt(env.getProperty("vigencia.encuesta.sensibilizacion")), request.getIdsesion());
            for (CorreosAsistencias c : correos) {
                enviar.setApellidos(c.getPrimerApellido() + " " + (c.getSegundoApellido() != null ? c.getSegundoApellido() : ""));
                enviar.setNombres(c.getPrimerNombre() + " " + (c.getSegundoNombre() != null ? c.getSegundoNombre() : ""));
                if (c.getValor().equals("Si")) {
                    enviar.notificarGenerica(32, c.getCorreo());
                } else {
                    enviar.notificarGenerica(33, c.getCorreo());
                }

            }
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA);
            response.setDescripcion(Mensajes.EXITO_REGISTRO_ASISTENCIA);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    /**
     * Metodo que registra las asistencias de una sesion
     *
     * @param request Contiene el id de la sesión, el id del funcionario y el
     * valor de las asistencia
     * @return La respuesta si se registrarion las asistencias
     * satisfactoriamente o no
     */
    @Override
    public ResponseRegistroAsistencias registroAsistenciasS(RequestRegistroAsistencias request) {
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
        List<AsistenciasValor> asistencias1 = request.getAsistencias();
        List<AsistenciasValor2> asistencias = new ArrayList();
        for (int i = 0; i < asistencias1.size(); i++) {
            AsistenciasValor2 asistencia = new AsistenciasValor2();
            asistencia.setIdasistencia(asistencias1.get(i).getIdasistencia());
            asistencia.setValor(asistencias1.get(i).getValor());
            asistencias.add(asistencia);
        }
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            correos = listaAsistenciaDAO.registroAsistenciasE(asistencias, Integer.parseInt(env.getProperty("vigencia.encuesta.sensibilizacion")), request.getIdsesion());
            for (CorreosAsistencias c : correos) {
                enviar.setApellidos(c.getPrimerApellido() + " " + (c.getSegundoApellido() != null ? c.getSegundoApellido() : ""));
                enviar.setNombres(c.getPrimerNombre() + " " + (c.getSegundoNombre() != null ? c.getSegundoNombre() : ""));
                if (c.getValor().equals("Si")) {
                    enviar.notificarGenerica(35, c.getCorreo());
                } else {
                    enviar.notificarGenerica(36, c.getCorreo());
                }

            }
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA);
            response.setDescripcion(Mensajes.EXITO_REGISTRO_ASISTENCIA);
            response.setStatus("1");
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

}

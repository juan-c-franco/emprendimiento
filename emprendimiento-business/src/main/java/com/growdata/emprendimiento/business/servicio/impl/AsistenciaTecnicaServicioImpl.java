package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ConsultarAvanceComplexDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestUpdateListasAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATComplexPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseUpdateListasAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionAATComplexDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import static com.growdata.emprendimiento.business.commons.DTOToEntity.dtoListaATTTOListaATT;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AsociadosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipodocumentosDTO;
import com.growdata.emprendimiento.business.servicio.AsistenciaTecnicaServicio;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.DAO.AsistenciaTecnicaDAO;
import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.SeguimientoasistenciaDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Seguimientoasistencia;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentos;
import static java.lang.Math.abs;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import org.springframework.core.env.Environment;

/**
 *
 * @author Danny Fernando Guerrero Gelpud
 */
@Service
public class AsistenciaTecnicaServicioImpl implements AsistenciaTecnicaServicio {

    @Autowired
    private AsistenciaTecnicaDAO asistenciaTecnicaDAO;
    @Autowired
    private PlantillaMailDAO plantillaMailDAO;
    @Autowired
    private AsociadoDAO asociadoDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private TemasRutaCapacitacionDAO temasRutaCapacitacionDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private Environment env;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private SeguimientoasistenciaDAO seguimientoasistenciaDAO;
    @Autowired
    private AprobacionDAO aprobacionDAO;
    @Autowired
    private EnviarEmail enviar;

    /**
     * Servicio encargado de ubicar las sesiones que cumplan con los parámetros
     * de entrada.
     *
     * @param request Criterios de búsqueda
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de sesiones
     * que cumplan con los criterios de búsquedad.
     */
    @Override
    public ResponseTraerSesionesAATPorFuncionario getSesionesAAT(RequestTraerSesionesAATPorFuncionario request) {
        ResponseTraerSesionesAATPorFuncionario response = new ResponseTraerSesionesAATPorFuncionario();
        try {
            List<Sesionacompanamientoat> sesionesAAT = asistenciaTecnicaDAO.getSesionesAATPorFuncionario(request.getEstadosSesion(), request.getIdFuncionario());
            if (sesionesAAT != null) {
                List<SesionacompanamientoatDTO> sesionesAATDTO = new ArrayList<>();
                Date now = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(now);
                cal.add(Calendar.MONTH, Integer.parseInt(env.getProperty("meses.muestra.calendario.programacion.sesion")));
                Date desde = cal.getTime();
                if (request.getTipoBusqueda() == 'd') {
                    sesionesAAT.forEach((sAAT) -> {
                        if (new Date(sAAT.getFechainicio().getTime()).compareTo(now) > 0) {
                            sesionesAATDTO.add(EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sAAT));
                        }
                    });
                } else if (request.getTipoBusqueda() == 'a') {
                    sesionesAAT.forEach((sAAT) -> {
                        if (new Date(sAAT.getFechainicio().getTime()).compareTo(now) <= 0 && new Date(sAAT.getFechainicio().getTime()).compareTo(desde) > 0) {
                            sesionesAATDTO.add(EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sAAT));
                        }
                    });
                } else {
                    sesionesAAT.forEach((sAAT) -> {
                        if (new Date(sAAT.getFechainicio().getTime()).compareTo(desde) > 0) {
                            sesionesAATDTO.add(EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sAAT));
                        }
                    });
                }
                response.setSesionesAATDTO(sesionesAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_SESIONES_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de guardar o actualizar una sesion de Asistencia
     * Técnica.
     *
     * @param request Datos de la sesión
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseGuardarSesionAAT guardarSesionAAT(RequestGuardarSesionAAT request
    ) {
        ResponseGuardarSesionAAT response = new ResponseGuardarSesionAAT();
        try {
            Sesionacompanamientoat sesionAAT = DTOToEntity.dtoSesionAATToSesionAAT(request.getSesionAATDTO());
            long resp = -1;
            List<Sesionacompanamientoat> lstSesionesAATConSolapamiento = asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(sesionAAT);
            if (lstSesionesAATConSolapamiento != null && lstSesionesAATConSolapamiento.size() > 0) {
                response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONESAAT);
                response.setStatus("0");
            } else {
                if (sesionAAT.getIdsesionacompanamientoat() > 0) {
                    resp = asistenciaTecnicaDAO.updateSesionAAT(sesionAAT);
                    notificaBeneficiariosGenerica(10, sesionAAT.getIdsesionacompanamientoat());
                    response.setDescripcion(Mensajes.EXITO_UPDATE_SESION_AAT);
                    response.setStatus("1");
                    response.setAccion(Acciones.MODIFICAR_SESION_AAT);
                    response.setId(resp);
                } else {
                    resp = asistenciaTecnicaDAO.setSesionAAT(sesionAAT);
                    response.setDescripcion(Mensajes.EXITO_REGISTRO_SESION_AAT);
                    response.setStatus("1");
                    response.setAccion(Acciones.REGISTRAR_SESION_AAT);
                    response.setId(resp);
                }
            }
            response.setSesionAATId(resp);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_GUARDAR_SESION_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de cancelar una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param request Datos de la sesión a cancelar.
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseEliminarSesionAAT deleteSesionAAT(RequestEliminarSesionAAT request
    ) {
        ResponseEliminarSesionAAT response = new ResponseEliminarSesionAAT();
        try {
            notificaBeneficiariosGenerica(7, request.getIdSessionAAT());
            asistenciaTecnicaDAO.deleteSesionAAT(request.getIdSessionAAT());
            response.setDescripcion(Mensajes.EXITO_DELETE_SESION_AAT);
            response.setStatus("1");
            response.setAccion(Acciones.ELIMINAR_SESION_AAT);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_DELETE_SESION_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de ubicar una sesion de Acompañamiento y Asistencia
     * Técnica por su Id.
     *
     * @param request Identificador de la sesion
     * @return Repuesta si fue exitósa o no la búsqueda, y la sesión que cumpla
     * con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerSesionAATPorId getSesionAAT(RequestTraerSesionAATPorId request
    ) {
        ResponseTraerSesionAATPorId response = new ResponseTraerSesionAATPorId();
        try {
            Sesionacompanamientoat sesionAAT = asistenciaTecnicaDAO.getSesionAAT(request.getSesionAATId());
            if (sesionAAT != null) {
                SesionacompanamientoatDTO sesionAATDTO = EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sesionAAT);
                response.setSesionAAT(sesionAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_SESION_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_SESION_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_SESION_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de asociar un beneficiario a una determinada sesión de
     * Acompañamiento y Asistencia Técnica.
     *
     * @param request Datos de la sesión a actualizar
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseGuardarSesionAAT actualizarSesionAAT(RequestGuardarSesionAAT request) {
        ResponseGuardarSesionAAT response = new ResponseGuardarSesionAAT();
        try {
            Sesionacompanamientoat sesionAAT = DTOToEntity.dtoSesionAATToSesionAAT(request.getSesionAATDTO());
            long resp = -1;
            List<Asociados> asociados = asociadoDAO.getAsociadosPorEmprendimiento(request.getSesionAATDTO().getRutaacompanamientoat().getEmprendimiento().getIdemprendimiento());
            asistenciaTecnicaDAO.setListaAAT(asociados, sesionAAT);
            notificaBeneficiariosGenerica(6, sesionAAT.getIdsesionacompanamientoat());
            resp = sesionAAT.getIdsesionacompanamientoat();
            response.setDescripcion(Mensajes.EXITO_UPDATE_SESION_AAT);
            response.setStatus("1");
            response.setAccion(Acciones.MODIFICAR_SESION_AAT);
            response.setId(resp);
            response.setSesionAATId(resp);
        } catch (NoResultException ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_SESION_NO_DISPONIBLE);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_GUARDAR_SESION_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de conseguir un Temas de Acompañamiento y Asistencia
     * Técnica dado su id.
     *
     * @param requestTraerTemasRutaAAT Identificador del Tema
     * @return Respuesta si fue exitósa o no la búsqueda y el Tema que cumpla
     * con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerTemasRutaAAT getTemaRutaAAT(RequestTraerTemasRutaAAT requestTraerTemasRutaAAT
    ) {
        ResponseTraerTemasRutaAAT response = new ResponseTraerTemasRutaAAT();
        try {
            Temasrutaacompanamientoat temaRutaAAT = asistenciaTecnicaDAO.getTemaRutaAAT(requestTraerTemasRutaAAT.getIdTemaRutaAAT());
            if (temaRutaAAT != null) {
                TemasrutaacompanamientoatDTO temasRutaAATDTO = EntityToDTO.temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(temaRutaAAT);
                response.setTemasRutaAATDTO(temasRutaAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_TEMA_RUTA_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_TEMA_RUTA_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TEMA_RUTA_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de ubicar una Sesión de AAT.
     *
     * @param request Identificador de la Sesión
     * @return Respuesta si fue exitósa o no la búsqueda, y la sesión de
     * acompañamiento que cumpla con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerSesionAATComplexPorId getSesionAATComplex(RequestTraerSesionAATPorId request
    ) {
        ResponseTraerSesionAATComplexPorId response = new ResponseTraerSesionAATComplexPorId();
        try {
            Sesionacompanamientoat sesionAAT = asistenciaTecnicaDAO.getSesionAAT(request.getSesionAATId());
            if (sesionAAT != null) {
                SesionAATComplexDTO sesionAATComplexDTO = new SesionAATComplexDTO();
                sesionAATComplexDTO.setSesionacompanamientoatDTO(EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sesionAAT));

                List<Listaasistenciaaat> listaAAT = asistenciaTecnicaDAO.getListaAAT(request.getSesionAATId());
                sesionAATComplexDTO.setListaAATDTO(EntityToDTO.listasAATToListaAATDTO(listaAAT));
                response.setSesionAATComplexDTO(sesionAATComplexDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_SESIONES_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de conseguir las Rutas de Acompañamiento y Asistencia
     * Técnica para un determinado emprendimiento dado su idemprendimiento
     *
     * @param requestTraerRutaAAT Identificador del Emprendimiento
     * @return Respuesta si fue exitósa o no la búsqueda y la ruta de
     * Acompañamiento y Asistencia Técnica.
     */
    @Override
    public ResponseTraerRutaAAT getRutaAAT(RequestTraerRutaAAT requestTraerRutaAAT) {
        ResponseTraerRutaAAT response = new ResponseTraerRutaAAT();
        try {
            Rutaacompanamientoat rutaAAT = asistenciaTecnicaDAO.getRutaAAT(requestTraerRutaAAT.getIdEmprendimiento());
            if (rutaAAT != null) {
                RutaacompanamientoatDTO rutaAATDTO = EntityToDTO.rutaAcompanamientoATToRutaacompanamientoatDTO(rutaAAT);
                response.setRutaAATDTO(rutaAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_RUTA_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_RUTA_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_RUTA_AAT);
        }
        return response;
    }

    /**
     * Metodo que trae la lista de asistencia de una sesion a partir de su id
     *
     * @param requestTraerListaAAT Contiene el id de la sesión
     * @return Lista asistencia
     */
    @Override
    public ResponseTraerListaAAT getListaAAT(RequestTraerListaAAT requestTraerListaAAT) {
        ResponseTraerListaAAT response = new ResponseTraerListaAAT();
        try {
            Listaasistenciaaat listaAAT = asistenciaTecnicaDAO.getListaAATPorId(requestTraerListaAAT.getIdListaAAT());
            if (listaAAT != null) {
                ListaasistenciaaatDTO listaAATDTO = EntityToDTO.listaAATTolistaAATDTO(listaAAT);
                response.setListaAATDTO(listaAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_LISTA_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_LISTA_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_LISTA_AAT);
        }
        return response;
    }

    @Override
    public ResponseUpdateListasAAT updateListasATT(RequestUpdateListasAAT requestUpdateListasAAT) {
        ResponseUpdateListasAAT response = new ResponseUpdateListasAAT();
        List<ListaasistenciaaatDTO> listasAATDTO = requestUpdateListasAAT.getListasAATDTO();
        List<Listaasistenciaaat> listasAAT = new ArrayList();
        for (ListaasistenciaaatDTO e : listasAATDTO) {
            Listaasistenciaaat temp = dtoListaATTTOListaATT(e);
            listasAAT.add(temp);
        }
        try {

//            requestUpdateListasAAT.getListasAATDTO().stream().map((lAATDTO) -> DTOToEntity.dtoListaATTTOListaATT(lAATDTO)).forEachOrdered((listasAAT) -> {
//                try {
            asistenciaTecnicaDAO.updateListaAAT(listasAAT);
//                } catch (Exception ex) {
//                    log.writeToLogFile(ex);
//                    response.setStatus("0");
//                    response.setDescripcion(Mensajes.ERROR_UPDATE_LISTA_AAT);
//                    
//                }
//            });

            response.setDescripcion(Mensajes.EXITO_UPDATE_LISTA_AAT);
            response.setStatus("1");
            response.setAccion(Acciones.MODIFICAR_LISTA_AAT);
            response.setId(requestUpdateListasAAT.getListasAATDTO().get(0).getSesionacompanamientoat().getIdsesionacompanamientoat());
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_UPDATE_LISTA_AAT);
        }
        return response;
    }

    /**
     * Metodo que trae una lista de emprendimientos a partir de unos estados
     *
     * @param requestEmprendimientos Contiene la lista de estados
     * @return Lista de emprendimientos
     */
    @Override
    public ResponseTraerEmprendimientos getEmprendimientos(RequestTraerEmprendimientos requestEmprendimientos) {
        ResponseTraerEmprendimientos response = new ResponseTraerEmprendimientos();
        try {
            List<Emprendimiento> emprendimientos = emprendimientoDAO.getEmprendimientosPorEstado(requestEmprendimientos.getEstadosEmprendimiento());
            if (emprendimientos != null) {
                List<EmprendimientoDTO> emprendimientosDTO = new ArrayList<>();
                emprendimientos.forEach((emprendimiento) -> {
                    emprendimientosDTO.add(EntityToDTO.emprendimientoToEmprendimientoDTO(emprendimiento));
                });
                response.setEmprendimientos(emprendimientosDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_EMPRENDIMIENTOS);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_EMPRENDIMIENTOS);
        }
        return response;
    }

    /**
     * Servicio responsable de obtener un emprendimiento por su
     * idemprendimiento.
     *
     * @param requestTraerEmprendimiento Identificador del Emprendimiento
     * @return Respuesta si fue exitósa o no la búsqueda, y Emprendimiento que
     * cumpla con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerEmprendimiento getEmprendimiento(RequestTraerEmprendimiento requestTraerEmprendimiento) {
        ResponseTraerEmprendimiento response = new ResponseTraerEmprendimiento();
        try {
            Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorId(requestTraerEmprendimiento.getIdEmprendimiento());
            if (emprendimiento != null) {
                EmprendimientoDTO emprendimientoDTO = EntityToDTO.emprendimientoToEmprendimientoDTO(emprendimiento);
                response.setEmprendimientoDTO(emprendimientoDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTO_ID);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_EMPRENDIMIENTO_ID);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_EMPRENDIMIENTO_ID);
        }
        return response;
    }

    /**
     * Servicio encargados de ubicar los Temas de Acompañamiento y Asistencia
     * Técnica vinculados a un emprendimiento.
     *
     * @param requestTraerTemasRutaAAT Contiene el identificador del
     * Emprendimiento
     * @return Respuesta con los Temas Ruta de Acompañamiento y Asistencia
     * Técnica vinculados al emprendimiento.
     */
    @Override
    public ResponseTraerListaTemasRutaAAT getTemasRutaATTPorEmprendimiento(RequestTraerTemasRutaAAT requestTraerTemasRutaAAT) {
        ResponseTraerListaTemasRutaAAT response = new ResponseTraerListaTemasRutaAAT();
        try {
            List<Temasrutaacompanamientoat> temasRutaAAT = asistenciaTecnicaDAO.getTemasRutaAAT(requestTraerTemasRutaAAT.getIdEmprendimiento());
            if (temasRutaAAT != null) {
                List<TemasrutaacompanamientoatDTO> temasRutaAATDTO = new ArrayList<>();
                for (Temasrutaacompanamientoat temaRutaAAT : temasRutaAAT) {
                    TemasrutaacompanamientoatDTO temaRutaAATDTO = EntityToDTO.temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(temaRutaAAT);
                    float cantHorasEjecutadas
                            = asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(
                                    temaRutaAAT.getIdtemarutaacompanamientoat(),
                                    requestTraerTemasRutaAAT.getIdEmprendimiento());
                    temaRutaAATDTO.setCantidadHorasEjecutadas(cantHorasEjecutadas);
                    temasRutaAATDTO.add(temaRutaAATDTO);
                }
                response.setTemasRutaAATDTO(temasRutaAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_TEMAS_RUTAS_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_NO_TEMAS_RUTAS_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_NO_TEMAS_RUTAS_AAT);
        }
        return response;
    }

    /**
     * Metodo que guarda o actualiza un tema de acompañamiento
     *
     * @param requestGuardarTemaRutaAAT Contiene el tema de la ruta de
     * acompañamiento
     * @return respuesta si se creo o actualizo el tema exitosamente o no
     */
    @Override
    public ResponseGuardarTemaRutaAAT guardarTemaRutaATT(RequestGuardarTemaRutaAAT requestGuardarTemaRutaAAT) {
        ResponseGuardarTemaRutaAAT response = new ResponseGuardarTemaRutaAAT();
        try {
            Temasrutaacompanamientoat temaRutaAAT = DTOToEntity.dtoTemaAATToTemaAAT(requestGuardarTemaRutaAAT.getTemaRutaAAT());
            long resp = -1;
            if (temaRutaAAT.getIdtemarutaacompanamientoat() > 0) {
                resp = asistenciaTecnicaDAO.updateTemaRutaAAT(temaRutaAAT);
                response.setDescripcion(Mensajes.EXITO_UPDATE_TEMA_RUTA_AAT);
                response.setStatus("1");
                response.setAccion(Acciones.MODIFICAR_TEMA_AAT);
                response.setId(resp);
            } else {
                resp = asistenciaTecnicaDAO.setTemaRutaAAT(temaRutaAAT);
                response.setDescripcion(Mensajes.EXITO_REGISTRO_TEMA_RUTA_AAT);
                response.setStatus("1");
                response.setAccion(Acciones.REGISTRAR_TEMA_AAT);
                response.setId(resp);
            }
            response.setTemaRutaAATId(resp);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_GUARDAR_TEMA_RUTA_AAT);
        }
        return response;
    }

    /**
     * Servicio encargado de de consultar el avance y los documentos asociados a
     * un emprendimiento.
     *
     * @param requestConsultarAvance Datos para consultar el avance del
     * Emprendimiento
     * @return Respuesta si fue exitósa o no la consulta, e información del
     * avance correspondiente al Emprendimiento
     */
    @Override
    public ResponseConsultarAvance consultarAvanceAAT(RequestConsultarAvance requestConsultarAvance) {
        ResponseConsultarAvance response = new ResponseConsultarAvance();
        try {
            Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    requestConsultarAvance.getEstadosEmprendimiento(),
                    requestConsultarAvance.getNumeroDocumentoBen(),
                    requestConsultarAvance.getIdCajaCompensacion());
            if (emprendimiento == null) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_NOENCONTRADO);
                return response;
            }
            ConsultarAvanceComplexDTO consultaAvanceComplexDTO = new ConsultarAvanceComplexDTO();
            consultaAvanceComplexDTO.setEmprendimiento(EntityToDTO.emprendimientoToEmprendimientoDTO(emprendimiento));
            consultaAvanceComplexDTO.setPorcentajesAprobacion(new ArrayList<>());
            consultaAvanceComplexDTO.setPermiteAprobar(true);

            if (asistenciaTecnicaDAO.getDocumentos(emprendimiento.getIdemprendimiento(), BigDecimal.ONE).size() == 0) {
                consultaAvanceComplexDTO.setDocSet(false);
            } else {
                consultaAvanceComplexDTO.setDocSet(true);
            }

            List<Temasrutaacompanamientoat> temasRutaAAT = asistenciaTecnicaDAO.getTemasRutaAAT(emprendimiento.getIdemprendimiento());
            if (temasRutaAAT.size() > 0) {
                List<TemasrutaacompanamientoatDTO> temasRutaAATDTO = new ArrayList<>();
                for (Temasrutaacompanamientoat temaRutaAAT : temasRutaAAT) {
                    TemasrutaacompanamientoatDTO temaRutaAATDTO = EntityToDTO.temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(temaRutaAAT);

                    float cantHorasEjecutadas
                            = asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(
                                    temaRutaAAT.getIdtemarutaacompanamientoat(),
                                    emprendimiento.getIdemprendimiento());
                    temaRutaAATDTO.setCantidadHorasEjecutadas(cantHorasEjecutadas);
                    temasRutaAATDTO.add(temaRutaAATDTO);
                }
                consultaAvanceComplexDTO.setTemasRutasAAT(temasRutaAATDTO);
            } else {
                response.setDescripcion(Mensajes.ERROR_NO_TEMAS_RUTAS_AAT);
                response.setStatus("0");
                return response;
            }

            List<Asociados> asociados = asociadoDAO.getAsociadosPorEmprendimiento(emprendimiento.getIdemprendimiento());
            if (asociados != null) {
                List<BeneficiarioAATDTO> beneficiariosAATDTO = new ArrayList<>();
                for (Asociados asociado : asociados) {
                    AsociadosDTO asociadoDTO = EntityToDTO.asociadoToAsociadoDTO(asociado);
                    BeneficiarioDTO beneficiarioDTO = asociadoDTO.getBeneficiario();
                    BeneficiarioAATDTO beneficiarioAATDTO = new BeneficiarioAATDTO();
                    beneficiarioAATDTO.setIdbeneficiario(beneficiarioDTO.getIdbeneficiario());
                    beneficiarioAATDTO.setNombres(beneficiarioDTO.getPrimernombre() + " " + (beneficiarioDTO.getSegundonombre() != null ? beneficiarioDTO.getSegundonombre() : ""));
                    beneficiarioAATDTO.setApellidos(beneficiarioDTO.getPrimerapellido() + " " + (beneficiarioDTO.getSegundoapellido() != null ? beneficiarioDTO.getSegundoapellido() : ""));
                    beneficiarioAATDTO.setTipodocumento(beneficiarioDTO.getTipodocumentoid().getNombredocumento());
                    beneficiarioAATDTO.setNumerodocumento(beneficiarioDTO.getNumerodocumento());
                    beneficiarioAATDTO.setEmail(beneficiarioDTO.getEmail());
                    beneficiarioAATDTO.setTelefono(beneficiarioDTO.getTelefono());

                    List<Aprobacion> aprobaciones = aprobacionDAO.
                            getAprobacionesPorNumeroDocumento(beneficiarioDTO.getTipodocumentoid().getNombredocumento(),
                                    beneficiarioDTO.getNumerodocumento());
                    
                    if (aprobaciones.isEmpty()) {
                        consultaAvanceComplexDTO.setPermiteAprobar(false);
                    }

                    for (Aprobacion a : aprobaciones) {
                        if (consultaAvanceComplexDTO.isPermiteAprobar() && a.getCalificacionfinal() == 0) {
                            consultaAvanceComplexDTO.setPermiteAprobar(false);
                        }
                    }

                    List<Seguimientoasistencia> seguimiento = seguimientoasistenciaDAO.
                            getSeguimientoNumeroDocumento(
                                    beneficiarioDTO.getTipodocumentoid().getNombredocumento(),
                                    beneficiarioDTO.getNumerodocumento());
                    
                    if (seguimiento.isEmpty()) {
                        consultaAvanceComplexDTO.setPermiteAprobar(false);
                    }

                    short intensidadHoraria = 0;
                    short cantidadHorasAsistidas = 0;
                    for (Seguimientoasistencia s : seguimiento) {
                        intensidadHoraria += s.getModulociclo().getIntensidadhoraria();
                        cantidadHorasAsistidas += (s.getModulociclo().getIntensidadhoraria() >= s.getCantidadhorasasistencia() ? s.getCantidadhorasasistencia() : s.getModulociclo().getIntensidadhoraria());
                    }
                    Integer porcentaje = 0;
                    if (intensidadHoraria != 0) {
                        porcentaje = abs(cantidadHorasAsistidas * 100 / intensidadHoraria);
                    }
                    beneficiarioAATDTO.setPorcentajeAprobacion(new Short(porcentaje.toString()));

                    List<Temasrutacapacitacion> temasRutaCapacitacion = temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(beneficiarioDTO.getIdbeneficiario());
                    if (temasRutaCapacitacion == null) {
                        response.setStatus("0");
                        response.setDescripcion(Mensajes.ERROR_CONSULTAR_AVANCE);
                        return response;
                    }

                    List<TemasrutacapacitacionDTO> temasRutaCapacitacionDTO = EntityToDTO.listaTemasRutaCapacitacionToListaTemasRutaCapacitacionDTO(temasRutaCapacitacion);
                    for (TemasrutacapacitacionDTO t : temasRutaCapacitacionDTO) {
                        for (Seguimientoasistencia s : seguimiento) {
                            if (s.getModulociclo().getCapacitacionprograma().getNombrecapacitacionprograma().equals(t.getNombretema())) {
                                Integer porcentaje2 = 0;
                                if (s.getModulociclo().getIntensidadhoraria() != 0) {
                                    porcentaje2 = abs(s.getCantidadhorasasistencia() / s.getModulociclo().getIntensidadhoraria());
                                }
                                t.setPorcentajeAprobacion(new Short(porcentaje2.toString()));
                                break;
                            }
                        }
                    }
                    beneficiarioAATDTO.setTemasRutaCapacitacionDTO(temasRutaCapacitacionDTO);
                    beneficiariosAATDTO.add(beneficiarioAATDTO);
                }

                consultaAvanceComplexDTO.setBeneficiarios(beneficiariosAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO);
                response.setStatus("0");
                return response;
            }
            response.setConsultarAvanceComplexDTO(consultaAvanceComplexDTO);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CONSULTAR_AVANCE);
        }
        return response;
    }

    /**
     * Servicio encargado de obtener el estado actual de un emprendimiento.
     *
     * @param requestTraerEstadoEmprendimiento Datos del Emprendimiento
     * @return Respuesta si fue exitósa o no la búsqueda, y Estado actual del
     * Emprendimiento
     */
    @Override
    public ResponseTraerEstadoEmprendimiento getEstadoEmprendimiento(RequestTraerEstadoEmprendimiento requestTraerEstadoEmprendimiento) {
        ResponseTraerEstadoEmprendimiento response = new ResponseTraerEstadoEmprendimiento();
        try {
            Estadoemprendimiento estadoEmprendimiento = emprendimientoDAO.getEstadoEmprendimiento(requestTraerEstadoEmprendimiento.getIdestadoemprendimiento());
            if (estadoEmprendimiento != null) {
                EstadoemprendimientoDTO estadoEmprendimientoDTO = EntityToDTO.estadoEmprendimientoToEstadoEmprendimientoDTO(estadoEmprendimiento);
                response.setEstadoEmprendimientoDTO(estadoEmprendimientoDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_ESTADO_EMPRENDIMIENTO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ESTADO_EMPRENDIMIENTO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_ESTADO_EMPRENDIMIENTO);
        }
        return response;
    }

    /**
     * Metodo que trae un documento a partir de su id
     *
     * @param requestTraerDocumentoComite Contiene el id del documento
     * @return Un documento
     */
    @Override
    public ResponseTraerDocumentoComite getDocumento(RequestTraerDocumentoComite requestTraerDocumentoComite) {
        ResponseTraerDocumentoComite response = new ResponseTraerDocumentoComite();
        try {
            Documentos documento = asistenciaTecnicaDAO.getDocumento(requestTraerDocumentoComite.getIdDocumentoComite());
            if (documento != null) {
                DocumentosDTO documentoDTO = EntityToDTO.documentoToDocumentoDTO(documento);
                response.setDocumentoDTO(documentoDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_DOCUMENTO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_DOCUMENTO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_DOCUMENTO);
        }
        return response;
    }

    /**
     * Metodo que trae un tipo de documento a partir de su id
     *
     * @param requestTipoDocumento Contiene el id de tipo de documento
     * @return Un tipo de documento
     */
    @Override
    public ResponseTipoDocumento getTipoDocumento(RequestTipoDocumento requestTipoDocumento) {
        ResponseTipoDocumento response = new ResponseTipoDocumento();
        try {
            Tipodocumentos tipoDocumento = asistenciaTecnicaDAO.getTipoDocumento(requestTipoDocumento.getIdtipodocumento());
            if (tipoDocumento != null) {
                TipodocumentosDTO tipoDocumentoDTO = EntityToDTO.tipoDocumentoToTipoDocumentoDTO(tipoDocumento);
                response.setTipoDocumentosDTO(tipoDocumentoDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_TIPO_DOCUMENTO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_TIPO_DOCUMENTO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TIPO_DOCUMENTO);
        }
        return response;
    }

    /**
     * Metodo que guarda o actualiza un documento
     *
     * @param requestGuardarDocumento Contiene el documento
     * @return Respuesta si se creó o actualizó el documento exitosamente o no
     */
    @Override
    public ResponseGuardarDocumento guardarDocumento(RequestGuardarDocumento requestGuardarDocumento) {
        ResponseGuardarDocumento response = new ResponseGuardarDocumento();
        try {
            Documentos documentos = DTOToEntity.dtoDocumentosToDocumentos(requestGuardarDocumento.getDocumento());
            long resp = -1;
            if (documentos.getIddocumento() > 0) {
                resp = asistenciaTecnicaDAO.updateDocumento(documentos);
                response.setDescripcion(Mensajes.EXITO_UPDATE_DOCUMENTO);
                response.setStatus("1");
                response.setId(resp);
                response.setAccion(Acciones.MODIFICAR_DOCUMENTO);
            } else {
                resp = asistenciaTecnicaDAO.setDocumento(documentos);
                response.setDescripcion(Mensajes.EXITO_GUARDAR_DOCUMENTO);
                response.setStatus("1");
                response.setId(resp);
                response.setAccion(Acciones.REGISTRAR_DOCUMENTO);
            }
            response.setIdDocumento(resp);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_GUARDAR_DOCUMENTO);
        }
        return response;
    }

    /**
     * Metodo que trase todos los documentos de un emprendimiento a partir de un
     * id de emprendimiento y un id de tipo de documento
     *
     * @param requestTraerDocumentos Contiene el id del emprendimiento y el id
     * del tipo de documento
     * @return Lista de documentos
     */
    @Override
    public ResponseTraerDocumentos getDocumentos(RequestTraerDocumentos requestTraerDocumentos) {
        ResponseTraerDocumentos response = new ResponseTraerDocumentos();
        try {
            List<Documentos> documentos = asistenciaTecnicaDAO.getDocumentos(requestTraerDocumentos.getIdEmprendimiento(), requestTraerDocumentos.getIdTipoDocumento());
            if (documentos != null) {
                List<DocumentosDTO> documentosDTO = new ArrayList<>();
                documentos.forEach((documento) -> {
                    DocumentosDTO documentoDTO = EntityToDTO.documentoToDocumentoDTO(documento);
                    documentosDTO.add(documentoDTO);
                });
                response.setDocumentosDTO(documentosDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_DOCUMENTOS);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_DOCUMENTOS);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_DOCUMENTOS);
        }
        return response;
    }

    /**
     * Metodo que borra un documento a partir de su id
     *
     * @param request Contiene el id del documento
     * @return Respuesta si se eliminó el documento exotósamente o no
     */
    @Override
    public ResponseEliminarDocumento deleteDocumento(RequestEliminarDocumento request) {
        ResponseEliminarDocumento response = new ResponseEliminarDocumento();
        try {
            asistenciaTecnicaDAO.deleteDocumento(request.getIdDocumento());
            response.setDescripcion(Mensajes.EXITO_DELETE_DOCUMENTO);
            response.setStatus("1");
            response.setAccion(Acciones.ELIMINAR_DOCUMENTO);
            response.setId(request.getIdDocumento().longValue());
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_DELETE_DOCUMENTO);
        }
        return response;
    }

    /**
     * Servicio encargado de liberar una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param sesion Sesión a ser liberada
     * @return Respuesta si fue exitóso o no el cambio
     */
    @Override
    public ResponseDTO liberarSesiones(Sesionacompanamientoat sesion) {
        ResponseDTO response = new ResponseDTO();
        try {
            asistenciaTecnicaDAO.liberarSesiones(sesion);
            notificaBeneficiariosGenerica(11, sesion.getIdsesionacompanamientoat());
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_LIBERAR_SESIONES);
            response.setAccion(Acciones.LIBERAR_SESION_AAT);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        }
        return response;
    }

    /**
     * Notifica a los beneficiarios asociados sobre los cambios generados en las
     * sesiones.
     *
     * @param idPlantilla que se debe utilizar para enviar los email
     * @param sesion la sesión que fue modificada para extraer los
     * beneficiarios.
     */
    private void notificaBeneficiariosGenerica(long idPlantilla, long id) {
        try {
//            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
            String tipoSesion = "Sesión Acompañamiento Técnico";
            Sesionacompanamientoat sesion = asistenciaTecnicaDAO.getSesionAAT(id);
            for (Listaasistenciaaat l : sesion.getListaasistenciaaats()) {
//                String tempPlantilla = new String(plantilla.getPlantilla());
//                tempPlantilla = tempPlantilla.replace("<#nombres#>", l.getBeneficiario().getPrimernombre() + " " + (l.getBeneficiario().getSegundonombre() != null ? l.getBeneficiario().getSegundonombre() : ""));
//                tempPlantilla = tempPlantilla.replace("<#apellidos#>", l.getBeneficiario().getPrimerapellido() + " " + (l.getBeneficiario().getSegundoapellido() != null ? l.getBeneficiario().getSegundoapellido() : ""));
//                tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", sesion.getFechainicio().toString());
//                tempPlantilla = tempPlantilla.replace("<#fechaFin#>", sesion.getFechafinal().toString());
//                tempPlantilla = tempPlantilla.replace("<#tipoSesion#>", tipoSesion);
//                tempPlantilla = tempPlantilla.replace("<#ubicacionSesion#>", sesion.getUbicacion());
//                tempPlantilla = tempPlantilla.replace("<#asistentes#> ", "");
//                final String email = l.getBeneficiario().getEmail();
//                final String asunto = plantilla.getAsunto();
//                final String plantillaFinal = tempPlantilla;
////                Runnable runnable = () -> {
//                mail.enviarEmail(email, asunto, plantillaFinal);
////                };
////                new Thread(runnable).start();

                mail.setNombres(l.getBeneficiario().getPrimernombre() + " " + (l.getBeneficiario().getSegundonombre() != null ? l.getBeneficiario().getSegundonombre() : ""));
                mail.setApellidos(l.getBeneficiario().getPrimerapellido() + " " + (l.getBeneficiario().getSegundoapellido() != null ? l.getBeneficiario().getSegundoapellido() : ""));
                mail.setFechaInicio(sesion.getFechainicio().toString());
                mail.setFechaFin(sesion.getFechafinal().toString());
                mail.setTipoSesion(tipoSesion);
                mail.setUbicacionSesion(sesion.getUbicacion());
                mail.setAsistentes("");
                mail.notificarGenerica(idPlantilla, l.getBeneficiario().getEmail());
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
    }

    /**
     * Metodo que trae las sesiones de AAT apartir de un id de funcionario y
     * unos estados
     *
     * @param request Contiene la lista de estados y el id del funcionario
     * @return Lista de sesiones AAT
     */
    @Override
    public ResponseTraerSesionesAATPorFuncionario getSesionesAATAsistencia(RequestTraerSesionesAATPorFuncionario request) {
        ResponseTraerSesionesAATPorFuncionario response = new ResponseTraerSesionesAATPorFuncionario();
        try {
            List<Sesionacompanamientoat> sesionesAAT = asistenciaTecnicaDAO.getSesionesAATPorFuncionario(request.getEstadosSesion(), request.getIdFuncionario());
            if (sesionesAAT != null) {
                List<SesionacompanamientoatDTO> sesionesAATDTO = new ArrayList<>();
                Date date = new Date();
                sesionesAAT.forEach((sAAT) -> {
                    if (date.compareTo(sAAT.getFechainicio()) > 0) {
                        sesionesAATDTO.add(EntityToDTO.sesionAcompanamientoATToSesionAcompanamientoATDTO(sAAT));
                    }
                });
                response.setSesionesAATDTO(sesionesAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_SESIONES_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_SESIONES_AAT);
        }
        return response;
    }

    /**
     * Metodo que registra las asistencias a una sesión AAt determinada
     *
     * @param request Contiene la lista de asistencias
     * @return Respuesta si se actualizaron las asistencias satisfactiamente o
     * no
     */
    @Override
    public ResponseDTO registrarAsistenciaAAT(RequestGuardarSesionAAT request) {
        ResponseDTO response = new ResponseDTO();
        try {
            List<Listaasistenciaaat> listasAAT = new ArrayList();
            List<ListaasistenciaaatDTO> listasAATDTO = request.getListasAATDTO();
            for (ListaasistenciaaatDTO l : listasAATDTO) {
                Listaasistenciaaat lista = new Listaasistenciaaat();
                lista = DTOToEntity.dtoListaATTTOListaATT(l);
                listasAAT.add(lista);
            }
            List<CorreosAsistencias> correos = asistenciaTecnicaDAO.updateListaAAT(listasAAT);
            for (CorreosAsistencias c : correos) {
                enviar.setApellidos(c.getPrimerApellido() + " " + (c.getSegundoApellido() != null ? c.getSegundoApellido() : ""));
                enviar.setNombres(c.getPrimerNombre() + " " + (c.getSegundoNombre() != null ? c.getSegundoNombre() : ""));
                if (c.getValor().equals("Si")) {
                    enviar.notificarGenerica(43, c.getCorreo());
                } else {
                    enviar.notificarGenerica(44, c.getCorreo());
                }
            }
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRO_ASISTENCIA);
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA_AAT);
            response.setId(listasAAT.get(0).getSesionacompanamientoat().getIdsesionacompanamientoat());
        } catch (Exception ex) {
           
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }
}

package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestEmprendimientoPorDocEstados;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseGetEmprendimientoCompleto;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRompimientoDeFases;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.emprendimientoToEmprendimientoDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaEmprendimientoToListaEmprendimientoDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FormalizadoDTO;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;
import com.growdata.emprendimiento.persistence.DAO.AsistenciaTecnicaDAO;

import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;

import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.MunicipiosDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;

import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
//@PropertySource("classpath:parametros.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Service
public class EmprendimientoServicioImpl implements EmprendimientoServicio {

    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private AsociadoDAO asociadoDAO;
    @Autowired
    private PlantillaMailDAO plantillaMailDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private Environment env;
    @Autowired
    private MunicipiosDAO municipiosDAO;

    @Autowired
    private AsistenciaTecnicaDAO asistenciaTecnicaDAO;

    /**
     * Metodo que trae una lista de emprendimientos a partir de un nombre
     *
     * @param request Contiene el nombre a buscar, el id de la caja de
     * compensación, y los estados del emprendimiento a buscar
     * @return Una lista de emprendimientos
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombre(RequestTraerEmprendimientoPorNombre request) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        List<Emprendimiento> emprendimientos = new ArrayList();
        if (!"".equals(request.getNombreEmprendimiento())) {
            try {
                emprendimientos = emprendimientoDAO.getEmprendimientoPorNombre(request.getNombreEmprendimiento(), request.getEstados(), request.getIdcajacompensacion());
                if (emprendimientos.size() > 0) {
                    List<EmprendimientoDTO> emprendimientosDTO = listaEmprendimientoToListaEmprendimientoDTO(emprendimientos);
                    response.setEmprendimientos(emprendimientosDTO);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
                } else {
                    response.setStatus("0");
                    response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_INEXISTENTE);
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
        } else {
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Servicio para registrar un emprendimiento formalizado.
     *
     * @param request Datos del Emprendimiento Formalizado
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO guardarFormalizado(RequestRegistrarFormalizado request) {
        ResponseDTO response = new ResponseTraerEmprendimientoPorNombre();
        if (!request.checkNullsEmprendimiento() || !request.checkNullsFormalizado()) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
        }
        try {
            long idEmp = emprendimientoDAO.guardarFormalizado(request.getIdFuncionario(), request.getIdcajacompensacion(),
                    request.getNombreEmpresa(), request.getNit(), request.getnRegistroMercantil(),
                    request.getNombreRepresentante(), request.getNombreEmprendimiento(),
                    request.getDireccion(), request.getTelefono(), request.getEmail(),
                    request.getWeb(), request.getConstitucion(), request.getSector(),
                    request.gettEmprendimiento(), request.getPaisesComercializa(),
                    request.getBeneficiarios(), request.getNegInternet(), request.getProdServ(),
                    request.getFechaRenov(), request.getFechaInicio(), request.getActividad(),
                    request.getEmpDirectos(), request.getEmpIndirectos(),
                    Integer.parseInt(env.getProperty("tiempo.espera.nuevo.emprendimiento")),
                    request.getIdmunicipio());
            for (String id : request.getBeneficiarios()) {
                Beneficiario b = beneficiarioDAO.getBeneficiarioPorId(Long.valueOf(id));
//                PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(9);
//                String msg = plantilla.getPlantilla();
//                msg = msg.replace("<#nombres#>", b.getPrimernombre() + " "
//                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
//                msg = msg.replace("<#apellidos#>", b.getPrimerapellido() + " "
//                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
//                msg = msg.replace("<#nombreEmpresa#>", request.getNombreEmpresa());
//                msg = msg.replace("<#NIT#>", request.getNit());
//                msg = msg.replace("<#registroMercantil#>", request.getnRegistroMercantil());
//                msg = msg.replace("<#nombreRepresentante#>", request.getNombreRepresentante());
//                msg = msg.replace("<#nombreEmprendimiento#>", request.getNombreEmprendimiento());
//                final String email = b.getEmail();
//                final String asunto = plantilla.getAsunto();
//                final String plantillaFinal = msg;
//                Runnable runnable = () -> {
//                    mail.enviarEmail(email, asunto, plantillaFinal);
//                };
//                new Thread(runnable).start();
//                mail.enviarEmail(email, asunto, plantillaFinal);

                mail.setNombres(b.getPrimernombre() + " "
                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
                mail.setApellidos(b.getPrimerapellido() + " "
                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
                mail.setNombreEmpresa(request.getNombreEmpresa());
                mail.setNit(request.getNit());
                mail.setRegistroMercantil(request.getnRegistroMercantil());
                mail.setNombreRepresentante(request.getNombreRepresentante());
                mail.setNombreEmprendimiento(request.getNombreEmprendimiento());
                mail.notificarGenerica(9, b.getEmail());
            }
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CREAR_EMPRENDIMIENTO);
            response.setAccion(Acciones.REGISTRAR_EMPRENDIMIENTO);
            response.setId(idEmp);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EL BENEFICIARIO DEBE ESPERAR 3 MESES DESDE QUE AGENDO SU ULTIMO EMPRENDIMIENTO":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO);
                    break;
                case "Beneficiario no presenta asistencia en sesión de sensibilización recientemente.":
                    response.setDescripcion(Mensajes.ERROR_NO_SENSIBILIZACION);
                    break;
                case "Beneficiario no presenta asistencia en sesión de valoración recientemente.":
                    response.setDescripcion(Mensajes.ERROR_NO_VALORACION);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_CREAR_EMPRENDIMIENTO);
            }
        }

        return response;
    }

    /**
     * Servicio para registrar un emprendimiento no establecido.
     *
     * @param request Datos del emprendimiento No Establecido
     * @return Respuesta si fue satisfactorio el proceso.
     */
    @Override
    public ResponseDTO guardarNoEstablecido(RequestNoEstablecido request) {
        ResponseDTO response = new ResponseTraerEmprendimientoPorNombre();
        if (!request.checkNullsEmprendimiento() || !request.checkNullsNoEstablecido()) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
        }
        try {
            long idEmp = emprendimientoDAO.guardarNoEstablecido(request.getIdFuncionario(),
                    request.getIdcajacompensacion(), request.getNombreEmprendimiento(),
                    request.gettEmprendimiento(), request.getConstitucion(), request.getSector(),
                    request.getBeneficiarios(), request.getProdServ(),
                    request.getCuandoInicia(), request.getObservaciones(),
                    Integer.parseInt(env.getProperty("tiempo.espera.nuevo.emprendimiento")));
            for (String id : request.getBeneficiarios()) {
                Beneficiario b = beneficiarioDAO.getBeneficiarioPorId(Long.valueOf(id));
////                EnviarEmail mail = new EnviarEmail();
//                PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(34);
//                String msg = plantilla.getPlantilla();
//                msg = msg.replace("<#nombres#>", b.getPrimernombre() + " "
//                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
//                msg = msg.replace("<#apellidos#>", b.getPrimerapellido() + " "
//                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
//                msg = msg.replace("<#nombreEmprendimiento#>", request.getNombreEmprendimiento());
//                mail.enviarEmail(b.getEmail(), plantilla.getAsunto(), msg);
                mail.setNombres(b.getPrimernombre() + " "
                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
                mail.setApellidos(b.getPrimerapellido() + " "
                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
                mail.setNombreEmprendimiento(request.getNombreEmprendimiento());
                mail.notificarGenerica(34, b.getEmail());
            }
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CREAR_EMPRENDIMIENTO);
            response.setAccion(Acciones.REGISTRAR_EMPRENDIMIENTO);
            response.setId(idEmp);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EL BENEFICIARIO DEBE ESPERAR 3 MESES DESDE QUE AGENDO SU ULTIMO EMPRENDIMIENTO":
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO);
                    break;
                case "Beneficiario no presenta asistencia en sesión de sensibilización recientemente.":
                    response.setDescripcion(Mensajes.ERROR_NO_SENSIBILIZACION);
                    break;
                case "Beneficiario no presenta asistencia en sesión de valoración recientemente.":
                    response.setDescripcion(Mensajes.ERROR_NO_VALORACION);
                    break;
                default:
                    if (ex.getCause() != null) {
                        log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                    } else {
                        log.writeToLogFile(ex);
                    }
                    response.setDescripcion(Mensajes.ERROR_CREAR_EMPRENDIMIENTO);
            }
        }

        return response;
    }

    /**
     * Servicio que busca emprendimientos que cumplan con los criterios de
     * búsqueda.
     *
     * @param request Contiene el número de documento, caja de compensación y
     * estados, parámetros con los que debe coincidir los emprendimientos a
     * buscar.
     * @return Respuestá si fue exitósa o no la búsqueda, y Lista de
     * Emprendimientos que cumplen con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDoc(RequestEmprendimientoPorDocEstados request) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        Emprendimiento emprendimiento = new Emprendimiento();
        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO();
        List<EmprendimientoDTO> emprendimientos = new ArrayList();
        List<Beneficiario> beneficiarios = new ArrayList();
        if (!"".equals(request.getDoc())) {
            try {
                beneficiarios = beneficiarioDAO.getBeneficiarios(null, request.getDoc(), null, null, null, null);
                if (beneficiarios.size() > 0) {
                    Asociados asociado = asociadoDAO.getAsociadoXId(beneficiarios.get(0).getIdbeneficiario());
                    if (asociado != null) {
                        emprendimiento = emprendimientoDAO.getEmprendimientoXIdYEstado(
                                asociado.getEmprendimiento().getIdemprendimiento(),
                                request.getEstados(), request.getIdcajacompensacion());

                        emprendimientoDTO = EntityToDTO.emprendimientoToEmprendimientoDTO(emprendimiento);
                        for (FormalizadoDTO f : emprendimientoDTO.getFormalizados()) {
                            f.setMunicipio(EntityToDTO.municipiosToMunicipiosDTO(
                                    municipiosDAO.getMunicipioPorId(new BigDecimal(f.getMunicipios()))));
                        }
                        emprendimientos.add(emprendimientoDTO);

                        response.setEmprendimientos(emprendimientos);
                        response.setStatus("1");
                        response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_ASOCIADO);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE2);
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

        } else {
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Servicio encargado de actualizar el estado de un emprendimiento.
     *
     * @param requestActualizarEmprendimiento Datos del Emprendimiento
     * @return Respuesta si fue exitoso o no el cambio.
     */
    @Override
    public ResponseActualizarEmprendimiento updateEmprendimiento(RequestActualizarEmprendimiento requestActualizarEmprendimiento) {
        ResponseActualizarEmprendimiento response = new ResponseActualizarEmprendimiento();
        try {
            emprendimientoDAO.updateEmprendimiento(
                    requestActualizarEmprendimiento.getEmprendimiento().getIdemprendimiento(),
                    DTOToEntity.dtoEstadoEmprendimientoToEstadoEmprendimiento(
                            requestActualizarEmprendimiento.getEmprendimiento().getEstadoemprendimiento()));
            notificaBeneficiarios(12, requestActualizarEmprendimiento.getBeneficiarios(), requestActualizarEmprendimiento.getEmprendimiento().getNombreemprendimiento());
            response.setDescripcion(Mensajes.EXITO_UPDATE_EMPRENDIMIENTO);
            response.setStatus("1");
            response.setAccion(Acciones.MODIFICAR_EMPRENDIMIENTO);
            response.setId(requestActualizarEmprendimiento.getEmprendimiento().getIdemprendimiento());
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_UPDATE_EMPRENDIMIENTO);
        }
        return response;
    }

    /**
     * Servicio encargado de ubicar los emprendimientos que cumplam con los
     * criterios de búsqueda.
     *
     * @param request Contiene los estados en los que puede estar el
     * emprendimiento y la caja de compensación a la que debe estar vinculado.
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de
     * Emprendimientos que cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorEdo(RequestEmprendimientoPorDocEstados request) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        List<EmprendimientoDTO> dto = new ArrayList<>();
        try {
            for (Emprendimiento e : emprendimientoDAO.getEmprendimientosPorEdo(request.getEstados(), request.getIdcajacompensacion())) {
                dto.add(EntityToDTO.emprendimientoToEmprendimientoDTOpocosDatos(e));
            }

            response.setEmprendimientos(dto);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
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

    private void notificaBeneficiarios(long idPlantilla, List<BeneficiarioAATDTO> beneficiarios, String nombreEmprendimiento) {
//        EnviarEmail mail = new EnviarEmail();
        try {
//            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
            for (BeneficiarioAATDTO beneficiario : beneficiarios) {
//            beneficiarios.forEach((beneficiario) -> {
//                String tempPlantilla = plantilla.getPlantilla();
//                tempPlantilla = tempPlantilla.replace("<#nombres#>", beneficiario.getNombres());
//                tempPlantilla = tempPlantilla.replace("<#apellidos#>", beneficiario.getApellidos());
//                tempPlantilla = tempPlantilla.replace("<#nombreEmprendimiento#>", nombreEmprendimiento);
//                mail.enviarEmail(beneficiario.getEmail(), plantilla.getAsunto(), tempPlantilla);

                mail.setNombres(beneficiario.getNombres());
                mail.setApellidos(beneficiario.getApellidos());
                mail.setNombreEmprendimiento(nombreEmprendimiento);
                mail.notificarGenerica(idPlantilla, beneficiario.getEmail());
            }
//            });
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
        }
    }

    /**
     * Metodo que trae un emprendimiento a partir de su id
     *
     * @param request Contiene el id del emprendimiento y los estados del
     * emprendimiento
     * @return Un emprendimiento
     */
    @Override
    public ResponseTraerEmprendimientoPorId getEmprendimientoPorId(RequestTraerEmprendimientoPorId request) {
        ResponseTraerEmprendimientoPorId response = new ResponseTraerEmprendimientoPorId();
        Emprendimiento emprendimiento = new Emprendimiento();

        try {
            emprendimiento = emprendimientoDAO.getEmprendimientoXIdYEstado(request.getIdEmprendimiento(), request.getEstados(), null);
            if (emprendimiento != null) {
                EmprendimientoDTO emprendimientoDTO = emprendimientoToEmprendimientoDTO(emprendimiento);
                response.setEmprendimiento(emprendimientoDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_INEXISTENTE);
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
     * Servicio encargado de ubica el emprendimiento que cumpla con los
     * criterios de búsqueda.
     *
     * @param idSesionComite Id de la Sesión Comité
     * @param estadoEmprendimiento Estado en los que deben estar los
     * Emprendimeintos
     * @param idcajacompensacion Identificador de la cada de compensación a los
     * que deben estar vuinculados los emprendimientos
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Emprendimeintos que cumplan con la búsqueda.
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComite(long idSesionComite,
            int estadoEmprendimiento, BigDecimal idcajacompensacion) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        List<EmprendimientoDTO> dto = new ArrayList<>();
        try {
            for (Emprendimiento e : emprendimientoDAO.getEmprendimientosComite(idSesionComite,
                    estadoEmprendimiento, idcajacompensacion)) {
                dto.add(EntityToDTO.emprendimientoToEmprendimientoDTO(e));
            }

            response.setEmprendimientos(dto);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
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
     * Servicio responsable de ubicar los emprendimientos vinculados a una
     * Sesión Comité.
     *
     * @param idSesionComite Identificador de la Sesión Comité
     * @param estadoEmprendimiento Estado en el que debe estar el
     * emprendimientoi
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de
     * Emprendimientos que cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComitePorIdSesion(long idSesionComite, int estadoEmprendimiento) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        List<EmprendimientoDTO> dto = new ArrayList<>();
        try {
            for (Emprendimiento e : emprendimientoDAO.getEmprendimientosComitePorIdSesion(idSesionComite)) {
                dto.add(EntityToDTO.emprendimientoToEmprendimientoDTO(e));
            }

            response.setEmprendimientos(dto);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
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
     * Metodo que trae un emprendimiento junto con sus temas de evaluación y
     * documentos, a partir de un id de emprendimiento
     *
     * @param request Contiene el id del emprendimiento
     * @return Un emprendimiento junto con sus temas de evaluación y documentos
     */
    @Override
    public ResponseGetEmprendimientoCompleto getEmprendimientoCompleto(RequestTraerEmprendimientoPorId request) {
        ResponseGetEmprendimientoCompleto response = new ResponseGetEmprendimientoCompleto();
        EmprendimientoDTO dto = new EmprendimientoDTO();
        Emprendimiento e = new Emprendimiento();
        try {
            e = emprendimientoDAO.getEmprendimientoPorId(request.getIdEmprendimiento());
            dto = EntityToDTO.emprendimientoToEmprendimientoDTO(e);

            response.setEmprendimiento(dto);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);

            //traigo los temas
            List<Temasrutaacompanamientoat> temasRutaAAT = asistenciaTecnicaDAO.getTemasRutaAAT(e.getIdemprendimiento());
            if (temasRutaAAT != null) {
                List<TemasrutaacompanamientoatDTO> temasRutaAATDTO = new ArrayList<>();
                for (Temasrutaacompanamientoat temaRutaAAT : temasRutaAAT) {
//                temasRutaAAT.forEach((temaRutaAAT) -> {
                    TemasrutaacompanamientoatDTO temaRutaAATDTO = EntityToDTO.temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(temaRutaAAT);
                    float cantHorasEjecutadas
                            = asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(
                                    temaRutaAAT.getIdtemarutaacompanamientoat(),
                                    request.getIdEmprendimiento());
                    temaRutaAATDTO.setCantidadHorasEjecutadas(cantHorasEjecutadas);
                    temasRutaAATDTO.add(temaRutaAATDTO);
                }
                response.setTemasRutasAAT(temasRutaAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_TEMAS_RUTAS_AAT);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_NO_TEMAS_RUTAS_AAT);
                response.setStatus("0");
            }
            //traigo los documentos de el emprendimiento con estado 1(evaluacion)
            List<Documentos> documentos = asistenciaTecnicaDAO.getDocumentos(e.getIdemprendimiento(), BigDecimal.ONE);
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
     * Metodo que trae un emprendimiento a partir de un documento de un
     * beneficiario
     *
     * @param request Contiene el documento del beneficiario, el id de la caja
     * de compensación y los estados
     * @return Una lista de Emprendimientos
     */
    @Override
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDoc2(RequestEmprendimientoPorDocEstados request) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        Emprendimiento emprendimiento = new Emprendimiento();
        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO();
        List<EmprendimientoDTO> emprendimientos = new ArrayList();
        List<Beneficiario> beneficiarios = new ArrayList();
        if (!"".equals(request.getDoc())) {
            try {
                beneficiarios = beneficiarioDAO.getBeneficiarios(null, request.getDoc(), null, null, null, null);
                if (beneficiarios.size() > 0) {
                    Asociados asociado = asociadoDAO.getAsociadoXId(beneficiarios.get(0).getIdbeneficiario());
                    if (asociado != null) {
                        emprendimiento = emprendimientoDAO.getEmprendimientoXIdYEstado2(
                                asociado.getEmprendimiento().getIdemprendimiento(),
                                request.getEstados(), request.getIdcajacompensacion());

                        emprendimientoDTO = EntityToDTO.emprendimientoToEmprendimientoDTO(emprendimiento);
                        emprendimientos.add(emprendimientoDTO);

                        response.setEmprendimientos(emprendimientos);
                        response.setStatus("1");
                        response.setDescripcion(Mensajes.EXITO_CARGA_EMPRENDIMIENTOS);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_ASOCIADO);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE2);
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

        } else {
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método encargado de actualizar el estado de un emprendimiento
     *
     * @param request Contiene el id del emprendimiento y el estado ha
     * actualizar
     * @return Respuesta si se actualizó el emprendimiento exitosamente o no
     */
    @Override
    public ResponseDTO rompimientoDeFases(RequestRompimientoDeFases request) {
        ResponseDTO response = new ResponseDTO();
        Estadoemprendimiento estado = new Estadoemprendimiento();
        estado.setIdestadoemprendimiento(request.getIdEstadoASaltar());
        try {
            emprendimientoDAO.updateEmprendimiento(request.getIdEmprendimiento(), estado);
            Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorId(request.getIdEmprendimiento());
            List<Asociados> asociados = asociadoDAO.getAsociadosPorEmprendimiento2(request.getIdEmprendimiento());
            mail.setNombreEmprendimiento(emprendimiento.getNombreemprendimiento());
            mail.setNombreEstadoEmprendimiento(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento());
            for (Asociados a : asociados) {
                mail.setNombres(a.getBeneficiario().getPrimernombre() + " " + (a.getBeneficiario().getSegundonombre() != null ? a.getBeneficiario().getSegundonombre() : ""));
                mail.setApellidos(a.getBeneficiario().getPrimerapellido() + " " + (a.getBeneficiario().getSegundoapellido() != null ? a.getBeneficiario().getSegundoapellido() : ""));
                mail.notificarGenerica(40, a.getBeneficiario().getEmail());
            }
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ROMPIMIENTO_FASES);
            response.setAccion(Acciones.SALTAR_FASE);
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_ROMPIMIENTO_FASES);
        }

        return response;
    }

}

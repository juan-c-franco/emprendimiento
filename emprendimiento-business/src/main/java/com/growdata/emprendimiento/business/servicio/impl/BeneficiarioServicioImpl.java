/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.AsistenciaTecnicaComplexDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.EmprendimientoAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRequisitos;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseBeneficiario;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetBeneficiarioXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetBeneficiarioXId;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listDatosBasicosToListBeneficiarioDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.persistence.DAO.AsistenciaTecnicaDAO;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.TipoDocumentoDAO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Users;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.regex.Pattern;
import javax.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.beneficiarioToBeneficiarioDto;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class BeneficiarioServicioImpl implements BeneficiarioServicio {

    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private TipoDocumentoDAO tipoDAO;
    @Autowired
    private AsistenciaTecnicaDAO asistenciaTecnicaDAO;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private EnviarEmail enviar;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private FuncionarioDAO funcionarioDAO;

    private String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
            + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
    private String asunto = "Olvidó contraseña";
    private Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);

    /**
     * Metodo que busca a un beneficiario por su correo y luego le envia un
     * correo de recuperación de contraseña
     *
     * @param correo EMail
     * @return Respuesta si se envio el correo o no
     */
    @Override
    @Transactional
    public ResponseDTO enviarCorreoRecuperacion(String correo) {
        ResponseDTO response = new ResponseDTO();
        try {
            Users user = usersDAO.getUserPorCorreo(correo);
            if (user != null) {
                BigDecimal id = user.getIduser();
                Timestamp tiempo = new Timestamp(System.currentTimeMillis());
                String cuerpo;
                enviar.setFechaCaducidad(tiempo.toString());
                enviar.setIduser(id.toString());
                enviar.notificarGenerica(20, correo);
                response.setDescripcion(
                        Mensajes.EXITO_ENVIO_CORREO_RECUPERACION);
                response.setStatus("1");
            } else {
                response.setStatus("0");
                response.setDescripcion(
                        Mensajes.ERROR_ENVIO_CORREO_RECUPERACION);
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Servicio responsable de conseguir un beneficiario dado su número de
     * documento en la base de datos de SIM-PC.
     *
     * @param request Contiene el Número de Documento de los beneficiarios a
     * buscar.
     * @return Respuesta si fue exitóso o no la búsqueda y los beneficiarios que
     * cumplen con los criterios de búsqueda.
     */
    @Override
    @Transactional
    public ResponseFindBeneficiarioXDoc consultaBenfeficiario(RequestFindBeneficiarioXDoc request) {
        ResponseFindBeneficiarioXDoc response = new ResponseFindBeneficiarioXDoc();
        List<MdFDatosBasicos> beneficiarios = new ArrayList();
        if (!"".equals(request.getDoc())) {
            try {
                beneficiarios = beneficiarioDAO.consultaBeneficiario(request.getDoc());
                if (!beneficiarios.isEmpty()) {
                    List<BeneficiarioDTO> beneficiariosDTO = listDatosBasicosToListBeneficiarioDTO(beneficiarios);
                    response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                    response.setStatus("1");
                    response.setBeneficiariosDTO(beneficiariosDTO);

                } else {
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE2);
                    response.setStatus("0");
                }

            } catch (Exception ex) {
                log.writeToLogFile(ex);
                response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO2);
                response.setStatus("0");
            }
        } else {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
        }
        return response;
    }

    /**
     * Servicio encargado de registrar los datos de un beneficiario en la base
     * de datos de emprendimiento.
     *
     * @param request Datos del Beneficiario a ser registrado.
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    @Transactional
    public ResponseBeneficiario guardarBeneficiario(RequestRegBeneficiario request) {
        Beneficiario bene = null;
        ResponseBeneficiario response = new ResponseBeneficiario();
        Tipodocumentoid tipo = new Tipodocumentoid();
        try {
            if (enviar.validarEmail(request.getBeneficiario().getEmail())) {
                tipo = tipoDAO.getTipoDocumentoIdPorNombre(request.getTipoDocumento());
                if (tipo != null) {
                    request.getBeneficiario().setTipodocumentoid(tipo);
                    Funcionario verificacion = funcionarioDAO.getFuncionarioPorCorreo(request.getBeneficiario().getEmail());
                    if (verificacion == null) {
                        bene = beneficiarioDAO.guardarBeneficiario(request.getBeneficiario());
                    } else {
                        response.setStatus("0");
                        response.setDescripcion(Mensajes.ERROR_ES_FUNCIONARIO);
                        return response;
                    }
                } else {
                    response.setStatus("0");
                    response.setDescripcion(Mensajes.ERROR_TIPO_DOCUMENTO_INVALIDO);
                    return response;
                }
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_CORREO_INVALIDO);
                return response;

            }
        } catch (ConstraintViolationException e) {
            response.setStatus("2");
            response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_YAEXISTE);
            return response;
        } catch (PersistenceException e) {
            response.setStatus("2");
            response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_YAEXISTE);
            return response;
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_REGISTRO_BENEFICIARIO);
            return response;
        }
        response.setBeneficiario(EntityToDTO.beneficiarioToBeneficiarioDto(bene));
        response.setStatus("1");
        response.setDescripcion(Mensajes.EXITO_REGISTRO_BENEFICIARIO);
        response.setId(bene.getIdbeneficiario());
        response.setAccion(Acciones.REGISTRAR_BENEFICIARIO);
        return response;
    }

    @Override
    public BeneficiarioDTO traerBeneficiario(String numDoc) {
        try {
            return EntityToDTO.beneficiarioToBeneficiarioDto(beneficiarioDAO.traerBeneficiario(numDoc));
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }

    @Override
    public Beneficiario getBeneficiario(long saveIdBeneficiario) {
        try {
            return beneficiarioDAO.getBeneficiario(saveIdBeneficiario);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }

    @Override
    public boolean validaBeneficiario(String doc, String email) {
        try {
            return beneficiarioDAO.validaBeneficiario(doc, email);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return false;
    }

    /**
     * Controlador encargado de consultar un Beneficiario y sus Emprendimientos
     * por Número de Documento.
     *
     * @param request Datos del Beneficiario
     * @return Datos del Emprendimiento
     */
    @Override
    public ResponseTraerBeneEmprTemasPorDocBeneficiario getBeneEmprTemasPorDocBeneficiario(RequestTraerBeneEmprTemasPorDocBeneficiario request) {
        ResponseTraerBeneEmprTemasPorDocBeneficiario response = new ResponseTraerBeneEmprTemasPorDocBeneficiario();
        try {
            Object[] beneEmprObj = beneficiarioDAO.getBeneEmprPorDocBeneficiario(request.getEstadosEmprendimiento(), request.getNumeroDocumentoBen());
            if (beneEmprObj != null) {
                AsistenciaTecnicaComplexDTO asistenciaTecnicaComplex = new AsistenciaTecnicaComplexDTO();
                BeneficiarioAATDTO beneficiarioAATDTO = new BeneficiarioAATDTO();
                beneficiarioAATDTO.setIdbeneficiario(new BigDecimal(beneEmprObj[0].toString()).longValue());
                beneficiarioAATDTO.setTipodocumento(beneEmprObj[1].toString());
                beneficiarioAATDTO.setNumerodocumento(beneEmprObj[2].toString());
                beneficiarioAATDTO.setNombres(beneEmprObj[3].toString());
                beneficiarioAATDTO.setApellidos(beneEmprObj[4].toString());
                beneficiarioAATDTO.setEmail(beneEmprObj[5].toString());
                beneficiarioAATDTO.setTelefono(new Long(beneEmprObj[6].toString()));
                beneficiarioAATDTO.setFecharegistro(beneEmprObj[7].toString());
                asistenciaTecnicaComplex.setBeneficiarioAAT(beneficiarioAATDTO);
                EmprendimientoAATDTO emprendimientoAATDTO = new EmprendimientoAATDTO();
                emprendimientoAATDTO.setIdemprendimiento(new BigDecimal(beneEmprObj[8].toString()).longValue());
                emprendimientoAATDTO.setTipoemprendimiento(beneEmprObj[9].toString());
                emprendimientoAATDTO.setEstadoemprendimiento(beneEmprObj[10].toString());
                emprendimientoAATDTO.setNombreemprendimiento(beneEmprObj[11].toString());
                emprendimientoAATDTO.setFecharegistro(beneEmprObj[12].toString());
                asistenciaTecnicaComplex.setEmprendimientoAAT(emprendimientoAATDTO);
                List<Temasrutaacompanamientoat> temasRutaAAT = beneficiarioDAO.getTemasRutaAATPorDocBeneficiario(request.getEstadosEmprendimiento(), request.getNumeroDocumentoBen());
                if (temasRutaAAT != null && temasRutaAAT.size() > 0) {
                    List<TemasrutaacompanamientoatDTO> temasRutaAATDTO = new ArrayList<>();
                    for (Temasrutaacompanamientoat temaRutaAAT : temasRutaAAT) {
                        TemasrutaacompanamientoatDTO temaRutaAATDTO = EntityToDTO.temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(temaRutaAAT);
                        float cantHorasEjecutadas
                                = asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(
                                        temaRutaAAT.getIdtemarutaacompanamientoat(),
                                        emprendimientoAATDTO.getIdemprendimiento());
                        temaRutaAATDTO.setCantidadHorasEjecutadas(cantHorasEjecutadas);
                        temasRutaAATDTO.add(temaRutaAATDTO);
                    }
                    asistenciaTecnicaComplex.setTemasRutasAAT(temasRutaAATDTO);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CARGA_TEMAS_RUTAS_AAT);
                } else {
                    response.setDescripcion(Mensajes.ERROR_NO_TEMAS_RUTAS_AAT);
                    response.setStatus("0");
                }
                response.setAsistenciaTecnicaComplex(asistenciaTecnicaComplex);
                response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO_EMPRENDIMIENTO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO_EMPRENDIMIENTO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO_EMPRENDIMIENTO);
        }
        return response;
    }

    /**
     * Servicio responsable de conseguir un beneficiario dado sus nombres y
     * apellidos en la base de datos de SIM-PC
     *
     * @param request Nombre y Apellido del Beneficiario
     * @return Respuesta si fue exitósa o no la búsqueda, y Beneficiarios que
     * cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarioPorNombreYApellido(RequestGetBeneficiarioXNombreYApellido request) {
        ResponseGetBeneficiarioXNombreYApellido response = new ResponseGetBeneficiarioXNombreYApellido();
        if (!"".equals(request.getpApellido()) && !"".equals(request.getpNombre())) {
            try {

                List<MdFDatosBasicos> beneficiarios = beneficiarioDAO.getBeneficiarioPorNombreYApellido(
                        request.getpNombre(), request.getsNombre(),
                        request.getpApellido(), request.getsApellido());
                if (!beneficiarios.isEmpty()) {
                    List<BeneficiarioDTO> beneficiariosDTO = listDatosBasicosToListBeneficiarioDTO(beneficiarios);
                    response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                    response.setStatus("1");
                    response.setBeneficiariosDTO(beneficiariosDTO);

                } else {
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE);
                    response.setStatus("0");
                }
            } catch (Exception ex) {
                log.writeToLogFile(ex);
                response.setStatus("0");
                response.setDescripcion(ex.getMessage());
            }
        } else {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
        }

        return response;
    }

    /**
     * Servicio responsable de conseguir un beneficiario dado su idbeneficiario
     * en la base de datos de SIM-PC.
     *
     * @param request Nombre y Apellido del Beneficiario
     * @return Respuesta si fue exitósa o no la búsqueda, y Beneficiarios que
     * cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponseGetBeneficiarioXId getBeneficiarioXId(RequestGetBeneficiarioXId request) {
        ResponseGetBeneficiarioXId response = new ResponseGetBeneficiarioXId();
        Beneficiario bene = new Beneficiario();
        BeneficiarioDTO beneDTO = new BeneficiarioDTO();
        if (!"".equals(request.getIdBeneficiario())) {
            try {
                bene = beneficiarioDAO.getBeneficiarioXId(request.getIdBeneficiario());
                if (bene != null) {
                    beneDTO = beneficiarioToBeneficiarioDto(bene);
                    response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                    response.setStatus("1");
                    response.setBeneficiario(beneDTO);

                } else {
                    response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE3);
                    response.setStatus("0");
                }

            } catch (Exception ex) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        } else {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
        }

        return response;
    }

    /**
     * Servicio encargado de ubicar un beneficiario por su correo electrónico.
     *
     * @param correo Correo por el cual se desea ubicar al Beneficiario
     * @return Respuesta si fue exitósa o no la busqueda y el Beneficiario
     * conseguido.
     */
    @Override
    public ResponseGetBeneficiarioXId getBeneficiarioPorCorreo(String correo) {
        ResponseGetBeneficiarioXId response = new ResponseGetBeneficiarioXId();
        try {
            Beneficiario b = beneficiarioDAO.getBeneficiario(correo);
            if (b == null) {
                throw new Exception();
            }
            response.setBeneficiario(EntityToDTO.beneficiarioToBeneficiarioDto(b));
            response.setStatus("1");
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE_CORREO);
            log.writeToLogFile(ex);
        }
        return response;
    }

    /**
     * Busca todos los beneficiarios que cumplan con la condicion de los
     * parametros not null enviados.
     *
     * @param idbeneficiario (opcional) Identificador del Beneficiario
     * @param doc (opcional) Número de Documento del Beneficiario
     * @param pNombre (opcional) Primer nombre del Beneficiario
     * @param sNombre (opcional) Segundo nombre del Beneficiario
     * @param pApellido (opcional) Primer apellido del Beneficiario
     * @param sApellido (opcional) Segundo apellido del Beneficiario
     * @return Retorna una lista con los beneficiarios
     */
    @Override
    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarios(
            Long idbeneficiario,
            String doc,
            String pNombre,
            String sNombre,
            String pApellido,
            String sApellido) {
        ResponseGetBeneficiarioXNombreYApellido response
                = new ResponseGetBeneficiarioXNombreYApellido();

        try {
            List<BeneficiarioDTO> lBeneficiarioDTO = new ArrayList<>();
            List<Beneficiario> lBneficiarios = beneficiarioDAO.getBeneficiarios(
                    idbeneficiario, doc, pNombre, sNombre, pApellido, sApellido);

            for (Beneficiario b : lBneficiarios) {
                lBeneficiarioDTO.add(EntityToDTO.beneficiarioToBeneficiarioDto(b));
            }
            response.setBeneficiariosDTO(lBeneficiarioDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO);

        }
        return response;
    }

    /**
     * Metodo que trae a un beneficiario a partir de su Username
     *
     * @param requestTraerBeneficiarioPorUserName Contiene el username y el
     * estado del usuario
     * @return Un Beneficiario
     */
    @Override
    public ResponseTraerBeneficiarioPorUserName getBeneficiario(RequestTraerBeneficiarioPorUserName requestTraerBeneficiarioPorUserName) {
        ResponseTraerBeneficiarioPorUserName response = new ResponseTraerBeneficiarioPorUserName();
        try {
            Beneficiario beneficiario = beneficiarioDAO.getBeneficiario(requestTraerBeneficiarioPorUserName.getEstadoUsuario(), requestTraerBeneficiarioPorUserName.getUserName());
            if (beneficiario != null) {
                BeneficiarioDTO beneficiarioDTO = EntityToDTO.beneficiarioToBeneficiarioDto(beneficiario);
                response.setBeneficiario(beneficiarioDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                response.setStatus("1");

            } else {
                response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_BENEFICIARIO_INEXISTENTE);
        }
        return response;
    }

    /**
     * Servicio responsable de consultar el estado de un determinado
     * beneficiario frente a las validaciones configuradas.
     *
     * @param beneficiario Datos del Beneficiario.
     * @param validaciones Configuración de Validaciones.
     * @return Respuesta si fue satisfactoria o no la consulta, y el resultado
     * de la misma.
     */
    @Override
    public ResponseRequisitos verificarRequisitos(MdFDatosBasicos beneficiario, RequestConfiguraciones validaciones) {
        ResponseRequisitos response = new ResponseRequisitos();
        String siCumple = beneficiarioDAO.SI_CUMPLE;
        String validacionInactiva = beneficiarioDAO.VALIDACION_INACTIVA;
        try {
            List<String> verificaciones = beneficiarioDAO.verificarRequisitos(
                    beneficiario, validaciones.getConfiguraciones());
            response.setSimpc(verificaciones.get(0));
            response.setCesante(verificaciones.get(1));
            response.setAportes(verificaciones.get(2));
            response.setRecobros(verificaciones.get(3));
            response.setUltimaPrestacion(verificaciones.get(4));
            response.setStatus("1");
            response.setPermiteRegistrar(true);
            response.setDescripcion(Mensajes.EXITO_VERIFICANDO_REQUISITOS);

            if (!verificaciones.get(0).equals(siCumple)
                    && !verificaciones.get(0).equals(validacionInactiva)) {
                response.setPermiteRegistrar(false);
            }

            if (!verificaciones.get(1).equals(siCumple)
                    && !verificaciones.get(1).equals(validacionInactiva)) {
                response.setPermiteRegistrar(false);
            }

            if (!verificaciones.get(2).equals(siCumple)
                    && !verificaciones.get(2).equals(validacionInactiva)) {
                response.setPermiteRegistrar(false);
            }

        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_VERIFICANDO_REQUISITOS);
        }
        return response;
    }
}

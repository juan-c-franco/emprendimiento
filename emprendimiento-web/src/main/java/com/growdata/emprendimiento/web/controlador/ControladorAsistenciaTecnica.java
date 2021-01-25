package com.growdata.emprendimiento.web.controlador;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoSesionPorNombre;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsistentesSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoSesionPorNombre;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATComplexPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerFuncionariosPorGrupoCaja;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionariosPorGrupoCaja;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetBeneficiarioXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetBeneficiarioXId;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.servicio.AsistenciaTecnicaServicio;
import com.growdata.emprendimiento.business.servicio.AsociadoServicio;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;
import com.growdata.emprendimiento.business.servicio.EstadoSesionServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.ListaasistenciaaatServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.MediaType;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Danny Fernando Guerrero Gelpud
 */
@Controller
//@PropertySource("classpath:propiedades.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class ControladorAsistenciaTecnica {

    private final BigDecimal grupo = new BigDecimal(8);

    @Autowired
    private Environment env;

    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @Autowired
    private AsistenciaTecnicaServicio asistenciaTecnicaServicio;

    @Autowired
    private BeneficiarioServicio beneficiarioServicio;

    @Autowired
    private EstadoSesionServicio estadoSesionServicio;

    @Autowired
    private AsociadoServicio asociadosServicio;

    @Autowired
    private EmprendimientoServicio emprendimientoServicio;

    @Autowired
    private ListaasistenciaaatServicio listaasistenciaaatServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;
    @Autowired
    private LoggerEmprendimiento log;

    private String modulo = "Asistencia Técnica";

    /**
     * Metodo encargado de consultar las sesion de AAT que se encuentran
     * agendadas por el id de un asistente técnico.
     *
     * @param principal El usuario en sesión
     * @param asistenteTecnicoId El id de el asistente técnico
     * @return Una lista de sesiones de AAT
     */
    @PostMapping(path = "/cargarSesionesAgendadasAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<SesionacompanamientoatDTO> cargarSesionesAgendadasAAT(Principal principal, @RequestParam(name = "asistenteTecnicoId", required = false) BigDecimal asistenteTecnicoId) {
        long idFAsistenteTecnico;
        if (asistenteTecnicoId == null) {
            RequestIsFuncionarioGrupo requestFuncionarioGrupo = new RequestIsFuncionarioGrupo();
            requestFuncionarioGrupo.setUserName(principal.getName());
            requestFuncionarioGrupo.setGrupo("Asistente Técnico");
            ResponseIsFuncionarioGrupo responseFuncionarioGrupo = funcionarioServicio.isFuncionarioDelGrupo(requestFuncionarioGrupo);
            idFAsistenteTecnico = responseFuncionarioGrupo.getFuncionarioDTO().getIdfuncionario();
        } else {
            idFAsistenteTecnico = asistenteTecnicoId.longValue();
        }
        RequestTraerSesionesAATPorFuncionario requestTraerSesionesAATPorFuncionario = new RequestTraerSesionesAATPorFuncionario();
        requestTraerSesionesAATPorFuncionario.setIdFuncionario(idFAsistenteTecnico);

        List<String> estadosSesion = new ArrayList<>();
        estadosSesion.add("Reservada");
        requestTraerSesionesAATPorFuncionario.setEstadosSesion(estadosSesion);

        ResponseTraerSesionesAATPorFuncionario responseTraerSesionesAATPorFuncionario = asistenciaTecnicaServicio.getSesionesAATAsistencia(requestTraerSesionesAATPorFuncionario);
        return responseTraerSesionesAATPorFuncionario.getSesionesAATDTO();
    }

    /**
     * Controlador encargado de consultar un Beneficiario y sus Emprendimientos
     * por Número de Documento.
     *
     * @param numeroDocumento Número de Documento
     * @return Datos del Beneficiario y emprendientos asociados.
     */
    @PostMapping(path = "/consultarBeneficiarioAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerBeneEmprTemasPorDocBeneficiario consultarBeneficiarioAAT(@RequestParam(name = "numeroDocumento") String numeroDocumento) {
        RequestTraerBeneEmprTemasPorDocBeneficiario request = new RequestTraerBeneEmprTemasPorDocBeneficiario();
        request.setNumeroDocumentoBen(numeroDocumento);
        List<String> estadosEmprendimiento = new ArrayList<>();
        estadosEmprendimiento.add("Acompañamiento y Asistencia Técnica");
        request.setEstadosEmprendimiento(estadosEmprendimiento);
        ResponseTraerBeneEmprTemasPorDocBeneficiario response = beneficiarioServicio.getBeneEmprTemasPorDocBeneficiario(request);
        return response;
    }

    /**
     * Controlador encargado de asociar un beneficiario a una determinada sesión
     * de Acompañamiento y Asistencia Técnica.
     *
     * @param idSesionAAT Identificador de la Sesión
     * @param temaAATId Identificador del Tema
     * @param principal Sesión Spring Security
     * @param emprendimientoId Identificador del Emprendimiento
     * @return Respuesta si fue satisfactorio o no el proceso.
     */
    @PostMapping(path = "/agendarSesionAAT")
    @ResponseBody
    public ResponseDTO agendarSesionAAT(@RequestParam("idSesionAAT") BigDecimal idSesionAAT,
            @RequestParam("temaAATId") BigDecimal temaAATId, Principal principal,
            @RequestParam("idEmprendimiento") BigDecimal emprendimientoId) {
        ResponseGuardarSesionAAT response = new ResponseGuardarSesionAAT();
        try {
            RequestTraerSesionAATPorId requestTraerSesionAATPorId = new RequestTraerSesionAATPorId();
            requestTraerSesionAATPorId.setSesionAATId(idSesionAAT.longValue());
            ResponseTraerSesionAATPorId responseTraerSesionAATPorId = asistenciaTecnicaServicio.getSesionAAT(requestTraerSesionAATPorId);
            SesionacompanamientoatDTO sesionAATDTO = responseTraerSesionAATPorId.getSesionAAT();
            RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion = new RequestTraerEstadoSesionPorNombre();
            requestTraerEstadoSesion.setNombreEstadoSesion("Reservada");
            ResponseTraerEstadoSesionPorNombre responseEstadoSesion = estadoSesionServicio.getEstadoSesion(requestTraerEstadoSesion);
            sesionAATDTO.setEstadosesion(responseEstadoSesion.getEstadoSesionDTO());
            sesionAATDTO.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));

            RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
            requestTraerTemasRutaAAT.setIdTemaRutaAAT(temaAATId.longValue());
            ResponseTraerTemasRutaAAT responseTraerTemasRutaAAT = asistenciaTecnicaServicio.getTemaRutaAAT(requestTraerTemasRutaAAT);
            TemasrutaacompanamientoatDTO temaRutaAATDTO = responseTraerTemasRutaAAT.getTemasRutaAATDTO();
            sesionAATDTO.setTemasrutaacompanamientoat(temaRutaAATDTO);

            RequestTraerRutaAAT requestTraerRutaAAT = new RequestTraerRutaAAT();
            requestTraerRutaAAT.setIdEmprendimiento(emprendimientoId.longValue());
            ResponseTraerRutaAAT responseTraerRutaAAT = asistenciaTecnicaServicio.getRutaAAT(requestTraerRutaAAT);
            sesionAATDTO.setRutaacompanamientoat(responseTraerRutaAAT.getRutaAATDTO());

            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            request.setSesionAATDTO(sesionAATDTO);
            response = asistenciaTecnicaServicio.actualizarSesionAAT(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(idSesionAAT.longValue());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
            log.writeToLogFile(ex);
        }
        return response;
    }

    /**
     * Controlador traer las sesiones de Acompañamiento y Asistencia Técnica
     * Programadas.
     *
     * @param principal Sesión Spring Secutiry
     * @param asistenteTecnicoId Identificador Funcionario
     * @return Respeusta si fue exitósa o no la búsqueda, y lista de Sesiones
     * que cumplan con los criterios de búsqueda.
     */
    @PostMapping(path = "/cargarSesionesProgramadasAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesionesAATPorFuncionario cargarSesionesProgramadasAAT(Principal principal, @RequestParam(name = "asistenteTecnicoId", required = false) BigDecimal asistenteTecnicoId) {
        long idFAsistenteTecnico;
        if (asistenteTecnicoId == null) {
            RequestIsFuncionarioGrupo requestFuncionarioGrupo = new RequestIsFuncionarioGrupo();
            requestFuncionarioGrupo.setUserName(principal.getName());
            requestFuncionarioGrupo.setGrupo("Asistente Técnico");
            ResponseIsFuncionarioGrupo responseFuncionarioGrupo = funcionarioServicio.isFuncionarioDelGrupo(requestFuncionarioGrupo);
            idFAsistenteTecnico = responseFuncionarioGrupo.getFuncionarioDTO().getIdfuncionario();
        } else {
            idFAsistenteTecnico = asistenteTecnicoId.longValue();
        }
        RequestTraerSesionesAATPorFuncionario requestTraerSesionesAATPorFuncionario = new RequestTraerSesionesAATPorFuncionario();
        requestTraerSesionesAATPorFuncionario.setIdFuncionario(idFAsistenteTecnico);
        List<String> estadosSesion = new ArrayList<>();
        estadosSesion.add("Programada");
        requestTraerSesionesAATPorFuncionario.setEstadosSesion(estadosSesion);
        requestTraerSesionesAATPorFuncionario.setTipoBusqueda('d');
        ResponseTraerSesionesAATPorFuncionario responseTraerSesionesAATPorFuncionario = asistenciaTecnicaServicio.getSesionesAAT(requestTraerSesionesAATPorFuncionario);
        return responseTraerSesionesAATPorFuncionario;
    }

    /**
     * Controlador traer las sesiones de Acompañamiento y Asistencia Técnica
     * Programadas y Reservadas.
     *
     * @param principal Sesión Spring Secutiry
     * @param asistenteTecnicoId Identificador Funcionario
     * @return Respeusta si fue exitósa o no la búsqueda, y lista de Sesiones
     * que cumplan con los criterios de búsqueda.
     */
    @PostMapping(path = "/cargarSesionesProgramadasReservadasAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesionesAATPorFuncionario cargarSesionesProgramadasReservadasAAT(Principal principal, @RequestParam(name = "asistenteTecnicoId", required = false) BigDecimal asistenteTecnicoId) {
        long idFAsistenteTecnico;
        if (asistenteTecnicoId == null) {
            RequestIsFuncionarioGrupo requestFuncionarioGrupo = new RequestIsFuncionarioGrupo();
            requestFuncionarioGrupo.setUserName(principal.getName());
            requestFuncionarioGrupo.setGrupo("Asistente Técnico");
            ResponseIsFuncionarioGrupo responseFuncionarioGrupo = funcionarioServicio.isFuncionarioDelGrupo(requestFuncionarioGrupo);
            idFAsistenteTecnico = responseFuncionarioGrupo.getFuncionarioDTO().getIdfuncionario();
        } else {
            idFAsistenteTecnico = asistenteTecnicoId.longValue();
        }
        RequestTraerSesionesAATPorFuncionario requestTraerSesionesAATPorFuncionario = new RequestTraerSesionesAATPorFuncionario();
        requestTraerSesionesAATPorFuncionario.setIdFuncionario(idFAsistenteTecnico);
        List<String> estadosSesion = new ArrayList<>();
        estadosSesion.add("Reservada");
        estadosSesion.add("Programada");
        estadosSesion.add("Culminada");
        estadosSesion.add("Cancelada");
        requestTraerSesionesAATPorFuncionario.setEstadosSesion(estadosSesion);
        requestTraerSesionesAATPorFuncionario.setTipoBusqueda('t');
        ResponseTraerSesionesAATPorFuncionario responseTraerSesionesAATPorFuncionario = asistenciaTecnicaServicio.getSesionesAAT(requestTraerSesionesAATPorFuncionario);
        return responseTraerSesionesAATPorFuncionario;
    }

    /**
     * Controlador encargado progragar una sesión de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param principal Sesión Spring Security
     * @param asistenteTecnicoId Identificador del Funcionario
     * @param fechaInicial Fecha de Inicio
     * @param fechaFinal Fecha de Fin
     * @param ubicacionSesion Ubicación
     * @return Url vista
     */
    @PostMapping(path = "/programarSesionAAT")
    @ResponseBody
    public ResponseDTO programarSesionAAT(Principal principal, @RequestParam(name = "asistenteTecnicoId") BigDecimal asistenteTecnicoId, @RequestParam("fechaInicial") String fechaInicial, @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("ubicacionSesion") String ubicacionSesion) {
        ResponseGuardarSesionAAT response = new ResponseGuardarSesionAAT();
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            SesionacompanamientoatDTO sesionAAT = new SesionacompanamientoatDTO();
            sesionAAT.setIdsesionacompanamientoat(-1);
            sesionAAT.setUbicacion(ubicacionSesion);
            sesionAAT.setFechainicio(new Timestamp(simple.parse(fechaInicial).getTime()));
            sesionAAT.setFechafinal(new Timestamp(simple.parse(fechaFinal).getTime()));
            sesionAAT.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));

            RequestModificarFuncionario requestFuncionario = new RequestModificarFuncionario();
            requestFuncionario.setIdfuncionario(asistenteTecnicoId.longValue());
            ResponseModificarFuncionario responseFuncionarioGrupo = funcionarioServicio.getFuncionarioPorId(requestFuncionario);
            sesionAAT.setFuncionario(responseFuncionarioGrupo.getFuncionarioDTO());

            RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion = new RequestTraerEstadoSesionPorNombre();
            requestTraerEstadoSesion.setNombreEstadoSesion("Programada");
            ResponseTraerEstadoSesionPorNombre responseEstadoSesion = estadoSesionServicio.getEstadoSesion(requestTraerEstadoSesion);

            sesionAAT.setEstadosesion(responseEstadoSesion.getEstadoSesionDTO());

            request.setSesionAATDTO(sesionAAT);
            response = asistenciaTecnicaServicio.guardarSesionAAT(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(response.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return response;
    }

    /**
     * Controlador encargado cancelar una sesión de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param idSesionAAT Identificador de la Sesión
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/eliminarSesionAAT")
    @ResponseBody
    public ResponseDTO eliminarSesionAAT(@RequestParam(name = "idSesionAAT") long idSesionAAT, Principal principal) {
        RequestEliminarSesionAAT request = new RequestEliminarSesionAAT();
        request.setIdSessionAAT(idSesionAAT);
        ResponseEliminarSesionAAT response = asistenciaTecnicaServicio.deleteSesionAAT(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idSesionAAT);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Controlador responsable de ubicar una Sesión de Acompañamiento y
     * Asistencia Técnica.
     *
     * @param idSesionAAT Identificador de la Sesión
     * @return Respuesta si fue exitósa o no la búsqueda, y Sesión que cumpla
     * con los criterios de búsqeuda.
     */
    @PostMapping(path = "/consultaSesionAATPorId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<SesionacompanamientoatDTO> consultaSesionAATPorId(@RequestParam("idSesionAAT") long idSesionAAT) {
        RequestTraerSesionAATPorId request = new RequestTraerSesionAATPorId();
        request.setSesionAATId(idSesionAAT);
        ResponseTraerSesionAATPorId response = asistenciaTecnicaServicio.getSesionAAT(request);
        return new ResponseEntity<>(response.getSesionAAT(), HttpStatus.OK);
    }

    /**
     * Controlador responsable de actualizar una sesión de Asistencia Técnica.
     *
     * @param fechaInicial Fecha de Inicio
     * @param fechaFinal Fecha Fin
     * @param ubicacionSesion Ubicación
     * @param idsesionacompanamientoat Identificador de la sesión
     * @param asistente Identificador del Funcionario
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/actualizarSesionAAT")
    @ResponseBody
    public ResponseDTO actualizarSesionAAT(@RequestParam("fechaInicial") String fechaInicial, @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("ubicacion") String ubicacionSesion, @RequestParam(name = "idsesionacompanamientoat") long idsesionacompanamientoat,
            @RequestParam(name = "asistente") BigDecimal asistente, Principal principal) {
        ResponseGuardarSesionAAT response = new ResponseGuardarSesionAAT();
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            SesionacompanamientoatDTO sesionAATDTO = new SesionacompanamientoatDTO();
            sesionAATDTO.setIdsesionacompanamientoat(idsesionacompanamientoat);
            sesionAATDTO.setUbicacion(ubicacionSesion);
            sesionAATDTO.setFechainicio(new Timestamp(simple.parse(fechaInicial).getTime()));
            sesionAATDTO.setFechafinal(new Timestamp(simple.parse(fechaFinal).getTime()));
            sesionAATDTO.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            RequestModificarFuncionario requestFuncionario = new RequestModificarFuncionario();
            requestFuncionario.setIdfuncionario(asistente.longValue());
            ResponseModificarFuncionario responseFuncionarioGrupo = funcionarioServicio.getFuncionarioPorId(requestFuncionario);
            sesionAATDTO.setFuncionario(responseFuncionarioGrupo.getFuncionarioDTO());

            RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion = new RequestTraerEstadoSesionPorNombre();
            requestTraerEstadoSesion.setNombreEstadoSesion("Programada");
            ResponseTraerEstadoSesionPorNombre responseEstadoSesion = estadoSesionServicio.getEstadoSesion(requestTraerEstadoSesion);
            sesionAATDTO.setEstadosesion(responseEstadoSesion.getEstadoSesionDTO());

            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            request.setSesionAATDTO(sesionAATDTO);
            response = asistenciaTecnicaServicio.guardarSesionAAT(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(idsesionacompanamientoat);
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param principal El usuario en sesion
     * @param cajaId El id de la caja de compensación
     * @param asistenteTecnicoId El id de el asistente técnico
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registrarSesionAAT")
    public String registrarSesionAAT(Principal principal, @RequestParam(name = "cajaId", required = false) BigDecimal cajaId, @RequestParam(name = "asistenteTecnicoId", required = false) BigDecimal asistenteTecnicoId, Model model) {
        RequestTraerFuncionarioPorUserName requestFuncionario = new RequestTraerFuncionarioPorUserName();
        requestFuncionario.setIdEstado(BigDecimal.valueOf(1));
        requestFuncionario.setUserName(principal.getName());
        ResponseTraerFuncionarioPorUserName responseFuncionario = funcionarioServicio.getFuncionarioPorUserName(requestFuncionario);

        String status = "";
        if (responseFuncionario.getFuncionarioDTO() == null && cajaId == null) {
            status = "adm";
            RequestTraerCajas requestCajas = new RequestTraerCajas();
            ResponseTraerCajas responseCajas = cajasDeCompensacionServicio.getCajasDeCompensacion(requestCajas);
            model.addAttribute("cajas", responseCajas.getCajasDTO());
        } else {
            RequestIsFuncionarioGrupo requestFuncionarioGrupo = new RequestIsFuncionarioGrupo();
            requestFuncionarioGrupo.setUserName(principal.getName());
            requestFuncionarioGrupo.setGrupo("Asistente Técnico");
            ResponseIsFuncionarioGrupo responseFuncionarioGrupo = funcionarioServicio.isFuncionarioDelGrupo(requestFuncionarioGrupo);
            model.addAttribute("idCajaCompensacion", cajaId);
            if (responseFuncionarioGrupo.getFuncionarioDTO() == null && asistenteTecnicoId == null) {
                status = "caja";
                RequestTraerFuncionariosPorGrupoCaja requestFuncionarioGrupoCaja = new RequestTraerFuncionariosPorGrupoCaja();
                requestFuncionarioGrupoCaja.setGrupo("Asistente Técnico");
                requestFuncionarioGrupoCaja.setIdCajaCompensacion(cajaId);
                ResponseTraerFuncionariosPorGrupoCaja responseAsistentes = funcionarioServicio.getFuncionariosPorGrupoYCaja(requestFuncionarioGrupoCaja);
                model.addAttribute("asistentesTecnicos", responseAsistentes.getFuncionariosDTO());
            } else {
                status = "asistente";
                long idFAsistenteTecnico = asistenteTecnicoId != null ? asistenteTecnicoId.longValue() : responseFuncionarioGrupo.getFuncionarioDTO().getIdfuncionario();
                model.addAttribute("idAsistenteTecnico", idFAsistenteTecnico);
            }
        }
        model.addAttribute("status", status);
        return "registrarSesionAAT";
    }

    /**
     * Controlador responsable de mostrar vista correspondiente al caso de uso
     * Programar Sesión de Acompañamiento y Asistencia Técnica.
     *
     * @param cajaId Identificador de la Caja de Compensación
     * @param asistenteTecnicoId Identificador del Funcionario
     * @param idSesionAAT Identificador de la Sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping(path = "/consultaSesionAATComplexPorId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String consultaSesionAATComplexPorId(@RequestParam(name = "cajaId") BigDecimal cajaId, @RequestParam(name = "asistenteTecnicoId") BigDecimal asistenteTecnicoId, @RequestParam("idSesionAAT") long idSesionAAT, Model model) {
        RequestTraerSesionAATPorId request = new RequestTraerSesionAATPorId();
        request.setSesionAATId(idSesionAAT);
        ResponseTraerSesionAATComplexPorId response = asistenciaTecnicaServicio.getSesionAATComplex(request);
        model.addAttribute("status", "admAsistencia");
        model.addAttribute("idAsistenteTecnico", asistenteTecnicoId);
        model.addAttribute("idCajaCompensacion", cajaId);
        model.addAttribute("sesionAATComplex", response.getSesionAATComplexDTO());
        return "registrarSesionAAT";
    }

    /**
     * Metodo que registra la asistencia a una sesion de AAT
     *
     * @param cajaId El id de la caja de compensación
     * @param asistenteTecnicoId El id de el asistente técnico
     * @param sesionRegistrar Contiene el id de la sesion y las asistencias
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Respuesta si se registro la asistencia o no
     */
    @PostMapping(path = "/registrarSesionAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarSesionAAT(@RequestParam(name = "cajaId") BigDecimal cajaId,
            @RequestParam(name = "asistenteTecnicoId") BigDecimal asistenteTecnicoId,
            @RequestParam(name = "sesionRegistrar") String sesionRegistrar, Model model, Principal principal) {
        ResponseDTO response = null;
        try {
            JsonFactory factory = new JsonFactory();
            JsonParser jsonParser = factory.createParser(sesionRegistrar);
            RequestTraerSesionAATPorId requestTraerSesionAATPorId = new RequestTraerSesionAATPorId();
            ResponseTraerSesionAATPorId responseTraerSesionAATPorId = new ResponseTraerSesionAATPorId();
            SesionacompanamientoatDTO sesionAATDTO = new SesionacompanamientoatDTO();

            List<ListaasistenciaaatDTO> listasAATDTO = new ArrayList<>();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String name = jsonParser.getCurrentName();
                if ("idSesion".equals(name)) {
                    jsonParser.nextToken();
                    requestTraerSesionAATPorId.setSesionAATId(Long.parseLong(jsonParser.getValueAsString()));
                    responseTraerSesionAATPorId = asistenciaTecnicaServicio.getSesionAAT(requestTraerSesionAATPorId);
                    sesionAATDTO = responseTraerSesionAATPorId.getSesionAAT();
                } else if ("asistenciaArray".equals(name)) {
                    jsonParser.nextToken();
                    long idListaAAT = 0;
                    String radioRs = "";
                    String jusInasistencia = "";
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        String nameArray = jsonParser.getCurrentName();
                        if ("idListaAAT".equals(nameArray)) {
                            jsonParser.nextToken();
                            idListaAAT = Long.parseLong(jsonParser.getValueAsString());
                        } else if ("radioRs".equals(nameArray)) {
                            jsonParser.nextToken();
                            radioRs = jsonParser.getValueAsString();
                        } else if ("jusInasistencia".equals(nameArray)) {
                            jsonParser.nextToken();
                            jusInasistencia = jsonParser.getValueAsString();
                        }
                        if ((idListaAAT > 0 && !"".equals(radioRs) && "1".equals(radioRs)) || (idListaAAT > 0 && !"".equals(radioRs) && "0".equals(radioRs) && !"".equals(jusInasistencia))) {
                            ListaasistenciaaatDTO listaAATDTO = new ListaasistenciaaatDTO();
                            RequestTraerListaAAT requestTraerListaAAT = new RequestTraerListaAAT();
                            requestTraerListaAAT.setIdListaAAT(idListaAAT);
                            ResponseTraerListaAAT responseTraerListaAAT = asistenciaTecnicaServicio.getListaAAT(requestTraerListaAAT);
                            listaAATDTO = responseTraerListaAAT.getListaAATDTO();
                            listaAATDTO.setRegistroasistencia(radioRs.charAt(0));
                            listaAATDTO.setJustificacioninasistencia("".equals(jusInasistencia) ? null : jusInasistencia.charAt(0));
                            listaAATDTO.setFecharegistro(new Date());
                            listasAATDTO.add(listaAATDTO);
                            idListaAAT = 0;
                            radioRs = "";
                            jusInasistencia = "";
                        }
                    }
                } else if ("observacionesSesion".equals(name)) {
                    jsonParser.nextToken();
                    sesionAATDTO.setObservaciones(jsonParser.getValueAsString());
                }
            }
            RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion = new RequestTraerEstadoSesionPorNombre();
            requestTraerEstadoSesion.setNombreEstadoSesion("Culminada");
            ResponseTraerEstadoSesionPorNombre responseEstadoSesion = estadoSesionServicio.getEstadoSesion(requestTraerEstadoSesion);
            sesionAATDTO.setEstadosesion(responseEstadoSesion.getEstadoSesionDTO());
            sesionAATDTO.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            request.setSesionAATDTO(sesionAATDTO);
            request.setListasAATDTO(listasAATDTO);
            response = asistenciaTecnicaServicio.registrarAsistenciaAAT(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(response.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return response;
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador, la pantalla para el beneficiario o la pantalla para el
     * funcionario
     *
     * @param principal Usuario en sesion
     * @param emprendimientoId Identificador del emprendimiento
     * @param model Modelo JSP
     * @return Url vista dependiendo del tipo de usuario
     */
    @GetMapping("/adjuntarDocumentoAAT")
    public String adjuntarDocumentoAAT(Principal principal, @RequestParam(name = "emprendimientoId", required = false) BigDecimal emprendimientoId, Model model) {
        RequestTraerBeneficiarioPorUserName requestTraerBeneficiarioPorUserName = new RequestTraerBeneficiarioPorUserName();
        requestTraerBeneficiarioPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
        requestTraerBeneficiarioPorUserName.setUserName(principal.getName());
        ResponseTraerBeneficiarioPorUserName responseTraerBeneficiarioPorUserName = beneficiarioServicio.getBeneficiario(requestTraerBeneficiarioPorUserName);

        String status = "";
        if (responseTraerBeneficiarioPorUserName.getBeneficiario() == null && emprendimientoId == null) {
            status = "adm";
            RequestTraerEmprendimientos requestEmprendimientos = new RequestTraerEmprendimientos();
            List<String> estadosEmprendimiento = new ArrayList<>();
            estadosEmprendimiento.add("Acompañamiento y Asistencia Técnica");
            requestEmprendimientos.setEstadosEmprendimiento(estadosEmprendimiento);
            ResponseTraerEmprendimientos responseTraerEmprendimientos = asistenciaTecnicaServicio.getEmprendimientos(requestEmprendimientos);
            model.addAttribute("emprendimientos", responseTraerEmprendimientos.getEmprendimientos());
        } else {
            RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName = new RequestTraerAsociadoPorUserName();
            requestTraerAsociadoPorUserName.setUserName(principal.getName());
            requestTraerAsociadoPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
            ResponseTraerAsociadoPorUserName responseTraerAsociadoPorUserName = asociadosServicio.getAsociado(requestTraerAsociadoPorUserName);
            EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
            long idBeneficiario = 0;
            boolean beneficiarioLider = false;
            if (responseTraerAsociadoPorUserName.getAsociadoDTO() == null) {
                if (emprendimientoId == null) {
                    model.addAttribute("mensaje", "El beneficiario no cuenta con un emprendimiento activo");
                    return "adjuntarDocumentoAAT";
                } else {
                    RequestTraerEmprendimiento requestTraerEmprendimiento = new RequestTraerEmprendimiento();
                    requestTraerEmprendimiento.setIdEmprendimiento(emprendimientoId.longValue());
                    ResponseTraerEmprendimiento responseTraerEmprendimiento = asistenciaTecnicaServicio.getEmprendimiento(requestTraerEmprendimiento);
                    emprendimiento = responseTraerEmprendimiento.getEmprendimientoDTO();
                }
            } else {
                emprendimiento = responseTraerAsociadoPorUserName.getAsociadoDTO().getEmprendimiento();
                idBeneficiario = responseTraerAsociadoPorUserName.getAsociadoDTO().getBeneficiario().getIdbeneficiario();
                beneficiarioLider = '1' == responseTraerAsociadoPorUserName.getAsociadoDTO().getLider();
            }
            if (!"Acompañamiento y Asistencia Técnica".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento())) {
                model.addAttribute("mensaje", "El emprendimiento asociado debe estar en estado 'Acompañamiento y Asistencia Técnica'");
                return "adjuntarDocumentoAAT";
            }
            status = "beneficiario";
            model.addAttribute("idBeneficiario", idBeneficiario);
            model.addAttribute("idEmprendimiento", emprendimiento.getIdemprendimiento());
            model.addAttribute("emprendimiento", emprendimiento);

            model.addAttribute("soloConsulta", !"Acompañamiento y Asistencia Técnica".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento()) || idBeneficiario == 0 || !beneficiarioLider);

            RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
            requestTraerTemasRutaAAT.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
            ResponseTraerListaTemasRutaAAT responseTraerListaTemasRutaAAT = asistenciaTecnicaServicio.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
            List<TemasrutaacompanamientoatDTO> temasRutaAATT = responseTraerListaTemasRutaAAT.getTemasRutaAATDTO();
            model.addAttribute("temasRutaAAT", temasRutaAATT);
        }
        model.addAttribute("status", status);
        return "adjuntarDocumentoAAT";
    }

    /**
     * Metodo que revisa en la BD si existe un documento con el id que recibe y
     * si es asi lo trae
     *
     * @param id El id de un tema de ruta de AAT
     * @param response HttpServletResponse
     */
    @RequestMapping(value = "/verDocumentoTemaRutaAAT", method = RequestMethod.GET, produces = "application/pdf")
    public @ResponseBody
    void verDocumentoTemaRutaAAT(@RequestParam(name = "id") BigDecimal id, HttpServletResponse response) {
        RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
        requestTraerTemasRutaAAT.setIdTemaRutaAAT(id.longValue());
        ResponseTraerTemasRutaAAT responseTraerTemasRutaAAT = asistenciaTecnicaServicio.getTemaRutaAAT(requestTraerTemasRutaAAT);

        if (responseTraerTemasRutaAAT.getTemasRutaAATDTO().getUrldocumentotema() != null && !"".equals(responseTraerTemasRutaAAT.getTemasRutaAATDTO().getUrldocumentotema())) {
            try {
                String pathFile = env.getProperty("root.path.files.emprendimiento") + env.getProperty("delimiter.path")
                        + env.getProperty("path.files.temasruta.aat") + env.getProperty("delimiter.path")
                        + responseTraerTemasRutaAAT.getTemasRutaAATDTO().getIdtemarutaacompanamientoat() + env.getProperty("delimiter.path")
                        + responseTraerTemasRutaAAT.getTemasRutaAATDTO().getUrldocumentotema();
                File file = getFile(pathFile);
                InputStream in = new FileInputStream(file);

                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                response.setHeader("Content-Length", String.valueOf(file.length()));
                try {
                    FileCopyUtils.copy(in, response.getOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAsistenciaTecnica.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorAsistenciaTecnica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo que recibe una ruta de archivo y lo trae
     *
     * @param pathFile Ruta de archivo
     * @return Un archivo
     * @throws FileNotFoundException
     */
    private File getFile(String pathFile) throws FileNotFoundException {
        File file = new File(pathFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Archivo no encontrado: " + pathFile);
        }
        return file;
    }

    /**
     * Metodo que crea el archivo a adjuntar en al ruta definida en el archivo
     * de propiedades y agrega su url a la BD
     *
     * @param temaRutaAATId El id de un tema de ruta de AAT
     * @param documentoTemaRutaAAT El documento a adjuntar
     * @param descDocumento Descripción del documento
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @RequestMapping(value = "/adjuntarDocumentoAAT/{temaRutaAATId}", method = RequestMethod.POST)
    public String guardarAdjuntarDocumentoAAT(@PathVariable BigDecimal temaRutaAATId,
            @RequestPart("documentoTemaRutaAAT") MultipartFile documentoTemaRutaAAT,
            @RequestParam("descDocumento") String descDocumento, Model model, Principal principal) {
        String respuesta = "Se guardó documento exitosamente!";
        try {
            RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
            requestTraerTemasRutaAAT.setIdTemaRutaAAT(temaRutaAATId.longValue());
            ResponseTraerTemasRutaAAT responseTraerTemasRutaAAT = asistenciaTecnicaServicio.getTemaRutaAAT(requestTraerTemasRutaAAT);
            TemasrutaacompanamientoatDTO temaRutaAAT = responseTraerTemasRutaAAT.getTemasRutaAATDTO();
            temaRutaAAT.setDescripciondocumento(descDocumento);
            temaRutaAAT.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));

            String pathRoot = env.getProperty("root.path.files.emprendimiento") + env.getProperty("delimiter.path")
                    + env.getProperty("path.files.temasruta.aat") + env.getProperty("delimiter.path")
                    + responseTraerTemasRutaAAT.getTemasRutaAATDTO().getIdtemarutaacompanamientoat() + env.getProperty("delimiter.path");

            File carpetaTema = new File(pathRoot);
            carpetaTema.mkdirs();

            deleteFiles(pathRoot);
            writeBytesToFile(documentoTemaRutaAAT.getBytes(), pathRoot + documentoTemaRutaAAT.getOriginalFilename());

            temaRutaAAT.setUrldocumentotema(documentoTemaRutaAAT.getOriginalFilename());

            RequestGuardarTemaRutaAAT requestGuardarTemaRutaAAT = new RequestGuardarTemaRutaAAT();
            requestGuardarTemaRutaAAT.setTemaRutaAAT(temaRutaAAT);
            ResponseGuardarTemaRutaAAT responseGuardarTemaRutaAAT = asistenciaTecnicaServicio.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
            if ("1".equals(responseGuardarTemaRutaAAT.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(responseGuardarTemaRutaAAT.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(responseGuardarTemaRutaAAT.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }

            respuesta = "0".equals(responseGuardarTemaRutaAAT.getStatus()) ? responseGuardarTemaRutaAAT.getDescripcion() : respuesta;
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        model.addAttribute("mensaje", respuesta);
        return "adjuntarDocumentoAAT";
    }

    /**
     * Metodo que borra un archivo
     *
     * @param folder Ruta del archivo
     */
    public void deleteFiles(String folder) {
        File fileTemp = new File(folder);
        File[] files = fileTemp.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    /**
     * Metodo que crea un archivo
     *
     * @param bFile Bytes del archivo
     * @param fileDest Ruta del archivo a crear
     * @throws Exception Cualquier Exception
     */
    private static void writeBytesToFile(byte[] bFile, String fileDest) throws Exception {
        try {
            Path path = Paths.get(fileDest);
            Files.write(path, bFile);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Controlador encargado de cargar los datos del emprendimiento al consultar
     * el avance.
     *
     * @param numeroDocumento Número de Documento
     * @param idAsistenteTecnico Identificador del Funcionario
     * @param idCajaCompensacion Identificador de la Caja de Compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping(path = "/consultarAvanceAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String consultarAvanceAAT(@RequestParam(name = "numeroDocumento") String numeroDocumento, @RequestParam(name = "idAsistenteTecnico") BigDecimal idAsistenteTecnico, @RequestParam(name = "idCajaCompensacion") BigDecimal idCajaCompensacion, Model model) {
        RequestConsultarAvance request = new RequestConsultarAvance();
        request.setNumeroDocumentoBen(numeroDocumento);
        List<String> estadosEmprendimiento = new ArrayList<>();
        estadosEmprendimiento.add("Acompañamiento y Asistencia Técnica");
        estadosEmprendimiento.add("Registro");
        estadosEmprendimiento.add("Registro de información financiera");
        estadosEmprendimiento.add("Evaluación");
        estadosEmprendimiento.add("Financiación");
        estadosEmprendimiento.add("Puesta en marcha y seguimiento");
        estadosEmprendimiento.add("Finalizado");
        request.setEstadosEmprendimiento(estadosEmprendimiento);
        request.setIdAsistenteTecnico(idAsistenteTecnico.longValue());
        request.setIdCajaCompensacion(idCajaCompensacion);
        List<String> estadosSesion = new ArrayList<>();
        estadosSesion.add("Culminada");
        request.setEstadosSesion(estadosSesion);
        ResponseConsultarAvance response = asistenciaTecnicaServicio.consultarAvanceAAT(request);
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);
        model.addAttribute("idAsistenteTecnico", idAsistenteTecnico);
        model.addAttribute("numeroDocumentoTmp", numeroDocumento);

        if ("0".equals(response.getStatus())) {
            model.addAttribute("mensaje", response.getDescripcion());
            return "consultarAvanceAAT";
        }

        model.addAttribute("status", "beneficiario");
        Iterator itTemasRutaAAT = response.getConsultarAvanceComplexDTO().getTemasRutasAAT().iterator();
        float porcentajeRealTemasAAT = 0;
        while (itTemasRutaAAT.hasNext()) {
            TemasrutaacompanamientoatDTO temasRutaAATDTO = (TemasrutaacompanamientoatDTO) itTemasRutaAAT.next();
            float porcentajeTmp = (temasRutaAATDTO.getCantidadHorasEjecutadas() * 100) / temasRutaAATDTO.getCantidadhorasplaneadas().floatValue();
            porcentajeRealTemasAAT += porcentajeTmp;
        }

        if (response.getConsultarAvanceComplexDTO().getTemasRutasAAT().size() > 0) {
            porcentajeRealTemasAAT = porcentajeRealTemasAAT / response.getConsultarAvanceComplexDTO().getTemasRutasAAT().size();
        } else {
            porcentajeRealTemasAAT = 0;
        }

        if (porcentajeRealTemasAAT > 100) {
            porcentajeRealTemasAAT = 100;
        }
        model.addAttribute("emprendimiento", response.getConsultarAvanceComplexDTO().getEmprendimiento());
        model.addAttribute("temasRutasAAT", response.getConsultarAvanceComplexDTO().getTemasRutasAAT());
        model.addAttribute("beneficiarios", response.getConsultarAvanceComplexDTO().getBeneficiarios());
        model.addAttribute("porcentajeRealTemasAAT", porcentajeRealTemasAAT);
        model.addAttribute("permiteAprobar", !"0".equals(response.getStatus())
                && "Acompañamiento y Asistencia Técnica".equals(response.getConsultarAvanceComplexDTO().getEmprendimiento().getEstadoemprendimiento().getNombreestadoemprendimiento())
                && porcentajeRealTemasAAT >= 0.8 && response.getConsultarAvanceComplexDTO().isPermiteAprobar() ? "1" : "0");
        model.addAttribute("docSet", response.getConsultarAvanceComplexDTO().isDocSet());
        return "consultarAvanceAAT";
    }

    /**
     * Controlador encargado de aprobar el avance de un emprendimiento.
     *
     * @param numeroDocumento Número de documento del Beneficiario
     * @param idemprendimiento Identificador del Emprendimiento
     * @param idAsistenteTecnico Identificador del Funcionario
     * @param idcajacompensacion Identificador de la caja de compensación
     * @param principal Sesión Spring Security
     * @return Url vista
     */
    @PostMapping(path = "/aprobarAvanceAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO aprobarAvanceAAT(@RequestParam(name = "numeroDocumento") String numeroDocumento,
            @RequestParam(name = "idemprendimiento") BigDecimal idemprendimiento,
            @RequestParam(name = "idAsistenteTecnico") BigDecimal idAsistenteTecnico,
            @RequestParam(name = "idcajacompensacion") BigDecimal idcajacompensacion, Principal principal) {
        RequestConsultarAvance request = new RequestConsultarAvance();
        ResponseActualizarEmprendimiento responseActualizarEmprendimiento = null;
        request.setNumeroDocumentoBen(numeroDocumento);
        request.setIdCajaCompensacion(idcajacompensacion);
        List<String> estadosEmprendimiento = new ArrayList<>();
        estadosEmprendimiento.add("Acompañamiento y Asistencia Técnica");
        request.setEstadosEmprendimiento(estadosEmprendimiento);
        request.setIdAsistenteTecnico(idAsistenteTecnico.longValue());
        List<String> estadosSesion = new ArrayList<>();
        estadosSesion.add("Culminada");
        request.setEstadosSesion(estadosSesion);
        ResponseConsultarAvance response = asistenciaTecnicaServicio.consultarAvanceAAT(request);
        if ("0".equals(response.getStatus())) {
            return response;
        }

        Iterator itTemasRutaAAT = response.getConsultarAvanceComplexDTO().getTemasRutasAAT().iterator();
        float porcentajeRealTemasAAT = 0;
        while (itTemasRutaAAT.hasNext()) {
            TemasrutaacompanamientoatDTO temasRutaAATDTO = (TemasrutaacompanamientoatDTO) itTemasRutaAAT.next();
            float porcentajeTmp = (temasRutaAATDTO.getCantidadHorasEjecutadas() * 100) / temasRutaAATDTO.getCantidadhorasplaneadas().floatValue();
            porcentajeRealTemasAAT += porcentajeTmp;
        }

        if (response.getConsultarAvanceComplexDTO().getTemasRutasAAT().size() > 0) {
            porcentajeRealTemasAAT = porcentajeRealTemasAAT / response.getConsultarAvanceComplexDTO().getTemasRutasAAT().size();
        } else {
            porcentajeRealTemasAAT = 0;
        }

        int porcentajePermitidoAvance = Integer.parseInt(env.getProperty("porcentaje.aprobacion.aat"));
        boolean aprobarAvance = false;
        if (porcentajeRealTemasAAT >= porcentajePermitidoAvance) {
            aprobarAvance = true;
        }
        String mensaje = "";
        if (!aprobarAvance) {
            mensaje = "El emprendimiento no cumple con el porcentaje de avance " + porcentajePermitidoAvance + "% para Asistencia Técnica.";
        } else {
            RequestTraerEmprendimiento requestTraerEmprendimiento = new RequestTraerEmprendimiento();
            requestTraerEmprendimiento.setIdEmprendimiento(idemprendimiento.longValue());
            ResponseTraerEmprendimiento responseTraerEmprendimiento = asistenciaTecnicaServicio.getEmprendimiento(requestTraerEmprendimiento);
            if ("0".equals(responseTraerEmprendimiento.getStatus())) {
                return responseTraerEmprendimiento;
            }
            EmprendimientoDTO emprendimiento = responseTraerEmprendimiento.getEmprendimientoDTO();
            RequestTraerEstadoEmprendimiento requestTraerEstadoEmprendimiento = new RequestTraerEstadoEmprendimiento();
            requestTraerEstadoEmprendimiento.setIdestadoemprendimiento(new BigDecimal(3));
            ResponseTraerEstadoEmprendimiento estadoemprendimientoDTO = asistenciaTecnicaServicio.getEstadoEmprendimiento(requestTraerEstadoEmprendimiento);
            if ("0".equals(estadoemprendimientoDTO.getStatus())) {
                return estadoemprendimientoDTO;
            }
            emprendimiento.setEstadoemprendimiento(estadoemprendimientoDTO.getEstadoEmprendimientoDTO());

            RequestActualizarEmprendimiento requestActualizarEmprendimiento = new RequestActualizarEmprendimiento();
            requestActualizarEmprendimiento.setEmprendimiento(emprendimiento);
            requestActualizarEmprendimiento.setBeneficiarios(response.getConsultarAvanceComplexDTO().getBeneficiarios());
            responseActualizarEmprendimiento = emprendimientoServicio.updateEmprendimiento(requestActualizarEmprendimiento);
            if ("0".equals(responseActualizarEmprendimiento.getStatus())) {
                return responseActualizarEmprendimiento;
            }
            if ("1".equals(responseActualizarEmprendimiento.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(responseActualizarEmprendimiento.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(responseActualizarEmprendimiento.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
//            mensaje = "1".equals(responseActualizarEmprendimiento.getStatus()) ? mensaje : responseActualizarEmprendimiento.getDescripcion();
        }
        return responseActualizarEmprendimiento;
    }

    //Adjuntar documento comite AAT
    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador, la pantalla para el beneficiario o la pantalla para el
     * funcionario
     *
     * @param principal El usuario en sesión
     * @param emprendimientoId El id del emprendimiento
     * @param model Modelo JSP
     * @return Url vista dependiendo del tipo de usuario
     */
    @GetMapping("/adjuntarDocumentoComiteAAT")
    public String adjuntarDocumentoComiteAAT(Principal principal, @RequestParam(name = "emprendimientoId", required = false) BigDecimal emprendimientoId, Model model) {
        RequestTraerBeneficiarioPorUserName requestTraerBeneficiarioPorUserName = new RequestTraerBeneficiarioPorUserName();
        requestTraerBeneficiarioPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
        requestTraerBeneficiarioPorUserName.setUserName(principal.getName());
        ResponseTraerBeneficiarioPorUserName responseTraerBeneficiarioPorUserName = beneficiarioServicio.getBeneficiario(requestTraerBeneficiarioPorUserName);

        String status = "";
        if (responseTraerBeneficiarioPorUserName.getBeneficiario() == null && emprendimientoId == null) {
            status = "adm";
            RequestTraerEmprendimientos requestEmprendimientos = new RequestTraerEmprendimientos();
            List<String> estadosEmprendimiento = new ArrayList<>();
            estadosEmprendimiento.add("Acompañamiento y Asistencia Técnica");
            estadosEmprendimiento.add("Registro de información financiera");
            estadosEmprendimiento.add("Rompimiento de fases");
            requestEmprendimientos.setEstadosEmprendimiento(estadosEmprendimiento);
            ResponseTraerEmprendimientos responseTraerEmprendimientos = asistenciaTecnicaServicio.getEmprendimientos(requestEmprendimientos);
            model.addAttribute("emprendimientos", responseTraerEmprendimientos.getEmprendimientos());
        } else {
            RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName = new RequestTraerAsociadoPorUserName();
            requestTraerAsociadoPorUserName.setUserName(principal.getName());
            requestTraerAsociadoPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
            ResponseTraerAsociadoPorUserName responseTraerAsociadoPorUserName = asociadosServicio.getAsociado(requestTraerAsociadoPorUserName);
            EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
            long idBeneficiario = 0;
            boolean beneficiarioLider = false;
            if (responseTraerAsociadoPorUserName.getAsociadoDTO() == null) {
                RequestTraerEmprendimiento requestTraerEmprendimiento = new RequestTraerEmprendimiento();
                requestTraerEmprendimiento.setIdEmprendimiento(emprendimientoId.longValue());
                ResponseTraerEmprendimiento responseTraerEmprendimiento = asistenciaTecnicaServicio.getEmprendimiento(requestTraerEmprendimiento);
                emprendimiento = responseTraerEmprendimiento.getEmprendimientoDTO();
                if (emprendimiento == null) {
                    model.addAttribute("mensaje", "El beneficiario no tiene un emprendimiento activo");
                } else {
                    model.addAttribute("emprendimiento", emprendimiento);
                    model.addAttribute("status", "beneficiario");
                    model.addAttribute("soloConsulta", !("Registro de información financiera".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento()) || "Acompañamiento y Asistencia Técnica".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento())) || idBeneficiario == 0 || !beneficiarioLider);
                    RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
                    requestTraerTemasRutaAAT.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
                    ResponseTraerListaTemasRutaAAT responseTraerListaTemasRutaAAT = asistenciaTecnicaServicio.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
                    List<TemasrutaacompanamientoatDTO> temasRutaAATT = responseTraerListaTemasRutaAAT.getTemasRutaAATDTO();
                    model.addAttribute("temasRutaAAT", temasRutaAATT);

                    RequestTraerDocumentos requestTraerDocumentos = new RequestTraerDocumentos();
                    requestTraerDocumentos.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
                    requestTraerDocumentos.setIdTipoDocumento(new BigDecimal(1));
                    ResponseTraerDocumentos responseTraerDocumentos = asistenciaTecnicaServicio.getDocumentos(requestTraerDocumentos);
                    model.addAttribute("documentosComite", responseTraerDocumentos.getDocumentosDTO());
                }

                return "adjuntarDocumentoComiteAAT";

            } else {
                emprendimiento = responseTraerAsociadoPorUserName.getAsociadoDTO().getEmprendimiento();
                idBeneficiario = responseTraerAsociadoPorUserName.getAsociadoDTO().getBeneficiario().getIdbeneficiario();
                beneficiarioLider = '1' == responseTraerAsociadoPorUserName.getAsociadoDTO().getLider();
            }
            status = "beneficiario";
            model.addAttribute("idBeneficiario", idBeneficiario);
            model.addAttribute("idEmprendimiento", emprendimiento.getIdemprendimiento());
            model.addAttribute("emprendimiento", emprendimiento);

            model.addAttribute("soloConsulta", !("Registro de información financiera".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento()) || "Acompañamiento y Asistencia Técnica".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento()) || "Rompimiento de fases".equals(emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento())) || idBeneficiario == 0 || !beneficiarioLider);

            RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
            requestTraerTemasRutaAAT.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
            ResponseTraerListaTemasRutaAAT responseTraerListaTemasRutaAAT = asistenciaTecnicaServicio.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
            List<TemasrutaacompanamientoatDTO> temasRutaAATT = responseTraerListaTemasRutaAAT.getTemasRutaAATDTO();
            model.addAttribute("temasRutaAAT", temasRutaAATT);

            RequestTraerDocumentos requestTraerDocumentos = new RequestTraerDocumentos();
            requestTraerDocumentos.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
            requestTraerDocumentos.setIdTipoDocumento(new BigDecimal(1));
            ResponseTraerDocumentos responseTraerDocumentos = asistenciaTecnicaServicio.getDocumentos(requestTraerDocumentos);
            model.addAttribute("documentosComite", responseTraerDocumentos.getDocumentosDTO());
        }
        model.addAttribute("status", status);
        return "adjuntarDocumentoComiteAAT";
    }

    /**
     * Metodo que revisa en la BD si existe un documento con el id que recibe y
     * si es asi lo trae
     *
     * @param id El id del documento de comité
     * @param response HttpServletResponse
     */
    @RequestMapping(value = "/verDocumentoComiteAAT", method = RequestMethod.GET, produces = "application/pdf")
    public @ResponseBody
    void verDocumentoComiteAAT(@RequestParam(name = "id") BigDecimal id, HttpServletResponse response) {
        RequestTraerDocumentoComite requestTraerDocumentoComite = new RequestTraerDocumentoComite();
        requestTraerDocumentoComite.setIdDocumentoComite(id.longValue());
        ResponseTraerDocumentoComite responseTraerDocumentoComite = asistenciaTecnicaServicio.getDocumento(requestTraerDocumentoComite);

        if (responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo() != null && !"".equals(responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo())) {
            try {
                String pathFile = env.getProperty("root.path.files.emprendimiento") + env.getProperty("delimiter.path")
                        + env.getProperty("path.files.documentos.comite.aat") + env.getProperty("delimiter.path")
                        + responseTraerDocumentoComite.getDocumentoDTO().getIddocumento() + env.getProperty("delimiter.path")
                        + responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo();
                File file = getFile(pathFile);
                InputStream in = new FileInputStream(file);

                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                response.setHeader("Content-Length", String.valueOf(file.length()));
                try {
                    FileCopyUtils.copy(in, response.getOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAsistenciaTecnica.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorAsistenciaTecnica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo que crea el archivo a adjuntar en al ruta definida en el archivo
     * de propiedades y agrega su url a la BD
     *
     * @param documentoComiteAATId El id del documento de comité AAT
     * @param documentoComiteAAT El documento de comité AAT
     * @param emprendimientoId El id del emprendimiento
     * @param idBeneficiario El id del beneficiario
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @RequestMapping(value = "/adjuntarDocumentoComiteAAT", method = RequestMethod.POST)
    public String guardarAdjuntarDocumentoComiteAAT(@RequestParam(name = "documentoComiteAATId", required = false) BigDecimal documentoComiteAATId,
            @RequestPart("documentoComiteAAT") MultipartFile documentoComiteAAT, @RequestParam(name = "emprendimientoId") BigDecimal emprendimientoId,
            @RequestParam(name = "idBeneficiario") BigDecimal idBeneficiario, Model model, Principal principal) {
        DocumentosDTO documentoDTO;
        String respuesta = "Se guardó documento exitosamente!";
        try {
            if (documentoComiteAATId != null) {
                RequestTraerDocumentoComite requestTraerDocumentoComite = new RequestTraerDocumentoComite();
                requestTraerDocumentoComite.setIdDocumentoComite(documentoComiteAATId.longValue());
                ResponseTraerDocumentoComite responseTraerDocumentoComite = asistenciaTecnicaServicio.getDocumento(requestTraerDocumentoComite);
                documentoDTO = responseTraerDocumentoComite.getDocumentoDTO();
            } else {
                documentoDTO = new DocumentosDTO();
                RequestTraerEmprendimiento requestTraerEmprendimiento = new RequestTraerEmprendimiento();
                requestTraerEmprendimiento.setIdEmprendimiento(emprendimientoId.longValue());
                ResponseTraerEmprendimiento responseTraerEmprendimiento = asistenciaTecnicaServicio.getEmprendimiento(requestTraerEmprendimiento);
                documentoDTO.setEmprendimiento(responseTraerEmprendimiento.getEmprendimientoDTO());

                RequestGetBeneficiarioXId requestGetBeneficiarioXId = new RequestGetBeneficiarioXId();
                requestGetBeneficiarioXId.setIdBeneficiario(idBeneficiario.longValue());
                ResponseGetBeneficiarioXId responseGetBeneficiarioXId = beneficiarioServicio.getBeneficiarioXId(requestGetBeneficiarioXId);
                documentoDTO.setBeneficiario(responseGetBeneficiarioXId.getBeneficiario());

                RequestTipoDocumento requestTipoDocumento = new RequestTipoDocumento();
                requestTipoDocumento.setIdtipodocumento(new BigDecimal(1));
                ResponseTipoDocumento responseTipoDocumento = asistenciaTecnicaServicio.getTipoDocumento(requestTipoDocumento);
                documentoDTO.setTipodocumentos(responseTipoDocumento.getTipoDocumentosDTO());
            }
            documentoDTO.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            documentoDTO.setUrlarchivo(documentoComiteAAT.getOriginalFilename());

            RequestGuardarDocumento requestGuardarDocumento = new RequestGuardarDocumento();
            requestGuardarDocumento.setDocumento(documentoDTO);
            ResponseGuardarDocumento responseGuardarDocumento = asistenciaTecnicaServicio.guardarDocumento(requestGuardarDocumento);
            if ("1".equals(responseGuardarDocumento.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(responseGuardarDocumento.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(responseGuardarDocumento.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
            if ("1".equals(responseGuardarDocumento.getStatus())) {
                String pathRoot = env.getProperty("root.path.files.emprendimiento") + env.getProperty("delimiter.path")
                        + env.getProperty("path.files.documentos.comite.aat") + env.getProperty("delimiter.path")
                        + responseGuardarDocumento.getIdDocumento() + env.getProperty("delimiter.path");

                File carpetaTema = new File(pathRoot);
                carpetaTema.mkdirs();

                deleteFiles(pathRoot);
                writeBytesToFile(documentoComiteAAT.getBytes(), pathRoot + documentoComiteAAT.getOriginalFilename());
            }

            respuesta = "0".equals(responseGuardarDocumento.getStatus()) ? responseGuardarDocumento.getDescripcion() : respuesta;
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        model.addAttribute("mensaje", respuesta);
        return "adjuntarDocumentoAAT";
    }

    /**
     * Metodo que elimina un documento de comite
     *
     * @param idDocumentoComite El id del documento de comité
     * @param principal El usuario en sesión
     * @return Respuesta si se eliminó el documento o no
     */
    @PostMapping(path = "/eliminarDocumentoComiteAAT")
    @ResponseBody
    public ResponseEntity<String> eliminarDocumentoComiteAAT(@RequestParam(name = "idDocumentoComite") BigDecimal idDocumentoComite,
            Principal principal) {
        RequestEliminarDocumento request = new RequestEliminarDocumento();
        request.setIdDocumento(idDocumentoComite);
        ResponseEliminarDocumento response = asistenciaTecnicaServicio.deleteDocumento(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return new ResponseEntity<>(response.getStatus(), HttpStatus.OK);
    }

    /**
     * Controlador encargado mostrar la vista correspondiente a la funcionalidad
     * Programar Sesion Acompañamiento y Asistencia Técnica.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador de la Caja de Compensación
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosProgramarSesionAAT")
    public String cargarDatosProgramarSesionAAT(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        if (idfuncionario == null || idcajacompensacion == null) {

            List<FuncionarioDTO> sensibilizadores = null;
            List<GestionarFuncionarioDTO> cajasDTO = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Verifico si es administrador (El usuario Administrador no es funcionario).
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosProgramarSesionAAT");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "programarSesionAAT";
    }

    /**
     * Controlador encargado mostrar la vista correspondiente a la funcionalidad
     * Agendar Sesión Acompañamiento y Asistencia Técnica.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador Caja de Compensación
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosAgendarSesionAAT")
    public String cargarDatosAgendarSesionAAT(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) Long idcajacompensacion
    ) {

        if (idfuncionario == null) {

            List<FuncionarioDTO> sensibilizadores = null;
            List<GestionarFuncionarioDTO> cajasDTO = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Verifico si es administrador (El usuario Administrador no es funcionario).
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosAgendarSesionAAT");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 3 (Sensibilizador)            
            /*
             * Si no es sensibilizador, es Atencion CCF y debe seleccionar
             * alguno de los funcionarios sensibilizadores de la caja de
             * compensacion a la que pertenece.
             */
            for (GroupMembersDTO s : funcionario.getUsers().getGroupMemberses()) {
                if (s.getGroups().getId() == 2) {
                    sensibilizadores = funcionarioServicio
                            .getFuncionariosPorGrupoYCaja(grupo, funcionario.getCajacompensacion().getIdcajacompensacion())
                            .getFuncionariosDTO();

                    model.addAttribute("sensibilizadores", sensibilizadores);
                    model.addAttribute("cajaN", funcionario.getCajacompensacion().getNombrecajacompensacion());
                    model.addAttribute("cajaID", funcionario.getCajacompensacion().getIdcajacompensacion());
                    model.addAttribute("url", "/cargarDatosAgendarSesionAAT");
                    model.addAttribute("grupo", grupo.intValue());
                    return "setIdFuncionario";
                }
            }

            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion().longValue();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "agendarSesionAAT";
    }

    /**
     * Controlador encargado mostrar la vista correspondiente a la funcionalidad
     * Consultar Avance.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador de la Caja de Compensación
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosConsultarAvancesAAT")
    public String cargarDatosConsultarAvancesAAT(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) Long idcajacompensacion
    ) {

        if (idfuncionario == null) {
            BeneficiarioDTO beneficiario = beneficiarioServicio.getBeneficiarioPorCorreo(
                    principal.getName()).getBeneficiario();

            List<GestionarFuncionarioDTO> cajasDTO;
            //Verifico si es un beneficiario.
            if (beneficiario != null) {
                RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName = new RequestTraerAsociadoPorUserName();
                requestTraerAsociadoPorUserName.setUserName(principal.getName());
                requestTraerAsociadoPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
                ResponseTraerAsociadoPorUserName responseTraerAsociadoPorUserName = asociadosServicio.getAsociado(requestTraerAsociadoPorUserName);
                EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
                if (responseTraerAsociadoPorUserName.getAsociadoDTO() != null) {
                    emprendimiento = responseTraerAsociadoPorUserName.getAsociadoDTO().getEmprendimiento();
                    RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
                    requestTraerTemasRutaAAT.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
                    ResponseTraerListaTemasRutaAAT responseTraerListaTemasRutaAAT = asistenciaTecnicaServicio.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
                    List<TemasrutaacompanamientoatDTO> temasRutaAATT = responseTraerListaTemasRutaAAT.getTemasRutaAATDTO();
                    Iterator itTemasRutaAAT = temasRutaAATT.iterator();
                    float porcentajeRealTemasAAT = 0;
                    while (itTemasRutaAAT.hasNext()) {
                        TemasrutaacompanamientoatDTO temasRutaAATDTO = (TemasrutaacompanamientoatDTO) itTemasRutaAAT.next();
                        float porcentajeTmp = (temasRutaAATDTO.getCantidadHorasEjecutadas() * 100) / temasRutaAATDTO.getCantidadhorasplaneadas().floatValue();
                        porcentajeRealTemasAAT += porcentajeTmp;
                    }

                    if (temasRutaAATT.size() > 0) {
                        porcentajeRealTemasAAT = porcentajeRealTemasAAT / temasRutaAATT.size();
                    } else {
                        porcentajeRealTemasAAT = 0;
                    }

                    RequestAsociadosPorEmprendimiento requestAsociadosPorEmprendimiento = new RequestAsociadosPorEmprendimiento();
                    requestAsociadosPorEmprendimiento.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
                    ResponseAsociadosPorEmprendimiento responseBeneficiarios = asociadosServicio.getAsociadosPorEmprendimiento(requestAsociadosPorEmprendimiento);
                    List<BeneficiarioAATDTO> beneficiarios = responseBeneficiarios.getBeneficiarios();
                    model.addAttribute("status", "beneficiario");
                    model.addAttribute("permiteAprobar", "0");
                    model.addAttribute("emprendimiento", emprendimiento);
                    model.addAttribute("temasRutasAAT", responseTraerListaTemasRutaAAT.getTemasRutaAATDTO());
                    model.addAttribute("beneficiarios", beneficiarios);
                    model.addAttribute("porcentajeRealTemasAAT", porcentajeRealTemasAAT);
                    return "consultarAvanceAAT";
                } else {
                    model.addAttribute("status", "nada");
                    model.addAttribute("mensaje", "El beneficiario no tiene un emprendimiento activo");
                    return "consultarAvanceAAT";
                }
            }

            List<FuncionarioDTO> sensibilizadores = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Verifico si es administrador (El usuario Administrador no es funcionario).
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosConsultarAvancesAAT");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion().longValue();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "consultarAvanceAAT";
    }

    /**
     * Controlador encargado liberar una sesión de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param idSesion Identificador de la Sesión
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @GetMapping(path = "/liberarSesionAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO liberarSesionAAT(@RequestParam("idSesion") long idSesion, Principal principal
    ) {
        Sesionacompanamientoat s = new Sesionacompanamientoat();
        s.setIdsesionacompanamientoat(idSesion);
        ResponseDTO response = new ResponseDTO();
        response = asistenciaTecnicaServicio.liberarSesiones(s);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idSesion);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    @GetMapping(path = "/getAsistentesSesionAAT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseAsistentesSesionAAT getAsistentesSesionAAT(@RequestParam("idsesion") long idsesion) {
        return listaasistenciaaatServicio.getLista(idsesion);
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idfuncionario El id del funcionario
     * @param idcajacompensacion El id de la caja de compensación
     * @return Url vista dependiendo del tipo de usuario
     */
    @RequestMapping(path = "/cargarDatosRegistrarSesionAAT")
    public String cargarDatosRegistrarSesionAAT(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) Long idcajacompensacion
    ) {

        if (idfuncionario == null) {

            List<FuncionarioDTO> sensibilizadores = null;
            List<GestionarFuncionarioDTO> cajasDTO = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Verifico si es administrador (El usuario Administrador no es funcionario).
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosRegistrarSesionAAT");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion().longValue();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "registrarSesionAAT";
    }
}

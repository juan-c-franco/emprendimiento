package com.growdata.emprendimiento.web.controlador;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestEmprendimientoPorDocEstados;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinanciera;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerTiposFinanciacion;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseEvaluacionintegrantescomite;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseGetEmprendimientoCompleto;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerSesionesComite;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerTiposFinanciacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.DTOSesiones;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestAsociarBeneficiariosValoracion;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesioncomiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;
import java.math.BigDecimal;
import java.security.Principal;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;

import com.growdata.emprendimiento.business.servicio.ComiteEvaluacionServicio;
import com.growdata.emprendimiento.business.servicio.ConfiguracionServicio;

import com.growdata.emprendimiento.business.servicio.EntidadesFinancierasServicio;
import com.growdata.emprendimiento.business.servicio.EvaluacionIntegrantesComiteServicio;
import com.growdata.emprendimiento.business.servicio.EvaluacionemprendimientosServicio;

import com.growdata.emprendimiento.business.servicio.FinanciacionServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.SesionesComiteServicio;
import com.growdata.emprendimiento.business.servicio.TipoFinanciacionServicio;

import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;

import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Franco
 */
@Controller
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class ControladorEvaluacionFinanciacion {

    private final BigDecimal grupo = new BigDecimal(10);
    private final BigDecimal grupoFinanciero = new BigDecimal(10);
    private final BigDecimal grupoLiderComite = new BigDecimal(6);
    private final int estadoEmprendimientoParaAgendarSesionComite = 4;

    @Autowired
    private Environment env;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;

    @Autowired
    private BeneficiarioServicio beneficiarioServicio;

    @Autowired
    private SesionesServicio sesionesServicio;

    @Autowired
    private ListaAsistenciaServicio listaAsistenciaServicio;

    @Autowired
    private EmprendimientoServicio emprendimientoServicio;

    @Autowired
    private TipoFinanciacionServicio tipoFinanciacionServicio;

    @Autowired
    private FinanciacionServicio financiacionServicio;

    @Autowired
    private SesionesComiteServicio sesionesComiteServicio;

    @Autowired
    private ComiteEvaluacionServicio comiteEvaluacionServicio;

    @Autowired
    private EntidadesFinancierasServicio entidadesFinancierasServicio;

    @Autowired
    private EvaluacionIntegrantesComiteServicio evaluacionIntegrantesComiteServicio;

    @Autowired
    private EvaluacionemprendimientosServicio evaluacionEmprendimientosServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;

    @Autowired
    private ConfiguracionServicio configuracionServicio;

    private String modulo = "Evaluación y Financiación";

    /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso 
     * Programar Sesión de Evaluación y Financiamiento.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador de la Caja de Compensación
     * @return Url vista.
     */
    @RequestMapping("/programarEvaluacionFinanciacion")
    public String programarEvaluacionFinanciacion(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        if (idfuncionario == null || idcajacompensacion == null) {

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
                model.addAttribute("url", "/programarEvaluacionFinanciacion");
                model.addAttribute("grupo", grupoFinanciero.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        return "programarEvaluacionFinanciacionView";

    }

    /**
     * Controlador encargado de mostrar la vista en donde se seleccionan los beneficiarios a ser
     * agendados en una sesión de Evaluación.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador de la Caja de Compensación
     * correspondiente al funcionario
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosSesionEvaluacion")
    public String cargarDatosSesionEvaluacion(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        if (idfuncionario == null || idcajacompensacion == null) {

            List<FuncionarioDTO> valoradores = null;
            List<GestionarFuncionarioDTO> cajasDTO;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Si no es beneficiario y no es funcionario, es administrador.
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosSesionEvaluacion");
                model.addAttribute("grupo", grupoFinanciero.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            /*
             * Si no es valorador, es Atencion CCF y debe seleccionar alguno de
             * los funcionarios funcionarios de la caja de compensacion a la que
             * pertenece.
             */
            for (GroupMembersDTO s : funcionario.getUsers().getGroupMemberses()) {
                //Soy algo diferente a valorador.
                if (s.getGroups().getId() == 2) {
                    valoradores = funcionarioServicio
                            .getFuncionariosPorGrupoYCaja(grupoFinanciero, funcionario.getCajacompensacion().getIdcajacompensacion())
                            .getFuncionariosDTO();

                    model.addAttribute("sensibilizadores", valoradores);
                    model.addAttribute("cajaN", funcionario.getCajacompensacion().getNombrecajacompensacion());
                    model.addAttribute("cajaID", funcionario.getCajacompensacion().getIdcajacompensacion());
                    model.addAttribute("url", "/cargarDatosSesionValoracion");
                    model.addAttribute("grupo", grupoFinanciero.intValue());
                    return "setIdFuncionario";
                }
            }

            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "consultarBeneficiarioEvaluacion";
    }

    /**
     * Controlador encargado de ubicar los emprendimientos que cumplan con los 
     * parámetros de búsqueda.
     *
     * @param documento Número de Documento al que deben tener un Beneficiario
     * Asociado
     * @param strEstados Lista de Estados en los que puede estar el
     * Emprendimiento.
     * @param idcajacompensacion Identificador de la caja de compensación a la
     * que deben estar vinculados.
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Emprendimientos que cumplen con los criterios de búsqueda.
     */
    @GetMapping(path = "/getEmprendimientoXDOC", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoXDOC(
            @RequestParam("documento") String documento,
            @RequestParam("estados") String strEstados,
            @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion) {
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        List<String> estados = new Gson().fromJson(strEstados, List.class);
        request.setDoc(documento);
        request.setEstados(estados);
        request.setIdcajacompensacion(idcajacompensacion);
        return emprendimientoServicio.getEmprendimientoPorDoc(request);
    }

    /**
     * Controlador encargado de ubicar los Emprendimientos vinculados a una sesión comité.
     *
     * @param idSesionComite Identificador de la sesión comité
     * @param idcajacompensacion Identificador de la caja de compensación
     * @return Respuesta si fue exitoso o no el proceso
     */
    @GetMapping(path = "/getEmprendimientosComite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComite(
            @RequestParam(name = "idSesionComite", required = false) Long idSesionComite,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        long id = -1;
        if (idSesionComite != null) {
            id = idSesionComite;
        }
        return emprendimientoServicio.getEmprendimientosComite(id,
                estadoEmprendimientoParaAgendarSesionComite, idcajacompensacion);
    }

    /**
     * Controlador encargado de ubicar los emprendimientos vinculados a una 
     * sesión comité.
     *
     * @param idSesionComite Identificador Sesión Comité
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Emmprendimientos que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getEmprendimientosComitePorIdSesion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComitePorIdSesion(
            @RequestParam(name = "idSesionComite") Long idSesionComite) {

        return emprendimientoServicio.getEmprendimientosComitePorIdSesion(idSesionComite, estadoEmprendimientoParaAgendarSesionComite);
    }

    /**
     * Controlador encargado de ubicar los emprendimientos que cumplan con los criterios. de búsqueda.
     *
     * @param strEstados Lista de Estados en los que puede estar el
     * Emprendimiento
     * @param idcajacompensacion Identificador de la caja de compensación a la
     * que deben estar vinulados los emprendimientos.
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de
     * Emprendimientos} que cumplan con la búsqueda.
     */
    @GetMapping(path = "/getEmprendimientosSeguimiento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientosSeguimiento(
            @RequestParam("estados") String strEstados, @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion) {
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        List<String> estados = new Gson().fromJson(strEstados, List.class);
        request.setEstados(estados);
        request.setIdcajacompensacion(idcajacompensacion);
        return emprendimientoServicio.getEmprendimientoPorEdo(request);
    }

    /**
     * Controlador encargado de ubicar las sesiones comité vinculadas a un 
     * Funcionario.
     *
     * @param idFuncionario Identificador del Funcionario.
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de sesiones
     * que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getSesionesComitePorFuncionario",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesionesComite getSesionesComitePorFuncionario(
            @RequestParam("idFuncionario") long idFuncionario) {
        return sesionesComiteServicio.getSesionesFuncionario(idFuncionario, null, new Date(), 1);
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id de el funcionario
     * @return Url vista dependiendo del tipo de usuario
     */
    @RequestMapping("/registrarAsistenciaEvaluacion")
    public String registrarAsistenciaEvaluacion(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        if (idfuncionario == null) {

            List<FuncionarioDTO> valoradores = null;
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
                model.addAttribute("url", "/registrarAsistenciaEvaluacion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();

        }
        ResponseTraerSesiones response = sesionesServicio.getSesionesPorFuncionario(idfuncionario);
        List<SesionesDTO> sesiones = new ArrayList();
        String mensaje;
        String status;
        sesiones = response.getSesiones();
        status = response.getStatus();
        mensaje = response.getDescripcion();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("sesiones", sesiones);
        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        return "registrarAsistenciaE";
    }

    /**
     * Metodo que trae los asistentes a una sesion de evaluacion basandose en el
     * id de la sesion
     *
     * @param idfuncionario El id del funcionario
     * @param idsesion El id de la sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("/traerAsistentesE")
    public String traerAsistentesE(@RequestParam("idfuncionario") int idfuncionario,
            @RequestParam("idsesion") int idsesion,
            Model model
    //            @RequestParam("idestadosesion") long idestadosesion, Model model
    ) {

        //traigo los asistentes
        RequestTraerAsistentes request = new RequestTraerAsistentes();
        request.setIdsesion(idsesion);
        ResponseTraerAsistentes response = new ResponseTraerAsistentes();
        response = listaAsistenciaServicio.getLista(request);
        List<ListaasistenciaDTO> listaAsistencia = response.getAsistenciaDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        //Traigo el emprendimiento
        if (listaAsistencia.size() > 0) {
            ResponseTraerEmprendimientoPorNombre response2 = new ResponseTraerEmprendimientoPorNombre();
            RequestEmprendimientoPorDocEstados request2 = new RequestEmprendimientoPorDocEstados();
            List<String> estados = new ArrayList<>();
            estados.add("4");
            estados.add("3");
            estados.add("10");
            request2.setEstados(estados);
            request2.setDoc(listaAsistencia.get(0).getBeneficiario().getNumerodocumento());
            response2 = emprendimientoServicio.getEmprendimientoPorDoc(request2);
            model.addAttribute("emprendimiento", response2.getEmprendimientos().get(0));

        }

        //agrego los asistentes al modelo
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("listaAsistencia", listaAsistencia);
        model.addAttribute("idsesion", idsesion);

        return "registrarAsistencia2E";
    }

    /**
     * Metodo que registra las asistencias de una sesion
     *
     * @param idfuncionario El id del funcionario
     * @param asisten Contiene el id de las asistencia y su valor
     * @param idsesion El id de la sesión
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @RequestMapping("/registroAsistenciasE")
    public String registroAsistentesE(@RequestParam("idfuncionario") long idfuncionario,
            @RequestParam("asist") String asisten,
            @RequestParam("idsesion") long idsesion, Model model, Principal principal) {
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
        List<AsistenciasValor> asistencias = new ArrayList<>();
        if (asisten != null) {
            System.out.println(asisten);
            asisten = asisten.replace("[{", "{");
            asisten = asisten.replace("}]", "}");
            System.out.println("Despues del replace--->" + asisten);
            JSONObject obj = new JSONObject(asisten);

            JSONArray arr = obj.getJSONArray("Beneficiario");
            JSONArray arr2 = obj.getJSONArray("valor");
            for (int i = 0; i < arr.length(); i++) {
                AsistenciasValor a = new AsistenciasValor();
                a.setIdasistencia(arr.getInt(i));
                String g = arr2.getString(i);
                a.setValor(g.charAt(0));
                asistencias.add(a);
            }
        }
        request.setIdfuncionario(idfuncionario);
        request.setIdsesion(idsesion);
        request.setAsistencias(asistencias);
        response = listaAsistenciaServicio.registroAsistenciasE(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idsesion);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        //agrego el resultado al modelo
        model.addAttribute("mensajeTitulo", "Registro de Asistencia");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "confirmar";
    }

    /**
     * Controlador encargado mostrar la vista correspondiente a la funcionalidad 
     * Agendar Sesión de Evaluación y Financiamiento.
     *
     * @return url vista
     */
    @GetMapping("/agendarSesionEvaluacion")
    public ModelAndView agendarSesionEvaluacion() {
        ModelAndView view = new ModelAndView("agendarSesionEvaluacionView");
        return view;
    }

    /**
     * Controlador encargado de asociar a un beneficiario a una sesión de tipo: 
     * Evaluacion y Financiación, o Puesta en Marcha y Seguimiento.
     *
     * @param strRequest Contiene los datos de la sesión y los beneficiarios a
     * asociar
     * @param principal Contiene los datos de la sesion de Spring Security
     * @return Respuesta si fue exitoso o no el cambio.
     */
    @PostMapping(path = "/asociarBeneficiariosEvaluacionSeguimiento")
    @ResponseBody
    public ResponseAsociarBeneficiarioSesion asociarBeneficiariosEvaluacionSeguimiento(
            @RequestParam("requestEmp") String strRequest, Principal principal
    ) {
        RequestAsociarBeneficiariosValoracion request = new RequestAsociarBeneficiariosValoracion();
        ResponseAsociarBeneficiarioSesion response = new ResponseAsociarBeneficiarioSesion();
        try {
            request = new Gson().fromJson(strRequest, RequestAsociarBeneficiariosValoracion.class);
            response = listaAsistenciaServicio.asociarBeneficiarioEvaluacionSeguimiento(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(response.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (JsonSyntaxException e) {
            response.setStatus("0");
            response.setDescripcion(e.getMessage());
        }
        return response;
    }

    /**
     * Controlador encargado de cargar la vista para seleccionar los 
     * emprendimientos a ser revisados durante una sesion comite que se desea programar.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idcajacompensacion Id Caja de Compensación
     * @param idfuncionario Id Funcionario
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosSesionComiteEvaluacion")
    public String cargarDatosSesionComiteEvaluacion(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {

        if (idfuncionario == null) {

            List<GestionarFuncionarioDTO> cajasDTO;

            List<FuncionarioDTO> valoradores = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Si no es beneficiario y no es funcionario, es administrador.
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosSesionComiteEvaluacion");
                model.addAttribute("grupo", grupoLiderComite.intValue());
                return "setIdFuncionario";
            }

            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        return "consultarEmprendimientosEvaluacionComite";
    }

    /**
     * Controlador encargado de ubicar las sesiones comité de determinado funcionario.
     *
     * @param idFuncionario Id Funcionario
     * @param todas Parámetro de control que indica si ubican todas las sesiones
     * o solo Disponibles.
     * @return Respuestá si fue exitósa o no la búsqueda.
     */
    @GetMapping(path = "/cargarSesionesComite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesionesComite cargarSesionesComite(
            @RequestParam(name = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(name = "todas") int todas) {
        long id = -1;
        if (idFuncionario != null) {
            id = idFuncionario;
        }
        Date desde = null;
        if (todas == 1) {
            desde = new Date();
        }
        return sesionesComiteServicio.getSesionesFuncionario(id, desde, null, todas);
    }

    /**
     * Metodo que trae las sesiones de un funcionario en base a su id
     *
     * @param idFuncionario El id del funcionario
     * @param todas Entero que define desde que fecha se traen las sesiones
     * @return Lista de sesiones
     */
    @GetMapping(path = "/cargarSesionesComiteIndividual", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesionesComite cargarSesionesComiteIndividual(
            @RequestParam(name = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(name = "todas") int todas) {
        long id = -1;
        if (idFuncionario != null) {
            id = idFuncionario;
        }
        Date desde = null;
        if (todas == 1) {
            desde = new Date();
        }
        ResponseTraerSesionesComite response = new ResponseTraerSesionesComite();

        response = sesionesComiteServicio.getSesionesFuncionarioComite(id, desde, null, todas);

        return response;
    }

    /**
     * Controlador encargado de mostrar la vista con la disponibilidad de Agenda 
     * de determinado Lider de Comité.
     *
     * @return Vista
     */
    @GetMapping("/consultarAgendaLiderComite")
    public ModelAndView consultarAgendaLiderComite() {
        ModelAndView view = new ModelAndView("consultarAgendaLiderComiteView");
        return view;
    }

    /**
     * Controlador encargado de crear una nueva Sesión Comité.
     *
     * @param fechaInicial Fecha de Inicio de Sesión
     * @param fechaFinal Fecha Fin de Sesión
     * @param idFuncionario Identificador de Funcionario que creó la sesión
     * @param ubicacion Ubicación de la Sesión Comité
     * @param principal Sesión de Spring Security
     * @param strEmprendimientos Lista de Emprendimentos a ser vinculados en la
     * Sesión Comité
     * @return Respuesta si fue o no exitóso el cambio.
     */
    @PostMapping(path = "/guardarSesionComite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO guardarSesionComite(
            @RequestParam("fechaInicial") String fechaInicial, @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("ubicacion") String ubicacion, Principal principal,
            @RequestParam("strEmprendimientos") String strEmprendimientos) {
        ResponseDTO response = new ResponseDTO();
        try {
            List<String> emprendimientos = new Gson().fromJson(strEmprendimientos, List.class);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            ResponseComiteEvaluacion response2 = comiteEvaluacionServicio.getComitePorIdFuncionario(idFuncionario);
            if ("0".equals(response2.getStatus()) || response2.getComite() == null) {
                return response2;
            }

            Sesioncomite sesion = new Sesioncomite(-1, response2.getComite(), new Estadosesion(new BigDecimal(4)),
                    new Funcionario(idFuncionario), new Timestamp(simple.parse(fechaInicial).getTime()),
                    new Timestamp(simple.parse(fechaFinal).getTime()), new Timestamp(new Date(System.currentTimeMillis()).getTime()),
                    null, ubicacion);

            response = sesionesComiteServicio.saveSesiones(sesion, emprendimientos);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(response.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (ParseException e) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_FECHA_HORA);

        }
        return response;
    }

    /**
     * Controlador encargado de cancelar una Sesión Comité.
     *
     * @param idSesion Identificador de la Sesión Comité a cancelar.
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/eliminarSesionComite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO eliminarSesionComite(@RequestParam("idSesion") long idSesion, Principal principal
    ) {
        Sesioncomite s = new Sesioncomite();
        s.setIdsesioncomite(idSesion);
        ResponseDTO response = new ResponseDTO();
        response = sesionesComiteServicio.deleteSesiones(s);
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

    /**
     * Controlador encargado de actualizar una Sesiòn Comité.
     *
     * @param sesionDto Datos de la sesion a actualizar
     * @param principal Sesion Spring Security
     * @return Respuesta si fue exitoso o no el cambio
     */
    @PutMapping(path = "/actualizarSesionComite")
    @ResponseBody
    public ResponseDTO actualizarSesionComite(@RequestBody DTOSesiones sesionDto, Principal principal) {
        Sesioncomite sesion = new Sesioncomite();
        sesion.setIdsesioncomite(sesionDto.getIdSesion());
        sesion.setEstadosesion(new Estadosesion(sesionDto.getIdestadosesion()));
        sesion.setFuncionario(new Funcionario(sesionDto.getIdfuncionario()));
        sesion.setFechainicio(sesionDto.getFechaInicio());
        sesion.setFechafinal(sesionDto.getFechaFin());
        ResponseDTO response = new ResponseDTO();
        response = sesionesComiteServicio.updateSesiones(sesion);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(sesionDto.getIdSesion());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Metodo que trae un emprendimiento en base a su nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorNombreF")
    public String getEmprendimientoPorNombreF(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        request.setIdcajacompensacion(idcajacompensacion);
        setEstados.add("3");
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());
        return "registroFinancieroAdmin1";
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento de un
     * beneficiario
     *
     * @param documento El documento del beneficario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compenación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorDocF")
    public String getEmprendimientoPorDocF(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        request.setIdcajacompensacion(idcajacompensacion);
        List<String> setEstados = new ArrayList();
        setEstados.add("3");

        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());

        return "registroFinancieroAdmin1";
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return url vista dependiendo del tipo de usuario
     */
    @RequestMapping("/infoFinancieraBasica")
    public String infoFinancieraBasica(Model model, Principal principal, @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        if (idfuncionario == null) {

            List<FuncionarioDTO> valoradores = null;
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
                model.addAttribute("url", "/infoFinancieraBasica");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        model.addAttribute("idFuncionario", idfuncionario);

        return "registroFinancieroAdmin1";
    }

    /**
     * Metodo que muestra la vista de registro de informacion financiera basica,
     * si el emprendimiento ya tiene informacion financiera la trae
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param idFuncionario El id del funciario
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registrarInfoFinancieraBasica")
    public String registrarInfoFinancieraBasica(@RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("idFuncionario") long idFuncionario, Model model
    ) {

        //Miro si ya tiene financiacion los emprendimientos
        ResponseTraerInfoFinancieraBasica response2 = new ResponseTraerInfoFinancieraBasica();
        RequestTraerInfoFinancieraBasica request2 = new RequestTraerInfoFinancieraBasica();
        request2.setIdEmprendimiento(idEmprendimiento);
        response2 = financiacionServicio.getInfoFinancieraBasicaPorId(request2);
        if ("1".equals(response2.getStatus())) {
            model.addAttribute("financiacion", response2.getFinanciacionDTO());
        }
        //Traigo los tipos de financiacion
        RequestTraerTiposFinanciacion request = new RequestTraerTiposFinanciacion();
        ResponseTraerTiposFinanciacion response = tipoFinanciacionServicio.getTiposFinanciacion(request);
        model.addAttribute("tiposFinanciacion", response.getTiposFinanciacionDTO());
        model.addAttribute("idFuncionario", idFuncionario);
        model.addAttribute("idEmprendimiento", idEmprendimiento);
        return "registroInfoFinancieraBasica";
    }

    /**
     * Metodo que registra la informacion financiera basica de un emprendimiento
     *
     * @param Aprobado Estado de aprobación del emprendimiento
     * @param idEmprendimiento el id del emprendimiento
     * @param idFuncionario El id del funcionario
     * @param idtipofinanciacion El id del tipo de financiación
     * @param montofinanciacions El monto de financiación
     * @param cuotaspactadasS Las cuotas pactadas
     * @param tasaintertess La tasa de interés
     * @param recursospropiosae Los recursos propios
     * @param empleosporgenerar Los empleos por generar
     * @param capitaltotal El capital total
     * @param capitaltrabajo El capital de trabajo
     * @param mesespuntoequilibrio Los meses para el punto de equilibrio
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/registroInfoFinancieraBasica")
    public String registroInfoFinancieraBasica(@RequestParam("Aprobado") String Aprobado,
            @RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idtipofinanciacion") String idtipofinanciacion,
            @RequestParam("montofinanciacions") Long montofinanciacions,
            @RequestParam("cuotaspactadasS") String cuotaspactadasS,
            @RequestParam("tasaintertess") String tasaintertess,
            @RequestParam("recursospropiosae") long recursospropiosae,
            @RequestParam("empleosporgenerar") String empleosporgenerar,
            @RequestParam("capitaltotal") long capitaltotal,
            @RequestParam("capitaltrabajo") long capitaltrabajo,
            @RequestParam("mesespuntoequilibrio") String mesespuntoequilibrio, Model model, Principal principal
    ) {
        RequestRegistrarInfoFinancieraBasica request = new RequestRegistrarInfoFinancieraBasica();
        request.setAprobado(Aprobado);
        request.setCapitaltotal(capitaltotal);
        request.setCapitaltrabajo(capitaltrabajo);
        request.setCuotaspactadasS(new BigDecimal(cuotaspactadasS));
        request.setEmpleosporgenerar(new BigDecimal(empleosporgenerar));
        request.setIdEmprendimiento(idEmprendimiento);
        request.setIdFuncionario(idFuncionario);
        request.setIdtipofinanciacion(new BigDecimal(idtipofinanciacion));
        request.setMesespuntoequilibrio(new BigDecimal(mesespuntoequilibrio));
        request.setMontofinanciacions(montofinanciacions);
        request.setRecursospropiosae(recursospropiosae);
        request.setTasaintertess(new BigDecimal(tasaintertess));
        ResponseRegistrarInfoFinancieraBasica response = new ResponseRegistrarInfoFinancieraBasica();
        response = financiacionServicio.guardarInfoFinancieraBasica(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Registro de Información Financiera Básica");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);

        return "confirmar";
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion EL id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @RequestMapping("/infoFinanciera")
    public String infoFinanciera(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        if (idfuncionario == null) {

            List<FuncionarioDTO> valoradores = null;
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
                model.addAttribute("url", "/infoFinanciera");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();

        }
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        model.addAttribute("idFuncionario", idfuncionario);

        return "registroFinancieroAdmin";
    }

    /**
     * Metodo que trae un emprendimiento en base a su nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorNombreF2")
    public String getEmprendimientoPorNombreF2(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        request.setIdcajacompensacion(idcajacompensacion);
        setEstados.add("6");
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());
        return "registroFinancieroAdmin";
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento de un
     * beneficiario
     *
     * @param documento El documento del beneficiario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorDocF2")
    public String getEmprendimientoPorDocF2(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());

        return "registroFinancieroAdmin";
    }

    /**
     * Metodo que trae un emprendimiento en base a su id
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorIdF")
    public String getEmprendimientoPorIdF(@RequestParam("idEmprendimiento") long idEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        ResponseTraerEmprendimientoPorId response = new ResponseTraerEmprendimientoPorId();
        RequestTraerEmprendimientoPorId request = new RequestTraerEmprendimientoPorId();
        request.setIdEmprendimiento(idEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");

        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorId(request);
        EmprendimientoDTO emprendimiento = response.getEmprendimiento();
        List<EmprendimientoDTO> emprendimientos = new ArrayList();
        emprendimientos.add(emprendimiento);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", emprendimientos);

        return "registroFinancieroAdmin";
    }

    /**
     * Metodo que muestra la vista de registro de informacion financiera, si el
     * emprendimiento ya tiene informacion financiera la trae
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param idFuncionario El id del funcionario
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registrarInfoFinanciera")
    public String registrarInfoFinanciera(@RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("idFuncionario") long idFuncionario, Model model
    ) {

        //Miro si ya tiene financiacion los emprendimientos
        ResponseTraerInfoFinancieraBasica response2 = new ResponseTraerInfoFinancieraBasica();
        RequestTraerInfoFinancieraBasica request2 = new RequestTraerInfoFinancieraBasica();
        request2.setIdEmprendimiento(idEmprendimiento);
        response2 = financiacionServicio.getInfoFinancieraPorId(request2);
        if ("1".equals(response2.getStatus())) {
            model.addAttribute("financiacion", response2.getFinanciacionDTO());
        }
        //Traigo las entidades financieras 
        RequestTraerEntidadesFinancieras request3 = new RequestTraerEntidadesFinancieras();
        ResponseTraerEntidadesFinancieras response3 = new ResponseTraerEntidadesFinancieras();
        response3 = entidadesFinancierasServicio.getEntidadesFinancieras(request3);
        //Traigo los tipos de financiacion
        RequestTraerTiposFinanciacion request = new RequestTraerTiposFinanciacion();
        ResponseTraerTiposFinanciacion response = tipoFinanciacionServicio.getTiposFinanciacion(request);
        model.addAttribute("entidadesFinancieras", response3.getEntidadesDTO());
        model.addAttribute("tiposFinanciacion", response.getTiposFinanciacionDTO());
        model.addAttribute("idFuncionario", idFuncionario);
        model.addAttribute("idEmprendimiento", idEmprendimiento);
        return "registroInfoFinanciera";
    }

    /**
     * Metodo que registra la informacion financiera de un emprendimiento
     *
     * @param idfinanciacion El id de la financiación
     * @param idEmprendimiento El id del emprendimiento
     * @param idFuncionario El id del funcionario
     * @param idtipofinanciacion El id del tipo de financiación
     * @param montoA El monto a financiar
     * @param cuotaspactadasa Las cuotas pactadas
     * @param tasainteresa La tasa de interés
     * @param identidadfinanciera El id de la entidad financiera
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/registroInfoFinanciera")
    public String registroInfoFinanciera(@RequestParam(name = "idfinanciacion", required = false) String idfinanciacion,
            @RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idtipofinanciacion") BigDecimal idtipofinanciacion,
            @RequestParam("montoA") String montoA,
            @RequestParam("cuotaspactadasa") String cuotaspactadasa,
            @RequestParam("tasainteresa") String tasainteresa,
            @RequestParam("identidadfinanciera") String identidadfinanciera,
            Principal principal,
            Model model
    ) {
        RequestRegistrarInfoFinanciera request = new RequestRegistrarInfoFinanciera();
        //Traigo informacion si la validacion de beneficios economicos esta activa o no
        ResponseConfiguraciones response4 = configuracionServicio.getConfiguracion(new BigDecimal(5));
        Entidadesfinancieras entidad = new Entidadesfinancieras();
        entidad.setIdentidadfinanciera(new BigDecimal(identidadfinanciera));
        request.setIdEmprendimiento(idEmprendimiento);
        request.setIdtipofinanciacion(idtipofinanciacion);
        request.setMontoa(Long.parseLong(montoA));
        request.setCuotaspactadasa(new BigDecimal(cuotaspactadasa));
        request.setTasainteresa(new BigDecimal(tasainteresa));
        request.setEntidadesfinancieras(entidad);
        request.setConfiguracion(response4.getConfiguracion());
        if (idfinanciacion != null && !"".equals(idfinanciacion)) {
            request.setIdfinanciacion(Long.parseLong(idfinanciacion));
        }
        ResponseRegistrarInfoFinancieraBasica response = new ResponseRegistrarInfoFinancieraBasica();
        response = financiacionServicio.guardarInfoFinanciera(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Registro de Información Financiera");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);

        return "confirmar";
    }

    @RequestMapping("/revisionYCalificacion")
    public String revisionYCalificacion(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "beneficiarios", required = false) List<BeneficiarioDTO> beneficiarios
    ) {
        String resp = "";
        List<FuncionarioDTO> funcionariosDTO = new ArrayList();

        List<GestionarFuncionarioDTO> cajasDTO = new ArrayList();
        RequestTraerFuncionarioPorUserName request5 = new RequestTraerFuncionarioPorUserName();
        if (idfuncionario != null && idcajacompensacion != null) {
            model.addAttribute("beneficiarios", beneficiarios);
            model.addAttribute("idfuncionario", idfuncionario);
            model.addAttribute("idcajacompensacion", idcajacompensacion);
            resp = "revisionYCalificacionAdmin";
        } else {
            if (idcajacompensacion != null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                BigDecimal grupoLocal = new BigDecimal(7);
                ResponseTraerFuncionarios response3 = new ResponseTraerFuncionarios();
                try {
                    response3 = funcionarioServicio.getFuncionariosPorGrupoYCaja(grupoLocal, idcajacompensacion);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorSensibilizacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                funcionariosDTO = response3.getFuncionariosDTO();
                model.addAttribute("funcionariosDTO", funcionariosDTO);
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("idcajacompensacion", idcajacompensacion);
                resp = "revisionYCalificacionAdmin";
            } else {
                request5.setUserName(principal.getName());
                request5.setIdEstado(BigDecimal.ONE);
                ResponseTraerFuncionarioPorUserName response5 = funcionarioServicio.getFuncionarioPorUserName(request5);
                FuncionarioDTO funcionario = response5.getFuncionarioDTO();
                if (response5.getFuncionarioDTO() != null) {
                    try {
                        idfuncionario = funcionario.getIdfuncionario();
                        idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
                        model.addAttribute("idfuncionario", idfuncionario);
                        model.addAttribute("idcajacompensacion", idcajacompensacion);
                        resp = "revisionYCalificacionAdmin";
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorSensibilizacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                    ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                    cajasDTO = response2.getFuncisDTO();
                    model.addAttribute("cajasDTO", cajasDTO);
                    resp = "revisionYCalificacionAdmin";
                }
            }

        }
        return resp;

    }

    /**
     * Metodo que trae un emprendimiento en base a su nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorNombreF3")
    public String getEmprendimientoPorNombreF3(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        request.setIdcajacompensacion(idcajacompensacion);
        setEstados.add("6");
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());
        return "revisionYCalificacionAdmin";
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento de un
     * beneficiario
     *
     * @param documento El documento del beneficiario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url Vista
     */
    @GetMapping("/getEmprendimientoPorDocF3")
    public String getEmprendimientoPorDocF3(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());

        return "revisionYCalificacionAdmin";
    }

    /**
     * Metodo que trae un emprendimiento en base a su id
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorIdF3")
    public String getEmprendimientoPorIdF3(@RequestParam("idEmprendimiento") long idEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {
        ResponseTraerEmprendimientoPorId response = new ResponseTraerEmprendimientoPorId();
        RequestTraerEmprendimientoPorId request = new RequestTraerEmprendimientoPorId();
        request.setIdEmprendimiento(idEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");

        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorId(request);
        EmprendimientoDTO emprendimiento = response.getEmprendimiento();
        List<EmprendimientoDTO> emprendimientos = new ArrayList();
        emprendimientos.add(emprendimiento);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", emprendimientos);

        return "revisionYCalificacionAdmin";
    }

    /**
     * Metodo que trae el emprendimiento a calificar basandose en su id y
     * muestra la vista de calificacion individual
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param idfuncionario El id del funcionario
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/calificarEmprendimiento")
    public String calificarEmprendimiento(@RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario, Model model
    ) {
        ResponseTraerEmprendimientoPorId response = new ResponseTraerEmprendimientoPorId();
        RequestTraerEmprendimientoPorId request = new RequestTraerEmprendimientoPorId();
        request.setIdEmprendimiento(idEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");

        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorId(request);
        EmprendimientoDTO emprendimiento = response.getEmprendimiento();

        String mensaje = response.getDescripcion();
        String status = response.getStatus();

        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", emprendimiento);

        return "calificacionIndividualEmprendimiento";
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista dependiendo el tipo de usuario
     */
    @RequestMapping("/cargarDatosCalificacionIndividual")
    public String cargarDatosCalificacionIndividual(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {

        if (idcajacompensacion == null || idfuncionario == null) {

            List<GestionarFuncionarioDTO> cajasDTO;

            List<FuncionarioDTO> valoradores = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Si no es beneficiario y no es funcionario, es administrador.
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosCalificacionIndividual");
                model.addAttribute("grupo", 7);
                return "setIdFuncionario";
            }

            //Si soy valorador debo ir directo a seleccionar beneficiario.
            model.addAttribute("url", "/cargarDatosCalificacionIndividual");
            model.addAttribute("idcajacompensacion", funcionario.getCajacompensacion().getIdcajacompensacion());
            model.addAttribute("idFuncionario", funcionario.getIdfuncionario());
            return "consultarSesionesComiteIndividual";

        }

        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idFuncionario", idfuncionario);
        return "consultarSesionesComiteIndividual";
    }

    /**
     * Controlador encargado de mostrar la vista en donde se muestran los 
     * emprendimientos para ser agendados en una Sesión Comité.
     *
     * @param idcajacompensacion Id caja de compensación
     * @param idfuncionario Id Funcionario
     * @param idSesionComite Id Sesión Comité
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/cargarEmprendimientosSesionComite")
    public String cargarEmprendimientosSesionComite(@RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam("idSesionComite") long idSesionComite, Model model) {

        ResponseTraerEmprendimientoPorNombre response = emprendimientoServicio.getEmprendimientosComite(idSesionComite, 4, idcajacompensacion);
        List<EmprendimientoDTO> emprendimientos = response.getEmprendimientos();
        model.addAttribute("emprendimientos", emprendimientos);
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        model.addAttribute("idFuncionario", idfuncionario);
        return "consultarEmprendimientosCalificacionIndividual";
    }

    /**
     * Controlador encargado de mostrar la vista correspondiente al Caso de Uso 
     * Calificación Definitiva.
     *
     * @param model Modelo JSP
     * @param principal Sesion Spring Security
     * @param idcajacompensacion Id de la Caja de Compensación
     * @param idfuncionario Id del Funcionario
     * @return Url de la vista
     */
    @RequestMapping(path = "/cargarDatosCalificacionDefinitiva")
    public String cargarDatosCalificacionDefinitiva(Model model, Principal principal,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
    ) {

        if (idcajacompensacion == null || idfuncionario == null) {
            BeneficiarioDTO beneficiario = beneficiarioServicio.getBeneficiarioPorCorreo(
                    principal.getName()).getBeneficiario();

            List<GestionarFuncionarioDTO> cajasDTO;

            List<FuncionarioDTO> valoradores = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Si no es beneficiario y no es funcionario, es administrador.
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosCalificacionDefinitiva");
                model.addAttribute("grupo", grupoLiderComite.intValue());
                return "setIdFuncionario";
            }

            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();

        }
        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idcajacompensacion", idcajacompensacion);
        return "consultarSesionesComite";
    }

    /**
     * Controlador encargado de mostrar vista correspondiente al caso de uso Calificación Definitiva.
     *
     * @return Vista
     */
    @GetMapping("/consultarEmpCalificacionDefinitiva")
    public ModelAndView consultarEmpCalificacionDefinitiva() {
        ModelAndView view = new ModelAndView("consultarEmprendimientosCalificacionDefinitiva");
        return view;
    }

    @GetMapping(path = "/getCalificacionesIntPorEmprendimiento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEvaluacionintegrantescomite getCalificacionesIntPorEmprendimiento(
            @RequestParam("idEmprendimiento") long idEmprendimiento
    ) {
        return evaluacionIntegrantesComiteServicio.getCalificacionesPorEmprendimiento(idEmprendimiento);
    }

    /**
     * Metodo que registra una calificacion individual de un emprendimiento
     *
     * @param model Modelo JSP
     * @param observaciones Las observaciones
     * @param calificacion La calificación
     * @param idemprendimiento El id del emprendimiento
     * @param idfuncionario El id del funcionario
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/calificarEmprendimientoIndividual")
    public String calificarEmprendimientoIndividual(Model model,
            @RequestParam("observaciones") String observaciones,
            @RequestParam("calificacion") BigDecimal calificacion,
            @RequestParam("idemprendimiento") long idemprendimiento,
            @RequestParam("idfuncionario") long idfuncionario, Principal principal
    ) {
        RequestCalificarEmpIndividual request = new RequestCalificarEmpIndividual();
        request.setCalificacion(calificacion);
        request.setIdemprendimiento(idemprendimiento);
        request.setIdfuncionario(idfuncionario);
        request.setObservaciones(observaciones);
        ResponseCalificarEmpIndividual response = new ResponseCalificarEmpIndividual();
        response = evaluacionIntegrantesComiteServicio.calificacionIndividual(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Calificar Emprendimiento");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "confirmar";
    }

    /**
     * Metodo que trae un emprendimiento en base a su id
     *
     * @param idemprendimiento El id del emprendimiento
     * @return El emprendimiento, una lista con sus temas de ruta de
     * acompañamiento y una lista con sus documentos
     */
    @GetMapping(path = "/getEmprendimientoCompleto", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGetEmprendimientoCompleto getEmprendimientoCompleto(
            @RequestParam("idemprendimiento") long idemprendimiento
    ) {
        RequestTraerEmprendimientoPorId request = new RequestTraerEmprendimientoPorId();
        request.setIdEmprendimiento(idemprendimiento);
        List<String> estados = new ArrayList();
        estados.add("4");
        ResponseGetEmprendimientoCompleto response = emprendimientoServicio.getEmprendimientoCompleto(request);
        int f = 0;
        return response;
    }

    /**
     * Controlador encargado de calificar los emprendimientos en una Sesión Comité
     *
     * @param documento Acta de la Sesión Comité
     * @param strEmprendimientos Lista de Emprendimientos y sus calificaciones
     * @param idSesionComite Identificador de la sesión
     * @param idCaja Caja de compensación del funcionario lider
     * @param idFuncionario Identificador del funcionario lider
     * @param principal Sesion Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/calificarEmprendimientoDefinitiva", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO calificarEmprendimientoDefinitiva(
            @RequestPart("documento") MultipartFile documento,
            @RequestParam("emprendimientos") String strEmprendimientos,
            @RequestParam("idSesionComite") long idSesionComite,
            @RequestParam("idCaja") BigDecimal idCaja,
            @RequestParam("idFuncionario") long idFuncionario, Principal principal
    ) {

        ResponseDTO response = new ResponseDTO();
        ResponseCajaCompensacion response1 = cajasDeCompensacionServicio.getCajaCompensacionPorId(idCaja);
        if ("0".equals(response1.getStatus())) {
            return response1;
        }

        RequestModificarFuncionario request = new RequestModificarFuncionario();
        request.setIdfuncionario(idFuncionario);
        ResponseModificarFuncionario response2 = funcionarioServicio.getFuncionarioPorId(request);
        if ("0".equals(response2.getStatus())) {
            return response2;
        }

        try {
            List<RequestCalificarEmprendimiento> calificaciones = new Gson().fromJson(strEmprendimientos, new TypeToken<ArrayList<RequestCalificarEmprendimiento>>() {
            }.getType());
            List<Character> aprobados = new ArrayList<>();
            List<String> observaciones = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            for (RequestCalificarEmprendimiento r : calificaciones) {
                aprobados.add(r.getAprobado());
                observaciones.add(r.getObservaciones());
                ids.add(r.getIdEmprendimiento());
            }
            String pathRoot = env.getProperty("root.path.files.actasComite") + env.getProperty("delimiter.path")
                    + env.getProperty("path.files.actasComite") + env.getProperty("delimiter.path")
                    + response1.getCaja().getNombrecajacompensacion() + env.getProperty("delimiter.path")
                    + response2.getFuncionarioDTO().getNumerodocumento() + env.getProperty("delimiter.path");

            File carpetaTema = new File(pathRoot);
            carpetaTema.mkdirs();

            deleteFiles(pathRoot);
            writeBytesToFile(documento.getBytes(), pathRoot + documento.getOriginalFilename());
            response = evaluacionEmprendimientosServicio.calificacionDefinitiva(idSesionComite,
                    aprobados, observaciones, ids, documento.getOriginalFilename());
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
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_DOCUMENTOS);
        }
        return response;
    }

    /**
     * Metodo que borra un archivo
     *
     * @param folder La ruta del archivo
     */
    public void deleteFiles(String folder) {
        File fileTemp = new File(folder);
        File[] files = fileTemp.listFiles();
        for (File file : files) {
            file.delete();
        }
    }

    /**
     * Metodo que crea un archivo
     *
     * @param bFile Bytes del archivo
     * @param fileDest Ruta del archivo a crear
     */
    private static void writeBytesToFile(byte[] bFile, String fileDest) {
        try {
            Path path = Paths.get(fileDest);
            Files.write(path, bFile);
        } catch (IOException e) {
            
        }
    }

    /**
     * Controlador encargado de ubicar una Sesión Comité por su identificador.
     *
     * @param idSesion Identificador de la Sesión Comité
     * @return Respuesta con la Sesión Comité.
     */
    @GetMapping(path = "/consultaSesionComiteXId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<SesioncomiteDTO> consultaSesionComiteXId(@RequestParam("idSesion") long idSesion) {
        SesioncomiteDTO sesion = sesionesComiteServicio.getSesiones(idSesion);
        return new ResponseEntity<>(sesion, (sesion != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento de un
     * beneficiario
     *
     * @param documento El documento del beneficiario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Un emprendimiento
     */
    @GetMapping(path = "/getEmprendimientoPorDocEva", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDocEva(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        request.setIdcajacompensacion(idcajacompensacion);
        List<String> setEstados = new ArrayList();
        setEstados.add("3");
        setEstados.add("10");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc2(request);

        return response;
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento de un
     * beneficiario
     *
     * @param documento El documento del beneficario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Un emprendimiento
     */
    @GetMapping(path = "/getEmprendimientoPorDocEva2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDocEva2(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        request.setIdcajacompensacion(idcajacompensacion);
        List<String> setEstados = new ArrayList();
        setEstados.add("5");
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc2(request);

        return response;
    }

    /**
     * Metodo que trae una lista de emprendimientos en base a su nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Lista de emprendimientos
     */
    @GetMapping(path = "/getEmprendimientoPorNombreEva2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombreEva2(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        request.setIdcajacompensacion(idcajacompensacion);
        List<String> setEstados = new ArrayList();
        setEstados.add("5");

        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);

        return response;
    }

    /**
     * Metodo que trae una lista de emprendimientos en base a su nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensacion
     * @param idfuncionario El id del funcionario
     * @return Lista de emprendimientos
     */
    @GetMapping(path = "/getEmprendimientoPorNombreEva", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombreEva(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("3");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);

        return response;
    }
}

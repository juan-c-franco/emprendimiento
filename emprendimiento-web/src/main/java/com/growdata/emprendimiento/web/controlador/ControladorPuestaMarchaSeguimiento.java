package com.growdata.emprendimiento.web.controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestEmprendimientoPorDocEstados;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.seguimiento.RequestGuardarPlanAccion;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseActividadInternacional;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseDepartamentos;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponsePaises;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseSectorProductivo;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTipoConstitucionLegal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTiposEmprendimiento;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipodocumentosDTO;
import com.growdata.emprendimiento.business.servicio.ActividadInternacionalServicio;
import com.growdata.emprendimiento.business.servicio.AsistenciaTecnicaServicio;
import com.growdata.emprendimiento.business.servicio.AsociadoServicio;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.DepartamentosServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;
import java.math.BigDecimal;
import java.security.Principal;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;
import com.growdata.emprendimiento.business.servicio.FinanciacionServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.PaisesServicio;
import com.growdata.emprendimiento.business.servicio.SectorProductivoServicio;
import com.growdata.emprendimiento.business.servicio.SeguimientoServicio;
import com.growdata.emprendimiento.business.servicio.TipoConstitucionLegalServicio;
import com.growdata.emprendimiento.business.servicio.TipoemprendimientoServicio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Juan Carlos Franco
 */
@Controller
//@PropertySource("classpath:propiedades.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class ControladorPuestaMarchaSeguimiento {

    private final BigDecimal grupo = new BigDecimal(8);

    @Autowired
    private FuncionarioServicio funcionarioServicio;
    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;
    @Autowired
    private SesionesServicio sesionesServicio;
    @Autowired
    private ListaAsistenciaServicio listaAsistenciaServicio;
    @Autowired
    private EmprendimientoServicio emprendimientoServicio;
    @Autowired
    private DepartamentosServicio departamentosServicio;
    @Autowired
    private PaisesServicio paisServicio;
    @Autowired
    private ActividadInternacionalServicio actividadInternacionalServicio;
    @Autowired
    private SectorProductivoServicio sectorProductivoServicio;
    @Autowired
    private TipoConstitucionLegalServicio tipoConstitucionLegalServicio;
    @Autowired
    private TipoemprendimientoServicio tipoemprendimientoServicio;
    @Autowired
    private FinanciacionServicio financiacionServicio;
    @Autowired
    private SeguimientoServicio seguimientoServicio;
    @Autowired
    private BeneficiarioServicio beneficiarioServicio;
    @Autowired
    private AsistenciaTecnicaServicio asistenciaTecnicaServicio;
    @Autowired
    private AsociadoServicio asociadoServicio;
    @Autowired
    private LogAuditoriaServicio logAuditoria;
    @Autowired
    private Environment env;
    @Autowired
    private LoggerEmprendimiento log;

    private String modulo = "Puesta en Marcha y Seguimiento";

    /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso
     * Programar Sesión Puesta en Marcha y Seguimiento.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario en sesión
     * @param idcajacompensacion Identificador de la Caja de Compensación a la
     * que pertenece el Funcionario
     * @return Url vista
     */
    @RequestMapping("/programarPuestaMarchaSeguimiento")
    public String programarPuestaMarchaSeguimiento(Model model, Principal principal,
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
                model.addAttribute("url", "/programarPuestaMarchaSeguimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        return "programarPuestaMarchaSeguimientoView";

    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compnesación
     * @param idfuncionario El id de funcionario
     * @return Url vista dependiendo del tipo de usuario
     */
    @RequestMapping("/registrarAsistenciaSeguimiento")
    public String registrarAsistenciaSeguimiento(Model model, Principal principal, @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
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
                model.addAttribute("url", "/registrarAsistenciaSeguimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();

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

        return "registrarAsistenciaS";
    }

    /**
     * Metodo que trae los asistentes de una sesion en base a su id
     *
     * @param idfuncionario El id del funcionario
     * @param idsesion El id de la sesión
     * @param fecha La fecha
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("/traerAsistentesS")
    public String traerAsistentesS(@RequestParam("idfuncionario") int idfuncionario, @RequestParam("idsesion") int idsesion, @RequestParam(name = "fecha", required = false) Timestamp fecha,
            Model model) {
//            @RequestParam("idestadosesion") long idestadosesion, Model model) {

//        Date date = new Date();
//
//        if (date.compareTo(fecha) > 0) {
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
            estados.add("6");

            request2.setEstados(estados);
            request2.setDoc(listaAsistencia.get(0).getBeneficiario().getNumerodocumento());
            response2 = emprendimientoServicio.getEmprendimientoPorDoc(request2);
            model.addAttribute("emprendimiento", response2.getEmprendimientos().get(0));

        }

        //agrego los asistentes al modelo
//        model.addAttribute("idestadosesion", idestadosesion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("listaAsistencia", listaAsistencia);
        model.addAttribute("idsesion", idsesion);
//        } else {
//            resp = "errorFecha";
//        }

        return "registrarAsistencia2S";
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
    @RequestMapping("/registroAsistenciasS")
    public String registroAsistentesS(@RequestParam("idfuncionario") long idfuncionario,
            @RequestParam("asist") String asisten, @RequestParam("idsesion") long idsesion,
            Model model, Principal principal) {
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        ResponseRegistroAsistencias response = new ResponseRegistroAsistencias();
//        JsonFactory factory = new JsonFactory();
        List<AsistenciasValor> asistencias = new ArrayList<>();
//        JsonParser parser = factory.createParser(asisten);
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
        response = listaAsistenciaServicio.registroAsistenciasS(request);
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
        //agrego el resultado al modelo

        return "confirmar";
    }

    /**
     * /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso
     * Agendar Sesión Puesta en Marcha y Seguimiento.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario en sesión
     * @param idcajacompensacion Identificador de la Caja de Compensación a la
     * que pertenece el Funcionario
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosSesionSeguimiento")
    public String cargarDatosSesionSeguimiento(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        if (idfuncionario == null || idcajacompensacion == null) {

            List<GestionarFuncionarioDTO> cajasDTO;
            List<FuncionarioDTO> valoradores = null;
            RequestTraerFuncionarioPorUserName request = new RequestTraerFuncionarioPorUserName();
            request.setUserName(principal.getName());
            request.setIdEstado(BigDecimal.ONE);
            ResponseTraerFuncionarioPorUserName response = funcionarioServicio.getFuncionarioPorUserName(request);
            FuncionarioDTO funcionario = response.getFuncionarioDTO();

            //Verifico si es funcionario. Sino es funcionario es administrador
            if (funcionario == null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosSesionSeguimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 8 (Asistente Tecnico)            
            /*
             * Si no es asistente tecnico, es Atencion CCF y debe seleccionar
             * alguno de los funcionarios funcionarios de la caja de
             * compensacion a la que pertenece.
             */
            for (GroupMembersDTO s : funcionario.getUsers().getGroupMemberses()) {
                //Soy algo diferente a valorador.
                if (s.getGroups().getId() == 2) {
                    valoradores = funcionarioServicio
                            .getFuncionariosPorGrupoYCaja(grupo, funcionario.getCajacompensacion().getIdcajacompensacion())
                            .getFuncionariosDTO();

                    model.addAttribute("sensibilizadores", valoradores);
                    model.addAttribute("cajaN", funcionario.getCajacompensacion().getNombrecajacompensacion());
                    model.addAttribute("cajaID", funcionario.getCajacompensacion().getIdcajacompensacion());
                    model.addAttribute("url", "/cargarDatosSesionSeguimiento");
                    model.addAttribute("grupo", grupo.intValue());
                    return "setIdFuncionario";
                }
            }
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        return "consultarBeneficiarioSeguimiento";
    }

    /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso
     * Agendar Sesión Puesta en Marcha y Seguimiento.
     *
     * @return Vista
     */
    @GetMapping("/agendarSesionSeguimiento")
    public ModelAndView agendarSesionSeguimiento() {
        ModelAndView view = new ModelAndView("agendarSesionSeguimientoView");
        return view;
    }

    /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso
     * Registro de Información Seguimiento
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario en sesión
     * @param idcajacompensacion Identificador de la Caja de Compensación a la
     * que pertenece el Funcionario
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosRegistroInformacionSeguimiento")
    public String cargarDatosRegistroInformacionSeguimiento(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion) {

        if (idfuncionario == null || idcajacompensacion == null) {

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
                model.addAttribute("url", "/cargarDatosRegistroInformacionSeguimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);
        ResponsePaises response6 = paisServicio.getPaises();
        if ("1".equals(response6.getStatus())) {
            model.addAttribute("paises", response6.getPaises());
        }
        ResponseTipoConstitucionLegal response1 = tipoConstitucionLegalServicio.getTiposConstitucionLegal();
        if ("1".equals(response1.getStatus())) {
            model.addAttribute("tiposConstitucion", response1.getTipos());
        }
        ResponseSectorProductivo response2 = sectorProductivoServicio.getSectoresProductivos();
        if ("1".equals(response2.getStatus())) {
            model.addAttribute("sectoresProductivos", response2.getSectores());
        }
        ResponseActividadInternacional response3 = actividadInternacionalServicio.getActividadesInternacionales();
        if ("1".equals(response3.getStatus())) {
            model.addAttribute("actividadesInternacionales", response3.getActividades());
        }

        ResponseTiposEmprendimiento response4 = tipoemprendimientoServicio.getTiposEmprendiemiento();
        if ("1".equals(response4.getStatus())) {
            model.addAttribute("tiposEmprendimiento", response4.getTipos());
        }

        ResponseDepartamentos response5 = departamentosServicio.getDepartamentos();
        if ("1".equals(response5.getStatus())) {
            model.addAttribute("departamentos", response5.getDepartamentos());
        }
        return "consultarBeneficiarioRegistroSeguimiento";
    }

    /**
     * Método responsable de traer todos los Departamentos.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Departamentos.
     */
    @GetMapping(path = "/getDepartamentos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDepartamentos getDepartamentos() {
        return departamentosServicio.getDepartamentos();
    }

    /**
     * Método responsable de traer todos los Paises.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Paises.
     */
    @GetMapping(path = "/getPaises", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponsePaises getPaises() {
        return paisServicio.getPaises();
    }

    /**
     * Método responsable de traer todos los Tipos de Constitución Legal.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Tipos de Constinución Legal.
     */
    @GetMapping(path = "/getTiposConstitucionLegal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTipoConstitucionLegal getTiposConstitucionLegal() {
        return tipoConstitucionLegalServicio.getTiposConstitucionLegal();
    }

    /**
     * Método responsable de traer todos los Sectores Productivos.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Sectores Productivos.
     */
    @GetMapping(path = "/getSectoresProductivos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSectorProductivo getSectoresProductivos() {
        return sectorProductivoServicio.getSectoresProductivos();
    }

    /**
     * Método responsable de traer todos las Actividades Internacionales.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Actividades Internacionales.
     */
    @GetMapping(path = "/getActividadesInternacionales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseActividadInternacional getActividadesInternacionales() {
        return actividadInternacionalServicio.getActividadesInternacionales();
    }

    /**
     * Método responsable de traer todos los Tipos de Emprendimiento.
     *
     * @return Respuesta si fue exitosa o no la búsqueda, junto con la lista de
     * Tipos de Emprendimiento.
     */
    @GetMapping(path = "/getTiposEmprendimientos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTiposEmprendimiento getTiposEmprendimientos() {
        return tipoemprendimientoServicio.getTiposEmprendiemiento();
    }

    /**
     * Controlador encargado de mostrar la vista correspondiente al caso de uso
     * Registro de Información Puesta en Marcha y Seguimiento.
     *
     * @return Vista
     */
    @GetMapping("/registroInformacionSeguimiento")
    public ModelAndView registroInformacionSeguimiento() {
        ModelAndView view = new ModelAndView("registroInformacionSeguimientoView");
        return view;
    }

    @GetMapping(path = "/getInfoFinancieraPorIdEmp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerInfoFinancieraBasica getInfoFinancieraPorIdEmp(@RequestParam("idemprendimiento") long idemprendimiento) {
        RequestTraerInfoFinancieraBasica request = new RequestTraerInfoFinancieraBasica();
        request.setIdEmprendimiento(idemprendimiento);
        return financiacionServicio.getInfoFinancieraBasicaPorId(request);
    }

    /**
     * Controlador encargado de registrar la información de un Seguimiento
     *
     * @param strRequest Datos del Emprendimiento
     * @param strRequestFinan Datos Financieros del Emprendimiento
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/registrarInformacionSeguimiento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarInformacionSeguimiento(
            @RequestParam("requestEmp") String strRequest,
            @RequestParam("requestFinan") String strRequestFinan, Principal principal) {
        RequestRegistrarFormalizado request = new RequestRegistrarFormalizado();
        RequestNoEstablecido requestNF = new RequestNoEstablecido();
        RequestRegistrarInfoFinancieraBasica requestF = new RequestRegistrarInfoFinancieraBasica();
        ResponseDTO response = new ResponseDTO();
        try {
            Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            request = g.fromJson(strRequest, RequestRegistrarFormalizado.class);
            requestF = g.fromJson(strRequestFinan, RequestRegistrarInfoFinancieraBasica.class);
            if ("si".equals(request.getFormalizado())) {
                request = g.fromJson(strRequest, RequestRegistrarFormalizado.class);
                response = seguimientoServicio.guardarSeguimientoFormalizado(request, requestF);
            } else {
                requestNF = g.fromJson(strRequest, RequestNoEstablecido.class);
                response = seguimientoServicio.guardarSeguimientoNoEstablecido(requestNF, requestF);
            }
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
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador, funcionario o beneficiario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idbeneficiario El id del beneficiario
     * @param idfuncionario El id del funcionario
     * @param idcajacompensacion El id de la caja de compensación
     * @param atr Redireccionador de atributos
     * @return Url vista
     */
    @RequestMapping(path = "/cargarEmprendimientoAdjuntar")
    public String cargarEmprendimientoAdjuntar(Model model, Principal principal,
            @RequestParam(name = "idbeneficiario", required = false) Long idbeneficiario,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            RedirectAttributes atr) {
        if (idfuncionario == null) {
            BeneficiarioDTO beneficiario = beneficiarioServicio.getBeneficiarioPorCorreo(
                    principal.getName()).getBeneficiario();

            List<GestionarFuncionarioDTO> cajasDTO;
            //Verifico si es un beneficiario.
            if (beneficiario != null) {
                ResponseTraerAsociadoPorUserName response = new ResponseTraerAsociadoPorUserName();
                RequestTraerAsociadoPorUserName request = new RequestTraerAsociadoPorUserName();
                request.setUserName(principal.getName());
                request.setEstadoUsuario(new BigDecimal(1));
                response = asociadoServicio.getAsociado(request);
                if (response.getAsociadoDTO() != null) {
                    atr.addAttribute("emprendimientoId", response.getAsociadoDTO().getEmprendimiento().getIdemprendimiento());
                    model.addAttribute("idBeneficiario", beneficiario.getIdbeneficiario());
                    return "redirect:adjuntarPlanAccion2";
                } else {
                    model.addAttribute("mensajeTitulo", "Adjuntar Plan de Acción");
                    model.addAttribute("mensaje", response.getDescripcion());
                    model.addAttribute("status", response.getStatus());
                    return "confirmar";
                }

            }

            List<FuncionarioDTO> valoradores = null;
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
                model.addAttribute("url", "/cargarEmprendimientoAdjuntar");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "adjuntarPlanAccion1";
    }

    /**
     * Metodo que trae una lista de emprendimientos en base a un nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @return url vista
     */
    @GetMapping("/getEmprendimientoPorNombrePlanAccion")
    public String getEmprendimientoPorNombrePlanAccion(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();

        setEstados.add("6");
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());
        model.addAttribute("buscador", "1");
        return "adjuntarPlanAccion1";
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento
     *
     * @param documento El documento del beneficiario
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/getEmprendimientoPorDocPlanAccion")
    public String getEmprendimientoPorDocPlanAccion(@RequestParam("documento") String documento, Model model) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");

        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("emprendimientos", response.getEmprendimientos());
        model.addAttribute("buscador", "1");
        return "adjuntarPlanAccion1";
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * beneficiario lider o no lider
     *
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @param emprendimientoId El id del emprendimiento
     * @return Url vista
     */
    @GetMapping("/adjuntarPlanAccion2")
    public String adjuntarPlanAccion2(Principal principal, Model model, @RequestParam(name = "emprendimientoId", required = false) BigDecimal emprendimientoId) {
        //traigo beneficiario asociado para ver si es lider 
        RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName = new RequestTraerAsociadoPorUserName();
        requestTraerAsociadoPorUserName.setUserName(principal.getName());
        requestTraerAsociadoPorUserName.setEstadoUsuario(BigDecimal.valueOf(1));
        ResponseTraerAsociadoPorUserName responseTraerAsociadoPorUserName = asociadoServicio.getAsociado(requestTraerAsociadoPorUserName);
        if (responseTraerAsociadoPorUserName.getAsociadoDTO() != null) {

            String lider = String.valueOf(responseTraerAsociadoPorUserName.getAsociadoDTO().getLider());
            model.addAttribute("lider", lider);
            model.addAttribute("idBeneficiario", responseTraerAsociadoPorUserName.getAsociadoDTO().getBeneficiario().getIdbeneficiario());
        }
        //Traigo emprendimiento
        RequestTraerEmprendimiento requestTraerEmprendimiento = new RequestTraerEmprendimiento();
        requestTraerEmprendimiento.setIdEmprendimiento(emprendimientoId.longValue());
        ResponseTraerEmprendimiento responseTraerEmprendimiento = asistenciaTecnicaServicio.getEmprendimiento(requestTraerEmprendimiento);
        EmprendimientoDTO emprendimiento = responseTraerEmprendimiento.getEmprendimientoDTO();
        model.addAttribute("emprendimiento", emprendimiento);
        //Traigo documento
        RequestTraerDocumentos requestTraerDocumentos = new RequestTraerDocumentos();
        requestTraerDocumentos.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
        requestTraerDocumentos.setIdTipoDocumento(new BigDecimal(3));
        ResponseTraerDocumentos responseTraerDocumentos = asistenciaTecnicaServicio.getDocumentos(requestTraerDocumentos);
        if (responseTraerDocumentos.getDocumentosDTO().size() > 0) {
            model.addAttribute("documentoPlan", responseTraerDocumentos.getDocumentosDTO().get(0));
        } else {
            DocumentosDTO docu = new DocumentosDTO();
            docu.setUrlarchivo("");
            TipodocumentosDTO tip = new TipodocumentosDTO();
            tip.setNombretipodocumento("");
            docu.setTipodocumentos(tip);
            docu.setIddocumento(0);
            model.addAttribute("documentoPlan", docu);
        }

        // Traigo rutas
        RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = new RequestTraerTemasRutaAAT();
        requestTraerTemasRutaAAT.setIdEmprendimiento(emprendimiento.getIdemprendimiento());
        ResponseTraerListaTemasRutaAAT responseTraerListaTemasRutaAAT = asistenciaTecnicaServicio.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
        List<TemasrutaacompanamientoatDTO> temasRutaAATT = responseTraerListaTemasRutaAAT.getTemasRutaAATDTO();
        model.addAttribute("temasRutaAAT", temasRutaAATT);
        return "adjuntarPlanAccion2";
    }

    /**
     * Metodo que trae una lista de emprendimientos en base a un nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Lista de emprendimientos
     */
    @GetMapping(path = "/getEmprendimientoPorNombreSeguimiento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombreSeguimiento(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);

        return response;
    }

    /**
     * Metodo que trae un emprendimiento en base a un documento
     *
     * @param documento El documento del beneficiario
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Un emprendimiento
     */
    @GetMapping(path = "/getEmprendimientoPorDocSeguimiento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDocSeguimiento(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        List<String> setEstados = new ArrayList();
        setEstados.add("6");
        request.setIdcajacompensacion(idcajacompensacion);
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);
//        String mensaje = response.getDescripcion();
//        String status = response.getStatus();
//        model.addAttribute("idcajacompensacion", idcajacompensacion);
//        model.addAttribute("idfuncionario", idfuncionario);
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("status", status);
//        model.addAttribute("emprendimientos", response.getEmprendimientos());

        return response;
    }

    /**
     * Metodo que crea el archivo a adjuntar en al ruta definida en el archivo
     * de propiedades y agrega su url a la BD
     *
     * @param emprendimientoId El id del emprendimiento
     * @param documentoPlanAccion El documento de plan de acción
     * @param idBeneficiario El id del beneficiario
     * @param idPlanAccion El id del plan de acción
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idestadoemprendimiento Identificador del estado del
     * emprendimiento.
     * @return respuesta si se adjunto el documento exitosamente o no
     */
    @PostMapping(path = "/adjuntarDocumentoPlanAccion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGuardarDocumento adjuntarDocumentoPlanAccion(@RequestParam(name = "emprendimientoId", required = false) long emprendimientoId,
            @RequestPart("documentoPlanAccion") MultipartFile documentoPlanAccion, @RequestParam(name = "idBeneficiario") long idBeneficiario,
            @RequestParam(name = "idPlanAccion") long idPlanAccion, Model model, Principal principal,
            @RequestParam("idestadoemprendimiento") BigDecimal idestadoemprendimiento) {
        RequestGuardarPlanAccion request = new RequestGuardarPlanAccion();
        Date date = new Date();
        DocumentosDTO documento = new DocumentosDTO();
        BeneficiarioDTO beneficiario = new BeneficiarioDTO();
        beneficiario.setIdbeneficiario(idBeneficiario);
        documento.setBeneficiario(beneficiario);
        EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
        emprendimiento.setIdemprendimiento(emprendimientoId);
        EstadoemprendimientoDTO estadoemprendimiento = new EstadoemprendimientoDTO();
        estadoemprendimiento.setIdestadoemprendimiento(idestadoemprendimiento);
        emprendimiento.setEstadoemprendimiento(estadoemprendimiento);
        documento.setEmprendimiento(emprendimiento);
        documento.setFecharegistro(date);
        TipodocumentosDTO tipodocumentos = new TipodocumentosDTO();
        tipodocumentos.setIdtipodocumento(new BigDecimal(3));
        documento.setTipodocumentos(tipodocumentos);
        documento.setUrlarchivo(documentoPlanAccion.getOriginalFilename());

        RequestGuardarDocumento requestGuardarDocumento = new RequestGuardarDocumento();
        requestGuardarDocumento.setDocumento(documento);
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
            String pathRoot = env.getProperty("root.path.files.emprendimiento.plan") + env.getProperty("delimiter.path")
                    + env.getProperty("path.files.documentos.plan") + env.getProperty("delimiter.path")
                    + responseGuardarDocumento.getIdDocumento() + env.getProperty("delimiter.path");

            File carpetaTema = new File(pathRoot);
            carpetaTema.mkdirs();

            deleteFiles(pathRoot);
            try {
                writeBytesToFile(documentoPlanAccion.getBytes(), pathRoot + documentoPlanAccion.getOriginalFilename());
            } catch (Exception ex) {
                log.writeToLogFile(ex);
                responseGuardarDocumento.setStatus("0");
                responseGuardarDocumento.setDescripcion(Mensajes.ERROR_ESCRIBIENDO_ARCHIVO);
            }
        }

        return responseGuardarDocumento;
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
     */
    private static void writeBytesToFile(byte[] bFile, String fileDest) {
        try {
            Path path = Paths.get(fileDest);
            Files.write(path, bFile);
        } catch (IOException e) {
            
        }
    }

    /**
     * Metodo que trae un archivo
     *
     * @param pathFile Ruta del archivo
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
     * Metodo que revisa en la BD si existe un documento con el id que recibe y
     * si es asi lo trae
     *
     * @param id El id del documento de comité
     * @param response HttpServletResponse
     */
    @RequestMapping(value = "/verPlanAccion", method = RequestMethod.GET, produces = "application/pdf")
    public @ResponseBody
    void verDocumentoComiteAAT(@RequestParam(name = "id") BigDecimal id, HttpServletResponse response) {
        RequestTraerDocumentoComite requestTraerDocumentoComite = new RequestTraerDocumentoComite();
        requestTraerDocumentoComite.setIdDocumentoComite(id.longValue());
        ResponseTraerDocumentoComite responseTraerDocumentoComite = asistenciaTecnicaServicio.getDocumento(requestTraerDocumentoComite);

        if (responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo() != null && !"".equals(responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo())) {
            try {
                String pathFile = env.getProperty("root.path.files.emprendimiento.plan") + env.getProperty("delimiter.path")
                        + env.getProperty("path.files.documentos.plan") + env.getProperty("delimiter.path")
                        + responseTraerDocumentoComite.getDocumentoDTO().getIddocumento() + env.getProperty("delimiter.path")
                        + responseTraerDocumentoComite.getDocumentoDTO().getUrlarchivo();
                File file = getFile(pathFile);
                InputStream in = new FileInputStream(file);

                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
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

}

package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.DTOSesiones;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.TraerEncuestaDTO;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.EncuestaServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;
import com.growdata.emprendimiento.business.servicio.UsersServicio;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Tiposesion;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRequisitos;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetBeneficiarioXId;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EncriptadorUrl;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.ConfiguracionServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.persistence.entidad.Users;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;

/**
 *
 * @author Grow Data PC
 */
@Controller
public class ControladorSensibilizacion {

    private final BigDecimal grupo = new BigDecimal(3);

    //inycecto dependencia dao 
    @Autowired
    private BeneficiarioServicio datosBService;

    @Autowired
    private SesionesServicio sesionesServicio;

    @Autowired
    private ListaAsistenciaServicio listaAsistenciaServicio;

    @Autowired
    private EncuestaServicio encuestaServicio;

    @Autowired
    private UsersServicio usersServicio;

    @Autowired
    private BeneficiarioServicio beneficiarioServicio;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;
    
    @Autowired
    private LoggerEmprendimiento log;

    @Autowired
    private ConfiguracionServicio configuracionServicio;

    private String modulo = "Sensibilización";


//    @PostMapping("/encuestaSensibilizacion")
//    public String mostrarEncuesta(@RequestParam(name = "idBeneficiario", required = false) int idBeneficiario, @RequestParam(name = "idEncuesta", required = false) long idEncuesta,
//            @RequestParam(name = "idfuncionario", required = false) long idfuncionario, Model model) {
    /**
     * Metodo que desencripta los parametros y trae la encuesta basandose en
     * ellos
     *
     * @param xjzlv Id del beneficiario, id de la encuesta e id del funcionario
     * encriptados
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/encuestaSensibilizacion")
    public String mostrarEncuesta(@RequestParam("xjzlv") String xjzlv, Model model) {

        int idBeneficiario = -1;
        long idfuncionario = -1;
        long idEncuesta = -1;

        String decodificado = EncriptadorUrl.decode(xjzlv);
//        String[] aux = decodificado.split("/?");
//        String datos = aux[1];
        String[] aux2 = decodificado.split("&");

        for (String s : aux2) {
            String[] aux3 = s.split("=");
            if (aux3[0].equals("idBeneficiario")) {
                idBeneficiario = Integer.parseInt(aux3[1]);
            } else if (aux3[0].equals("idEncuesta")) {
                idEncuesta = Integer.parseInt(aux3[1]);
            } else if (aux3[0].equals("idfuncionario")) {
                idfuncionario = Integer.parseInt(aux3[1]);
            }

        }
        RequestTraerEncuesta request = new RequestTraerEncuesta();
        TraerEncuestaDTO traerEncuestaDTO = new TraerEncuestaDTO();
        traerEncuestaDTO.setIdBeneficiario(idBeneficiario);
        traerEncuestaDTO.setIdEncuesta(idEncuesta);
        request.setIdfuncionario(idfuncionario);
        request.setTraerEncuestaDTO(traerEncuestaDTO);

        //Traigo la encuesta para validar la fecha 
        ResponseTraerEncuesta response;
        response = encuestaServicio.getEncuesta(request);
        //valido el valor response
        if ("0".equals(response.getStatus())) {
            String mensaje = response.getDescripcion();

            String respuesta = "0";
            model.addAttribute("respuesta", respuesta);
            model.addAttribute("mensaje3", mensaje);

        } else {
            //Traigo las preguntas del dao
            List<PreguntasDTO> preguntasDTO = response.getPreguntasDTO();
            // agrego las preguntas al modelo
            model.addAttribute("idBeneficiario", idBeneficiario);
            model.addAttribute("preguntasDTO", preguntasDTO);
            model.addAttribute("idEncuesta", idEncuesta);
        }
        return "encuestaSensibilizacion";
    }

    /**
     * Metodo que trae las sesiones de determinado funcionario por su id
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion EL id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Vista a ser redireccionado
     */
    @RequestMapping("/traerSesiones")
    public String traerSesiones(Model model, Principal principal, @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
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
                model.addAttribute("url", "/traerSesiones");
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

        return "registrarAsistencia";
    }

    /**
     * Metodo que trae los asistentes de determinada sesion por su id
     *
     * @param idfuncionario El id del funcionario
     * @param idsesion El id de la sesión
     * @param fecha Fecha
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("/traerAsistentes")
//    public String traerAsistentes(@RequestParam("idsesion") int idsesion, @RequestParam("fecha") @DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss.SSSSSS") Timestamp fecha, Model model) {
    public String traerAsistentes(@RequestParam("idfuncionario") int idfuncionario, @RequestParam("idsesion") int idsesion, @RequestParam(name = "fecha", required = false) Timestamp fecha,
            Model model) {
//            @RequestParam("idestadosesion") long idestadosesion, Model model) {

//        Date date = new Date();
//        if (date.compareTo(fecha) > 0) {
        //traigo los asistentes
        RequestTraerAsistentes request = new RequestTraerAsistentes();
        request.setIdsesion(idsesion);
        ResponseTraerAsistentes response = new ResponseTraerAsistentes();
        response = listaAsistenciaServicio.getLista(request);
        List<ListaasistenciaDTO> listaAsistencia = response.getAsistenciaDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        //agrego los asistentes al modelo
//            model.addAttribute("idestadosesion", idestadosesion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("listaAsistencia", listaAsistencia);
        model.addAttribute("idsesion", idsesion);
//        } else {
//            resp = "errorFecha";
//        }

        return "registrarAsistencia2";
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
    @RequestMapping("/registroAsistencias")
    public String registroAsistentes(@RequestParam("idfuncionario") long idfuncionario, @RequestParam("asist") String asisten,
            @RequestParam("idsesion") long idsesion, Model model, Principal principal) {
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
                a.setIdasistencia(arr.getLong(i));
                String g = arr2.getString(i);
                a.setValor(g.charAt(0));
                asistencias.add(a);
            }
            //registro las asistencias
        }
        request.setIdfuncionario(idfuncionario);
        request.setIdsesion(idsesion);
        request.setAsistencias(asistencias);
        response = listaAsistenciaServicio.registroAsistencias(request);
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
     * Metodo que registra las respuesta de la encuesta de sensibilizacion y
     * crea un usuario para el beneficiario
     *
     * @param idbeneficiario El id del beneficiario
     * @param respuestas Las respuestas de la encuesta
     * @param idEncuesta El id de la encuesta
     * @param model Modelo JSP
     * @return respuesta si se creo el usuario exitosamente o no
     */
    @PostMapping(path = "/crearUsuario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseCrearUsuario crearUsuario(
            @RequestParam("idBeneficiario") long idbeneficiario,
            @RequestParam("respuestas") String respuestas,
            @RequestParam("idEncuesta") long idEncuesta,
            Model model) {

        List<RespuestasValor> respuestasV = new ArrayList<>();
        if (respuestas != null) {
            System.out.println(respuestas);
            respuestas = respuestas.replace("[{", "{");
            respuestas = respuestas.replace("}]", "}");
            System.out.println("Despues del replace--->" + respuestas);
            JSONObject obj = new JSONObject(respuestas);

            JSONArray arr = obj.getJSONArray("pregunta");
            JSONArray arr2 = obj.getJSONArray("valor");
            for (int i = 0; i < arr.length(); i++) {
                RespuestasValor r = new RespuestasValor();
                r.setIdpregunta(BigDecimal.valueOf(arr.getDouble(i)));
                r.setRespuesta(arr2.getString(i));
                respuestasV.add(r);
            }

        }
        RequestCrearUsuario request = new RequestCrearUsuario();
//        RequestGuardarRespuestas request = new RequestGuardarRespuestas();
//        ResponseGuardarRespuestas response = new ResponseGuardarRespuestas();
        request.setIdEncuesta(idEncuesta);
        request.setRespuestasValor(respuestasV);
//        response = respuestasEncuestaServicio.guardarRespuestas(request);
//        if ("1".equals(response.getStatus())) {
//            RequestLogAuditoria requestA = new RequestLogAuditoria();
//            Date date = new Date();
//           
//            requestA.setUsers(new Users(principal.getName()));
//            requestA.setAccion(response.getAccion());
//            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
//            requestA.setIdelemento(idEncuesta);
//            requestA.setModulo(modulo);
//            logAuditoria.registrarLog(requestA);
//        }
        //creo el usuario

        ResponseCrearUsuario response = new ResponseCrearUsuario();
        request.setIdbeneficiario(idbeneficiario);
        response = usersServicio.crearUser(request);

//        if ("El usuario ya existe".equals(response2.getDescripcion())) {
//            response2.setStatus("1");
//            response2.setDescripcion(response.getDescripcion());
//        } else {
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestB = new RequestLogAuditoria();

           
           requestB.setUsers(new Users("Sistema"));
            requestB.setAccion(response.getAccion());
            requestB.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestB.setIdelemento(response.getId());
            requestB.setModulo(modulo);
            logAuditoria.registrarLog(requestB);
//            }
        }

        return response;
//        String respuesta;
//        if ("1".equals(response.getStatus()) && "1".equals(response2.getStatus())) {
//            respuesta = "1";
//            String mensaje3 = "Encuesta registrada exitosamente, recibira un correo electrónico con sus datos de acceso";
//        } else {
//            respuesta = "0";
//            if ("1".equals(response.getStatus()) && "0".equals(response2.getStatus())) {
//                String mensaje3 = "Se presentó un error al crear el usuario";
//            }
//            if ("0".equals(response.getStatus()) && "1".equals(response2.getStatus())) {
//                String mensaje3 = "Se presentó un error al guardar la encuesta";
//            }
//
//        }
//        model.addAttribute("respuesta", respuesta);
//        return "encuestaSensibilizacion";
    }

//    @RequestMapping("/registroAsistenciasModificadas")
//    public String registroAsistentesModificadas(@RequestParam("idfuncionario") long idfuncionario, @RequestParam("asist") String asisten, Model model) throws IOException {
//        RequestRegistroAsistentesModificadas request = new RequestRegistroAsistentesModificadas();
//        ResponseRegistroAsistentesModificadas response = new ResponseRegistroAsistentesModificadas();
//        JsonFactory factory = new JsonFactory();
//        List<AsistenciasValor> asistencias = new ArrayList<>();
//        if (asisten != null) {
//            System.out.println(asisten);
//            asisten = asisten.replace("[{", "{");
//            asisten = asisten.replace("}]", "}");
//            System.out.println("Despues del replace--->" + asisten);
//            JSONObject obj = new JSONObject(asisten);
//
//            JSONArray arr = obj.getJSONArray("Beneficiario");
//            JSONArray arr2 = obj.getJSONArray("valor");
//            for (int i = 0; i < arr.length(); i++) {
//                AsistenciasValor a = new AsistenciasValor();
//                a.setIdasistencia(arr.getLong(i));
//                String g = arr2.getString(i);
//                a.setValor(g.charAt(0));
//                asistencias.add(a);
//            }
//        }
//
////        JsonParser parser = factory.createParser(asisten);
////        while (!parser.isClosed()) {
////            String temp = parser.nextTextValue();
////            if (temp != null) {
////                asistencias.add(Integer.parseInt(temp));
////            }
////
////        }
//        request.setIdfuncionario(idfuncionario);
//        request.setAsistencias(asistencias);
//        //registro las asistencias
//        response = listaAsistenciaServicio.registroAsistenciasModificadas(request);
//        String update = response.getDescripcion();
//        //agrego el resultado al modelo
//        System.out.println("Esto trae el update que hice_------->" + update);
//        model.addAttribute("update", update);
//
//        return "registroAsistencia3";
//    }
//    @RequestMapping("/registroInasistentes")
//    public String registroInasistentes(@RequestParam("idsesion") int idsesion, @RequestParam("idfuncionario") long idfuncionario, Model model) {
//        RequestRegistroInasistentes request = new RequestRegistroInasistentes();
//        ResponseRegistroInasistentes response = new ResponseRegistroInasistentes();
//        //traigo los asistentes
//        request.setIdsesion(idsesion);
//        response = listaAsistenciaServicio.getListaInasistentes(request);
//        List<ListaasistenciaDTO> listaAsistencia = response.getAsistenciasDTO();
//        //agrego los asistentes al modelo
//        model.addAttribute("idfuncionario", idfuncionario);
//        model.addAttribute("listaAsistencia", listaAsistencia);
//
//        return "modificarAsistentes";
//    }
    /**
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Consultar Beneficiario.
     *
     * @return Vista a ser redireccionada
     */
    @GetMapping("/consultaBeneficiario")
    public ModelAndView loadConsultaBeneficiario() {
        ModelAndView view = new ModelAndView("consultaBeneficiario");
        return view;
    }

    /**
     * Controlador responsable de conseguir un beneficiario dado su número de 
     * documento en la base de datos de SIM-PC.
     *
     * @param doc Número del documento
     * @param url Vista a donde se debe redireccionar la respuesta
     * @param model Model JSP
     * @return Url vista
     */
    @GetMapping("/findBeneficiarioXDoc")
    public String findBeneficiarioXDoc(@RequestParam("doc") String doc, @RequestParam("url") String url, Model model) {
        RequestFindBeneficiarioXDoc request = new RequestFindBeneficiarioXDoc();
        request.setDoc(doc);
        ResponseFindBeneficiarioXDoc response = new ResponseFindBeneficiarioXDoc();

        response = datosBService.consultaBenfeficiario(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        List<BeneficiarioDTO> beneficiarios = response.getBeneficiariosDTO();
        model.addAttribute("beneficiarios", beneficiarios);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return url;
    }

    /**
     * Controlador responsable de conseguir un beneficiario dado sus nombres y 
     * apellidos en la base de datos de SIM-PC.
     *
     * @param pNombre Primer nombre del Beneficiario
     * @param sNombre Segundo nombre del Beneficiario
     * @param pApellido Primer apellido del Beneficiario
     * @param sApellido Segundo apellido del Beneficiario
     * @param url Vista a la que se debe redireccionar la respuesta
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/getBeneficiarioPorNombreYApellido")
    public String getBeneficiarioPorNombreYApellido(
            @RequestParam("pNombre") String pNombre,
            @RequestParam("sNombre") String sNombre,
            @RequestParam("pApellido") String pApellido,
            @RequestParam("sApellido") String sApellido,
            @RequestParam("url") String url, Model model) {
        RequestGetBeneficiarioXNombreYApellido request = new RequestGetBeneficiarioXNombreYApellido();
        request.setpNombre(pNombre);
        request.setsNombre(sNombre);
        request.setpApellido(pApellido);
        request.setsApellido(sApellido);
        ResponseGetBeneficiarioXNombreYApellido response = datosBService.getBeneficiarioPorNombreYApellido(request);
        List<BeneficiarioDTO> beneficiarios = response.getBeneficiariosDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("beneficiarios", beneficiarios);
        return url;
    }

    /**
     * Controlador encargado de registrar los datos de un beneficiario en la base de datos de
     * emprendimiento.
     *
     * @param json Datos del Beneficiario
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el registro.
     */
    @PostMapping(path = "/regBeneficiario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseBeneficiario regBeneficiario(@RequestParam("strBeneficiario") String json, 
            Principal principal) {
        MdFDatosBasicos datos = new Gson().fromJson(json, MdFDatosBasicos.class);
        RequestRegBeneficiario request = new RequestRegBeneficiario();
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNumerodocumento(datos.getNumeroDocumento());
        beneficiario.setPrimerapellido(datos.getPrimerApellido());
        beneficiario.setSegundoapellido(datos.getSegundoApellido() != null ? datos.getSegundoApellido() : "");
        beneficiario.setPrimernombre(datos.getPrimerNombre());
        beneficiario.setSegundonombre(datos.getSegundoNombre() != null ? datos.getSegundoNombre() : "");
        beneficiario.setEmail(datos.getCorreoElectronico().toLowerCase());
        beneficiario.setTelefono(Long.parseLong(datos.getTelefonoContacto()));
        Date date = new Date();
        beneficiario.setFecharegistro(date);
        request.setBeneficiario(beneficiario);
        request.setTipoDocumento(datos.getTipoDocumento());
        ResponseBeneficiario response = beneficiarioServicio.guardarBeneficiario(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        //Beneficiario ya registrado
        if ("2".equals(response.getStatus()) || "1".equals(response.getStatus())) {
            ResponseGetBeneficiarioXId response2 = beneficiarioServicio.getBeneficiarioPorCorreo(datos.getCorreoElectronico().toLowerCase());
            if ("0".equals(response2.getStatus())) {
                response.setDescripcion(Mensajes.ERROR_CORREO_NUMDOC_DUPLICADO);
                response.setBeneficiario(null);
                response.setStatus("0");
            } else {
                response.setBeneficiario(response2.getBeneficiario());
            }
        }
        return response;
    }

    /**
     * Controlador mostrar la vista correspondiente a el caso de uso Programar 
     * Sesión de Sensibilización.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador de Beneficiario que programa la sesión
     * @return Url vista.
     */
    @RequestMapping("/programarSesiones")
    public String programarSesiones(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {

        System.out.println("SESSION: " + principal.getName());

        if (idfuncionario == null) {

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
                model.addAttribute("url", "/programarSesiones");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }
        model.addAttribute("idFuncionario", idfuncionario);

        return "programarSesion";
    }

    /**
     * Controlador encargado de cargar las sesiones que cumplan con los
     * parametros
     *
     * @param idFuncionario Identificador del Funcionario
     * @param tiposesion Tipo de la Sesión
     * @param todas Parámetro que indica si se deben traer todas las sesiones o
     * solo las Disponibles.
     * @return Respuesta si fue exitoso o no la consulta y las sesiones
     * conseguidas.
     */
    @GetMapping(path = "/cargarSesiones", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerSesiones cargarSesiones(@RequestParam(name = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(name = "tiposesion", required = false) BigDecimal tiposesion,
            @RequestParam(name = "todas") int todas) {
        long id = -1;
        if (idFuncionario != null) {
            id = idFuncionario;
        }
        Date desde = null;
        if (todas == 1 || todas == 2) {
            desde = new Date();
        }
        return sesionesServicio.getSesionesPorFuncionarioTipoSesion(id,
                tiposesion, desde, todas);
    }

    /**
     * Controlador encargado de guardar las sesiones de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento.
     *
     * @param descripcion Descripcion de la sesión
     * @param fechaInicial Fecha de Inicio
     * @param fechaFinal Fecha Fin
     * @param maxCantidad Máxima cantidad de asistentes
     * @param ubicacion Ubicación de la Sesión
     * @param idFuncionario Identificador del Funcionario que registra la sesión
     * @param tiposesion Tipo de Sesión
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/guardarSesion")
    @ResponseBody
    public ResponseDTO guardarSesion(@RequestParam("descripcion") String descripcion,
            @RequestParam("fechaInicial") String fechaInicial, @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("maxCantidad") long maxCantidad, @RequestParam("ubicacion") String ubicacion,
            @RequestParam("idFuncionario") long idFuncionario, @RequestParam("tiposesion") BigDecimal tiposesion, Principal principal) {
        ResponseDTO response = new ResponseDTO();
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();

            Sesiones sesion = new Sesiones();
            sesion.setIdsesion(-1);
            sesion.setDescripcion(descripcion);
            sesion.setTiposesion(new Tiposesion(tiposesion));
            sesion.setMaxAsistentes(maxCantidad);
            sesion.setUbicacion(ubicacion == null ? "Sin Ubicación" : ubicacion);
            sesion.setEstadosesion(new Estadosesion(new BigDecimal(1)));
            sesion.setFuncionario(new Funcionario(idFuncionario));
            sesion.setFechainicio(new Timestamp(simple.parse(fechaInicial).getTime()));
            sesion.setFechafinal(new Timestamp(simple.parse(fechaFinal).getTime()));
            sesion.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            response = sesionesServicio.saveSesiones(sesion);
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
     * Controlador traer una sesión por su identificador.
     *
     * @param idSesion Identificador de la Sesión
     * @return Respuesta con las sesiones que cumplan con el criterio de
     * búsqueda.
     */
    @GetMapping(path = "/consultaSesionXId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<DTOSesiones> consultaSesionXId(@RequestParam("idSesion") long idSesion) {
        Sesiones s = sesionesServicio.getSesiones(idSesion);
        if (s == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        DTOSesiones dto = new DTOSesiones();
        dto.setDescripcion(s.getDescripcion());
        dto.setIdSesion(s.getIdsesion());
        dto.setFechaInicio((Timestamp) s.getFechainicio());
        dto.setFechaFin((Timestamp) s.getFechafinal());
        dto.setMaxAsistentes(s.getMaxAsistentes());
        dto.setUbicacion(s.getUbicacion());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Controlador que se utiliza para recibir los requerimientos de actualizar
     * sesiones de tipo: Sensibilización, Valoración, Evaluación y Seguimiento.
     *
     * @param sesionDto Datos de la sesión a actualizar
     * @param principal Sesión Srping Security
     * @return ResponseDTO Respuesta si fue exitóso o no el cambio.
     */
    @PutMapping(path = "/actualizarSesion")
    @ResponseBody
    public ResponseDTO actualizarSesion(@RequestBody DTOSesiones sesionDto, Principal principal) {
        ResponseDTO response = new ResponseDTO();
        try {
            Sesiones sesion = new Sesiones();
            sesion.setIdsesion(sesionDto.getIdSesion());
            sesion.setDescripcion(sesionDto.getDescripcion());
            sesion.setTiposesion(new Tiposesion(new BigDecimal(1)));
            sesion.setMaxAsistentes(sesionDto.getMaxAsistentes());
            sesion.setUbicacion(sesionDto.getUbicacion() == null ? "Sin Ubicación" : sesionDto.getUbicacion());
            sesion.setEstadosesion(new Estadosesion(sesionDto.getIdestadosesion()));
            sesion.setFuncionario(new Funcionario(sesionDto.getIdfuncionario()));
            sesion.setFechainicio(sesionDto.getFechaInicio());
            sesion.setFechafinal(sesionDto.getFechaFin());

            response = sesionesServicio.updateSesiones(sesion);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(sesionDto.getIdSesion());
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
     * Controlador para cancelar sesiones de tipo: Sensibilización, Valoración, 
     * Evaluación o Seguimiento.
     *
     * @param idSesion Identificador de la Sesión
     * @param tipoSesion Tipo de Sesión
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/eliminarSesion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO eliminarSesion(@RequestParam("idSesion") long idSesion,
            @RequestParam("tipoSesion") BigDecimal tipoSesion, Principal principal
    ) {
        Sesiones s = new Sesiones();
        s.setIdsesion(idSesion);
        s.setTiposesion(new Tiposesion(tipoSesion));
        ResponseDTO response = new ResponseDTO();
        response = sesionesServicio.deleteSesiones(s);
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
     * Controlador utilizado para ir a la vista correspondiente a Agendar Sesión 
     * Sensibilización.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return URL vista
     */
    @RequestMapping(path = "/consultarAgendaSensibilizacion")
    public String cargarAgenda(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario
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
                model.addAttribute("url", "/consultarAgendaSensibilizacion");
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
                    model.addAttribute("url", "/consultarAgendaSensibilizacion");
                    model.addAttribute("grupo", grupo.intValue());
                    return "setIdFuncionario";
                }
            }
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
        }

        model.addAttribute("idFuncionario", idfuncionario);

        return "agendarSensibilizacion";
    }

    /**
     * Controlador traer sesiones por funcionario.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Lista de Sesiones que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/consultaSesionesXSensibilizador")
    @ResponseBody
    public ResponseEntity<List<SesionesDTO>> consultaSesionesXSensibilizador(@RequestParam("idFuncionario") long idFuncionario
    ) {
        return new ResponseEntity<>(sesionesServicio.getSesionesXFuncionario(idFuncionario).getSesiones(), HttpStatus.OK);
    }

    /**
     * Controlador que se utiliza para asociar un beneficiario a una sesión de 
     * Sensibilización.
     *
     * @param idBeneficiario Identificador del Beneficiario
     * @param idSesion Identificador de la Sesión
     * @param email Correo electrónico del Beneficiario
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/asociarBeneficiarioSensibilizacion")
    @ResponseBody
    public ResponseAsociarBeneficiarioSesion asociarBeneficiarioSensibilizacion(
            @RequestParam("idBeneficiario") long idBeneficiario,
            @RequestParam("idSesion") long idSesion,
            @RequestParam("email") String email, Principal principal
    ) {
        ListaasistenciaDTO lista = new ListaasistenciaDTO();
        lista.setBeneficiario(new BeneficiarioDTO(idBeneficiario));
        lista.getBeneficiario().setEmail(email);
        lista.setSesiones(new SesionesDTO(idSesion));
        ResponseAsociarBeneficiarioSesion response;
        response = listaAsistenciaServicio.asociarBeneficiario(lista);
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
     * Método encargado de traer los asistentes de una Sesión.
     *
     * @param idsesion Identificador de la Sesión.
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * asistencia.
     */
    @GetMapping(path = "/getAsistentesSesion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerAsistentes getAsistentesSesion(@RequestParam("idsesion") int idsesion) {
        RequestTraerAsistentes request = new RequestTraerAsistentes();
        request.setIdsesion(idsesion);
        return listaAsistenciaServicio.getLista(request);
    }

    /**
     * Controlador encargado de verificar el estado de los requisitoss de un 
     * beneficiario.
     *
     * @param strBeneficiario Datos del Beneficiario
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no la consulta, condición para cada
     * validación.
     */
    @PostMapping(path = "/verificarRequisitos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseRequisitos verificarRequisitos(
            @RequestParam("strBeneficiario") String strBeneficiario,
            Principal principal) {
        ResponseRequisitos response = null;
        try {
            RequestConfiguraciones request = new RequestConfiguraciones();
            request.setConfiguraciones(DTOToEntity.
                    listDtoConfiguracionTolistConfiguracion(
                            configuracionServicio.getConfiguraciones().getConfiguraciones()));

            MdFDatosBasicos beneficiario = new Gson().fromJson(strBeneficiario, MdFDatosBasicos.class);
            response = beneficiarioServicio.verificarRequisitos(
                    new Gson().fromJson(strBeneficiario, MdFDatosBasicos.class), request);
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }
}

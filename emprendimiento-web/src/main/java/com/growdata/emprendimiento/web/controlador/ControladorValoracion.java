package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.valoracion.RespuestasValorV;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.TraerEncuestaDTO;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGuardarRespuestas;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasV;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGuardarRespuestas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestAsociarBeneficiariosValoracion;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetAsociadoXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetAsociadoXId;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerSesionesV;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerVInd;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVInd;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.servicio.AsociadoServicio;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.EncuestaServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.business.servicio.PreguntasServicio;
import com.growdata.emprendimiento.business.servicio.RespuestasEncuestaServicio;
import com.growdata.emprendimiento.business.servicio.RutaCapacitacionServicio;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseCapacitaciones;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestEmprendimientoPorDocEstados;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRompimientoDeFases;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerValoGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;
import com.growdata.emprendimiento.business.servicio.RutaAcompanamientoATServicio;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseActividadInternacional;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseDepartamentos;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseMunicipios;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponsePaises;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseSectorProductivo;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTipoConstitucionLegal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTiposEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

import com.growdata.emprendimiento.business.commons.EncriptadorUrl;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.RutacapacitacionDTO;

import com.growdata.emprendimiento.business.servicio.ActividadInternacionalServicio;
import com.growdata.emprendimiento.business.servicio.CapacitacionProgramaServicio;
import com.growdata.emprendimiento.business.servicio.DepartamentosServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.MunicipiosServicio;
import com.growdata.emprendimiento.business.servicio.PaisesServicio;
import com.growdata.emprendimiento.business.servicio.SectorProductivoServicio;
import com.growdata.emprendimiento.business.servicio.TemasIndividualesServicio;
import com.growdata.emprendimiento.business.servicio.TemasRutaAcompanamientoatServicio;
import com.growdata.emprendimiento.business.servicio.TemasRutaCapacitacionServicio;
import com.growdata.emprendimiento.business.servicio.TipoConstitucionLegalServicio;

import com.growdata.emprendimiento.business.servicio.TipoemprendimientoServicio;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;

import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Tiposesion;
import com.growdata.emprendimiento.persistence.entidad.Users;

import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Controller
public class ControladorValoracion {

    private final BigDecimal grupo = new BigDecimal(9);

    @Autowired
    private EncuestaServicio encuestaServicio;
    @Autowired
    private ListaAsistenciaServicio listaAsistenciaServicio;
    @Autowired
    private FuncionarioServicio funcionarioServicio;
    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;
    @Autowired
    private SesionesServicio sesionesServicio;
    @Autowired
    private RespuestasEncuestaServicio respuestasEncuestaServicio;
    @Autowired
    private BeneficiarioServicio beneficiarioServicio;
    @Autowired
    private AsociadoServicio asociadoServicio;
    @Autowired
    private PreguntasServicio preguntasServicio;
    @Autowired
    private RutaCapacitacionServicio rutaCapacitacionServicio;
    @Autowired
    private EmprendimientoServicio emprendimientoServicio;
    @Autowired
    private RutaAcompanamientoATServicio rutaAcompanamientoATServicio;
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
    private TemasIndividualesServicio temasIndividualesServicio;
    @Autowired
    private TemasRutaCapacitacionServicio temasRutaCapacitacionServicio;
    @Autowired
    private TemasRutaAcompanamientoatServicio temasRutaAcompanamientoatServicio;
    @Autowired
    private DepartamentosServicio departamentosServicio;
    @Autowired
    private MunicipiosServicio municipiosServicio;
    @Autowired
    private LogAuditoriaServicio logAuditoria;
    @Autowired
    private CapacitacionProgramaServicio capacitacionProgramaServicio;

    private String modulo = "Valoración";


    /**
     *
     * Controlador mostrar la vista con el calendario y las sesiones de
     * valoracion disponibles
     *
     * @return Vista
     */
    @GetMapping("/agendarSesionValoracion")
    public ModelAndView agendarSesionValoracion() {
        ModelAndView view = new ModelAndView("agendarSesionValoracion");
        return view;
    }

    /**
     *
     * Controlador mostrar la vista correspondiente a la funcionalidad Agendar
     * Sesión Valoración
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping(path = "/cargarDatosSesionValoracion")
    public String cargarDatosSesionValoracion(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {

        if (idfuncionario == null) {
            BeneficiarioDTO beneficiario = beneficiarioServicio.getBeneficiarioPorCorreo(
                    principal.getName()).getBeneficiario();

            List<GestionarFuncionarioDTO> cajasDTO;
            //Verifico si es un beneficiario.
            if (beneficiario != null) {
                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
                cajasDTO = response2.getFuncisDTO();
                model.addAttribute("cajasDTO", cajasDTO);
                model.addAttribute("url", "/cargarDatosSesionValoracion");
                model.addAttribute("grupo", grupo.intValue());
                model.addAttribute("idBeneficiario", beneficiario.getIdbeneficiario());
                return "setIdFuncionario";
            }

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
                model.addAttribute("url", "/cargarDatosSesionValoracion");
                model.addAttribute("grupo", grupo.intValue());
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
                            .getFuncionariosPorGrupoYCaja(grupo, funcionario.getCajacompensacion().getIdcajacompensacion())
                            .getFuncionariosDTO();

                    model.addAttribute("sensibilizadores", valoradores);
                    model.addAttribute("cajaN", funcionario.getCajacompensacion().getNombrecajacompensacion());
                    model.addAttribute("cajaID", funcionario.getCajacompensacion().getIdcajacompensacion());
                    model.addAttribute("url", "/cargarDatosSesionValoracion");
                    model.addAttribute("grupo", grupo.intValue());
                    return "setIdFuncionario";
                }
            }
            //Si soy valorador debo ir directo a seleccionar beneficiario.
            //model.addAttribute("url", "/cargarDatosSesionValoracion");
            idfuncionario = funcionario.getIdfuncionario();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        return "consultarBeneficiarioValoracion";
    }

    @PostMapping(path = "/cargarSesionesAgendadasV", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<SesionesDTO> cargarSesionesAgendadasV(Principal principal, @RequestParam(name = "valoradorId", required = false) BigDecimal valoradorId) {
        long idFValorador;
        if (valoradorId == null) {
            RequestIsFuncionarioGrupo requestFuncionarioGrupo = new RequestIsFuncionarioGrupo();
            String username;
            if (valoradorId != null) {
                RequestModificarFuncionario req = new RequestModificarFuncionario();

                ResponseModificarFuncionario resp = new ResponseModificarFuncionario();

                req.setIdfuncionario(valoradorId.longValue());
                resp = funcionarioServicio.getFuncionarioPorId(req);
                FuncionarioDTO fun = resp.getFuncionarioDTO();
                username = fun.getEmail();
            } else {
                username = principal.getName();
            }
            requestFuncionarioGrupo.setUserName(username);

            requestFuncionarioGrupo.setGrupo("Valorador");
            ResponseIsFuncionarioGrupo responseFuncionarioGrupo = funcionarioServicio.isFuncionarioDelGrupo(requestFuncionarioGrupo);
            idFValorador = responseFuncionarioGrupo.getFuncionarioDTO().getIdfuncionario();
        } else {
            idFValorador = valoradorId.longValue();
        }
        RequestTraerSesionesV request = new RequestTraerSesionesV();
        request.setIdFuncionario(idFValorador);
        request.setIdEstadoSesion(1);
        ResponseTraerSesiones response = sesionesServicio.getSesionesVXFuncionario(request);
        return response.getSesiones();
    }

//    @GetMapping("/registrarAsistenciaValoracion")
//    public String registrarAsistenciaValoracion(Model model, Principal principal, @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
//            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
//        String resp = "";
//        List<FuncionarioDTO> funcionariosDTO = new ArrayList();
//        List<SesionesDTO> sesiones = new ArrayList();
//        List<GestionarFuncionarioDTO> cajasDTO = new ArrayList();
//        RequestTraerFuncionarioPorUserName request5 = new RequestTraerFuncionarioPorUserName();
//        if (idfuncionario != null && idcajacompensacion != null) {
//            ResponseTraerSesiones response = sesionesServicio.getSesionesPorFuncionario(idfuncionario);
//            sesiones = response.getSesiones();
//            model.addAttribute("sesiones", sesiones);
//            resp = "registrarAsistenciaV";
//        } else {
//            if (idcajacompensacion != null) {
//                RequestGestionarCuentas request2 = new RequestGestionarCuentas();
//                ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
//                cajasDTO = response2.getFuncisDTO();
//                BigDecimal grupo = new BigDecimal(9);
//                ResponseTraerFuncionarios response3 = new ResponseTraerFuncionarios();
//                try {
//                    response3 = funcionarioServicio.getFuncionariosPorGrupoYCaja(grupo, idcajacompensacion);
//                } catch (Exception ex) {
//                    Logger.getLogger(ControladorSensibilizacion.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                funcionariosDTO = response3.getFuncionariosDTO();
//                model.addAttribute("funcionariosDTO", funcionariosDTO);
//                model.addAttribute("cajasDTO", cajasDTO);
//                model.addAttribute("idcajacompensacion", idcajacompensacion);
//                resp = "registrarAsistenciaAdminV";
//            } else {
//                request5.setUserName(principal.getName());
//                request5.setIdEstado(BigDecimal.ONE);
//                ResponseTraerFuncionarioPorUserName response5 = funcionarioServicio.getFuncionarioPorUserName(request5);
//                FuncionarioDTO funcionario = response5.getFuncionarioDTO();
//                if (response5.getFuncionarioDTO() != null) {
//                    try {
//                        ResponseTraerSesiones response = sesionesServicio.getSesionesPorFuncionario(funcionario.getIdfuncionario());
//                        sesiones = response.getSesiones();
//                        model.addAttribute("sesiones", sesiones);
//                        resp = "registrarAsistenciaV";
//                    } catch (Exception ex) {
//                        Logger.getLogger(ControladorSensibilizacion.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                } else {
//                    RequestGestionarCuentas request2 = new RequestGestionarCuentas();
//                    ResponseGestionarCuentas response2 = cajasDeCompensacionServicio.getNombresCajas(request2);
//                    cajasDTO = response2.getFuncisDTO();
//                    model.addAttribute("cajasDTO", cajasDTO);
//                    resp = "registrarAsistenciaAdminV";
//                }
//            }
//
//        }
//        return resp;
//    }
    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Url vista
     */
    @RequestMapping("/registrarAsistenciaValoracion")
    public String registrarAsistenciaValoracion(Model model, Principal principal, @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
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
                model.addAttribute("url", "/registrarAsistenciaValoracion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();

        }

        model.addAttribute("idFuncionario", idfuncionario);

        return "registrarAsistenciaV";
    }
    /**
     * Metodo que trae los asistentes a una sesion de valoracion basandose en el
     * id de la sesion
     *
     * @param idfuncionario El id del funcionario
     * @param idsesion El id de la sesión
     * @param fecha Fecha
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("/traerAsistentesV")
    public String traerAsistentesV(@RequestParam("idfuncionario") int idfuncionario, @RequestParam("idsesion") int idsesion, @RequestParam(name = "fecha", required = false) Timestamp fecha,
            Model model) {
//            @RequestParam("idestadosesion") long idestadosesion, Model model) {

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
//        model.addAttribute("idestadosesion", idestadosesion);
        model.addAttribute("idfuncionario", idfuncionario);
        model.addAttribute("status", status);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("listaAsistencia", listaAsistencia);
        model.addAttribute("idsesion", idsesion);
//        } else {
//            resp = "errorFecha";
//        }

        return "registrarAsistencia2V";
    }

    /**
     * Metodo que registra las asistencias de una sesion de valoracion
     *
     * @param idfuncionario El id del funcionario
     * @param asisten Contiene el id de asistencia y su valor
     * @param idsesion El id de la sesión
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @RequestMapping("/registroAsistenciasV")
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
                a.setIdasistencia(arr.getInt(i));
                String g = arr2.getString(i);
                a.setValor(g.charAt(0));
                asistencias.add(a);
            }
        }
        request.setIdfuncionario(idfuncionario);
        request.setIdsesion(idsesion);
        request.setAsistencias(asistencias);
        response = listaAsistenciaServicio.registroAsistenciasV(request);
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
     * Metodo que desencripta los parametros y trae la encuesta de valoracion en
     * base a ellos
     *
     * @param xthewr El id del beneficiario, el id del funcionario y el id de la
     * encuesta encriptados
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/encuestaValoracion")
    public String mostrarEncuesta(@RequestParam("xthewr") String xthewr, Model model) {
        String respuesta = "encuestaValoracion";

        int idBeneficiario = -1;
        long idfuncionario = -1;
        long idEncuesta = -1;

        String decodificado = EncriptadorUrl.decode(xthewr);

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

        ResponseTraerEncuesta response = encuestaServicio.getEncuestaValoracion(request);
        //valido el valor response
        if ("0".equals(response.getStatus())) {
            String mensaje = response.getDescripcion();
            model.addAttribute("mensaje", mensaje);
            respuesta = "errorEncuesta";
        } else {
            //Traigo las preguntas del dao
            List<PreguntasDTO> preguntasDTO = response.getPreguntasDTO();
            // agrego las preguntas al modelo
            model.addAttribute("idBeneficiario", idBeneficiario);
            model.addAttribute("preguntasDTO", preguntasDTO);
            model.addAttribute("idEncuesta", idEncuesta);
        }
        return respuesta;

    }

    /**
     * Metodo que registra las respuestas a la encuesta de valoracion
     *
     * @param idbeneficiario El id del beneficiario
     * @param respuestas Las respuestas de la encuesta
     * @param idEncuesta El id de la encuesta
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Respuesta si se guardaron las respuestas de la encuesta
     * exitosamente o no
     */
    @PostMapping(path = "registrarEncuestaValoracion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGuardarRespuestas registrarEncuestaValoracion(@RequestParam("idBeneficiario") long idbeneficiario, @RequestParam("respuestas") String respuestas,
            @RequestParam("idEncuesta") long idEncuesta, Model model, Principal principal) {
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
        RequestGuardarRespuestas request = new RequestGuardarRespuestas();
        ResponseGuardarRespuestas response = new ResponseGuardarRespuestas();
        request.setIdEncuesta(idEncuesta);
        request.setRespuestasValor(respuestasV);
        response = respuestasEncuestaServicio.guardarRespuestas(request);
        Beneficiario beneficiario = beneficiarioServicio.getBeneficiario(idbeneficiario);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

           
            requestA.setUsers(new Users(beneficiario.getEmail()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idEncuesta);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String respuesta;
        if ("1".equals(response.getStatus())) {
            respuesta = "1";
        } else {
            respuesta = "0";
        }
        model.addAttribute("respuesta", respuesta);

        return response;
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
    @RequestMapping(path = "/valoracionIndividual")
    public String valoracionIndividual(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion
    ) {
        if (idfuncionario == null || idcajacompensacion == null) {

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
                model.addAttribute("url", "/valoracionIndividual");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();

        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("idCajacompensacion", idcajacompensacion);

        return "valoracionIndividualAdmin";
    }

    /**
     * Metodo que trae la encuesta de valoracion individual en base al id de la
     * caja de compensacion
     *
     * @param idBeneficiario El id del beneficiario
     * @param idFuncionario El id del funcionario
     * @param idcajacompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("traerValoracionIndividual")
    public String traerValoracionIndividual(@RequestParam("idBeneficiario") long idBeneficiario,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion, Model model) {

        RequestGetAsociadoXId request = new RequestGetAsociadoXId();
        request.setIdBeneficiario(idBeneficiario);
        ResponseGetAsociadoXId response = new ResponseGetAsociadoXId();
        ResponseTraerEncuesta response2 = new ResponseTraerEncuesta();
        RequestTraerVInd request2 = new RequestTraerVInd();
        request2.setIdBeneficiario(idBeneficiario);
        request2.setIdFuncionario(idFuncionario);
        request.setIdCajacompensacion(idcajacompensacion);
        response = asociadoServicio.getAsociadoXId(request);
        if ("1".equals(response.getStatus())) {
            response2 = encuestaServicio.getEncuestaValoracionInd(request2);
            model.addAttribute("preguntasDTO", response2.getPreguntasDTO());
            model.addAttribute("idBeneficiario", idBeneficiario);
            model.addAttribute("idFuncionario", idFuncionario);
            model.addAttribute("mensajeError", response2.getDescripcion());
        } else {
            model.addAttribute("mensajeError", response.getDescripcion());

        }
        return "encuestaValoracionInd";
    }

    /**
     * Metodo que calcula las horas sugeridas de cada tema dependiendo de las
     * respuestas de la encuesta de valoracion
     *
     * @param idbeneficiario El id del beneficiario
     * @param respuestas Las respuestas de la encuesta
     * @param model Modelo JSP
     * @param temasAgregados Temas agregados
     * @param idruta El id de la ruta
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("registrarEncuestaValoracionInd")
    public String registrarEncuestaValoracionInd(@RequestParam("idBeneficiario") long idbeneficiario,
            @RequestParam(name = "respuestas", required = false) String respuestas,
            Model model, @RequestParam(name = "temasAgregados", required = false) String temasAgregados,
            @RequestParam(name = "idruta", required = false) Long idruta, Principal principal) {
        List<TemasrutacapacitacionDTO> temasRuta = new ArrayList();

        if (temasAgregados == null) {
            List<RespuestasValorV> respuestasV = new ArrayList<>();
            if (respuestas != null) {
                System.out.println(respuestas);
                respuestas = respuestas.replace("[{", "{");
                respuestas = respuestas.replace("}]", "}");
                System.out.println("Despues del replace--->" + respuestas);
                JSONObject obj = new JSONObject(respuestas);

                JSONArray arr = obj.getJSONArray("pregunta");
                JSONArray arr2 = obj.getJSONArray("valor");
                JSONArray arr3 = obj.getJSONArray("tema");
                for (int i = 0; i < arr.length(); i++) {
                    RespuestasValorV r = new RespuestasValorV();
                    r.setIdpregunta(BigDecimal.valueOf(arr.getDouble(i)));
                    r.setRespuesta(arr2.getString(i));
                    r.setIdtema(BigDecimal.valueOf(arr3.getDouble(i)));
                    respuestasV.add(r);
                }

            }

            RequestGuardarRespuestasV request = new RequestGuardarRespuestasV();
            ResponseGuardarRespuestasVInd response = new ResponseGuardarRespuestasVInd();
            request.setRespuestasV(respuestasV);
            request.setIdBeneficiario(idbeneficiario);
            response = rutaCapacitacionServicio.crearRutaCapacitacion(request);
            if ("1".equals(response.getStatus())) {

                if (response.getAccion() != null) {
                    RequestLogAuditoria requestA = new RequestLogAuditoria();

                   
                    requestA.setAccion(response.getAccion());
                    requestA.setUsers(new Users(principal.getName()));
                    requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                    requestA.setIdelemento(response.getId());
                    requestA.setModulo(modulo);
                    logAuditoria.registrarLog(requestA);
                }

            }
            String mensaje = response.getDescripcion();
            String status = response.getStatus();

            if ("1".equals(response.getStatus())) {

                temasRuta = response.getTemasRuta();

                model.addAttribute("idBeneficiario", idbeneficiario);
                model.addAttribute("idruta", temasRuta.get(0).getRutacapacitacion().getIdrutacapacitacion());
                model.addAttribute("temasRuta", temasRuta);
                model.addAttribute("mensaje", mensaje);
                model.addAttribute("status", status);

            } else {
                model.addAttribute("mensaje", mensaje);
                model.addAttribute("status", status);
            }
        } else {

            String status = "1";
            String mensaje = "Tema agregado exitosamente";
            temasAgregados = temasAgregados.replace("[{", "{");
            temasAgregados = temasAgregados.replace("}]", "}");
            JSONObject obj = new JSONObject(temasAgregados);
            JSONArray arr5 = obj.getJSONArray("tema");
            JSONArray arr6 = obj.getJSONArray("hora");
            for (int i = 0; i < arr5.length(); i++) {
                TemasrutacapacitacionDTO te = new TemasrutacapacitacionDTO();
                te.setCantidadhorasplaneadas(new BigDecimal(arr6.getString(i)));
                te.setNombretema(arr5.getString(i));

                temasRuta.add(te);
            }

            model.addAttribute("idBeneficiario", idbeneficiario);
            model.addAttribute("idruta", idruta);
            model.addAttribute("temasRuta", temasRuta);
            model.addAttribute("status", status);
            model.addAttribute("mensaje", mensaje);

        }

        ResponseCapacitaciones response2 = capacitacionProgramaServicio.getCapacitaciones();
        
        model.addAttribute("temasIndividuales", response2.getCapacitaciones());
        model.addAttribute("mensajeIndividuales", response2.getDescripcion());
        model.addAttribute("statusindividuales", response2.getStatus());

        return "confirmarTemasRuta";
    }

    /**
     *
     * Controlador que muestra la vista para la funcionalidad Programar
     * Sesiones.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping("/programarValoracion")
    public String programarValoracion(Model model, Principal principal,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {

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
                model.addAttribute("url", "/programarValoracion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }
        model.addAttribute("idFuncionario", idfuncionario);
        return "programarValoracion";

    }

    /**
     *
     * Controlador encargado de ubicar un beneficiario por número de documento.
     *
     * @param doc Número de Documento
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Beneficiarios que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getBeneficiarioDOC", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarioDOC(@RequestParam(name = "doc", required = false) String doc) {
        return beneficiarioServicio.getBeneficiarios(null, doc, null, null, null, null);
    }

    /**
     * Controlador encargado de ubicar un beneficiario por identificador.
     *
     * @param id Identificador del Beneficiario.
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Beneficiarios que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getBeneficiarioID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarioID(@RequestParam(name = "id", required = false) Long id) {
        return beneficiarioServicio.getBeneficiarios(id, null, null, null, null, null);
    }

    /**
     *
     * Controlador encargado de ubicar un beneficiario por nombre y apellido.
     *
     * @param pNombre Primer nombre del beneficiario
     * @param sNombre Segundo nombre del beneficiario
     * @param pApellido Primer apellido del beneficiario
     * @param sApellido Segundo apellido del beneficiario
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de
     * Beneficiarios que cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getBeneficiarioNombreApellido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarioNombreApellido(
            @RequestParam(name = "pNombre", required = false) String pNombre,
            @RequestParam(name = "sNombre", required = false) String sNombre,
            @RequestParam(name = "pApellido", required = false) String pApellido,
            @RequestParam(name = "sApellido", required = false) String sApellido) {
        return beneficiarioServicio.getBeneficiarios(null, null, pNombre, sNombre, pApellido, sApellido);
    }

    /**
     *
     * Controlador encargado de asociar beneficiarios a una sesión de Valoración
     *
     * @param strRequest Datos de los Beneficiarios.
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/asociarBeneficiariosValoracion")
    @ResponseBody
    public ResponseAsociarBeneficiarioSesion asociarBeneficiariosValoracion(
            @RequestParam("requestEmp") String strRequest, Principal principal
    ) {
        RequestAsociarBeneficiariosValoracion request = new RequestAsociarBeneficiariosValoracion();
        ResponseAsociarBeneficiarioSesion response = new ResponseAsociarBeneficiarioSesion();
        try {
            request = new Gson().fromJson(strRequest, RequestAsociarBeneficiariosValoracion.class);
            response = listaAsistenciaServicio.asociarBeneficiarioValoracion(request);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

               
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(request.getIdSesion());
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
     *
     * Método auxiliar para cargar información al mostrar la vista Registrar
     * Emprendimiento.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     */
    private void registrarEmprendimiento(Model model, Principal principal) {
        ResponsePaises response = paisServicio.getPaises();
        if ("1".equals(response.getStatus())) {
            model.addAttribute("paises", response.getPaises());
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

    }


    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el beneficiario
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @param beneficiarios Lista de beneficiarios
     * @return Url vista dependiendo del tipo de usuario
     */
    @RequestMapping(path = "/valoracionGrupal")
    public String valoracionGrupal(Model model, Principal principal, @RequestParam(name = "idcajacompensacion",
            required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario,
            @RequestParam(name = "beneficiarios", required = false) List<BeneficiarioDTO> beneficiarios) {

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
                model.addAttribute("url", "/valoracionGrupal");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }

            //Sino, es un funcionario. Verifico si es tipo 9 (Valorador)            
            //Si soy sensibilizador debo ir directo a la vista para agendar beneficiario.
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();

        }
        model.addAttribute("idCajaCompensacion", idcajacompensacion);
        model.addAttribute("idFuncionario", idfuncionario);

        return "valoracionGrupalAdmin";
    }

    /**
     * Metodo que busca emprendimientos por nombre
     *
     * @param nombreEmprendimiento Nombre del emprendimiento
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @param idfuncionario El id del funcionario
     * @return Lista de emprendimientos
     */
    @GetMapping(path = "/getEmprendimientoPorNombre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombre(@RequestParam("nombreEmprendimiento") String nombreEmprendimiento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
        request.setNombreEmprendimiento(nombreEmprendimiento);
        List<String> setEstados = new ArrayList();
        setEstados.add("1");
        setEstados.add("2");
        request.setEstados(setEstados);
        request.setIdcajacompensacion(idcajacompensacion);
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        response = emprendimientoServicio.getEmprendimientoPorNombre(request);

        return response;
    }
    /**
     * Metodo que trae la encuesta de valoracion grupal basandose en el id de
     * funcionario y el id de emprendimiento
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param idFuncionario El id del funcionario
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping("/traerValoracionGrupal")
    public String traerValoracionGrupal(@RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("idFuncionario") long idFuncionario, Model model) {

        ResponseTraerEncuesta response = new ResponseTraerEncuesta();
        RequestTraerValoGrupal request = new RequestTraerValoGrupal();
        request.setIdEmprendimiento(idEmprendimiento);
        request.setIdFuncionario(idFuncionario);

        response = encuestaServicio.getEncuestaValoracionGrupal(request);
        model.addAttribute("preguntasDTO", response.getPreguntasDTO());
        model.addAttribute("idEmprendimiento", idEmprendimiento);
        model.addAttribute("idFuncionario", idFuncionario);

        return "encuestaValoracionGrupal";
    }

    /**
     * Metodo que calcula las horas sugeridas de cada tema dependiendo de las
     * respuestas de la encuesta de valoracion
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param respuestas Las respuestas de la encuesta
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/registrarEncuestaValoracionGrupal")
    public String registrarEncuestaValoracionGrupal(@RequestParam("idEmprendimiento") long idEmprendimiento,
            @RequestParam("respuestas") String respuestas, Principal principal,
            Model model) {
        List<RespuestasValorV> respuestasV = new ArrayList<>();
        if (respuestas != null) {
            System.out.println(respuestas);
            respuestas = respuestas.replace("[{", "{");
            respuestas = respuestas.replace("}]", "}");
            System.out.println("Despues del replace--->" + respuestas);
            JSONObject obj = new JSONObject(respuestas);

            JSONArray arr = obj.getJSONArray("pregunta");
            JSONArray arr2 = obj.getJSONArray("valor");
            JSONArray arr3 = obj.getJSONArray("tema");
            for (int i = 0; i < arr.length(); i++) {
                RespuestasValorV r = new RespuestasValorV();
                r.setIdpregunta(BigDecimal.valueOf(arr.getDouble(i)));
                r.setRespuesta(arr2.getString(i));
                r.setIdtema(BigDecimal.valueOf(arr3.getDouble(i)));
                respuestasV.add(r);
            }

        }

        RequestGuardarRespuestasVGrupal request = new RequestGuardarRespuestasVGrupal();
        ResponseGuardarRespuestasVGrupal response = new ResponseGuardarRespuestasVGrupal();
        request.setRespuestasV(respuestasV);
        request.setIdEmprendimiento(idEmprendimiento);
        response = rutaAcompanamientoATServicio.crearRutaAcompanamientoAT(request);
        if ("1".equals(response.getStatus())) {
            if (response.getAccion() != null) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

               
                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(response.getId());
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }

        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        List<TemasrutaacompanamientoatDTO> temasRuta = new ArrayList();

        if ("1".equals(response.getStatus())) {
            temasRuta = response.getTemasRuta();
            model.addAttribute("idEmprendimiento", idEmprendimiento);
            model.addAttribute("temasRuta", temasRuta);
            model.addAttribute("idruta", response.getIdRuta());
            model.addAttribute("mensaje", mensaje);
            model.addAttribute("status", status);
        } else {
            model.addAttribute("mensaje", mensaje);
            model.addAttribute("status", status);
        }
        return "confirmarTemasRutaAComp";
    }

    /**
     *
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Registrar Emprendimiento
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @param idcajacompensacion Identificador Caja de Compensación
     * @return Url vista
     */
    @RequestMapping(path = "/setDatosRegistrarEmprendimiento")
    public String setDatosRegistrarEmprendimiento(Model model, Principal principal,
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
                model.addAttribute("url", "/setDatosRegistrarEmprendimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
            idcajacompensacion = funcionario.getCajacompensacion().getIdcajacompensacion();
       
            registrarEmprendimiento(model, principal);
        }
        model.addAttribute(
                "idCajacompensacion", idcajacompensacion);
        model.addAttribute(
                "idFuncionario", idfuncionario);
        registrarEmprendimiento(model, principal);
        return "registrarEmprendimientoView";
    }

    /**
     *
     * Controlador para registrar un emprendimiento formalizado
     *
     * @param strRequest Datos del Emprendimiento
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/registrarFormalizado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarFormalizado(
            @RequestParam("requestEmp") String strRequest, Principal principal
    ) {
        RequestRegistrarFormalizado request = new RequestRegistrarFormalizado();
        ResponseDTO response = new ResponseDTO();
        try {
            Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            request = g.fromJson(strRequest, RequestRegistrarFormalizado.class);
            response = emprendimientoServicio.guardarFormalizado(request);
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
     *
     * Controlador para registrar un emprendimiento no establecido
     *
     * @param strRequest Datos del Emprendimiento
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/registrarNoEstablecido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarNoEstablecido(
            @RequestParam("requestEmp") String strRequest, Principal principal
    ) {
        RequestNoEstablecido request = new RequestNoEstablecido();
        ResponseDTO response = new ResponseDTO();
        try {
            Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            request = g.fromJson(strRequest, RequestNoEstablecido.class);
            response = emprendimientoServicio.guardarNoEstablecido(request);
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
     * Metodo que guarda las horas y los temas que haya agregado el valorador
     *
     * @param idbeneficiario El id del beneficiario
     * @param model Modelo JSP
     * @param temasAgregados Temas agregados
     * @param idruta El id de la ruta
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/guardarTemasValoracionInd")
    public String guardarTemasValoracionInd(@RequestParam("idBeneficiario") long idbeneficiario,
            Model model, @RequestParam(name = "temasAgregados") String temasAgregados,
            @RequestParam(name = "idruta") Long idruta, Principal principal) {
        List<TemasrutacapacitacionDTO> temasRuta = new ArrayList();
        temasAgregados = temasAgregados.replace("[{", "{");
        temasAgregados = temasAgregados.replace("}]", "}");
        JSONObject obj = new JSONObject(temasAgregados);
        JSONArray arr5 = obj.getJSONArray("tema");
        JSONArray arr6 = obj.getJSONArray("hora");
        for (int i = 0; i < arr5.length(); i++) {
            TemasrutacapacitacionDTO te = new TemasrutacapacitacionDTO();
            RutacapacitacionDTO ruta = new RutacapacitacionDTO();
            ruta.setIdrutacapacitacion(idruta);
            te.setRutacapacitacion(ruta);
            te.setCantidadhorasplaneadas(new BigDecimal(arr6.getString(i)));
            te.setNombretema(arr5.getString(i));

            temasRuta.add(te);
        }

        RequestGuardarTemasValoracionInd request = new RequestGuardarTemasValoracionInd();
        request.setIdbeneficiario(idbeneficiario);
        request.setIdruta(idruta);
        request.setTemasRuta(temasRuta);
        ResponseGuardarTemasValoracionInd response = new ResponseGuardarTemasValoracionInd();
        response = temasRutaCapacitacionServicio.crearTemas(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

           
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idruta);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Temas de Valoración Individual");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "confirmar";
    }

    /**
     *
     * Controlador para liberar sesiones de tipo: Sensibilización, Valoración,
     * Evaluación y Seguimiento.
     *
     * @param idSesion Identificador de la sesión
     * @param tipoSesion Tipo de Sesión
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @GetMapping(path = "/liberarSesion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO liberarSesion(@RequestParam("idSesion") long idSesion,
            @RequestParam("tipoSesion") BigDecimal tipoSesion, Principal principal
    ) {
        Sesiones s = new Sesiones();
        s.setIdsesion(idSesion);
        s.setTiposesion(new Tiposesion(tipoSesion));
        ResponseDTO response = new ResponseDTO();
        response = sesionesServicio.liberarSesiones(s);
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
     *
     * Controlador que busca emprendimientos por documento de beneficiario
     *
     * @param documento Número de Documento
     * @param model Modelo JSP
     * @param idcajacompensacion Identificador de la Caja de Compensación
     * @param idfuncionario Identificador del Funcionario
     * @return Respuesta si fue exitosa o no la consulta, y el emprendimiento
     * conseguido.
     */
    @GetMapping(path = "/getEmprendimientoPorDoc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDoc(@RequestParam("documento") String documento, Model model,
            @RequestParam(name = "idcajacompensacion", required = false) BigDecimal idcajacompensacion,
            @RequestParam(name = "idfuncionario", required = false) Long idfuncionario) {
        ResponseTraerEmprendimientoPorNombre response = new ResponseTraerEmprendimientoPorNombre();
        RequestEmprendimientoPorDocEstados request = new RequestEmprendimientoPorDocEstados();
        request.setDoc(documento);
        List<String> setEstados = new ArrayList();
        setEstados.add("1");
        setEstados.add("2");
        request.setEstados(setEstados);
        response = emprendimientoServicio.getEmprendimientoPorDoc(request);

        return response;
    }

    /**
     * Metodo que guarda las horas y los temas que haya agregado el valorador
     * @param idEmprendimiento El id del emprendimiento
     * @param model Modelo JSP
     * @param temasAgregados Temas agregados
     * @param idruta El id de la ruta
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/guardarTemasValoracionGrupal")
    public String guardarTemasValoracionGrupal(@RequestParam("idEmprendimiento") long idEmprendimiento,
            Model model, @RequestParam(name = "temasAgregados") String temasAgregados,
            @RequestParam(name = "idruta") Long idruta, Principal principal) {
        Date date = new Date();
        List<TemasrutaacompanamientoatDTO> temasRuta = new ArrayList();
        temasAgregados = temasAgregados.replace("[{", "{");
        temasAgregados = temasAgregados.replace("}]", "}");
        JSONObject obj = new JSONObject(temasAgregados);
        JSONArray arr5 = obj.getJSONArray("tema");
        JSONArray arr6 = obj.getJSONArray("hora");
        JSONArray arr7 = obj.getJSONArray("idTema");
        for (int i = 0; i < arr5.length(); i++) {
            TemasrutaacompanamientoatDTO te = new TemasrutaacompanamientoatDTO();
            RutaacompanamientoatDTO ruta = new RutaacompanamientoatDTO();
            EmprendimientoDTO emprendimiendoDTO = new EmprendimientoDTO();
            TemasEvaluacionDTO temasevaluacion = new TemasEvaluacionDTO();
            temasevaluacion.setNombretema(arr5.getString(i));
            temasevaluacion.setIdtema(new BigDecimal(arr7.getDouble(i)));
            emprendimiendoDTO.setIdemprendimiento(idEmprendimiento);
            ruta.setEmprendimiento(emprendimiendoDTO);
            ruta.setIdrutaacompanamientoat(idruta);
            te.setRutaacompanamientoat(ruta);
            te.setCantidadhorasplaneadas(new BigDecimal(arr6.getString(i)));
            te.setTemasevaluacion(temasevaluacion);
            te.setFecharegistro(date);
            temasRuta.add(te);
        }

        RequestGuardarTemasValoracionGrupal request = new RequestGuardarTemasValoracionGrupal();
        request.setIdEmprendimiento(idEmprendimiento);
        request.setTemasRuta(temasRuta);
        ResponseGuardarTemasValoracionInd response = new ResponseGuardarTemasValoracionInd();
        response = temasRutaAcompanamientoatServicio.crearTemas(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
           
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idruta);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Temas de Valoración Grupal");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "confirmar";
    }

    /**
     *
     * Controlador que busca los municipios de un determinado departamento
     *
     * @param iddepartamento Identificador del Departamento
     * @return Respuesta si fue exitósa o no la búsqueda, y los Municipios que
     * cumplan con los criterios de búsqueda.
     */
    @GetMapping(path = "/getMunicipiosPorDepartamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseMunicipios getMunicipiosPorDepartamento(@RequestParam("iddepartamento") BigDecimal iddepartamento) {
        return municipiosServicio.getMunicipiosPorDepartamento(iddepartamento);
    }

    /**
     * Metodo que actualiza un emprendimiento
     *
     * @param idEstadoASaltar El id del estado al que se desea actualizar el
     * emprendimiento
     * @param idEmprendimiento El id del emprendimiento a actualizar
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/rompimientoDeFases")
    public String rompimientoDeFases(@RequestParam("idEstadoASaltar") BigDecimal idEstadoASaltar,
            @RequestParam("idEmprendimiento") long idEmprendimiento, Principal principal,
            Model model) {
        RequestRompimientoDeFases request = new RequestRompimientoDeFases();
        request.setIdEmprendimiento(idEmprendimiento);
        request.setIdEstadoASaltar(idEstadoASaltar);
        ResponseDTO response = emprendimientoServicio.rompimientoDeFases(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
           
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idEmprendimiento);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        model.addAttribute("mensajeTitulo", "Salto de Fase");
        model.addAttribute("mensaje", response.getDescripcion());
        model.addAttribute("status", response.getStatus());
        return "confirmar";
    }
}

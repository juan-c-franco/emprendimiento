/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseCapacitaciones;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseDocentes;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSedes;
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.HerramientaValoracionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.PreguntasTemaDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCategoria;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestDocente;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarEntidadF;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModuloCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerHerramientaValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerHerramientasValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerLogA;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerPreguntasXTemaHerramientaCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerTemasPorCajaYHerramienta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComiteLibres;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEstadoDocentes;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGetCategorias;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModulosCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCategoria;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerDocente;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEstadosCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerHerramientaValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerHerramientasValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerLogA;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerModulo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerPreguntasXTemaHerramientaCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerTemasPorCajaYHerramienta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComiteLibres;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TraerEntidadesFinancierasDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.UsuarioComiteDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerTipoD;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerTipoD;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.CapacitacionProgramaServicio;
import com.growdata.emprendimiento.business.servicio.CategoriaServicio;
import com.growdata.emprendimiento.business.servicio.ConfiguracionServicio;
import com.growdata.emprendimiento.business.servicio.DocentesServicio;
import com.growdata.emprendimiento.business.servicio.EntidadesFinancierasServicio;
import com.growdata.emprendimiento.business.servicio.EstadoCapacitacionProgramaServicio;
import com.growdata.emprendimiento.business.servicio.EstadoDocenteServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.HerramientaValoracionServicio;
import com.growdata.emprendimiento.business.servicio.InstitucionesServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.ModuloCicloServicio;
import com.growdata.emprendimiento.business.servicio.PreguntasServicio;
import com.growdata.emprendimiento.business.servicio.SedesServicio;
import com.growdata.emprendimiento.business.servicio.TipoDocumentoServicio;
import com.growdata.emprendimiento.persistence.entidad.Estadodocente;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Controller
public class ControladorParametrizacion {

    @Autowired
    private EntidadesFinancierasServicio entidadesFinancierasServicio;

    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;

    @Autowired
    private HerramientaValoracionServicio herramientaValoracionServicio;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @Autowired
    private ConfiguracionServicio configuracionServicio;

    @Autowired
    private PreguntasServicio preguntasServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;

    @Autowired
    private LoggerEmprendimiento log;

    @Autowired
    private InstitucionesServicio institucionesServicio;

    @Autowired
    private CapacitacionProgramaServicio capacitacionProgramaServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @Autowired
    private EstadoCapacitacionProgramaServicio estadoCapacitacionProgramaServicio;

    @Autowired
    private ModuloCicloServicio moduloCicloServicio;

    @Autowired
    private DocentesServicio docentesServicio;

    @Autowired
    private TipoDocumentoServicio tipoDocumentoServicio;

    @Autowired
    private EstadoDocenteServicio estadoDocenteServicio;

    @Autowired
    private SedesServicio sedesServicio;

    private String modulo = "Parametrizacion";


    /**
     * Metodo que trae las entidades financieras
     *
     * @param model Modelo JSP
     * @param mensaje3 Mensaje de respuesta de una acción
     * @param status3 Status de respuesa de una acción
     * @return Url Vista
     */
    @GetMapping("/entidadesFinancieras")
    public String entidadesFinancieras(Model model, @RequestParam(name = "mensaje3", required = false) String mensaje3,
            @RequestParam(name = "status3", required = false) String status3) {

        RequestTraerEntidadesFinancieras request = new RequestTraerEntidadesFinancieras();
        //traigo las entidades financieras
        ResponseTraerEntidadesFinancieras response = entidadesFinancierasServicio.getEntidadesFinancierasAdmin(request);

        List<TraerEntidadesFinancierasDTO> entidades = response.getEntidadesDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("status3", status3);
        model.addAttribute("entidades", entidades);
        model.addAttribute("mensaje3", mensaje3);
        return "entidadesFinancieras";
    }

    /**
     * metodo que muestra la pagina de registro de entidades financieras
     *
     * @return Url vista
     */
    @GetMapping("/registroEntidadFinanciera")
    public String registroEntidadFinanciera() {
        return "registroEntidadFinanciera";
    }

    /**
     * Metodo que registra la nueva entidad financiera
     *
     * @param principal Usuario en sesión
     * @param descripcion Descripcion de la entidad
     * @param estado Estado de la entidad.
     * @param nombreEntidad Nombre de la entidad financiera
     * @param atr Atributos del modelo.
     * @return Url vista
     */
    @PostMapping("/registrarEntidadFinanciera")
    public String registrarEntidadFinanciera(Principal principal,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("estado") char estado,
            @RequestParam("nombreEntidad") String nombreEntidad,
            RedirectAttributes atr) {
        EntidadesfinancierasDTO entidadesfinancierasDTO = new EntidadesfinancierasDTO();
        entidadesfinancierasDTO.setDescripcion(descripcion);
        entidadesfinancierasDTO.setEstado(estado);
        entidadesfinancierasDTO.setNombreentidad(nombreEntidad);
        //registro la entidad
        RequestRegistrarEntidadFinanciera request2 = new RequestRegistrarEntidadFinanciera();
        request2.setEntidadesfinancierasDTO(entidadesfinancierasDTO);
        ResponseRegistrarEntidadFinanciera response2 = new ResponseRegistrarEntidadFinanciera();
        response2 = entidadesFinancierasServicio.setEntidadFinanciera(request2);
        String mensaje3 = response2.getDescripcion();

        atr.addAttribute("mensaje3", mensaje3);
        atr.addAttribute("status3", response2.getStatus());
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response2.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
//          //traigo las entidades financieras
//        RequestTraerEntidadesFinancieras request = new RequestTraerEntidadesFinancieras();
//       
//        ResponseTraerEntidadesFinancieras response = entidadesFinancierasServicio.getEntidadesFinancieras(request);
//
//        List<TraerEntidadesFinancierasDTO> entidades = response.getEntidadesDTO();
//        String mensaje = response.getDescripcion();
//        String status = response.getStatus();
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("status", status);
//        model.addAttribute("entidades", entidades);
        return "redirect:entidadesFinancieras";
    }

    /**
     * Metodo que muestra la pantalla de modificacion de entidades financieras y
     * trae los datos de la entidad a modificar
     *
     * @param identidadfinanciera El id de la entidad financiera
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/modificarEntidadFinanciera")
    public String modificarEntidadFinanciera(@RequestParam("identidadfinanciera") BigDecimal identidadfinanciera, Model model) {
        RequestModificarEntidadF request = new RequestModificarEntidadF();
        request.setIdentidadfinanciera(identidadfinanciera);
        ResponseModificarEntidadFinanciera response = new ResponseModificarEntidadFinanciera();
        response = entidadesFinancierasServicio.getEntidadFinanciera(request);
        TraerEntidadesFinancierasDTO entidadDTO = response.getEntidadDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();

        model.addAttribute("entidadDTO", entidadDTO);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);

        return "modificarEntidadFinanciera";
    }

    /**
     * metodo que actualiza la entidad
     *
     * @param identidadesfinanciera EL id de la entidad financiera
     * @param nombreentidad Nombre de la entidad financiera
     * @param model Modelo JSP
     * @param estado El estado de la entidad financiera
     * @param atr Redireccionador de atributos
     * @param descripcion La descripción de la entidad financiera
     * @param principal Sesion Spring Security
     * @return Url vista
     */
    @PostMapping("/modificarEntidadFinanciera2")
    public String modificarEntidadFinanciera2(@RequestParam("identidadesfinanciera") BigDecimal identidadesfinanciera,
            @RequestParam("nombreEntidad") String nombreentidad, @RequestParam("descripcion") String descripcion,
            @RequestParam("estado") Character estado, RedirectAttributes atr, Model model, Principal principal) {
        EntidadesfinancierasDTO entidadesfinancierasDTO = new EntidadesfinancierasDTO();
        entidadesfinancierasDTO.setDescripcion(descripcion);
        entidadesfinancierasDTO.setEstado(estado);
        entidadesfinancierasDTO.setNombreentidad(nombreentidad);
        entidadesfinancierasDTO.setIdentidadesfinanciera(identidadesfinanciera);
//Modifico la entidad
        RequestRegistrarEntidadFinanciera request2 = new RequestRegistrarEntidadFinanciera();

        request2.setEntidadesfinancierasDTO(entidadesfinancierasDTO);
        ResponseModificarEntidadFinanciera2 response2 = new ResponseModificarEntidadFinanciera2();
        response2 = entidadesFinancierasServicio.setEntidadFinancieraM(request2);
        String mensaje3 = response2.getDescripcion();
        atr.addAttribute("mensaje3", mensaje3);
        atr.addAttribute("status3", response2.getStatus());
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(identidadesfinanciera.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
//        //traigo las entidades financieras
//        RequestTraerEntidadesFinancieras request = new RequestTraerEntidadesFinancieras();
//        
//        ResponseTraerEntidadesFinancieras response = entidadesFinancierasServicio.getEntidadesFinancieras(request);
//        
//        List<TraerEntidadesFinancierasDTO> entidades = response.getEntidadesDTO();
//        String mensaje = response.getDescripcion();
//        String status = response.getStatus();
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("status", status);
//        model.addAttribute("entidades", entidades);
        return "redirect:entidadesFinancieras";

    }

    /**
     * Metodo que borra una entidad financiera basandose en su id
     *
     * @param atr Redireccionador de atributos
     * @param identidadesfinanciera EL id de la entidad financiera
     * @return Url vista
     */
    @PostMapping("/borrarEntidadFinanciera")
    public String borrarEntidadFinanciera(RedirectAttributes atr,
            @RequestParam("identidadesfinanciera") BigDecimal identidadesfinanciera) {
        RequestBorrarEntidadFinanciera request = new RequestBorrarEntidadFinanciera();
        ResponseRegistrarEntidadFinanciera response = new ResponseRegistrarEntidadFinanciera();
        request.setIdentidadesfinanciera(identidadesfinanciera);
        response = entidadesFinancierasServicio.borrarEntidadFinanciera(request);
        atr.addAttribute("mensaje3", response.getDescripcion());
        atr.addAttribute("status3", response.getStatus());
        return "redirect:entidadesFinancieras";
    }

    /**
     * Metodo que trae las cajas de compensacion
     *
     * @param model Modelo JSP
     * @param mensaje3 Mensaje de respuesta de una acción
     * @param status3 Status de respuesta de una acción
     * @return Url vista
     */
    @GetMapping("/cajasDeCompensacion")
    public String cajasDeCompensacion(Model model, @RequestParam(name = "mensaje3", required = false) String mensaje3,
            @RequestParam(name = "status3", required = false) String status3) {
        RequestTraerCajas request = new RequestTraerCajas();
        ResponseTraerCajas response = new ResponseTraerCajas();
        response = cajasDeCompensacionServicio.getCajasDeCompensacionAdmin(request);
        List<CajacompensacionDTO> cajasDTO = response.getCajasDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("cajasDTO", cajasDTO);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("status3", status3);
        model.addAttribute("mensaje3", mensaje3);
        return "cajasDeCompensacion";
    }

    /**
     * metodo que muestra la pagina de registro de cajas de compensacion
     *
     * @return Url vista
     */
    @GetMapping("/registroCajaCompensacion")
    public String registroCajaCompensacion() {
        return "registroCajaCompensacion";
    }

    /**
     * Metodo que registra la nueva caja de compensacion
     *
     * @param principal Sesión Spring Security
     * @param codigoccf Codigo de la caja de compensación
     * @param departamento Departamento
     * @param nombrecajacompensacion Nombre de la caja de compensación
     * @param idestadocajacompensacion Id del estado de la caja de compensación
     * @param atr Redireccionador de atributos
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/registrarCajaCompensacion")
    public String registrarCajaCompensacion(
            @RequestParam("idestadocajacompensacion") BigDecimal idestadocajacompensacion,
            @RequestParam("codigoccf") String codigoccf,
            @RequestParam(name = "departamento", required = false) String departamento,
            @RequestParam("nombrecajacompensacion") String nombrecajacompensacion, RedirectAttributes atr,
            Model model, Principal principal) {
        CajacompensacionDTO cajaDTO = new CajacompensacionDTO();
        cajaDTO.setDepartamento(departamento);
        cajaDTO.setCodigoccf(codigoccf);
        cajaDTO.setNombrecajacompensacion(nombrecajacompensacion);
        //registro la nueva caja
        RequestRegistrarCaja request2 = new RequestRegistrarCaja();
        EstadocajacompensacionDTO estado = new EstadocajacompensacionDTO();
        estado.setIdestadocajacompensacion(idestadocajacompensacion);
        cajaDTO.setEstadocajacompensacion(estado);
        request2.setCajaDTO(cajaDTO);
        ResponseRegistrarCaja response2 = new ResponseRegistrarCaja();
        response2 = cajasDeCompensacionServicio.setCajaCompensacion(request2);
        String mensaje3 = response2.getDescripcion();
        String status3 = response2.getStatus();

        atr.addAttribute("mensaje3", mensaje3);
        atr.addAttribute("status3", status3);
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response2.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
//        //Traigo las cajas 
//        RequestTraerCajas request = new RequestTraerCajas();
//        ResponseTraerCajas response = new ResponseTraerCajas();
//        response = cajasDeCompensacionServicio.getCajasDeCompensacion(request);
//        List<CajacompensacionDTO> cajasDTO = response.getCajasDTO();
//        String mensaje = response.getDescripcion();
//        String status = response.getStatus();
//        model.addAttribute("cajasDTO", cajasDTO);
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("status", status);
        return "redirect:cajasDeCompensacion";
    }

    //Inicio Herramienta de Evaluación - DFGG
    /**
     * Metodo que trae las herramientas de evaluacion
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/herramientasEvaluacion")
    public String herramientaEvaluacion(Model model) {
        RequestTraerHerramientasValoracion request = new RequestTraerHerramientasValoracion();
        ResponseTraerHerramientasValoracion response = herramientaValoracionServicio.getHerramientasValoracion(request);
        List<HerramientaValoracionDTO> herramientasValoracionDTO = response.getHerramientasValoracionDTO();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("herramientasValoracion", herramientasValoracionDTO);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "herramientasEvaluacion";
    }

    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param tipoHerramienta Tipo de herramienta
     * @param cajaId El id de la caja de compensación
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @return Url vista dependiendo del tipo de usuario
     */
    @PostMapping("/seleccionarHerramientaEvaluacion")
    public String seleccionarHerramientaEvaluacion(@RequestParam("tipoHerramienta") BigDecimal tipoHerramienta, @RequestParam(name = "cajaId", required = false) BigDecimal cajaId, Principal principal, Model model) {
        if (tipoHerramienta == null) {
            RequestTraerHerramientasValoracion request = new RequestTraerHerramientasValoracion();
            ResponseTraerHerramientasValoracion response = herramientaValoracionServicio.getHerramientasValoracion(request);
            List<HerramientaValoracionDTO> herramientasValoracionDTO = response.getHerramientasValoracionDTO();
            model.addAttribute("herramientasValoracion", herramientasValoracionDTO);
            return "herramientasEvaluacion";
        }

        RequestTraerHerramientaValoracion request = new RequestTraerHerramientaValoracion();
        request.setIdHerramientaValoracion(tipoHerramienta);
        ResponseTraerHerramientaValoracion response = herramientaValoracionServicio.getHerramientaValoracion(request);
        HerramientaValoracionDTO herramientaValoracionDTO = response.getHerramientaValoracionDTO();
        model.addAttribute("herramientaValoracion", herramientaValoracionDTO);
        RequestTraerFuncionarioPorUserName requestFuncionario = new RequestTraerFuncionarioPorUserName();
        requestFuncionario.setIdEstado(BigDecimal.valueOf(1));
        requestFuncionario.setUserName(principal.getName());
        ResponseTraerFuncionarioPorUserName responseFuncionario = funcionarioServicio.getFuncionarioPorUserName(requestFuncionario);

        if (responseFuncionario.getFuncionarioDTO() == null && cajaId == null) {
            RequestTraerHerramientasValoracion requestHerramientas = new RequestTraerHerramientasValoracion();
            ResponseTraerHerramientasValoracion responseHerramientas = herramientaValoracionServicio.getHerramientasValoracion(requestHerramientas);
            List<HerramientaValoracionDTO> herramientasValoracionDTO = responseHerramientas.getHerramientasValoracionDTO();
            RequestTraerCajas requestCajas = new RequestTraerCajas();
            ResponseTraerCajas responseCajas = cajasDeCompensacionServicio.getCajasDeCompensacion(requestCajas);
            String status = "adm";
            model.addAttribute("herramientasValoracion", herramientasValoracionDTO);
            model.addAttribute("tipoHerramienta", tipoHerramienta);
            model.addAttribute("cajas", responseCajas.getCajasDTO());
            model.addAttribute("status", status);
            return "herramientasEvaluacion";
        }
        BigDecimal idCajaCompensacion = cajaId != null ? cajaId : responseFuncionario.getFuncionarioDTO().getCajacompensacion().getIdcajacompensacion();
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);
        RequestTraerTemasPorCajaYHerramienta requestTemas = new RequestTraerTemasPorCajaYHerramienta();
        requestTemas.setIdCajaCompensacion(idCajaCompensacion);
        requestTemas.setIdHerramienta(tipoHerramienta);
        ResponseTraerTemasPorCajaYHerramienta responseTemas = herramientaValoracionServicio.getTemasEvaluacion(requestTemas);
        List<TemasEvaluacionDTO> temasEvaluacionDTO = responseTemas.getTemasEvaluacion();
        model.addAttribute("temasEvaluacion", temasEvaluacionDTO);
        return "parametrizarTemasHerramienta";
    }

    /**
     * Metodo que muestra la vista para agregar temas de evaluacion, trae
     * herramientas de valoracion y cajas de compensacion
     *
     * @param idHerramienta El id de la herramienta de valoracion
     * @param idCajaCompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/agregarTemaEvaluacion")
    public String agregarTemaEvaluacion(@RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion, Model model) {
        RequestTraerHerramientaValoracion request = new RequestTraerHerramientaValoracion();
        request.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion response = herramientaValoracionServicio.getHerramientaValoracion(request);
        HerramientaValoracionDTO herramientaValoracionDTO = response.getHerramientaValoracionDTO();
        TemasEvaluacionDTO temaEvaluacionDTO = new TemasEvaluacionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        temaEvaluacionDTO.setCajaCompensacionDTO(cajaDTO);
        temaEvaluacionDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        model.addAttribute("temaEvaluacionDTO", temaEvaluacionDTO);
        model.addAttribute("herramientaValoracion", herramientaValoracionDTO);
        return "agregandoTemaEvaluacion";
    }

    /**
     * Metodo que crea un nuevo tema de evaluacion
     *
     * @param temaEvaluacionDTO Tema de evaluación
     * @param idHerramienta Id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/guardarTemaEvaluacion")
    public String guardarTemaEvaluacion(@ModelAttribute("TemasEvaluacionDTO") TemasEvaluacionDTO temaEvaluacionDTO,
            @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion,
            Model model, Principal principal) {
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        temaEvaluacionDTO.setCajaCompensacionDTO(cajaDTO);
        temaEvaluacionDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        RequestRegistrarTemaEvaluacion request = new RequestRegistrarTemaEvaluacion();
        temaEvaluacionDTO.setFecharegistro(new Date());
        temaEvaluacionDTO.setEstado('1');
        request.setTemaEvaluacionDTO(temaEvaluacionDTO);
        ResponseRegistrarTemaEvaluacion response = herramientaValoracionServicio.setTemaEvaluacion(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        RequestTraerTemasPorCajaYHerramienta requestTemas = new RequestTraerTemasPorCajaYHerramienta();
        requestTemas.setIdCajaCompensacion(idCajaCompensacion);
        requestTemas.setIdHerramienta(idHerramienta);
        ResponseTraerTemasPorCajaYHerramienta responseTemas = herramientaValoracionServicio.getTemasEvaluacion(requestTemas);
        List<TemasEvaluacionDTO> temasEvaluacionDTO = responseTemas.getTemasEvaluacion();

        model.addAttribute("herramientaValoracion", herramientaValoracionDTO);
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);
        model.addAttribute("temasEvaluacion", temasEvaluacionDTO);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "parametrizarTemasHerramienta";
    }

    /**
     * Metodo que borra un tema y todas las preguntas que contenga basandose en
     * el id del tema
     *
     * @param idTemaEvaluacion El id del tema de evaluación
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @param idHerramienta El id de la herramienta e evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @return Url vista
     */
    @PostMapping("/borrarTemaEvaluacion")
    public String borrarTemaEvaluacion(@RequestParam("idTemaEvaluacion") BigDecimal idTemaEvaluacion,
            Model model, Principal principal, @RequestParam("idHerramienta") BigDecimal idHerramienta,
            @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion) {
        //trae herramienta
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();

        RequestBorrarTema request = new RequestBorrarTema();
        ResponseBorrarTema response = new ResponseBorrarTema();
        request.setIdTema(idTemaEvaluacion);
        request.setIdHerramienta(idHerramienta);
        request.setIdCajaCompensacion(idCajaCompensacion);
        response = herramientaValoracionServicio.borrarTemaEvaluacion(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idTemaEvaluacion.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        RequestTraerTemasPorCajaYHerramienta requestTemas = new RequestTraerTemasPorCajaYHerramienta();
        requestTemas.setIdCajaCompensacion(idCajaCompensacion);
        requestTemas.setIdHerramienta(idHerramienta);
        ResponseTraerTemasPorCajaYHerramienta responseTemas = herramientaValoracionServicio.getTemasEvaluacion(requestTemas);
        List<TemasEvaluacionDTO> temasEvaluacionDTO = responseTemas.getTemasEvaluacion();

        model.addAttribute("herramientaValoracion", herramientaValoracionDTO);
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);
        model.addAttribute("temasEvaluacion", temasEvaluacionDTO);

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "parametrizarTemasHerramienta";
    }

    /**
     * Metodo que trae el tema de evaluacion a editar en base a su id
     *
     * @param idTemaEvaluacion El id del tema de evaluación
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/editarTemaEvaluacion")
    public String editarTemaEvaluacion(@RequestParam("idTemaEvaluacion") BigDecimal idTemaEvaluacion, Model model) {
        RequestTraerTemaEvaluacion request = new RequestTraerTemaEvaluacion();
        request.setIdTemaEvaluacion(idTemaEvaluacion);
        ResponseTraerTemaEvaluacion response = herramientaValoracionServicio.getTraerTemaEvaluacion(request);
        TemasEvaluacionDTO temaEvaluacionDTO = response.getTemaEvaluacion();
        model.addAttribute("temaEvaluacionDTO", temaEvaluacionDTO);
        model.addAttribute("herramientaValoracion", temaEvaluacionDTO.getHerramientaValoracionDTO());
        return "editarTemaEvaluacion";
    }

    /**
     * Metodo que actualiza un tema de evaluacion
     *
     * @param temaEvaluacionDTO Tema de evaluación
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compnesación
     * @param idtema El id del tema
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/editandoTemaEvaluacion")
    public String editandoTemaEvaluacion(@ModelAttribute("TemasEvaluacionDTO") TemasEvaluacionDTO temaEvaluacionDTO,
            @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion,
            @RequestParam("idtema") BigDecimal idtema, Model model, Principal principal) {
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        temaEvaluacionDTO.setIdtema(idtema);
        temaEvaluacionDTO.setCajaCompensacionDTO(cajaDTO);
        temaEvaluacionDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        temaEvaluacionDTO.setFecharegistro(new Date());
        RequestRegistrarTemaEvaluacion request = new RequestRegistrarTemaEvaluacion();
        request.setTemaEvaluacionDTO(temaEvaluacionDTO);
        ResponseRegistrarTemaEvaluacion response = herramientaValoracionServicio.setTemaEvaluacion(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idtema.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        RequestTraerTemasPorCajaYHerramienta requestTemas = new RequestTraerTemasPorCajaYHerramienta();
        requestTemas.setIdCajaCompensacion(idCajaCompensacion);
        requestTemas.setIdHerramienta(idHerramienta);
        ResponseTraerTemasPorCajaYHerramienta responseTemas = herramientaValoracionServicio.getTemasEvaluacion(requestTemas);
        List<TemasEvaluacionDTO> temasEvaluacionDTO = responseTemas.getTemasEvaluacion();

        model.addAttribute("herramientaValoracion", herramientaValoracionDTO);
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);
        model.addAttribute("temasEvaluacion", temasEvaluacionDTO);

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "parametrizarTemasHerramienta";
    }

    /**
     * Metodo que trae las preguntas que un tema contenga basandose en el id del
     * tema
     *
     * @param idTemaEvaluacion El id del tema de evaluación
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/preguntasTemaEvaluacion")
    public String preguntasTemaEvaluacion(@RequestParam("idTema") BigDecimal idTemaEvaluacion, @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCaja") BigDecimal idCajaCompensacion, Model model) {
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        RequestTraerTemaEvaluacion requestTema = new RequestTraerTemaEvaluacion();
        requestTema.setIdTemaEvaluacion(idTemaEvaluacion);
        ResponseTraerTemaEvaluacion responseTema = herramientaValoracionServicio.getTraerTemaEvaluacion(requestTema);
        TemasEvaluacionDTO temaEvaluacionDTO = responseTema.getTemaEvaluacion();
        RequestTraerPreguntasXTemaHerramientaCaja request = new RequestTraerPreguntasXTemaHerramientaCaja();
        request.setIdTema(idTemaEvaluacion);
        request.setIdCajaCompensacion(idCajaCompensacion);
        request.setIdHerramienta(idHerramienta);
        ResponseTraerPreguntasXTemaHerramientaCaja response = herramientaValoracionServicio.getTraerPreguntas(request);
        List<PreguntasTemaDTO> preguntasDTO = response.getPreguntasDTO();
        model.addAttribute("tema", temaEvaluacionDTO);
        model.addAttribute("herramienta", herramientaValoracionDTO);
        model.addAttribute("caja", cajaDTO);
        model.addAttribute("preguntas", preguntasDTO);
        return "preguntasTemaEvaluacion";
    }

    /**
     * Metodo que muestra la vista para agregar preguntas, trae herramientas de
     * valoracion, temas de evaluacion y cajas de compensacion
     *
     * @param idTema El id del tema
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/agregarPreguntaTema")
    public String agregarPreguntaTema(@RequestParam("idTema") BigDecimal idTema, @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion, Model model) {
        RequestTraerHerramientaValoracion request = new RequestTraerHerramientaValoracion();
        request.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion response = herramientaValoracionServicio.getHerramientaValoracion(request);
        HerramientaValoracionDTO herramientaValoracionDTO = response.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        RequestTraerTemaEvaluacion requestTema = new RequestTraerTemaEvaluacion();
        requestTema.setIdTemaEvaluacion(idTema);
        ResponseTraerTemaEvaluacion responseTema = herramientaValoracionServicio.getTraerTemaEvaluacion(requestTema);
        TemasEvaluacionDTO temaEvaluacionDTO = responseTema.getTemaEvaluacion();
        PreguntasTemaDTO preguntaTemaDTO = new PreguntasTemaDTO();
        preguntaTemaDTO.setTemaEvaluacionDTO(temaEvaluacionDTO);
        preguntaTemaDTO.setCajaCompensacionDTO(cajaDTO);
        preguntaTemaDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        model.addAttribute("pregunta", preguntaTemaDTO);
        model.addAttribute("idTema", idTema);
        model.addAttribute("idCaja", idCajaCompensacion);
        model.addAttribute("idHerramienta", idHerramienta);
        return "agregarPreguntaTema";
    }

    /**
     * Metodo que crea una nueva pregunta
     *
     * @param preguntaTemaDTO Pregunta
     * @param idTema El id del tema
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/guardarPreguntaTema")
    public String guardarPreguntaTema(@ModelAttribute("PreguntasTemaDTO") PreguntasTemaDTO preguntaTemaDTO,
            @RequestParam("idTema") BigDecimal idTema, @RequestParam("idHerramienta") BigDecimal idHerramienta,
            @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion, Model model, Principal principal) {
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        RequestTraerTemaEvaluacion requestTema = new RequestTraerTemaEvaluacion();
        requestTema.setIdTemaEvaluacion(idTema);
        ResponseTraerTemaEvaluacion responseTema = herramientaValoracionServicio.getTraerTemaEvaluacion(requestTema);
        TemasEvaluacionDTO temaEvaluacionDTO = responseTema.getTemaEvaluacion();
        preguntaTemaDTO.setCajaCompensacionDTO(cajaDTO);
        preguntaTemaDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        preguntaTemaDTO.setTemaEvaluacionDTO(temaEvaluacionDTO);
        RequestRegistrarPreguntaTema request = new RequestRegistrarPreguntaTema();
        preguntaTemaDTO.setFecharegistro(new Date());
        request.setPreguntaTemaDTO(preguntaTemaDTO);
        ResponseRegistrarPreguntaTema response = herramientaValoracionServicio.setPreguntaTema(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();

        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        RequestTraerPreguntasXTemaHerramientaCaja requestPreguntas = new RequestTraerPreguntasXTemaHerramientaCaja();
        requestPreguntas.setIdTema(idTema);
        requestPreguntas.setIdCajaCompensacion(idCajaCompensacion);
        requestPreguntas.setIdHerramienta(idHerramienta);
        ResponseTraerPreguntasXTemaHerramientaCaja responsePreguntas = herramientaValoracionServicio.getTraerPreguntas(requestPreguntas);
        List<PreguntasTemaDTO> preguntasDTO = responsePreguntas.getPreguntasDTO();

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("tema", temaEvaluacionDTO);
        model.addAttribute("herramienta", herramientaValoracionDTO);
        model.addAttribute("caja", cajaDTO);
        model.addAttribute("preguntas", preguntasDTO);
        return "preguntasTemaEvaluacion";
    }

    /**
     * Metodo que trae la pregunta a editar en base a su id
     *
     * @param idPregunta El id de la pregunta
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/editarPreguntaTema")
    public String editarPreguntaTema(@RequestParam("idPregunta") BigDecimal idPregunta, Model model) {
        RequestTraerPregunta request = new RequestTraerPregunta();
        request.setIdPregunta(idPregunta);
        ResponseTraerPregunta response = herramientaValoracionServicio.getTraerPreguntaTema(request);
        PreguntasTemaDTO preguntaTemaDTO = response.getPreguntaTemaDTO();
        model.addAttribute("pregunta", preguntaTemaDTO);
        model.addAttribute("idTema", preguntaTemaDTO.getTemaEvaluacionDTO().getIdtema());
        model.addAttribute("idCaja", preguntaTemaDTO.getCajaCompensacionDTO().getIdcajacompensacion());
        model.addAttribute("idHerramienta", preguntaTemaDTO.getHerramientaValoracionDTO().getIdHerramienta());
        return "editarPreguntaTema";
    }

    /**
     * Metodo que borra una pregunta basandose en su id
     *
     * @param preguntaTemaDTO Pregunta
     * @param principal El usuario en sesión
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idTema El id del tema
     * @param idPregunta EL id de la pregunta
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/borrarPreguntaTema")
    public String borrarPreguntaTema(@ModelAttribute("PreguntasTemaDTO") PreguntasTemaDTO preguntaTemaDTO, Principal principal,
            @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion,
            @RequestParam("idTema") BigDecimal idTema, @RequestParam("idPregunta") BigDecimal idPregunta, Model model) {
        //trae herramienta, caja y tema
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        RequestTraerTemaEvaluacion requestTema = new RequestTraerTemaEvaluacion();
        requestTema.setIdTemaEvaluacion(idTema);
        ResponseTraerTemaEvaluacion responseTema = herramientaValoracionServicio.getTraerTemaEvaluacion(requestTema);
        TemasEvaluacionDTO temaEvaluacionDTO = responseTema.getTemaEvaluacion();
        //borro pregunta
        RequestBorrarPregunta request = new RequestBorrarPregunta();
        ResponseBorrarPregunta response = new ResponseBorrarPregunta();
        request.setIdPregunta(idPregunta);
        response = preguntasServicio.borrarPreguntas(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idPregunta.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }

        //trae preguntas
        RequestTraerPreguntasXTemaHerramientaCaja requestPreguntas = new RequestTraerPreguntasXTemaHerramientaCaja();
        requestPreguntas.setIdTema(idTema);
        requestPreguntas.setIdCajaCompensacion(idCajaCompensacion);
        requestPreguntas.setIdHerramienta(idHerramienta);
        ResponseTraerPreguntasXTemaHerramientaCaja responsePreguntas = herramientaValoracionServicio.getTraerPreguntas(requestPreguntas);
        List<PreguntasTemaDTO> preguntasDTO = responsePreguntas.getPreguntasDTO();

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("tema", temaEvaluacionDTO);
        model.addAttribute("herramienta", herramientaValoracionDTO);
        model.addAttribute("caja", cajaDTO);
        model.addAttribute("preguntas", preguntasDTO);
        return "preguntasTemaEvaluacion";
    }

    /**
     * Metodo que actualiza una pregunta
     *
     * @param preguntaTemaDTO Pregunta
     * @param principal El usuario en sesión
     * @param idHerramienta El id de la herramienta de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idTema El id del tema
     * @param idPregunta El id de la pregunta
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("/editandoPreguntaTema")
    public String editandoPreguntaTema(@ModelAttribute("PreguntasTemaDTO") PreguntasTemaDTO preguntaTemaDTO, Principal principal,
            @RequestParam("idHerramienta") BigDecimal idHerramienta, @RequestParam("idCajaCompensacion") BigDecimal idCajaCompensacion,
            @RequestParam("idTema") BigDecimal idTema, @RequestParam("idPregunta") BigDecimal idPregunta, Model model) {
        RequestTraerHerramientaValoracion requestHerramienta = new RequestTraerHerramientaValoracion();
        requestHerramienta.setIdHerramientaValoracion(idHerramienta);
        ResponseTraerHerramientaValoracion responseHerramienta = herramientaValoracionServicio.getHerramientaValoracion(requestHerramienta);
        HerramientaValoracionDTO herramientaValoracionDTO = responseHerramienta.getHerramientaValoracionDTO();
        RequestModificarCaja requestCaja = new RequestModificarCaja();
        requestCaja.setIdcajacompensacion(idCajaCompensacion);
        ResponseModificarCaja responseCaja = cajasDeCompensacionServicio.getCajaCompensacion(requestCaja);
        CajacompensacionDTO cajaDTO = responseCaja.getCajaDTO();
        RequestTraerTemaEvaluacion requestTema = new RequestTraerTemaEvaluacion();
        requestTema.setIdTemaEvaluacion(idTema);
        ResponseTraerTemaEvaluacion responseTema = herramientaValoracionServicio.getTraerTemaEvaluacion(requestTema);
        TemasEvaluacionDTO temaEvaluacionDTO = responseTema.getTemaEvaluacion();
        preguntaTemaDTO.setIdpregunta(idPregunta);
        preguntaTemaDTO.setCajaCompensacionDTO(cajaDTO);
        preguntaTemaDTO.setHerramientaValoracionDTO(herramientaValoracionDTO);
        preguntaTemaDTO.setTemaEvaluacionDTO(temaEvaluacionDTO);
        preguntaTemaDTO.setFecharegistro(new Date());
        RequestRegistrarPreguntaTema request = new RequestRegistrarPreguntaTema();
        request.setPreguntaTemaDTO(preguntaTemaDTO);
        ResponseRegistrarPreguntaTema response = herramientaValoracionServicio.setPreguntaTema(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idPregunta.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        RequestTraerPreguntasXTemaHerramientaCaja requestPreguntas = new RequestTraerPreguntasXTemaHerramientaCaja();
        requestPreguntas.setIdTema(idTema);
        requestPreguntas.setIdCajaCompensacion(idCajaCompensacion);
        requestPreguntas.setIdHerramienta(idHerramienta);
        ResponseTraerPreguntasXTemaHerramientaCaja responsePreguntas = herramientaValoracionServicio.getTraerPreguntas(requestPreguntas);
        List<PreguntasTemaDTO> preguntasDTO = responsePreguntas.getPreguntasDTO();

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("tema", temaEvaluacionDTO);
        model.addAttribute("herramienta", herramientaValoracionDTO);
        model.addAttribute("caja", cajaDTO);
        model.addAttribute("preguntas", preguntasDTO);
        return "preguntasTemaEvaluacion";
    }

    //Fin Herramienta de Evaluación - DFGG
    /**
     * Metodo que muestra la pantalla de modificacion de caja de compensacion y
     * trae la informacion de la caja a modificar
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/modificarCajaCompensacion")
    public String modificarCajaCompensacion(@RequestParam("idcajacompensacion") BigDecimal idcajacompensacion, Model model) {
        RequestModificarCaja request = new RequestModificarCaja();
        request.setIdcajacompensacion(idcajacompensacion);
        ResponseModificarCaja response = cajasDeCompensacionServicio.getCajaCompensacion(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        CajacompensacionDTO cajaDTO = response.getCajaDTO();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("cajaDTO", cajaDTO);
        return "modificarCajaCompensacion";
    }

    /**
     * Metodo que actualiza una caja de compensacion
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @param nombrecajacompensacion El nombre de la caja de compensación
     * @param codigoccf El codigo de la caja de compensación
     * @param idestadocajacompensacion El id del estado de la caja de
     * compensación
     * @param atr Redireccionador de atributos
     * @param departamento Departamento
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @PostMapping("/modificarCajaCompensacion2")
    public String modificarCajaCompensacion2(@RequestParam("idcajacompensacion") BigDecimal idcajacompensacion,
            @RequestParam("nombrecajacompensacion") String nombrecajacompensacion, @RequestParam("codigoccf") String codigoccf,
            @RequestParam("idestadocajacompensacion") BigDecimal idestadocajacompensacion, RedirectAttributes atr,
            @RequestParam(name = "departamento", required = false) String departamento, Model model, Principal principal) {
        CajacompensacionDTO cajaDTO = new CajacompensacionDTO();
        cajaDTO.setDepartamento(departamento);
        cajaDTO.setNombrecajacompensacion(nombrecajacompensacion);
        cajaDTO.setCodigoccf(codigoccf);
        cajaDTO.setIdcajacompensacion(idcajacompensacion);
//modifico la caja
        RequestModificarCaja2 request2 = new RequestModificarCaja2();
        EstadocajacompensacionDTO estadoDTO = new EstadocajacompensacionDTO();
        estadoDTO.setIdestadocajacompensacion(idestadocajacompensacion);
        cajaDTO.setEstadocajacompensacion(estadoDTO);
        request2.setCajaDTO(cajaDTO);
        ResponseModificarCaja2 response2 = cajasDeCompensacionServicio.setCajaCompensacionM(request2);
        String mensaje3 = response2.getDescripcion();
        String status3 = response2.getStatus();
        atr.addAttribute("mensaje3", mensaje3);
        atr.addAttribute("status3", status3);
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idcajacompensacion.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
//        //traigo las cajas
//        RequestTraerCajas request = new RequestTraerCajas();
//        ResponseTraerCajas response = new ResponseTraerCajas();
//        response = cajasDeCompensacionServicio.getCajasDeCompensacion(request);
//        List<CajacompensacionDTO> cajasDTO = response.getCajasDTO();
//        String mensaje = response.getDescripcion();
//        String status = response.getStatus();
//        model.addAttribute("cajasDTO", cajasDTO);
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("status", status);
        return "redirect:cajasDeCompensacion";
    }

    /**
     * Metodo que borra una caja de compensacion basandose en su id
     *
     * @param atr Redireccionador de atributos
     * @param idcajacompensacion El id de la caja de compensación
     * @return Url vista
     */
    @PostMapping("/borrarCajaCompensacion")
    public String borrarCajaCompensacion(RedirectAttributes atr,
            @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion) {
        RequestBorrarCajaCompensacion request = new RequestBorrarCajaCompensacion();
        ResponseRegistrarCaja response = new ResponseRegistrarCaja();
        request.setIdcajacompensacion(idcajacompensacion);
        response = cajasDeCompensacionServicio.borrarCajaCompensacion(request);
        atr.addAttribute("mensaje3", response.getDescripcion());
        atr.addAttribute("status3", response.getStatus());
        return "redirect:cajasDeCompensacion";
    }

    //Inicio Comité de Evaluación - DFGG
    /**
     * Metodo que evalua que tipo de usuario es y muestra la pantalla para
     * administrador o la pantalla para el funcionario
     *
     * @param principal El usuario en sesión
     * @param cajaId El id de la caja de compensación
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/comiteEvaluacion")
    public String comiteEvaluacion(Principal principal, @RequestParam(name = "cajaId", required = false) BigDecimal cajaId, Model model) {
        RequestTraerFuncionarioPorUserName requestFuncionario = new RequestTraerFuncionarioPorUserName();
        requestFuncionario.setIdEstado(BigDecimal.valueOf(1));
        requestFuncionario.setUserName(principal.getName());
        ResponseTraerFuncionarioPorUserName responseFuncionario = funcionarioServicio.getFuncionarioPorUserName(requestFuncionario);
        if (responseFuncionario.getFuncionarioDTO() == null && cajaId == null) {
            RequestTraerCajas requestCajas = new RequestTraerCajas();
            ResponseTraerCajas responseCajas = cajasDeCompensacionServicio.getCajasDeCompensacion(requestCajas);
            String status = "adm";
            model.addAttribute("cajas", responseCajas.getCajasDTO());
            model.addAttribute("status", status);
            return "comiteEvaluacion";
        }
        BigDecimal idCajaCompensacion = cajaId != null ? cajaId : responseFuncionario.getFuncionarioDTO().getCajacompensacion().getIdcajacompensacion();
        model.addAttribute("idCajaCompensacion", idCajaCompensacion);

        RequestTraerComiteEvaluacionPorCaja requestComiteEvaluacion = new RequestTraerComiteEvaluacionPorCaja();
        requestComiteEvaluacion.setIdCajaCompensacion(idCajaCompensacion);
        ResponseTraerComiteEvaluacionPorCaja responseComiteEvaluacion = funcionarioServicio.getComiteEvaluacion(requestComiteEvaluacion);
        if (responseComiteEvaluacion.getComiteEvaluacionDTO() == null) {
            model.addAttribute("mensaje", "La caja seleccionada no tiene Comité de Evaluación Parametrizado");
            String status = "adm";
            RequestTraerCajas requestCajas = new RequestTraerCajas();
            ResponseTraerCajas responseCajas = cajasDeCompensacionServicio.getCajasDeCompensacion(requestCajas);
            model.addAttribute("cajas", responseCajas.getCajasDTO());
            model.addAttribute("cajaId", cajaId);
            model.addAttribute("status", status);
        } else {
            model.addAttribute("idComite", responseComiteEvaluacion.getComiteEvaluacionDTO().getIdcomite());
            RequestTraerUsuariosComiteLibres requestUsuariosLibres = new RequestTraerUsuariosComiteLibres();
            List<String> roles = new ArrayList<>();
            roles.add("Líder Comité Evaluación");
            roles.add("Integrante Comité Evaluación");
            requestUsuariosLibres.setLstRoles(roles);
            requestUsuariosLibres.setIdCajaCompensacion(idCajaCompensacion);
            requestUsuariosLibres.setIdEstado(BigDecimal.valueOf(1));
            ResponseTraerUsuariosComiteLibres responseUsuariosLibres = funcionarioServicio.getUsuariosComiteLibres(requestUsuariosLibres);
            List<UsuarioComiteDTO> usuariosComiteDTO = responseUsuariosLibres.getUsuariosComite();

            RequestTraerUsuariosComite requestUsuarios = new RequestTraerUsuariosComite();
            requestUsuarios.setIdCajaCompensacion(idCajaCompensacion);
            requestUsuarios.setIdEstado(BigDecimal.valueOf(1));
            ResponseTraerUsuariosComite responseUsuarios = funcionarioServicio.getUsuariosComite(requestUsuarios);
            List<UsuarioComiteDTO> integrantesComiteDTO = responseUsuarios.getUsuariosComite();
            for (UsuarioComiteDTO u : integrantesComiteDTO) {
                usuariosComiteDTO.add(u);
            }
            model.addAttribute("integrantesComiteDTO", integrantesComiteDTO);
            model.addAttribute("usuariosComiteDTO", usuariosComiteDTO);
        }
        return "comiteEvaluacion";
    }

    //    public String guardarIntegrantesComite(Principal principal, @RequestParam("idComite") BigDecimal idComite, @RequestParam(name = "integrantesComiteId", required = false) String integrantesCoId, @RequestParam(name = "cajaId", required = false) BigDecimal cajaId, Model model) throws IOException {
    /**
     * Metodo que actualiza el comite de evaluacion
     *
     * @param principal El usuario en sesión
     * @param idComite El id del comtité
     * @param integrantesCoId El id de los integrantes del comité
     * @param cajaId El id de la caja de compensación
     * @param model Modelo JSP
     * @return respuesta con la acción
     */
    @PostMapping(path = "/guardarIntegrantesComite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseGuardarIntegranteComite guardarIntegrantesComite(Principal principal,
            @RequestParam("idComite") BigDecimal idComite,
            @RequestParam(name = "integrantesComiteId", required = false) String integrantesCoId,
            @RequestParam(name = "cajaId", required = false) BigDecimal cajaId,
            Model model) {
        ResponseGuardarIntegranteComite response = new ResponseGuardarIntegranteComite();
        response.setStatus("0");
        response.setDescripcion("Error en el controlador");
        try {
            RequestTraerComiteEvaluacion requestComiteEvaluacion = new RequestTraerComiteEvaluacion();
            requestComiteEvaluacion.setIdComite(idComite);
            JsonFactory factory = new JsonFactory();
            List<String> integrantesComiteId = new ArrayList<>();
            JsonParser parser = factory.createParser(integrantesCoId);
            while (!parser.isClosed()) {
                String temp = parser.nextTextValue();
                if (temp != null) {
                    integrantesComiteId.add(temp);
                }

            }
            ResponseTraerComiteEvaluacion responseComiteEvaluacion = funcionarioServicio.getComiteEvaluacion(requestComiteEvaluacion);
            ComiteevaluacionDTO comiteEvaluacion = responseComiteEvaluacion.getComiteEvaluacionDTO();
            List<IntegrantescomiteDTO> lstIntegrantesComite = new ArrayList<>();
            int cantLider = 0;
            for (String integranteComiteId : integrantesComiteId) {
                IntegrantescomiteDTO integranteComiteDTO = new IntegrantescomiteDTO();
                RequestModificarFuncionario requestFuncionario = new RequestModificarFuncionario();
                requestFuncionario.setIdfuncionario(Long.parseLong(integranteComiteId));
                ResponseModificarFuncionario responseFuncionario = funcionarioServicio.getFuncionarioPorId(requestFuncionario);
                if ("Líder Comité Evaluación".equals(responseFuncionario.getGroupMember().getGroups().getGroupName())) {
                    cantLider++;
                }
                integranteComiteDTO.setComiteevaluacion(comiteEvaluacion);
                integranteComiteDTO.setFuncionario(responseFuncionario.getFuncionarioDTO());
                integranteComiteDTO.setFecharegistro(new Date());
                lstIntegrantesComite.add(integranteComiteDTO);
            }
            String mensaje = "";
            String status = "";

            if (cantLider > 1) {
                mensaje = "No es valido parametrizar más de un líder de comité de evaluación y cómo mínimo uno";
                response.setStatus("0");
                response.setDescripcion(mensaje);
            } else if (cantLider == 0) {
                mensaje = "El comité de evaluación debe tener como mínimo un líder";
                response.setStatus("0");
                response.setDescripcion(mensaje);
            } else if (lstIntegrantesComite.size() < 3) {
                mensaje = "El comité de evaluación debe tener como mínimo 3 integrantes";
                response.setStatus("0");
                response.setDescripcion(mensaje);
            } else if (lstIntegrantesComite.size() % 2 == 0) {
                mensaje = "La cantidad de integrantes del comité de evaluación debe ser impar";
                response.setStatus("0");
                response.setDescripcion(mensaje);
            } else {
                RequestEliminarIntegrantesComite requestEliminarIntegrantes = new RequestEliminarIntegrantesComite();
                requestEliminarIntegrantes.setIdComite(idComite);
                ResponseEliminarIntegrantesComite responseEliminarIntegrantes = funcionarioServicio.deleteIntegrantesComite(requestEliminarIntegrantes);
                responseEliminarIntegrantes.getStatus();

                RequestGuardarIntegranteComite request = new RequestGuardarIntegranteComite();
                request.setIntegrantesComiteDTO(lstIntegrantesComite);
                response = funcionarioServicio.setIntegranteComite(request);
                mensaje = response.getDescripcion();
                status = response.getStatus();
                if ("1".equals(response.getStatus())) {
                    RequestLogAuditoria requestA = new RequestLogAuditoria();

                    
                    requestA.setUsers(new Users(principal.getName()));
                    requestA.setAccion(response.getAccion());
                    requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                    requestA.setIdelemento(idComite.longValue());
                    requestA.setModulo(modulo);
                    logAuditoria.registrarLog(requestA);
                }
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return response;
    }

    //Fin Comité de Evaluación - DFGG
    /**
     * Metodo que muestra la vista de busqueda del log de auditoria
     *
     * @return Url vista
     */
    @GetMapping("/visorLogAuditoria")
    public String visorLogAuditoria() {
        return "visorLogAuditoria";
    }

    /**
     * Metodo que trae los registros del log de auditoria que esten entre la
     * fecha inicial y la fecha final
     *
     * @param fechaI Fecha inicial
     * @param fechaF Fecha final
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/getLogXFechas")
    public String getLogXFechas(@RequestParam("fechaI") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaI,
            @RequestParam("fechaF") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaF, Model model) {
        ResponseTraerLogA response = new ResponseTraerLogA();
        RequestTraerLogA request = new RequestTraerLogA();
        request.setFechaF(fechaF);
        request.setFechaI(fechaI);
        response = logAuditoria.getLogsXFecha(request);
        model.addAttribute("registrosLog", response.getLogs());
        model.addAttribute("status", response.getStatus());
        model.addAttribute("mensaje", response.getDescripcion());
        return "visorLogAuditoria";
    }

    /**
     * Controlador encargado de ubicar la configuración de la App.
     *
     * @return Respuesta si fue exitóso o no la consulta, lista de
     * configuraciones.
     */
    @PostMapping(path = "/getConfiguracion")
    @ResponseBody
    public ResponseConfiguraciones getConfiguracion() {
        return configuracionServicio.getConfiguraciones();
    }

    /**
     * Método para consultar los parámetros de las configuraciones.
     *
     * @param model Modelo JSP
     * @param principal Sesion Spring Security
     * @return Url vista
     */
    @GetMapping("/configuracion")
    public String configuracion(Model model, Principal principal) {
        ResponseConfiguraciones response = configuracionServicio.getConfiguraciones();
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        model.addAttribute("configuraciones", response.getConfiguraciones());
        model.addAttribute("status", response.getStatus());
        model.addAttribute("mensaje", response.getDescripcion());
        return "configuracion";
    }

    /**
     * Controlador para guardar configuraciones.
     *
     * @param strRequest Lista de configuraciones
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/guardarConfiguraciones", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO guardarConfiguraciones(
            @RequestParam("request") String strRequest, Principal principal) {
        ResponseDTO response = new ResponseDTO();
        try {
            RequestConfiguraciones request = new RequestConfiguraciones();
            List<Configuracion> configuraciones = new ArrayList<>();
            JSONArray arr = new JSONArray(strRequest);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Configuracion c = new Configuracion(new BigDecimal(obj.get("idconfiguracion").toString()),
                        obj.get("nombreconfiguracion").toString(),
                        new Timestamp(new Date().getTime()),
                        new Integer(obj.get("valor").toString()));
                configuraciones.add(c);
            }

            request.setConfiguraciones(configuraciones);
            response = configuracionServicio.setConfiguraciones(request);
            if ("1".equals(response.getStatus())) {
                for (Configuracion c : configuraciones) {
                    RequestLogAuditoria requestA = new RequestLogAuditoria();
                    
                    requestA.setUsers(new Users(principal.getName()));
                    requestA.setAccion(response.getAccion());
                    requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                    requestA.setIdelemento(c.getIdconfiguracion().longValue());
                    requestA.setModulo(modulo);
                    logAuditoria.registrarLog(requestA);
                }
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Método que trae una lista de instituciones y muestra la vista de gestión
     * de instituciones
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/institucionesOferentes")
    public String institucionesOferentes(Model model) {
        List<InstitucionesDTO> instituciones = institucionesServicio.getInstituciones().getInstituciones();
        model.addAttribute("instituciones", instituciones);
        return "institucionesOferentes";
    }

    /**
     *
     * Método que crea una institución
     *
     * @param correoElectronico Email de la institución
     * @param nombreInstitucion Nombre de la institución
     * @param naturalezaJuridica Naturaleza jurÃ­dica de la institución
     * @param nit Nit de la institución
     * @param origen Origen de la institución
     * @param estado Estado de la institución
     * @param tipoInstitucion Tipo de la institución
     * @param estadoAprobacion Estado de aprobación de la institución
     * @param tipoCertificacion Tipo de certificacion de la institución
     * @param telefono TelÃ©fono de la institución
     * @param digitoVerificacion Digito de verificación del NIT
     * @param principal El usuario en sesión
     * @return respuesta si se creó la institución exitosamente o no
     */
    @PostMapping(path = "crearInstitucionOferente", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO crearInstitucionOferente(@RequestParam("email") String correoElectronico,
            @RequestParam("nombreInstitucion") String nombreInstitucion,
            @RequestParam("naturalezaJuridica") int naturalezaJuridica,
            @RequestParam("nit") String nit,
            @RequestParam("origen") char origen,
            @RequestParam("estado") char estado,
            @RequestParam("tipoInstitucion") BigDecimal tipoInstitucion,
            @RequestParam("estadoAprobacion") char estadoAprobacion,
            @RequestParam("tipoCertificacion") BigDecimal tipoCertificacion,
            @RequestParam(name = "telefono", required = false) String telefono,
            @RequestParam(name = "digitoVerificacion", required = false) Long digitoVerificacion,
            Principal principal) {
        RequestInstitucion request = new RequestInstitucion();
        request.setCorreoElectronico(correoElectronico);
        request.setNombreInstitucion(nombreInstitucion);
        request.setNaturalezaJuridica(naturalezaJuridica);
        request.setNit(nit);
        request.setOrigen(origen);
        request.setEstado(estado);
        request.setTipoInstitucionId(tipoInstitucion);
        request.setEstadoAprobacion(estadoAprobacion);
        request.setTipoCertificacion(tipoCertificacion);
        request.setNumeroTelefono(telefono);
        request.setDigitoVerificacion(digitoVerificacion);
        ResponseDTO response = institucionesServicio.crearInstitucion(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que actualiza una institución
     *
     * @param correoElectronico Email de la institución
     * @param nombreInstitucion Nombre de la institución
     * @param naturalezaJuridica Naturaleza jurÃ­dica de la institución
     * @param nit Nit de la institución
     * @param origen Origen de la institución
     * @param estado Estado de la institución
     * @param tipoInstitucion Tipo de la institución
     * @param estadoAprobacion Estado de aprobación de la institución
     * @param tipoCertificacion Tipo de certificacion de la institución
     * @param id Id de la institución
     * @param telefono TelÃ©fono de la institución
     * @param digitoVerificacion Digito de verificación del NIT
     * @param principal El usuario en sesión
     * @return respuesta si se actualizó la institución exitosamente o no
     */
    @PostMapping(path = "modificarInstitucionOferente", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO modificarInstitucionOferente(@RequestParam("correoElectronico") String correoElectronico,
            @RequestParam("nombreInstitucion") String nombreInstitucion,
            @RequestParam("naturalezaJuridica") int naturalezaJuridica,
            @RequestParam("nit") String nit,
            @RequestParam("origen") char origen,
            @RequestParam("estado") char estado,
            @RequestParam("tipoInstitucion") BigDecimal tipoInstitucion,
            @RequestParam("estadoAprobacion") char estadoAprobacion,
            @RequestParam("tipoCertificacion") BigDecimal tipoCertificacion,
            @RequestParam("id") BigDecimal id,
            @RequestParam(name = "telefono", required = false) String telefono,
            @RequestParam(name = "digitoVerificacion", required = false) Long digitoVerificacion,
            Principal principal) {
        RequestInstitucion request = new RequestInstitucion();
        request.setId(id);
        request.setCorreoElectronico(correoElectronico);
        request.setNombreInstitucion(nombreInstitucion);
        request.setNaturalezaJuridica(naturalezaJuridica);
        request.setNit(nit);
        request.setOrigen(origen);
        request.setEstado(estado);
        request.setTipoInstitucionId(tipoInstitucion);
        request.setEstadoAprobacion(estadoAprobacion);
        request.setTipoCertificacion(tipoCertificacion);
        request.setNumeroTelefono(telefono);
        request.setDigitoVerificacion(digitoVerificacion);
        ResponseDTO response = institucionesServicio.modificarInstitucion(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(id.longValue());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que muestra la vista de registro de instituciones / oferentes
     *
     * @return Url vista
     */
    @GetMapping("/registroInstituciones")
    public String registroInstituciones() {
        return "registroInstituciones";
    }

    /**
     * Método que trae una institución a partir de su id y muestra la vista de
     * actualización de instituciones
     *
     * @param model Modelo JSP
     * @param id El id de la institución a actualizar
     * @return Url vista
     */
    @GetMapping(path = "/modificarInstituciones", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerInstitucion modificarInstituciones(Model model, @RequestParam("id") BigDecimal id) {
        RequestTraerInstitucion request = new RequestTraerInstitucion();
        request.setId(id);
        ResponseTraerInstitucion response = institucionesServicio.traerInstitucion(request);
//        model.addAttribute("mensaje", response.getDescripcion());
//        model.addAttribute("status", response.getStatus());
//        model.addAttribute("institucion", response.getInstituciones());
//        return "modificarInstituciones";
        return response;
    }

    /**
     * Método que trae una lista de instituciones, una lista de programas de
     * capacitación y muestra la vista de gestión de programas de
     * capacitación
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/capacitacionPrograma")
    public String capacitacionPrograma(Model model) {
        ResponseCapacitaciones response = capacitacionProgramaServicio.getCapacitacionesParametrizar();
        List<InstitucionesDTO> instituciones = institucionesServicio.getInstituciones().getInstituciones();
        model.addAttribute("instituciones", instituciones);
        model.addAttribute("capacitaciones", response.getCapacitaciones());
        return "capacitacionPrograma";
    }

    /**
     * Método que muestra la vista de registro de programas de capacitación
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registroCapacitacion")
    public String registroCapacitacion(Model model) {
        List<InstitucionesDTO> instituciones = institucionesServicio.getInstituciones().getInstituciones();
        ResponseGetCategorias response = categoriaServicio.getCategorias();
        model.addAttribute("categorias", response.getCategorias());
        model.addAttribute("instituciones", instituciones);
        return "registroCapacitacion";
    }

    /**
     * Método que crea una Capacitación
     *
     * @param nombrecapacitacionprograma El nombre de la capacitación
     * @param idoferenteinstitucion El id de la institución oferente
     * @param idcategoria El id de la categorÃ­a
     * @param principal El usuario en sesión
     * @return Una respuesta si se creó la capacitación exitosamente o no
     */
    @PostMapping(path = "/crearCapacitacionPrograma", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO crearCapacitacionPrograma(@RequestParam("nombrecapacitacionprograma") String nombrecapacitacionprograma,
            @RequestParam("idoferenteinstitucion") long idoferenteinstitucion,
            @RequestParam("idcategoria") long idcategoria, Principal principal) {
        RequestCapacitacion request = new RequestCapacitacion();
        request.setIdoferenteinstitucion(idoferenteinstitucion);
        request.setNombrecapacitacionprograma(nombrecapacitacionprograma);
        Categoria categoria = new Categoria();
        categoria.setIdcategoria(idcategoria);
        request.setCategoria(categoria);
        Estadocapacitacionprograma estado = new Estadocapacitacionprograma();
        estado.setIdestadocapacitacionprograma(1);
        request.setEstadoCapacitacionPrograma(estado);
        ResponseDTO response = capacitacionProgramaServicio.crearCapacitacion(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }

        return response;
    }

    /**
     * Método que trae una capacitación a partir de su id y muestra la vista de
     * actualización de programas de capacitacion
     *
     * @param model Modelo JSP
     * @param idcapacitacionprograma El id de la capacitación
     * @return Url vista
     */
    @GetMapping("/modificarCapacitacion")
    public String modificarCapacitacion(Model model, @RequestParam("idcapacitacionprograma") long idcapacitacionprograma) {
        RequestTraerCapacitacion request = new RequestTraerCapacitacion();
        request.setIdcapacitacionprograma(idcapacitacionprograma);
        ResponseTraerCapacitacion response = capacitacionProgramaServicio.traerCapacitacion(request);
        ResponseTraerEstadosCapacitacion response2 = estadoCapacitacionProgramaServicio.getEstadosCapacitacion();
        List<InstitucionesDTO> instituciones = institucionesServicio.getInstituciones().getInstituciones();
        ResponseGetCategorias response3 = categoriaServicio.getCategorias();
        model.addAttribute("categorias", response3.getCategorias());
        model.addAttribute("instituciones", instituciones);
        model.addAttribute("mensaje", response.getDescripcion());
        model.addAttribute("status", response.getStatus());
        model.addAttribute("capacitacion", response.getCapacitacion());
        model.addAttribute("estados", response2.getEstados());
        return "modificarCapacitacion";
    }

    /**
     * Método que actualiza una capacitación
     *
     * @param nombrecapacitacionprograma El nombre de la capacitación
     * @param idoferenteinstitucion El id de la institución oferente
     * @param idcategoria El id de la categorÃ­a
     * @param idcapacitacionprograma El id de la capacitación a actualizar
     * @param estados El estado de la capacitación
     * @param principal El usuario en sesión
     * @return Una respuesta si se actualizó la capacitación exitosamente o no
     */
    @PostMapping(path = "/modificarCapacitacionPrograma", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO modificarCapacitacionPrograma(@RequestParam("nombrecapacitacionprograma") String nombrecapacitacionprograma,
            @RequestParam("idoferenteinstitucion") long idoferenteinstitucion,
            @RequestParam("idcategoria") long idcategoria,
            @RequestParam("idcapacitacionprograma") long idcapacitacionprograma,
            @RequestParam("estados") long estados,
            Principal principal) {
        RequestCapacitacion request = new RequestCapacitacion();
        request.setIdoferenteinstitucion(idoferenteinstitucion);
        request.setNombrecapacitacionprograma(nombrecapacitacionprograma);
        Categoria categoria = new Categoria();
        categoria.setIdcategoria(idcategoria);
        request.setCategoria(categoria);
        Estadocapacitacionprograma estado = new Estadocapacitacionprograma();
        estado.setIdestadocapacitacionprograma(estados);
        request.setEstadoCapacitacionPrograma(estado);
        request.setIdcapacitacionprograma(idcapacitacionprograma);
        ResponseDTO response = capacitacionProgramaServicio.modificarCapacitacion(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idcapacitacionprograma);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que trae una lista de módulos y muestra la vista de gestión de
     * módulos
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/moduloCiclo")
    public String moduloCiclo(Model model) {
        ResponseModulosCiclo response = moduloCicloServicio.getModulos();
        model.addAttribute("modulos", response.getModulos());
        return "moduloCiclo";
    }

    /**
     * Método que crea un módulo
     *
     * @param idcapacitacionprograma El id de la capacitación del módulo a
     * crear
     * @param nombremodulociclo El nombre del módulo a crear
     * @param intensidadhoraria La intensidad horaria del módulo a crear
     * @param principal El usuario en sesión
     * @return Una respuesta si se creó el módulo exitosamente o no
     */
    @PostMapping(path = "/crearModuloCiclo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO crearModuloCiclo(@RequestParam("idcapacitacionprograma") long idcapacitacionprograma,
            @RequestParam("nombremodulociclo") String nombremodulociclo,
            @RequestParam("intensidadhoraria") short intensidadhoraria, Principal principal) {
        RequestModuloCiclo request = new RequestModuloCiclo();
        request.setIntensidadhoraria(intensidadhoraria);
        request.setNombremodulociclo(nombremodulociclo);
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setIdcapacitacionprograma(idcapacitacionprograma);
        request.setCapacitacionPrograma(capacitacion);
        ResponseDTO response = moduloCicloServicio.crearModulo(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que actualiza un módulo
     *
     * @param idcapacitacionprograma El id de la capacitación del módulo a
     * actualizar
     * @param nombremodulociclo El nombre del módulo a actualizar
     * @param intensidadhoraria La intensidad horaria
     * @param idmodulociclo El id del módulo a actualizar
     * @param principal El usuario en sesión
     * @return Una respuesta si se actualizó el módulo exitosamente o no
     */
    @PostMapping(path = "/modificarModuloCiclo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO modificarModuloCiclo(@RequestParam("idcapacitacionprograma") long idcapacitacionprograma,
            @RequestParam("nombremodulociclo") String nombremodulociclo,
            @RequestParam("intensidadhoraria") short intensidadhoraria,
            @RequestParam("idmodulociclo") long idmodulociclo,
            Principal principal) {
        RequestModuloCiclo request = new RequestModuloCiclo();
        request.setIntensidadhoraria(intensidadhoraria);
        request.setNombremodulociclo(nombremodulociclo);
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setIdcapacitacionprograma(idcapacitacionprograma);
        request.setCapacitacionPrograma(capacitacion);
        request.setIdmodulociclo(idmodulociclo);
        ResponseDTO response = moduloCicloServicio.modificarModulo(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idmodulociclo);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que trae un módulo a partir de su id y muestra la vista de
     * actualización de módulos
     *
     * @param model Modelo JSP
     * @param idmodulociclo El id del módulo a actualizar
     *
     * @return Url vista
     */
    @GetMapping("/modificarModulo")
    public String modificarModulo(Model model, @RequestParam("idmodulociclo") long idmodulociclo) {
        RequestModuloCiclo request = new RequestModuloCiclo();
        request.setIdmodulociclo(idmodulociclo);
        ResponseTraerModulo response = moduloCicloServicio.traerModulo(request);
        ResponseCapacitaciones response2 = capacitacionProgramaServicio.getCapacitaciones();
        model.addAttribute("capacitaciones", response2.getCapacitaciones());
        model.addAttribute("modulo", response.getModulo());
        return "modificarModulo";
    }

    /**
     * Método que muestra la vista de registro de módulos
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registroModulo")
    public String registroModulo(Model model) {
        ResponseCapacitaciones response = capacitacionProgramaServicio.getCapacitaciones();
        model.addAttribute("capacitaciones", response.getCapacitaciones());
        return "registroModulo";
    }

    /**
     * Método que trae una lista de categorÃ­as y muestra la vista de gestión
     * de categorÃ­as
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/categorias")
    public String categorias(Model model) {
        ResponseGetCategorias response = categoriaServicio.getCategorias();
        model.addAttribute("categorias", response.getCategorias());
        return "categorias";
    }

    /**
     * Método que crea una categorÃ­a
     *
     * @param nombrecategoria nombre de la categorÃ­a a crear
     * @param descripcion Descripción de la categorÃ­a a crear
     * @param porcentajeaprobacion Porcentaje de aprobación de la categorÃ­a a
     * crear
     * @param calificacionaprobacion Calificación de aprobación de la
     * categorÃ­a a crear
     * @param principal El usuario en sesión
     * @return Una respuesta si se creó la categorÃ­a exitosamente o no
     */
    @PostMapping(path = "/crearCategoria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO crearCategoria(@RequestParam("nombrecategoria") String nombrecategoria,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("porcentajeaprobacion") short porcentajeaprobacion,
            @RequestParam("calificacionaprobacion") short calificacionaprobacion,
            Principal principal) {
        RequestCategoria request = new RequestCategoria();
        request.setCalificacionaprobacion(calificacionaprobacion);
        request.setDescripcion(descripcion);
        request.setNombrecategoria(nombrecategoria);
        request.setPorcentajeaprobacion(porcentajeaprobacion);
        ResponseDTO response = categoriaServicio.crearCategoria(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que actualiza una categorÃ­a
     *
     * @param nombrecategoria nombre de la categorÃ­a a actualizar
     * @param descripcion Descripción de la categorÃ­a a actualizar
     * @param porcentajeaprobacion Porcentaje de aprobación de la categorÃ­a a
     * actualizar
     * @param calificacionaprobacion Calificación de aprobación de la
     * categorÃ­a a actualizar
     * @param idcategoria El id de la categorÃ­a a actualizar
     * @param principal El usuario en sesión
     * @return Una respuesta si se actualizó la categorÃ­a exitosamente o no
     */
    @PostMapping(path = "/modificarCategoriaPrograma", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO modificarCategoriaPrograma(@RequestParam("nombrecategoria") String nombrecategoria,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("porcentajeaprobacion") short porcentajeaprobacion,
            @RequestParam("calificacionaprobacion") short calificacionaprobacion,
            @RequestParam("idcategoria") long idcategoria,
            Principal principal) {
        RequestCategoria request = new RequestCategoria();
        request.setCalificacionaprobacion(calificacionaprobacion);
        request.setDescripcion(descripcion);
        request.setNombrecategoria(nombrecategoria);
        request.setPorcentajeaprobacion(porcentajeaprobacion);
        request.setIdcategoria(idcategoria);
        ResponseDTO response = categoriaServicio.modificarCategoria(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idcategoria);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que trae una categorÃ­a a partir de su id y muestra la vista de
     * actualización de categorÃ­as
     *
     * @param model Modelo JSP
     * @param idcategoria El id de la categorÃ­a a traer
     *
     *
     * @return Url vista
     */
    @GetMapping("/modificarCategoria")
    public String modificarCategoria(Model model, @RequestParam("idcategoria") long idcategoria) {
        RequestCategoria request = new RequestCategoria();
        request.setIdcategoria(idcategoria);
        ResponseTraerCategoria response = categoriaServicio.traerCategoria(request);
        model.addAttribute("categoria", response.getCategoria());
        return "modificarCategoria";
    }

    /**
     * Método que muestra la vista de registro de categorÃ­as
     *
     * @return Url vista
     */
    @GetMapping("/registroCategoria")
    public String registroCategoria() {
        return "registroCategoria";
    }

    /**
     * Método que trae una lista de docentes y muestra la vista de gestión de
     * docentes
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/docentes")
    public String docentes(Model model) {
        ResponseDocentes response = docentesServicio.getDocentesParametrizar();
        model.addAttribute("docentes", response.getDocentes());
        return "docentes";
    }

    /**
     *
     * Método que crea un docente
     *
     * @param primernombre El primer nombre del docente a crear
     * @param segundonombre El segundo nombre del docente a crear
     * @param primerapellido El primer apellido del docente a crear
     * @param segundoapellido El segundo apellido del docente a crear
     * @param email El email del docente a crear
     * @param telefono El telefono del docente a crear
     * @param idtipodocumento El id de tipo de documento del docente a crear
     * @param numerodocumento El nÃºmero de documento del docente a crear
     * @param principal El usuario en sesión
     * @return Una respuesta si se creó el docente exitosamente o no
     */
    @PostMapping(path = "/crearDocente", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO crearDocente(@RequestParam("primernombre") String primernombre,
            @RequestParam("segundonombre") String segundonombre,
            @RequestParam("primerapellido") String primerapellido,
            @RequestParam("segundoapellido") String segundoapellido,
            @RequestParam("email") String email,
            @RequestParam("telefono") long telefono,
            @RequestParam("idtipodocumento") BigDecimal idtipodocumento,
            @RequestParam("numerodocumento") String numerodocumento,
            Principal principal) {
        RequestDocente request = new RequestDocente();
        request.setPrimernombre(primernombre);
        request.setSegundonombre(segundonombre);
        request.setPrimerapellido(primerapellido);
        request.setSegundoapellido(segundoapellido);
        request.setEmail(email);
        request.setTelefono(telefono);
        Tipodocumentoid tipoId = new Tipodocumentoid();
        tipoId.setIdtipodocumento(idtipodocumento);
        request.setTipodocumentoid(tipoId);
        request.setNumerodocumento(numerodocumento);
        Estadodocente estadoDocente = new Estadodocente();
        estadoDocente.setIdestadodocente(1);
        request.setEstadoDocente(estadoDocente);
        ResponseDTO response = docentesServicio.crearDocente(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que actualiza un docente
     *
     * @param primernombre El primer nombre del docente a actualizar
     * @param segundonombre El segundo nombre del docente a actualizar
     * @param primerapellido El primer apellido del docente a actualizar
     * @param segundoapellido El segundo apellido del docente a actualizar
     * @param email El email del docente a actualizar
     * @param telefono El telefono del docente a actualizar
     * @param idtipodocumento El id de tipo de documento del docente a
     * actualizar
     * @param numerodocumento El nÃºmero de documento del docente a actualizar
     * @param iddocente El id del docente a actualizar
     * @param idestadodocente El id del estado del docente a actualizar
     * @param principal El usuario en sesión
     * @return Una respuesta si se actualizó el docente exitosamente o no
     */
    @PostMapping(path = "/modificarDocente2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO modificarDocente2(@RequestParam("primernombre") String primernombre,
            @RequestParam("segundonombre") String segundonombre,
            @RequestParam("primerapellido") String primerapellido,
            @RequestParam("segundoapellido") String segundoapellido,
            @RequestParam("email") String email,
            @RequestParam("telefono") long telefono,
            @RequestParam("idtipodocumento") BigDecimal idtipodocumento,
            @RequestParam("numerodocumento") String numerodocumento,
            @RequestParam("iddocente") long iddocente,
            @RequestParam("idestadodocente") long idestadodocente,
            Principal principal) {
        RequestDocente request = new RequestDocente();
        request.setPrimernombre(primernombre);
        request.setSegundonombre(segundonombre);
        request.setPrimerapellido(primerapellido);
        request.setSegundoapellido(segundoapellido);
        request.setEmail(email);
        request.setTelefono(telefono);
        Tipodocumentoid tipoId = new Tipodocumentoid();
        tipoId.setIdtipodocumento(idtipodocumento);
        request.setTipodocumentoid(tipoId);
        request.setNumerodocumento(numerodocumento);
        request.setIddocente(iddocente);
        Estadodocente estadoDocente = new Estadodocente();
        estadoDocente.setIdestadodocente(idestadodocente);
        request.setEstadoDocente(estadoDocente);
        ResponseDTO response = docentesServicio.modificarDocente(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(iddocente);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Método que trae un docente a partir de su id y muestra la vista de
     * actualización de docentes
     *
     * @param model Modelo JSP
     * @param iddocente El id del docente a traer
     *
     * @return Url vista
     */
    @GetMapping("/modificarDocente")
    public String modificarDocente(Model model, @RequestParam("iddocente") long iddocente) {
        RequestDocente request = new RequestDocente();
        request.setIddocente(iddocente);
        ResponseEstadoDocentes response2 = estadoDocenteServicio.getEstadosDocente();
        ResponseTraerDocente response = docentesServicio.traerDocente(request);
        RequestTraerTipoD request3 = new RequestTraerTipoD();
        ResponseTraerTipoD response3 = new ResponseTraerTipoD();
        response3 = tipoDocumentoServicio.getTipoDocumento(request3);
        model.addAttribute("tiposDTO", response3.getTipoDTO());
        model.addAttribute("docente", response.getDocente());
        model.addAttribute("estadosDocente", response2.getEstadosDocente());
        return "modificarDocente";
    }

    /**
     * Método que muestra la vista de registro de docentes
     *
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/registroDocentes")
    public String registroDocentes(Model model) {
        RequestTraerTipoD request = new RequestTraerTipoD();
        ResponseTraerTipoD response = new ResponseTraerTipoD();
        response = tipoDocumentoServicio.getTipoDocumento(request);
        model.addAttribute("tiposDTO", response.getTipoDTO());
        return "registroDocentes";
    }

    @GetMapping("/sedes")
    public String sedes(Model model) {
        ResponseSedes response = sedesServicio.getSedes();
        model.addAttribute("sedes", response.getSedes());
        return "sedes";
    }

    @GetMapping(path = "/traerSede", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSedes traerSede(@RequestParam("id") BigDecimal id) {
        ResponseSedes response = sedesServicio.getSedePorID(id);
        RequestTraerInstitucion request = new RequestTraerInstitucion();
        request.setId(response.getSedes().get(0).getIdInstitucion());
        ResponseTraerInstitucion response2 = institucionesServicio.traerInstitucion(request);
        response.setInstitucion(response2.getInstitucion());
        if (response2.getStatus().equals("0")) {
            response.setStatus("0");
            response.setDescripcion(response2.getDescripcion());
        }
        return response;
    }
}

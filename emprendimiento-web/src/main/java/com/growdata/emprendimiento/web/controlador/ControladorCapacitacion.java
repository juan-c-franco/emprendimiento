/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.google.gson.Gson;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAlumnos;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseProgramaciones;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSedes;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ProgramacionDTO;
import com.growdata.emprendimiento.business.servicio.AlumnosServicio;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.CapacitacionProgramaServicio;
import com.growdata.emprendimiento.business.servicio.DepartamentosServicio;
import com.growdata.emprendimiento.business.servicio.DocentesServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.InstitucionesServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.ProgramacionServicio;
import com.growdata.emprendimiento.business.servicio.SedesServicio;
import com.growdata.emprendimiento.business.servicio.SeguimientoasistenciaServicio;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Docentes;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ModuloscicloShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSeguimientoasistencia;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.servicio.AprobacionServicio;
import com.growdata.emprendimiento.business.servicio.ModuloCicloServicio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Franco
 */
@Controller
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class ControladorCapacitacion {

    private final BigDecimal grupo = new BigDecimal(5);

    @Autowired
    private Environment env;

    @Autowired
    private FuncionarioServicio funcionarioServicio;
    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;
    @Autowired
    private SedesServicio sedesServicio;
    @Autowired
    private InstitucionesServicio institucionesServicio;
    @Autowired
    private CapacitacionProgramaServicio capacitacionProgramaServicio;
    @Autowired
    private DocentesServicio docentesServicio;
    @Autowired
    private ProgramacionServicio programacionServicio;
    @Autowired
    private LogAuditoriaServicio logAuditoria;
    @Autowired
    private AlumnosServicio alumnosServicio;
    @Autowired
    private DepartamentosServicio departamentosServicio;
    @Autowired
    private SeguimientoasistenciaServicio seguimientoasistenciaServicio;
    @Autowired
    private AprobacionServicio aprobacionServicio;
    @Autowired
    private ModuloCicloServicio moduloCicloServicio;

    private String modulo = "Capacitación";

    /**
     * Controlador que muestra la vista para la funcionalidad Programar
     * Capacitación.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping("/cargarDatosProgramarCapacitacion")
    public String cargarDatosProgramarCapacitacion(Model model, Principal principal,
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
                model.addAttribute("url", "/cargarDatosProgramarCapacitacion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }
        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("oferentes", institucionesServicio.getInstituciones().getInstituciones());
        model.addAttribute("capacitaciones", capacitacionProgramaServicio.getCapacitaciones().getCapacitaciones());
        model.addAttribute("docentes", docentesServicio.getDocentes().getDocentes());
        model.addAttribute("url", "/programarCapacitacionView");
        return "setIdDocente";

    }

    /**
     * Controlador encargado de traer las sedes dado un oferente.
     *
     * @param idoferente Identificador del Oferente
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * sedes.
     */
    @GetMapping(path = "/getSedesPorOferente", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSedes getSedesPorOferente(@RequestParam("idoferente") BigDecimal idoferente) {
        return sedesServicio.getSedesPorOferente(idoferente);
    }

    /**
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Programar Capcitación
     *
     * @return Vista a ser redireccionada.
     */
    @GetMapping("/programarCapacitacionView")
    public ModelAndView programarCapacitacionView() {
        ModelAndView view = new ModelAndView("programarCapacitacion");
        return view;
    }

    /**
     * Controlador encargado de crear una programación.
     *
     * @param fechaInicial Fecha de Inicio
     * @param fechaFinal Fecha Fin
     * @param maxCantidad Máxima cantidad de asistentes
     * @param idFuncionario Identificador del Funcionario que registra la sesión
     * @param idCapacitacion Identificador de la Capacitaciòn vinculada a la
     * programaciòn.
     * @param idDocente Identificador del Docente que dictarà la Capacitaciòn.
     * @param idSede Identificador de la Sede donde se dictarà la Capacitaciòn.
     * @param ubicacion Ubicación de la Programación.
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/guardarProgramacion")
    @ResponseBody
    public ResponseDTO guardarProgramacion(
            @RequestParam("fechaInicial") String fechaInicial,
            @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("maxCantidad") short maxCantidad,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idCapacitacion") long idCapacitacion,
            @RequestParam("idDocente") long idDocente,
            @RequestParam("idSede") BigDecimal idSede,
            @RequestParam("ubicacion") String ubicacion,
            Principal principal) {
        ResponseDTO response = new ResponseDTO();
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();

            Programacion programacion = new Programacion(null, new Estadosesion(BigDecimal.ONE), new Funcionario(idFuncionario),
                    new Capacitacionprograma(idCapacitacion), new Docentes(idDocente),
                    idSede, new Timestamp(simple.parse(fechaInicial).getTime()),
                    new Timestamp(simple.parse(fechaFinal).getTime()), maxCantidad, new Date(), ubicacion, null);

            response = programacionServicio.saveProgramaciones(programacion);
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
     * Controlador que se utiliza para actualizar una Programación
     *
     * @param fechaInicial Fecha y hora de inicio de la Capacitación.
     * @param fechaFinal Fecha y hora de fin de la Capacitación
     * @param maxCantidad Máxima cantidad de Asistentes
     * @param idFuncionario Identificador del Funcionario que hizo la
     * modificación.
     * @param idCapacitacion Identificador de la Capacitación.
     * @param idDocente Identificador del Docente que dictará la Capacitación.
     * @param idSede Identificador de la Sede donde se dictará la Capacitación.
     * @param idProgramacion Identificador de la Programación
     * @param ubicacion Ubicación donde si dictará la Capacitación.
     * @param principal Sesión Srping Security
     * @return ResponseDTO Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/actualizarProgramacion")
    @ResponseBody
    public ResponseDTO actualizarProgramacion(
            @RequestParam("fechaInicial") String fechaInicial,
            @RequestParam("fechaFinal") String fechaFinal,
            @RequestParam("maxCantidad") short maxCantidad,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idCapacitacion") long idCapacitacion,
            @RequestParam("idDocente") long idDocente,
            @RequestParam("idSede") BigDecimal idSede,
            @RequestParam("idProgramacion") BigDecimal idProgramacion,
            @RequestParam("ubicacion") String ubicacion,
            Principal principal) {
        ResponseDTO response = new ResponseDTO();
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            Programacion programacion = new Programacion(idProgramacion, new Estadosesion(BigDecimal.ONE), new Funcionario(idFuncionario),
                    new Capacitacionprograma(idCapacitacion), new Docentes(idDocente),
                    idSede, new Timestamp(simple.parse(fechaInicial).getTime()),
                    new Timestamp(simple.parse(fechaFinal).getTime()), maxCantidad, new Date(), ubicacion, null);

            response = programacionServicio.updateProgramaciones(programacion);
            if ("1".equals(response.getStatus())) {
                RequestLogAuditoria requestA = new RequestLogAuditoria();

                requestA.setUsers(new Users(principal.getName()));
                requestA.setAccion(response.getAccion());
                requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                requestA.setIdelemento(new Long(idProgramacion.toString()));
                requestA.setModulo(modulo);
                logAuditoria.registrarLog(requestA);
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Controlador para cancelar un programación.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param principal Sesión Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/eliminarProgramacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO eliminarProgramacion(@RequestParam("idProgramacion") BigDecimal idProgramacion,
            Principal principal) {
        Programacion p = new Programacion();
        p.setIdprogramacion(idProgramacion);
        ResponseDTO response = new ResponseDTO();
        response = programacionServicio.deleteProgramaciones(p);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(new Long(idProgramacion.toString()));
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Controlador encargado de cargar las programaciones que cumplan con los
     * paràmetros de bùsqueda.
     *
     * @param idDocente Identificador del Funcionario
     * @param todas Indicador para seleccionar o no las programaciones del
     * pasado.
     * @return Respuesta si fue exitoso o no la consulta y las sesiones
     * conseguidas.
     */
    @GetMapping(path = "/cargarProgramaciones", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseProgramaciones cargarProgramaciones(
            @RequestParam(name = "idDocente", required = false) Long idDocente,
            @RequestParam(name = "todas") int todas) {
        long id = -1;
        if (idDocente != null) {
            id = idDocente;
        }
        Date desde = null;
        if (todas == 0) {
            desde = new Date();
        }
        return programacionServicio.getProgramaciones(id, desde);
    }

    /**
     * Método encargado de traer los asistentes de una Programación.
     *
     * @param idProgramacion Identificador de la programación
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * asistencia.
     */
    @GetMapping(path = "/getAsistentesProgramacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseAlumnos getAsistentesProgramacion(@RequestParam("idProgramacion") BigDecimal idProgramacion) {
        return alumnosServicio.getLista(idProgramacion);
    }

    /**
     * Controlador para ubicar una Programación por su identificador.
     *
     * @param idProgramacion Identificador de la programación.
     * @return Respuesta con las sesiones que cumplan con el criterio de
     * búsqueda.
     */
    @GetMapping(path = "/consultaProgramacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramacionDTO> consultaProgramacion(@RequestParam("idProgramacion") BigDecimal idProgramacion) {
        ResponseProgramaciones response = programacionServicio.getProgramacion(idProgramacion);
        if ("0".equals(response.getStatus())) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response.getProgramaciones().get(0), HttpStatus.OK);
    }

    /**
     * Controlador que muestra la vista para la funcionalidad Agendar
     * Capacitación.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping("/cargarDatosAgendarCapacitacion")
    public String cargarDatosAgendarCapacitacion(Model model, Principal principal,
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
                model.addAttribute("url", "/cargarDatosAgendarCapacitacion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("capacitaciones", capacitacionProgramaServicio.getCapacitaciones().getCapacitaciones());
        model.addAttribute("departamentos", departamentosServicio.getDepartamentos().getDepartamentos());
        model.addAttribute("url", "/agendarCapacitacionView");
        return "setIdCapacitacion";

    }

    /**
     * Controlador que muestra la vista para la funcionalidad Registrar
     * Asistencia Capacitación.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping("/cargarDatosRegistrarSeguimiento")
    public String cargarDatosRegistrarSeguimiento(Model model, Principal principal,
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
                model.addAttribute("url", "/cargarDatosRegistrarSeguimiento");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("capacitaciones", capacitacionProgramaServicio.getCapacitaciones().getCapacitaciones());
        model.addAttribute("departamentos", departamentosServicio.getDepartamentos().getDepartamentos());
        model.addAttribute("url", "/registrarAsistenciaCapacitacionView");
        return "setIdCapacitacion";

    }

    /**
     * Controlador que muestra la vista para la funcionalidad Registrar
     * Calificación Capacitación.
     *
     * @param model Modelo JSP
     * @param principal Sesión Spring Security
     * @param idfuncionario Identificador del Funcionario
     * @return Url vista
     */
    @RequestMapping("/cargarDatosRegistrarCalificacion")
    public String cargarDatosRegistrarCalificacion(Model model, Principal principal,
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
                model.addAttribute("url", "/cargarDatosRegistrarCalificacion");
                model.addAttribute("grupo", grupo.intValue());
                return "setIdFuncionario";
            }
            idfuncionario = funcionario.getIdfuncionario();
        }

        model.addAttribute("idFuncionario", idfuncionario);
        model.addAttribute("capacitaciones", capacitacionProgramaServicio.getCapacitaciones().getCapacitaciones());
        model.addAttribute("departamentos", departamentosServicio.getDepartamentos().getDepartamentos());
        model.addAttribute("url", "/registrarCalificaciónCapacitacionView");
        return "setIdCapacitacion";

    }

    /**
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Registrar Calificación Capacitación.
     *
     * @return Vista a ser redireccionada.
     */
    @GetMapping("/registrarCalificaciónCapacitacionView")
    public ModelAndView registrarCalificacionCapacitacionView() {
        ModelAndView view = new ModelAndView("registrarCalificaciónCapacitacion");
        return view;
    }

    /**
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Registrar Asistencia Programación.
     *
     * @return Vista a ser redireccionada.
     */
    @GetMapping("/registrarAsistenciaCapacitacionView")
    public ModelAndView registrarAsistenciaCapacitacionView() {
        ModelAndView view = new ModelAndView("registrarAsistenciaCapacitacion");
        return view;
    }

    /**
     * Controlador encargado de traer las sedes dado un oferente.
     *
     * @param municipio Identificador del Municipio
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * sedes.
     */
    @GetMapping(path = "/getSedesPorMunicipio", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSedes getSedesPorMunicipio(@RequestParam("municipio") BigDecimal municipio) {
        return sedesServicio.getSedesPorMunicipio(municipio);
    }

    /**
     * Controlador encargado de traer la sede dado su identificador.
     *
     * @param idsede Identificador de la sede.
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * sedes.
     */
    @GetMapping(path = "/getSedesPorId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSedes getSedesPorId(@RequestParam("idsede") BigDecimal idsede) {
        return sedesServicio.getSedesPorId(idsede);
    }

    /**
     * Controlador encargado de traer una capacitación dado su identificador.
     *
     * @param idcapacitacion Identificador de la Capacitación
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * sedes.
     */
    @GetMapping(path = "/traerCapacitacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseTraerCapacitacion traerCapacitacion(@RequestParam("idcapacitacion") long idcapacitacion) {
        return capacitacionProgramaServicio.traerCapacitacion(new RequestTraerCapacitacion(idcapacitacion));
    }

    /**
     * Controlador encargado de traer una Programación dado su identificador.
     *
     * @param idProgramacion Identificador de la Programación
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * programaciones.
     */
    @GetMapping(path = "/getProgramacionPorId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseProgramaciones getProgramacionPorId(@RequestParam("idProgramacion") BigDecimal idProgramacion) {
        return programacionServicio.getProgramacion(idProgramacion);
    }

    /**
     * Controlador encargado de las Programaciones dado una Sede y
     * Capacitacióon.
     *
     * @param idsede Identificador de la Sede.
     * @param idcapacitacion Identificador de la Capacitación.
     * @param vencidas Indica si se quieren o no las sesiones del pasado.
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * programaciones.
     */
    @GetMapping(path = "/getProgramacionPorSedeCapacitacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseProgramaciones getProgramacionPorSedeCapacitacion(
            @RequestParam("idsede") BigDecimal idsede,
            @RequestParam("idcapacitacion") long idcapacitacion,
            @RequestParam(name = "vencidas") Short vencidas) {
        Date desde = new Date();
        if (vencidas == 1) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(desde);
            cal.add(Calendar.YEAR, -10);
            desde = cal.getTime();
        }
        return programacionServicio.getProgramacionPorSedeCapacitacion(
                idsede, idcapacitacion, desde, vencidas);
    }

    /**
     * Controlador encargado de registrar asistencia a una Capacitación.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param idFuncionario Identificador del Funcionario.
     * @param registros Registro de horas asistidas.
     * @param alumnos Lista de Alumnos.
     * @param modulos Lista de Módulos/Ciclos.
     *
     * @return Respuesta si fue exitosa o no la consulta.
     */
    @PostMapping(path = "/registrarAsistenciaCapacitacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseAprobaciones registrarAsistenciaCapacitacion(
            @RequestParam("idProgramacion") BigDecimal idProgramacion,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("registros") String registros,
            @RequestParam("alumnos") String alumnos,
            @RequestParam("modulos") String modulos) {
        Type listAlumnosType = new TypeToken<ArrayList<AlumnosShortDTO>>() {
        }.getType();
        Type listModulocicloType = new TypeToken<ArrayList<ModuloscicloShortDTO>>() {
        }.getType();
        List<AlumnosShortDTO> lAlumnos = new Gson().fromJson(alumnos, listAlumnosType);
        List<ModuloscicloShortDTO> lModulos = new Gson().fromJson(modulos, listModulocicloType);

        List<List<String>> registrosStr = new Gson().fromJson(registros, List.class);

        return seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                idProgramacion, idFuncionario, lAlumnos, lModulos, registrosStr);
    }

    /**
     * Controlador encargado de registrar calificación a una Capacitación.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param idFuncionario Identificador del Funcionario.
     * @param registros Registro de horas asistidas.
     * @param alumnos Lista de Alumnos.
     *
     * @return Respuesta si fue exitosa o no la consulta.
     */
    @PostMapping(path = "/registrarCalificacionCapacitacion",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseAprobaciones registrarCalificacionCapacitacion(
            @RequestParam("idProgramacion") BigDecimal idProgramacion,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("registros") String registros,
            @RequestParam("alumnos") String alumnos) {
        Type listAlumnosType = new TypeToken<ArrayList<AlumnosShortDTO>>() {
        }.getType();
        List<AlumnosShortDTO> lAlumnos = new Gson().fromJson(alumnos, listAlumnosType);
        List<String> registrosStr = new Gson().fromJson(registros, List.class);
        return aprobacionServicio.registrarCalificacionCapacitacion(
                idProgramacion, idFuncionario, lAlumnos, registrosStr);
    }

    /**
     * Controlador encargado de cargar la vista correspondiente a la
     * funcionalidad Agendar Capcitación
     *
     * @return Vista a ser redireccionada.
     */
    @GetMapping("/agendarCapacitacionView")
    public ModelAndView agendarCapacitacionView() {
        ModelAndView view = new ModelAndView("agendarCapacitacion");
        return view;
    }

    /**
     * Controlador encargado de asociar un Beneficiario a una Programción.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param idBeneficiario Identificador del Beneficiario.
     * @param idFuncionario Identificador del Funcionario que realiza la acción.
     * @param principal Sesión de Spring Security
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * programaciones.
     */
    @PostMapping(path = "/asociarBeneficiarioProgramacion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO asociarBeneficiarioProgramacion(
            @RequestParam("idProgramacion") BigDecimal idProgramacion,
            @RequestParam("idBeneficiario") long idBeneficiario,
            @RequestParam("idFuncionario") long idFuncionario,
            Principal principal) {
        ResponseDTO response = alumnosServicio.asociarBeneficiarioProgramacion(
                idProgramacion, idBeneficiario, idFuncionario);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();
            Users user = new Users();

            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date().getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        return response;
    }

    /**
     * Controlador encargado de ubicar el Seguimientoasistencia dado un Alumno y
     * un Modulociclo
     *
     * @param idalumno Identificador del Alumno.
     * @param idmodulociclo Identificador del Modulociclo.
     * @return Respuesta si fue exitosa o no la consulta, además de la lista de
     * programaciones.
     */
    @GetMapping(path = "/getSeguimientoAlumnoModulo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseSeguimientoasistencia getSeguimientoAlumnoModulo(
            @RequestParam("idalumno") BigDecimal idalumno,
            @RequestParam("idmodulociclo") long idmodulociclo) {
        return seguimientoasistenciaServicio.getSeguimientoAlumnoModulo(idalumno, idmodulociclo);
    }

    /**
     * Controlador encargado de calificar los emprendimientos en una Sesión
     * Comité.
     *
     * @param documento Acta de la Sesión Comité
     * @param alumnos Lista de Alumnos.
     * @param modulos Lista de Modulos.
     * @param idFuncionario Identificador del Funcionario.
     * @param idProgramacion Identificador de la Programación.
     * @param principal Sesion Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/registrarCalificacionCapacitacionMasiva", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarCalificacionCapacitacionMasiva(
            @RequestPart("documento") MultipartFile documento,
            @RequestParam("alumnos") String alumnos,
            @RequestParam("modulos") String modulos,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idProgramacion") BigDecimal idProgramacion, Principal principal
    ) {

        String mensajes = "";
        ResponseDTO response = new ResponseDTO();
        RequestModificarFuncionario request = new RequestModificarFuncionario();
        request.setIdfuncionario(idFuncionario);
        ResponseModificarFuncionario response2 = funcionarioServicio.getFuncionarioPorId(request);
        if ("0".equals(response2.getStatus())) {
            return response2;
        }

        try {
            String pathRoot = env.getProperty("root.path.files.capacitacion") + env.getProperty("delimiter.path")
                    + env.getProperty("path.files.capacitacion") + env.getProperty("delimiter.path")
                    + response2.getFuncionarioDTO().getNumerodocumento() + env.getProperty("delimiter.path");

            File carpetaTema = new File(pathRoot);
            carpetaTema.mkdirs();

            deleteFiles(pathRoot);
            writeBytesToFile(documento.getBytes(), pathRoot + documento.getOriginalFilename());
            File file = new File(pathRoot + documento.getOriginalFilename());

            BufferedReader br = new BufferedReader(new FileReader(file));

            List<RequestCalificacionDTO> requestCalificaciones = new ArrayList<>();
            String st;
            long linea = 1;
            while ((st = br.readLine()) != null) {
                String mensaje = "";
                String[] tokens = st.split("\\|\\$\\|");

                //Verifico número de columnas.
                if (tokens.length != 3) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_COLUMNAS_NO_COINCIDE + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico tipo de documento.
                if ("".equals(tokens[0])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_TIPO_DOCUMENTO_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico número de documento.
                if ("".equals(tokens[1])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_NUMERO_DOCUMENTO_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico calificación.
                if ("".equals(tokens[2])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_CALIFICACION_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                ResponseAlumnos aResponse = alumnosServicio.getAlumnoPorDocumento(tokens[0], tokens[1], idProgramacion);
                Short calificacion = new Short(tokens[2]);

                //Verifico que el Alumno exista en la programación.
                if (Mensajes.ERROR_ALUMNO_NO_EXISTE.equals(aResponse.getDescripcion())) {
                    mensaje += "Error en la linea " + linea + ": No "
                            + "existe Alumno asociado a esta Programación con número de documento: "
                            + tokens[0] + tokens[1] + "<br>";
                }

                //Verifico calificación.
                if (calificacion != 0 && calificacion != 1) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_CALIFICACION_FUERA_RANGO + "<br>";
                }

                if ("".equals(mensaje)) {
                    RequestCalificacionDTO dto = new RequestCalificacionDTO(aResponse.getAlumnos().get(0).getIdalumno(),
                            calificacion);
                    requestCalificaciones.add(dto);
                }
                mensajes += mensaje;
                linea++;
            }

            //Verifico si hubieron errores
            if (!"".equals(mensajes)) {
                response.setStatus("2");
                response.setDescripcion(mensajes);
                return response;
            }

            response = aprobacionServicio.registrarCalificacionCapacitacionMasiva(
                    requestCalificaciones, idFuncionario, idProgramacion);
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
     * Controlador encargado de calificar los emprendimientos en una Sesión
     * Comité.
     *
     * @param documento Acta de la Sesión Comité
     * @param alumnos Lista de Alumnos.
     * @param modulos Lista de Modulos.
     * @param idFuncionario Identificador del Funcionario.
     * @param idProgramacion Identificador de la Programación.
     * @param principal Sesion Spring Security
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @PostMapping(path = "/registrarAsistenciaCapacitacionMasiva", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO registrarAsistenciaCapacitacionMasiva(
            @RequestPart("documento") MultipartFile documento,
            @RequestParam("alumnos") String alumnos,
            @RequestParam("modulos") String modulos,
            @RequestParam("idFuncionario") long idFuncionario,
            @RequestParam("idProgramacion") BigDecimal idProgramacion, Principal principal
    ) {
        Set<Long> modulosSet = new HashSet<Long>(0);
        List<RequestModulocicloCheck> modulosList = new ArrayList<>();
        String mensajes = "";
        ResponseDTO response = new ResponseDTO();
        RequestModificarFuncionario request = new RequestModificarFuncionario();
        request.setIdfuncionario(idFuncionario);
        ResponseModificarFuncionario response2 = funcionarioServicio.getFuncionarioPorId(request);
        if ("0".equals(response2.getStatus())) {
            return response2;
        }

        try {
            String pathRoot = env.getProperty("root.path.files.capacitacion") + env.getProperty("delimiter.path")
                    + env.getProperty("path.files.capacitacion") + env.getProperty("delimiter.path")
                    + response2.getFuncionarioDTO().getNumerodocumento() + env.getProperty("delimiter.path");

            File carpetaTema = new File(pathRoot);
            carpetaTema.mkdirs();

            deleteFiles(pathRoot);
            writeBytesToFile(documento.getBytes(), pathRoot + documento.getOriginalFilename());
            File file = new File(pathRoot + documento.getOriginalFilename());

            BufferedReader br = new BufferedReader(new FileReader(file));

            List<RequestCalificacionDTO> requestCalificaciones = new ArrayList<>();
            String st;
            long linea = 1;
            while ((st = br.readLine()) != null) {
                String mensaje = "";
                String[] tokens = st.split("\\|\\$\\|");

                //Verifico número de columnas.
                if (tokens.length != 4) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_COLUMNAS_NO_COINCIDE + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico tipo de documento.
                if ("".equals(tokens[0])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_TIPO_DOCUMENTO_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico número de documento.
                if ("".equals(tokens[1])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_NUMERO_DOCUMENTO_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico módulo.
                if ("".equals(tokens[2])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_MODULO_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                //Verifico calificación.
                if ("".equals(tokens[3])) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_NUMERO_CALIFICACION_VACIO + "<br>";
                    mensajes += mensaje;
                    continue;
                }

                ResponseAlumnos aResponse = alumnosServicio.getAlumnoPorDocumento(tokens[0], tokens[1], idProgramacion);
                Long moduloLocal = new Long(tokens[2]);
                Boolean nuevo = modulosSet.add(moduloLocal);
                if (nuevo) {
                    modulosList.add(new RequestModulocicloCheck(moduloLocal, linea, true));
                } else {
                    for (RequestModulocicloCheck r : modulosList) {
                        if (r.getIdmodulociclo() == moduloLocal) {
                            r.getLineas().add(linea);
                            break;
                        }
                    }
                }
                Short horas = new Short(tokens[3]);

                //Verifico que el Alumno exista en la programación.
                if (Mensajes.ERROR_ALUMNO_NO_EXISTE.equals(aResponse.getDescripcion())) {
                    mensaje += "Error en la linea " + linea + ": No "
                            + "existe Alumno asociado a esta Programación con número de documento: "
                            + tokens[0] + tokens[1] + "<br>";
                }

                //Verifico horas.
                if (horas < 0 || horas > 999) {
                    mensaje += "Error en la linea " + linea + ": "
                            + Mensajes.ERROR_HORAS_ASISTENCIA_FUERA_RANGO + "<br>";
                }

                if ("".equals(mensaje)) {
                    RequestCalificacionDTO dto = new RequestCalificacionDTO(
                            aResponse.getAlumnos().get(0).getIdalumno(),
                            moduloLocal, horas);
                    requestCalificaciones.add(dto);
                }
                linea++;
                mensajes += mensaje;
            }

            ResponseModulocicloCheck response3 = moduloCicloServicio.check(modulosList, idProgramacion);

            for (RequestModulocicloCheck r : response3.getList()) {
                if (!r.getInvalid()) {
                    for (Long l : r.getLineas()) {
                        mensajes += "Error en la linea " + l + ": El módulo "
                                + r.getIdmodulociclo() + " no existe o no se "
                                + "encuentra asociado a la Programación seleccionada.<br>";
                    }
                }
            }

            //Verifico si hubieron errores
            if (!"".equals(mensajes)) {
                response.setStatus("2");
                response.setDescripcion(mensajes);
                return response;
            }

            response = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestCalificaciones, idFuncionario, idProgramacion);
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
}

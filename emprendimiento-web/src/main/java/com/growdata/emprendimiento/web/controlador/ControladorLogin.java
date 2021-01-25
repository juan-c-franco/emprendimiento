/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.login.RequestRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.login.ResponseRestaurarContrasena;
import com.growdata.emprendimiento.business.commons.EncriptadorUrl;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.commons.RequestLogSesion;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.business.servicio.FormulariosServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.LogInicioSesionServicio;
import com.growdata.emprendimiento.business.servicio.UserAttemptsServicio;
import com.growdata.emprendimiento.business.servicio.UsersServicio;
import com.growdata.emprendimiento.persistence.commons.CredencialesMalasException;
import com.growdata.emprendimiento.persistence.entidad.Formulariosweb;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//bloqueo de usuario
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Grow Data PC
 */
@Controller
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class ControladorLogin {

    @Autowired
    private FormulariosServicio formulariosServicio;
    @Autowired
    private LogInicioSesionServicio logInicioSesionServicio;

    @Autowired
    private BeneficiarioServicio beneficiarioServicio;
    @Autowired
    private UsersServicio usersServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;

    @Autowired
    private Environment env;

    @Autowired
    private UserAttemptsServicio userAttemptsServicio;

    private final String modulo = "Login";

    private final int intentosBloqueo = 3;

    /**
     * Metodo que registra al usuario en el log de inicio de sesion y muestra el
     * home de la aplicacion
     *
     * @param model Modelo JSP
     * @param principal El usuario en sesión
     * @return Url vista
     */
    @GetMapping("/")
    public String mostrarIndex(Model model, Principal principal) {
        RequestLogSesion request = new RequestLogSesion();
        request.setUsername(principal.getName());
        request.setDate(new Timestamp(System.currentTimeMillis()));
        logInicioSesionServicio.registrarLog(request);
        List<Formulariosweb> formularios = formulariosServicio.getFormularios();
        model.addAttribute("formularios", formularios);

        return "home";
    }

    /**
     * Metodo que muestra la pantalla de olvido de contraseña
     *
     * @return Url vista
     */
    @GetMapping("olvidoContrasena")
    public String olvidoContra() {
        return "olvidoContrasena";
    }

    /**
     * Metodo que muestra la pantalla de acceso denegado
     *
     * @return Url vista
     */
    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "acceso-denegado";
    }

    /**
     * Metodo que envia correo de recuperacion de contraseña
     *
     * @param correo Email
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/correoContrasena")
    public String enviarCorreoContrasena(@RequestParam("correo") String correo, Model model) {
        model.addAttribute("correo", correo);
        String correo2 = correo.toLowerCase();
        ResponseDTO response = beneficiarioServicio.enviarCorreoRecuperacion(correo2);

        model.addAttribute("mensaje", response.getDescripcion());
        model.addAttribute("statu", response.getStatus());

        return "olvidoContrasenaCorreo";
    }

    /**
     * Metodo que desencripta los parametros, trae el usuario en base a ellos y
     * muestra la pantalla de restaurar contraseña
     *
     * @param hfgrt El id del usuario encriptado
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("/resetPassword")
    public String resetPassword(@RequestParam("hfgrt") String hfgrt, Model model) {
        //traigo el usuario
        BigDecimal idUser;
        String decodificado = EncriptadorUrl.decode(hfgrt);
        String[] aux = decodificado.split("&");
        String[] aux2 = aux[0].split("=");
        String[] aux3 = aux[1].split("=");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();

        try {
            Date horaDate = format.parse(aux3[1]);
            cal.setTime(horaDate);
            cal.add(Calendar.HOUR, Integer.parseInt(env.getProperty("vigencia.link")));
            horaDate = cal.getTime();
            Timestamp hora = new Timestamp(horaDate.getTime());
            Timestamp horaActual = new Timestamp(System.currentTimeMillis());
            if (horaActual.compareTo(hora) > 0) {
                model.addAttribute("caducado", "Link Caducado");
            } else {
                idUser = new BigDecimal(aux2[1]);

                Users user = usersServicio.getUser(idUser);
                model.addAttribute("user", user);
            }
        } catch (Exception ex) {
            
        }

        return "cambioClave";
    }

    /**
     * Metodo que genera una nueva contraseña y envia un email al usuario con
     * sus nuevas credenciales
     *
     * @param username username
     * @param password contraseña
     * @param enabled Estado del username
     * @param id El id del user
     * @param model Modelo JSP
     * @param principal EL usuario en sesión
     * @return Url vista
     */
    @PostMapping("/restaurarContra")
    public String restaurarContra(@RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("enabled") BigDecimal enabled,
            @RequestParam("id") BigDecimal id, Model model, Principal principal) {
        //
        RequestRestaurarContrasena request = new RequestRestaurarContrasena();
        ResponseRestaurarContrasena response = new ResponseRestaurarContrasena();
        Users user = new Users();
        user.setEnabled(enabled);
        user.setIduser(id);
        user.setPassword(password);
        user.setUsername(username);
        request.setUser(user);
        response = usersServicio.restaurarPassword(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            requestA.setUsers(new Users("Sistema"));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        model.addAttribute("resp", response.getStatus());
        return "confirmoCambioClave";
    }

    /**
     * Metodo que muestra la vista de login
     *
     * @param error Cualquier exception que se pueda presentar
     * @param logout Parametro que dice si se realizó un logout
     * @param request Request del cliente
     * @param model Modelo JSP
     * @return Url vista
     */
    @RequestMapping(value = "/mostrarLogin", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpServletRequest request, Model model) {

//        error = getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION");
//        ModelAndView model = new ModelAndView();
        if (error != null) {
//            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
            error = getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION");
            model.addAttribute("error", error);

        }

        if (logout != null) {

            model.addAttribute("msg", "You've been logged out successfully.");
        }
        String error2 = "";
        if (error != null) {
            error2 = error;
        }

//        model.setViewName("loginPag");
        String[] errorYUsuario = error2.split("/");
        if ("Actualizar Contraseña".equals(errorYUsuario[0])) {
            model.addAttribute("usuario", errorYUsuario[1]);
            model.addAttribute("obligatorio", "1");
            model.addAttribute("error", errorYUsuario[0]);
        }
        return "loginPag";

    }

    /**
     * Metodo que trae las excepciones del spring security
     *
     * @param request request del cliente
     * @param key Mensaje que dice que excepción buscar
     * @return Un mensaje que dice el error que se presentó
     */
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception
                = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof CredencialesMalasException) {
            error = exception.getMessage();
        } else if (exception instanceof SessionAuthenticationException) {
            error = "El usuario ya se encuentra en sesión, solo se permite una sesión simultánea";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else if (exception instanceof CredentialsExpiredException) {
            error = "Actualizar Contraseña/" + exception.getMessage();
        } else {
            error = "Ocurrio un error desconocido, por favor contacte al administrador del sistema";
        }

        return error;
    }

//    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
//    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(false);
//        SecurityContextHolder.clearContext();
//        session = request.getSession(false);
//
//        if (session != null) {
//            session.invalidate();
//        }
//        for (Cookie cookie : request.getCookies()) {
//            cookie.setMaxAge(0);
//        }
//
//        return "logout";
//    }

    @RequestMapping(path = "/sesionExpirada", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDTO sesionExpirada() {
        
        ResponseDTO response2 = new ResponseDTO();
    
        return response2;
    }

}

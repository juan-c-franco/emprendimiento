/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.miperfil.RequestModificarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.ResponseModificarContrasena;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.UsersServicio;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Controller
public class ControladorMiPerfil {

    @Autowired
    private UsersServicio usersServicio;
    @Autowired
    private LogAuditoriaServicio logAuditoria;

    private final String modulo = "Mi Perfil";

    /**
     * Metodo que muestra la pantalla de modificacion de contraseña
     *
     * @return Url vista
     */
    @GetMapping("modificarContrasena")
    public String modificarContrasena() {

        return "modificarContrasena";
    }

    /**
     * Metodo que modifica la contraseña de un usuario
     *
     * @param password Contraseña vieja
     * @param contrasenaN Contraseña nueva
     * @param contrasenaN2 Contraseña nueva
     * @param principal El usuario en sesión
     * @param model Modelo JSP
     * @return Url vista
     */
    @PostMapping("modificarContrasena2")
    public String modificarContrasena2(@RequestParam("password") String password,
            @RequestParam("contrasenaN") String contrasenaN,
            @RequestParam("contrasenaN2") String contrasenaN2, Principal principal, Model model) {
        RequestModificarContrasena request = new RequestModificarContrasena();
        ResponseModificarContrasena response = new ResponseModificarContrasena();
        UsersDTO userDTO = new UsersDTO();
        userDTO.setUsername(principal.getName());
        userDTO.setPassword(password);
        request.setUserDTO(userDTO);
        request.setContrasenaN(contrasenaN);
        request.setContrasenaN2(contrasenaN2);
        response = usersServicio.setContrasena(request);
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
        model.addAttribute("mensajeTitulo", "Modificar Contraseña");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        return "confirmar";
    }

    @PostMapping(path = "modificarContrasenaObligado2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseModificarContrasena modificarContrasenaObligado(@RequestParam("password") String password,
            @RequestParam("contrasenaN") String contrasenaN,
            @RequestParam("contrasenaN2") String contrasenaN2,
            @RequestParam("username") String username, Model model) {
        RequestModificarContrasena request = new RequestModificarContrasena();
        ResponseModificarContrasena response = new ResponseModificarContrasena();
        UsersDTO userDTO = new UsersDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        request.setUserDTO(userDTO);
        request.setContrasenaN(contrasenaN);
        request.setContrasenaN2(contrasenaN2);
        response = usersServicio.setContrasenaObligado(request);
        if ("1".equals(response.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

          
            requestA.setUsers(new Users(username));
            requestA.setAccion(response.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("mensajeTitulo", "Modificar Contraseña");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("error", response.getDescripcion());
        return response;
    }
}

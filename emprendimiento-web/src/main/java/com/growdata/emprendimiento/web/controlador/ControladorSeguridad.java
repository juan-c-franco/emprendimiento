/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.FuncionariosYGrupoDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerGroups;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerTipoD;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerGroups;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerTipoD;
import com.growdata.emprendimiento.business.dtos.seguridad.TipodocumentoidDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupsDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario2;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.business.servicio.GroupsServicio;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.business.servicio.TipoDocumentoServicio;
import com.growdata.emprendimiento.persistence.entidad.Users;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ControladorSeguridad {

    @Autowired
    private CajasDeCompensacionServicio cajasDeCompensacionServicio;
    @Autowired
    private FuncionarioServicio funcionarioServicio;
    @Autowired
    private GroupsServicio groupsServicio;
    @Autowired
    private TipoDocumentoServicio tipoDocumentoServicio;

    @Autowired
    private LogAuditoriaServicio logAuditoria;

    private String modulo = "Seguridad";

 

    /**
     * Metodo que trae las cajas de compensacion y muestra la pantalla de
     * gestion de usuarios
     *
     * @param model Modelo JSP
     * @param mensaje3 Mensaje de una acción
     * @param mensaje2 Mensaje de una acción
     * @param status3 Status de una acción
     * @param idcajacompensacion2 El id de la caja de compensación
     * @param status2 Status de una acción
     * @param funcionariosDTO Funcionario
     * @return Url vista
     */
    @GetMapping("/gestionarCuentas")
    public String gestionarCuentas(Model model, @RequestParam(name = "mensaje3", required = false) String mensaje3,
            @RequestParam(name = "mensaje2", required = false) String mensaje2,
            @RequestParam(name = "status3", required = false) String status3,
            @RequestParam(name = "status2", required = false) String status2,
            @RequestParam(name = "funcionariosDTO", required = false) List<FuncionariosYGrupoDTO> funcionariosDTO,
            @RequestParam(name = "idcajacompensacion2", required = false) BigDecimal idcajacompensacion2) {
        RequestGestionarCuentas request = new RequestGestionarCuentas();
        ResponseGestionarCuentas response = cajasDeCompensacionServicio.getNombresCajas(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();

        List<GestionarFuncionarioDTO> funcisDTO = response.getFuncisDTO();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("funcisDTO", funcisDTO);
        model.addAttribute("mensaje3", mensaje3);
        model.addAttribute("mensaje2", mensaje2);
        model.addAttribute("status2", status2);
        model.addAttribute("status3", status3);
        model.addAttribute("funcionariosDTO", funcionariosDTO);
        model.addAttribute("idcajacompensacion2", idcajacompensacion2);
        return "gestionarCuentasUsuario";
    }

    /**
     * Metodo que trae las cajas y los funcionarios de la caja escogida
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @param atr Redireccionador de atributos
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("consultarFuncionarios")
    public String consultarFuncionarios(@RequestParam("idcajacompensacion") BigDecimal idcajacompensacion,
            RedirectAttributes atr, Model model) {
        //primero traigo las cajas de compensacion
        RequestGestionarCuentas request = new RequestGestionarCuentas();
        ResponseGestionarCuentas response = cajasDeCompensacionServicio.getNombresCajas(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();

        List<GestionarFuncionarioDTO> funcisDTO = response.getFuncisDTO();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("funcisDTO", funcisDTO);
        //traigo los funcionarios por caja
        RequestConsultarFuncionarios request2 = new RequestConsultarFuncionarios();
        ResponseConsultarFuncionarios response2 = new ResponseConsultarFuncionarios();
        request2.setIdcajacompensacion(idcajacompensacion);
        response2 = funcionarioServicio.getFuncionariosPorCaja(request2);
        List<FuncionariosYGrupoDTO> funcionariosDTO = response2.getFyg();
        String mensaje2 = response2.getDescripcion();
        String status2 = response2.getStatus();
        model.addAttribute("mensaje2", mensaje2);
        model.addAttribute("status2", status2);
        model.addAttribute("funcionariosDTO", funcionariosDTO);
        model.addAttribute("idcajacompensacion2", idcajacompensacion);

        return "gestionarCuentasUsuario";
    }

    /**
     * Metodo que trae las cajas, los roles y los tipos de documento, ademas
     * muestra la pantalla de registro de funcionario
     *
     * @param model Modelo JSP
     * @param idcajacompensacion El id de la caja de compensación
     * @return Url vista
     */
    @GetMapping("agregarFuncionario")
    public String agregarFuncionario(Model model, @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion) {
        //traigo las cajas
        RequestGestionarCuentas request = new RequestGestionarCuentas();
        ResponseGestionarCuentas response = cajasDeCompensacionServicio.getNombresCajas(request);
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        List<GestionarFuncionarioDTO> funcisDTO = response.getFuncisDTO();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);
        model.addAttribute("funcisDTO", funcisDTO);
        model.addAttribute("cajaEscogida", idcajacompensacion);
        // traigo los groups
        RequestTraerGroups request2 = new RequestTraerGroups();
        ResponseTraerGroups response2 = groupsServicio.getGroups(request2);
        List<GroupsDTO> groupsDTO = response2.getGroupsDTO();
        String statusGroups = response2.getStatus();
        String mensajeGroups = response2.getDescripcion();
        model.addAttribute("groupsDTO", groupsDTO);
        model.addAttribute("statusGroups", statusGroups);
        model.addAttribute("mensajeGroups", mensajeGroups);
        //Traigo los tipos de documento
        RequestTraerTipoD request3 = new RequestTraerTipoD();
        ResponseTraerTipoD response3 = new ResponseTraerTipoD();
        response3 = tipoDocumentoServicio.getTipoDocumento(request3);
        List<TipodocumentoidDTO> tiposDTO = response3.getTipoDTO();
        String statusTipos = response3.getStatus();
        String mensajeTipos = response3.getDescripcion();
        model.addAttribute("tiposDTO", tiposDTO);
        model.addAttribute("statusTipos", statusTipos);
        model.addAttribute("mensajeTipos", mensajeTipos);

        return "registroFuncionario";
    }

    /**
     * Metodpo que registra el nuevo funcionario
     *
     * @param primernombre Primer nombre
     * @param email Email
     * @param primerapellido Primer apellido
     * @param segundoapellido Segundo apellido
     * @param segundonombre Segundo nombre
     * @param telefono Teléfono
     * @param numerodocumento Numero de documento
     * @param idestadofuncionario EL id del estado del funcionario
     * @param id El id del tipo de funcionario
     * @param idcajacompensacion El id de la caja de compensación
     * @param idtipodocumento El id del tipo de documento
     * @param atr Redireccionador de atributos
     * @param model Modelo JSP
     * @param principal Sesion Spring Security
     * @return Url vista
     */
    @PostMapping(path = "/registrarFuncionario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseRegistrarFuncionario registrarFuncionario(@RequestParam("primernombre") String primernombre, @RequestParam("segundonombre") String segundonombre,
            @RequestParam("primerapellido") String primerapellido, @RequestParam("segundoapellido") String segundoapellido,
            @RequestParam("email") String email, @RequestParam("telefono") Long telefono, @RequestParam("numerodocumento") String numerodocumento,
            @RequestParam("idestadofuncionario") BigDecimal idestadofuncionario,
            @RequestParam("id") int id, @RequestParam("idcajacompensacion") BigDecimal idcajacompensacion,
            @RequestParam("idtipodocumento") BigDecimal idtipodocumento,
            Model model, RedirectAttributes atr, Principal principal) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setPrimerapellido(primerapellido);
        funcionarioDTO.setSegundoapellido(segundoapellido);
        funcionarioDTO.setEmail(email.toLowerCase());

        funcionarioDTO.setPrimernombre(primernombre);
        funcionarioDTO.setSegundonombre(segundonombre);

        funcionarioDTO.setNumerodocumento(numerodocumento);
        funcionarioDTO.setTelefono(telefono);

        //registro el funcionario
        RequestRegistrarFuncionario request2 = new RequestRegistrarFuncionario();
        ResponseRegistrarFuncionario response2 = new ResponseRegistrarFuncionario();
        request2.setFuncionarioDTO(funcionarioDTO);
        request2.setId(id);
        request2.setIdestadofuncionario(idestadofuncionario);
        request2.setIdtipodocumento(idtipodocumento);
        request2.setIdcajacompensacion(idcajacompensacion);

        response2 = funcionarioServicio.setFuncionario(request2);
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(response2.getId());
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }

        return response2;
    }

    /**
     * Metodo que trae los roles, tipos de documento y la informacion del
     * funcionario a modificar, ademas muestra la pantalla de modificacion de
     * funcionario
     *
     * @param idfuncionario El id del funcionario
     * @param model Modelo JSP
     * @return Url vista
     */
    @GetMapping("modificarFuncionario")
    public String modificarFuncioanrio(@RequestParam("idfuncionario") long idfuncionario, Model model) {
        // traigo los groups
        RequestTraerGroups request2 = new RequestTraerGroups();
        ResponseTraerGroups response2 = groupsServicio.getGroups(request2);
        List<GroupsDTO> groupsDTO = response2.getGroupsDTO();
        String statusGroups = response2.getStatus();
        String mensajeGroups = response2.getDescripcion();
        model.addAttribute("groupsDTO", groupsDTO);
        model.addAttribute("statusGroups", statusGroups);
        model.addAttribute("mensajeGroups", mensajeGroups);
        //Traigo los tipos de documento
        RequestTraerTipoD request3 = new RequestTraerTipoD();
        ResponseTraerTipoD response3 = new ResponseTraerTipoD();
        response3 = tipoDocumentoServicio.getTipoDocumento(request3);
        List<TipodocumentoidDTO> tiposDTO = response3.getTipoDTO();
        String statusTipos = response3.getStatus();
        String mensajeTipos = response3.getDescripcion();
        model.addAttribute("tiposDTO", tiposDTO);
        model.addAttribute("statusTipos", statusTipos);
        model.addAttribute("mensajeTipos", mensajeTipos);
        //Traigo los datos del funcionario
        RequestModificarFuncionario request = new RequestModificarFuncionario();
        ResponseModificarFuncionario response = new ResponseModificarFuncionario();
        request.setIdfuncionario(idfuncionario);
        response = funcionarioServicio.getFuncionarioPorId(request);
        FuncionarioDTO funcionarioDTO = response.getFuncionarioDTO();
        GroupMembersDTO gmDTO = response.getGroupMember();
        String mensaje = response.getDescripcion();
        String status = response.getStatus();
        model.addAttribute("gmDTO", gmDTO);
        model.addAttribute("funcionarioDTO", funcionarioDTO);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("status", status);

        return "modificarFuncionario";
    }

    /**
     * Metodo que modifica el funcionario
     *
     *
     * @param idfuncionario El id del funcionario
     * @param primernombre Primer nombre
     * @param segundonombre Segundo nombre
     * @param idestadofuncionario El id del estado del funcionario
     * @param primerapellido Primer apellido
     * @param segundoapellido Segundo apellido
     * @param principal El usuario en sesión
     *
     * @param email Email
     * @param telefono Teléfono
     * @param numerodocumento Numero de documento
     * @param id El id del tipo de funcionario
     * @param idtipodocumento El id del tipo de documento
     * @param contr Valor para saber si se restaura la contraseña o no
     * @param model Modelo JSP
     * @param atr Redireccionador de atributos
     * @return Url vista
     */
    @PostMapping(path = "/modificarFuncionario2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseModificarFuncionario2 modificarFuncionario2(@RequestParam("idfuncionario") long idfuncionario, @RequestParam("primernombre") String primernombre,
            @RequestParam("segundonombre") String segundonombre, Principal principal,
            @RequestParam("primerapellido") String primerapellido, @RequestParam("segundoapellido") String segundoapellido,
            @RequestParam("email") String email, @RequestParam("telefono") Long telefono, @RequestParam("numerodocumento") String numerodocumento,
            @RequestParam("idestadofuncionario") BigDecimal idestadofuncionario,
            @RequestParam("id") int id, @RequestParam("idtipodocumento") BigDecimal idtipodocumento,
            @RequestParam("contrasena") boolean contr, Model model, RedirectAttributes atr) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setIdfuncionario(idfuncionario);

        funcionarioDTO.setPrimerapellido(primerapellido);
        funcionarioDTO.setSegundoapellido(segundoapellido);
        funcionarioDTO.setEmail(email.toLowerCase());

        funcionarioDTO.setPrimernombre(primernombre);
        funcionarioDTO.setSegundonombre(segundonombre);
        funcionarioDTO.setNumerodocumento(numerodocumento);
        funcionarioDTO.setTelefono(telefono);
       
        //  modifico users group members y funcionario
        RequestModificarFuncionario2 request2 = new RequestModificarFuncionario2();
        ResponseModificarFuncionario2 response2 = new ResponseModificarFuncionario2();
        request2.setFuncionarioDTO(funcionarioDTO);
        request2.setId(id);
        request2.setIdestadofuncionario(idestadofuncionario);
        request2.setIdtipodocumento(idtipodocumento);
        request2.setContr(contr ? "si" : "no");
        response2 = funcionarioServicio.setFuncionarioM(request2);
        if ("1".equals(response2.getStatus())) {
            RequestLogAuditoria requestA = new RequestLogAuditoria();

            
            requestA.setUsers(new Users(principal.getName()));
            requestA.setAccion(response2.getAccion());
            requestA.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            requestA.setIdelemento(idfuncionario);
            requestA.setModulo(modulo);
            logAuditoria.registrarLog(requestA);
        }

        return response2;
    }
}

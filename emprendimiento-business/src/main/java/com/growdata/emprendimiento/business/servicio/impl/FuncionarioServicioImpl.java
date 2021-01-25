/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorIdUser;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComiteLibres;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorIdUser;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComiteLibres;
import com.growdata.emprendimiento.business.dtos.parametrizacion.UsuarioComiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.FuncionariosYGrupoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerFuncionariosPorGrupoCaja;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionariosPorGrupoCaja;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.Contrasena;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import static com.growdata.emprendimiento.business.commons.DTOToEntity.dtoFuncionarioToFuncionario;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.estadoFuncionarioToEstadoFuncionarioDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.funcionarioToFuncionarioDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.groupMembersToGroupMembersDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.PasswordEncoderGenerator;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.GroupMembersDAO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Estadofuncionario;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Groups;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class FuncionarioServicioImpl implements FuncionarioServicio {
    
    @Autowired
    private EnviarEmail enviar;
    @Autowired
    private FuncionarioDAO funcionarioDAO;
    @Autowired
    private GroupMembersDAO groupMembersDAO;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae todos los funcionarios de una caja de compensacion a
     * partir de su id
     *
     * @param request Contiene el id de la caja de compensación
     * @return Una lista con los funcionarios
     */
    @Override
    @Transactional
    public ResponseConsultarFuncionarios getFuncionariosPorCaja(RequestConsultarFuncionarios request) {
        ResponseConsultarFuncionarios response = new ResponseConsultarFuncionarios();
        
        try {
            //Traigo los funcionarios relacionados con la caja
            List<Funcionario> funcionarios = funcionarioDAO.getFuncionariosPorCaja(request.getIdcajacompensacion());
            if (funcionarios.size() > 0) {
                String username;
                
                GroupMembers gm = new GroupMembers();
                List<FuncionariosYGrupoDTO> funcionariosG = new ArrayList();

                //traigo los roles de esos funcionarios
                for (Funcionario funcionario : funcionarios) {
                    username = funcionario.getEmail();
                    FuncionariosYGrupoDTO funcG = new FuncionariosYGrupoDTO();
                    gm = groupMembersDAO.getGroupMember(username);
                    
                    funcG.setPrimerapellido(funcionario.getPrimerapellido());
                    funcG.setSegundoapellido(funcionario.getSegundoapellido());
                    
                    funcG.setPrimernombre(funcionario.getPrimernombre());
                    funcG.setSegundonombre(funcionario.getSegundonombre());
                    funcG.setIdfuncionario(funcionario.getIdfuncionario());
                    funcG.setNumerodocumento(funcionario.getNumerodocumento());
                    funcG.setEstadofuncionario(estadoFuncionarioToEstadoFuncionarioDTO(funcionario.getEstadofuncionario()));
                    funcG.setGroupName(gm.getGroups().getGroupName());
                    
                    funcionariosG.add(funcG);
                    
                }
                if (funcionariosG != null) {
                    response.setFyg(funcionariosG);
                    response.setDescripcion(Mensajes.EXITO_CARGA_GROUP_MEMBERS);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_CARGA_GROUP_MEMBERS);
                    response.setStatus("0");
                }
            } else {
                response.setDescripcion(Mensajes.ERROR_NO_HAY_FUNCIONARIOS);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        
        return response;
    }

    /**
     * Metodo que crea un funcionario
     *
     * @param request Contiene el funcionario a crear
     * @return Respuesta si se creo satisfactoriamente el funcionario o no
     */
    @Override
    @Transactional
    public ResponseRegistrarFuncionario setFuncionario(RequestRegistrarFuncionario request) {
        ResponseRegistrarFuncionario response = new ResponseRegistrarFuncionario();
        Funcionario funcionario = dtoFuncionarioToFuncionario(request.getFuncionarioDTO());
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        Contrasena contra = new Contrasena();
//        EnviarEmail enviar = new EnviarEmail();
        String pass = contra.crearPassword();
        String tempPass = encriptador.encriptar(pass);
        String asunto = "Cuenta de usuario";
        String correo = funcionario.getEmail();
        String cuerpo;
        String resp;
        Estadofuncionario estado = new Estadofuncionario();
        Tipodocumentoid tipo = new Tipodocumentoid();
        Cajacompensacion caja = new Cajacompensacion();
        Date date = new Date();
        Users user = new Users();
        user.setUsername(funcionario.getEmail());
        user.setAccountnonlocked(1);
        user.setCredentialsnonexpired(0);
        user.setPassword("{bcrypt}" + tempPass);
        user.setEnabled(request.getIdestadofuncionario());
        user.setFecharegistro(date);
        
        caja.setIdcajacompensacion(request.getIdcajacompensacion());
        tipo.setIdtipodocumento(request.getIdtipodocumento());
        estado.setIdestadofuncionario(request.getIdestadofuncionario());
        
        funcionario.setCajacompensacion(caja);
        funcionario.setEstadofuncionario(estado);
        funcionario.setTipodocumentoid(tipo);
        
        funcionario.setFecharegistro(date);
        funcionario.setUsers(user);
        funcionario.setCajacompensacion(caja);
        funcionario.setTipodocumentoid(tipo);
        
        GroupMembers gm = new GroupMembers();
        Groups g = new Groups();
        g.setId(request.getId());
        gm.setGroups(g);
        gm.setUsers(user);
        try {
            // reviso que no exista un usuario con ese correo
            Users user2 = usersDAO.getUserPorCorreo(funcionario.getEmail());
            if (user2 == null) {

                // reviso que no exista un funcionario con ese documento
                Funcionario funcionario2 = funcionarioDAO.getFuncionarioPorDocumento(funcionario.getNumerodocumento(), funcionario.getTipodocumentoid().getIdtipodocumento(), -1);
                if (funcionario2 == null) {
                    //creo el user
                    CorreosAsistencias funcionarioCreado = usersDAO.crearFuncionario(user, gm, funcionario);
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    enviar.setUsuario(correo);
                    enviar.setContrasena(pass);
                    enviar.setNombres(funcionario.getPrimernombre() + " " + (funcionario.getSegundonombre() != null ? funcionario.getSegundonombre() : ""));
                    enviar.setApellidos(funcionario.getPrimerapellido() + " " + (funcionario.getSegundoapellido() != null ? funcionario.getSegundoapellido() : ""));
                    enviar.notificarGenerica(22, correo);
                    response.setStatus("1");
                    response.setId(funcionarioCreado.getIdBeneficiario());
                    response.setDescripcion(Mensajes.EXITO_REGISTRO_FUNCIONARIO);
                    response.setAccion(Acciones.REGISTRAR_FUNCIONARIO);
                    
                } else {
                    response.setDescripcion(Mensajes.ERROR_DOCUMENTO_EXISTENTE);
                    response.setStatus("0");
                }
                
            } else {
                response.setDescripcion(Mensajes.ERROR_CORREO_EXIXTENTE);
                response.setStatus("0");
            }
            
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Servicio responsable ubicar un funcionario por idfuncionario.
     *
     * @param request Contiene el identificador del funcionario
     * @return Contiene si fue exitósa la búsqueda y el Funcionario obtenido.
     */
    @Override
    @Transactional
    public ResponseModificarFuncionario getFuncionarioPorId(RequestModificarFuncionario request) {
        ResponseModificarFuncionario response = new ResponseModificarFuncionario();
        try {
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(request.getIdfuncionario());
            if (funcionario != null) {
                GroupMembers gm = groupMembersDAO.getGroupMember(funcionario.getUsers().getUsername());
                GroupMembersDTO gmDTO = groupMembersToGroupMembersDTO(gm);
                
                FuncionarioDTO funcionarioDTO = funcionarioToFuncionarioDTO(funcionario);
                response.setFuncionarioDTO(funcionarioDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_FUNCIONARIO);
                response.setStatus("1");
                response.setGroupMember(gmDTO);
                
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
        
    }
    
    @Override
    @Transactional
    public ResponseTraerFuncionarioPorIdUser getFuncionarioPorIdUser(RequestTraerFuncionarioPorIdUser request) {
        ResponseTraerFuncionarioPorIdUser response = new ResponseTraerFuncionarioPorIdUser();
        try {
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorIdUser(request.getIdUser(), request.getIdEstado());
            if (funcionario != null) {
                
                FuncionarioDTO funcionarioDTO = EntityToDTO.funcionarioToFuncionarioDTOShort(funcionario);
                
                response.setFuncionarioDTO(funcionarioDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_FUNCIONARIO);
                response.setStatus("1");
                
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getCause().getMessage());
        }
        return response;
    }

    /**
     * Metodo que actualiza un funcionario
     *
     * @param request Contiene el funcionario con la información a actualizar
     * @return Respuesta si se actualizó satisfactoriamente el funcionario o no
     */
    @Override
    public ResponseModificarFuncionario2 setFuncionarioM(RequestModificarFuncionario2 request) {
        ResponseModificarFuncionario2 response = new ResponseModificarFuncionario2();
        Funcionario funcionario = dtoFuncionarioToFuncionario(request.getFuncionarioDTO());
        Users user = new Users();
        Estadofuncionario estado = new Estadofuncionario();
        Tipodocumentoid tipo = new Tipodocumentoid();
        Contrasena contra = new Contrasena();
//        EnviarEmail enviar = new EnviarEmail();
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        tipo.setIdtipodocumento(request.getIdtipodocumento());
        estado.setIdestadofuncionario(request.getIdestadofuncionario());
        user.setEnabled(request.getIdestadofuncionario());
        user.setUsername(funcionario.getEmail());
        String correo = funcionario.getEmail();
        funcionario.setEstadofuncionario(estado);
        funcionario.setTipodocumentoid(tipo);
        funcionario.setUsers(user);

        //evaluo si el checkbox de reestablecer contraseña esta checkeado
        if (request.getContr().equals("si")) {
            String pass = contra.crearPassword();
            String tempPass = encriptador.encriptar(pass);
            
            user.setPassword("{bcrypt}" + tempPass);
            
            try {

                // reviso que no exista un funcionario con ese documento
                Funcionario funcionario2 = funcionarioDAO.getFuncionarioPorDocumento(funcionario.getNumerodocumento(), funcionario.getTipodocumentoid().getIdtipodocumento(), funcionario.getIdfuncionario());
                if (funcionario2 == null) {
                    Users tempUser = usersDAO.getUserPorCorreo(correo);
                    user.setIduser(tempUser.getIduser());
                    user.setAccountnonlocked(tempUser.getAccountnonlocked());
                    user.setCredentialsnonexpired(0);
                    Funcionario tempFuncionario = funcionarioDAO.getFuncionarioPorId(funcionario.getIdfuncionario());
                    GroupMembers gm = new GroupMembers();
                    Groups g = new Groups();
                    g.setId(request.getId());
                    gm.setGroups(g);
                    gm.setUsers(user);
                    String resp = usersDAO.modificarUser(user, funcionario, gm);
                    enviar.setNombres(funcionario.getPrimernombre() + " " + (funcionario.getSegundonombre() != null ? funcionario.getSegundonombre() : ""));
                    enviar.setApellidos(funcionario.getPrimerapellido() + " " + (funcionario.getSegundoapellido() != null ? funcionario.getSegundoapellido() : ""));
                    enviar.setUsuario(correo);
                    enviar.setContrasena(pass);
                    enviar.notificarGenerica(23, correo);
                    response.setAccion(Acciones.MODIFICAR_FUNCIONARIO);
                    response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_FUNCIONARIO);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_DOCUMENTO_EXISTENTE);
                    response.setStatus("0");
                }
                
            } catch (Exception ex) {
                if (ex.getCause() != null) {
                    log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                } else {
                    log.writeToLogFile(ex);
                }
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
            
        } else {
            
            try {

                // reviso que no exista un funcionario con ese documento
                Funcionario funcionario2 = funcionarioDAO.getFuncionarioPorDocumento(funcionario.getNumerodocumento(), funcionario.getTipodocumentoid().getIdtipodocumento(), funcionario.getIdfuncionario());
                if (funcionario2 == null) {
                    Users tempUser = usersDAO.getUserPorCorreo(correo);
                    user.setIduser(tempUser.getIduser());
                    user.setPassword(tempUser.getPassword());
                    user.setAccountnonlocked(tempUser.getAccountnonlocked());
                    user.setCredentialsnonexpired(tempUser.getCredentialsnonexpired());
                    Funcionario tempFuncionario = funcionarioDAO.getFuncionarioPorId(funcionario.getIdfuncionario());
                    GroupMembers gm = new GroupMembers();
                    Groups g = new Groups();
                    g.setId(request.getId());
                    gm.setGroups(g);
                    gm.setUsers(user);
                    String resp = usersDAO.modificarUser(user, funcionario, gm);
                    enviar.setNombres(funcionario.getPrimernombre() + " " + (funcionario.getSegundonombre() != null ? funcionario.getSegundonombre() : ""));
                    enviar.setApellidos(funcionario.getPrimerapellido() + " " + (funcionario.getSegundoapellido() != null ? funcionario.getSegundoapellido() : ""));
                    enviar.notificarGenerica(24, correo);
                    response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_FUNCIONARIO);
                    response.setStatus("1");
                    response.setAccion(Acciones.MODIFICAR_FUNCIONARIO);
                } else {
                    response.setDescripcion(Mensajes.ERROR_DOCUMENTO_EXISTENTE);
                    response.setStatus("0");
                }
                
            } catch (Exception ex) {
                if (ex.getCause() != null) {
                    log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                } else {
                    log.writeToLogFile(ex);
                }
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        }
        return response;
    }

    /**
     * Metodo que trae los integrantes del comite libres
     *
     * @param requestUsuariosLibres Contiene el id de la caja de compensación,
     * el id del estado, y una lista de roles
     * @return Una lista de funcionarios de tipo comité
     */
    @Override
    public ResponseTraerUsuariosComiteLibres getUsuariosComiteLibres(RequestTraerUsuariosComiteLibres requestUsuariosLibres) {
        ResponseTraerUsuariosComiteLibres response = new ResponseTraerUsuariosComiteLibres();
        try {
            List funcionarios = funcionarioDAO.getUsuariosComiteLibres(requestUsuariosLibres.getLstRoles(), requestUsuariosLibres.getIdCajaCompensacion(), requestUsuariosLibres.getIdEstado());
            if (funcionarios != null) {
                Iterator itFuncionarios = funcionarios.iterator();
                List<UsuarioComiteDTO> usuariosComiteDTO = new ArrayList<>();
                while (itFuncionarios.hasNext()) {
                    Object[] funcionarioObj = (Object[]) itFuncionarios.next();
                    UsuarioComiteDTO usuarioComiteDTO = new UsuarioComiteDTO();
                    usuarioComiteDTO.setNombres(funcionarioObj[0].toString());
                    usuarioComiteDTO.setApellidos(funcionarioObj[1].toString());
                    usuarioComiteDTO.setGroupName(funcionarioObj[2].toString());
                    usuarioComiteDTO.setIdFuncionario(new BigDecimal(funcionarioObj[3].toString()));
                    usuariosComiteDTO.add(usuarioComiteDTO);
                }
                response.setUsuariosComite(usuariosComiteDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_USUARIOS_COMITE);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_USUARIOS_COMITE);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_USUARIOS_COMITE);
        }
        return response;
    }

    /**
     * Metodo que trae los integrantes del comite de una caja de compensación
     *
     * @param requestUsuarios Contiene el id de la caja de compensación, y el id
     * del estado
     * @return Una lista de funcionarios de tipo comité
     */
    @Override
    public ResponseTraerUsuariosComite getUsuariosComite(RequestTraerUsuariosComite requestUsuarios) {
        ResponseTraerUsuariosComite response = new ResponseTraerUsuariosComite();
        try {
            List funcionarios = funcionarioDAO.getUsuariosComite(requestUsuarios.getIdCajaCompensacion(), requestUsuarios.getIdEstado());
            if (funcionarios != null) {
                Iterator itFuncionarios = funcionarios.iterator();
                List<UsuarioComiteDTO> usuariosComiteDTO = new ArrayList<>();
                while (itFuncionarios.hasNext()) {
                    Object[] funcionarioObj = (Object[]) itFuncionarios.next();
                    UsuarioComiteDTO usuarioComiteDTO = new UsuarioComiteDTO();
                    usuarioComiteDTO.setNombres(funcionarioObj[0].toString());
                    usuarioComiteDTO.setApellidos(funcionarioObj[1].toString());
                    usuarioComiteDTO.setGroupName(funcionarioObj[2].toString());
                    usuarioComiteDTO.setIdFuncionario(new BigDecimal(funcionarioObj[3].toString()));
                    usuarioComiteDTO.setIdIntegranteComite(new BigDecimal(funcionarioObj[4].toString()));
                    usuariosComiteDTO.add(usuarioComiteDTO);
                }
                response.setUsuariosComite(usuariosComiteDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_INTEGRANTES_COMITE);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_INTEGRANTES_COMITE);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_INTEGRANTES_COMITE);
        }
        return response;
    }

    /**
     * Metodo que registra los integrantes del comité
     *
     * @param request Contiene una lista con los integrantes del comité a
     * regsitrar
     * @return Respuesta si se registraron los integrantes del comité
     * satisfactoriamente o no
     */
    @Override
    @Transactional
    public ResponseGuardarIntegranteComite setIntegranteComite(RequestGuardarIntegranteComite request) {
        ResponseGuardarIntegranteComite response = new ResponseGuardarIntegranteComite();
        List<Integrantescomite> integrantes = new ArrayList();
        for (IntegrantescomiteDTO integranteComiteDTO : request.getIntegrantesComiteDTO()) {
            Integrantescomite integranteComite = DTOToEntity.dtoIntegranteComiteToIntegranteComite(integranteComiteDTO);
            integrantes.add(integranteComite);
        }
        String resp;
//            if (integranteComite.getIdintegrante() != null) {
        try {
            resp = funcionarioDAO.updateIntegranteComite(integrantes);
            if (resp.equals("1")) {
                response.setAccion(Acciones.MODIFICAR_INTEGRANTE);
                response.setDescripcion(Mensajes.EXITO_UPDATE_INTEGRANTE_COMITE);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_UPDATE_INTEGRANTE_COMITE);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

//            } else {
//                resp = funcionarioDAO.setIntegranteComite(integranteComite);
//                if (resp.equals("1")) {
//                    response.setAccion(Acciones.REGISTRAR_INTEGRANTE);
//                    response.setDescripcion(Mensajes.EXITO_REGISTRO_INTEGRANTE_COMITE);
//                    response.setStatus("1");
//                } else {
//                    response.setDescripcion(Mensajes.ERROR_REGISTRO_INTEGRANTE_COMITE);
//                    response.setStatus("0");
//                }
//            }
        return response;
    }

    /**
     * Metodo que trae un comité de evaluación a partir de un id de caja de
     * compensación
     *
     * @param requestComiteEvaluacion Contiene el id de la caja de compensación
     * @return Un comité de evaluación
     */
    @Override
    public ResponseTraerComiteEvaluacionPorCaja getComiteEvaluacion(RequestTraerComiteEvaluacionPorCaja requestComiteEvaluacion) {
        ResponseTraerComiteEvaluacionPorCaja response = new ResponseTraerComiteEvaluacionPorCaja();
        try {
            Comiteevaluacion comiteEvaluacion = funcionarioDAO.getComiteEvaluacion(requestComiteEvaluacion.getIdCajaCompensacion());
            if (comiteEvaluacion != null) {
                ComiteevaluacionDTO comiteEvaluacionDTO = EntityToDTO.comiteEvaluacionToComiteEvaluacionDTO(comiteEvaluacion);
                response.setComiteEvaluacionDTO(comiteEvaluacionDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_COMITE_EVALUACION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_COMITE_EVALUACION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_COMITE_EVALUACION);
        }
        return response;
    }

    /**
     * Metodo que trae un comité de evaluación a partir de un id de comité
     *
     * @param requestComiteEvaluacion Contiene el id del comité
     * @return Un comite de evaluación
     */
    @Override
    public ResponseTraerComiteEvaluacion getComiteEvaluacion(RequestTraerComiteEvaluacion requestComiteEvaluacion) {
        ResponseTraerComiteEvaluacion response = new ResponseTraerComiteEvaluacion();
        try {
            Comiteevaluacion comiteEvaluacion = funcionarioDAO.getComiteEvaluacionPorId(requestComiteEvaluacion.getIdComite());
            if (comiteEvaluacion != null) {
                ComiteevaluacionDTO comiteEvaluacionDTO = EntityToDTO.comiteEvaluacionToComiteEvaluacionDTO(comiteEvaluacion);
                response.setComiteEvaluacionDTO(comiteEvaluacionDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_COMITE_EVALUACION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_COMITE_EVALUACION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_COMITE_EVALUACION);
        }
        return response;
    }

    /**
     * Metodo que borra un comité de evaluación a partir de su id
     *
     * @param requestEliminarIntegrantes Contiene el id del comité de evaluación
     * @return Respuesta si se borró satisfactoriamente el comité de evaluación
     * o no
     */
    @Override
    public ResponseEliminarIntegrantesComite deleteIntegrantesComite(RequestEliminarIntegrantesComite requestEliminarIntegrantes) {
        ResponseEliminarIntegrantesComite response = new ResponseEliminarIntegrantesComite();
        String resp;
        try {
            resp = funcionarioDAO.deleteIntegrantesComite(requestEliminarIntegrantes.getIdComite());
            if (resp.equals("1")) {
                response.setDescripcion(Mensajes.EXITO_DELETE_INTEGRANTES_COMITE);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_DELETE_INTEGRANTES_COMITE);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        
        return response;
    }

    /**
     * Servicio encargados de ubicar un funcionario por nombre de usuario.
     *
     * @param request Contiene el nombre de usuario del Funcionario que se desea
     * ubicar.
     * @return Respuesta si fue exitósa o no la búsqueda y el Funcionario que
     * cumple con el criterio de búsqueda.
     */
    @Override
    @Transactional
    public ResponseTraerFuncionarioPorUserName getFuncionarioPorUserName(RequestTraerFuncionarioPorUserName request) {
        ResponseTraerFuncionarioPorUserName response = new ResponseTraerFuncionarioPorUserName();
        try {
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorUserName(request.getUserName(), request.getIdEstado());
            if (funcionario != null) {
                
                FuncionarioDTO funcionarioDTO = EntityToDTO.funcionarioToFuncionarioDTO(funcionario);
                
                response.setFuncionarioDTO(funcionarioDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_FUNCIONARIO);
                response.setStatus("1");
                
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIO);
        }
        return response;
    }

    /**
     * Servicio encargado de traer todos los funcionarios de una determinada
     * caja y tipo de funcionar. Ej. Sensibilizador.
     *
     * @param grupo Grupo al que deben pertenecer los Funcionarios
     * @param caja Caja de Compensación a la que deben pertener los Funcionarios
     * @return Respuesta si fue exitósa o no la búsqueda, y Funcionarios que
     * cumplen con el criterio de búsqueda.
     */
    @Override
    public ResponseTraerFuncionarios getFuncionariosPorGrupoYCaja(BigDecimal grupo, BigDecimal caja) {
        ResponseTraerFuncionarios response = new ResponseTraerFuncionarios();
        try {
            List<Funcionario> funcionarios = funcionarioDAO.getFuncionariosPorGrupoYCaja(grupo, caja);
            List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
            
            for (Funcionario f : funcionarios) {
                funcionariosDTO.add(EntityToDTO.funcionarioToFuncionarioDTO(f));
            }
            
            response.setFuncionariosDTO(funcionariosDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_FUNCIONARIOS);
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIOS);
        }
        
        return response;
    }

    /**
     * Servicio encargado de indicar si un funcionario pertenece o no a un
     * determinado grupo.
     *
     * @param request Nombre de Usuario del Funcionario y grupo
     * @return Respuesta si fue exitósa o no la búsqueda,
     */
    @Override
    public ResponseIsFuncionarioGrupo isFuncionarioDelGrupo(RequestIsFuncionarioGrupo request) {
        ResponseIsFuncionarioGrupo response = new ResponseIsFuncionarioGrupo();
        try {
            Funcionario funcionario = funcionarioDAO.isFuncionarioDelGrupo(request.getUserName(), request.getGrupo());
            response.setFuncionarioDTO(EntityToDTO.funcionarioToFuncionarioDTO(funcionario));
            response.setDescripcion(Mensajes.EXITO_IS_FUNCIONARIO_GRUPO);
            response.setStatus("1");
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_IS_FUNCIONARIO_GRUPO);
        }
        return response;
    }

    /**
     * Metodo que trae una lista de funcionarios a partir de un id de caja de
     * compensación, y un tipo de funcionario
     *
     * @param requestFuncionarioGrupoCaja Contiene el id de la caja de
     * compensación y el tipo de funcionario
     * @return Una lista de funcionarios
     */
    @Override
    public ResponseTraerFuncionariosPorGrupoCaja getFuncionariosPorGrupoYCaja(RequestTraerFuncionariosPorGrupoCaja requestFuncionarioGrupoCaja) {
        ResponseTraerFuncionariosPorGrupoCaja response = new ResponseTraerFuncionariosPorGrupoCaja();
        try {
            List<Funcionario> funcionarios = funcionarioDAO.getFuncionariosPorGrupoYCaja(requestFuncionarioGrupoCaja.getGrupo(), requestFuncionarioGrupoCaja.getIdCajaCompensacion());
            if (funcionarios != null) {
                List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
                for (Funcionario f : funcionarios) {
                    funcionariosDTO.add(EntityToDTO.funcionarioToFuncionarioDTO(f));
                }
                response.setFuncionariosDTO(funcionariosDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_FUNCIONARIOS);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIOS);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            ex.getMessage();
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_FUNCIONARIOS);
        }
        return response;
    }
}

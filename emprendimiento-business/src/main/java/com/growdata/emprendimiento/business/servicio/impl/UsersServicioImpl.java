/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.login.RequestRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.login.ResponseRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.RequestModificarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.ResponseModificarContrasena;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuarioPorNombreUsuario;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuarioPorNombreUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.Contrasena;
import static com.growdata.emprendimiento.business.commons.DTOToEntity.dtoUserToUsers;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.PasswordEncoderGenerator;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.entidad.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.growdata.emprendimiento.business.servicio.UsersServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Groups;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class UsersServicioImpl implements UsersServicio {

    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private LoggerEmprendimiento log;

    @Autowired
    private EnviarEmail enviar;
    private Contrasena contra = new Contrasena();
//    EnviarEmail enviar = new EnviarEmail();
    private final String asunto = "Cuenta de usuario";
    private String correo;
    private String cuerpo;

    /**
     * Metodo que trae un usuario a partir de su id
     *
     * @param idUser Identificador del Usuario
     * @return Objeto usuario
     */
    @Override
    @Transactional
    public Users getUser(BigDecimal idUser) {
        try {
            return usersDAO.getUser(idUser);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }

    /**
     * Metodo que guarda las respuestas de la encuesta, crea un usuario y envia
     * notificacion a el beneficiario
     *
     * @param request Contiene el id del beneficiario, el id de la encuesta y
     * las respuestas de la encuesta
     * @return Respuesta si se guardaron las respuestas, se creó el usuario y si
     * fue notificado satisfactoriamente o no
     */
    @Override
    @Transactional
    public ResponseCrearUsuario crearUser(RequestCrearUsuario request) {
        ResponseCrearUsuario response = new ResponseCrearUsuario();
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        String resp1 = "";
        String resp;
        List<Respuestasencuesta> respuestas = new ArrayList();
        List<RespuestasValor> res = request.getRespuestasValor();
        Date date = new Date();
        Groups g = new Groups();
        GroupMembers gm = new GroupMembers();

        for (RespuestasValor r : res) {
            Respuestasencuesta re = new Respuestasencuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.setIdencuesta(request.getIdEncuesta());
            Preguntas pregunta = new Preguntas();
            pregunta.setIdpregunta(r.getIdpregunta());
            re.setEncuesta(encuesta);
            re.setFecharegistro(date);
            re.setRespuesta(r.getRespuesta());
            re.setPreguntas(pregunta);
            respuestas.add(re);
        }

        try {
            //traigo el beneficiario para tener su correo
            Beneficiario beneficiario = beneficiarioDAO.getBeneficiarioPorId(request.getIdbeneficiario());
            Users user = new Users();
            //creo contraseña aleatoria
            String pass = contra.crearPassword();
            String tempPass = encriptador.encriptar(pass);
            //seteo el nuevo user
            user.setEnabled(BigDecimal.ONE);
            user.setUsername(beneficiario.getEmail());
            user.setPassword("{bcrypt}" + tempPass);
            user.setFecharegistro(date);
            user.setAccountnonlocked(1);
            user.setCredentialsnonexpired(0);
            g.setGroupName("Beneficiario");
            g.setId(4);
            gm.setGroups(g);
            gm.setUsers(user);
            CorreosAsistencias co = new CorreosAsistencias();
            co = usersDAO.crearUser(user, respuestas, date, request.getIdEncuesta(), gm);

            //si se crea el usuario envio el email
            if ("1".equals(co.getValor())) {
                enviar.setNombres(beneficiario.getPrimernombre() + " " + (beneficiario.getSegundonombre() != null ? beneficiario.getSegundonombre() : ""));
                enviar.setApellidos(beneficiario.getPrimerapellido() + " " + (beneficiario.getSegundoapellido() != null ? beneficiario.getSegundoapellido() : ""));
                correo = co.getCorreo();
                enviar.setUsuario(correo);
                enviar.setContrasena(pass);
                enviar.notificarGenerica(18, correo);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CREAR_USUARIO);
                response.setAccion(Acciones.REGISTRAR_USUARIO);
                response.setId(co.getIdBeneficiario());
            } else {
                response.setAccion(Acciones.DILIGENCIAR_ENCUESTA);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_REGISTRO_RESPUESTAS);
            }

        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    /**
     * Metodo que crea un password aleatorio para un usuario existente
     *
     * @param request Contiene el user al que se le va a restaurar el password
     * @return Respuesta si se creó el password satisfactoriamente o no
     */
    @Override
    public ResponseRestaurarContrasena restaurarPassword(RequestRestaurarContrasena request) {
        ResponseRestaurarContrasena response = new ResponseRestaurarContrasena();
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        String nueva = contra.crearPassword();
        String tempPass = encriptador.encriptar(nueva);
        Users user = request.getUser();
//        System.out.println("esa es la clave que envia al crreo y encriopta--->" + nueva);
        try {
            user.setPassword("{bcrypt}" + tempPass);
            String resp1 = usersDAO.modificarPassword(user, nueva);

            if ("1".equals(resp1)) {

                correo = user.getUsername();

//                 String ip = InetAddress.getLocalHost().getHostAddress();
//                cuerpo = "Ha restaurado su contraseña estas son sus nuevas credenciales de acceso a la aplicación\n"
//                        + "Usuario: " + user.getUsername() + "\n"
//                        + "Contraseña: " + nueva +"\n"+
//                        new URL("http://" + ip + ":7001/emprendimiento-web/");
                enviar.setUsuario(user.getUsername());
                enviar.setContrasena(nueva);
                enviar.notificarGenerica(19, correo);
                response.setAccion(Acciones.MODIFICAR_CONTRASENA2);
                response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_CONTRASENA);
                response.setStatus("1");
                response.setId(user.getIduser().longValue());
//                enviar.enviarEmail(correo, asunto, cuerpo);

            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que trae un usuario a partir de su username
     *
     * @param requestUser Contiene el username y el estado en el que debe estar
     * el usuario
     * @return El usuario
     */
    @Override
    @Transactional
    public ResponseTraerUsuarioPorNombreUsuario getUser(RequestTraerUsuarioPorNombreUsuario requestUser) {
        ResponseTraerUsuarioPorNombreUsuario response = new ResponseTraerUsuarioPorNombreUsuario();
        try {
            Users user = usersDAO.getUser(requestUser.getUserName(), requestUser.getEnabled());
            if (user != null) {
                UsersDTO userDTO = EntityToDTO.userToUserDTO(user);
                response.setUserDTO(userDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_USUARIO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_USUARIO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_USUARIO);
        }
        return response;
    }

    /**
     * Metodo que actualiza la contraseña de un usuario
     *
     * @param request Contiene el usuario y la nueva contraseña
     * @return Respuesta si se actualizó la contraseña satisfactoriamente no
     */
    @Override
    public ResponseModificarContrasena setContrasena(RequestModificarContrasena request) {
        ResponseModificarContrasena response = new ResponseModificarContrasena();
        Users user = dtoUserToUsers(request.getUserDTO());
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        String pass = encriptador.encriptar(request.getContrasenaN());

        Users tempUser = new Users();
        if (request.getContrasenaN().equals(request.getContrasenaN2())) {
            try {

                tempUser = usersDAO.getUserPorCorreo(user.getUsername());

                response.setId(tempUser.getIduser().longValue());

                String tempClave = tempUser.getPassword();

                tempClave = tempClave.replace("{bcrypt}", "");
//                 System.out.println("HASTA ACAAA--->");
                if (BCrypt.checkpw(user.getPassword(), tempClave)) {
//                    System.out.println("Pasooo el bcrypt");
                    user.setPassword(pass);
                    tempUser.setPassword("{bcrypt}" + user.getPassword());
                    String resp = usersDAO.modificarContrasena(tempUser);
                    if (resp.equals("1")) {
                        response.setAccion(Acciones.MODIFICAR_CONTRASENA);
                        response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_CONTRASENA);
                        response.setStatus(resp);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_ACTUALIZAR_CONTRASENA);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_CONTRASENA_INCORRECTA);
                    response.setStatus("0");
                }

            } catch (Exception ex) {
//                
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        } else {

            response.setDescripcion(Mensajes.ERROR_CONTRASENAS_NO_COINCIDEN);
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Metodo que actualiza la contraseña de un usuario
     *
     * @param request Contiene el usuario y la nueva contraseña
     * @return Respuesta si se actualizó la contraseña satisfactoriamente no
     */
    @Override
    public ResponseModificarContrasena setContrasenaObligado(RequestModificarContrasena request) {
        ResponseModificarContrasena response = new ResponseModificarContrasena();
        Users user = dtoUserToUsers(request.getUserDTO());
        PasswordEncoderGenerator encriptador = new PasswordEncoderGenerator();
        String pass = encriptador.encriptar(request.getContrasenaN());

        Users tempUser = new Users();
        if (request.getContrasenaN().equals(request.getContrasenaN2())) {
            try {

                tempUser = usersDAO.getUserPorCorreo(user.getUsername());

                response.setId(tempUser.getIduser().longValue());

                String tempClave = tempUser.getPassword();

                tempClave = tempClave.replace("{bcrypt}", "");
                System.out.println("HASTA ACAAA--->");
                if (BCrypt.checkpw(user.getPassword(), tempClave)) {

                    user.setPassword(pass);
                    tempUser.setPassword("{bcrypt}" + user.getPassword());
                    String resp = usersDAO.modificarContrasenaObligado(tempUser);
                    if (resp.equals("1")) {
                        response.setAccion(Acciones.MODIFICAR_CONTRASENA);
                        response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_CONTRASENA);
                        response.setStatus(resp);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_ACTUALIZAR_CONTRASENA);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_CONTRASENA_INCORRECTA);
                    response.setStatus("0");
                }

            } catch (Exception ex) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        } else {

            response.setDescripcion(Mensajes.ERROR_CONTRASENAS_NO_COINCIDEN);
            response.setStatus("0");
        }

        return response;
    }

    @Override
    public UsersDTO getUserByUserName(String username) {
        try {
            return EntityToDTO.userToUserDTO(usersDAO.getUserByUserName(username));
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }
}

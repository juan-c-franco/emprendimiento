/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface UsersDAO {

    public Users getUser(BigDecimal idUser) throws Exception;

    public Users getUserByUserName(String username) throws Exception;

    public CorreosAsistencias crearUser(Users user,
            List<Respuestasencuesta> respuestas, Date fecha, long idEncuesta,
            GroupMembers gm) throws Exception;

    public CorreosAsistencias crearFuncionario(Users user, GroupMembers gm,
            Funcionario funcionario) throws Exception;

    public Users getUserPorCorreo(String correo) throws Exception;

    public String modificarPassword(Users user, String pass) throws Exception;

    public Users getUser(String userName, BigDecimal enabled) throws Exception;

    public String modificarUser(Users user, Funcionario funcionario, GroupMembers gm) throws Exception;

    public String modificarContrasena(Users user) throws Exception;

    public String modificarContrasenaObligado(Users user) throws Exception;
}

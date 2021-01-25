/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.login.RequestRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.login.ResponseRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.RequestModificarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.ResponseModificarContrasena;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuarioPorNombreUsuario;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuarioPorNombreUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseCrearUsuario;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;

public interface UsersServicio {

    public Users getUser(BigDecimal idUser);

    public ResponseCrearUsuario crearUser(RequestCrearUsuario request);

    public ResponseRestaurarContrasena restaurarPassword(RequestRestaurarContrasena request);

    public ResponseTraerUsuarioPorNombreUsuario getUser(RequestTraerUsuarioPorNombreUsuario requestUser);

    public ResponseModificarContrasena setContrasena(RequestModificarContrasena request);

    public UsersDTO getUserByUserName(String username);

    public ResponseModificarContrasena setContrasenaObligado(RequestModificarContrasena request);
}

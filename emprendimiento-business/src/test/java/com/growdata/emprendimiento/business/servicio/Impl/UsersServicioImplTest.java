/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.UsersServicioImpl;
import com.growdata.emprendimiento.business.dtos.login.RequestRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.login.ResponseRestaurarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.RequestModificarContrasena;
import com.growdata.emprendimiento.business.dtos.miperfil.ResponseModificarContrasena;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseCrearUsuario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.business.servicio.UsersServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class UsersServicioImplTest {

    @Mock
    private UsersDAO usersDAO;
    @Mock
    private BeneficiarioDAO beneficiarioDAO;
    @Mock
    private LoggerEmprendimiento log;

    @Mock
    private EnviarEmail enviar;

    @InjectMocks
    private UsersServicio usersServicio
            = new UsersServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo de crear user y registrar encuesta
     * PU0002-REQ-UC05
     */
    @Test
    public void testCrearUser() {
        System.out.println("Start Test: testCrearUser");
        RequestCrearUsuario request = new RequestCrearUsuario();
        List<RespuestasValor> respuestasValor = new ArrayList();
        RespuestasValor respuestas = new RespuestasValor();
        respuestas.setIdpregunta(BigDecimal.TEN);
        respuestas.setRespuesta("1");
        respuestasValor.add(respuestas);
        request.setRespuestasValor(respuestasValor);
        request.setIdEncuesta(0);
        request.setIdbeneficiario(0);
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setEmail("email");
        CorreosAsistencias co = new CorreosAsistencias();
        co.setValor("valor");
        co.setCorreo("correo");
        co.setIdBeneficiario(0);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 crear usuario exitosamente
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
            when(usersDAO.crearUser(any(Users.class), any(ArrayList.class), any(Date.class), any(Long.class), any(GroupMembers.class))).thenReturn(co);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseCrearUsuario response = usersServicio.crearUser(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("   PruebaOK #1 --> OK");
            //Prueba Error 1 enviar correo lanza exception
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
            when(usersDAO.crearUser(any(Users.class), any(ArrayList.class), any(Date.class), any(Long.class), any(GroupMembers.class))).thenReturn(co);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = usersServicio.crearUser(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("   Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al crear usuario
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
            given(usersDAO.crearUser(any(Users.class), any(ArrayList.class), any(Date.class), any(Long.class), any(GroupMembers.class))).willThrow(excep);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = usersServicio.crearUser(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("   Prueba Error #2 --> OK");
            //Prueba Error 3 el dao lanza exception al traer beneficiario
            given(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).willThrow(excep);
            when(usersDAO.crearUser(any(Users.class), any(ArrayList.class), any(Date.class), any(Long.class), any(GroupMembers.class))).thenReturn(co);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = usersServicio.crearUser(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("   Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearUser");
        }
        System.out.println("End Test: testCrearUser");
    }

    /**
     * Prueba unitaria para RestaurarPassword PU0059-REQ-UC39
     */
    @Test
    public void testRestaurarPassword() {
        System.out.println("Start Test: testRestaurarPassword");
        RequestRestaurarContrasena request = new RequestRestaurarContrasena();
        Users user = new Users();
        user.setIduser(BigDecimal.ZERO);
        user.setUsername("username");
        request.setUser(user);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 contraseña modificada exitosamente
            when(usersDAO.modificarPassword(any(Users.class), any(String.class))).thenReturn("1");
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRestaurarContrasena response = usersServicio.restaurarPassword(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar email lanza exception
            when(usersDAO.modificarPassword(any(Users.class), any(String.class))).thenReturn("1");
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = usersServicio.restaurarPassword(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al modificar contraseña
            given(usersDAO.modificarPassword(any(Users.class), any(String.class))).willThrow(excep);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = usersServicio.restaurarPassword(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRestaurarPassword");
        }
        System.out.println("End Test: testRestaurarPassword");
    }

    /**
     * Prueba unitaria para el metodo SetContrasena PU0058-REQ-UC38
     */
    @Test
    public void testSetContrasena() {
        System.out.println("Start Test: testSetContrasena");
        RequestModificarContrasena request = new RequestModificarContrasena();
        UsersDTO userDTO = new UsersDTO();
        request.setContrasenaN("contra");
        request.setContrasenaN2("contra");
        userDTO.setPassword("12345");
        userDTO.setUsername("username");
        request.setUserDTO(userDTO);
        Exception excep = new Exception("ex", new Exception("ex"));
        Users tempUser = new Users();
        tempUser.setIduser(BigDecimal.ZERO);
        tempUser.setPassword("{bcrypt}$2a$10$sh86TLpnfTLZb3A2YKWZsu/Pp5/AougW8YfGAf2HiQGS6OQi8o9OW");

        try {
            //Prueba 1 contraseña modificada exitosamente
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(tempUser);
//            when(BCrypt.checkpw(any(String.class),any(String.class))).thenReturn(true);
            when(usersDAO.modificarContrasena(any(Users.class))).thenReturn("1");
            ResponseModificarContrasena response = usersServicio.setContrasena(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 dao lanza exception al modificar contraseña
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(tempUser);
//            when(BCrypt.checkpw(any(String.class),any(String.class))).thenReturn(true);
            given(usersDAO.modificarContrasena(any(Users.class))).willThrow(excep);
            response = usersServicio.setContrasena(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 dao lanza exception al traer usuario
            given(usersDAO.getUserPorCorreo(any(String.class))).willThrow(excep);
            when(usersDAO.modificarContrasena(any(Users.class))).thenReturn("1");
            response = usersServicio.setContrasena(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetContrasena");
        }
        System.out.println("End Test: testSetContrasena");
    }

}

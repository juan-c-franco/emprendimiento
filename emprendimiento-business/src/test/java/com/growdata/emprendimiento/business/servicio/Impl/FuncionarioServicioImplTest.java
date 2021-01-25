/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.FuncionarioServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseRegistrarFuncionario;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.GroupMembersDAO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
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
import static org.hamcrest.MatcherAssert.assertThat;
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
public class FuncionarioServicioImplTest {

    @Mock
    private EnviarEmail enviar;

    @Mock
    private FuncionarioDAO funcionarioDAO;

    @Mock
    private GroupMembersDAO groupMembersDAO;

    @Mock
    private UsersDAO usersDAO;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private FuncionarioServicio funcionarioServicio
            = new FuncionarioServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo SetFuncionario PU0050-REQ-UC34
     */
    @Test
    public void testSetFuncionario() {
        System.out.println("Start test: testSetFuncionario");
        RequestRegistrarFuncionario request = new RequestRegistrarFuncionario();
        request.setId(1);
        request.setIdestadofuncionario(BigDecimal.ZERO);
        request.setIdtipodocumento(BigDecimal.ZERO);
        request.setIdcajacompensacion(BigDecimal.ZERO);
        FuncionarioDTO funcionario = new FuncionarioDTO();
        funcionario.setEmail("");
        funcionario.setNumerodocumento("1");
        request.setFuncionarioDTO(funcionario);
        CorreosAsistencias correoAsistencias = new CorreosAsistencias();
        correoAsistencias.setIdBeneficiario(1);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //PruebaOK #1 - Funcionario creado exitosamente
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(null);
            when(funcionarioDAO.getFuncionarioPorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            when(usersDAO.crearFuncionario(any(Users.class), any(GroupMembers.class), any(Funcionario.class))).thenReturn(correoAsistencias);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(any(Boolean.class));
            ResponseRegistrarFuncionario response = funcionarioServicio.setFuncionario(request);
            assertThat(response.getStatus(), is(equalTo("1")));
            assertThat(response, is(not(nullValue())));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el dao lanza una exception al crear funcionario
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(null);
            when(funcionarioDAO.getFuncionarioPorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            given(usersDAO.crearFuncionario(any(Users.class), any(GroupMembers.class), any(Funcionario.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(any(Boolean.class));
            response = funcionarioServicio.setFuncionario(request);
            assertThat(response.getStatus(), is(equalTo("0")));
            assertThat(response, is(not(nullValue())));
            System.out.println("    Prueba Error #1 --> OK");

            //Prueba error 2 el dao lanza una excepcion al traer funcionario
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(null);
            given(funcionarioDAO.getFuncionarioPorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).willThrow(excep);
            when(usersDAO.crearFuncionario(any(Users.class), any(GroupMembers.class), any(Funcionario.class))).thenReturn(correoAsistencias);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(any(Boolean.class));
            response = funcionarioServicio.setFuncionario(request);
            assertThat(response.getStatus(), is(equalTo("0")));
            assertThat(response, is(not(nullValue())));
            System.out.println("    Prueba Error #2 --> OK");

            //Prueba error 3 el dao lanza una excepcion al traer el usuario
            given(usersDAO.getUserPorCorreo(any(String.class))).willThrow(excep);
            when(funcionarioDAO.getFuncionarioPorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            when(usersDAO.crearFuncionario(any(Users.class), any(GroupMembers.class), any(Funcionario.class))).thenReturn(correoAsistencias);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(any(Boolean.class));
            response = funcionarioServicio.setFuncionario(request);
            assertThat(response.getStatus(), is(equalTo("0")));
            assertThat(response, is(not(nullValue())));
            System.out.println("    Prueba Error #3 --> OK");

            System.out.println("End Test: testSetFuncionario");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): testSetFuncionario");
        }

    }

    /**
     * Prueba unitaria para el metodo SetFuncionarioM PU0051-REQ-UC34
     */
    @Test
    public void testSetFuncionarioM() {
        System.out.println("Start test: testSetFuncionarioM");
        RequestModificarFuncionario2 request = new RequestModificarFuncionario2();
        request.setId(1);
        request.setIdtipodocumento(new BigDecimal(1));
        request.setIdestadofuncionario(new BigDecimal(1));
        FuncionarioDTO funcionario = new FuncionarioDTO();
        funcionario.setEmail("");
        funcionario.setIdfuncionario(0);
        request.setFuncionarioDTO(funcionario);
        request.setContr("");
        String resp = "";
        Users user = new Users();
        Funcionario funcionario2 = new Funcionario();
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 funcionario modificado exitosamente
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(user);
            when(funcionarioDAO.getFuncionarioPorId(any(Long.class))).thenReturn(funcionario2);
            when(usersDAO.modificarUser(any(Users.class), any(Funcionario.class), any(GroupMembers.class))).thenReturn(resp);
            ResponseModificarFuncionario2 response = funcionarioServicio.setFuncionarioM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el dao lanza una excepcion al modificar el funcionario
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(user);
            when(funcionarioDAO.getFuncionarioPorId(any(Long.class))).thenReturn(funcionario2);
            given(usersDAO.modificarUser(any(Users.class), any(Funcionario.class), any(GroupMembers.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = funcionarioServicio.setFuncionarioM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba error 2 el dao lanza una excepcion al traer el funcionario
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(user);
            given(funcionarioDAO.getFuncionarioPorId(any(Long.class))).willThrow(excep);
            when(usersDAO.modificarUser(any(Users.class), any(Funcionario.class), any(GroupMembers.class))).thenReturn(resp);
            response = funcionarioServicio.setFuncionarioM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba error 3 el dao lanza una excepcion al traer el usuario
            given(usersDAO.getUserPorCorreo(any(String.class))).willThrow(excep);
//            when(funcionarioDAO.getFuncionarioPorId(any(Long.class))).thenReturn(new Funcionario());
            when(usersDAO.modificarUser(any(Users.class), any(Funcionario.class), any(GroupMembers.class))).thenReturn(resp);
            response = funcionarioServicio.setFuncionarioM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): testSetFuncionarioM");
        }

        System.out.println("End Test: testSetFuncionarioM");
    }

    /**
     * Prueba unitaria para el metodo SetIntegranteComite PU0056-REQ-UC36
     */
    @Test
    public void testSetIntegranteComite() {
        System.out.println("Start test: testSetIntegranteComite");
        RequestGuardarIntegranteComite request = new RequestGuardarIntegranteComite();
        List<IntegrantescomiteDTO> integrantesComiteDTO = new ArrayList();
        IntegrantescomiteDTO integrante = new IntegrantescomiteDTO();
        integrante.setIdintegrantes(BigDecimal.TEN);
        integrante.setFecharegistro(new Date());
        ComiteevaluacionDTO comite = new ComiteevaluacionDTO();
        comite.setIdcomite(BigDecimal.ONE);
        comite.setNombrecomite("");
        comite.setFecharegistro(new Date());
        comite.setDescripcion("");
        integrante.setComiteevaluacion(comite);
        FuncionarioDTO funcionario = new FuncionarioDTO();
        funcionario.setEmail("");
        funcionario.setNumerodocumento("");
        funcionario.setPrimerapellido("");
        funcionario.setSegundoapellido("");
        funcionario.setPrimernombre("");
        funcionario.setSegundonombre("");
        funcionario.setTelefono(Long.MIN_VALUE);
        funcionario.setIdfuncionario(0);
        integrante.setFuncionario(funcionario);
        integrantesComiteDTO.add(integrante);
        request.setIntegrantesComiteDTO(integrantesComiteDTO);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Integrantes actualizados exitosamente
            when(funcionarioDAO.updateIntegranteComite(any(ArrayList.class))).thenReturn("1");
            ResponseGuardarIntegranteComite response = funcionarioServicio.setIntegranteComite(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 el dao lanza una excepcion al actualizar Integrantes 
            given(funcionarioDAO.updateIntegranteComite(any(ArrayList.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = funcionarioServicio.setIntegranteComite(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetIntegranteComite");

        }

        System.out.println("End Test: testSetIntegranteComite");
    }

    /**
     * Prueba unitaria para el metodo DeleteIntegrantesComite PU0057-REQ-UC36
     */
    @Test
    public void testDeleteIntegrantesComite() {
        System.out.println("Start test: testDeleteIntegrantesComite");
        RequestEliminarIntegrantesComite request = new RequestEliminarIntegrantesComite();
        request.setIdComite(BigDecimal.ONE);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 borrar integrantes exitosamente
            when(funcionarioDAO.deleteIntegrantesComite(any(BigDecimal.class))).thenReturn("1");
            ResponseEliminarIntegrantesComite response = funcionarioServicio.deleteIntegrantesComite(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 1 dao lanza excepcion al borrar integrantes 
            given(funcionarioDAO.deleteIntegrantesComite(any(BigDecimal.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = funcionarioServicio.deleteIntegrantesComite(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testDeleteIntegrantesComite");

        }

        System.out.println("End Test: testDeleteIntegrantesComite");
    }
}

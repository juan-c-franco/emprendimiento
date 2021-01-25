package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.ListaAsistenciaServicioImpl;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.AsistenciasValor;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestAsociarBeneficiariosValoracion;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.servicio.ListaAsistenciaServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.ListaAsistenciaDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Tipoencuesta;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/02/2019
 */
public class ListaAsistenciaServicioImplTest {

    @Mock
    private ListaAsistenciaDAO listaAsistenciaDAO;

    @Mock
    private BeneficiarioDAO beneficiarioDAO;

    @Mock
    private EnviarEmail enviar;

    @Mock
    private SesionesDAO sesionesDAO;

    @Mock
    private Environment env;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private ListaAsistenciaServicio listaAsistenciaServicio
            = new ListaAsistenciaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Test of getLista method, of class ListaAsistenciaServicioImpl.
//     */
//    @Test
//    public void testGetLista() {
//        System.out.println("getLista");
//        RequestTraerAsistentes request = null;
//        ListaAsistenciaServicioImpl instance = new ListaAsistenciaServicioImpl();
//        ResponseTraerAsistentes expResult = null;
//        ResponseTraerAsistentes result = instance.getLista(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registroAsistencias method, of class ListaAsistenciaServicioImpl.
//     */
//    @Test
//    public void testRegistroAsistencias() {
//        System.out.println("registroAsistencias");
//        RequestRegistroAsistencias request = null;
//        ListaAsistenciaServicioImpl instance = new ListaAsistenciaServicioImpl();
//        ResponseRegistroAsistencias expResult = null;
//        ResponseRegistroAsistencias result = instance.registroAsistencias(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListaInasistentes method, of class ListaAsistenciaServicioImpl.
//     */
//    @Test
//    public void testGetListaInasistentes() {
//        System.out.println("getListaInasistentes");
//        RequestRegistroInasistentes request = null;
//        ListaAsistenciaServicioImpl instance = new ListaAsistenciaServicioImpl();
//        ResponseRegistroInasistentes expResult = null;
//        ResponseRegistroInasistentes result = instance.getListaInasistentes(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria para el método asociarBeneficiario. PU0007-REQ-UC02
     */
    @Test
    public void testAsociarBeneficiario() {
        System.out.println("Start Test: asociarBeneficiario");
        try {
            BeneficiarioDTO beneficiario = new BeneficiarioDTO();
            beneficiario.setUsers(new Users());
            beneficiario.setPrimernombre("");
            beneficiario.setPrimerapellido("");
            beneficiario.setSegundonombre("");
            beneficiario.setSegundoapellido("");
            beneficiario.setEmail("");
            beneficiario.setTelefono(new Long(123));
            beneficiario.setFecharegistro(new Date());
            beneficiario.setIdbeneficiario(0);

            Beneficiario bene = new Beneficiario();
            bene.setPrimernombre("");
            bene.setPrimerapellido("");
            bene.setSegundonombre("");
            bene.setSegundoapellido("");
            bene.setEmail("");

            SesionesDTO sesion = new SesionesDTO();
            sesion.setDescripcion("");
            sesion.setUbicacion("");
            sesion.setIdsesion(123);
            sesion.setMaxAsistentes(123);
            sesion.setFechainicio(new Timestamp(123));
            sesion.setFechafinal(new Timestamp(123));
            ListaasistenciaDTO listaDto = new ListaasistenciaDTO();
            listaDto.setBeneficiario(beneficiario);
            listaDto.setSesiones(sesion);
            listaDto.setIdasistencia(123);
            listaDto.setRegistroasistencia('1');
            listaDto.setJustificacionInasistencia('1');

            Sesiones sesionX = new Sesiones();
            sesionX.setUbicacion("");
            sesionX.setFechainicio(new Timestamp(0));
            sesionX.setFechafinal(new Timestamp(0));

            //PruebaOK #1 - Beneficiarios asociados exitosamente
            doNothing().when(listaAsistenciaDAO).asociarBeneficiario(any(Listaasistencia.class), any(Integer.class));
            when(beneficiarioDAO.getBeneficiario(any(long.class))).thenReturn(bene);
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(sesionX);
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            ResponseAsociarBeneficiarioSesion result = listaAsistenciaServicio.asociarBeneficiario(listaDto);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - sesionesDAO lanza una Exception
            given(sesionesDAO.getSesiones(any(long.class))).willThrow(new Exception("Exception"));
            result = listaAsistenciaServicio.asociarBeneficiario(listaDto);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - beneficiarioDAO lanza una Exception
            given(beneficiarioDAO.getBeneficiario(any(long.class))).willThrow(new Exception("Exception"));
            result = listaAsistenciaServicio.asociarBeneficiario(listaDto);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - listaAsistenciaDAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(listaAsistenciaDAO).asociarBeneficiario(any(Listaasistencia.class), any(Integer.class));
            result = listaAsistenciaServicio.asociarBeneficiario(listaDto);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            System.out.println("End Test: asociarBeneficiario");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): asociarBeneficiario");
        }
    }

//    /**
//     * Test of registroAsistenciasV method, of class ListaAsistenciaServicioImpl.
//     */
//    @Test
//    public void testRegistroAsistenciasV() {
//        System.out.println("registroAsistenciasV");
//        RequestRegistroAsistencias request = null;
//        ListaAsistenciaServicioImpl instance = new ListaAsistenciaServicioImpl();
//        ResponseRegistroAsistencias expResult = null;
//        ResponseRegistroAsistencias result = instance.registroAsistenciasV(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria para el método asociarBeneficiarioValoracion.
     * PU0017-REQ-UC07
     */
    @Test
    public void testAsociarBeneficiarioValoracion() {
        System.out.println("Start Test: asociarBeneficiarioValoracion");
        try {
            RequestAsociarBeneficiariosValoracion request = new RequestAsociarBeneficiariosValoracion();
            request.setIdSesion(123);
            request.setBeneficiarios(new ArrayList<>());

            //PruebaOK #1 - Beneficiarios asociados exitosamente
            when(listaAsistenciaDAO.asociarBeneficiarioValoracion(any(long.class), any(ArrayList.class), any(int.class))).thenReturn(new ArrayList<>());
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            ResponseAsociarBeneficiarioSesion result = listaAsistenciaServicio.asociarBeneficiarioValoracion(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una PersistenceException
            given(listaAsistenciaDAO.asociarBeneficiarioValoracion(any(long.class), any(ArrayList.class), any(int.class))).willThrow(new PersistenceException("email@growdata.com.co", new Throwable("EMAIL INVALIDO")));
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = listaAsistenciaServicio.asociarBeneficiarioValoracion(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(listaAsistenciaDAO.asociarBeneficiarioValoracion(any(long.class), any(ArrayList.class), any(int.class))).willThrow(new Exception("Exception"));
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = listaAsistenciaServicio.asociarBeneficiarioValoracion(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");
            System.out.println("End Test: asociarBeneficiarioValoracion");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): asociarBeneficiarioValoracion");
        }
    }

    /**
     * Prueba unitaria para el método asociarBeneficiarioEvaluacionSeguimiento.
     * PU0035-REQ-UC22
     */
    @Test
    public void testAsociarBeneficiarioEvaluacionSeguimiento() {
        System.out.println("Start Test: asociarBeneficiarioEvaluacionSeguimiento");
        try {
            RequestAsociarBeneficiariosValoracion request = new RequestAsociarBeneficiariosValoracion();
            request.setIdSesion(123);
            request.setBeneficiarios(new ArrayList<>());

            //PruebaOK #1 - Beneficiarios asociados exitosamente
            when(listaAsistenciaDAO.asociarBeneficiarioEvaluacionSeguimiento(any(long.class), any(ArrayList.class), any(int.class), any(int.class))).thenReturn(new ArrayList<>());
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            ResponseAsociarBeneficiarioSesion result = listaAsistenciaServicio.asociarBeneficiarioEvaluacionSeguimiento(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una PersistenceException
            given(listaAsistenciaDAO.asociarBeneficiarioEvaluacionSeguimiento(any(long.class), any(ArrayList.class), any(int.class), any(int.class))).willThrow(new PersistenceException("email@growdata.com.co", new Throwable("EMAIL INVALIDO")));
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = listaAsistenciaServicio.asociarBeneficiarioEvaluacionSeguimiento(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(listaAsistenciaDAO.asociarBeneficiarioEvaluacionSeguimiento(any(long.class), any(ArrayList.class), any(int.class), any(int.class))).willThrow(new Exception("Exception"));
            when(sesionesDAO.getSesiones(any(long.class))).thenReturn(new Sesiones());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(enviar.notificarGenerica(any(long.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = listaAsistenciaServicio.asociarBeneficiarioEvaluacionSeguimiento(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");
            System.out.println("End Test: asociarBeneficiarioEvaluacionSeguimiento");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): asociarBeneficiarioEvaluacionSeguimiento");
        }
    }

    /**
     * Prueba Unitaria para el metodo de registrar asistencias PU0001-REQ-UC04
     */
    @Test
    public void testRegistroAsistencias() {
        System.out.println("Start Test: testRegistroAsistencias");
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        List<AsistenciasValor> asistencias = new ArrayList();
        request.setIdfuncionario(1);
        request.setIdsesion(1);
        AsistenciasValor a = new AsistenciasValor();
        a.setIdasistencia(0);
        a.setValor('1');
        asistencias.add(a);
        request.setAsistencias(asistencias);
        List<CorreosAsistencias> correos = new ArrayList();
        CorreosAsistencias c = new CorreosAsistencias();
        c.setIdBeneficiario(0);
        c.setIdEncuesta(0);
        c.setCorreo("correo");
        c.setValor("Si");
        correos.add(c);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Asistencias registradas exitosamente
            when(env.getProperty(any(String.class))).thenReturn("1");
            when(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).thenReturn(correos);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRegistroAsistencias response = listaAsistenciaServicio.registroAsistencias(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar correo lanza exception
            when(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).thenReturn(correos);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = listaAsistenciaServicio.registroAsistencias(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al registrar asistencias
            given(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = listaAsistenciaServicio.registroAsistencias(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistroAsistencias");
        }

        System.out.println("End Test: testRegistroAsistencias");
    }

    /**
     * Prueba Unitaria para el metodo de registrar asistencias de valoracion
     * PU0003-REQ-UC09
     */
    @Test
    public void testRegistroAsistenciasV() {
        System.out.println("Start Test: testRegistroAsistenciasV");
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        List<AsistenciasValor> asistencias = new ArrayList();
        request.setIdfuncionario(1);
        request.setIdsesion(1);
        AsistenciasValor a = new AsistenciasValor();
        a.setIdasistencia(0);
        a.setValor('1');
        asistencias.add(a);
        request.setAsistencias(asistencias);
        List<CorreosAsistencias> correos = new ArrayList();
        CorreosAsistencias c = new CorreosAsistencias();
        c.setIdBeneficiario(0);
        c.setIdEncuesta(0);
        c.setCorreo("correo");
        c.setValor("Si");
        correos.add(c);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Asistencias registradas exitosamente
            when(env.getProperty(any(String.class))).thenReturn("1");
            when(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).thenReturn(correos);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRegistroAsistencias response = listaAsistenciaServicio.registroAsistenciasV(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar correo lanza exception
            when(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).thenReturn(correos);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = listaAsistenciaServicio.registroAsistenciasV(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al registrar asistencias
            given(listaAsistenciaDAO.registroAsistencias(any(ArrayList.class), any(Integer.class), any(Long.class), any(Tipoencuesta.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = listaAsistenciaServicio.registroAsistenciasV(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistroAsistenciasV");
        }

        System.out.println("End Test: testRegistroAsistenciasV");
    }

    /**
     * Prueba Unitaria para el metodo RegistroAsistenciasE PU0039-REQ-UC22
     */
    @Test
    public void testRegistroAsistenciasE() {
        System.out.println("Start Test: testRegistroAsistenciasE");
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        List<AsistenciasValor> asistencias = new ArrayList();
        request.setIdfuncionario(1);
        request.setIdsesion(1);
        AsistenciasValor a = new AsistenciasValor();
        a.setIdasistencia(0);
        a.setValor('1');
        asistencias.add(a);
        request.setAsistencias(asistencias);
        List<CorreosAsistencias> correos = new ArrayList();
        CorreosAsistencias c = new CorreosAsistencias();
        c.setIdBeneficiario(0);
        c.setIdEncuesta(0);
        c.setCorreo("correo");
        c.setValor("Si");
        correos.add(c);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Asistencias registradas exitosamente
            when(env.getProperty(any(String.class))).thenReturn("1");
            when(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).thenReturn(correos);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRegistroAsistencias response = listaAsistenciaServicio.registroAsistenciasE(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar correo lanza exception
            when(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).thenReturn(correos);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = listaAsistenciaServicio.registroAsistenciasE(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al registrar asistencias
            given(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = listaAsistenciaServicio.registroAsistenciasE(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistroAsistenciasE");
        }

        System.out.println("End Test: testRegistroAsistenciasE");
    }

    /**
     * Prueba Unitaria para el metodo RegistroAsistenciasS PU0043-REQ-UC29
     */
    @Test
    public void testRegistroAsistenciasS() {
        System.out.println("Start Test: testRegistroAsistenciasS");
        RequestRegistroAsistencias request = new RequestRegistroAsistencias();
        List<AsistenciasValor> asistencias = new ArrayList();
        request.setIdfuncionario(1);
        request.setIdsesion(1);
        AsistenciasValor a = new AsistenciasValor();
        a.setIdasistencia(0);
        a.setValor('1');
        asistencias.add(a);
        request.setAsistencias(asistencias);
        List<CorreosAsistencias> correos = new ArrayList();
        CorreosAsistencias c = new CorreosAsistencias();
        c.setIdBeneficiario(0);
        c.setIdEncuesta(0);
        c.setCorreo("correo");
        c.setValor("Si");
        correos.add(c);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Asistencias registradas exitosamente
            when(env.getProperty(any(String.class))).thenReturn("1");
            when(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).thenReturn(correos);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRegistroAsistencias response = listaAsistenciaServicio.registroAsistenciasS(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar correo lanza exception
            when(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).thenReturn(correos);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            response = listaAsistenciaServicio.registroAsistenciasS(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza exception al registrar asistencias
            given(listaAsistenciaDAO.registroAsistenciasE(any(ArrayList.class), any(Integer.class), any(Long.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = listaAsistenciaServicio.registroAsistenciasS(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistroAsistenciasS");
        }

        System.out.println("End Test: testRegistroAsistenciasS");
    }
}

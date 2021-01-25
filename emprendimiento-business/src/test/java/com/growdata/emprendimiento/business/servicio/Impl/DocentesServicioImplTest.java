/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.DocentesServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestDocente;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.DocentesServicio;
import com.growdata.emprendimiento.persistence.DAO.DocentesDAO;
import com.growdata.emprendimiento.persistence.entidad.Docentes;
import com.growdata.emprendimiento.persistence.entidad.Estadodocente;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import java.math.BigDecimal;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class DocentesServicioImplTest {

    @Mock
    private DocentesDAO docentesDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private DocentesServicio docentesServicio
            = new DocentesServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo crearDocente PU0078-REQ-UC45
     */
    @Test
    public void crearDocenteTest() {
        System.out.println("Start test: testCrearDocente");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestDocente request = new RequestDocente();
        request.setPrimernombre("");
        request.setSegundonombre("");
        request.setPrimerapellido("");
        request.setSegundoapellido("");
        request.setEmail("");
        request.setTelefono(1);
        Tipodocumentoid tipoId = new Tipodocumentoid();
        tipoId.setIdtipodocumento(new BigDecimal(1));
        request.setTipodocumentoid(tipoId);
        request.setNumerodocumento("");
        Estadodocente estadoDocente = new Estadodocente();
        estadoDocente.setIdestadodocente(1);
        request.setEstadoDocente(estadoDocente);
        try {
            //Prueba 1 docente creado exitosamente
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.crearDocente(any(Docentes.class))).thenReturn(new Long(1));
            ResponseDTO response = docentesServicio.crearDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el email del docente existe
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(new Docentes());
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.crearDocente(any(Docentes.class))).thenReturn(new Long(1));
            response = docentesServicio.crearDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 el documento del docente existe
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(new Docentes());
            when(docentesDAO.crearDocente(any(Docentes.class))).thenReturn(new Long(1));
            response = docentesServicio.crearDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
            //Prueba error 3 lanza una exception
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            given(docentesDAO.crearDocente(any(Docentes.class))).willThrow(excep);
            response = docentesServicio.crearDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearDocente");
        }
        System.out.println("End Test: testCrearDocente");
    }

    /**
     * Prueba unitaria para el metodo modificarDocente PU0079-REQ-UC45
     */
    @Test
    public void modificarDocenteTest() {
        System.out.println("Start test: testModificarDocente");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestDocente request = new RequestDocente();
        request.setPrimernombre("");
        request.setSegundonombre("");
        request.setPrimerapellido("");
        request.setSegundoapellido("");
        request.setEmail("");
        request.setTelefono(1);
        Tipodocumentoid tipoId = new Tipodocumentoid();
        tipoId.setIdtipodocumento(new BigDecimal(1));
        request.setTipodocumentoid(tipoId);
        request.setNumerodocumento("");
        Estadodocente estadoDocente = new Estadodocente();
        estadoDocente.setIdestadodocente(1);
        request.setEstadoDocente(estadoDocente);
        try {
            //Prueba 1 docente creado exitosamente
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            doNothing().when(docentesDAO).modificarDocente(any(Docentes.class));
            ResponseDTO response = docentesServicio.modificarDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el email del docente existe
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(new Docentes());
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            doNothing().when(docentesDAO).modificarDocente(any(Docentes.class));
            response = docentesServicio.modificarDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 el documento del docente existe
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(new Docentes());
            doNothing().when(docentesDAO).modificarDocente(any(Docentes.class));
            response = docentesServicio.modificarDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
            //Prueba error 3 lanza una exception
            when(docentesDAO.traerDocentePorEmail(any(String.class), any(Long.class))).thenReturn(null);
            when(docentesDAO.traerDocentePorDocumento(any(String.class), any(BigDecimal.class), any(Long.class))).thenReturn(null);
            Mockito.doThrow(excep).when(docentesDAO).modificarDocente(any(Docentes.class));
            response = docentesServicio.modificarDocente(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testModificarDocente");
        }
        System.out.println("End Test: testModificarDocente");
    }
}

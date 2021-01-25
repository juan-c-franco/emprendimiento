/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.CapacitacionProgramaServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCapacitacion;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.CapacitacionProgramaServicio;
import com.growdata.emprendimiento.persistence.DAO.CapacitacionProgramaDAO;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import java.util.Date;
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
public class CapacitacionProgramaServicioImplTest {

    @Mock
    private CapacitacionProgramaDAO capacitacionProgramaDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private CapacitacionProgramaServicio capacitacionProgramaServicio
            = new CapacitacionProgramaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo crearCapacitacion PU0072-REQ-UC42
     */
    @Test
    public void crearCapacitacionTest() {
        System.out.println("Start test: testCrearCapacitacion");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestCapacitacion request = new RequestCapacitacion();
        request.setCategoria(new Categoria());
        request.setEstadoCapacitacionPrograma(new Estadocapacitacionprograma());
        request.setFecharegistro(new Date());
        request.setIdoferenteinstitucion(2);
        request.setNombrecapacitacionprograma("");
        try {
            //Prueba 1 capacitacion creada exitosamente
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(null);
            when(capacitacionProgramaDAO.crearCapacitacion(any(Capacitacionprograma.class))).thenReturn(new Long(1));
            ResponseDTO response = capacitacionProgramaServicio.crearCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 la capacitacion existe
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(new Capacitacionprograma());
            when(capacitacionProgramaDAO.crearCapacitacion(any(Capacitacionprograma.class))).thenReturn(new Long(1));
            response = capacitacionProgramaServicio.crearCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(null);
            given(capacitacionProgramaDAO.crearCapacitacion(any(Capacitacionprograma.class))).willThrow(excep);
            response = capacitacionProgramaServicio.crearCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearCapacitacion");
        }
        System.out.println("End Test: testCrearCapacitacion");
    }
    
    /**
     * Prueba unitaria para el metodo modificarCapacitacion PU0073-REQ-UC42
     */
    @Test
    public void modificarCapacitacionTest() {
        System.out.println("Start test: testModificarCapacitacion");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestCapacitacion request = new RequestCapacitacion();
        request.setCategoria(new Categoria());
        request.setEstadoCapacitacionPrograma(new Estadocapacitacionprograma());
        request.setFecharegistro(new Date());
        request.setIdoferenteinstitucion(2);
        request.setNombrecapacitacionprograma("");
        try {
            //Prueba 1 capacitacion modificada exitosamente
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(null);
            doNothing().when(capacitacionProgramaDAO).modificarCapacitacion(any(Capacitacionprograma.class));
            ResponseDTO response = capacitacionProgramaServicio.modificarCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 la capacitacion existe
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(new Capacitacionprograma());
            doNothing().when(capacitacionProgramaDAO).modificarCapacitacion(any(Capacitacionprograma.class));
            response = capacitacionProgramaServicio.modificarCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(capacitacionProgramaDAO.traerCapacitacionporNombre(any(String.class),any(Long.class))).thenReturn(null);
            Mockito.doThrow(excep).when(capacitacionProgramaDAO).modificarCapacitacion(any(Capacitacionprograma.class));
            response = capacitacionProgramaServicio.modificarCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testModificarCapacitacion");
        }
        System.out.println("End Test: testModificarCapacitacion");
    }
}

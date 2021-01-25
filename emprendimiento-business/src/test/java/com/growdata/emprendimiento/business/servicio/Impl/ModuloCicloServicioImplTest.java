/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.ModuloCicloServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModuloCiclo;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.ModuloCicloServicio;
import com.growdata.emprendimiento.persistence.DAO.ModuloCicloDAO;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
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
public class ModuloCicloServicioImplTest {

    @Mock
    private ModuloCicloDAO moduloCicloDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private ModuloCicloServicio moduloCicloServicio
            = new ModuloCicloServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo crearModulo PU0074-REQ-UC43
     */
    @Test
    public void crearModuloTest() {
        System.out.println("Start test: testCrearModulo");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestModuloCiclo request = new RequestModuloCiclo();
        request.setIntensidadhoraria(new Short("1"));
        request.setNombremodulociclo("");
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setIdcapacitacionprograma(1);
        request.setCapacitacionPrograma(capacitacion);
        try {
            //Prueba 1 categoria creada exitosamente
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(null);
            when(moduloCicloDAO.crearModulo(any(Modulociclo.class))).thenReturn(new Long(1));
            ResponseDTO response = moduloCicloServicio.crearModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el modulo existe
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(new Modulociclo());
            when(moduloCicloDAO.crearModulo(any(Modulociclo.class))).thenReturn(new Long(1));
            response = moduloCicloServicio.crearModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(null);
            given(moduloCicloDAO.crearModulo(any(Modulociclo.class))).willThrow(excep);
            response = moduloCicloServicio.crearModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearModulo");
        }
        System.out.println("End Test: testCrearModulo");
    }

    /**
     * Prueba unitaria para el metodo modificarModulo
     */
    @Test
    public void modificarCategoriaTest() {
        System.out.println("Start test: testModificarModulo");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestModuloCiclo request = new RequestModuloCiclo();
        request.setIntensidadhoraria(new Short("1"));
        request.setNombremodulociclo("");
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setIdcapacitacionprograma(1);
        request.setCapacitacionPrograma(capacitacion);
        try {
            //Prueba 1 modulo creado exitosamente
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(null);
            doNothing().when(moduloCicloDAO).modificarModulo(any(Modulociclo.class));
            ResponseDTO response = moduloCicloServicio.modificarModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 el modulo existe
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(new Modulociclo());
            doNothing().when(moduloCicloDAO).modificarModulo(any(Modulociclo.class));
            response = moduloCicloServicio.modificarModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(moduloCicloDAO.traerModuloporNombre(any(String.class), any(Long.class), any(Long.class))).thenReturn(null);
            Mockito.doThrow(excep).when(moduloCicloDAO).modificarModulo(any(Modulociclo.class));
            response = moduloCicloServicio.modificarModulo(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testModificarModulo");
        }
        System.out.println("End Test: testModificarModulo");
    }
}

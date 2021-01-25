/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.EntidadesFinancierasServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.EntidadesFinancierasServicio;
import com.growdata.emprendimiento.persistence.DAO.EntidadesFinancierasDAO;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
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
public class EntidadesFinancierasServicioImplTest {

    @Mock
    private EntidadesFinancierasDAO entidadesFinancierasDAO;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private EntidadesFinancierasServicio entidadesFinancierasServicio
            = new EntidadesFinancierasServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo SetEntidadFinanciera PU0046-REQ-UC32
     */
    @Test
    public void testSetEntidadFinanciera() {
        System.out.println("Start test: testSetEntidadFinanciera");
        RequestRegistrarEntidadFinanciera request = new RequestRegistrarEntidadFinanciera();
        EntidadesfinancierasDTO entidad = new EntidadesfinancierasDTO();
        entidad.setDescripcion("descripcion");
        entidad.setEstado(Character.MIN_VALUE);
        entidad.setNombreentidad("entidad");
        entidad.setIdentidadesfinanciera(BigDecimal.TEN);
        request.setEntidadesfinancierasDTO(entidad);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 entidad registrada exitosamente
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombre(any(String.class))).thenReturn(null);
            when(entidadesFinancierasDAO.setEntidadFinanciera(any(Entidadesfinancieras.class))).thenReturn(new BigDecimal(1));
            ResponseRegistrarEntidadFinanciera response = entidadesFinancierasServicio.setEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 2 al buscar la entidad devuelve una entidad 
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombre(any(String.class))).thenReturn(new Entidadesfinancieras());
            when(entidadesFinancierasDAO.setEntidadFinanciera(any(Entidadesfinancieras.class))).thenReturn(new BigDecimal(1));
            response = entidadesFinancierasServicio.setEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaOK #2 --> OK");
            //Prueba Error 1 al registrar la entidad el dao lanza excepcion
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombre(any(String.class))).thenReturn(null);
            given(entidadesFinancierasDAO.setEntidadFinanciera(any(Entidadesfinancieras.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = entidadesFinancierasServicio.setEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba ERROR #1 --> OK");
            //Prueba Error 2 al buscar la entidad el dao lanza excepcion
            given(entidadesFinancierasDAO.getEntidadFinancieraPorNombre(any(String.class))).willThrow(excep);
            response = entidadesFinancierasServicio.setEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba ERROR #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetEntidadFinanciera");
        }
        System.out.println("End Test: testSetEntidadFinanciera");
    }

    /**
     * Prueba Unitaria para el metodo SetEntidadFinancieraM PU0047-REQ-UC32
     */
    @Test
    public void testSetEntidadFinancieraM() {
        System.out.println("Start test: testSetEntidadFinancieraM");
        RequestRegistrarEntidadFinanciera request = new RequestRegistrarEntidadFinanciera();
        EntidadesfinancierasDTO entidad = new EntidadesfinancierasDTO();
        entidad.setDescripcion("descripcion");
        entidad.setEstado(Character.MIN_VALUE);
        entidad.setNombreentidad("entidad");
        entidad.setIdentidadesfinanciera(BigDecimal.TEN);
        request.setEntidadesfinancierasDTO(entidad);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 entidad actualizada exitosamente
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(null);
            when(entidadesFinancierasDAO.setEntidadFinancieraM(any(Entidadesfinancieras.class))).thenReturn("1");
            ResponseModificarEntidadFinanciera2 response = entidadesFinancierasServicio.setEntidadFinancieraM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 2 al buscar la entidad devuelve una entidad 
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(new Entidadesfinancieras());
            when(entidadesFinancierasDAO.setEntidadFinancieraM(any(Entidadesfinancieras.class))).thenReturn("1");
            response = entidadesFinancierasServicio.setEntidadFinancieraM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaOK #2 --> OK");
            //Prueba Error 1 al actualizar la entidad el dao lanza excepcion
            when(entidadesFinancierasDAO.getEntidadFinancieraPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(null);
            given(entidadesFinancierasDAO.setEntidadFinancieraM(any(Entidadesfinancieras.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = entidadesFinancierasServicio.setEntidadFinancieraM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba ERROR #1 --> OK");
            //Prueba Error 2 al buscar la entidad el dao lanza excepcion
            given(entidadesFinancierasDAO.getEntidadFinancieraPorNombreM(any(String.class), any(BigDecimal.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = entidadesFinancierasServicio.setEntidadFinancieraM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba ERROR #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetEntidadFinancieraM");
        }
        System.out.println("End Test: testSetEntidadFinancieraM");
    }

    /**
     * Preuab unitaria para le metodo BorrarEntidad
     */
    @Test
    public void testBorrarEntidad() {
        System.out.println("Start Test: testBorrarEntidad");
        RequestBorrarEntidadFinanciera request = new RequestBorrarEntidadFinanciera();
        request.setIdentidadesfinanciera(BigDecimal.TEN);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 entidad borrada exitosamente
            doNothing().when(entidadesFinancierasDAO).borrarEntidadFinanciera(any(BigDecimal.class));
            ResponseRegistrarEntidadFinanciera response = entidadesFinancierasServicio.borrarEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");

            //Prueba Error 1 dao lanza excepcion al borrar entidad
            Mockito.doThrow(excep).when(entidadesFinancierasDAO).borrarEntidadFinanciera(any(BigDecimal.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = entidadesFinancierasServicio.borrarEntidadFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaOK #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (ERRORES): testBorrarEntidad");
        }
        System.out.println("End Test: testBorrarEntidad");

    }
}

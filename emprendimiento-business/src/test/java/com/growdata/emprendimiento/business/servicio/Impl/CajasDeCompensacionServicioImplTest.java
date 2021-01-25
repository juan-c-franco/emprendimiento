/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.CajasDeCompensacionServicioImpl;
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarCaja;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.persistence.DAO.CajasDeCompensacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import java.math.BigDecimal;
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
public class CajasDeCompensacionServicioImplTest {

    @Mock
    private CajasDeCompensacionDAO cajasDeCompensacionDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private CajasDeCompensacionServicio cajasDeCompensacionServicio
            = new CajasDeCompensacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo SetCajaCompensacion PU0048-REQ-UC33
     */
    @Test
    public void testSetCajaCompensacion() {
        System.out.println("Start test: testSetCajaCompensacion");
        RequestRegistrarCaja request = new RequestRegistrarCaja();
        CajacompensacionDTO cajaDTO = new CajacompensacionDTO();
        cajaDTO.setNombrecajacompensacion("caja");
        cajaDTO.setCodigoccf("codigo");
        cajaDTO.setFecharegistro(new Date());
        cajaDTO.setIdcajacompensacion(BigDecimal.ZERO);
        cajaDTO.setDepartamento("");
        EstadocajacompensacionDTO estado = new EstadocajacompensacionDTO();
        estado.setIdestadocajacompensacion(BigDecimal.TEN);
        cajaDTO.setEstadocajacompensacion(estado);
        request.setCajaDTO(cajaDTO);
        Cajacompensacion caja = new Cajacompensacion();
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Pruenba 1 caja creada exitosamente
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombre(any(String.class))).thenReturn(null);
            when(cajasDeCompensacionDAO.setCajaCompensacion(any(Cajacompensacion.class))).thenReturn(new BigDecimal(1));
            ResponseRegistrarCaja response = cajasDeCompensacionServicio.setCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Pruenba 2 caja traida exitosamente
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombre(any(String.class))).thenReturn(caja);
            when(cajasDeCompensacionDAO.setCajaCompensacion(any(Cajacompensacion.class))).thenReturn(new BigDecimal(1));
            response = cajasDeCompensacionServicio.setCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaOK #2 --> OK");
            //Pruenba Error 1 el dao lanza una excepcion al crear caja
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombre(any(String.class))).thenReturn(null);
            given(cajasDeCompensacionDAO.setCajaCompensacion(any(Cajacompensacion.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = cajasDeCompensacionServicio.setCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Pruenba Error 2 el dao lanza una excepcion al buscar caja por nombre
            given(cajasDeCompensacionDAO.getCajaCompensacionPorNombre(any(String.class))).willThrow(excep);
            when(cajasDeCompensacionDAO.setCajaCompensacion(any(Cajacompensacion.class))).thenReturn(new BigDecimal(1));
            response = cajasDeCompensacionServicio.setCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");

        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetCajaCompensacion");
        }
        System.out.println("End Test: testSetCajaCompensacion");
    }

    /**
     * Prueba Unitaria para el metodo SetCajaCompensacionM PU0049-REQ-UC33
     */
    @Test
    public void testSetCajaCompensacionM() {
        System.out.println("Start test: testSetCajaCompensacionM");
        RequestModificarCaja2 request = new RequestModificarCaja2();
        CajacompensacionDTO cajaDTO = new CajacompensacionDTO();
        cajaDTO.setNombrecajacompensacion("caja");
        cajaDTO.setCodigoccf("codigo");
        cajaDTO.setFecharegistro(new Date());
        cajaDTO.setIdcajacompensacion(BigDecimal.ZERO);
        cajaDTO.setDepartamento("");
        EstadocajacompensacionDTO estado = new EstadocajacompensacionDTO();
        estado.setIdestadocajacompensacion(BigDecimal.TEN);
        cajaDTO.setEstadocajacompensacion(estado);
        request.setCajaDTO(cajaDTO);
        Cajacompensacion caja = new Cajacompensacion();
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Pruenba 1 caja creada exitosamente
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(null);
            when(cajasDeCompensacionDAO.setCajaCompensacionM(any(Cajacompensacion.class))).thenReturn("1");
            ResponseModificarCaja2 response = cajasDeCompensacionServicio.setCajaCompensacionM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Pruenba 2 caja traida exitosamente
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(caja);
//            when(cajasDeCompensacionDAO.setCajaCompensacionM(any(Cajacompensacion.class))).thenReturn("1");
            response = cajasDeCompensacionServicio.setCajaCompensacionM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaOK #2 --> OK");
            //Pruenba Error 1 el dao lanza una excepcion al crear caja
            when(cajasDeCompensacionDAO.getCajaCompensacionPorNombreM(any(String.class), any(BigDecimal.class))).thenReturn(null);
            given(cajasDeCompensacionDAO.setCajaCompensacionM(any(Cajacompensacion.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = cajasDeCompensacionServicio.setCajaCompensacionM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Pruenba Error 2 el dao lanza una excepcion al buscar caja por nombre
            given(cajasDeCompensacionDAO.getCajaCompensacionPorNombreM(any(String.class), any(BigDecimal.class))).willThrow(excep);
//            when(cajasDeCompensacionDAO.setCajaCompensacionM(any(Cajacompensacion.class))).thenReturn(new BigDecimal(1));
            response = cajasDeCompensacionServicio.setCajaCompensacionM(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");

        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetCajaCompensacionM");
        }
        System.out.println("End Test: testSetCajaCompensacionM");
    }

    /**
     * Prueba unitaria para el metodo BorrarCajaCompensacion
     */
    @Test
    public void testBorrarCajaCompensacion() {
        System.out.println("Start test: testBorrarCajaCompensacion");
        RequestBorrarCajaCompensacion request = new RequestBorrarCajaCompensacion();
        request.setIdcajacompensacion(BigDecimal.ZERO);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 se borra la caja exitosamente
            doNothing().when(cajasDeCompensacionDAO).borrarCajaCompensacion(any(BigDecimal.class));
            ResponseRegistrarCaja response = cajasDeCompensacionServicio.borrarCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 el dao lanza una excepcion al borrar la caja
            Mockito.doThrow(excep).when(cajasDeCompensacionDAO).borrarCajaCompensacion(any(BigDecimal.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = cajasDeCompensacionServicio.borrarCajaCompensacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");

        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testBorrarCajaCompensacion");
        }
        System.out.println("End Test: testBorrarCajaCompensacion");

    }
}

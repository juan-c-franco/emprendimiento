/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.HerramientaValoracionServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.PreguntasTemaDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.HerramientaValoracionServicio;
import com.growdata.emprendimiento.persistence.DAO.HerramientaValoracionDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
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
public class HerramientaValoracionServicioImplTest {

    @Mock
    private HerramientaValoracionDAO herramientaValoracionDAO;
    @Mock
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private HerramientaValoracionServicio herramientaValoracionServicio
            = new HerramientaValoracionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo BorrarTemaEvaluacion PU0052-REQ-UC35
     */
    @Test
    public void testBorrarTemaEvaluacion() {
        System.out.println("Start Test: testBorrarTemaEvaluacion");
        RequestBorrarTema request = new RequestBorrarTema();
        request.setIdTema(BigDecimal.TEN);
        request.setIdHerramienta(BigDecimal.ZERO);
        request.setIdCajaCompensacion(BigDecimal.ZERO);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Tema borrado exitosamente
            doNothing().when(temasEvaluacionDAO).borrarTemaEvaluacion(any(BigDecimal.class), any(BigDecimal.class), any(BigDecimal.class));
            ResponseBorrarTema response = herramientaValoracionServicio.borrarTemaEvaluacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 el dao lanza una excepcion al borrar el tema
            Mockito.doThrow(excep).when(temasEvaluacionDAO).borrarTemaEvaluacion(any(BigDecimal.class), any(BigDecimal.class), any(BigDecimal.class));
            response = herramientaValoracionServicio.borrarTemaEvaluacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testBorrarTemaEvaluacion");
        }
        System.out.println("End Test: testBorrarTemaEvaluacion");

    }

    /**
     * Prueba unitaria para el metodo SetPreguntaTema PU0054-REQ-UC35
     */
    @Test
    public void testSetPreguntaTema() {
        System.out.println("Start Test: testSetPreguntaTema");
        RequestRegistrarPreguntaTema request = new RequestRegistrarPreguntaTema();
        RequestRegistrarPreguntaTema request2 = new RequestRegistrarPreguntaTema();
        PreguntasTemaDTO preguntaTemaDTO = new PreguntasTemaDTO();
        PreguntasTemaDTO pregunta2 = new PreguntasTemaDTO();
        preguntaTemaDTO.setIdpregunta(BigDecimal.TEN);
        request.setPreguntaTemaDTO(preguntaTemaDTO);
        request2.setPreguntaTemaDTO(pregunta2);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 pregunta actualizada exitosamente
            when(herramientaValoracionDAO.updatePreguntaTema(any(Preguntas.class))).thenReturn("1");
            ResponseRegistrarPreguntaTema response = herramientaValoracionServicio.setPreguntaTema(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 2 pregunta creada exitosamente
            when(herramientaValoracionDAO.setPreguntaTema(any(Preguntas.class))).thenReturn(new BigDecimal(1));
            response = herramientaValoracionServicio.setPreguntaTema(request2);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #2 --> OK");
            //Prueba Error 1 dao lanza exception al actualizar pregunta 
            given(herramientaValoracionDAO.updatePreguntaTema(any(Preguntas.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = herramientaValoracionServicio.setPreguntaTema(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 dao lanza exception al crear pregunta 
            given(herramientaValoracionDAO.setPreguntaTema(any(Preguntas.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = herramientaValoracionServicio.setPreguntaTema(request2);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores: testSetPreguntaTema");
        }
        System.out.println("End Test: testSetPreguntaTema");

    }

    /**
     * Prueba Unitaria para el metodo SetTemaEvaluacion PU0053-REQ-UC35
     */
    @Test
    public void testSetTemaEvaluacion() {
        System.out.println("Start Test: testSetTemaEvaluacion");
        RequestRegistrarTemaEvaluacion request = new RequestRegistrarTemaEvaluacion();
        RequestRegistrarTemaEvaluacion request2 = new RequestRegistrarTemaEvaluacion();
        TemasEvaluacionDTO tema = new TemasEvaluacionDTO();
        tema.setIdtema(BigDecimal.TEN);
        tema.setNombretema("nombre");
        tema.setDescripcion("descripcion");
        tema.setFecharegistro(new Date());
        tema.setHorasbasico(BigDecimal.ZERO);
        tema.setCalificacionbasico(Long.MIN_VALUE);
        tema.setHorasintermedio(Long.MIN_VALUE);
        tema.setCalificacionintermedio(BigDecimal.ZERO);
        tema.setHorasavanzado(BigDecimal.ZERO);
        tema.setCalificacionavanzado(BigDecimal.ZERO);
        request.setTemaEvaluacionDTO(tema);
        TemasEvaluacionDTO tema2 = new TemasEvaluacionDTO();

        tema2.setNombretema("nombre");
        tema2.setDescripcion("descripcion");
        tema2.setFecharegistro(new Date());
        tema2.setHorasbasico(BigDecimal.ZERO);
        tema2.setCalificacionbasico(Long.MIN_VALUE);
        tema2.setHorasintermedio(Long.MIN_VALUE);
        tema2.setCalificacionintermedio(BigDecimal.ZERO);
        tema2.setHorasavanzado(BigDecimal.ZERO);
        tema2.setCalificacionavanzado(BigDecimal.ZERO);
        request2.setTemaEvaluacionDTO(tema2);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 actualizar tema exitosamente
            when(herramientaValoracionDAO.updateTemaEvaluacion(any(Temasevaluacion.class))).thenReturn("1");
            ResponseRegistrarTemaEvaluacion response = herramientaValoracionServicio.setTemaEvaluacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 2 crear tema exitosamente
            when(herramientaValoracionDAO.setTemaEvaluacion(any(Temasevaluacion.class))).thenReturn(new BigDecimal(1));
            response = herramientaValoracionServicio.setTemaEvaluacion(request2);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #2 --> OK");
            //Prueba Error 1 dao lanza exception al actualizar tema 
            given(herramientaValoracionDAO.updateTemaEvaluacion(any(Temasevaluacion.class))).willThrow(excep);
            response = herramientaValoracionServicio.setTemaEvaluacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2dao lanza exception al crear tema 
            given(herramientaValoracionDAO.setTemaEvaluacion(any(Temasevaluacion.class))).willThrow(excep);
            response = herramientaValoracionServicio.setTemaEvaluacion(request2);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testSetTemaEvaluacion");
        }
        System.out.println("End Test: testSetTemaEvaluacion");
    }
}

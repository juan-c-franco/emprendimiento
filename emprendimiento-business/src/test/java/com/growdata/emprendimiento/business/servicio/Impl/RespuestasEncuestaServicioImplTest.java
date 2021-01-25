/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.RespuestasEncuestaServicioImpl;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGuardarRespuestas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGuardarRespuestas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.RespuestasEncuestaServicio;
import com.growdata.emprendimiento.persistence.DAO.EncuestaDAO;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RespuestasEncuestaServicioImplTest {

    @Mock
    private EncuestaDAO encuestaDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private RespuestasEncuestaServicio respuestasEncuestaServicio
            = new RespuestasEncuestaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo GuardarRespuestas PU0014-REQ-UC13
     */
    @Test
    public void testGuardarRespuestas() {
        System.out.println("Start Test: testGuardarRespuestas");
        RequestGuardarRespuestas request = new RequestGuardarRespuestas();
        List<RespuestasValor> respuestasValor = new ArrayList();
        RespuestasValor respuesta = new RespuestasValor();
        respuesta.setIdpregunta(BigDecimal.TEN);
        respuesta.setRespuesta("1");
        respuestasValor.add(respuesta);
        request.setIdEncuesta(0);
        request.setRespuestasValor(respuestasValor);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 respuestas guardadas exitosamente
            doNothing().when(encuestaDAO).actualizarEncuesta(any(Long.class), any(Date.class), any(ArrayList.class));
            ResponseGuardarRespuestas response = respuestasEncuestaServicio.guardarRespuestas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 respuestas guardadas exitosamente
            Mockito.doThrow(excep).when(encuestaDAO).actualizarEncuesta(any(Long.class), any(Date.class), any(ArrayList.class));
            response = respuestasEncuestaServicio.guardarRespuestas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testGuardarRespuestas");
        }
        System.out.println("End Test: testGuardarRespuestas");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.EvaluacionIntegrantesComiteServicioImpl;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCalificarEmpIndividual;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.EvaluacionIntegrantesComiteServicio;
import com.growdata.emprendimiento.persistence.DAO.EvaluacionIntegrantesComiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionintegrantescomite;
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
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class EvaluacionIntegrantesComiteServicioImplTest {

    @Mock
    private EvaluacionIntegrantesComiteDAO evaluacionIntegrantesComiteDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private EvaluacionIntegrantesComiteServicio evaluacionIntegrantesComiteServicio
            = new EvaluacionIntegrantesComiteServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo CalificacionIndividual PU0040-REQ-UC23
     */
    @Test
    public void testCalificacionIndividual() {
        System.out.println("Start Test: testCalificacionIndividual");
        RequestCalificarEmpIndividual request = new RequestCalificarEmpIndividual();
        request.setObservaciones("observaciones");
        request.setCalificacion(BigDecimal.ZERO);
        request.setIdfuncionario(0);
        request.setIdemprendimiento(0);
        Exception e = new Exception("Exception", new Exception(""));

        try {
            //Prueba 1 calificacion guardada exitosamente
            when(evaluacionIntegrantesComiteDAO.calificacionIndividual(any(Long.class), any(Evaluacionintegrantescomite.class))).thenReturn(new Long(1));
            ResponseCalificarEmpIndividual response = evaluacionIntegrantesComiteServicio.calificacionIndividual(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 el dao lanza una exception al guardar calificacion
            given(evaluacionIntegrantesComiteDAO.calificacionIndividual(any(Long.class), any(Evaluacionintegrantescomite.class))).willThrow(e);

            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = evaluacionIntegrantesComiteServicio.calificacionIndividual(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception l) {
            System.out.println("End Test (Errores): testCalificacionIndividual");
        }

        System.out.println("End Test: testCalificacionIndividual");
    }
}

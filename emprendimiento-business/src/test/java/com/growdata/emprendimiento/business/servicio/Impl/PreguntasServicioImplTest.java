/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.PreguntasServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarPregunta;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.PreguntasServicio;
import com.growdata.emprendimiento.persistence.DAO.PreguntasDAO;
import java.math.BigDecimal;
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
public class PreguntasServicioImplTest {

    @Mock
    private PreguntasDAO preguntasDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private PreguntasServicio preguntasServicio
            = new PreguntasServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria del metodo BorrarPreguntas PU0055-REQ-UC35
     */
    @Test
    public void testBorrarPreguntas() {
        System.out.println("Start Test: testBorrarPreguntas");
        RequestBorrarPregunta request = new RequestBorrarPregunta();
        request.setIdPregunta(BigDecimal.TEN);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 borrar preguntas exitosamente
            doNothing().when(preguntasDAO).borrarPregunta(any(BigDecimal.class));
            ResponseBorrarPregunta response = preguntasServicio.borrarPreguntas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1--> OK");
            //Prueba Error 1 dao lanza exception al borrar preguntas
            Mockito.doThrow(excep).when(preguntasDAO).borrarPregunta(any(BigDecimal.class));
            response = preguntasServicio.borrarPreguntas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1--> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testBorrarPreguntas");
        }
        System.out.println("End Test: testBorrarPreguntas");
    }
}

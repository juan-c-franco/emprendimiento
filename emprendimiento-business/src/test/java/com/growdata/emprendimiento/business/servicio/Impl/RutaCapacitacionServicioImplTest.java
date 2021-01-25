/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.RutaCapacitacionServicioImpl;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasV;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVInd;
import com.growdata.emprendimiento.business.dtos.valoracion.RespuestasValorV;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.RutaCapacitacionServicio;
import com.growdata.emprendimiento.persistence.DAO.RutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Rutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class RutaCapacitacionServicioImplTest {

    @Mock
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Mock
    private RutaCapacitacionDAO rutaCapacitacionDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private RutaCapacitacionServicio rutaCapacitacionServicio
            = new RutaCapacitacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo crear ruta de capacitacion PU0004-REQ-UC11
     */
    @Test
    public void testCrearRutaCapacitacion() {
        System.out.println("Start Test: testCrearRutaCapacitacion");
        RequestGuardarRespuestasV request = new RequestGuardarRespuestasV();
        List<RespuestasValorV> respuestasValorV = new ArrayList();
        RespuestasValorV respuesta = new RespuestasValorV();
        respuesta.setIdpregunta(BigDecimal.TEN);
        respuesta.setRespuesta("1");
        respuesta.setIdtema(BigDecimal.TEN);
        respuestasValorV.add(respuesta);
        request.setIdBeneficiario(0);
        request.setRespuestasV(respuestasValorV);
        Exception excep = new Exception("ex", new Exception("ex"));
        Rutacapacitacion ruta = null;
        Temasevaluacion tema = new Temasevaluacion();
        tema.setNombretema("nombre");
        tema.setCalificacionbasico(Long.MIN_VALUE);
        tema.setHorasbasico(BigDecimal.ZERO);
        tema.setCalificacionintermedio(new BigDecimal(2));
        tema.setHorasintermedio(Long.MIN_VALUE);
        tema.setCalificacionavanzado(BigDecimal.TEN);
        tema.setHorasavanzado(BigDecimal.ZERO);

        try {
            //Prueba 1 todo OK
            when(rutaCapacitacionDAO.getRuta(any(Long.class))).thenReturn(ruta);
            when(rutaCapacitacionDAO.crearRuta(any(Rutacapacitacion.class))).thenReturn(new Long(1));
            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            ResponseGuardarRespuestasVInd response = rutaCapacitacionServicio.crearRutaCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1
            when(rutaCapacitacionDAO.getRuta(any(Long.class))).thenReturn(ruta);
            when(rutaCapacitacionDAO.crearRuta(any(Rutacapacitacion.class))).thenReturn(new Long(1));
            given(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = rutaCapacitacionServicio.crearRutaCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2
            when(rutaCapacitacionDAO.getRuta(any(Long.class))).thenReturn(ruta);
            given(rutaCapacitacionDAO.crearRuta(any(Rutacapacitacion.class))).willThrow(excep);
//            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            response = rutaCapacitacionServicio.crearRutaCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba Error 3
            given(rutaCapacitacionDAO.getRuta(any(Long.class))).willThrow(excep);
//            when(rutaCapacitacionDAO.crearRuta(any(Rutacapacitacion.class))).thenReturn(new Long(1));
//            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            response = rutaCapacitacionServicio.crearRutaCapacitacion(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearRutaCapacitacion");
        }
        System.out.println("End Test: testCrearRutaCapacitacion");
    }
}

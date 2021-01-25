/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.RutaAcompanamientoATServicioImpl;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.RespuestasValorV;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.RutaAcompanamientoATServicio;
import com.growdata.emprendimiento.persistence.DAO.RutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
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
public class RutaAcompanamientoATServicioImplTest {

    @Mock
    private RutaAcompanamientoATDAO rutaAcompanamientoATDAO;
    @Mock
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private RutaAcompanamientoATServicio rutaAcompanamientoATServicio
            = new RutaAcompanamientoATServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo CrearRutaAcompanamientoAT PU0011-REQ-UC12
     */
    @Test
    public void testCrearRutaAcompanamientoAT() {
        System.out.println("Start Test: testCrearRutaAcompanamientoAT");
        RequestGuardarRespuestasVGrupal request = new RequestGuardarRespuestasVGrupal();
        request.setIdEmprendimiento(0);
        List<RespuestasValorV> respuestasV = new ArrayList();
        RespuestasValorV respuesta = new RespuestasValorV();
        respuesta.setIdpregunta(BigDecimal.TEN);
        respuesta.setIdtema(BigDecimal.TEN);
        respuesta.setRespuesta("1");
        respuestasV.add(respuesta);
        request.setRespuestasV(respuestasV);
        Rutaacompanamientoat ruta = null;
        Temasevaluacion tema = new Temasevaluacion();
        tema.setNombretema("nombre");
        tema.setCalificacionbasico(Long.MIN_VALUE);
        tema.setHorasbasico(BigDecimal.ZERO);
        tema.setCalificacionintermedio(new BigDecimal(2));
        tema.setHorasintermedio(Long.MIN_VALUE);
        tema.setCalificacionavanzado(BigDecimal.TEN);
        tema.setHorasavanzado(BigDecimal.ZERO);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 todo OK
            when(rutaAcompanamientoATDAO.getRuta(any(Long.class))).thenReturn(ruta);
            when(rutaAcompanamientoATDAO.crearRuta(any(Rutaacompanamientoat.class))).thenReturn(new Long(1));
            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            ResponseGuardarRespuestasVGrupal response = rutaAcompanamientoATServicio.crearRutaAcompanamientoAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 
            when(rutaAcompanamientoATDAO.getRuta(any(Long.class))).thenReturn(ruta);
            when(rutaAcompanamientoATDAO.crearRuta(any(Rutaacompanamientoat.class))).thenReturn(new Long(1));
            given(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = rutaAcompanamientoATServicio.crearRutaAcompanamientoAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 
            when(rutaAcompanamientoATDAO.getRuta(any(Long.class))).thenReturn(ruta);
            given(rutaAcompanamientoATDAO.crearRuta(any(Rutaacompanamientoat.class))).willThrow(excep);
//            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            response = rutaAcompanamientoATServicio.crearRutaAcompanamientoAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba Error 1 
            given(rutaAcompanamientoATDAO.getRuta(any(Long.class))).willThrow(excep);
//            when(rutaAcompanamientoATDAO.crearRuta(any(Rutaacompanamientoat.class))).thenReturn(new Long(1));
//            when(temasEvaluacionDAO.traerTemasPorTema(any(BigDecimal.class))).thenReturn(tema);
            response = rutaAcompanamientoATServicio.crearRutaAcompanamientoAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println(" End Test (Errores): testCrearRutaAcompanamientoAT");
        }
        System.out.println("End Test: testCrearRutaAcompanamientoAT");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.TemasRutaCapacitacionServicioImpl;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.intentodto.RutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.servicio.TemasRutaCapacitacionServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
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
public class TemasRutaCapacitacionServicioImplTest {

    @Mock
    private TemasRutaCapacitacionDAO temasRutaCapacitacionDAO;

    @Mock
    private BeneficiarioDAO beneficiarioDAO;

    @Mock
    private EnviarEmail enviarEmail;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private TemasRutaCapacitacionServicio temasRutaCapacitacionServicio
            = new TemasRutaCapacitacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo Crear Temas PU0005-REQ-UC11
     */
    @Test
    public void testCrearTemas() {
        System.out.println("Start test: testCrearTemas");
        RequestGuardarTemasValoracionInd request = new RequestGuardarTemasValoracionInd();
        List<TemasrutacapacitacionDTO> temasRuta = new ArrayList();
        request.setIdbeneficiario(0);
        request.setIdruta(0);
        TemasrutacapacitacionDTO tema = new TemasrutacapacitacionDTO();
        tema.setCantidadhorasplaneadas(BigDecimal.ONE);
        tema.setIdtemarutacapacitacion(0);
        tema.setNombretema("tema");
        RutacapacitacionDTO ruta = new RutacapacitacionDTO();
        ruta.setIdrutacapacitacion(0);
        tema.setRutacapacitacion(ruta);
        temasRuta.add(tema);
        request.setTemasRuta(temasRuta);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 temas creados exitosamente
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            when(temasRutaCapacitacionDAO.crearTema(any(ArrayList.class))).thenReturn(new Long(1));
//            doNothing().when(temasRutaCapacitacionDAO).crearTema(any(ArrayList.class));
            when(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseGuardarTemasValoracionInd response = temasRutaCapacitacionServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 enviar email lanza una excepcion
//            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
//            doNothing().when(temasRutaCapacitacionDAO).crearTema(any(ArrayList.class));
//            given(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).willThrow(new Exception("Exception"));
//            response = temasRutaCapacitacionServicio.crearTemas(request);
//            assertThat(response, is(not(nullValue())));
//            assertThat(response.getStatus(), is(equalTo("0")));
//            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza una excepcion al crear tema
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            given(temasRutaCapacitacionDAO.crearTema(any(ArrayList.class))).willThrow(excep);
//            Mockito.doThrow(excep).when(temasRutaCapacitacionDAO).crearTema(any(ArrayList.class));
//            when(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = temasRutaCapacitacionServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba Error 3 el dao lanza una excepcion al traer el beneficiario
            given(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            given(temasRutaCapacitacionDAO.crearTema(any(ArrayList.class))).willThrow(excep);
            when(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            response = temasRutaCapacitacionServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearTemas");
        }
        System.out.println("End Test: testCrearTemas");
    }

}

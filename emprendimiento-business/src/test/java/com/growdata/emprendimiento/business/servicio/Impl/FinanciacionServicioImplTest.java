/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.FinanciacionServicioImpl;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinanciera;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.intentodto.ConfiguracionDTO;
import com.growdata.emprendimiento.business.servicio.FinanciacionServicio;
import com.growdata.emprendimiento.persistence.DAO.FinanciacionDAO;
import com.growdata.emprendimiento.persistence.DAO.IntegrantescomiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class FinanciacionServicioImplTest {

    @Mock
    private FinanciacionDAO financiacionDAO;
    @Mock
    private IntegrantescomiteDAO integrantesComiteDAO;
    @Mock
    private EnviarEmail enviar;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private FinanciacionServicio financiacionServicio
            = new FinanciacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo GuardarInfoFinancieraBasica
     * PU0041-REQ-UC26
     */
    @Test
    public void testGuardarInfoFinancieraBasica() {
        System.out.println("Start Test: testGuardarInfoFinancieraBasica");
        RequestRegistrarInfoFinancieraBasica request = new RequestRegistrarInfoFinancieraBasica();
        request.setIdEmprendimiento(0);
        request.setIdFuncionario(0);
        request.setIdtipofinanciacion(BigDecimal.ONE);
        request.setMontofinanciacions(0);
        request.setCuotaspactadasS(BigDecimal.ONE);
        request.setTasaintertess(BigDecimal.ZERO);
        request.setRecursospropiosae(0);
        request.setEmpleosporgenerar(BigDecimal.ONE);
        request.setEmpleosgenerados(BigDecimal.ZERO);
        request.setCapitaltotal(0);
        request.setCapitaltrabajo(0);
        request.setMesespuntoequilibrio(BigDecimal.ZERO);
        request.setAprobado("1");
        Funcionario f = new Funcionario();
        f.setEmail("email");
        Integrantescomite i = new Integrantescomite();
        i.setFuncionario(f);
        List<Integrantescomite> integrantes = new ArrayList();
        integrantes.add(i);
        Exception excep = new Exception("Ex", new Exception(""));
        try {
            //Prueba 1 Info financiera guardada exitosamente
            when(financiacionDAO.guardarInformacionFinancieraBasica(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(String.class))).thenReturn(new Long(1));
            when(integrantesComiteDAO.getIntegrantesComitePorIdFuncionario(any(Long.class))).thenReturn(integrantes);
            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseRegistrarInfoFinancieraBasica response = financiacionServicio.guardarInfoFinancieraBasica(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 el dao lanza Exception al enviar email
            when(financiacionDAO.guardarInformacionFinancieraBasica(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(String.class))).thenReturn(new Long(1));
            when(integrantesComiteDAO.getIntegrantesComitePorIdFuncionario(any(Long.class))).thenReturn(integrantes);
            given(enviar.notificarGenerica(any(Long.class), any(String.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = financiacionServicio.guardarInfoFinancieraBasica(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Error 2 el dao lanza Exception al traer integrantes comite
            when(financiacionDAO.guardarInformacionFinancieraBasica(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(String.class))).thenReturn(new Long(1));
            given(integrantesComiteDAO.getIntegrantesComitePorIdFuncionario(any(Long.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = financiacionServicio.guardarInfoFinancieraBasica(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba Error 3 el dao lanza Exception al guardar info financiera basica
            given(financiacionDAO.guardarInformacionFinancieraBasica(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(String.class))).willThrow(excep);
//            given(integrantesComiteDAO.getIntegrantesComitePorIdFuncionario(any(Long.class))).willThrow(excep);
//            when(enviar.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = financiacionServicio.guardarInfoFinancieraBasica(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testGuardarInfoFinancieraBasica");
        }

        System.out.println("End Test: testGuardarInfoFinancieraBasica");
    }

    /**
     * Prueba unitaria para el metodo GuardarInfoFinanciera PU0042-REQ-UC26
     */
    @Test
    public void testGuardarInfoFinanciera() {
        System.out.println("Start Test: testGuardarInfoFinanciera");
        RequestRegistrarInfoFinanciera request = new RequestRegistrarInfoFinanciera();
        request.setMontoa(Long.MIN_VALUE);
        request.setTasainteresa(BigDecimal.ZERO);
        request.setCuotaspactadasa(BigDecimal.ONE);
        request.setIdfinanciacion(0);
        request.setEntidadesfinancieras(new Entidadesfinancieras());
        request.setIdtipofinanciacion(BigDecimal.ONE);
        request.setIdEmprendimiento(0);
        ConfiguracionDTO config = new ConfiguracionDTO();
        config.setValor(0);
        request.setConfiguracion(config);
        Exception excep = new Exception("Ex", new Exception(""));
        try {
            //Prueba 1 informacion financiera guardada exitosamente 
            doNothing().when(financiacionDAO).guardarInformacionFinanciera(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(Integer.class));
            ResponseRegistrarInfoFinancieraBasica response = financiacionServicio.guardarInfoFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 informacion financiera guardada exitosamente 
            Mockito.doThrow(excep).when(financiacionDAO).guardarInformacionFinanciera(any(Financiacion.class), any(Long.class), any(Estadoemprendimiento.class), any(Integer.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = financiacionServicio.guardarInfoFinanciera(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testGuardarInfoFinanciera");
        }
        System.out.println("End Test: testGuardarInfoFinanciera");
    }
}

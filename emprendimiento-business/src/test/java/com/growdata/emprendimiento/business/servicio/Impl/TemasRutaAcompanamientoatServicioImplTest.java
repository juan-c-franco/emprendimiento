/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.TemasRutaAcompanamientoatServicioImpl;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.TemasRutaAcompanamientoatServicio;
import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
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
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class TemasRutaAcompanamientoatServicioImplTest {

    @Mock
    private TemasRutaAcompanamientoATDAO temasRutaAcompanamientoATDAO;
    @Mock
    private AsociadoDAO asociadoDAO;
    @Mock
    private BeneficiarioDAO beneficiarioDAO;
    @Mock
    private EmprendimientoDAO emprendimientoDAO;
    @Mock
    private EnviarEmail enviarEmail;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private TemasRutaAcompanamientoatServicio temasRutaAcompanamientoatServicio
            = new TemasRutaAcompanamientoatServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Unitaria para el metodo CrearTemasAAT PU0012-REQ-UC12
     */
    @Test
    public void testCrearTemasAAT() {
        System.out.println("Start Test: testCrearTemasAAT");
        RequestGuardarTemasValoracionGrupal request = new RequestGuardarTemasValoracionGrupal();
        List<TemasrutaacompanamientoatDTO> temasRuta = new ArrayList();
        TemasrutaacompanamientoatDTO tema = new TemasrutaacompanamientoatDTO();
        tema.setIdtemarutaacompanamientoat(0);
        RutaacompanamientoatDTO rutaAAT = new RutaacompanamientoatDTO();
        rutaAAT.setIdrutaacompanamientoat(0);
        rutaAAT.setFecharegistro(new Date());
        tema.setRutaacompanamientoat(rutaAAT);
        TemasEvaluacionDTO temasevaluacion = new TemasEvaluacionDTO();
        temasevaluacion.setNombretema("tema");
        temasevaluacion.setIdtema(BigDecimal.TEN);
        tema.setTemasevaluacion(temasevaluacion);
        tema.setCantidadhorasplaneadas(BigDecimal.ONE);
        tema.setFecharegistro(new Date());
        temasRuta.add(tema);
        request.setIdEmprendimiento(0);
        request.setTemasRuta(temasRuta);
        List<Asociados> asociados = new ArrayList();
        Asociados asociado = new Asociados();
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setIdbeneficiario(0);
        asociado.setBeneficiario(beneficiario);
        asociados.add(asociado);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 temas creados exitosamente
//            doNothing().when(temasRutaAcompanamientoATDAO).crearTema(any(ArrayList.class), any(Long.class), any(Estadoemprendimiento.class));
            when(temasRutaAcompanamientoATDAO.crearTema(any(ArrayList.class), any(Long.class), any(Estadoemprendimiento.class))).thenReturn(new Long(1));
            when(asociadoDAO.getAsociadosPorEmprendimiento2(any(Long.class))).thenReturn(asociados);
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
            when(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            ResponseGuardarTemasValoracionInd response = temasRutaAcompanamientoatServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Errores 1 el dao lanza una exception al traer beneficiario
            when(temasRutaAcompanamientoATDAO.crearTema(any(ArrayList.class), any(Long.class), any(Estadoemprendimiento.class))).thenReturn(new Long(1));
            when(asociadoDAO.getAsociadosPorEmprendimiento2(any(Long.class))).thenReturn(asociados);
            given(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).willThrow(excep);
//            when(enviarEmail.notificarGenerica(any(Long.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            response = temasRutaAcompanamientoatServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba Errores 2 el dao lanza una exception al traer asociados
            when(temasRutaAcompanamientoATDAO.crearTema(any(ArrayList.class), any(Long.class), any(Estadoemprendimiento.class))).thenReturn(new Long(1));
            given(asociadoDAO.getAsociadosPorEmprendimiento2(any(Long.class))).willThrow(new Exception("Exception"));
//            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
//            when(enviarEmail.notificarGenerica(any(Long.class),any(String.class))).thenReturn(true);
            response = temasRutaAcompanamientoatServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
            //Prueba Errores 3 el dao lanza una exception al crear tema
            given(temasRutaAcompanamientoATDAO.crearTema(any(ArrayList.class), any(Long.class), any(Estadoemprendimiento.class))).willThrow(excep);
//            when(asociadoDAO.getAsociadosPorEmprendimiento2(any(Long.class))).thenReturn(asociados);
//            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(beneficiario);
//            when(enviarEmail.notificarGenerica(any(Long.class),any(String.class))).thenReturn(true);
            response = temasRutaAcompanamientoatServicio.crearTemas(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #3 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearTemasAAT");
        }
        System.out.println("End Test: testCrearTemasAAT");
    }
}

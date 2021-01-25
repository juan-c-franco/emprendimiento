/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.SeguimientoServicioImpl;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.SeguimientoServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.FormalizadoDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.NoestablecidoDAO;
import com.growdata.emprendimiento.persistence.DAO.PaisesDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.SeguimientoDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Observacionesseguimiento;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.entidad.Seguimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Juan Franco
 */
public class SeguimientoServicioImplTest {

    @Mock
    private FormalizadoDAO formalizadoDAO;
    @Mock
    private NoestablecidoDAO noestablecidoDAO;
    @Mock
    private EmprendimientoDAO emprendimientoDAO;
    @Mock
    private FuncionarioDAO funcionarioDAO;
    @Mock
    private SeguimientoDAO seguimientoDAO;
    @Mock
    private PaisesDAO paisesDAO;
    @Mock
    private PlantillaMailDAO plantillaMailDAO;
    @Mock
    private EnviarEmail mail;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private SeguimientoServicio seguimientoServicio
            = new SeguimientoServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el método guardarSeguimientoFormalizado.
     * PU0044-REQ-UC30
     */
    @Test
    public void testGuardarSeguimientoFormalizado() {
        System.out.println("Start Test: guardarSeguimientoFormalizado");
        try {
            List<List<String>> paises = new ArrayList<>();
            List<String> lPaises = new ArrayList<String>();
            String pais = "123";
            lPaises.add(pais);
            paises.add(lPaises);
            RequestRegistrarFormalizado request = new RequestRegistrarFormalizado(
                    Long.MIN_VALUE, new Long(123), Long.MIN_VALUE, BigDecimal.ZERO,
                    "aaa", "aaa", "aaa", "registroMercantil", "aaa", "aaa", Long.MIN_VALUE, 123, "aaa", "aaa",
                    "si", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO, paises, new ArrayList<String>(),
                    Character.MIN_VALUE, "aaa", new Date(), new Date(), BigDecimal.TEN,
                    BigDecimal.ZERO, BigDecimal.ZERO, "aaa", 123, true);

            RequestRegistrarInfoFinancieraBasica requestFinan
                    = new RequestRegistrarInfoFinancieraBasica(0, 0, BigDecimal.ONE,
                            0, BigDecimal.ONE, BigDecimal.ZERO, 0, BigDecimal.ONE,
                            BigDecimal.ZERO, 0, 0, BigDecimal.ZERO, "");

            PlantillaMail plantilla = new PlantillaMail();
            plantilla.setAsunto("");
            plantilla.setPlantilla("");

            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setNombreemprendimiento("");
            Beneficiario beneficiario = new Beneficiario();
            beneficiario.setPrimernombre("");
            beneficiario.setPrimerapellido("");
            beneficiario.setEmail("");
            Asociados asociado = new Asociados();
            asociado.setBeneficiario(beneficiario);
            Set<Asociados> asociadoses = new HashSet<Asociados>(0);
            asociadoses.add(asociado);
            emprendimiento.setAsociadoses(asociadoses);

            //PruebaOK #1 - Seguimiento guardado exitosamente
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(formalizadoDAO.getFormalizadoPorId(any(long.class))).thenReturn(new Formalizado());
            when(paisesDAO.getPaisesPorId(any(int.class))).thenReturn(new Paises());
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);

            ResponseDTO result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - seguimientoDAO.guardarSeguimientoFormalizado lanza PersistenceException
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(formalizadoDAO.getFormalizadoPorId(any(long.class))).thenReturn(new Formalizado());
            when(paisesDAO.getPaisesPorId(any(int.class))).thenReturn(new Paises());
            given(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).willThrow(new PersistenceException("Exception"));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - seguimientoDAO.guardarSeguimientoFormalizado lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(formalizadoDAO.getFormalizadoPorId(any(long.class))).thenReturn(new Formalizado());
            when(paisesDAO.getPaisesPorId(any(int.class))).thenReturn(new Paises());
            given(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).willThrow(new Exception("Exception"));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - paisesDAO.getPaisesPorId lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(formalizadoDAO.getFormalizadoPorId(any(long.class))).thenReturn(new Formalizado());
            given(paisesDAO.getPaisesPorId(any(int.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - formalizadoDAO.getFormalizadoPorId lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            given(formalizadoDAO.getFormalizadoPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - funcionarioDAO.getFuncionarioPorId lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            given(funcionarioDAO.getFuncionarioPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            //PruebaERROR #6 - emprendimientoDAO.getEmprendimientoPorId devuelve null
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(null);
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #6 --> OK");

            //PruebaERROR #7 - emprendimientoDAO.getEmprendimientoPorId lanza Exception
            given(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoFormalizado(any(Formalizado.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoFormalizado(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #7 --> OK");

            System.out.println("End Test: guardarSeguimientoFormalizado");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarSeguimientoFormalizado");
        }
    }

    /**
     * Prueba unitaria para el método guardarSeguimientoNoEstablecido.
     * PU0062-REQ-UC30
     */
    @Test
    public void testGuardarSeguimientoNoEstablecido() {
        System.out.println("Start Test: guardarSeguimientoNoEstablecido");
        try {
            RequestNoEstablecido request = new RequestNoEstablecido(new Long(123),
                    BigDecimal.ZERO, "", BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO,
                    new ArrayList<String>(), "productos", new Date(), "");
            request.setIdEmprendimiento(new Long(123));
            request.setIdNoEstablecido(BigDecimal.ZERO);

            RequestRegistrarInfoFinancieraBasica requestFinan
                    = new RequestRegistrarInfoFinancieraBasica(0, 0, BigDecimal.ONE,
                            0, BigDecimal.ONE, BigDecimal.ZERO, 0, BigDecimal.ONE,
                            BigDecimal.ZERO, 0, 0, BigDecimal.ZERO, "");

            PlantillaMail plantilla = new PlantillaMail();
            plantilla.setAsunto("");
            plantilla.setPlantilla("");

            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setNombreemprendimiento("");
            Beneficiario beneficiario = new Beneficiario();
            beneficiario.setPrimernombre("");
            beneficiario.setPrimerapellido("");
            beneficiario.setEmail("");
            Asociados asociado = new Asociados();
            asociado.setBeneficiario(beneficiario);
            Set<Asociados> asociadoses = new HashSet<Asociados>(0);
            asociadoses.add(asociado);
            emprendimiento.setAsociadoses(asociadoses);

            //PruebaOK #1 - Seguimiento guardado exitosamente
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(emprendimiento);
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(noestablecidoDAO.getNoEstablecidoPorId(any(BigDecimal.class))).thenReturn(new Noestablecido());
            when(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);

            ResponseDTO result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - seguimientoDAO.guardarSeguimientoNoEstablecido lanza PersistenceException
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(emprendimiento);
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(noestablecidoDAO.getNoEstablecidoPorId(any(BigDecimal.class))).thenReturn(new Noestablecido());
            given(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).willThrow(new PersistenceException("Exception"));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - seguimientoDAO.guardarSeguimientoNoEstablecido lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(emprendimiento);
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            when(noestablecidoDAO.getNoEstablecidoPorId(any(BigDecimal.class))).thenReturn(new Noestablecido());
            given(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).willThrow(new Exception("Exception"));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - noestablecidoDAO.getFormalizadoPorId lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(emprendimiento);
            when(funcionarioDAO.getFuncionarioPorId(any(long.class))).thenReturn(new Funcionario());
            given(noestablecidoDAO.getNoEstablecidoPorId(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - funcionarioDAO.getFuncionarioPorId lanza Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(emprendimiento);
            given(funcionarioDAO.getFuncionarioPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - emprendimientoDAO.getEmprendimientoPorId devuelve null
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(null);
            when(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            //PruebaERROR #6 - emprendimientoDAO.getEmprendimientoPorId lanza Exception
            given(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(seguimientoDAO.guardarSeguimientoNoEstablecido(any(Noestablecido.class),
                    any(Observacionesseguimiento.class), any(Seguimiento.class),
                    any(Financiacion.class), any(boolean.class))).thenReturn(new Long(123));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoServicio.guardarSeguimientoNoEstablecido(request, requestFinan);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #6 --> OK");

            System.out.println("End Test: guardarSeguimientoNoEstablecido");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarSeguimientoNoEstablecido");
        }
    }

}

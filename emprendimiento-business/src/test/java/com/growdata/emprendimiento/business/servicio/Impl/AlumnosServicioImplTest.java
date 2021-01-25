/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.AlumnosServicioImpl;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAlumnos;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.AlumnosServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.DAO.SedesDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Sedes;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class AlumnosServicioImplTest {

    @Mock
    private AlumnosDAO alumnosDAO;
    @Mock
    private BeneficiarioDAO beneficiarioDAO;
    @Mock
    private EnviarEmail enviar;
    @Mock
    private ProgramacionDAO programacionDAO;
    @Mock
    private SedesDAO sedesDAO;
    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private EmprendimientoDAO emprendimientoDAO;
    @Mock
    private FuncionarioDAO funcionarioDAO;

    @InjectMocks
    private AlumnosServicio alumnosServicio
            = new AlumnosServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el mètodo getLista.
     */
    @Test
    public void testGetLista() {
        System.out.println("Start Test: getLista");
        try {
            ResponseAlumnos result = new ResponseAlumnos();

            List<Alumnos> list = new ArrayList<>();
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, null, null, null,
                    new Date(), null, null);
            list.add(alumno);

            //PruebaOK #1 - Alumnos encontrados exitosamente.
            when(alumnosDAO.getLista(any(BigDecimal.class))).thenReturn(list);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = alumnosServicio.getLista(BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaOK #2 - Alumnos no encontrados
            when(alumnosDAO.getLista(any(BigDecimal.class))).thenReturn(new ArrayList<>());
            result = alumnosServicio.getLista(BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #2 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            given(alumnosDAO.getLista(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.getLista(BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");
            System.out.println("End Test: getLista");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            System.out.println("End Test (Errores): getLista");
        }
    }

    /**
     * Prueba unitaria para el mètodo asociarBeneficiarioProgramacion.
     * PU0067-REQ-UC47
     */
    @Test
    public void testAsociarBeneficiarioProgramacion() {
        System.out.println("Start Test: asociarBeneficiarioProgramacion");
        try {
            ResponseDTO result = new ResponseDTO();

            Capacitacionprograma capacitacion = new Capacitacionprograma();
            capacitacion.setNombrecapacitacionprograma("");

            Beneficiario beneficiario = new Beneficiario();
            beneficiario.setPrimernombre("");
            beneficiario.setPrimerapellido("");
            beneficiario.setEmail("");
            beneficiario.setNumerodocumento("");

            Programacion programacion = new Programacion();
            programacion.setIdInstitucion(BigDecimal.TEN);
            programacion.setCapacitacionprograma(capacitacion);
            programacion.setFechainicioprogramacion(new Timestamp(0));
            programacion.setFechafinalrogramacion(new Timestamp(0));
            programacion.setUbicacion("");

            Sedes sede = new Sedes();
            sede.setNombre("");

            Cajacompensacion caja = new Cajacompensacion();
            caja.setIdcajacompensacion(BigDecimal.ZERO);
            Funcionario funcionario = new Funcionario();
            funcionario.setCajacompensacion(caja);

            //PruebaOK #1 - Alumnos encontrados exitosamente.
            when(beneficiarioDAO.getBeneficiarioPorId(any(long.class))).thenReturn(beneficiario);
            when(programacionDAO.getProgramacion(any(BigDecimal.class))).thenReturn(programacion);
            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class), any(BigDecimal.class)))
                    .thenReturn(new Emprendimiento());
            when(funcionarioDAO.getFuncionarioPorId(any(long.class)))
                    .thenReturn(funcionario);
            when(sedesDAO.getSedesPorId(any(BigDecimal.class))).thenReturn(sede);
            when(alumnosDAO.asociarBeneficiarioProgramacion(any(Alumnos.class))).thenReturn(new Long(123));
            when(enviar.notificarGenerica(any(int.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - No existe emprendimiento
            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class), any(BigDecimal.class)))
                    .thenReturn(null);
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 1 --> OK");

            //PruebaERROR #2 - El DAO alumnosDAO lanza una Exception
            given(alumnosDAO.asociarBeneficiarioProgramacion(any(Alumnos.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 2 --> OK");

            //PruebaERROR #3 - El DAO sedesDAO lanza una Exception
            given(sedesDAO.getSedesPorId(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 3 --> OK");

            //PruebaERROR #4 - El DAO funcionarioDAO lanza Exception
            given(funcionarioDAO.getFuncionarioPorId(any(long.class)))
                    .willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 4 --> OK");

            //PruebaERROR #5 - El DAO emprendimientoDAO lanza una Exception
            given(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class), any(BigDecimal.class)))
                    .willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 5 --> OK");

            //PruebaERROR #6 - El DAO programacionDAO lanza una Exception
            given(programacionDAO.getProgramacion(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 6 --> OK");

            //PruebaERROR #7 - El DAO beneficiarioDAO lanza una Exception
            given(beneficiarioDAO.getBeneficiarioPorId(any(long.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.asociarBeneficiarioProgramacion(BigDecimal.ONE, new Long(1), new Long(2));
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 7 --> OK");
            System.out.println("End Test: asociarBeneficiarioProgramacion");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            System.out.println("End Test (Errores): asociarBeneficiarioProgramacion");
        }
    }

    /**
     * Prueba unitaria para el mètodo getAlumnoPorDocumento.
     */
    @Test
    public void testGetAlumnoPorDocumento() {
        System.out.println("Start Test: getAlumnoPorDocumento");
        try {
            ResponseAlumnos result = new ResponseAlumnos();

            List<Alumnos> list = new ArrayList<>();
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, null, null, null,
                    new Date(), null, null);
            list.add(alumno);

            //PruebaOK #1 - Alumnos encontrados exitosamente.
            when(alumnosDAO.getAlumnoPorDocumento(any(String.class), any(String.class), any(BigDecimal.class))).thenReturn(list);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = alumnosServicio.getAlumnoPorDocumento("", "", BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - Alumnos no encontrados
            when(alumnosDAO.getAlumnoPorDocumento(any(String.class), any(String.class), any(BigDecimal.class))).thenReturn(new ArrayList<>());
            result = alumnosServicio.getAlumnoPorDocumento("", "", BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(alumnosDAO.getAlumnoPorDocumento(any(String.class), any(String.class), any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = alumnosServicio.getAlumnoPorDocumento("", "", BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");
            System.out.println("End Test: getAlumnoPorDocumento");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            System.out.println("End Test (Errores): getAlumnoPorDocumento");
        }
    }

}

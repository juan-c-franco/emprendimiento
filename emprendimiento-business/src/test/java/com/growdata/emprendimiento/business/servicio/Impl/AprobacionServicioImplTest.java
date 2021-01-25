/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.AprobacionServicioImpl;
import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.AprobacionServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Juan Franco
 */
public class AprobacionServicioImplTest {

    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private AprobacionDAO aprobacionDAO;
    @Mock
    private AlumnosDAO alumnosDAO;
    @Mock
    private EnviarEmail enviar;

    @InjectMocks
    private AprobacionServicio aprobacionServicio
            = new AprobacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Pruebas unitarias para el método registrarCalificacionCapacitacion.
     * PU0070-REQ-UC49
     */
    @Test
    public void testRegistrarCalificacionCapacitacion() {
        System.out.println("Start Test: registrarCalificacionCapacitacion");
        try {
            ResponseAprobaciones result = new ResponseAprobaciones();
            Beneficiario beneficiario = new Beneficiario(0, null, "Nombre",
                    "Apeliido", null, null, "email", Long.MIN_VALUE, null,
                    new Date(), null, null, null, null, null, null, null);
            Capacitacionprograma capacitacion = new Capacitacionprograma(0, null,
                    null, 0, "", new Date());
            Programacion programacion = new Programacion(BigDecimal.ZERO,
                    null, null, capacitacion, null, BigDecimal.TEN,
                    new Timestamp(0), new Timestamp(0), new Short("100"), new Date(),
                    "");
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, beneficiario, null,
                    programacion, null);

            List<AlumnosShortDTO> lAlumnos = new ArrayList<>();
            AlumnosShortDTO idAlumno = new AlumnosShortDTO();
            idAlumno.setIdalumno(BigDecimal.ZERO);
            lAlumnos.add(idAlumno);

            List<Aprobacion> list = new ArrayList<>();
            Aprobacion aprobacion = new Aprobacion(BigDecimal.ZERO,
                    null, alumno, new Short("1"), new Short("1"),
                    new Short("1"), new Date());
            list.add(aprobacion);

            List<String> aux = new ArrayList<>();
            String horas = "50";
            aux.add(horas);

            //PruebaOK #1 - Asistencia registrada exitosamente.
            doNothing().when(aprobacionDAO).registrarCalificacionCapacitacion(
                    any(ArrayList.class), any(BigDecimal.class));
            when(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).thenReturn(list);
            when(enviar.notificarGenerica(any(int.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = aprobacionServicio.registrarCalificacionCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, aux);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - aprobacionDAO.getAprobacionesPorProgramacion lanza una Exception
            given(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = aprobacionServicio.registrarCalificacionCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, aux);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 1 --> OK");

            //PruebaERROR #2 - seguimientoasistenciaDAO.registrarAsistenciaCapacitacion lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(aprobacionDAO).
                    registrarCalificacionCapacitacion(
                            any(ArrayList.class), any(BigDecimal.class));
            result = aprobacionServicio.registrarCalificacionCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, aux);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 2 --> OK");
            System.out.println("End Test: registrarCalificacionCapacitacion");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): registrarCalificacionCapacitacion");
        }
    }

    /**
     * Pruebas unitarias para el método registrarCalificacionCapacitacionMasiva.
     * PU0071-REQ-UC49
     */
    @Test
    public void testRegistrarCalificacionCapacitacionMasiva() {
        System.out.println("Start Test: registrarCalificacionCapacitacionMasiva");
        try {
            ResponseAprobaciones result = new ResponseAprobaciones();
            Beneficiario beneficiario = new Beneficiario(0, null, "Nombre",
                    "Apellido", null, null, "email", Long.MIN_VALUE, null,
                    new Date(), null, null, null, null, null, null, null);
            Capacitacionprograma capacitacion = new Capacitacionprograma(0, null,
                    null, 0, "", new Date());
            Programacion programacion = new Programacion(BigDecimal.ZERO,
                    null, null, capacitacion, null, BigDecimal.TEN,
                    new Timestamp(0), new Timestamp(0), new Short("100"), new Date(),
                    "");
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, beneficiario, null,
                    programacion, null);

            List<RequestCalificacionDTO> requestList = new ArrayList<>();
            RequestCalificacionDTO request = new RequestCalificacionDTO(
                    BigDecimal.ZERO, new Short("1"), new Short("0"));
            requestList.add(request);

            List<Aprobacion> list = new ArrayList<>();
            Aprobacion aprobacion = new Aprobacion(BigDecimal.ZERO,
                    null, alumno, new Short("1"), new Short("1"),
                    new Short("1"), new Date());
            list.add(aprobacion);

            List<String> aux = new ArrayList<>();
            String horas = "50";
            aux.add(horas);

            //PruebaOK #1 - Asistencia registrada exitosamente.
            doNothing().when(aprobacionDAO).registrarCalificacionCapacitacion(
                    any(ArrayList.class), any(BigDecimal.class));
            when(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).thenReturn(list);
            when(enviar.notificarGenerica(any(int.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = aprobacionServicio.registrarCalificacionCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - aprobacionDAO.getAprobacionesPorProgramacion lanza una Exception
            given(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = aprobacionServicio.registrarCalificacionCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 1 --> OK");

            //PruebaERROR #2 - seguimientoasistenciaDAO.registrarAsistenciaCapacitacion lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(aprobacionDAO).
                    registrarCalificacionCapacitacion(
                            any(ArrayList.class), any(BigDecimal.class));
            result = aprobacionServicio.registrarCalificacionCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 2 --> OK");
            System.out.println("End Test: registrarCalificacionCapacitacionMasiva");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): registrarCalificacionCapacitacionMasiva");
        }
    }

}

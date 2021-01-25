/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.SeguimientoasistenciaServicioImpl;
import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ModuloscicloShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.SeguimientoasistenciaServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.DAO.ModuloCicloDAO;
import com.growdata.emprendimiento.persistence.DAO.SeguimientoasistenciaDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import java.math.BigDecimal;
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
public class SeguimientoasistenciaServicioImplTest {

    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private SeguimientoasistenciaDAO seguimientoasistenciaDAO;
    @Mock
    private AprobacionDAO aprobacionDAO;
    @Mock
    private ModuloCicloDAO moduloCicloDAO;
    @Mock
    private AlumnosDAO alumnosDAO;
    @Mock
    private EnviarEmail enviar;

    @InjectMocks
    private SeguimientoasistenciaServicio seguimientoasistenciaServicio
            = new SeguimientoasistenciaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria del método registrarAsistenciaCapacitacion.
     * PU0068-REQ-UC48
     */
    @Test
    public void testRegistrarAsistenciaCapacitacion() {
        System.out.println("Start Test: registrarAsistenciaCapacitacion");
        try {
            ResponseAprobaciones result = new ResponseAprobaciones();
            Capacitacionprograma capacitacion = new Capacitacionprograma(0, null,
                    null, 0, "", new Date());
            Modulociclo modulo = new Modulociclo(0, capacitacion, "", new Short("1"), new Date());
            Beneficiario beneficiario = new Beneficiario(0, null, "Nombre",
                    "Apeliido", null, null, "email", Long.MIN_VALUE, null,
                    new Date(), null, null, null, null, null, null, null);
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, beneficiario, null,
                    null, null);

            List<AlumnosShortDTO> lAlumnos = new ArrayList<>();
            List<ModuloscicloShortDTO> lModulos = new ArrayList<>();
            AlumnosShortDTO idAlumno = new AlumnosShortDTO();
            idAlumno.setIdalumno(BigDecimal.ZERO);
            lAlumnos.add(idAlumno);
            ModuloscicloShortDTO idModulo = new ModuloscicloShortDTO();
            idModulo.setIdmodulociclo(0);
            lModulos.add(idModulo);

            List<Aprobacion> list = new ArrayList<>();
            Aprobacion aprobacion = new Aprobacion(BigDecimal.ZERO,
                    null, null, new Short("1"), new Short("1"),
                    new Short("1"), new Date());
            list.add(aprobacion);

            List<List<String>> registros = new ArrayList<>();
            List<String> aux = new ArrayList<>();
            String horas = "50";
            aux.add(horas);
            registros.add(aux);

            //PruebaOK #1 - Asistencia registrada exitosamente.
            when(moduloCicloDAO.traerModulo(any(long.class))).thenReturn(modulo);
            when(alumnosDAO.getAlumno(any(BigDecimal.class))).thenReturn(alumno);
            doNothing().when(seguimientoasistenciaDAO).registrarAsistenciaCapacitacion(
                    any(ArrayList.class), any(BigDecimal.class), any(long.class));
            when(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).thenReturn(list);
            when(enviar.notificarGenerica(any(int.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, lModulos, registros);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - aprobacionDAO.getAprobacionesPorProgramacion lanza una Exception
            given(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, lModulos, registros);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 1 --> OK");

            //PruebaERROR #2 - seguimientoasistenciaDAO.registrarAsistenciaCapacitacion lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(seguimientoasistenciaDAO).
                    registrarAsistenciaCapacitacion(any(ArrayList.class), any(BigDecimal.class), any(long.class));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, lModulos, registros);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 2 --> OK");

            //PruebaERROR #3 - moduloCicloDAO.traerModulo lanza una Exception
            given(moduloCicloDAO.traerModulo(any(long.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, lModulos, registros);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 3 --> OK");

            //PruebaERROR #4 - alumnosDAO.getAlumno lanza una Exception
            given(alumnosDAO.getAlumno(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacion(
                    BigDecimal.ONE, new Long(1), lAlumnos, lModulos, registros);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 4 --> OK");
            System.out.println("End Test: registrarAsistenciaCapacitacion");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): registrarAsistenciaCapacitacion");
        }
    }

    /**
     * Prueba unitaria del método registrarAsistenciaCapacitacionMasiva.
     * PU0069-REQ-UC48
     */
    @Test
    public void testRegistrarAsistenciaCapacitacionMasiva() {
        System.out.println("Start Test: registrarAsistenciaCapacitacionMasiva");
        try {
            ResponseAprobaciones result = new ResponseAprobaciones();
            Capacitacionprograma capacitacion = new Capacitacionprograma(0, null,
                    null, 0, "", new Date());
            Modulociclo modulo = new Modulociclo(0, capacitacion, "", new Short("1"), new Date());
            Beneficiario beneficiario = new Beneficiario(0, null, "Nombre",
                    "Apeliido", null, null, "email", Long.MIN_VALUE, null,
                    new Date(), null, null, null, null, null, null, null);
            Alumnos alumno = new Alumnos(BigDecimal.ZERO, beneficiario, null,
                    null, null);

            List<RequestCalificacionDTO> requestList = new ArrayList<>();
            RequestCalificacionDTO request = new RequestCalificacionDTO(
                    BigDecimal.ZERO, 0, new Short("10"));
            requestList.add(request);

            List<Aprobacion> list = new ArrayList<>();
            Aprobacion aprobacion = new Aprobacion(BigDecimal.ZERO,
                    null, null, new Short("1"), new Short("1"),
                    new Short("1"), new Date());
            list.add(aprobacion);

            //PruebaOK #1 - Asistencia registrada exitosamente.
            when(moduloCicloDAO.traerModulo(any(long.class))).thenReturn(modulo);
            when(alumnosDAO.getAlumno(any(BigDecimal.class))).thenReturn(alumno);
            doNothing().when(seguimientoasistenciaDAO).registrarAsistenciaCapacitacion(
                    any(ArrayList.class), any(BigDecimal.class), any(long.class));
            when(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).thenReturn(list);
            when(enviar.notificarGenerica(any(int.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - aprobacionDAO.getAprobacionesPorProgramacion lanza una Exception
            given(aprobacionDAO.getAprobacionesPorProgramacion(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 1 --> OK");

            //PruebaERROR #2 - seguimientoasistenciaDAO.registrarAsistenciaCapacitacion lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(seguimientoasistenciaDAO).
                    registrarAsistenciaCapacitacion(any(ArrayList.class), any(BigDecimal.class), any(long.class));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 2 --> OK");

            //PruebaERROR #3 - moduloCicloDAO.traerModulo lanza una Exception
            given(moduloCicloDAO.traerModulo(any(long.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 3 --> OK");

            //PruebaERROR #4 - alumnosDAO.getAlumno lanza una Exception
            given(alumnosDAO.getAlumno(any(BigDecimal.class))).willThrow(new Exception("Exception"));
            result = seguimientoasistenciaServicio.registrarAsistenciaCapacitacionMasiva(
                    requestList, new Long(1), BigDecimal.ONE);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR 4 --> OK");
            System.out.println("End Test: registrarAsistenciaCapacitacionMasiva");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): registrarAsistenciaCapacitacionMasiva");
        }
    }

}

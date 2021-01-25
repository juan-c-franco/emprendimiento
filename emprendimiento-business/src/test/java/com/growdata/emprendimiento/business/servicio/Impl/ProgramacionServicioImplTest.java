/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.ProgramacionServicioImpl;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.ProgramacionServicio;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import org.hibernate.HibernateException;
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
import org.springframework.core.env.Environment;

/**
 *
 * @author Juan Franco
 */
public class ProgramacionServicioImplTest {

    @Mock
    private ProgramacionDAO programacionDAO;
    @Mock
    private EnviarEmail mail;
    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private Environment env;

    @InjectMocks
    private ProgramacionServicio programacionServicio
            = new ProgramacionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Pruebas unitarias para el método saveProgramaciones. PU0064-REQ-UC46
     */
    @Test
    public void testSaveProgramaciones() {
        System.out.println("Start Test: saveProgramaciones");
        try {
            ResponseDTO result;

            Programacion programacion = new Programacion();

            //PruebaOK #1 - Guardar programaciones
            when(programacionDAO.saveProgramaciones(any(Programacion.class))).thenReturn(new Long(1));
            doNothing().when(mail).notificaProgramacionGenerica(any(int.class), any(Programacion.class));
            result = programacionServicio.saveProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - programacionDAO lanza HibernateException
            given(programacionDAO.saveProgramaciones(any(Programacion.class))).willThrow(new HibernateException("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.saveProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - programacionDAO lanza una Exception
            given(programacionDAO.saveProgramaciones(any(Programacion.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.saveProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: saveProgramaciones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): saveProgramaciones");
        }

    }

    /**
     * Pruebas unitarias para el método updateProgramaciones. PU0065-REQ-UC46
     */
    @Test
    public void testUpdateProgramaciones() {
        System.out.println("Start Test: updateProgramaciones");
        try {
            ResponseDTO result;

            Programacion programacion = new Programacion();

            //PruebaOK #1 - Actualizar programación.
            doNothing().when(programacionDAO).updateProgramaciones(any(Programacion.class));
            doNothing().when(mail).notificaProgramacionGenerica(any(int.class), any(Programacion.class));
            result = programacionServicio.updateProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - programacionDAO lanza HibernateException
            Mockito.doThrow(new HibernateException("Exception")).when(programacionDAO).updateProgramaciones(any(Programacion.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.updateProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - programacionDAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(programacionDAO).updateProgramaciones(any(Programacion.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.updateProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: updateProgramaciones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): updateProgramaciones");
        }
    }

    /**
     * Pruebas unitarias para el método deleteProgramaciones. PU0066-REQ-UC46
     */
    @Test
    public void testDeleteProgramaciones() {
        System.out.println("Start Test: deleteProgramaciones");
        try {
            ResponseDTO result;

            Programacion programacion = new Programacion();

            //PruebaOK #1 - Eliminar programación.
            doNothing().when(programacionDAO).deleteProgramaciones(any(Programacion.class));
            doNothing().when(mail).notificaProgramacionGenerica(any(int.class), any(Programacion.class));
            result = programacionServicio.deleteProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - programacionDAO lanza HibernateException
            Mockito.doThrow(new HibernateException("Exception")).when(programacionDAO).deleteProgramaciones(any(Programacion.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.deleteProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - programacionDAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(programacionDAO).deleteProgramaciones(any(Programacion.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = programacionServicio.deleteProgramaciones(programacion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: deleteProgramaciones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): deleteProgramaciones");
        }
    }

}

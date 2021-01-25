package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.SesionesServicioImpl;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.SesionesServicio;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
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

/**
 *
 * @author Juan Franco
 */
public class SesionesServicioImplTest {

    @Mock
    private SesionesDAO sesionesDAO;
    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private EnviarEmail mail;

    @InjectMocks
    private SesionesServicio sesionesServicio
            = new SesionesServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Test of getSesiones method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesiones_0args() {
//        System.out.println("getSesiones");
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        List<Sesiones> expResult = null;
//        List<Sesiones> result = instance.getSesiones();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesionesXFuncionario method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesionesXFuncionario() {
//        System.out.println("getSesionesXFuncionario");
//        long idFuncionario = 0L;
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        ResponseTraerSesiones expResult = null;
//        ResponseTraerSesiones result = instance.getSesionesXFuncionario(idFuncionario);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesiones method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesiones_long() {
//        System.out.println("getSesiones");
//        long saveIdSesion = 0L;
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        Sesiones expResult = null;
//        Sesiones result = instance.getSesiones(saveIdSesion);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria para el método saveSesiones. PU0010-REQ-UC03
     */
    @Test
    public void testSaveSesiones() {
        System.out.println("Start Test: saveSesiones");
        try {

            //PruebaOK #1 - Sesion programada exitosamente
            when(sesionesDAO.saveSesiones(any(Sesiones.class))).thenReturn(new Long("123"));
            ResponseDTO result = sesionesServicio.saveSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una HibernateException
            given(sesionesDAO.saveSesiones(any(Sesiones.class))).willThrow(new HibernateException("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesServicio.saveSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(sesionesDAO.saveSesiones(any(Sesiones.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesServicio.saveSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: saveSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): saveSesiones");
        }
    }

    /**
     * Prueba unitaria para el método updateSesiones. PU0013-REQ-UC03
     */
    @Test
    public void testUpdateSesiones() {
        System.out.println("Start Test: updateSesiones");
        try {

            //PruebaOK #1 - Sesion actualizada exitosamente
            doNothing().when(sesionesDAO).updateSesiones(any(Sesiones.class));
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            ResponseDTO result = sesionesServicio.updateSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una HibernateException
            Mockito.doThrow(new HibernateException("Exception")).when(sesionesDAO).updateSesiones(any(Sesiones.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            result = sesionesServicio.updateSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(sesionesDAO).updateSesiones(any(Sesiones.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            result = sesionesServicio.updateSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: updateSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): updateSesiones");
        }
    }

    /**
     * Prueba unitaria para el método deleteSesiones. PU0015-REQ-UC03
     */
    @Test
    public void testDeleteSesiones() {
        System.out.println("Start Test: deleteSesiones");
        try {

            //PruebaOK #1 - Sesion cancelada exitosamente
            doNothing().when(sesionesDAO).deleteSesiones(any(Sesiones.class));
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            ResponseDTO result = sesionesServicio.deleteSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(sesionesDAO).deleteSesiones(any(Sesiones.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            result = sesionesServicio.deleteSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: deleteSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): deleteSesiones");
        }
    }
//
//    /**
//     * Test of getSesionesPorFuncionario method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesionesPorFuncionario() {
//        System.out.println("getSesionesPorFuncionario");
//        long idFuncionario = 0L;
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        ResponseTraerSesiones expResult = null;
//        ResponseTraerSesiones result = instance.getSesionesPorFuncionario(idFuncionario);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesionesVXFuncionario method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesionesVXFuncionario() {
//        System.out.println("getSesionesVXFuncionario");
//        RequestTraerSesionesV request = null;
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        ResponseTraerSesiones expResult = null;
//        ResponseTraerSesiones result = instance.getSesionesVXFuncionario(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesionesPorFuncionarioTipoSesion method, of class SesionesServicioImpl.
//     */
//    @Test
//    public void testGetSesionesPorFuncionarioTipoSesion() {
//        System.out.println("getSesionesPorFuncionarioTipoSesion");
//        long idFuncionario = 0L;
//        BigDecimal tiposesion = null;
//        Date desde = null;
//        int todos = 0;
//        SesionesServicioImpl instance = new SesionesServicioImpl();
//        ResponseTraerSesiones expResult = null;
//        ResponseTraerSesiones result = instance.getSesionesPorFuncionarioTipoSesion(idFuncionario, tiposesion, desde, todos);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Prueba unitaria para el método liberarSesiones. PU0016-REQ-UC03
     */
    @Test
    public void testLiberarSesiones() {
        System.out.println("Start Test: liberarSesiones");
        try {

            //PruebaOK #1 - Sesion liberada exitosamente
            doNothing().when(sesionesDAO).liberarSesiones(any(Sesiones.class));
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            ResponseDTO result = sesionesServicio.liberarSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(sesionesDAO).liberarSesiones(any(Sesiones.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            doNothing().when(mail).notificaBeneficiariosGenerica(any(long.class), any(Sesiones.class));
            result = sesionesServicio.liberarSesiones(new Sesiones());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: liberarSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): liberarSesiones");
        }
    }
}

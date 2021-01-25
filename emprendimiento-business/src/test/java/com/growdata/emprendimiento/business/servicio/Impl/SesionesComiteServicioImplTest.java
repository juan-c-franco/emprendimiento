package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.SesionesComiteServicioImpl;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.SesionesComiteServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesComiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class SesionesComiteServicioImplTest {

    @Mock
    private Environment env;
    @Mock
    private LoggerEmprendimiento log;
    @Mock
    private SesionesComiteDAO sesionesComiteDAO;
    @Mock
    private PlantillaMailDAO plantillaMailDAO;
    @Mock
    private EmprendimientoDAO emprendimientoDAO;
    @Mock
    private EnviarEmail mail;

    @InjectMocks
    private SesionesComiteServicio sesionesComiteServicio
            = new SesionesComiteServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Test of getSesionesFuncionario method, of class SesionesComiteServicioImpl.
//     */
//    @Test
//    public void testGetSesionesFuncionario() {
//        System.out.println("getSesionesFuncionario");
//        long idFuncionario = 0L;
//        Date desde = null;
//        Date hasta = null;
//        int todas = 0;
//        SesionesComiteServicioImpl instance = new SesionesComiteServicioImpl();
//        ResponseTraerSesionesComite expResult = null;
//        ResponseTraerSesionesComite result = instance.getSesionesFuncionario(idFuncionario, desde, hasta, todas);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesionesFuncionarioComite method, of class SesionesComiteServicioImpl.
//     */
//    @Test
//    public void testGetSesionesFuncionarioComite() {
//        System.out.println("getSesionesFuncionarioComite");
//        long idFuncionario = 0L;
//        Date desde = null;
//        Date hasta = null;
//        int todas = 0;
//        SesionesComiteServicioImpl instance = new SesionesComiteServicioImpl();
//        ResponseTraerSesionesComite expResult = null;
//        ResponseTraerSesionesComite result = instance.getSesionesFuncionarioComite(idFuncionario, desde, hasta, todas);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria para el método saveSesiones. PU0037-REQ-UC24
     */
    @Test
    public void testSaveSesiones() {
        System.out.println("Start Test: saveSesiones");
        try {
            List<String> emprendimientos = new ArrayList<>();
            emprendimientos.add("123");

            Set<Integrantescomite> integrantescomites = new HashSet<Integrantescomite>(0);
            Funcionario funcionario = new Funcionario();
            funcionario.setPrimernombre("");
            funcionario.setPrimerapellido("");
            funcionario.setEmail("");
            Integrantescomite integrante = new Integrantescomite();
            integrante.setFuncionario(funcionario);
            integrantescomites.add(integrante);

            Comiteevaluacion comite = new Comiteevaluacion(BigDecimal.ONE, null, null, null, null, null, integrantescomites);
            Sesioncomite sesion = new Sesioncomite(123, comite, null, null, new Timestamp(0), new Timestamp(0), null, null, "");
            PlantillaMail plantilla = new PlantillaMail();
            plantilla.setAsunto("");
            plantilla.setPlantilla("");

            //PruebaOK #1 - Sesion programada exitosamente
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).thenReturn(new Long("123"));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            ResponseDTO result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El emprendimientoDAO devuelve null
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(null);
            when(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).thenReturn(new Long("123"));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - plantillaMailDAO devuelve null
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).thenReturn(new Long("123"));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(null);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - sesionesComiteDAO.getSesiones devuelve null
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            when(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).thenReturn(new Long("123"));
            given(sesionesComiteDAO.getSesiones(any(long.class))).willThrow(new Exception("Exception"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - El sesionesComiteDAO.saveSesiones lanza una HibernateException
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            given(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).willThrow(new HibernateException("Exception"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - El sesionesComiteDAO.saveSesiones lanza una Exception
            when(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).thenReturn(new Emprendimiento());
            given(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).willThrow(new Exception("Exception"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            //PruebaERROR #6 - El emprendimientoDAO lanza una Exception
            given(emprendimientoDAO.getEmprendimientoPorId(any(long.class))).willThrow(new Exception("Exception"));
            when(sesionesComiteDAO.saveSesiones(any(Sesioncomite.class), any(ArrayList.class))).thenReturn(new Long("123"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.saveSesiones(new Sesioncomite(), emprendimientos);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #6 --> OK");

            System.out.println("End Test: saveSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): saveSesiones");
        }
    }

    /**
     * Prueba unitaria para el método deleteSesiones. PU0061-REQ-UC24
     */
    @Test
    public void testDeleteSesiones() {
        System.out.println("Start Test: deleteSesiones");
        try {
            List<String> emprendimientos = new ArrayList<>();
            emprendimientos.add("123");

            Set<Integrantescomite> integrantescomites = new HashSet<Integrantescomite>(0);
            Funcionario funcionario = new Funcionario();
            funcionario.setPrimernombre("");
            funcionario.setPrimerapellido("");
            funcionario.setEmail("");
            Integrantescomite integrante = new Integrantescomite();
            integrante.setFuncionario(funcionario);
            integrantescomites.add(integrante);

            Comiteevaluacion comite = new Comiteevaluacion(BigDecimal.ONE, null, null, null, null, null, integrantescomites);
            Sesioncomite sesion = new Sesioncomite(123, comite, null, null, new Timestamp(0), new Timestamp(0), null, null, "");
            PlantillaMail plantilla = new PlantillaMail();
            plantilla.setAsunto("");
            plantilla.setPlantilla("");

            //PruebaOK #1 - Sesion programada exitosamente
            doNothing().when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            ResponseDTO result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - plantillaMailDAO devuelve null
            doNothing().when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(null);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - sesionesComiteDAO.getSesiones devuelve null
            doNothing().when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            given(sesionesComiteDAO.getSesiones(any(long.class))).willThrow(new Exception("Exception"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - El sesionesComiteDAO.updateSesiones lanza una HibernateException
            Mockito.doThrow(new HibernateException("Exception")).when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - El sesionesComiteDAO.updateSesiones lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - El emprendimientoDAO lanza una Exception
            doNothing().when(sesionesComiteDAO).deleteSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.deleteSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            System.out.println("End Test: deleteSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): deleteSesiones");
        }
    }

    /**
     * Prueba unitaria para el método updateSesiones. PU0060-REQ-UC24
     */
    @Test
    public void testUpdateSesiones() {
        System.out.println("Start Test: updateSesiones");
        try {
            List<String> emprendimientos = new ArrayList<>();
            emprendimientos.add("123");

            Set<Integrantescomite> integrantescomites = new HashSet<Integrantescomite>(0);
            Funcionario funcionario = new Funcionario();
            funcionario.setPrimernombre("");
            funcionario.setPrimerapellido("");
            funcionario.setEmail("");
            Integrantescomite integrante = new Integrantescomite();
            integrante.setFuncionario(funcionario);
            integrantescomites.add(integrante);

            Comiteevaluacion comite = new Comiteevaluacion(BigDecimal.ONE, null, null, null, null, null, integrantescomites);
            Sesioncomite sesion = new Sesioncomite(123, comite, null, null, new Timestamp(0), new Timestamp(0), null, null, "");
            PlantillaMail plantilla = new PlantillaMail();
            plantilla.setAsunto("");
            plantilla.setPlantilla("");

            //PruebaOK #1 - Sesion programada exitosamente
            doNothing().when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            ResponseDTO result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - plantillaMailDAO devuelve null
            doNothing().when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            when(sesionesComiteDAO.getSesiones(any(long.class))).thenReturn(sesion);
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(null);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - sesionesComiteDAO.getSesiones devuelve null
            doNothing().when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            given(sesionesComiteDAO.getSesiones(any(long.class))).willThrow(new Exception("Exception"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - El sesionesComiteDAO.updateSesiones lanza una HibernateException
            Mockito.doThrow(new HibernateException("Exception")).when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - El sesionesComiteDAO.updateSesiones lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - El emprendimientoDAO lanza una Exception
            doNothing().when(sesionesComiteDAO).updateSesiones(any(Sesioncomite.class));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(plantilla);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = sesionesComiteServicio.updateSesiones(new Sesioncomite());
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            System.out.println("End Test: updateSesiones");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): updateSesiones");
        }
    }
//
//    /**
//     * Test of getSesiones method, of class SesionesComiteServicioImpl.
//     */
//    @Test
//    public void testGetSesiones() {
//        System.out.println("getSesiones");
//        long id = 0L;
//        SesionesComiteServicioImpl instance = new SesionesComiteServicioImpl();
//        SesioncomiteDTO expResult = null;
//        SesioncomiteDTO result = instance.getSesiones(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

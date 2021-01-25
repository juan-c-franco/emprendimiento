package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.EmprendimientoServicioImpl;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;
import com.growdata.emprendimiento.business.servicio.EmprendimientoServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class EmprendimientoServicioImplTest {

    @Mock
    private EmprendimientoDAO emprendimientoDAO;

    @Mock
    private BeneficiarioDAO beneficiarioDAO;

    @Mock
    private PlantillaMailDAO plantillaMailDAO;

    @Mock
    private EnviarEmail mail;

    @Mock
    private Environment env;

    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private EmprendimientoServicio emprendimientoServicio
            = new EmprendimientoServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testGetEmprendimientoPorNombre() {
//        System.out.println("Start test: getEmprendimientoPorNombre");
//        RequestTraerEmprendimientoPorNombre request = new RequestTraerEmprendimientoPorNombre();
//        request.setNombreEmprendimiento("Emprendimiento");
//        request.setIdcajacompensacion(BigDecimal.ZERO);
//        List<String> estados = new ArrayList();
//        estados.add("1");
//        request.setEstados(estados);
//        List<Emprendimiento> emprendimientos = new ArrayList();
//        Emprendimiento emp = new Emprendimiento();
//        emp.setIdemprendimiento(123);
//        emp.setNombreemprendimiento("");
//        emp.setFecharegistro(new Date());
//        Tipoemprendimiento tipo = new Tipoemprendimiento();
//        tipo.setIdtipoemprendimiento(BigDecimal.ZERO);
//        tipo.setNombretipoemprendimiento("");
//        tipo.setDescripcion("");
//        emp.setTipoemprendimiento(tipo);
//        emprendimientos.add(emp);
//        //PruebaOK #1 - Emprendimiento traido exitosamente
//        try {
//            when(emprendimientoDAO.getEmprendimientoPorNombre(request.getNombreEmprendimiento(), request.getEstados(), request.getIdcajacompensacion())).thenReturn(emprendimientos);
//            ResponseTraerEmprendimientoPorNombre response = emprendimientoServicio.getEmprendimientoPorNombre(request);
//            assertThat(response.getStatus(), is(equalTo("1")));
//            assertThat(response, is(not(nullValue())));
//            System.out.println("    PruebaOK #1 --> OK");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            
//            System.out.println("End Test (Errores): getEmprendimientoPorNombre");
//        }
//    }
    /**
     * Prueba unitaria para el método guardarFormalizado. PU0019-REQ-UC10
     */
    @Test
    public void testGuardarFormalizado() {
        System.out.println("Start Test: guardarFormalizado");
        try {
            RequestRegistrarFormalizado request = new RequestRegistrarFormalizado(
                    Long.MIN_VALUE, new Long(123), Long.MIN_VALUE, BigDecimal.ZERO,
                    "aaa", "aaa", "aaa", "registroMercantil", "aaa", "aaa", Long.MIN_VALUE, 123, "aaa", "aaa",
                    "si", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO, new ArrayList<List<String>>(), new ArrayList<String>(),
                    Character.MIN_VALUE, "aaa", new Date(), new Date(), BigDecimal.TEN,
                    BigDecimal.ZERO, BigDecimal.ZERO, "aaa", 123, true);

            //PruebaOK #1 - Emprendimiento formalizado creado exitosamente
            when(emprendimientoDAO.guardarFormalizado(any(long.class), any(BigDecimal.class), any(String.class),
                    any(String.class), any(String.class), any(String.class), any(String.class), any(String.class),
                    any(Long.class), any(String.class), any(String.class), any(BigDecimal.class),
                    any(BigDecimal.class), any(BigDecimal.class), any(List.class), any(List.class),
                    any(Character.class), any(String.class), any(Date.class), any(Date.class),
                    any(BigDecimal.class), any(BigDecimal.class), any(BigDecimal.class),
                    any(int.class), any(int.class))).thenReturn(new Long("123"));
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            ResponseDTO result = emprendimientoServicio.guardarFormalizado(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una PersistenceException
            given(emprendimientoDAO.guardarFormalizado(any(long.class), any(BigDecimal.class), any(String.class),
                    any(String.class), any(String.class), any(String.class), any(String.class), any(String.class),
                    any(Long.class), any(String.class), any(String.class), any(BigDecimal.class),
                    any(BigDecimal.class), any(BigDecimal.class), any(List.class), any(List.class),
                    any(Character.class), any(String.class), any(Date.class), any(Date.class),
                    any(BigDecimal.class), any(BigDecimal.class), any(BigDecimal.class),
                    any(int.class), any(int.class))).willThrow(new Exception("Exception"));
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = emprendimientoServicio.guardarFormalizado(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: guardarFormalizado");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarFormalizado");
        }
    }

    /**
     * Prueba unitaria para el método guardarNoEstablecido. PU0020-REQ-UC10
     */
    @Test
    public void testGuardarNoEstablecido() {
        System.out.println("Start Test: guardarNoEstablecido");
        try {
            RequestNoEstablecido request = new RequestNoEstablecido(new Long(123),
                    BigDecimal.ZERO, "", BigDecimal.ZERO, BigDecimal.ONE,
                    BigDecimal.ZERO, new ArrayList<String>(), "", new Date(), "");

            //PruebaOK #1 - Emprendimiento no establecido creado exitosamente
            when(emprendimientoDAO.guardarNoEstablecido(any(Long.class),
                    any(BigDecimal.class), any(String.class), any(BigDecimal.class), any(BigDecimal.class),
                    any(BigDecimal.class), any(ArrayList.class), any(String.class), any(Date.class),
                    any(String.class), any(int.class))).thenReturn(new Long("123"));
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(any(Boolean.class));
            ResponseDTO result = emprendimientoServicio.guardarNoEstablecido(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una PersistenceException
            given(emprendimientoDAO.guardarNoEstablecido(any(Long.class),
                    any(BigDecimal.class), any(String.class), any(BigDecimal.class), any(BigDecimal.class),
                    any(BigDecimal.class), any(ArrayList.class), any(String.class), any(Date.class),
                    any(String.class), any(int.class))).willThrow(new Exception("Exception"));
            when(beneficiarioDAO.getBeneficiarioPorId(any(Long.class))).thenReturn(new Beneficiario());
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(env.getProperty(any(String.class))).thenReturn(new String("123"));
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(Boolean.TRUE);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = result = emprendimientoServicio.guardarNoEstablecido(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: guardarNoEstablecido");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarNoEstablecido");
        }
    }

//    /**
//     * Test of getEmprendimientoPorDoc method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientoPorDoc() {
//        System.out.println("getEmprendimientoPorDoc");
//        RequestEmprendimientoPorDocEstados request = null;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseTraerEmprendimientoPorNombre expResult = null;
//        ResponseTraerEmprendimientoPorNombre result = instance.getEmprendimientoPorDoc(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of updateEmprendimiento method, of class EmprendimientoServicioImpl.
     */
    @Test
    public void testUpdateEmprendimiento() {
        System.out.println("Start Test: updateEmprendimiento");
        try {
            RequestActualizarEmprendimiento request = new RequestActualizarEmprendimiento();
            EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
            List<BeneficiarioAATDTO> beneficiarios = new ArrayList<>();

            EstadoemprendimientoDTO estado = new EstadoemprendimientoDTO();
            estado.setIdestadoemprendimiento(BigDecimal.ZERO);
            estado.setNombreestadoemprendimiento("");
            estado.setDescripcion("");
            estado.setLogestadoemprendimientos(null);

            emprendimiento.setIdemprendimiento(123);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            request.setBeneficiarios(beneficiarios);
            request.setEmprendimiento(emprendimiento);

            //PruebaOK #1 - Emprendimiento actualizado exitosamente
            doNothing().when(emprendimientoDAO).updateEmprendimiento(any(Long.class), any(Estadoemprendimiento.class));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(true);
            ResponseActualizarEmprendimiento result = emprendimientoServicio.updateEmprendimiento(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            HibernateException e = new HibernateException("");
            Mockito.doThrow(e).when(emprendimientoDAO).updateEmprendimiento(any(Long.class), any(Estadoemprendimiento.class));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(mail.enviarEmail(any(String.class), any(String.class), any(String.class))).thenReturn(true);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = emprendimientoServicio.updateEmprendimiento(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");
            System.out.println("End Test: updateEmprendimiento");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): updateEmprendimiento");
        }
    }

//    /**
//     * Test of getEmprendimientoPorEdo method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientoPorEdo() {
//        System.out.println("getEmprendimientoPorEdo");
//        RequestEmprendimientoPorDocEstados request = null;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseTraerEmprendimientoPorNombre expResult = null;
//        ResponseTraerEmprendimientoPorNombre result = instance.getEmprendimientoPorEdo(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimientoPorId method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientoPorId() {
//        System.out.println("getEmprendimientoPorId");
//        RequestTraerEmprendimientoPorId request = null;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseTraerEmprendimientoPorId expResult = null;
//        ResponseTraerEmprendimientoPorId result = instance.getEmprendimientoPorId(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimientosComite method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientosComite() {
//        System.out.println("getEmprendimientosComite");
//        long idSesionComite = 0L;
//        int estadoEmprendimiento = 0;
//        BigDecimal idcajacompensacion = null;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseTraerEmprendimientoPorNombre expResult = null;
//        ResponseTraerEmprendimientoPorNombre result = instance.getEmprendimientosComite(idSesionComite, estadoEmprendimiento, idcajacompensacion);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimientosComitePorIdSesion method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientosComitePorIdSesion() {
//        System.out.println("getEmprendimientosComitePorIdSesion");
//        long idSesionComite = 0L;
//        int estadoEmprendimiento = 0;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseTraerEmprendimientoPorNombre expResult = null;
//        ResponseTraerEmprendimientoPorNombre result = instance.getEmprendimientosComitePorIdSesion(idSesionComite, estadoEmprendimiento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimientoCompleto method, of class EmprendimientoServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientoCompleto() {
//        System.out.println("getEmprendimientoCompleto");
//        RequestTraerEmprendimientoPorId request = null;
//        EmprendimientoServicioImpl instance = new EmprendimientoServicioImpl();
//        ResponseGetEmprendimientoCompleto expResult = null;
//        ResponseGetEmprendimientoCompleto result = instance.getEmprendimientoCompleto(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

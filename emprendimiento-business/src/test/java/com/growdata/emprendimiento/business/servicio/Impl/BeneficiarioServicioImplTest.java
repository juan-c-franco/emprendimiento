package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.BeneficiarioServicioImpl;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.BeneficiarioServicio;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.TipoDocumentoDAO;
import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Users;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Juan Carlos Franco Fecha: 19/02/2019
 */
public class BeneficiarioServicioImplTest {

    @Mock
    private BeneficiarioDAO beneficiarioDAO;

    @Mock
    private EnviarEmail enviar;

    @Mock
    private TipoDocumentoDAO tipoDAO;

    @Mock
    private LoggerEmprendimiento log;

    @Mock
    private FuncionarioDAO funcionarioDAO;

    @Mock
    private UsersDAO usersDAO;

    @InjectMocks
    private BeneficiarioServicio beneficiarioServicio
            = new BeneficiarioServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el método consultaBenfeficiario. PU0006-REQ-UC01
     */
    @Test
    public void testConsultaBenfeficiario() {
        System.out.println("Start Test: consultaBenfeficiario");
        try {
            MdFDatosBasicos beneficiario = new MdFDatosBasicos(123, BigDecimal.ZERO, BigDecimal.ONE);
            beneficiario.setTelefonoContacto("123");
            List<MdFDatosBasicos> list = new ArrayList();
            list.add(beneficiario);

            //PruebaOK #1 - Beneficiarios encontrados exitosamente
            when(beneficiarioDAO.consultaBeneficiario(any(String.class))).thenReturn(list);
            RequestFindBeneficiarioXDoc request = new RequestFindBeneficiarioXDoc();
            request.setDoc("123");
            ResponseFindBeneficiarioXDoc result = beneficiarioServicio.consultaBenfeficiario(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - Beneficiario no encontrado
            when(beneficiarioDAO.consultaBeneficiario(any(String.class))).thenReturn(new ArrayList<>());
            ResponseFindBeneficiarioXDoc result4 = beneficiarioServicio.consultaBenfeficiario(request);
            assertNotNull(result4);
            assertEquals("0", result4.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - Se intenta buscar un beneficiario con numero de documento ""
            request.setDoc("");
            ResponseFindBeneficiarioXDoc result3 = beneficiarioServicio.consultaBenfeficiario(request);
            assertNotNull(result3);
            assertEquals("0", result3.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - El DAO lanza una Exception
            given(beneficiarioDAO.consultaBeneficiario(any(String.class))).willThrow(Exception.class);
            ResponseFindBeneficiarioXDoc result2 = beneficiarioServicio.consultaBenfeficiario(request);
            assertNotNull(result2);
            assertEquals("0", result2.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");
            System.out.println("End Test: consultaBenfeficiario");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultaBenfeficiario");
        }
    }

    /**
     * Test of guardarBeneficiario method, of class BeneficiarioServicioImpl.
     */
    @Test
    public void testGuardarBeneficiario() {
        System.out.println("Start Test: guardarBeneficiario");
        try {
            ResponseBeneficiario result;
            Tipodocumentoid tipo = new Tipodocumentoid(BigDecimal.ONE);
            tipo.setNombredocumento("CC");
            Beneficiario beneficiario = new Beneficiario(123, tipo, "", "", "",
                    "", "", new Long(123), "123", new Date(), new Users(), null, null, null, null, null, null);

            //PruebaOK #1 - Beneficiario creado exitosamente
            when(beneficiarioDAO.guardarBeneficiario(any(Beneficiario.class))).thenReturn(beneficiario);
            when(funcionarioDAO.getFuncionarioPorCorreo(any(String.class))).thenReturn(null);
            when(usersDAO.getUserPorCorreo(any(String.class))).thenReturn(null);
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            RequestRegBeneficiario request = new RequestRegBeneficiario();
            request.setBeneficiario(beneficiario);
            request.setTipoDocumento("CC");
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - Email no válido
            when(beneficiarioDAO.consultaBeneficiario(any(String.class))).thenReturn(new ArrayList<>());
            when(enviar.validarEmail(any(String.class))).thenReturn(false);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - Tipo de documento no válido
            when(beneficiarioDAO.consultaBeneficiario(any(String.class))).thenReturn(new ArrayList<>());
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(null);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - El DAO lanza una Exception
            given(beneficiarioDAO.guardarBeneficiario(any(Beneficiario.class))).willThrow(Exception.class);
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - El DAO lanza una ConstraintViolationException
            given(beneficiarioDAO.guardarBeneficiario(any(Beneficiario.class))).willThrow(org.hibernate.exception.ConstraintViolationException.class);
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("2", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - El DAO lanza una PersistenceException
            given(beneficiarioDAO.guardarBeneficiario(any(Beneficiario.class))).willThrow(PersistenceException.class);
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("2", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            // PruebaERROR #6 - El correo pertenece a un funcionario
            when(beneficiarioDAO.guardarBeneficiario(any(Beneficiario.class))).thenReturn(beneficiario);
            when(funcionarioDAO.getFuncionarioPorCorreo(any(String.class))).thenReturn(new Funcionario());
            when(enviar.validarEmail(any(String.class))).thenReturn(true);
            when(tipoDAO.getTipoDocumentoIdPorNombre(any(String.class))).thenReturn(new Tipodocumentoid());
            request = new RequestRegBeneficiario();
            request.setBeneficiario(beneficiario);
            request.setTipoDocumento("CC");
            result = beneficiarioServicio.guardarBeneficiario(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #6 --> OK");
            System.out.println("End Test: guardarBeneficiario");

            System.out.println("End Test: guardarBeneficiario");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarBeneficiario");
        }
    }
//
//    /**
//     * Test of traerBeneficiario method, of class BeneficiarioServicioImpl.
//     */
//    @Test
//    public void testTraerBeneficiario() {
//        System.out.println("traerBeneficiario");
//        String numDoc = "";
//        BeneficiarioServicioImpl instance = new BeneficiarioServicioImpl();
//        BeneficiarioDTO expResult = null;
//        BeneficiarioDTO result = instance.traerBeneficiario(numDoc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBeneficiario method, of class BeneficiarioServicioImpl.
//     */
//    @Test
//    public void testGetBeneficiario_long() {
//        System.out.println("getBeneficiario");
//        long saveIdBeneficiario = 0L;
//        BeneficiarioServicioImpl instance = new BeneficiarioServicioImpl();
//        Beneficiario expResult = null;
//        Beneficiario result = instance.getBeneficiario(saveIdBeneficiario);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validaBeneficiario method, of class BeneficiarioServicioImpl.
//     */
//    @Test
//    public void testValidaBeneficiario() {
//        System.out.println("validaBeneficiario");
//        String doc = "";
//        String email = "";
//        BeneficiarioServicioImpl instance = new BeneficiarioServicioImpl();
//        boolean expResult = false;
//        boolean result = instance.validaBeneficiario(doc, email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBeneEmprTemasPorDocBeneficiario method, of class
//     * BeneficiarioServicioImpl.
//     */
//    @Test
//    public void testGetBeneEmprTemasPorDocBeneficiario() {
//        System.out.println("getBeneEmprTemasPorDocBeneficiario");
//        RequestTraerBeneEmprTemasPorDocBeneficiario request = null;
//        BeneficiarioServicioImpl instance = new BeneficiarioServicioImpl();
//        ResponseTraerBeneEmprTemasPorDocBeneficiario expResult = null;
//        ResponseTraerBeneEmprTemasPorDocBeneficiario result = instance.getBeneEmprTemasPorDocBeneficiario(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getBeneficiarioPorNombreYApellido method, of class
     * BeneficiarioServicioImpl.
     */
//    @Test
    public void testGetBeneficiarioPorNombreYApellido() {
        System.out.println("Start Test: getBeneficiarioPorNombreYApellido");
        try {
            MdFDatosBasicos beneficiario = new MdFDatosBasicos(123, BigDecimal.ZERO, BigDecimal.ONE);
            beneficiario.setTelefonoContacto("123");
            List<MdFDatosBasicos> list = new ArrayList();
            list.add(beneficiario);

            //PruebaOK #1 - Beneficiarios encontrados exitosamente
            when(beneficiarioDAO.getBeneficiarioPorNombreYApellido(any(String.class),
                    any(String.class), any(String.class), any(String.class))).thenReturn(list);
            RequestGetBeneficiarioXNombreYApellido request = new RequestGetBeneficiarioXNombreYApellido();
            request.setpNombre("Hola");
            request.setpApellido("Chao");
            ResponseGetBeneficiarioXNombreYApellido result = beneficiarioServicio.getBeneficiarioPorNombreYApellido(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - Beneficiario no encontrado
            when(beneficiarioDAO.getBeneficiarioPorNombreYApellido(any(String.class),
                    any(String.class), any(String.class), any(String.class))).thenReturn(new ArrayList<>());
            ResponseGetBeneficiarioXNombreYApellido result4 = beneficiarioServicio.getBeneficiarioPorNombreYApellido(request);
            assertNotNull(result4);
            assertEquals("0", result4.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - Se intenta buscar un beneficiario con numero de documento ""
            request.setpNombre("");
            request.setpApellido("");
            ResponseGetBeneficiarioXNombreYApellido result3 = beneficiarioServicio.getBeneficiarioPorNombreYApellido(request);
            assertNotNull(result3);
            assertEquals("0", result3.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - El DAO lanza una Exception
            given(beneficiarioDAO.consultaBeneficiario(any(String.class))).willThrow(Exception.class);
            ResponseGetBeneficiarioXNombreYApellido result2 = beneficiarioServicio.getBeneficiarioPorNombreYApellido(request);
            assertNotNull(result2);
            assertEquals("0", result2.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");
            System.out.println("End Test: getBeneficiarioPorNombreYApellido");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): getBeneficiarioPorNombreYApellido");
        }
    }

}

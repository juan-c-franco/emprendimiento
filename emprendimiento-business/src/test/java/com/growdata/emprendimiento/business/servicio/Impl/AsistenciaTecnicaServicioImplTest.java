package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.AsistenciaTecnicaServicioImpl;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestUpdateListasAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseUpdateListasAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;
import com.growdata.emprendimiento.business.servicio.AsistenciaTecnicaServicio;
import com.growdata.emprendimiento.persistence.DAO.AsistenciaTecnicaDAO;
import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Tipoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
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
public class AsistenciaTecnicaServicioImplTest {

    @Mock
    private AsistenciaTecnicaDAO asistenciaTecnicaDAO;

    @Mock
    private PlantillaMailDAO plantillaMailDAO;

    @Mock
    private AsociadoDAO asociadoDAO;

    @Mock
    private EmprendimientoDAO emprendimientoDAO;

    @Mock
    private TemasRutaCapacitacionDAO temasRutaCapacitacionDAO;

    @Mock
    private LoggerEmprendimiento log;

    @Mock
    private EnviarEmail enviar;

    @InjectMocks
    private AsistenciaTecnicaServicio asistenciaTecnicaServicio
            = new AsistenciaTecnicaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Test of getSesionesAAT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetSesionesAAT() {
//        System.out.println("getSesionesAAT");
//        RequestTraerSesionesAATPorFuncionario request = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerSesionesAATPorFuncionario expResult = null;
//        ResponseTraerSesionesAATPorFuncionario result = instance.getSesionesAAT(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria para el método guardarSesionAAT. PU0021-REQ-UC15
     */
    @Test
    public void testGuardarSesionAAT() {
        System.out.println("Start Test: guardarSesionAAT");
        try {

            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            SesionacompanamientoatDTO sesion = new SesionacompanamientoatDTO();
            sesion.setIdsesionacompanamientoat(-1);
            sesion.setRutaacompanamientoat(null);
            sesion.setTemasrutaacompanamientoat(null);
            EstadosesionDTO estado = new EstadosesionDTO(BigDecimal.TEN, "", "", null, null, null);
            sesion.setEstadosesion(estado);
            sesion.setObservaciones("");
            sesion.setFechafinal(new Timestamp(123));
            sesion.setFechainicio(new Timestamp(123));
            sesion.setFecharegistro(new Timestamp(123));
            sesion.setUbicacion("");
            FuncionarioDTO funcionario = new FuncionarioDTO();
            funcionario.setPrimernombre("");
            funcionario.setSegundonombre("");
            funcionario.setPrimerapellido("");
            funcionario.setSegundoapellido("");
            funcionario.setEmail("");
            funcionario.setTelefono(new Long(123));
            funcionario.setIdfuncionario(123);
            funcionario.setNumerodocumento("");
            sesion.setFuncionario(funcionario);

            request.setSesionAATDTO(sesion);

            List<Sesionacompanamientoat> lista = new ArrayList<Sesionacompanamientoat>();

            //PruebaOK #1 - Agregar sesion AAT
            when(asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(any(Sesionacompanamientoat.class))).thenReturn(lista);
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.setSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            ResponseGuardarSesionAAT result = asistenciaTecnicaServicio.guardarSesionAAT(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaOK #2 - Update sesion AAT
            request.getSesionAATDTO().setIdsesionacompanamientoat(1);
            when(asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(any(Sesionacompanamientoat.class))).thenReturn(lista);
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.setSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            result = asistenciaTecnicaServicio.guardarSesionAAT(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #2 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            when(asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(any(Sesionacompanamientoat.class))).thenReturn(lista);
            given(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).willThrow(new Exception("Exception"));
            given(asistenciaTecnicaDAO.setSesionAAT(any(Sesionacompanamientoat.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = asistenciaTecnicaServicio.guardarSesionAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            request.getSesionAATDTO().setIdsesionacompanamientoat(-1);
            when(asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(any(Sesionacompanamientoat.class))).thenReturn(lista);
            given(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).willThrow(new Exception("Exception"));
            given(asistenciaTecnicaDAO.setSesionAAT(any(Sesionacompanamientoat.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = asistenciaTecnicaServicio.guardarSesionAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - Existe solapamiento
            lista.add(new Sesionacompanamientoat());
            when(asistenciaTecnicaDAO.setSesionesAATPorSolapamiento(any(Sesionacompanamientoat.class))).thenReturn(lista);
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.setSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = asistenciaTecnicaServicio.guardarSesionAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            System.out.println("End Test: guardarSesionAAT");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): guardarSesionAAT");
        }
    }

    /**
     * Prueba unitaria para el método deleteSesionAAT. PU0022-REQ-UC15
     */
    @Test
    public void testDeleteSesionAAT() {
        System.out.println("Start Test: deleteSesionAAT");
        try {
            RequestEliminarSesionAAT request = new RequestEliminarSesionAAT();
            request.setIdSessionAAT(123);

            //PruebaOK #1 - Sesion cancelada exitosamente
            doNothing().when(asistenciaTecnicaDAO).deleteSesionAAT(any(long.class));
            ResponseDTO result = asistenciaTecnicaServicio.deleteSesionAAT(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(asistenciaTecnicaDAO).deleteSesionAAT(any(long.class));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = asistenciaTecnicaServicio.deleteSesionAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: deleteSesionAAT");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): deleteSesionAAT");
        }
    }
//
//    /**
//     * Test of getSesionAAT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetSesionAAT() {
//        System.out.println("getSesionAAT");
//        RequestTraerSesionAATPorId request = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerSesionAATPorId expResult = null;
//        ResponseTraerSesionAATPorId result = instance.getSesionAAT(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

    /**
     * Prueba unitaria para el método actualizarSesionAAT. PU0063-REQ-UC15
     */
//    @Test
    public void testActualizarSesionAAT() {
        System.out.println("Start Test: actualizarSesionAAT");
        try {
            RequestGuardarSesionAAT requestReservada = new RequestGuardarSesionAAT();

            EstadosesionDTO estadoReservada = new EstadosesionDTO(BigDecimal.ONE, "Reservada", "", null, null, null);
            EmprendimientoDTO emprendimiento = new EmprendimientoDTO();
            emprendimiento.setIdemprendimiento(123);
            RutaacompanamientoatDTO ruta = new RutaacompanamientoatDTO(0, emprendimiento, new Date(), null, null);
            TemasrutaacompanamientoatDTO temas = new TemasrutaacompanamientoatDTO(0,
                    null, null, new Date(), "", "", BigDecimal.ONE, 123, null);

            SesionacompanamientoatDTO sesionReservada = new SesionacompanamientoatDTO(1,
                    estadoReservada, ruta, temas, null, new Timestamp(0), new Timestamp(0),
                    new Timestamp(0), "", "");

            List<ListaasistenciaaatDTO> lista = new ArrayList<>();

            requestReservada.setListasAATDTO(lista);
            requestReservada.setSesionAATDTO(sesionReservada);

            //PruebaOK #1 - Sesion actualizada exitosamente
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getListaAAT(any(long.class))).thenReturn(new ArrayList<Listaasistenciaaat>());
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(long.class))).thenReturn(new ArrayList<Asociados>());
            doNothing().when(asistenciaTecnicaDAO).setListaAAT(any(ArrayList.class), any(Sesionacompanamientoat.class));
            ResponseGuardarSesionAAT result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - asistenciaTecnicaDAO.getListaAAT lanza una Exception
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getListaAAT(any(long.class))).thenThrow(new Exception("Exception"));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(long.class))).thenReturn(new ArrayList<Asociados>());
            doNothing().when(asistenciaTecnicaDAO).setListaAAT(any(ArrayList.class), any(Sesionacompanamientoat.class));
            result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - asistenciaTecnicaDAO.getListaAAT lanza una HibernateException
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(long.class))).thenReturn(new ArrayList<Asociados>());
            Mockito.doThrow(new HibernateException("Exception")).when(asistenciaTecnicaDAO).setListaAAT(any(ArrayList.class), any(Sesionacompanamientoat.class));
            result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            //PruebaERROR #3 - asistenciaTecnicaDAO.getListaAAT lanza una Exception
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(long.class))).thenReturn(new ArrayList<Asociados>());
            Mockito.doThrow(new Exception("Exception")).when(asistenciaTecnicaDAO).setListaAAT(any(ArrayList.class), any(Sesionacompanamientoat.class));
            result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");

            //PruebaERROR #4 - asociadoDAO.getAsociadosPorEmprendimiento lanza una Exception
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(long.class))).thenThrow(new Exception("Exception"));
            result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");

            //PruebaERROR #5 - asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema lanza una Exception
            when(asistenciaTecnicaDAO.updateSesionAAT(any(Sesionacompanamientoat.class))).thenReturn(new Long(123));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(long.class), any(long.class))).thenThrow(new Exception("Exception"));
            result = asistenciaTecnicaServicio.actualizarSesionAAT(requestReservada);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");

            System.out.println("End Test: actualizarSesionAAT");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): actualizarSesionAAT");
        }
    }
//
//    /**
//     * Test of getTemaRutaAAT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetTemaRutaAAT() {
//        System.out.println("getTemaRutaAAT");
//        RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerTemasRutaAAT expResult = null;
//        ResponseTraerTemasRutaAAT result = instance.getTemaRutaAAT(requestTraerTemasRutaAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSesionAATComplex method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetSesionAATComplex() {
//        System.out.println("getSesionAATComplex");
//        RequestTraerSesionAATPorId request = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerSesionAATComplexPorId expResult = null;
//        ResponseTraerSesionAATComplexPorId result = instance.getSesionAATComplex(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRutaAAT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetRutaAAT() {
//        System.out.println("getRutaAAT");
//        RequestTraerRutaAAT requestTraerRutaAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerRutaAAT expResult = null;
//        ResponseTraerRutaAAT result = instance.getRutaAAT(requestTraerRutaAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListaAAT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetListaAAT() {
//        System.out.println("getListaAAT");
//        RequestTraerListaAAT requestTraerListaAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerListaAAT expResult = null;
//        ResponseTraerListaAAT result = instance.getListaAAT(requestTraerListaAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateListasATT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testUpdateListasATT() {
//        System.out.println("updateListasATT");
//        RequestUpdateListasAAT requestUpdateListasAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseUpdateListasAAT expResult = null;
//        ResponseUpdateListasAAT result = instance.updateListasATT(requestUpdateListasAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimientos method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimientos() {
//        System.out.println("getEmprendimientos");
//        RequestTraerEmprendimientos requestEmprendimientos = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerEmprendimientos expResult = null;
//        ResponseTraerEmprendimientos result = instance.getEmprendimientos(requestEmprendimientos);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmprendimiento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetEmprendimiento() {
//        System.out.println("getEmprendimiento");
//        RequestTraerEmprendimiento requestTraerEmprendimiento = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerEmprendimiento expResult = null;
//        ResponseTraerEmprendimiento result = instance.getEmprendimiento(requestTraerEmprendimiento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTemasRutaATTPorEmprendimiento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetTemasRutaATTPorEmprendimiento() {
//        System.out.println("getTemasRutaATTPorEmprendimiento");
//        RequestTraerTemasRutaAAT requestTraerTemasRutaAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerListaTemasRutaAAT expResult = null;
//        ResponseTraerListaTemasRutaAAT result = instance.getTemasRutaATTPorEmprendimiento(requestTraerTemasRutaAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarTemaRutaATT method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGuardarTemaRutaATT() {
//        System.out.println("guardarTemaRutaATT");
//        RequestGuardarTemaRutaAAT requestGuardarTemaRutaAAT = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseGuardarTemaRutaAAT expResult = null;
//        ResponseGuardarTemaRutaAAT result = instance.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Prueba unitaria para el método consultarAvanceAAT. PU0024-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatOk1() throws Exception {
        System.out.println("Start Test: consultarAvanceAatOk1");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            System.out.println("End Test: consultarAvanceAatOk1");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatOk1");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError1. PU0025-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError1() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError1");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(null);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");
            System.out.println("End Test: consultarAvanceAatError1");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError1");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError2. PU0026-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError2() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError2");
        try {

            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(null);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");
            System.out.println("End Test: consultarAvanceAatError2");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError2");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError3. PU0027-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError3() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError3");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(null);
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #3 --> OK");
            System.out.println("End Test: consultarAvanceAatError3");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError3");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError4. PU0028-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError4() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError4");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            given(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).willThrow(new Exception("Exception"));
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #4 --> OK");
            System.out.println("End Test: consultarAvanceAatError4");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError4");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError5. PU0029-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError5() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError5");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            given(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).willThrow(new Exception("Exception"));
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #5 --> OK");
            System.out.println("End Test: consultarAvanceAatError5");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError5");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError6. PU0030-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError6() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError6");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            given(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).willThrow(new HibernateException("Exception"));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #6 --> OK");
            System.out.println("End Test: consultarAvanceAatError6");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError6");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError7. PU0031-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError7() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError7");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            given(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).willThrow(new Exception("Exception"));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #7 --> OK");
            System.out.println("End Test: consultarAvanceAatError7");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError7");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError8. PU0032-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError8() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError8");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            given(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).willThrow(new Exception("Exception"));
            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #8 --> OK");
            System.out.println("End Test: consultarAvanceAatError8");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError8");
        }
    }

    /**
     * Prueba unitaria para el método consultarAvanceAatError9. PU0033-REQ-UC18
     *
     * @throws java.lang.Exception
     */
    @Test
    public void consultarAvanceAatError9() throws Exception {
        System.out.println("Start Test: consultarAvanceAatError9");
        try {
            RequestConsultarAvance request = new RequestConsultarAvance();
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setIdemprendimiento(123);
            Estadoemprendimiento estado = new Estadoemprendimiento(
                    BigDecimal.ZERO, "", "", null, null);
            Tipoemprendimiento tipo = new Tipoemprendimiento(
                    BigDecimal.ZERO, "", "", null);
            emprendimiento.setTipoemprendimiento(tipo);
            emprendimiento.setEstadoemprendimiento(estado);
            emprendimiento.setNombreemprendimiento("");
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setAsociadoses(new HashSet<>(0));
            emprendimiento.setFormalizados(new HashSet<>(0));
            emprendimiento.setNoestablecidos(new HashSet<>(0));
            request.setEstadosEmprendimiento(new ArrayList<>());
            request.setEstadosSesion(new ArrayList<>());
            request.setIdCajaCompensacion(BigDecimal.ZERO);
            request.setNumeroDocumentoBen("");

            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
            tema1.setIdtemarutaacompanamientoat(123);
            tema1.setFecharegistro(new Date());
            tema1.setRutaacompanamientoat(ruta);
            tema1.setFecharegistro(new Date());
            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
            tema1.setDescripciondocumento("");
            tema1.setUrldocumentotema("");

            temasRutaAAT.add(tema1);

            List<Asociados> asociados = new ArrayList<>();

            Beneficiario beneficiario = new Beneficiario(123,
                    new Tipodocumentoid(BigDecimal.TEN, "", "", null, null, null),
                    "", "", "", "", "", Long.MIN_VALUE, "", new Date(),
                    new Users(), null, null, null, null, null, null);
            Asociados asociado = new Asociados(123, beneficiario, emprendimiento,
                    new Date(), Character.MIN_VALUE);
            asociados.add(asociado);

            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
                    any(List.class), any(String.class),
                    any(BigDecimal.class))).thenReturn(emprendimiento);
            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class), any(long.class))).thenReturn(new Float(123));
            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(asociados);
            given(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #9 --> OK");
            System.out.println("End Test: consultarAvanceAatError9");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): consultarAvanceAatError9");
        }
    }

//    /**
//     * Test of consultarAvanceAAT method, of class
//     * AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testConsultarAvanceAAT() {
//        System.out.println("Start Test: consultarAvanceAAT");
//        try {
//
//            RequestConsultarAvance request = new RequestConsultarAvance();
//            Emprendimiento emprendimiento = new Emprendimiento();
//            emprendimiento.setIdemprendimiento(123);
//            Estadoemprendimiento estado = new Estadoemprendimiento(
//                    BigDecimal.ZERO, "", "", null, null);
//            Tipoemprendimiento tipo = new Tipoemprendimiento(
//                    BigDecimal.ZERO, "", "", null);
//            emprendimiento.setTipoemprendimiento(tipo);
//            emprendimiento.setEstadoemprendimiento(estado);
//            emprendimiento.setNombreemprendimiento("");
//            emprendimiento.setFecharegistro(new Date());
//            emprendimiento.setAsociadoses(new HashSet<>(0));
//            emprendimiento.setFormalizados(new HashSet<>(0));
//            emprendimiento.setNoestablecidos(new HashSet<>(0));
//            request.setEstadosEmprendimiento(new ArrayList<>());
//            request.setEstadosSesion(new ArrayList<>());
//            request.setIdCajaCompensacion(BigDecimal.ZERO);
//            request.setNumeroDocumentoBen("");
//
//            List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList<>();
//            Temasrutaacompanamientoat tema1 = new Temasrutaacompanamientoat();
//            Rutaacompanamientoat ruta = new Rutaacompanamientoat(123, emprendimiento, new Date(), null, null);
//            tema1.setIdtemarutaacompanamientoat(123);
//            tema1.setFecharegistro(new Date());
//            tema1.setRutaacompanamientoat(ruta);
//            tema1.setFecharegistro(new Date());
//            tema1.setCantidadhorasplaneadas(BigDecimal.ONE);
//            tema1.setDescripciondocumento("");
//            tema1.setUrldocumentotema("");
//
//            temasRutaAAT.add(tema1);
//
//            //PruebaOK #1 - Se consulta efectivamente el avance
//            consultarAvanceAatOk1();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            ResponseConsultarAvance result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("1", result.getStatus());
////            System.out.println("    PruebaOK #1 --> OK");
//
//            //PruebaERROR #1 - El emprendimiento no existe
//            consultarAvanceAatError1();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(null);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #1 --> OK");
//
//            //PruebaERROR #2 - Los temasRutaAAT no existen
//            consultarAvanceAatError2();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(null);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #2 --> OK");
//
//            //PruebaERROR #3 - No hay asociados
//            consultarAvanceAatError3();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(null);
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #3 --> OK");
////
//            //PruebaERROR #4 - El emprendimientoDAO lanza un Exception
//            consultarAvanceAatError4();
////            given(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).willThrow(new Exception("Exception"));
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #4 --> OK");
//
//            //PruebaERROR #5 - asistenciaTecnicaDAO.getTemasRutaAAT lanza Exception
//            consultarAvanceAatError5();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            given(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).willThrow(new Exception("Exception"));
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #5 --> OK");
//
//            //PruebaERROR #6 - asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema lanza HibernateException
//            consultarAvanceAatError6();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            given(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).willThrow(new HibernateException("Exception"));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #6 --> OK");
//
//            //PruebaERROR #7 - asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema lanza Exception
//            consultarAvanceAatError7();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            given(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).willThrow(new Exception("Exception"));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #7 --> OK");
//
//            //PruebaERROR #8 - asociadoDAO lanza una Exception
//            consultarAvanceAatError8();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            given(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).willThrow(new Exception("Exception"));
////            when(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).thenReturn(new ArrayList<>());
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #8 --> OK");
//
//            //PruebaERROR #9 - temasRutaCapacitacionDAO lanza una Exception
//            consultarAvanceAatError9();
////            when(emprendimientoDAO.getEmprendimientoPorBeneficiarioYFuncionario(
////                    any(List.class), any(List.class), any(String.class),
////                    any(Long.class))).thenReturn(emprendimiento);
////            when(asistenciaTecnicaDAO.getTemasRutaAAT(any(Long.class))).thenReturn(temasRutaAAT);
////            when(asistenciaTecnicaDAO.getCantidadHorasEjecutadasPorTema(any(Long.class))).thenReturn(new Float(123));
////            when(asociadoDAO.getAsociadosPorEmprendimiento(any(Long.class))).thenReturn(new ArrayList<>());
////            given(temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(any(Long.class))).willThrow(new Exception("Exception"));
////            result = asistenciaTecnicaServicio.consultarAvanceAAT(request);
////            assertNotNull(result);
////            assertEquals("0", result.getStatus());
////            System.out.println("    PruebaERROR #9 --> OK");
//
//            System.out.println("End Test: consultarAvanceAAT");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            
//            System.out.println("End Test (Errores): consultarAvanceAAT");
//        }
//    }
//
//    /**
//     * Test of getEstadoEmprendimiento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetEstadoEmprendimiento() {
//        System.out.println("getEstadoEmprendimiento");
//        RequestTraerEstadoEmprendimiento requestTraerEstadoEmprendimiento = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerEstadoEmprendimiento expResult = null;
//        ResponseTraerEstadoEmprendimiento result = instance.getEstadoEmprendimiento(requestTraerEstadoEmprendimiento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetDocumento() {
//        System.out.println("getDocumento");
//        RequestTraerDocumentoComite requestTraerDocumentoComite = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerDocumentoComite expResult = null;
//        ResponseTraerDocumentoComite result = instance.getDocumento(requestTraerDocumentoComite);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTipoDocumento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetTipoDocumento() {
//        System.out.println("getTipoDocumento");
//        RequestTipoDocumento requestTipoDocumento = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTipoDocumento expResult = null;
//        ResponseTipoDocumento result = instance.getTipoDocumento(requestTipoDocumento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarDocumento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGuardarDocumento() {
//        System.out.println("guardarDocumento");
//        RequestGuardarDocumento requestGuardarDocumento = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseGuardarDocumento expResult = null;
//        ResponseGuardarDocumento result = instance.guardarDocumento(requestGuardarDocumento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumentos method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testGetDocumentos() {
//        System.out.println("getDocumentos");
//        RequestTraerDocumentos requestTraerDocumentos = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseTraerDocumentos expResult = null;
//        ResponseTraerDocumentos result = instance.getDocumentos(requestTraerDocumentos);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteDocumento method, of class AsistenciaTecnicaServicioImpl.
//     */
//    @Test
//    public void testDeleteDocumento() {
//        System.out.println("deleteDocumento");
//        RequestEliminarDocumento request = null;
//        AsistenciaTecnicaServicioImpl instance = new AsistenciaTecnicaServicioImpl();
//        ResponseEliminarDocumento expResult = null;
//        ResponseEliminarDocumento result = instance.deleteDocumento(request);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Prueba unitaria del método liberarSesiones. PU0023-REQ-UC15
     */
    @Test
    public void testLiberarSesiones() {
        System.out.println("Start Test: liberarSesionesAAT");
        try {

            Sesionacompanamientoat sesion = new Sesionacompanamientoat();
            sesion.setIdsesionacompanamientoat(123);

            //PruebaOK #1 - Sesion liberada exitosamente
            doNothing().when(asistenciaTecnicaDAO).liberarSesiones(any(Sesionacompanamientoat.class));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(asistenciaTecnicaDAO.getSesionAAT(any(Long.class))).thenReturn(new Sesionacompanamientoat());
            ResponseDTO result = asistenciaTecnicaServicio.liberarSesiones(sesion);
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una Exception
            Mockito.doThrow(new Exception("Exception")).when(asistenciaTecnicaDAO).liberarSesiones(any(Sesionacompanamientoat.class));
            when(plantillaMailDAO.consultaPlantillaXId(any(Long.class))).thenReturn(new PlantillaMail());
            when(asistenciaTecnicaDAO.getSesionAAT(any(Long.class))).thenReturn(new Sesionacompanamientoat());
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = asistenciaTecnicaServicio.liberarSesiones(sesion);
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            System.out.println("End Test: liberarSesionesAAT");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): liberarSesionesAAT");
        }
    }

    /**
     * Prueba unitaria para el metodo GuardarTemaRutaATT PU0034-REQ-UC17
     */
    @Test
    public void testGuardarTemaRutaATT() {
        System.out.println("Start Test: testGuardarTemaRutaATT");

        RequestGuardarTemaRutaAAT requestGuardarTemaRutaAAT = new RequestGuardarTemaRutaAAT();
        TemasrutaacompanamientoatDTO temaRutaAAT = new TemasrutaacompanamientoatDTO();
        temaRutaAAT.setIdtemarutaacompanamientoat(1);
        RutaacompanamientoatDTO rutaAAT = new RutaacompanamientoatDTO();
        rutaAAT.setIdrutaacompanamientoat(0);
        rutaAAT.setFecharegistro(new Date());
        temaRutaAAT.setRutaacompanamientoat(rutaAAT);
        TemasEvaluacionDTO temasevaluacion = new TemasEvaluacionDTO();
        temasevaluacion.setNombretema("tema");
        temasevaluacion.setDescripcion("descripcion");
        temasevaluacion.setFecharegistro(new Date());
        temasevaluacion.setHorasbasico(new BigDecimal(1));
        temasevaluacion.setIdtema(BigDecimal.TEN);
        temasevaluacion.setCalificacionbasico(Long.MIN_VALUE);
        temasevaluacion.setCalificacionintermedio(new BigDecimal(1));
        temasevaluacion.setHorasintermedio(Long.MIN_VALUE);
        temasevaluacion.setHorasavanzado(new BigDecimal(1));
        temasevaluacion.setCalificacionavanzado(new BigDecimal(1));
        temaRutaAAT.setTemasevaluacion(temasevaluacion);
        temaRutaAAT.setDescripciondocumento("descripcion");
        temaRutaAAT.setCantidadhorasplaneadas(new BigDecimal(2));
        temaRutaAAT.setDescripciondocumento("descripcion");
        temaRutaAAT.setUrldocumentotema("url");
        temaRutaAAT.setFecharegistro(new Date());
        requestGuardarTemaRutaAAT.setTemaRutaAAT(temaRutaAAT);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 TODO ok actualizar
            when(asistenciaTecnicaDAO.updateTemaRutaAAT(any(Temasrutaacompanamientoat.class))).thenReturn(new Long(1));
            ResponseGuardarTemaRutaAAT response = asistenciaTecnicaServicio.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 actualizar
            given(asistenciaTecnicaDAO.updateTemaRutaAAT(any(Temasrutaacompanamientoat.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = asistenciaTecnicaServicio.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba 2 TODO ok crear
            requestGuardarTemaRutaAAT.getTemaRutaAAT().setIdtemarutaacompanamientoat(0);
            when(asistenciaTecnicaDAO.setTemaRutaAAT(any(Temasrutaacompanamientoat.class))).thenReturn(new Long(1));
            response = asistenciaTecnicaServicio.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #2 --> OK");
            //PruebaError 2 crear
            requestGuardarTemaRutaAAT.getTemaRutaAAT().setIdtemarutaacompanamientoat(0);
            given(asistenciaTecnicaDAO.setTemaRutaAAT(any(Temasrutaacompanamientoat.class))).willThrow(excep);
            response = asistenciaTecnicaServicio.guardarTemaRutaATT(requestGuardarTemaRutaAAT);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");

        } catch (Exception execp) {
            System.out.println("End Test (Errores): testGuardarTemaRutaATT");
        }
        System.out.println("End Test: testGuardarTemaRutaATT");
    }

    /**
     * Prueba Unitaria para el metodo UpdateListasATT PU0018-REQ-UC16
     */
    @Test
    public void testUpdateListasATT() {
        System.out.println("Start Test: testUpdateListasATT");
        RequestUpdateListasAAT request = new RequestUpdateListasAAT();
        List<ListaasistenciaaatDTO> listasAATDTO = new ArrayList();
        ListaasistenciaaatDTO lista = new ListaasistenciaaatDTO();
        lista.setFecharegistro(new Date());
        lista.setIdasistacompanamientoat(0);
        lista.setJustificacioninasistencia(Character.MIN_SURROGATE);
        lista.setRegistroasistencia(Character.MIN_SURROGATE);
        SesionacompanamientoatDTO sesion = new SesionacompanamientoatDTO();
        sesion.setIdsesionacompanamientoat(0);
        sesion.setObservaciones("");
        sesion.setFechafinal(new Timestamp(0));
        sesion.setFechainicio(new Timestamp(0));
        sesion.setFecharegistro(new Timestamp(0));
        sesion.setUbicacion("");
        lista.setSesionacompanamientoat(sesion);
        Exception excep = new Exception("ex", new Exception("ex"));
        listasAATDTO.add(lista);
        request.setListasAATDTO(listasAATDTO);

        try {
            //Prueba 1 todo ok
            when(asistenciaTecnicaDAO.updateListaAAT(any(ArrayList.class))).thenReturn(new ArrayList());
            ResponseUpdateListasAAT response = asistenciaTecnicaServicio.updateListasATT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 
            given(asistenciaTecnicaDAO.updateListaAAT(any(ArrayList.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = asistenciaTecnicaServicio.updateListasATT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");

        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testUpdateListasATT");

        }

        System.out.println("End Test: testUpdateListasATT");

    }

    /**
     * Prueba Unitaria para el metodo GuardarDocumento PU0036-REQ-UC19
     * PU0045-REQ-UC31
     */
    @Test
    public void testGuardarDocumento() {
        System.out.println("Start Test: testGuardarDocumento");
        RequestGuardarDocumento request = new RequestGuardarDocumento();
        DocumentosDTO documento = new DocumentosDTO();
        documento.setFecharegistro(new Date());
        documento.setIddocumento(0);
        documento.setUrlarchivo("");
        request.setDocumento(documento);
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 Todo OK crear
            when(asistenciaTecnicaDAO.setDocumento(any(Documentos.class))).thenReturn(new Long(1));
            ResponseGuardarDocumento response = asistenciaTecnicaServicio.guardarDocumento(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 crear
            given(asistenciaTecnicaDAO.setDocumento(any(Documentos.class))).willThrow(excep);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(true);
            response = asistenciaTecnicaServicio.guardarDocumento(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
            //Prueba 2 Todo OK actualizar
            request.getDocumento().setIddocumento(1);
            when(asistenciaTecnicaDAO.updateDocumento(any(Documentos.class))).thenReturn(new Long(1));
            response = asistenciaTecnicaServicio.guardarDocumento(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #2 --> OK");
            //Prueba Error 2 actualizar
            given(asistenciaTecnicaDAO.updateDocumento(any(Documentos.class))).willThrow(excep);
            response = asistenciaTecnicaServicio.guardarDocumento(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testGuardarDocumento");
        }
        System.out.println("End Test: testGuardarDocumento");
    }

    /**
     * PU0018-REQ-UC16 Prueba unitaria para el metodo registrarAsistenciaAAT
     */
    @Test
    public void testRegistrarAsistenciaAAT() {
        System.out.println("Start Test: testRegistrarAsistenciaAAT");
        try {
            RequestGuardarSesionAAT request = new RequestGuardarSesionAAT();
            List<ListaasistenciaaatDTO> listasAATDTO = new ArrayList();
            ListaasistenciaaatDTO lista = new ListaasistenciaaatDTO();
            lista.setIdasistacompanamientoat(0);
            lista.setJustificacioninasistencia(Character.MIN_SURROGATE);
            lista.setRegistroasistencia(Character.MIN_SURROGATE);
            lista.setFecharegistro(new Date());
            SesionacompanamientoatDTO sesion = new SesionacompanamientoatDTO();
            sesion.setIdsesionacompanamientoat(0);
            lista.setSesionacompanamientoat(sesion);
            listasAATDTO.add(lista);
            request.setListasAATDTO(listasAATDTO);
            Exception excep = new Exception("ex", new Exception("ex"));
            List<CorreosAsistencias> correos = new ArrayList();
            CorreosAsistencias correo = new CorreosAsistencias();
            correo.setCorreo("");
            correo.setValor("Si");
            correo.setPrimerApellido("");
            correo.setPrimerNombre("");
            correos.add(correo);
            //Prueba 1 Todo OK Registrar
            when(asistenciaTecnicaDAO.updateListaAAT(any(ArrayList.class))).thenReturn(correos);
            ResponseDTO response = asistenciaTecnicaServicio.registrarAsistenciaAAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba 1 Error Registrar
            given(asistenciaTecnicaDAO.updateListaAAT(any(ArrayList.class))).willThrow(excep);
            response = asistenciaTecnicaServicio.registrarAsistenciaAAT(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    Prueba Error #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistrarAsistenciaAAT");
        }
        System.out.println("End Test: testRegistrarAsistenciaAAT");
    }
}

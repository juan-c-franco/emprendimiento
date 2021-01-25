package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.EvaluacionemprendimientosServicioImpl;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.EvaluacionemprendimientosServicio;
import com.growdata.emprendimiento.persistence.DAO.EvaluacionemprendimientosDAO;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.ArrayList;
import org.hibernate.HibernateException;
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
public class EvaluacionemprendimientosServicioImplTest {

    @Mock
    private EvaluacionemprendimientosDAO evaluacionEmprendimientosDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private EvaluacionemprendimientosServicio evaluacionemprendimientosServicio
            = new EvaluacionemprendimientosServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria del método calificacionDefinitiva. PU0038-REQ-UC25
     */
    @Test
    public void testCalificacionDefinitiva() {
        System.out.println("Start Test: calificacionDefinitiva");
        try {

            //PruebaOK #1 - Evaluación guardada exitosamente
            when(evaluacionEmprendimientosDAO.save(any(Sesioncomite.class), any(ArrayList.class), any(ArrayList.class), any(ArrayList.class))).thenReturn(new Long("123"));
            ResponseDTO result = evaluacionemprendimientosServicio.calificacionDefinitiva(123, new ArrayList<Character>(), new ArrayList<String>(), new ArrayList<Long>(), "");
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #1 - El DAO lanza una HibernateException
            given(evaluacionEmprendimientosDAO.save(any(Sesioncomite.class), any(ArrayList.class), any(ArrayList.class), any(ArrayList.class))).willThrow(new HibernateException("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = evaluacionemprendimientosServicio.calificacionDefinitiva(123, new ArrayList<Character>(), new ArrayList<String>(), new ArrayList<Long>(), "");
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(evaluacionEmprendimientosDAO.save(any(Sesioncomite.class), any(ArrayList.class), any(ArrayList.class), any(ArrayList.class))).willThrow(new Exception("Exception"));
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            result = evaluacionemprendimientosServicio.calificacionDefinitiva(123, new ArrayList<Character>(), new ArrayList<String>(), new ArrayList<Long>(), "");
            assertNotNull(result);
            assertEquals("0", result.getStatus());
            System.out.println("    PruebaERROR #2 --> OK");

            System.out.println("End Test: calificacionDefinitiva");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): calificacionDefinitiva");
        }
    }

}

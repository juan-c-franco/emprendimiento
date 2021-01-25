package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.ActividadInternacionalServicioImpl;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseActividadInternacional;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.ActividadInternacionalServicio;
import com.growdata.emprendimiento.persistence.DAO.ActividadInternacionalDAO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import java.util.ArrayList;
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
 * @author Juan Carlos Franco Fecha: 18/02/2019
 */
public class ActividadInternacionalServicioImplTest {

    @Mock
    private ActividadInternacionalDAO actividadInternacionalDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private ActividadInternacionalServicio actividadInternacionalServicio
            = new ActividadInternacionalServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test of getActividadesInternacionales method, of class
     * ActividadInternacionalServicioImpl.
     */
    @Test
    public void testGetActividadesInternacionales() {
        System.out.println("Start Test: getActividadesInternacionales");
        try {

            //PruebaOK #1 - El DAO devuelve una lista
            when(actividadInternacionalDAO.getActividadesInternacionales()).thenReturn(new ArrayList<Actividadinternacional>());
            ResponseActividadInternacional result = actividadInternacionalServicio.getActividadesInternacionales();
            assertNotNull(result);
            assertEquals("1", result.getStatus());
            System.out.println("    PruebaOK #1 --> OK");

            //PruebaERROR #2 - El DAO lanza una Exception
            given(actividadInternacionalDAO.getActividadesInternacionales()).willThrow(Exception.class);
            when(log.writeToLogFile(any(Exception.class))).thenReturn(Boolean.TRUE);
            ResponseActividadInternacional result2 = actividadInternacionalServicio.getActividadesInternacionales();
            assertNotNull(result2);
            assertEquals("0", result2.getStatus());
            System.out.println("    PruebaERROR #2--> OK");
            System.out.println("End Test: getActividadesInternacionales");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            System.out.println("End Test (Errores): getActividadesInternacionales");
        }
    }
}

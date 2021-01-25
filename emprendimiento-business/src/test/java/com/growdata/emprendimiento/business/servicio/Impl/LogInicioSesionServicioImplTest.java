/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.LogInicioSesionServicioImpl;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.RequestLogSesion;
import com.growdata.emprendimiento.business.servicio.LogInicioSesionServicio;
import com.growdata.emprendimiento.persistence.DAO.LogInicioSesionDAO;
import com.growdata.emprendimiento.persistence.entidad.Loginiciosesion;
import java.sql.Timestamp;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class LogInicioSesionServicioImplTest {

    @Mock
    private LogInicioSesionDAO logInicioSesionDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private LogInicioSesionServicio logInicioSesionServicio
            = new LogInicioSesionServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     *
     */
    public void testRegistrarLog() {
        System.out.println("Start Test: testRegistrarLog");
        RequestLogSesion request = new RequestLogSesion();
        request.setDate(new Timestamp(System.currentTimeMillis()));
        request.setUsername("username");
        Exception excep = new Exception("ex", new Exception("ex"));
        try {
            //Prueba 1 registrarlog exitosamente
            doNothing().when(logInicioSesionDAO).registrarLog(any(Loginiciosesion.class));
            //Prueba Error 1 dao lanza exception al registrarlog
            Mockito.doThrow(excep).when(logInicioSesionDAO).registrarLog(any(Loginiciosesion.class));

        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistrarLog");
        }
        System.out.println("End Test: testRegistrarLog");
    }

}

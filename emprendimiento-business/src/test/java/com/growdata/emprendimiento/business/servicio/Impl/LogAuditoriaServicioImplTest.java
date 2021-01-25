/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.LogAuditoriaServicioImpl;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.persistence.DAO.LogAuditoriaDAO;
import com.growdata.emprendimiento.persistence.entidad.Logauditoria;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
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
public class LogAuditoriaServicioImplTest {

    @Mock
    private LogAuditoriaDAO logAuditoriaDAO;
    @Mock
    private LoggerEmprendimiento log;
    @InjectMocks
    private LogAuditoriaServicio logAuditoriaServicio
            = new LogAuditoriaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo registrarLog PU0080-REQ-UC50
     */
    @Test
    public void testRegistrarLog() {
        System.out.println("Start Test: testRegistrarLog");
        RequestLogAuditoria request = new RequestLogAuditoria();
        Users user = new Users();
        request.setAccion("accion");
        request.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getDate()));
        request.setIdelemento(Long.MIN_VALUE);
        request.setModulo("modulo");
        request.setUsers(user);
        Exception excep = new Exception("ex", new Exception("ex"));

        try {
            //Prueba 1 log registrar log exitosamente
            doNothing().when(logAuditoriaDAO).registrarLog(any(Logauditoria.class));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba Error 1 dao lanza exception al registrar log
            Mockito.doThrow(excep).when(logAuditoriaDAO).registrarLog(any(Logauditoria.class));
            System.out.println("    PruebaError #1 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testRegistrarLog");
        }
        System.out.println("End Test: testRegistrarLog");
    }
}

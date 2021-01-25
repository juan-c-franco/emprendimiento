/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.RequestLogSesion;
import com.growdata.emprendimiento.persistence.DAO.LogInicioSesionDAO;
import com.growdata.emprendimiento.persistence.entidad.Loginiciosesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.growdata.emprendimiento.business.servicio.LogInicioSesionServicio;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class LogInicioSesionServicioImpl implements LogInicioSesionServicio {

    @Autowired
    private LogInicioSesionDAO logInicioSesionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que guarda registros en el log de inicio de sesion
     *
     * @param request Contiene el username y la fecha
     */
    @Override
    public void registrarLog(RequestLogSesion request) {
        try {
            Loginiciosesion logObj = new Loginiciosesion();
            logObj.setUsername(request.getUsername());
            logObj.setFecharegistro(request.getDate());
            logInicioSesionDAO.registrarLog(logObj);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
        }
    }

}

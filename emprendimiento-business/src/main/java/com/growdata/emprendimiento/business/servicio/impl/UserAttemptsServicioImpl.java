/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.UserAttemptsServicio;
import com.growdata.emprendimiento.persistence.DAO.UserAttemptsDAO;
import com.growdata.emprendimiento.persistence.entidad.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Service
public class UserAttemptsServicioImpl implements UserAttemptsServicio {

    @Autowired
    private UserAttemptsDAO userAttemptsDAO;

    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los intentos de login fallidos a partir de un username
     *
     * @param username El username al que se le van a traer los intentos
     * fallidos
     * @return Los intentos fallidos de un username
     */
    @Override
    public UserAttempts getUserAttempts(String username) {
        UserAttempts userAttempts = new UserAttempts();
        try {
            userAttempts = userAttemptsDAO.getUserAttempts(username);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return userAttempts;
    }
}

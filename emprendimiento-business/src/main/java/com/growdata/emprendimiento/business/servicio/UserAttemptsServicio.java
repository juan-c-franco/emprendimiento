/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.persistence.entidad.UserAttempts;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public interface UserAttemptsServicio {

    public UserAttempts getUserAttempts(String username);
}

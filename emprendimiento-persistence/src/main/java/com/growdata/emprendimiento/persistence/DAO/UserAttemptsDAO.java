/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.UserAttempts;

/**
 *
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */
public interface UserAttemptsDAO {
    
    public UserAttempts getUserAttempts(String username)throws Exception;
}

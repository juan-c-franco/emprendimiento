/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.commons;

import org.springframework.security.authentication.AccountStatusException;

/**
 * Exception a ser lanzada cuando las credenciales no coinciden.
 * 
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class CredencialesMalasException extends AccountStatusException {


    public CredencialesMalasException(String message) {
        super(message);
    }
}

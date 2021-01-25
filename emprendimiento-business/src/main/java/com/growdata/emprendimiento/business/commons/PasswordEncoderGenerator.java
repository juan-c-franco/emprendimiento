/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clasem encargada de encriptar una cadena de caracteres.
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
public class PasswordEncoderGenerator {

    /**
     * Metodo que encripta una contraseña.
     *
     * @param password Contraseña a encriptar
     * @return Contraseña encriptada
     */
    public String encriptar(String password) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        return hashedPassword;
    }

}

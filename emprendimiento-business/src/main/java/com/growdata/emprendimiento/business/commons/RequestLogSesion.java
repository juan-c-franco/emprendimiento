/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

import java.sql.Timestamp;

/**
 * Clase solicitud log sesión.
 *
 * @author Juan Franco
 */
public class RequestLogSesion {

    /**
     * Nombre de usuario.
     */
    private String username;
    /**
     * Fecha y hora.
     */
    private Timestamp date;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param username Valor a ser actualizado.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param date Valor a ser actualizado.
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

}

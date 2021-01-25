/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.entidad;

import java.util.Date;

public class UserAttempts {

    private int idUserAttempts;
    private String username;
    private int attempts;
    private Date lastModified;

    public int getIdUserAttempts() {
        return idUserAttempts;
    }

    public void setIdUserAttempts(int idUserAttempts) {
        this.idUserAttempts = idUserAttempts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

}

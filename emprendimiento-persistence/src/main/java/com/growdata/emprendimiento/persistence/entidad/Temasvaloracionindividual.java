/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.entidad;

public class Temasvaloracionindividual {

    private String nombretema;
    private long idtema;

    public String getNombretema() {
        return nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public long getIdtema() {
        return idtema;
    }

    public void setIdtema(long idtema) {
        this.idtema = idtema;
    }

    public Temasvaloracionindividual(String nombretema, long idtema) {
        this.idtema = idtema;
        this.nombretema = nombretema;
    }

    public Temasvaloracionindividual() {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestCrearCapacitacion {

    private long idoferenteinstitucion;
    private String nombrecapacitacionprograma;
    private long idcategoria;

    public long getIdoferenteinstitucion() {
        return idoferenteinstitucion;
    }

    public void setIdoferenteinstitucion(long idoferenteinstitucion) {
        this.idoferenteinstitucion = idoferenteinstitucion;
    }

    public String getNombrecapacitacionprograma() {
        return nombrecapacitacionprograma;
    }

    public void setNombrecapacitacionprograma(String nombrecapacitacionprograma) {
        this.nombrecapacitacionprograma = nombrecapacitacionprograma;
    }

    public long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

}

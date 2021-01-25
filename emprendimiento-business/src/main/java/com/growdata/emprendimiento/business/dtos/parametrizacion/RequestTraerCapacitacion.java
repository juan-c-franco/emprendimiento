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
public class RequestTraerCapacitacion {

    private long idcapacitacionprograma;

    public RequestTraerCapacitacion() {
    }

    public RequestTraerCapacitacion(long idcapacitacionprograma) {
        this.idcapacitacionprograma = idcapacitacionprograma;
    }

    public long getIdcapacitacionprograma() {
        return idcapacitacionprograma;
    }

    public void setIdcapacitacionprograma(long idcapacitacionprograma) {
        this.idcapacitacionprograma = idcapacitacionprograma;
    }

}

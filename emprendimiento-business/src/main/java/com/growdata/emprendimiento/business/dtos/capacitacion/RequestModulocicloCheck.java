/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class RequestModulocicloCheck {

    private long idmodulociclo;
    private List<Long> lineas;
    private Boolean invalid;

    public RequestModulocicloCheck(long idmodulociclo, Long linea, Boolean invalid) {
        this.idmodulociclo = idmodulociclo;
        this.lineas = new ArrayList<Long>();
        this.lineas.add(linea);
        this.invalid = invalid;
    }

    public long getIdmodulociclo() {
        return idmodulociclo;
    }

    public void setIdmodulociclo(long idmodulociclo) {
        this.idmodulociclo = idmodulociclo;
    }

    public List<Long> getLineas() {
        return lineas;
    }

    public void setLineas(List<Long> lineas) {
        this.lineas = lineas;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

}

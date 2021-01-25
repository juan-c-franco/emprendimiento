/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 *
 * @author Juan Franco
 */
public class ResponseRequisitos extends ResponseDTO {

    private String simpc;
    private String cesante;
    private String aportes;
    private String recobros;
    private String ultimaPrestacion;
    private boolean permiteRegistrar;

    public String getSimpc() {
        return simpc;
    }

    public void setSimpc(String simpc) {
        this.simpc = simpc;
    }

    public String getCesante() {
        return cesante;
    }

    public void setCesante(String cesante) {
        this.cesante = cesante;
    }

    public String getAportes() {
        return aportes;
    }

    public void setAportes(String aportes) {
        this.aportes = aportes;
    }

    public String getRecobros() {
        return recobros;
    }

    public void setRecobros(String recobros) {
        this.recobros = recobros;
    }

    public String getUltimaPrestacion() {
        return ultimaPrestacion;
    }

    public void setUltimaPrestacion(String ultimaPrestacion) {
        this.ultimaPrestacion = ultimaPrestacion;
    }

    public boolean isPermiteRegistrar() {
        return permiteRegistrar;
    }

    public void setPermiteRegistrar(boolean permiteRegistrar) {
        this.permiteRegistrar = permiteRegistrar;
    }
   
}

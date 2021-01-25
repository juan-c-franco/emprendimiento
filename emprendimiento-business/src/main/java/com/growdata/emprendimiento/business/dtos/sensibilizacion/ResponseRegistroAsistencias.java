package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseRegistroAsistencias extends ResponseDTO {

    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}

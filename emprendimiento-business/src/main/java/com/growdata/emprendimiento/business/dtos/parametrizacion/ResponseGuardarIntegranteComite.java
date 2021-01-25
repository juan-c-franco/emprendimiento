package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseGuardarIntegranteComite extends ResponseDTO {

    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}

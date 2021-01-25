package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseCrearEncuesta extends ResponseDTO {

    private long idEncuesta;

    public long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

}

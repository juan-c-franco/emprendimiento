package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseBuscarPregunta extends ResponseDTO {

    private DTOPregunta dtoPregunta;

    public DTOPregunta getDtoPregunta() {
        return dtoPregunta;
    }

    public void setDtoPregunta(DTOPregunta dtoPregunta) {
        this.dtoPregunta = dtoPregunta;
    }

}

package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseTraerTemaEvaluacion extends ResponseDTO {

    private TemasEvaluacionDTO temaEvaluacion;

    public TemasEvaluacionDTO getTemaEvaluacion() {
        return temaEvaluacion;
    }

    public void setTemaEvaluacion(TemasEvaluacionDTO temaEvaluacion) {
        this.temaEvaluacion = temaEvaluacion;
    }
}

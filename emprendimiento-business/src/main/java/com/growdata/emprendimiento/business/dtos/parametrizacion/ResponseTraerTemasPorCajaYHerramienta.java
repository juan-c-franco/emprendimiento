package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerTemasPorCajaYHerramienta extends ResponseDTO {

    private List<TemasEvaluacionDTO> temasEvaluacion;

    public List<TemasEvaluacionDTO> getTemasEvaluacion() {
        return temasEvaluacion;
    }

    public void setTemasEvaluacion(List<TemasEvaluacionDTO> temasEvaluacion) {
        this.temasEvaluacion = temasEvaluacion;
    }
}

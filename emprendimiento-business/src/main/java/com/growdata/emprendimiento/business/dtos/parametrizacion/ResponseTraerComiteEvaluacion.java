package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;

public class ResponseTraerComiteEvaluacion extends ResponseDTO {

    private ComiteevaluacionDTO comiteEvaluacionDTO;

    public ComiteevaluacionDTO getComiteEvaluacionDTO() {
        return comiteEvaluacionDTO;
    }

    public void setComiteEvaluacionDTO(ComiteevaluacionDTO comiteEvaluacionDTO) {
        this.comiteEvaluacionDTO = comiteEvaluacionDTO;
    }

}

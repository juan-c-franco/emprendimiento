package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseTraerPregunta extends ResponseDTO {

    private PreguntasTemaDTO preguntaTemaDTO;

    public PreguntasTemaDTO getPreguntaTemaDTO() {
        return preguntaTemaDTO;
    }

    public void setPreguntaTemaDTO(PreguntasTemaDTO preguntaTemaDTO) {
        this.preguntaTemaDTO = preguntaTemaDTO;
    }
}

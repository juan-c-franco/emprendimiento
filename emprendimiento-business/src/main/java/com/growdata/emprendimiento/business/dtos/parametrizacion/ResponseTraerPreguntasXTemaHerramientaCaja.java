package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerPreguntasXTemaHerramientaCaja extends ResponseDTO {

    private List<PreguntasTemaDTO> preguntasDTO;

    public List<PreguntasTemaDTO> getPreguntasDTO() {
        return preguntasDTO;
    }

    public void setPreguntasDTO(List<PreguntasTemaDTO> preguntasDTO) {
        this.preguntasDTO = preguntasDTO;
    }
}

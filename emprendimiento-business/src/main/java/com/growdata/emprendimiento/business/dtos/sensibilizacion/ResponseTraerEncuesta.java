package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import java.util.List;

public class ResponseTraerEncuesta extends ResponseDTO {

    private List<PreguntasDTO> preguntasDTO;

    public List<PreguntasDTO> getPreguntasDTO() {
        return preguntasDTO;
    }

    public void setPreguntasDTO(List<PreguntasDTO> preguntasDTO) {
        this.preguntasDTO = preguntasDTO;
    }

}

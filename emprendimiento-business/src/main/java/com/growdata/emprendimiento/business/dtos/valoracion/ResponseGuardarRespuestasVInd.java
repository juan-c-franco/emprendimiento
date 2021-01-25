package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import java.util.List;

public class ResponseGuardarRespuestasVInd extends ResponseDTO {

    private List<TemasrutacapacitacionDTO> temasRuta;

    public List<TemasrutacapacitacionDTO> getTemasRuta() {
        return temasRuta;
    }

    public void setTemasRuta(List<TemasrutacapacitacionDTO> temasRuta) {
        this.temasRuta = temasRuta;
    }

}

package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerTemasIndividuales extends ResponseDTO {

    private List<TemasvaloracionindividualDTO> temas;

    public List<TemasvaloracionindividualDTO> getTemas() {
        return temas;
    }

    public void setTemas(List<TemasvaloracionindividualDTO> temas) {
        this.temas = temas;
    }

}

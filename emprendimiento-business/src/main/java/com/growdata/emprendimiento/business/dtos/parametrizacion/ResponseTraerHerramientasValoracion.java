package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerHerramientasValoracion extends ResponseDTO {

    private List<HerramientaValoracionDTO> herramientasValoracionDTO;

    public List<HerramientaValoracionDTO> getHerramientasValoracionDTO() {
        return herramientasValoracionDTO;
    }

    public void setHerramientasValoracionDTO(List<HerramientaValoracionDTO> herramientasValoracionDTO) {
        this.herramientasValoracionDTO = herramientasValoracionDTO;
    }
}

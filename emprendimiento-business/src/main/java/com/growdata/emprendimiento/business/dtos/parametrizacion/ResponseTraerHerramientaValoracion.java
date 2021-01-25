package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseTraerHerramientaValoracion extends ResponseDTO {

    private HerramientaValoracionDTO herramientaValoracionDTO;

    public HerramientaValoracionDTO getHerramientaValoracionDTO() {
        return herramientaValoracionDTO;
    }

    public void setHerramientaValoracionDTO(HerramientaValoracionDTO herramientaValoracionDTO) {
        this.herramientaValoracionDTO = herramientaValoracionDTO;
    }
}

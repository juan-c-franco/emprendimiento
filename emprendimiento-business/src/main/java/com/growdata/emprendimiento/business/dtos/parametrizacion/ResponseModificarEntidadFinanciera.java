package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseModificarEntidadFinanciera extends ResponseDTO {

    private TraerEntidadesFinancierasDTO entidadDTO;

    public TraerEntidadesFinancierasDTO getEntidadDTO() {
        return entidadDTO;
    }

    public void setEntidadDTO(TraerEntidadesFinancierasDTO entidadDTO) {
        this.entidadDTO = entidadDTO;
    }

}

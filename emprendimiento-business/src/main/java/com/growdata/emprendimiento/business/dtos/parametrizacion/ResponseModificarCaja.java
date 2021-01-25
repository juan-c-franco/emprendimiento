package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseModificarCaja extends ResponseDTO {

    private CajacompensacionDTO cajaDTO;

    public CajacompensacionDTO getCajaDTO() {
        return cajaDTO;
    }

    public void setCajaDTO(CajacompensacionDTO cajaDTO) {
        this.cajaDTO = cajaDTO;
    }

}

package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;

public class RequestRegistrarCaja {

    private CajacompensacionDTO cajaDTO;

    public CajacompensacionDTO getCajaDTO() {
        return cajaDTO;
    }

    public void setCajaDTO(CajacompensacionDTO cajaDTO) {
        this.cajaDTO = cajaDTO;
    }

}

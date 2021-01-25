package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseTraerCajaPorFuncionario extends ResponseDTO {

    private CajacompensacionDTO cajacompensacion;

    public CajacompensacionDTO getCajacompensacion() {
        return cajacompensacion;
    }

    public void setCajacompensacion(CajacompensacionDTO cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }
}

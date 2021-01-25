package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerComiteEvaluacionPorCaja {

    private BigDecimal idCajaCompensacion;

    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }
}

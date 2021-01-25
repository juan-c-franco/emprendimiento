package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestModificarCaja {

    private BigDecimal idcajacompensacion;

    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

}

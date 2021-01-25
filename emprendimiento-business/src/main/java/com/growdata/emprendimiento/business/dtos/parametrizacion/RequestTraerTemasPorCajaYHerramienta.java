package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerTemasPorCajaYHerramienta {

    private BigDecimal idHerramienta;
    private BigDecimal idCajaCompensacion;

    public BigDecimal getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(BigDecimal idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }
}

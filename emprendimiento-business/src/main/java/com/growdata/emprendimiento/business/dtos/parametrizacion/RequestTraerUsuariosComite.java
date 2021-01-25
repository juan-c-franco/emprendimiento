package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerUsuariosComite {

    private BigDecimal idCajaCompensacion;
    private BigDecimal idEstado;

    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }
}

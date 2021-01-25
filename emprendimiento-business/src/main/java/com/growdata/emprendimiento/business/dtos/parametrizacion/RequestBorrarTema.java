package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestBorrarTema {

    private BigDecimal idTema;
    private BigDecimal idCajaCompensacion;
    private BigDecimal idHerramienta;

    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    public BigDecimal getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(BigDecimal idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public BigDecimal getIdTema() {
        return idTema;
    }

    public void setIdTema(BigDecimal idTema) {
        this.idTema = idTema;
    }

}

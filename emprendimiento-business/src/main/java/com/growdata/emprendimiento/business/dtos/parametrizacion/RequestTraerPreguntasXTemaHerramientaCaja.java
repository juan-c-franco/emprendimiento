package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerPreguntasXTemaHerramientaCaja {

    private BigDecimal idTema;
    private BigDecimal idHerramienta;
    private BigDecimal idCajaCompensacion;

    public BigDecimal getIdTema() {
        return idTema;
    }

    public void setIdTema(BigDecimal idTema) {
        this.idTema = idTema;
    }

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

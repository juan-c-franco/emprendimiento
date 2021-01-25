package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class GestionarFuncionarioDTO {

    private BigDecimal idcajacompensacion;
    private String nombrecajacompensacion;

    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

    public String getNombrecajacompensacion() {
        return nombrecajacompensacion;
    }

    public void setNombrecajacompensacion(String nombrecajacompensacion) {
        this.nombrecajacompensacion = nombrecajacompensacion;
    }

}

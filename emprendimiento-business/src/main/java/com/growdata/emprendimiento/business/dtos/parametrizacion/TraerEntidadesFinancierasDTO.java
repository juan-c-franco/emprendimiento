package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;
import java.util.Date;

public class TraerEntidadesFinancierasDTO {

    private BigDecimal identidadfinanciera;
    private String nombreentidad;
    private String descripcion;
    private Character estado;
    private Date fecharegistro;

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getIdentidadfinanciera() {
        return identidadfinanciera;
    }

    public void setIdentidadfinanciera(BigDecimal identidadfinanciera) {
        this.identidadfinanciera = identidadfinanciera;
    }

}

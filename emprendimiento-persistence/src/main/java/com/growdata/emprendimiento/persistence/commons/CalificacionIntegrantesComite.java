package com.growdata.emprendimiento.persistence.commons;

import java.math.BigDecimal;

public class CalificacionIntegrantesComite {

    private String primernombre;
    private String primerapellido;
    private BigDecimal calificacionindividual;

    public CalificacionIntegrantesComite(String primernombre, String primerapellido, BigDecimal calificacionindividual) {
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.calificacionindividual = calificacionindividual;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public BigDecimal getCalificacionindividual() {
        return calificacionindividual;
    }

    public void setCalificacionindividual(BigDecimal calificacionindividual) {
        this.calificacionindividual = calificacionindividual;
    }

}

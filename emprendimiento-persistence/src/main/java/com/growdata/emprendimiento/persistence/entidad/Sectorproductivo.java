package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Sectorproductivo implements java.io.Serializable {

    private BigDecimal idsectorproductivo;
    private String nombresectorproductivo;
    private String descripcion;
    private Set<Formalizado> formalizados = new HashSet<Formalizado>(0);
    private Set<Noestablecido> noestablecidos = new HashSet<Noestablecido>(0);

    public Sectorproductivo() {
    }

    public Sectorproductivo(BigDecimal idsectorproductivo, String nombresectorproductivo) {
        this.idsectorproductivo = idsectorproductivo;
        this.nombresectorproductivo = nombresectorproductivo;
    }

    public Sectorproductivo(BigDecimal idsectorproductivo, String nombresectorproductivo, String descripcion, Set<Formalizado> formalizados, Set<Noestablecido> noestablecidos) {
        this.idsectorproductivo = idsectorproductivo;
        this.nombresectorproductivo = nombresectorproductivo;
        this.descripcion = descripcion;
        this.formalizados = formalizados;
        this.noestablecidos = noestablecidos;
    }

    public BigDecimal getIdsectorproductivo() {
        return this.idsectorproductivo;
    }

    public void setIdsectorproductivo(BigDecimal idsectorproductivo) {
        this.idsectorproductivo = idsectorproductivo;
    }

    public String getNombresectorproductivo() {
        return this.nombresectorproductivo;
    }

    public void setNombresectorproductivo(String nombresectorproductivo) {
        this.nombresectorproductivo = nombresectorproductivo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Formalizado> getFormalizados() {
        return this.formalizados;
    }

    public void setFormalizados(Set<Formalizado> formalizados) {
        this.formalizados = formalizados;
    }

    public Set<Noestablecido> getNoestablecidos() {
        return this.noestablecidos;
    }

    public void setNoestablecidos(Set<Noestablecido> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

}

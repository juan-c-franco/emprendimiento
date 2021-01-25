package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipoconstitucionlegal implements java.io.Serializable {

    private BigDecimal idtipoconstitucionlegal;
    private String nombretipoconstitucionlegal;
    private String descripcion;
    private Set<Noestablecido> noestablecidos = new HashSet<Noestablecido>(0);
    private Set<Formalizado> formalizados = new HashSet<Formalizado>(0);

    public Tipoconstitucionlegal() {
    }

    public Tipoconstitucionlegal(BigDecimal idtipoconstitucionlegal, String nombretipoconstitucionlegal) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
    }

    public Tipoconstitucionlegal(BigDecimal idtipoconstitucionlegal, String nombretipoconstitucionlegal, String descripcion, Set<Noestablecido> noestablecidos, Set<Formalizado> formalizados) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
        this.descripcion = descripcion;
        this.noestablecidos = noestablecidos;
        this.formalizados = formalizados;
    }

    public BigDecimal getIdtipoconstitucionlegal() {
        return this.idtipoconstitucionlegal;
    }

    public void setIdtipoconstitucionlegal(BigDecimal idtipoconstitucionlegal) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
    }

    public String getNombretipoconstitucionlegal() {
        return this.nombretipoconstitucionlegal;
    }

    public void setNombretipoconstitucionlegal(String nombretipoconstitucionlegal) {
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Noestablecido> getNoestablecidos() {
        return this.noestablecidos;
    }

    public void setNoestablecidos(Set<Noestablecido> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

    public Set<Formalizado> getFormalizados() {
        return this.formalizados;
    }

    public void setFormalizados(Set<Formalizado> formalizados) {
        this.formalizados = formalizados;
    }

}

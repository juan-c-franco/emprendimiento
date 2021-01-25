package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Actividadinternacional implements java.io.Serializable {

    private BigDecimal idactividadinternacional;
    private String nombreactividadinternacional;
    private String descripcion;
    private Set<Formalizado> formalizados = new HashSet<Formalizado>(0);

    public Actividadinternacional() {
    }

    public Actividadinternacional(BigDecimal idactividadinternacional, String nombreactividadinternacional) {
        this.idactividadinternacional = idactividadinternacional;
        this.nombreactividadinternacional = nombreactividadinternacional;
    }

    public Actividadinternacional(BigDecimal idactividadinternacional, String nombreactividadinternacional, String descripcion, Set<Formalizado> formalizados) {
        this.idactividadinternacional = idactividadinternacional;
        this.nombreactividadinternacional = nombreactividadinternacional;
        this.descripcion = descripcion;
        this.formalizados = formalizados;
    }

    public BigDecimal getIdactividadinternacional() {
        return this.idactividadinternacional;
    }

    public void setIdactividadinternacional(BigDecimal idactividadinternacional) {
        this.idactividadinternacional = idactividadinternacional;
    }

    public String getNombreactividadinternacional() {
        return this.nombreactividadinternacional;
    }

    public void setNombreactividadinternacional(String nombreactividadinternacional) {
        this.nombreactividadinternacional = nombreactividadinternacional;
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

}

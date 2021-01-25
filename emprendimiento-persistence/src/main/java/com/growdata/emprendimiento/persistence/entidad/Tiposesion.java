package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tiposesion implements java.io.Serializable {

    private BigDecimal idtiposesion;
    private String nombresesion;
    private String descripcion;
    private Set<Sesiones> sesioneses = new HashSet<Sesiones>(0);

    public Tiposesion() {
    }

    public Tiposesion(BigDecimal idtiposesion) {
        this.idtiposesion = idtiposesion;
    }

    public Tiposesion(BigDecimal idtiposesion, String nombresesion, String descripcion, Set<Sesiones> sesioneses) {
        this.idtiposesion = idtiposesion;
        this.nombresesion = nombresesion;
        this.descripcion = descripcion;
        this.sesioneses = sesioneses;
    }

    public BigDecimal getIdtiposesion() {
        return this.idtiposesion;
    }

    public void setIdtiposesion(BigDecimal idtiposesion) {
        this.idtiposesion = idtiposesion;
    }

    public String getNombresesion() {
        return this.nombresesion;
    }

    public void setNombresesion(String nombresesion) {
        this.nombresesion = nombresesion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Sesiones> getSesioneses() {
        return this.sesioneses;
    }

    public void setSesioneses(Set<Sesiones> sesioneses) {
        this.sesioneses = sesioneses;
    }

}

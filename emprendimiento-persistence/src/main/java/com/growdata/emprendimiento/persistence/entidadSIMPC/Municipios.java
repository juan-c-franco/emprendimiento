package com.growdata.emprendimiento.persistence.entidadSIMPC;
// Generated 18/07/2019 02:40:02 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Municipios generated by hbm2java
 */
public class Municipios implements java.io.Serializable {

    private BigDecimal id;
    private Departamentos departamentos;
    private String divipola;
    private String nombre;
    private Set<Sedes> sedeses = new HashSet<Sedes>(0);

    public Municipios() {
    }

    public Municipios(BigDecimal id, Departamentos departamentos, String nombre) {
        this.id = id;
        this.departamentos = departamentos;
        this.nombre = nombre;
    }

    public Municipios(BigDecimal id, Departamentos departamentos, String divipola, String nombre, Set<Sedes> sedeses) {
        this.id = id;
        this.departamentos = departamentos;
        this.divipola = divipola;
        this.nombre = nombre;
        this.sedeses = sedeses;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Departamentos getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public String getDivipola() {
        return this.divipola;
    }

    public void setDivipola(String divipola) {
        this.divipola = divipola;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Sedes> getSedeses() {
        return this.sedeses;
    }

    public void setSedeses(Set<Sedes> sedeses) {
        this.sedeses = sedeses;
    }

}
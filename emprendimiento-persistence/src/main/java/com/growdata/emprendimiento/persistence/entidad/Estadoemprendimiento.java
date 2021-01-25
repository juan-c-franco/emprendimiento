package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Estadoemprendimiento implements java.io.Serializable {

    private BigDecimal idestadoemprendimiento;
    private String nombreestadoemprendimiento;
    private String descripcion;
    private Set<Emprendimiento> emprendimientos = new HashSet<Emprendimiento>(0);
    private Set<Logestadoemprendimiento> logestadoemprendimientos = new HashSet<Logestadoemprendimiento>(0);

    public Estadoemprendimiento() {
    }

    public Estadoemprendimiento(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    public Estadoemprendimiento(BigDecimal idestadoemprendimiento, String nombreestadoemprendimiento, String descripcion, Set<Emprendimiento> emprendimientos, Set<Logestadoemprendimiento> logestadoemprendimientos) {
        this.idestadoemprendimiento = idestadoemprendimiento;
        this.nombreestadoemprendimiento = nombreestadoemprendimiento;
        this.descripcion = descripcion;
        this.emprendimientos = emprendimientos;
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

    public BigDecimal getIdestadoemprendimiento() {
        return this.idestadoemprendimiento;
    }

    public void setIdestadoemprendimiento(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    public String getNombreestadoemprendimiento() {
        return this.nombreestadoemprendimiento;
    }

    public void setNombreestadoemprendimiento(String nombreestadoemprendimiento) {
        this.nombreestadoemprendimiento = nombreestadoemprendimiento;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Emprendimiento> getEmprendimientos() {
        return this.emprendimientos;
    }

    public void setEmprendimientos(Set<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    public Set<Logestadoemprendimiento> getLogestadoemprendimientos() {
        return this.logestadoemprendimientos;
    }

    public void setLogestadoemprendimientos(Set<Logestadoemprendimiento> logestadoemprendimientos) {
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

}

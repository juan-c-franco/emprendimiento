package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipoemprendimiento implements java.io.Serializable {

    private BigDecimal idtipoemprendimiento;
    private String nombretipoemprendimiento;
    private String descripcion;
    private Set<Emprendimiento> emprendimientos = new HashSet<Emprendimiento>(0);

    public Tipoemprendimiento() {
    }

    public Tipoemprendimiento(BigDecimal idtipoemprendimiento) {
        this.idtipoemprendimiento = idtipoemprendimiento;
    }

    public Tipoemprendimiento(BigDecimal idtipoemprendimiento, String nombretipoemprendimiento, String descripcion, Set<Emprendimiento> emprendimientos) {
        this.idtipoemprendimiento = idtipoemprendimiento;
        this.nombretipoemprendimiento = nombretipoemprendimiento;
        this.descripcion = descripcion;
        this.emprendimientos = emprendimientos;
    }

    public BigDecimal getIdtipoemprendimiento() {
        return this.idtipoemprendimiento;
    }

    public void setIdtipoemprendimiento(BigDecimal idtipoemprendimiento) {
        this.idtipoemprendimiento = idtipoemprendimiento;
    }

    public String getNombretipoemprendimiento() {
        return this.nombretipoemprendimiento;
    }

    public void setNombretipoemprendimiento(String nombretipoemprendimiento) {
        this.nombretipoemprendimiento = nombretipoemprendimiento;
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

}

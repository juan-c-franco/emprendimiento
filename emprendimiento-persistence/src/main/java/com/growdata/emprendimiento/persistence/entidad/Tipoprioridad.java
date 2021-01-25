package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipoprioridad implements java.io.Serializable {

    private BigDecimal idtipoprioridad;
    private String nombreprioridad;
    private String descripcion;
    private Set<Evaluacionemprendimientos> evaluacionemprendimientoses = new HashSet<Evaluacionemprendimientos>(0);

    public Tipoprioridad() {
    }

    public Tipoprioridad(BigDecimal idtipoprioridad) {
        this.idtipoprioridad = idtipoprioridad;
    }

    public Tipoprioridad(BigDecimal idtipoprioridad, String nombreprioridad, String descripcion, Set<Evaluacionemprendimientos> evaluacionemprendimientoses) {
        this.idtipoprioridad = idtipoprioridad;
        this.nombreprioridad = nombreprioridad;
        this.descripcion = descripcion;
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

    public BigDecimal getIdtipoprioridad() {
        return this.idtipoprioridad;
    }

    public void setIdtipoprioridad(BigDecimal idtipoprioridad) {
        this.idtipoprioridad = idtipoprioridad;
    }

    public String getNombreprioridad() {
        return this.nombreprioridad;
    }

    public void setNombreprioridad(String nombreprioridad) {
        this.nombreprioridad = nombreprioridad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Evaluacionemprendimientos> getEvaluacionemprendimientoses() {
        return this.evaluacionemprendimientoses;
    }

    public void setEvaluacionemprendimientoses(Set<Evaluacionemprendimientos> evaluacionemprendimientoses) {
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

}

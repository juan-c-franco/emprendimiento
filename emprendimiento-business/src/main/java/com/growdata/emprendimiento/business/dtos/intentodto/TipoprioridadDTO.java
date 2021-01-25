package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipoprioridadDTO implements java.io.Serializable {

    private BigDecimal idtipoprioridad;
    private String nombreprioridad;
    private String descripcion;
    private Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos = new HashSet<EvaluacionemprendimientoDTO>(0);

    public TipoprioridadDTO() {
    }

    public TipoprioridadDTO(BigDecimal idtipoprioridad) {
        this.idtipoprioridad = idtipoprioridad;
    }

    public TipoprioridadDTO(BigDecimal idtipoprioridad, String nombreprioridad, String descripcion, Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos) {
        this.idtipoprioridad = idtipoprioridad;
        this.nombreprioridad = nombreprioridad;
        this.descripcion = descripcion;
        this.evaluacionemprendimientos = evaluacionemprendimientos;
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

    public Set<EvaluacionemprendimientoDTO> getEvaluacionemprendimientos() {
        return this.evaluacionemprendimientos;
    }

    public void setEvaluacionemprendimientos(Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos) {
        this.evaluacionemprendimientos = evaluacionemprendimientos;
    }

}

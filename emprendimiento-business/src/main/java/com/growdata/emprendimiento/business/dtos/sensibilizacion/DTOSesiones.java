package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.persistence.entidad.Evaluacionemprendimientos;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class DTOSesiones {

    private long idSesion;
    private String descripcion;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private String ubicacion;
    private long maxAsistentes;
    private BigDecimal idestadosesion;
    private long idfuncionario;
    private Set<Evaluacionemprendimientos> evaluacionemprendimientoses = new HashSet<Evaluacionemprendimientos>(0);

    public long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(long idSesion) {
        this.idSesion = idSesion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public long getMaxAsistentes() {
        return maxAsistentes;
    }

    public void setMaxAsistentes(long maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

    public BigDecimal getIdestadosesion() {
        return idestadosesion;
    }

    public void setIdestadosesion(BigDecimal idestadosesion) {
        this.idestadosesion = idestadosesion;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Set<Evaluacionemprendimientos> getEvaluacionemprendimientoses() {
        return evaluacionemprendimientoses;
    }

    public void setEvaluacionemprendimientoses(Set<Evaluacionemprendimientos> evaluacionemprendimientoses) {
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

}

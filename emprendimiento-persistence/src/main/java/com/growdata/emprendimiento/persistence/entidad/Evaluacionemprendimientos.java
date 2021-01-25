package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Evaluacionemprendimientos implements java.io.Serializable {

    private long idevaluacion;
    private Emprendimiento emprendimiento;
    private Sesioncomite sesioncomite;
    private Tipoprioridad tipoprioridad;
    private Date fecharegistro;
    private BigDecimal calificacionfinal;
    private Character aprobado;
    private String observaciones;
    private Date fechaevaluacion;
    private Set<Evaluacionintegrantescomite> evaluacionintegrantescomites = new HashSet<Evaluacionintegrantescomite>(0);

    public Evaluacionemprendimientos() {
    }

    public Evaluacionemprendimientos(long idevaluacion, Emprendimiento emprendimiento, Tipoprioridad tipoprioridad) {
        this.idevaluacion = idevaluacion;
        this.emprendimiento = emprendimiento;
        this.tipoprioridad = tipoprioridad;
    }

    public Evaluacionemprendimientos(long idevaluacion, Emprendimiento emprendimiento, Sesioncomite sesioncomite, Tipoprioridad tipoprioridad, Date fecharegistro, BigDecimal calificacionfinal, Character aprobado, String observaciones, Date fechaevaluacion, Set<Evaluacionintegrantescomite> evaluacionintegrantescomites) {
        this.idevaluacion = idevaluacion;
        this.emprendimiento = emprendimiento;
        this.sesioncomite = sesioncomite;
        this.tipoprioridad = tipoprioridad;
        this.fecharegistro = fecharegistro;
        this.calificacionfinal = calificacionfinal;
        this.aprobado = aprobado;
        this.observaciones = observaciones;
        this.fechaevaluacion = fechaevaluacion;
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

    public long getIdevaluacion() {
        return this.idevaluacion;
    }

    public void setIdevaluacion(long idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Sesioncomite getSesioncomite() {
        return this.sesioncomite;
    }

    public void setSesioncomite(Sesioncomite sesioncomite) {
        this.sesioncomite = sesioncomite;
    }

    public Tipoprioridad getTipoprioridad() {
        return this.tipoprioridad;
    }

    public void setTipoprioridad(Tipoprioridad tipoprioridad) {
        this.tipoprioridad = tipoprioridad;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getCalificacionfinal() {
        return this.calificacionfinal;
    }

    public void setCalificacionfinal(BigDecimal calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

    public Character getAprobado() {
        return this.aprobado;
    }

    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaevaluacion() {
        return this.fechaevaluacion;
    }

    public void setFechaevaluacion(Date fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    public Set<Evaluacionintegrantescomite> getEvaluacionintegrantescomites() {
        return this.evaluacionintegrantescomites;
    }

    public void setEvaluacionintegrantescomites(Set<Evaluacionintegrantescomite> evaluacionintegrantescomites) {
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Observacionesseguimiento implements java.io.Serializable {

    private long idobservacion;
    private Funcionario funcionario;
    private Seguimiento seguimiento;
    private String observacion;
    private Date fecharegistro;

    public Observacionesseguimiento() {
    }

    public Observacionesseguimiento(long idobservacion, Funcionario funcionario, Seguimiento seguimiento) {
        this.idobservacion = idobservacion;
        this.funcionario = funcionario;
        this.seguimiento = seguimiento;
    }

    public Observacionesseguimiento(long idobservacion, Funcionario funcionario, Seguimiento seguimiento, String observacion, Date fecharegistro) {
        this.idobservacion = idobservacion;
        this.funcionario = funcionario;
        this.seguimiento = seguimiento;
        this.observacion = observacion;
        this.fecharegistro = fecharegistro;
    }

    public long getIdobservacion() {
        return this.idobservacion;
    }

    public void setIdobservacion(long idobservacion) {
        this.idobservacion = idobservacion;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Seguimiento getSeguimiento() {
        return this.seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

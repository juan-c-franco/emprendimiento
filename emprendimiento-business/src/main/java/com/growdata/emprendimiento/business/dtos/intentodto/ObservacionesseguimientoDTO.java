package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class ObservacionesseguimientoDTO implements java.io.Serializable {

    private long idobservaciones;
    private FuncionarioDTO funcionario;
    private SeguimientoDTO seguimiento;
    private String observacion;
    private Date fecharegistro;

    public ObservacionesseguimientoDTO() {
    }

    public ObservacionesseguimientoDTO(long idobservaciones, FuncionarioDTO funcionario, SeguimientoDTO seguimiento) {
        this.idobservaciones = idobservaciones;
        this.funcionario = funcionario;
        this.seguimiento = seguimiento;
    }

    public ObservacionesseguimientoDTO(long idobservaciones, FuncionarioDTO funcionario, SeguimientoDTO seguimiento, String observacion, Date fecharegistro) {
        this.idobservaciones = idobservaciones;
        this.funcionario = funcionario;
        this.seguimiento = seguimiento;
        this.observacion = observacion;
        this.fecharegistro = fecharegistro;
    }

    public long getIdobservaciones() {
        return this.idobservaciones;
    }

    public void setIdobservaciones(long idobservaciones) {
        this.idobservaciones = idobservaciones;
    }

    public FuncionarioDTO getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public SeguimientoDTO getSeguimiento() {
        return this.seguimiento;
    }

    public void setSeguimiento(SeguimientoDTO seguimiento) {
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

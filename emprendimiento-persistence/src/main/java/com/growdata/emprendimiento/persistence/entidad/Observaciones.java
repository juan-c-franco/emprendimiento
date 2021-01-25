package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Observaciones implements java.io.Serializable {

    private long idobservacion;
    private Documentos documentos;
    private Funcionario funcionario;
    private String observacion;
    private Date fecharegistro;

    public Observaciones() {
    }

    public Observaciones(long idobservacion, Funcionario funcionario) {
        this.idobservacion = idobservacion;
        this.funcionario = funcionario;
    }

    public Observaciones(long idobservacion, Documentos documentos, Funcionario funcionario, String observacion, Date fecharegistro) {
        this.idobservacion = idobservacion;
        this.documentos = documentos;
        this.funcionario = funcionario;
        this.observacion = observacion;
        this.fecharegistro = fecharegistro;
    }

    public long getIdobservacion() {
        return this.idobservacion;
    }

    public void setIdobservacion(long idobservacion) {
        this.idobservacion = idobservacion;
    }

    public Documentos getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

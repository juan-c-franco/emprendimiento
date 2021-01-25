package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Asociados implements java.io.Serializable {

    private long idasociado;
    private Beneficiario beneficiario;
    private Emprendimiento emprendimiento;
    private Date fecharegistro;
    private Character lider;

    public Asociados() {
    }

    public Asociados(long idasociado, Beneficiario beneficiario, Emprendimiento emprendimiento) {
        this.idasociado = idasociado;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
    }

    public Asociados(long idasociado, Beneficiario beneficiario, Emprendimiento emprendimiento, Date fecharegistro, Character lider) {
        this.idasociado = idasociado;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.fecharegistro = fecharegistro;
        this.lider = lider;
    }

    public long getIdasociado() {
        return this.idasociado;
    }

    public void setIdasociado(long idasociado) {
        this.idasociado = idasociado;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Character getLider() {
        return this.lider;
    }

    public void setLider(Character lider) {
        this.lider = lider;
    }

}

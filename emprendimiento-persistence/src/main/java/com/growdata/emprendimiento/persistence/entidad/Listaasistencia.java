package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Listaasistencia implements java.io.Serializable {

    private long idasistencia;
    private Beneficiario beneficiario;
    private Sesiones sesiones;
    private Date fecharegistro;
    private Character registroasistencia;
    private Character justificacioninasistencia;

    public Listaasistencia() {
    }

    public Listaasistencia(long idasistencia, Beneficiario beneficiario, Sesiones sesiones) {
        this.idasistencia = idasistencia;
        this.beneficiario = beneficiario;
        this.sesiones = sesiones;
    }

    public Listaasistencia(long idasistencia, Beneficiario beneficiario, Sesiones sesiones, Date fecharegistro, Character registroasistencia, Character justificacioninasistencia) {
        this.idasistencia = idasistencia;
        this.beneficiario = beneficiario;
        this.sesiones = sesiones;
        this.fecharegistro = fecharegistro;
        this.registroasistencia = registroasistencia;
        this.justificacioninasistencia = justificacioninasistencia;
    }

    public long getIdasistencia() {
        return this.idasistencia;
    }

    public void setIdasistencia(long idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Sesiones getSesiones() {
        return this.sesiones;
    }

    public void setSesiones(Sesiones sesiones) {
        this.sesiones = sesiones;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Character getRegistroasistencia() {
        return this.registroasistencia;
    }

    public void setRegistroasistencia(Character registroasistencia) {
        this.registroasistencia = registroasistencia;
    }

    public Character getJustificacioninasistencia() {
        return this.justificacioninasistencia;
    }

    public void setJustificacioninasistencia(Character justificacioninasistencia) {
        this.justificacioninasistencia = justificacioninasistencia;
    }

}

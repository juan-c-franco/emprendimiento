package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Listaasistenciaaat implements java.io.Serializable {

    private long idasistenciaacompanamientoat;
    private Beneficiario beneficiario;
    private Sesionacompanamientoat sesionacompanamientoat;
    private Date fecharegistro;
    private Character registroasistencia;
    private Character justificacioninasistencia;

    public Listaasistenciaaat() {
    }

    public Listaasistenciaaat(long idasistenciaacompanamientoat, Beneficiario beneficiario, Sesionacompanamientoat sesionacompanamientoat) {
        this.idasistenciaacompanamientoat = idasistenciaacompanamientoat;
        this.beneficiario = beneficiario;
        this.sesionacompanamientoat = sesionacompanamientoat;
    }

    public Listaasistenciaaat(long idasistenciaacompanamientoat, Beneficiario beneficiario, Sesionacompanamientoat sesionacompanamientoat, Date fecharegistro, Character registroasistencia, Character justificacioninasistencia) {
        this.idasistenciaacompanamientoat = idasistenciaacompanamientoat;
        this.beneficiario = beneficiario;
        this.sesionacompanamientoat = sesionacompanamientoat;
        this.fecharegistro = fecharegistro;
        this.registroasistencia = registroasistencia;
        this.justificacioninasistencia = justificacioninasistencia;
    }

    public long getIdasistenciaacompanamientoat() {
        return this.idasistenciaacompanamientoat;
    }

    public void setIdasistenciaacompanamientoat(long idasistenciaacompanamientoat) {
        this.idasistenciaacompanamientoat = idasistenciaacompanamientoat;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Sesionacompanamientoat getSesionacompanamientoat() {
        return this.sesionacompanamientoat;
    }

    public void setSesionacompanamientoat(Sesionacompanamientoat sesionacompanamientoat) {
        this.sesionacompanamientoat = sesionacompanamientoat;
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

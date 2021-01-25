package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Encuesta implements java.io.Serializable {

    private long idencuesta;
    private Beneficiario beneficiario;
    private Tipoencuesta tipoencuesta;
    private Date fechaenvio;
    private Date fechavigencia;
    private Date fechadiligenciamiento;
    private Character diligenciada;
    private Set<Respuestasencuesta> respuestasencuestas = new HashSet<Respuestasencuesta>(0);

    public Encuesta() {
    }

    public Encuesta(long idencuesta, Beneficiario beneficiario, Tipoencuesta tipoencuesta) {
        this.idencuesta = idencuesta;
        this.beneficiario = beneficiario;
        this.tipoencuesta = tipoencuesta;
    }

    public Encuesta(long idencuesta, Beneficiario beneficiario, Tipoencuesta tipoencuesta, Date fechaenvio, Date fechavigencia, Date fechadiligenciamiento, Character diligenciada, Set<Respuestasencuesta> respuestasencuestas) {
        this.idencuesta = idencuesta;
        this.beneficiario = beneficiario;
        this.tipoencuesta = tipoencuesta;
        this.fechaenvio = fechaenvio;
        this.fechavigencia = fechavigencia;
        this.fechadiligenciamiento = fechadiligenciamiento;
        this.diligenciada = diligenciada;
        this.respuestasencuestas = respuestasencuestas;
    }

    public long getIdencuesta() {
        return this.idencuesta;
    }

    public void setIdencuesta(long idencuesta) {
        this.idencuesta = idencuesta;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Tipoencuesta getTipoencuesta() {
        return this.tipoencuesta;
    }

    public void setTipoencuesta(Tipoencuesta tipoencuesta) {
        this.tipoencuesta = tipoencuesta;
    }

    public Date getFechaenvio() {
        return this.fechaenvio;
    }

    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public Date getFechavigencia() {
        return this.fechavigencia;
    }

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public Date getFechadiligenciamiento() {
        return this.fechadiligenciamiento;
    }

    public void setFechadiligenciamiento(Date fechadiligenciamiento) {
        this.fechadiligenciamiento = fechadiligenciamiento;
    }

    public Character getDiligenciada() {
        return this.diligenciada;
    }

    public void setDiligenciada(Character diligenciada) {
        this.diligenciada = diligenciada;
    }

    public Set<Respuestasencuesta> getRespuestasencuestas() {
        return this.respuestasencuestas;
    }

    public void setRespuestasencuestas(Set<Respuestasencuesta> respuestasencuestas) {
        this.respuestasencuestas = respuestasencuestas;
    }

}

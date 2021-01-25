package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class ListaasistenciaDTO implements java.io.Serializable {

    private long idasistencia;
    private BeneficiarioDTO beneficiario;
    private SesionesDTO sesiones;
    private Date fecharegistro;
    private Character registroasistencia;
    private Character justificacionInasistencia;

    public ListaasistenciaDTO() {
    }

    public ListaasistenciaDTO(long idasistencia, BeneficiarioDTO beneficiario, SesionesDTO sesiones) {
        this.idasistencia = idasistencia;
        this.beneficiario = beneficiario;
        this.sesiones = sesiones;
    }

    public ListaasistenciaDTO(long idasistencia, BeneficiarioDTO beneficiario, SesionesDTO sesiones, Date fecharegistro, Character registroasistencia) {
        this.idasistencia = idasistencia;
        this.beneficiario = beneficiario;
        this.sesiones = sesiones;
        this.fecharegistro = fecharegistro;
        this.registroasistencia = registroasistencia;
    }

    public long getIdasistencia() {
        return this.idasistencia;
    }

    public void setIdasistencia(long idasistencia) {
        this.idasistencia = idasistencia;
    }

    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public SesionesDTO getSesiones() {
        return this.sesiones;
    }

    public void setSesiones(SesionesDTO sesiones) {
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

    public Character getJustificacionInasistencia() {
        return justificacionInasistencia;
    }

    public void setJustificacionInasistencia(Character justificacionInasistencia) {
        this.justificacionInasistencia = justificacionInasistencia;
    }

}

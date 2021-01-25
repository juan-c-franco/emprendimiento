package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import java.util.Date;

public class ListaasistenciaaatDTO implements java.io.Serializable {

    private long idasistacompanamientoat;
    private BeneficiarioDTO beneficiario;
    private SesionacompanamientoatDTO sesionacompanamientoat;
    private Date fecharegistro;
    private Character registroasistencia;
    private Character justificacioninasistencia;

    public ListaasistenciaaatDTO() {
    }

    public ListaasistenciaaatDTO(long idasistacompanamientoat, BeneficiarioDTO beneficiario, SesionacompanamientoatDTO sesionacompanamientoat) {
        this.idasistacompanamientoat = idasistacompanamientoat;
        this.beneficiario = beneficiario;
        this.sesionacompanamientoat = sesionacompanamientoat;
    }

    public ListaasistenciaaatDTO(long idasistacompanamientoat, BeneficiarioDTO beneficiario, SesionacompanamientoatDTO sesionacompanamientoat, Date fecharegistro, Character registroasistencia) {
        this.idasistacompanamientoat = idasistacompanamientoat;
        this.beneficiario = beneficiario;
        this.sesionacompanamientoat = sesionacompanamientoat;
        this.fecharegistro = fecharegistro;
        this.registroasistencia = registroasistencia;
    }

    public long getIdasistacompanamientoat() {
        return this.idasistacompanamientoat;
    }

    public void setIdasistacompanamientoat(long idasistacompanamientoat) {
        this.idasistacompanamientoat = idasistacompanamientoat;
    }

    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public SesionacompanamientoatDTO getSesionacompanamientoat() {
        return this.sesionacompanamientoat;
    }

    public void setSesionacompanamientoat(SesionacompanamientoatDTO sesionacompanamientoat) {
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
        return justificacioninasistencia;
    }

    public void setJustificacioninasistencia(Character justificacioninasistencia) {
        this.justificacioninasistencia = justificacioninasistencia;
    }

}

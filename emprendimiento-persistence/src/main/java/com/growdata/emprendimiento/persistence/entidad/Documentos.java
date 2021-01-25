package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Documentos implements java.io.Serializable {

    private long iddocumento;
    private Beneficiario beneficiario;
    private Emprendimiento emprendimiento;
    private Tipodocumentos tipodocumentos;
    private Date fecharegistro;
    private String urlarchivo;
    private Set<Observaciones> observacioneses = new HashSet<Observaciones>(0);

    public Documentos() {
    }

    public Documentos(long iddocumento, Beneficiario beneficiario, Emprendimiento emprendimiento, Tipodocumentos tipodocumentos) {
        this.iddocumento = iddocumento;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.tipodocumentos = tipodocumentos;
    }

    public Documentos(long iddocumento, Beneficiario beneficiario, Emprendimiento emprendimiento, Tipodocumentos tipodocumentos, Date fecharegistro, String urlarchivo, Set<Observaciones> observacioneses) {
        this.iddocumento = iddocumento;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.tipodocumentos = tipodocumentos;
        this.fecharegistro = fecharegistro;
        this.urlarchivo = urlarchivo;
        this.observacioneses = observacioneses;
    }

    public long getIddocumento() {
        return this.iddocumento;
    }

    public void setIddocumento(long iddocumento) {
        this.iddocumento = iddocumento;
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

    public Tipodocumentos getTipodocumentos() {
        return this.tipodocumentos;
    }

    public void setTipodocumentos(Tipodocumentos tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getUrlarchivo() {
        return this.urlarchivo;
    }

    public void setUrlarchivo(String urlarchivo) {
        this.urlarchivo = urlarchivo;
    }

    public Set<Observaciones> getObservacioneses() {
        return this.observacioneses;
    }

    public void setObservacioneses(Set<Observaciones> observacioneses) {
        this.observacioneses = observacioneses;
    }

}

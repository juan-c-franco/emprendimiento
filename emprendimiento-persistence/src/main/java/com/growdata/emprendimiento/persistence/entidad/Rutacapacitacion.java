package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Rutacapacitacion implements java.io.Serializable {

    private long idrutacapacitacion;
    private Beneficiario beneficiario;
    private Date fecharegistro;
    private Set<Temasrutacapacitacion> temasrutacapacitacions = new HashSet<Temasrutacapacitacion>(0);

    public Rutacapacitacion() {
    }

    public Rutacapacitacion(long idrutacapacitacion, Beneficiario beneficiario) {
        this.idrutacapacitacion = idrutacapacitacion;
        this.beneficiario = beneficiario;
    }

    public Rutacapacitacion(long idrutacapacitacion, Beneficiario beneficiario, Date fecharegistro, Set<Temasrutacapacitacion> temasrutacapacitacions) {
        this.idrutacapacitacion = idrutacapacitacion;
        this.beneficiario = beneficiario;
        this.fecharegistro = fecharegistro;
        this.temasrutacapacitacions = temasrutacapacitacions;
    }

    public long getIdrutacapacitacion() {
        return this.idrutacapacitacion;
    }

    public void setIdrutacapacitacion(long idrutacapacitacion) {
        this.idrutacapacitacion = idrutacapacitacion;
    }

    public Beneficiario getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Temasrutacapacitacion> getTemasrutacapacitacions() {
        return this.temasrutacapacitacions;
    }

    public void setTemasrutacapacitacions(Set<Temasrutacapacitacion> temasrutacapacitacions) {
        this.temasrutacapacitacions = temasrutacapacitacions;
    }

}

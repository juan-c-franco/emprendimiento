package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RutacapacitacionDTO implements java.io.Serializable {

    private long idrutacapacitacion;
    private BeneficiarioDTO beneficiario;
    private Date fecharegistro;
    private Set<TemasrutacapacitacionDTO> temasrutacapacitacions = new HashSet<TemasrutacapacitacionDTO>(0);

    public RutacapacitacionDTO() {
    }

    public RutacapacitacionDTO(long idrutacapacitacion, BeneficiarioDTO beneficiario) {
        this.idrutacapacitacion = idrutacapacitacion;
        this.beneficiario = beneficiario;
    }

    public RutacapacitacionDTO(long idrutacapacitacion, BeneficiarioDTO beneficiario, Date fecharegistro, Set<TemasrutacapacitacionDTO> temasrutacapacitacions) {
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

    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<TemasrutacapacitacionDTO> getTemasrutacapacitacions() {
        return this.temasrutacapacitacions;
    }

    public void setTemasrutacapacitacions(Set<TemasrutacapacitacionDTO> temasrutacapacitacions) {
        this.temasrutacapacitacions = temasrutacapacitacions;
    }

}

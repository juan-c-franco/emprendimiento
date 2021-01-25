package com.growdata.emprendimiento.business.dtos.parametrizacion;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.intentodto.FinanciacionDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EntidadesfinancierasDTO implements java.io.Serializable {

    private BigDecimal identidadesfinanciera;
    private String nombreentidad;
    private String descripcion;
    private Character estado;
    private Date fecharegistro;
    private Set<FinanciacionDTO> financiacions = new HashSet<FinanciacionDTO>(0);

    public EntidadesfinancierasDTO() {
    }

    public EntidadesfinancierasDTO(BigDecimal identidadesfinanciera) {
        this.identidadesfinanciera = identidadesfinanciera;
    }

    public EntidadesfinancierasDTO(BigDecimal identidadesfinanciera, String nombreentidad, String descripcion, Character estado, Date fecharegistro, Set<FinanciacionDTO> financiacions) {
        this.identidadesfinanciera = identidadesfinanciera;
        this.nombreentidad = nombreentidad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.financiacions = financiacions;
    }

    public BigDecimal getIdentidadesfinanciera() {
        return this.identidadesfinanciera;
    }

    public void setIdentidadesfinanciera(BigDecimal identidadesfinanciera) {
        this.identidadesfinanciera = identidadesfinanciera;
    }

    public String getNombreentidad() {
        return this.nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return this.estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<FinanciacionDTO> getFinanciacions() {
        return this.financiacions;
    }

    public void setFinanciacions(Set<FinanciacionDTO> financiacions) {
        this.financiacions = financiacions;
    }

}

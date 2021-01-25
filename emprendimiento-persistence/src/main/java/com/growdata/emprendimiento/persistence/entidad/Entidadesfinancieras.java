package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Entidadesfinancieras implements java.io.Serializable {

    private BigDecimal identidadfinanciera;
    private String nombreentidad;
    private String descripcion;
    private Character estado;
    private Date fecharegistro;
    private Set<Financiacion> financiacions = new HashSet<Financiacion>(0);

    public Entidadesfinancieras() {
    }

    public Entidadesfinancieras(BigDecimal identidadfinanciera) {
        this.identidadfinanciera = identidadfinanciera;
    }

    public Entidadesfinancieras(BigDecimal identidadfinanciera, String nombreentidad, String descripcion, Character estado, Date fecharegistro, Set<Financiacion> financiacions) {
        this.identidadfinanciera = identidadfinanciera;
        this.nombreentidad = nombreentidad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.financiacions = financiacions;
    }

    public BigDecimal getIdentidadfinanciera() {
        return this.identidadfinanciera;
    }

    public void setIdentidadfinanciera(BigDecimal identidadfinanciera) {
        this.identidadfinanciera = identidadfinanciera;
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

    public Set<Financiacion> getFinanciacions() {
        return this.financiacions;
    }

    public void setFinanciacions(Set<Financiacion> financiacions) {
        this.financiacions = financiacions;
    }

}

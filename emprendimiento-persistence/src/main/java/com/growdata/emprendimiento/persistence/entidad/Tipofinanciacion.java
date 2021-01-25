package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipofinanciacion implements java.io.Serializable {

    private BigDecimal idtipofinanciacion;
    private String nombretipofinanciacion;
    private String descripcion;
    private Set<Financiacion> financiacionsForIdtipofinanciacions = new HashSet<Financiacion>(0);
    private Set<Financiacion> financiacionsForIdtipofinanciaciona = new HashSet<Financiacion>(0);

    public Tipofinanciacion() {
    }

    public Tipofinanciacion(BigDecimal idtipofinanciacion) {
        this.idtipofinanciacion = idtipofinanciacion;
    }

    public Tipofinanciacion(BigDecimal idtipofinanciacion, String nombretipofinanciacion, String descripcion, Set<Financiacion> financiacionsForIdtipofinanciacions, Set<Financiacion> financiacionsForIdtipofinanciaciona) {
        this.idtipofinanciacion = idtipofinanciacion;
        this.nombretipofinanciacion = nombretipofinanciacion;
        this.descripcion = descripcion;
        this.financiacionsForIdtipofinanciacions = financiacionsForIdtipofinanciacions;
        this.financiacionsForIdtipofinanciaciona = financiacionsForIdtipofinanciaciona;
    }

    public BigDecimal getIdtipofinanciacion() {
        return this.idtipofinanciacion;
    }

    public void setIdtipofinanciacion(BigDecimal idtipofinanciacion) {
        this.idtipofinanciacion = idtipofinanciacion;
    }

    public String getNombretipofinanciacion() {
        return this.nombretipofinanciacion;
    }

    public void setNombretipofinanciacion(String nombretipofinanciacion) {
        this.nombretipofinanciacion = nombretipofinanciacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Financiacion> getFinanciacionsForIdtipofinanciacions() {
        return this.financiacionsForIdtipofinanciacions;
    }

    public void setFinanciacionsForIdtipofinanciacions(Set<Financiacion> financiacionsForIdtipofinanciacions) {
        this.financiacionsForIdtipofinanciacions = financiacionsForIdtipofinanciacions;
    }

    public Set<Financiacion> getFinanciacionsForIdtipofinanciaciona() {
        return this.financiacionsForIdtipofinanciaciona;
    }

    public void setFinanciacionsForIdtipofinanciaciona(Set<Financiacion> financiacionsForIdtipofinanciaciona) {
        this.financiacionsForIdtipofinanciaciona = financiacionsForIdtipofinanciaciona;
    }

}

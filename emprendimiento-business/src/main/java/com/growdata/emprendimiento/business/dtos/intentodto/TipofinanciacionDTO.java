package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipofinanciacionDTO implements java.io.Serializable {

    private BigDecimal idtipofinanciacion;
    private String nombretipofinanciacion;
    private String descripcion;
    private Set<FinanciacionDTO> financiacionsForIdtipofinanciacions = new HashSet<FinanciacionDTO>(0);
    private Set<FinanciacionDTO> financiacionsForIdtipofinanciaciona = new HashSet<FinanciacionDTO>(0);

    public TipofinanciacionDTO() {
    }

    public TipofinanciacionDTO(BigDecimal idtipofinanciacion) {
        this.idtipofinanciacion = idtipofinanciacion;
    }

    public TipofinanciacionDTO(BigDecimal idtipofinanciacion, String nombretipofinanciacion, String descripcion, Set<FinanciacionDTO> financiacionsForIdtipofinanciacions, Set<FinanciacionDTO> financiacionsForIdtipofinanciaciona) {
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

    public Set<FinanciacionDTO> getFinanciacionsForIdtipofinanciacions() {
        return this.financiacionsForIdtipofinanciacions;
    }

    public void setFinanciacionsForIdtipofinanciacions(Set<FinanciacionDTO> financiacionsForIdtipofinanciacions) {
        this.financiacionsForIdtipofinanciacions = financiacionsForIdtipofinanciacions;
    }

    public Set<FinanciacionDTO> getFinanciacionsForIdtipofinanciaciona() {
        return this.financiacionsForIdtipofinanciaciona;
    }

    public void setFinanciacionsForIdtipofinanciaciona(Set<FinanciacionDTO> financiacionsForIdtipofinanciaciona) {
        this.financiacionsForIdtipofinanciaciona = financiacionsForIdtipofinanciaciona;
    }

}

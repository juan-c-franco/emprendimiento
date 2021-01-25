package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipoemprendimientoDTO implements java.io.Serializable {

    private BigDecimal idtipoemprendimiento;
    private String nombretipoemprendimiento;
    private String descripcion;
    private Set<EmprendimientoDTO> emprendimientos = new HashSet<EmprendimientoDTO>(0);

    public TipoemprendimientoDTO() {
    }

    public TipoemprendimientoDTO(BigDecimal idtipoemprendimiento) {
        this.idtipoemprendimiento = idtipoemprendimiento;
    }

    public TipoemprendimientoDTO(BigDecimal idtipoemprendimiento, String nombretipoemprendimiento, String descripcion, Set<EmprendimientoDTO> emprendimientos) {
        this.idtipoemprendimiento = idtipoemprendimiento;
        this.nombretipoemprendimiento = nombretipoemprendimiento;
        this.descripcion = descripcion;
        this.emprendimientos = emprendimientos;
    }

    public BigDecimal getIdtipoemprendimiento() {
        return this.idtipoemprendimiento;
    }

    public void setIdtipoemprendimiento(BigDecimal idtipoemprendimiento) {
        this.idtipoemprendimiento = idtipoemprendimiento;
    }

    public String getNombretipoemprendimiento() {
        return this.nombretipoemprendimiento;
    }

    public void setNombretipoemprendimiento(String nombretipoemprendimiento) {
        this.nombretipoemprendimiento = nombretipoemprendimiento;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<EmprendimientoDTO> getEmprendimientos() {
        return this.emprendimientos;
    }

    public void setEmprendimientos(Set<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

}

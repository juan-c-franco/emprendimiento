package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SeguimientoDTO implements java.io.Serializable {

    private long idseguimiento;
    private EmprendimientoDTO emprendimiento;
    private FuncionarioDTO funcionario;
    private Character constitucion;
    private Date fecharegistro;
    private Set<ObservacionesseguimientoDTO> observacionesseguimientos = new HashSet<ObservacionesseguimientoDTO>(0);

    public SeguimientoDTO() {
    }

    public SeguimientoDTO(long idseguimiento, EmprendimientoDTO emprendimiento, FuncionarioDTO funcionario) {
        this.idseguimiento = idseguimiento;
        this.emprendimiento = emprendimiento;
        this.funcionario = funcionario;
    }

    public SeguimientoDTO(long idseguimiento, EmprendimientoDTO emprendimiento, FuncionarioDTO funcionario, Character constitucion, Date fecharegistro, Set<ObservacionesseguimientoDTO> observacionesseguimientos) {
        this.idseguimiento = idseguimiento;
        this.emprendimiento = emprendimiento;
        this.funcionario = funcionario;
        this.constitucion = constitucion;
        this.fecharegistro = fecharegistro;
        this.observacionesseguimientos = observacionesseguimientos;
    }

    public long getIdseguimiento() {
        return this.idseguimiento;
    }

    public void setIdseguimiento(long idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public FuncionarioDTO getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public Character getConstitucion() {
        return this.constitucion;
    }

    public void setConstitucion(Character constitucion) {
        this.constitucion = constitucion;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<ObservacionesseguimientoDTO> getObservacionesseguimientos() {
        return this.observacionesseguimientos;
    }

    public void setObservacionesseguimientos(Set<ObservacionesseguimientoDTO> observacionesseguimientos) {
        this.observacionesseguimientos = observacionesseguimientos;
    }

}

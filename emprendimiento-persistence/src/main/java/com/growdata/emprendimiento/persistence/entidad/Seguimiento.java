package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Seguimiento implements java.io.Serializable {

    private long idseguimiento;
    private Emprendimiento emprendimiento;
    private Funcionario funcionario;
    private Character constitucion;
    private Date fecharegistro;
    private Set<Observacionesseguimiento> observacionesseguimientos = new HashSet<Observacionesseguimiento>(0);

    public Seguimiento() {
    }

    public Seguimiento(long idseguimiento, Emprendimiento emprendimiento, Funcionario funcionario) {
        this.idseguimiento = idseguimiento;
        this.emprendimiento = emprendimiento;
        this.funcionario = funcionario;
    }

    public Seguimiento(long idseguimiento, Emprendimiento emprendimiento, Funcionario funcionario, Character constitucion, Date fecharegistro, Set<Observacionesseguimiento> observacionesseguimientos) {
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

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
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

    public Set<Observacionesseguimiento> getObservacionesseguimientos() {
        return this.observacionesseguimientos;
    }

    public void setObservacionesseguimientos(Set<Observacionesseguimiento> observacionesseguimientos) {
        this.observacionesseguimientos = observacionesseguimientos;
    }

}

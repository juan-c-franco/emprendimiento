package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Logestadoemprendimiento implements java.io.Serializable {

    private long idlogestadoemprendimiento;
    private Emprendimiento emprendimiento;
    private Estadoemprendimiento estadoemprendimiento;
    private Date fecharegistro;

    public Logestadoemprendimiento() {
    }

    public Logestadoemprendimiento(long idlogestadoemprendimiento, Emprendimiento emprendimiento, Estadoemprendimiento estadoemprendimiento) {
        this.idlogestadoemprendimiento = idlogestadoemprendimiento;
        this.emprendimiento = emprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
    }

    public Logestadoemprendimiento(long idlogestadoemprendimiento, Emprendimiento emprendimiento, Estadoemprendimiento estadoemprendimiento, Date fecharegistro) {
        this.idlogestadoemprendimiento = idlogestadoemprendimiento;
        this.emprendimiento = emprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
        this.fecharegistro = fecharegistro;
    }

    public long getIdlogestadoemprendimiento() {
        return this.idlogestadoemprendimiento;
    }

    public void setIdlogestadoemprendimiento(long idlogestadoemprendimiento) {
        this.idlogestadoemprendimiento = idlogestadoemprendimiento;
    }

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Estadoemprendimiento getEstadoemprendimiento() {
        return this.estadoemprendimiento;
    }

    public void setEstadoemprendimiento(Estadoemprendimiento estadoemprendimiento) {
        this.estadoemprendimiento = estadoemprendimiento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

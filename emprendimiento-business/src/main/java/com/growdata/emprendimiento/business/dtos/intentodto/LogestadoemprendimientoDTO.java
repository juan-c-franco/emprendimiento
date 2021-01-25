package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class LogestadoemprendimientoDTO implements java.io.Serializable {

    private long idlogestadoemprendimiento;
    private EmprendimientoDTO emprendimiento;
    private EstadoemprendimientoDTO estadoemprendimiento;
    private Date fecharegistro;

    public LogestadoemprendimientoDTO() {
    }

    public LogestadoemprendimientoDTO(long idlogestadoemprendimiento, EmprendimientoDTO emprendimiento, EstadoemprendimientoDTO estadoemprendimiento) {
        this.idlogestadoemprendimiento = idlogestadoemprendimiento;
        this.emprendimiento = emprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
    }

    public LogestadoemprendimientoDTO(long idlogestadoemprendimiento, EmprendimientoDTO emprendimiento, EstadoemprendimientoDTO estadoemprendimiento, Date fecharegistro) {
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

    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public EstadoemprendimientoDTO getEstadoemprendimiento() {
        return this.estadoemprendimiento;
    }

    public void setEstadoemprendimiento(EstadoemprendimientoDTO estadoemprendimiento) {
        this.estadoemprendimiento = estadoemprendimiento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

package com.growdata.emprendimiento.business.dtos.valoracion;

import java.util.ArrayList;
import java.util.Date;

public class RequestAsociarBeneficiariosValoracion {

    private ArrayList<String> beneficiarios;
    private long idSesion;
    private Date fechaMaximaEmp;
    private int tipoSesion;
    private int estadoEmprendimiento;

    public ArrayList<String> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(ArrayList<String> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(long idSesion) {
        this.idSesion = idSesion;
    }

    public Date getFechaMaximaEmp() {
        return fechaMaximaEmp;
    }

    public void setFechaMaximaEmp(Date fechaMaximaEmp) {
        this.fechaMaximaEmp = fechaMaximaEmp;
    }

    public int getTipoSesion() {
        return tipoSesion;
    }

    public void setTipoSesion(int tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    public int getEstadoEmprendimiento() {
        return estadoEmprendimiento;
    }

    public void setEstadoEmprendimiento(int estadoEmprendimiento) {
        this.estadoEmprendimiento = estadoEmprendimiento;
    }
}

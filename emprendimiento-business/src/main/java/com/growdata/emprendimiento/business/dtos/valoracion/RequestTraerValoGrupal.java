package com.growdata.emprendimiento.business.dtos.valoracion;

public class RequestTraerValoGrupal {

    private long idFuncionario;
    private long idEmprendimiento;

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

}

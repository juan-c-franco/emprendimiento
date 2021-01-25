package com.growdata.emprendimiento.business.dtos.valoracion;

public class RequestTraerSesionesV {

    private long idFuncionario;
    private long idEstadoSesion;

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public long getIdEstadoSesion() {
        return idEstadoSesion;
    }

    public void setIdEstadoSesion(long idEstadoSesion) {
        this.idEstadoSesion = idEstadoSesion;
    }
}

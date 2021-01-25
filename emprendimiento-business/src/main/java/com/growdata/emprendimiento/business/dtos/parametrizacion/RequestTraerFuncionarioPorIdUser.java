package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerFuncionarioPorIdUser {

    private long idUser;
    private BigDecimal idEstado;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }
}

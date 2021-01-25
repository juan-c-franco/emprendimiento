package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerFuncionarioPorUserName {

    private String userName;
    private BigDecimal idEstado;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }
}

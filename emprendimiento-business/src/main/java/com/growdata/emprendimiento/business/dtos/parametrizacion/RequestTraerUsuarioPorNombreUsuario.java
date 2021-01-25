package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class RequestTraerUsuarioPorNombreUsuario {

    private String userName;
    private BigDecimal enabled;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getEnabled() {
        return enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }
}

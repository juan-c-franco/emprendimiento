package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;
import java.util.List;

public class RequestTraerUsuariosComiteLibres {

    private List<String> lstRoles;
    private BigDecimal idEstado;
    private BigDecimal idCajaCompensacion;

    public List<String> getLstRoles() {
        return lstRoles;
    }

    public void setLstRoles(List<String> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }
}

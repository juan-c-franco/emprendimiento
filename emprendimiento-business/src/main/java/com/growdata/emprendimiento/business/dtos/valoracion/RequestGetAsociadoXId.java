package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;

public class RequestGetAsociadoXId {

    private long idBeneficiario;
    private BigDecimal idCajacompensacion;

    public long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public BigDecimal getIdCajacompensacion() {
        return idCajacompensacion;
    }

    public void setIdCajacompensacion(BigDecimal idCajacompensacion) {
        this.idCajacompensacion = idCajacompensacion;
    }

}

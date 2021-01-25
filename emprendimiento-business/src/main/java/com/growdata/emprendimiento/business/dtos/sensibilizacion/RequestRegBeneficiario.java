package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.persistence.entidad.Beneficiario;

public class RequestRegBeneficiario {

    private Beneficiario beneficiario;

    private String tipoDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

}

package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;

public class ResponseBeneficiario extends ResponseDTO {

    private BeneficiarioDTO beneficiario;

    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }
}

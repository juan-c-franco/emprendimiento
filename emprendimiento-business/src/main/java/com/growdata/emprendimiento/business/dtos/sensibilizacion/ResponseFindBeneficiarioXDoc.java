package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import java.util.List;

public class ResponseFindBeneficiarioXDoc extends ResponseDTO {

    private List<BeneficiarioDTO> beneficiariosDTO;

    public List<BeneficiarioDTO> getBeneficiariosDTO() {
        return beneficiariosDTO;
    }

    public void setBeneficiariosDTO(List<BeneficiarioDTO> beneficiariosDTO) {
        this.beneficiariosDTO = beneficiariosDTO;
    }

}

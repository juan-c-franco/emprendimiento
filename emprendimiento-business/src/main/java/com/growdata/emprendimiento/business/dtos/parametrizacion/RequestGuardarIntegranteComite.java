package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import java.util.List;

public class RequestGuardarIntegranteComite {

    private List<IntegrantescomiteDTO> integrantesComiteDTO;

    public List<IntegrantescomiteDTO> getIntegrantesComiteDTO() {
        return integrantesComiteDTO;
    }

    public void setIntegrantesComiteDTO(List<IntegrantescomiteDTO> integrantesComiteDTO) {
        this.integrantesComiteDTO = integrantesComiteDTO;
    }
}

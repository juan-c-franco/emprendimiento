package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerCajas extends ResponseDTO {

    public List<CajacompensacionDTO> getCajasDTO() {
        return cajaDTO;
    }

    public void setCajasDTO(List<CajacompensacionDTO> dto) {
        this.cajaDTO = dto;
    }
    private List<CajacompensacionDTO> cajaDTO;

}

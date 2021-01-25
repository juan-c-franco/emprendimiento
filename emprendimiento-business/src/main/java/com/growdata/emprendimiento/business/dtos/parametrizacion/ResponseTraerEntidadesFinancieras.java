package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerEntidadesFinancieras extends ResponseDTO {

    private List<TraerEntidadesFinancierasDTO> entidadesDTO;

    public List<TraerEntidadesFinancierasDTO> getEntidadesDTO() {
        return entidadesDTO;
    }

    public void setEntidadesDTO(List<TraerEntidadesFinancierasDTO> entidadesDTO) {
        this.entidadesDTO = entidadesDTO;
    }

}

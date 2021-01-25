package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SectorproductivoDTO;
import java.util.List;

public class ResponseSectorProductivo extends ResponseDTO {

    private List<SectorproductivoDTO> sectores;

    public List<SectorproductivoDTO> getSectores() {
        return sectores;
    }

    public void setSectores(List<SectorproductivoDTO> sectores) {
        this.sectores = sectores;
    }

}

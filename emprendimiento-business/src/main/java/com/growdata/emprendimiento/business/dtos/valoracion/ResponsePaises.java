package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PaisesDTO;
import java.util.List;

public class ResponsePaises extends ResponseDTO {

    private List<PaisesDTO> paises;

    public List<PaisesDTO> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisesDTO> paises) {
        this.paises = paises;
    }
}

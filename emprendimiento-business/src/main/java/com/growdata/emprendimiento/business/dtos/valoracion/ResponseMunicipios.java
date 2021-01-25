package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.MunicipiosDTO;
import java.util.List;

public class ResponseMunicipios extends ResponseDTO {

    private List<MunicipiosDTO> municipios;

    public List<MunicipiosDTO> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipiosDTO> municipios) {
        this.municipios = municipios;
    }

}

package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoconstitucionlegalDTO;
import java.util.List;

public class ResponseTipoConstitucionLegal extends ResponseDTO {

    private List<TipoconstitucionlegalDTO> tipos;

    public List<TipoconstitucionlegalDTO> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoconstitucionlegalDTO> tipos) {
        this.tipos = tipos;
    }
}

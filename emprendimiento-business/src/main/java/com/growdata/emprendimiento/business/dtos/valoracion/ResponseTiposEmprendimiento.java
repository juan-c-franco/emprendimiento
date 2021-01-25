package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoemprendimientoDTO;
import java.util.List;

public class ResponseTiposEmprendimiento extends ResponseDTO {

    private List<TipoemprendimientoDTO> tipos;

    public List<TipoemprendimientoDTO> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoemprendimientoDTO> tipos) {
        this.tipos = tipos;
    }
}

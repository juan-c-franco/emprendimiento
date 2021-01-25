package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import java.util.List;

public class ResponseRegistroInasistentes extends ResponseDTO {

    private List<ListaasistenciaDTO> asistenciasDTO;

    public List<ListaasistenciaDTO> getAsistenciasDTO() {
        return asistenciasDTO;
    }

    public void setAsistenciasDTO(List<ListaasistenciaDTO> asistenciasDTO) {
        this.asistenciasDTO = asistenciasDTO;
    }

}

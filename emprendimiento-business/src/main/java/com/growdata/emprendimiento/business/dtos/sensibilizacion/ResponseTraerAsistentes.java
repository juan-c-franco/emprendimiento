package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import java.util.List;

public class ResponseTraerAsistentes extends ResponseDTO {

    private List<ListaasistenciaDTO> asistenciaDTO;

    public List<ListaasistenciaDTO> getAsistenciaDTO() {
        return asistenciaDTO;
    }

    public void setAsistenciaDTO(List<ListaasistenciaDTO> asistenciaDTO) {
        this.asistenciaDTO = asistenciaDTO;
    }

}

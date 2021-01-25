package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ActividadInternacionalDTO;
import java.util.List;

public class ResponseActividadInternacional extends ResponseDTO {

    private List<ActividadInternacionalDTO> actividades;

    public List<ActividadInternacionalDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadInternacionalDTO> actividades) {
        this.actividades = actividades;
    }

}

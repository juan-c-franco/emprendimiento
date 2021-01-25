package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DepartamentosDTO;
import java.util.List;

public class ResponseDepartamentos extends ResponseDTO {

    private List<DepartamentosDTO> departamentos;

    public List<DepartamentosDTO> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentosDTO> departamentos) {
        this.departamentos = departamentos;
    }

}

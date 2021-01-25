package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.List;

public class ResponseTraerEmprendimientoPorNombre extends ResponseDTO {

    private List<EmprendimientoDTO> emprendimientos;

    public List<EmprendimientoDTO> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

}

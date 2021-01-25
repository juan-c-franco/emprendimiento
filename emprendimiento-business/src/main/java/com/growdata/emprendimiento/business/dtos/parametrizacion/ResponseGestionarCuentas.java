package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseGestionarCuentas extends ResponseDTO {

    private List<GestionarFuncionarioDTO> funcisDTO;

    public List<GestionarFuncionarioDTO> getFuncisDTO() {
        return funcisDTO;
    }

    public void setFuncisDTO(List<GestionarFuncionarioDTO> funcisDTO) {
        this.funcisDTO = funcisDTO;
    }

}

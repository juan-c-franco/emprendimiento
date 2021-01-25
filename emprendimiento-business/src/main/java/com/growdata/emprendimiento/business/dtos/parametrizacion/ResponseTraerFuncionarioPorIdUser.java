package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

public class ResponseTraerFuncionarioPorIdUser extends ResponseDTO {

    private FuncionarioDTO funcionarioDTO;

    public FuncionarioDTO getFuncionarioDTO() {
        return funcionarioDTO;
    }

    public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        this.funcionarioDTO = funcionarioDTO;
    }

}

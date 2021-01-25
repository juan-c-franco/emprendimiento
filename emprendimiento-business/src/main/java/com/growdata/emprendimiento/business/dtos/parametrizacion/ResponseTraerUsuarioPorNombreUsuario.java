package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;

public class ResponseTraerUsuarioPorNombreUsuario extends ResponseDTO {

    private UsersDTO userDTO;

    public UsersDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UsersDTO userDTO) {
        this.userDTO = userDTO;
    }
}

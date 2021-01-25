package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseTraerUsuariosComiteLibres extends ResponseDTO {

    private List<UsuarioComiteDTO> usuariosComite;

    public List<UsuarioComiteDTO> getUsuariosComite() {
        return usuariosComite;
    }

    public void setUsuariosComite(List<UsuarioComiteDTO> usuariosComite) {
        this.usuariosComite = usuariosComite;
    }
}

package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta funcionarios.
 *
 * @author Juan Franco
 */
public class ResponseTraerFuncionariosPorGrupoCaja extends ResponseDTO {

    /**
     * Lista de funcionarios.
     */
    private List<FuncionarioDTO> funcionariosDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<FuncionarioDTO> getFuncionariosDTO() {
        return funcionariosDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param funcionariosDTO Valor a ser actualizado.
     */
    public void setFuncionariosDTO(List<FuncionarioDTO> funcionariosDTO) {
        this.funcionariosDTO = funcionariosDTO;
    }
}

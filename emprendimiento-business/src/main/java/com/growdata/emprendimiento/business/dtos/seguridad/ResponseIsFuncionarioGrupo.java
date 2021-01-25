package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta para funcionarios.
 *
 * @author Juan Franco
 */
public class ResponseIsFuncionarioGrupo extends ResponseDTO {

    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionarioDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionarioDTO() {
        return funcionarioDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param funcionarioDTO Valor a ser actualizado.
     */
    public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        this.funcionarioDTO = funcionarioDTO;
    }
}

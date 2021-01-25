package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta para funcionario y grupos.
 *
 * @author Juan Franco
 */
public class ResponseConsultarFuncionarios extends ResponseDTO {

    /**
     * Datos del funcionario y el grupo.
     */
    private List<FuncionariosYGrupoDTO> fyg;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<FuncionariosYGrupoDTO> getFyg() {
        return fyg;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fyg Valor a ser actualizado.
     */
    public void setFyg(List<FuncionariosYGrupoDTO> fyg) {
        this.fyg = fyg;
    }

}

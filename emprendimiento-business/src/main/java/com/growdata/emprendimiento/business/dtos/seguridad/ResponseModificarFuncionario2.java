package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta modificar funcionario.
 *
 * @author Juan Franco
 */
public class ResponseModificarFuncionario2 extends ResponseDTO {

    /**
     * Acción.
     */
    private String accion;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param accion Valor a ser actualizado.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}

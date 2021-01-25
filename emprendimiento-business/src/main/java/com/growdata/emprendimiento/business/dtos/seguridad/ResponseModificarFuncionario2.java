package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta modificar funcionario.
 *
 * @author Juan Franco
 */
public class ResponseModificarFuncionario2 extends ResponseDTO {

    /**
     * Acci�n.
     */
    private String accion;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param accion Valor a ser actualizado.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}

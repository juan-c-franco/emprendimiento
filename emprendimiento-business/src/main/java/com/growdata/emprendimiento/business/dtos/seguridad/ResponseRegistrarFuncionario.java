package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta registrar funcionario.
 *
 * @author Juan Franco
 */
public class ResponseRegistrarFuncionario extends ResponseDTO {

    /**
     * Identificador.
     */
    private long id;
    /**
     * Acción.
     */
    private String accion;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getId() {
        return id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(long id) {
        this.id = id;
    }

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

package com.growdata.emprendimiento.business.dtos.seguimiento;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta guardar plan de acción.
 *
 * @author Juan Franco
 */
public class ResponseGuardarPlanAccion extends ResponseDTO {

    /**
     * Identificador del documento plan de acción.
     */
    private long idDocumento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdDocumento() {
        return idDocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idDocumento Valor a ser actualizado.
     */
    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }

}

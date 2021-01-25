package com.growdata.emprendimiento.business.dtos.seguimiento;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta guardar plan de acci�n.
 *
 * @author Juan Franco
 */
public class ResponseGuardarPlanAccion extends ResponseDTO {

    /**
     * Identificador del documento plan de acci�n.
     */
    private long idDocumento;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdDocumento() {
        return idDocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idDocumento Valor a ser actualizado.
     */
    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }

}

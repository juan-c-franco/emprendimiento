package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta guardar documento.
 *
 * @author Juan Franco
 */
public class ResponseGuardarDocumento extends ResponseDTO {

    /**
     * Identificador del documento.
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

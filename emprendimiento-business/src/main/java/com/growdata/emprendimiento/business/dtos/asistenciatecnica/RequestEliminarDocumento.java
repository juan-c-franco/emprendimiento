package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;

/**
 * Clase solicitud eliminar documento.
 *
 * @author Juan Franco
 */
public class RequestEliminarDocumento {

    /**
     * Identificador documento.
     */
    private BigDecimal idDocumento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdDocumento() {
        return idDocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idDocumento Valor a ser actualizado.
     */
    public void setIdDocumento(BigDecimal idDocumento) {
        this.idDocumento = idDocumento;
    }
}

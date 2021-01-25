package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;

/**
 * Clase solicitud tipo de documento.
 *
 * @author Juan Franco
 */
public class RequestTipoDocumento {

    /**
     * Identificador tipo de documento.
     */
    private BigDecimal idtipodocumento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdtipodocumento() {
        return idtipodocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idtipodocumento Valor a ser actualizado.
     */
    public void setIdtipodocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }
}

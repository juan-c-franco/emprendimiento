package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta tema ruta AAT.
 *
 * @author Juan Franco
 */
public class ResponseGuardarTemaRutaAAT extends ResponseDTO {

    /**
     * Tema ruta AAT.
     */
    private long temaRutaAATId;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getTemaRutaAATId() {
        return temaRutaAATId;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param temaRutaAATId Valor a ser actualizado.
     */
    public void setTemaRutaAATId(long temaRutaAATId) {
        this.temaRutaAATId = temaRutaAATId;
    }
}

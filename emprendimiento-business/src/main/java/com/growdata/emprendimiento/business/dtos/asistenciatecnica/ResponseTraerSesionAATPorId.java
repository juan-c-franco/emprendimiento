package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta Sesión AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesionAATPorId extends ResponseDTO {

    /**
     * Sesión AAT.
     */
    private SesionacompanamientoatDTO sesionAAT;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionacompanamientoatDTO getSesionAAT() {
        return sesionAAT;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionAAT Valor a ser actualizado.
     */
    public void setSesionAAT(SesionacompanamientoatDTO sesionAAT) {
        this.sesionAAT = sesionAAT;
    }
}

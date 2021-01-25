package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta Sesi�n AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesionAATPorId extends ResponseDTO {

    /**
     * Sesi�n AAT.
     */
    private SesionacompanamientoatDTO sesionAAT;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionacompanamientoatDTO getSesionAAT() {
        return sesionAAT;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionAAT Valor a ser actualizado.
     */
    public void setSesionAAT(SesionacompanamientoatDTO sesionAAT) {
        this.sesionAAT = sesionAAT;
    }
}

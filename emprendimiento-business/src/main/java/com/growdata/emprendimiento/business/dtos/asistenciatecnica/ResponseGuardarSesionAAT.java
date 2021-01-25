package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta sesi�n AAT.
 *
 * @author Juan Franco
 */
public class ResponseGuardarSesionAAT extends ResponseDTO {

    /**
     * Sesi�n AAT.
     */
    private long sesionAATId;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getSesionAATId() {
        return sesionAATId;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionAATId Valor a ser actualizado.
     */
    public void setSesionAATId(long sesionAATId) {
        this.sesionAATId = sesionAATId;
    }
}

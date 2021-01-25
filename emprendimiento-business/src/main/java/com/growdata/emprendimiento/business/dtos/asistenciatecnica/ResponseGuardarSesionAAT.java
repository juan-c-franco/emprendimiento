package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta sesión AAT.
 *
 * @author Juan Franco
 */
public class ResponseGuardarSesionAAT extends ResponseDTO {

    /**
     * Sesión AAT.
     */
    private long sesionAATId;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getSesionAATId() {
        return sesionAATId;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionAATId Valor a ser actualizado.
     */
    public void setSesionAATId(long sesionAATId) {
        this.sesionAATId = sesionAATId;
    }
}

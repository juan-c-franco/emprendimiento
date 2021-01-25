package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta sesi�n AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesionAATComplexPorId extends ResponseDTO {

    /**
     * Sesi�n AAT.
     */
    private SesionAATComplexDTO sesionAATComplexDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionAATComplexDTO getSesionAATComplexDTO() {
        return sesionAATComplexDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionAATComplexDTO Valor a ser actualizado.
     */
    public void setSesionAATComplexDTO(
            SesionAATComplexDTO sesionAATComplexDTO) {
        this.sesionAATComplexDTO = sesionAATComplexDTO;
    }
}

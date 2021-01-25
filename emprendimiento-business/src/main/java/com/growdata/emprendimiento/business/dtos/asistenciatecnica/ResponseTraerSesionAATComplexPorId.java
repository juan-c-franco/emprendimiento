package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta sesión AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesionAATComplexPorId extends ResponseDTO {

    /**
     * Sesión AAT.
     */
    private SesionAATComplexDTO sesionAATComplexDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionAATComplexDTO getSesionAATComplexDTO() {
        return sesionAATComplexDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionAATComplexDTO Valor a ser actualizado.
     */
    public void setSesionAATComplexDTO(
            SesionAATComplexDTO sesionAATComplexDTO) {
        this.sesionAATComplexDTO = sesionAATComplexDTO;
    }
}

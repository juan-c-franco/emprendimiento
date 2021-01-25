package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta consultar avance.
 *
 * @author Juan Franco
 */
public class ResponseConsultarAvance extends ResponseDTO {

    /**
     * Datos del emprendimiento.
     */
    private ConsultarAvanceComplexDTO consultarAvanceComplexDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public ConsultarAvanceComplexDTO getConsultarAvanceComplexDTO() {
        return consultarAvanceComplexDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param consultarAvanceComplexDTO Valor a ser actualizado.
     */
    public void setConsultarAvanceComplexDTO(
            ConsultarAvanceComplexDTO consultarAvanceComplexDTO) {
        this.consultarAvanceComplexDTO = consultarAvanceComplexDTO;
    }
}

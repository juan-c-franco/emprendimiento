package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FinanciacionDTO;

/**
 * Clase respuesta financiaci�n.
 *
 * @author Juan Franco
 */
public class ResponseTraerInfoFinancieraBasica extends ResponseDTO {

    /**
     * Datos financiaci�n.
     */
    private FinanciacionDTO financiacionDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FinanciacionDTO getFinanciacionDTO() {
        return financiacionDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param financiacionDTO Valor a ser actualizado.
     */
    public void setFinanciacionDTO(FinanciacionDTO financiacionDTO) {
        this.financiacionDTO = financiacionDTO;
    }

}

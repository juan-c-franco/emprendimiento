package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AsociadosDTO;

/**
 * Clase respuesta asociado.
 *
 * @author Juan Franco
 */
public class ResponseTraerAsociadoPorUserName extends ResponseDTO {

    /**
     * Asociado.
     */
    private AsociadosDTO asociadoDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public AsociadosDTO getAsociadoDTO() {
        return asociadoDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param asociadoDTO Valor a ser actualizado.
     */
    public void setAsociadoDTO(AsociadosDTO asociadoDTO) {
        this.asociadoDTO = asociadoDTO;
    }
}

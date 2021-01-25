package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;

/**
 * Clase response estado emprendimiento.
 *
 * @author Juan Franco
 */
public class ResponseTraerEstadoEmprendimiento extends ResponseDTO {

    /**
     * Estado emprendimiento.
     */
    private EstadoemprendimientoDTO estadoEmprendimientoDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadoemprendimientoDTO getEstadoEmprendimientoDTO() {
        return estadoEmprendimientoDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadoEmprendimientoDTO Valor a ser actualizado.
     */
    public void setEstadoEmprendimientoDTO(
            EstadoemprendimientoDTO estadoEmprendimientoDTO) {
        this.estadoEmprendimientoDTO = estadoEmprendimientoDTO;
    }
}

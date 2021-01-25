package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;

/**
 * Clase respuesta estados sesión.
 *
 * @author Juan Franco
 */
public class ResponseTraerEstadoSesionPorNombre extends ResponseDTO {

    /**
     * Estados sesión.
     */
    private EstadosesionDTO estadoSesionDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadosesionDTO getEstadoSesionDTO() {
        return estadoSesionDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadoSesionDTO Valor a ser actualizado.
     */
    public void setEstadoSesionDTO(EstadosesionDTO estadoSesionDTO) {
        this.estadoSesionDTO = estadoSesionDTO;
    }
}

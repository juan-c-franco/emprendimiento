package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;

/**
 * Clase respuesta estados sesi�n.
 *
 * @author Juan Franco
 */
public class ResponseTraerEstadoSesionPorNombre extends ResponseDTO {

    /**
     * Estados sesi�n.
     */
    private EstadosesionDTO estadoSesionDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadosesionDTO getEstadoSesionDTO() {
        return estadoSesionDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadoSesionDTO Valor a ser actualizado.
     */
    public void setEstadoSesionDTO(EstadosesionDTO estadoSesionDTO) {
        this.estadoSesionDTO = estadoSesionDTO;
    }
}

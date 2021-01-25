package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;

/**
 * Clase respuesta emprendimiento
 *
 * @author Juan Franco
 */
public class ResponseTraerEmprendimiento extends ResponseDTO {

    /**
     * Emprendimiento.
     */
    private EmprendimientoDTO emprendimientoDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimientoDTO() {
        return emprendimientoDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimientoDTO Valor a ser actualizado.
     */
    public void setEmprendimientoDTO(EmprendimientoDTO emprendimientoDTO) {
        this.emprendimientoDTO = emprendimientoDTO;
    }
}

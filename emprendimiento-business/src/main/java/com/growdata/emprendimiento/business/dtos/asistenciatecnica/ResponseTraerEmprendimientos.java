package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.List;

/**
 * Clase respuesta emprendimientos.
 *
 * @author Juan Franco
 */
public class ResponseTraerEmprendimientos extends ResponseDTO {

    /**
     * Lista de emprendimientos.
     */
    private List<EmprendimientoDTO> emprendimientos;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<EmprendimientoDTO> getEmprendimientos() {
        return emprendimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimientos Valor a ser actualizado.
     */
    public void setEmprendimientos(List<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }
}

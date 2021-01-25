package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;

/**
 * Clase respuesta Emprendimiento.
 *
 * @author Juan Franco
 */
public class ResponseTraerEmprendimientoPorId extends ResponseDTO {

    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return emprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

}

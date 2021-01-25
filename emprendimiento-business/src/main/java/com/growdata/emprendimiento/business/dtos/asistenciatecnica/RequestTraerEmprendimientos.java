package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.util.List;

/**
 * Clase solicitud emprendimientos.
 *
 * @author Juan Franco
 */
public class RequestTraerEmprendimientos {

    /**
     * Estados emprendimientos.
     */
    private List<String> estadosEmprendimiento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosEmprendimiento() {
        return estadosEmprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadosEmprendimiento Valor a ser actualizado.
     */
    public void setEstadosEmprendimiento(List<String> estadosEmprendimiento) {
        this.estadosEmprendimiento = estadosEmprendimiento;
    }
}

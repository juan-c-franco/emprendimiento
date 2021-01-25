package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;

/**
 * Clase solicitud estado emprendimiento.
 *
 * @author Juan Franco
 */
public class RequestTraerEstadoEmprendimiento {

    /**
     * Identificador estado emprendimiento.
     */
    private BigDecimal idestadoemprendimiento;

    /**
     * Nombre estado emprendimiento.
     */
    private String nombreEstadoEmprendimiento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadoemprendimiento() {
        return idestadoemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idestadoemprendimiento Valor a ser actualizado.
     */
    public void setIdestadoemprendimiento(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEstadoEmprendimiento() {
        return nombreEstadoEmprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreEstadoEmprendimiento Valor a ser actualizado.
     */
    public void setNombreEstadoEmprendimiento(String nombreEstadoEmprendimiento) {
        this.nombreEstadoEmprendimiento = nombreEstadoEmprendimiento;
    }
}

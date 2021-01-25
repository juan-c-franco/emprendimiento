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
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadoemprendimiento() {
        return idestadoemprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idestadoemprendimiento Valor a ser actualizado.
     */
    public void setIdestadoemprendimiento(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEstadoEmprendimiento() {
        return nombreEstadoEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreEstadoEmprendimiento Valor a ser actualizado.
     */
    public void setNombreEstadoEmprendimiento(String nombreEstadoEmprendimiento) {
        this.nombreEstadoEmprendimiento = nombreEstadoEmprendimiento;
    }
}

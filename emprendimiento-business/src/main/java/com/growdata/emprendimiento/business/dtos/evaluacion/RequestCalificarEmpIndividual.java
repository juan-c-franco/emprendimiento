package com.growdata.emprendimiento.business.dtos.evaluacion;

import java.math.BigDecimal;

/**
 * Clase solicitud calificar emprendimiento individual.
 *
 * @author Juan Franco
 */
public class RequestCalificarEmpIndividual {

    /**
     * Observaciones.
     */
    private String observaciones;
    /**
     * Aprobado o no.
     */
    private BigDecimal calificacion;
    /**
     * Identificador del emprendimiento.
     */
    private long idemprendimiento;
    /**
     * Identificador del funcionario.
     */
    private long idfuncionario;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param observaciones Valor a ser actualizado.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getCalificacion() {
        return calificacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacion Valor a ser actualizado.
     */
    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idfuncionario Valor a ser actualizado.
     */
    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdemprendimiento() {
        return idemprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idemprendimiento Valor a ser actualizado.
     */
    public void setIdemprendimiento(long idemprendimiento) {
        this.idemprendimiento = idemprendimiento;
    }

}

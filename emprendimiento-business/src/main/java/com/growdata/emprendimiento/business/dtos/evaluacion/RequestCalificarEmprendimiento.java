package com.growdata.emprendimiento.business.dtos.evaluacion;

/**
 * Clase solicitud calificar emprendimiento.
 *
 * @author Juan Franco
 */
public class RequestCalificarEmprendimiento {

    /**
     * Identificador del emprendimiento.
     */
    private long idemprendimiento;
    /**
     * Aprobado o no.
     */
    private Character aprobado;
    /**
     * Observaciones.
     */
    private String observaciones;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdEmprendimiento() {
        return idemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setIdEmprendimiento(long id) {
        this.idemprendimiento = id;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getAprobado() {
        return aprobado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param aprobado Valor a ser actualizado.
     */
    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param observaciones Valor a ser actualizado.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

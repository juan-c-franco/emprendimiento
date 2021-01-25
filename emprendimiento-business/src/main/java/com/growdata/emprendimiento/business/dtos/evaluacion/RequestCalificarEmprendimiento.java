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
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdEmprendimiento() {
        return idemprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setIdEmprendimiento(long id) {
        this.idemprendimiento = id;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getAprobado() {
        return aprobado;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param aprobado Valor a ser actualizado.
     */
    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
    }

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
}

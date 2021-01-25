package com.growdata.emprendimiento.business.dtos.evaluacion;

import java.util.List;

/**
 * Clase solicitud emprendimiento.
 *
 * @author Juan Franco
 */
public class RequestTraerEmprendimientoPorId {

    /**
     * Identificador del emprendimiento.
     */
    private long idEmprendimiento;

    /**
     * Lista de estados del emprendimiento.
     */
    private List<String> estados;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstados() {
        return estados;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estados Valor a ser actualizado.
     */
    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idEmprendimiento Valor a ser actualizado.
     */
    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

}

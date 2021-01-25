package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

/**
 * Clase solicitud temas ruta AAT.
 *
 * @author Juan Franco
 */
public class RequestTraerTemasRutaAAT {

    /**
     * Identificador tema ruta AAT.
     */
    private long idTemaRutaAAT;
    /**
     * Identificador emprendimiento.
     */
    private long idEmprendimiento;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdTemaRutaAAT() {
        return idTemaRutaAAT;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idTemaRutaAAT Valor a ser actualizado.
     */
    public void setIdTemaRutaAAT(long idTemaRutaAAT) {
        this.idTemaRutaAAT = idTemaRutaAAT;
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

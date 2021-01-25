package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

/**
 * Clase solicitud estado sesi�n.
 *
 * @author Juan Franco
 */
public class RequestTraerEstadoSesionPorNombre {

    /**
     * Nombre estado.
     */
    private String nombreEstadoSesion;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEstadoSesion() {
        return nombreEstadoSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreEstadoSesion Valor a ser actualizado.
     */
    public void setNombreEstadoSesion(String nombreEstadoSesion) {
        this.nombreEstadoSesion = nombreEstadoSesion;
    }
}

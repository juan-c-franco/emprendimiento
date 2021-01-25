package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;

/**
 * Clase respuesta comité de evaluación.
 *
 * @author Juan Franco
 */
public class ResponseComiteEvaluacion extends ResponseDTO {

    /**
     * Datos comité de evaluación.
     */
    private Comiteevaluacion comite;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Comiteevaluacion getComite() {
        return comite;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param comite Valor a ser actualizado.
     */
    public void setComite(Comiteevaluacion comite) {
        this.comite = comite;
    }

}

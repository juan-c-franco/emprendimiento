package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;

/**
 * Clase respuesta comit� de evaluaci�n.
 *
 * @author Juan Franco
 */
public class ResponseComiteEvaluacion extends ResponseDTO {

    /**
     * Datos comit� de evaluaci�n.
     */
    private Comiteevaluacion comite;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Comiteevaluacion getComite() {
        return comite;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param comite Valor a ser actualizado.
     */
    public void setComite(Comiteevaluacion comite) {
        this.comite = comite;
    }

}

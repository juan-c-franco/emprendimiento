package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.commons.CalificacionIntegrantesComite;
import java.util.List;

/**
 * Clase respuesta evaluaciones.
 *
 * @author Juan Franco
 */
public class ResponseEvaluacionintegrantescomite extends ResponseDTO {

    /**
     * Lista de evaluaciones.
     */
    private List<CalificacionIntegrantesComite> evaluaciones;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<CalificacionIntegrantesComite> getEvaluaciones() {
        return evaluaciones;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param evaluaciones Valor a ser actualizado.
     */
    public void setEvaluaciones(
            List<CalificacionIntegrantesComite> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

}

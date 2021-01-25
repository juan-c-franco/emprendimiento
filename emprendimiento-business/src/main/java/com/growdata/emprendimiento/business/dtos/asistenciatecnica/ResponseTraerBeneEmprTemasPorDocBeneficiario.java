package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta Asistencia T�cnica.
 *
 * @author Juan Franco
 */
public class ResponseTraerBeneEmprTemasPorDocBeneficiario extends ResponseDTO {

    /**
     * Datos asistencia tecnica.
     */
    private AsistenciaTecnicaComplexDTO asistenciaTecnicaComplex;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public AsistenciaTecnicaComplexDTO getAsistenciaTecnicaComplex() {
        return asistenciaTecnicaComplex;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param asistenciaTecnicaComplex Valor a ser actualizado.
     */
    public void setAsistenciaTecnicaComplex(
            AsistenciaTecnicaComplexDTO asistenciaTecnicaComplex) {
        this.asistenciaTecnicaComplex = asistenciaTecnicaComplex;
    }
}

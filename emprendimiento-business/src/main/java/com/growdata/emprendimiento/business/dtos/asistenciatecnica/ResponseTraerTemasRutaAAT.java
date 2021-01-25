package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase con la respuesta de los temas rutas AAT.
 * @author Juan Franco
 */
public class ResponseTraerTemasRutaAAT extends ResponseDTO {

    /**
     * Temas ruta AAT.
     */
    private TemasrutaacompanamientoatDTO temasRutaAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TemasrutaacompanamientoatDTO getTemasRutaAATDTO() {
        return temasRutaAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param temasRutaAATDTO Valor a ser actualizado.
     */
    public void setTemasRutaAATDTO(
            TemasrutaacompanamientoatDTO temasRutaAATDTO) {
        this.temasRutaAATDTO = temasRutaAATDTO;
    }
}

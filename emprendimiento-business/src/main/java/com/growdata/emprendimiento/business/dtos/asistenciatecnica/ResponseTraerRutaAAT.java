package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta Ruta AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerRutaAAT extends ResponseDTO {

    /**
     * Ruta AAT.
     */
    private RutaacompanamientoatDTO rutaAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public RutaacompanamientoatDTO getRutaAATDTO() {
        return rutaAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param rutaAATDTO Valor a ser actualizado.
     */
    public void setRutaAATDTO(RutaacompanamientoatDTO rutaAATDTO) {
        this.rutaAATDTO = rutaAATDTO;
    }
}

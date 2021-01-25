package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta temas ruta AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerListaTemasRutaAAT extends ResponseDTO {

    /**
     * Temas ruta AAT.
     */
    private List<TemasrutaacompanamientoatDTO> temasRutaAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TemasrutaacompanamientoatDTO> getTemasRutaAATDTO() {
        return temasRutaAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param temasRutaAATDTO Valor a ser actualizado.
     */
    public void setTemasRutaAATDTO(
            List<TemasrutaacompanamientoatDTO> temasRutaAATDTO) {
        this.temasRutaAATDTO = temasRutaAATDTO;
    }
}

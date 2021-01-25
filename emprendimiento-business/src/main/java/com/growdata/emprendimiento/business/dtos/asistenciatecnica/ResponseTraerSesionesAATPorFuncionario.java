package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta sesiones AAT.
 * @author Juan Franco
 */
public class ResponseTraerSesionesAATPorFuncionario extends ResponseDTO {

    /**
     * Sesiones AAT.
     */
    private List<SesionacompanamientoatDTO> sesionesAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<SesionacompanamientoatDTO> getSesionesAATDTO() {
        return sesionesAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionesAATDTO Valor a ser actualizado.
     */
    public void setSesionesAATDTO(
            List<SesionacompanamientoatDTO> sesionesAATDTO) {
        this.sesionesAATDTO = sesionesAATDTO;
    }
}

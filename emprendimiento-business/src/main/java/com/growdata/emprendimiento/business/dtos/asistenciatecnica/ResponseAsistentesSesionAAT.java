package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta lista de asistencia AAT.
 *
 * @author Juan Franco
 */
public class ResponseAsistentesSesionAAT extends ResponseDTO {

    /**
     * Lista de asistencia AAT.
     */
    private List<ListaasistenciaaatDTO> asistenciaDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<ListaasistenciaaatDTO> getAsistenciaDTO() {
        return asistenciaDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param asistenciaDTO Valor a ser actualizado.
     */
    public void setAsistenciaDTO(List<ListaasistenciaaatDTO> asistenciaDTO) {
        this.asistenciaDTO = asistenciaDTO;
    }

}

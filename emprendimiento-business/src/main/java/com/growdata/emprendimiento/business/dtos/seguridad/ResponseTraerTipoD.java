package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta tipo documento de identificación.
 *
 * @author Juan Franco
 */
public class ResponseTraerTipoD extends ResponseDTO {

    /**
     * Tipos de documentos de identificación.
     */
    private List<TipodocumentoidDTO> tipoDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TipodocumentoidDTO> getTipoDTO() {
        return tipoDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoDTO Valor a ser actualizado.
     */
    public void setTipoDTO(List<TipodocumentoidDTO> tipoDTO) {
        this.tipoDTO = tipoDTO;
    }

}

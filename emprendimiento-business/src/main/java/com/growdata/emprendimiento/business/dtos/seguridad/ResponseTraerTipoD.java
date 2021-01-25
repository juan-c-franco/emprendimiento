package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta tipo documento de identificaci�n.
 *
 * @author Juan Franco
 */
public class ResponseTraerTipoD extends ResponseDTO {

    /**
     * Tipos de documentos de identificaci�n.
     */
    private List<TipodocumentoidDTO> tipoDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TipodocumentoidDTO> getTipoDTO() {
        return tipoDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipoDTO Valor a ser actualizado.
     */
    public void setTipoDTO(List<TipodocumentoidDTO> tipoDTO) {
        this.tipoDTO = tipoDTO;
    }

}

package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipodocumentosDTO;

/**
 * Clase respuesta tipo de documento.
 *
 * @author Juan Franco
 */
public class ResponseTipoDocumento extends ResponseDTO {

    /**
     * Tipo de documento.
     */
    private TipodocumentosDTO tipoDocumentosDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipodocumentosDTO getTipoDocumentosDTO() {
        return tipoDocumentosDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoDocumentosDTO Valor a ser actualizado.
     */
    public void setTipoDocumentosDTO(TipodocumentosDTO tipoDocumentosDTO) {
        this.tipoDocumentosDTO = tipoDocumentosDTO;
    }
}

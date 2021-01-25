package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;

/**
 * Clase respuesta documentos comit�.
 *
 * @author Juan Franco
 */
public class ResponseTraerDocumentoComite extends ResponseDTO {

    /**
     * Documento comit�.
     */
    private DocumentosDTO documentoDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public DocumentosDTO getDocumentoDTO() {
        return documentoDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param documentoDTO Valor a ser actualizado.
     */
    public void setDocumentoDTO(DocumentosDTO documentoDTO) {
        this.documentoDTO = documentoDTO;
    }
}

package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import java.util.List;

/**
 * Clase respuesta documentos.
 *
 * @author Juan Franco
 */
public class ResponseTraerDocumentos extends ResponseDTO {

    /**
     * Lista de documentos.
     */
    private List<DocumentosDTO> documentosDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<DocumentosDTO> getDocumentosDTO() {
        return documentosDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param documentosDTO Valor a ser actualizado.
     */
    public void setDocumentosDTO(List<DocumentosDTO> documentosDTO) {
        this.documentosDTO = documentosDTO;
    }
}

package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;

/**
 * Clase solicitud guardar documento.
 *
 * @author Juan Franco
 */
public class RequestGuardarDocumento {

    /**
     * Documento.
     */
    private DocumentosDTO documento;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public DocumentosDTO getDocumento() {
        return documento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param documento Valor a ser actualizado.
     */
    public void setDocumento(DocumentosDTO documento) {
        this.documento = documento;
    }
}

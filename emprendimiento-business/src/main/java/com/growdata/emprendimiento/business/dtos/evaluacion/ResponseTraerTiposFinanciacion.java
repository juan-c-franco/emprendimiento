package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipofinanciacionDTO;
import java.util.List;

/**
 * Clase respuesta tipos de financiaci�n.
 *
 * @author Juan Franco
 */
public class ResponseTraerTiposFinanciacion extends ResponseDTO {

    /**
     * Tipos de financiaci�n.
     */
    private List<TipofinanciacionDTO> tiposFinanciacionDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TipofinanciacionDTO> getTiposFinanciacionDTO() {
        return tiposFinanciacionDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tiposFinanciacionDTO Valor a ser actualizado.
     */
    public void setTiposFinanciacionDTO(
            List<TipofinanciacionDTO> tiposFinanciacionDTO) {
        this.tiposFinanciacionDTO = tiposFinanciacionDTO;
    }

}

package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipofinanciacionDTO;
import java.util.List;

/**
 * Clase respuesta tipos de financiación.
 *
 * @author Juan Franco
 */
public class ResponseTraerTiposFinanciacion extends ResponseDTO {

    /**
     * Tipos de financiación.
     */
    private List<TipofinanciacionDTO> tiposFinanciacionDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TipofinanciacionDTO> getTiposFinanciacionDTO() {
        return tiposFinanciacionDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tiposFinanciacionDTO Valor a ser actualizado.
     */
    public void setTiposFinanciacionDTO(
            List<TipofinanciacionDTO> tiposFinanciacionDTO) {
        this.tiposFinanciacionDTO = tiposFinanciacionDTO;
    }

}

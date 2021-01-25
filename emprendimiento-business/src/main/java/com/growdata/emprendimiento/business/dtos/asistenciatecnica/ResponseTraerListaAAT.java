package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta lista asistencia AAT.
 *
 * @author Juan Franco
 */
public class ResponseTraerListaAAT extends ResponseDTO {

    /**
     * Lista asistencia AAT.
     */
    private ListaasistenciaaatDTO listaAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public ListaasistenciaaatDTO getListaAATDTO() {
        return listaAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param listaAATDTO Valor a ser actualizado.
     */
    public void setListaAATDTO(ListaasistenciaaatDTO listaAATDTO) {
        this.listaAATDTO = listaAATDTO;
    }
}

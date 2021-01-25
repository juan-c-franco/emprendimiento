package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import java.util.List;

/**
 * Clase respuesta lista asistencia AAT.
 *
 * @author Juan Franco
 */
public class RequestUpdateListasAAT {

    /**
     * Lista de asistencias AAT.
     */
    private List<ListaasistenciaaatDTO> listasAATDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<ListaasistenciaaatDTO> getListasAATDTO() {
        return listasAATDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param listasAATDTO Valor a ser actualizado.
     */
    public void setListasAATDTO(List<ListaasistenciaaatDTO> listasAATDTO) {
        this.listasAATDTO = listasAATDTO;
    }
}

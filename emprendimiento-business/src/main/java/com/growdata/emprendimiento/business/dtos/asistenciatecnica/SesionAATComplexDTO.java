package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import java.util.List;

/**
 * Clase correspondiente a una sesi�n AAT.
 * @author Juan Franco
 */
public class SesionAATComplexDTO {

    /**
     * Sesi�n AAT.
     */
    private SesionacompanamientoatDTO sesionacompanamientoatDTO;
    /**
     * Lista de asistencia.
     */
    private List<ListaasistenciaaatDTO> listaAATDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionacompanamientoatDTO getSesionacompanamientoatDTO() {
        return sesionacompanamientoatDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionacompanamientoatDTO Valor a ser actualizado.
     */
    public void setSesionacompanamientoatDTO(
            SesionacompanamientoatDTO sesionacompanamientoatDTO) {
        this.sesionacompanamientoatDTO = sesionacompanamientoatDTO;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<ListaasistenciaaatDTO> getListaAATDTO() {
        return listaAATDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param listaAATDTO Valor a ser actualizado.
     */
    public void setListaAATDTO(List<ListaasistenciaaatDTO> listaAATDTO) {
        this.listaAATDTO = listaAATDTO;
    }
}

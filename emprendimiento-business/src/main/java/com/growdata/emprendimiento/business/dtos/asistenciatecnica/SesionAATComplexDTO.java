package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import java.util.List;

/**
 * Clase correspondiente a una sesión AAT.
 * @author Juan Franco
 */
public class SesionAATComplexDTO {

    /**
     * Sesión AAT.
     */
    private SesionacompanamientoatDTO sesionacompanamientoatDTO;
    /**
     * Lista de asistencia.
     */
    private List<ListaasistenciaaatDTO> listaAATDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionacompanamientoatDTO getSesionacompanamientoatDTO() {
        return sesionacompanamientoatDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionacompanamientoatDTO Valor a ser actualizado.
     */
    public void setSesionacompanamientoatDTO(
            SesionacompanamientoatDTO sesionacompanamientoatDTO) {
        this.sesionacompanamientoatDTO = sesionacompanamientoatDTO;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<ListaasistenciaaatDTO> getListaAATDTO() {
        return listaAATDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param listaAATDTO Valor a ser actualizado.
     */
    public void setListaAATDTO(List<ListaasistenciaaatDTO> listaAATDTO) {
        this.listaAATDTO = listaAATDTO;
    }
}

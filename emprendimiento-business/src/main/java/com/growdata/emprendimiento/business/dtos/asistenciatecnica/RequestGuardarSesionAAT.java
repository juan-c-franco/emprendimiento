package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import java.util.List;

/**
 * Clase solicitud guardar sesi�n AAT.
 *
 * @author Juan Franco
 */
public class RequestGuardarSesionAAT {

    /**
     * Sesi�n AAT.
     */
    private SesionacompanamientoatDTO sesionAATDTO;

    /**
     * Listas de asistencia AAT.
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

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SesionacompanamientoatDTO getSesionAATDTO() {
        return sesionAATDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionAATDTO Valor a ser actualizado.
     */
    public void setSesionAATDTO(SesionacompanamientoatDTO sesionAATDTO) {
        this.sesionAATDTO = sesionAATDTO;
    }
}

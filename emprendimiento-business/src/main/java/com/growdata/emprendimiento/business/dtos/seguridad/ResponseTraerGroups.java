package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.GroupsDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta gurpos.
 *
 * @author Juan Franco
 */
public class ResponseTraerGroups extends ResponseDTO {

    /**
     * Lista de grupos.
     */
    private List<GroupsDTO> groupsDTO;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<GroupsDTO> getGroupsDTO() {
        return groupsDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groupsDTO Valor a ser actualizado.
     */
    public void setGroupsDTO(List<GroupsDTO> groupsDTO) {
        this.groupsDTO = groupsDTO;
    }

}

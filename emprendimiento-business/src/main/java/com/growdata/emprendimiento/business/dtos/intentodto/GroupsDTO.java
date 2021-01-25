package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad groups.
 *
 * @author Juan Franco
 */
public class GroupsDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private int id;
    /**
     * Nombre del grupo.
     */
    private String groupName;
    /**
     * Miembros del grupo.
     */
    private Set<GroupMembersDTO> groupMemberses
            = new HashSet<GroupMembersDTO>(0);
    /**
     * Roles del grupo.
     */
    private Set<GroupAuthoritiesDTO> groupAuthoritieses
            = new HashSet<GroupAuthoritiesDTO>(0);

    /**
     * Constructor.
     */
    public GroupsDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param groupName Nombre del grupo.
     */
    public GroupsDTO(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param groupName Nombre del grupo.
     * @param groupMemberses Miembros.
     * @param groupAuthoritieses Roles.
     */
    public GroupsDTO(int id, String groupName,
            Set<GroupMembersDTO> groupMemberses,
            Set<GroupAuthoritiesDTO> groupAuthoritieses) {
        this.id = id;
        this.groupName = groupName;
        this.groupMemberses = groupMemberses;
        this.groupAuthoritieses = groupAuthoritieses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getGroupName() {
        return this.groupName;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groupName Valor a ser actualizado.
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<GroupMembersDTO> getGroupMemberses() {
        return this.groupMemberses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groupMemberses Valor a ser actualizado.
     */
    public void setGroupMemberses(Set<GroupMembersDTO> groupMemberses) {
        this.groupMemberses = groupMemberses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<GroupAuthoritiesDTO> getGroupAuthoritieses() {
        return this.groupAuthoritieses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groupAuthoritieses Valor a ser actualizado.
     */
    public void setGroupAuthoritieses(
            Set<GroupAuthoritiesDTO> groupAuthoritieses) {
        this.groupAuthoritieses = groupAuthoritieses;
    }

}

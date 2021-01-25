package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase representante de Group Members.
 *
 * @author Juan Franco
 */
public class GroupMembersDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private int id;
    /**
     * Datos del usuario.
     */
    @JsonIgnore
    private UsersDTO users;
    /**
     * Datos del grupo.
     */
    private GroupsDTO groups;

    /**
     * Constructor.
     */
    public GroupMembersDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param users Datos del usuario.
     * @param groups Datos del grupo.
     */
    public GroupMembersDTO(int id, UsersDTO users, GroupsDTO groups) {
        this.id = id;
        this.users = users;
        this.groups = groups;
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
    public UsersDTO getUsers() {
        return this.users;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param users Valor a ser actualizado.
     */
    public void setUsers(UsersDTO users) {
        this.users = users;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public GroupsDTO getGroups() {
        return this.groups;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groups Valor a ser actualizado.
     */
    public void setGroups(GroupsDTO groups) {
        this.groups = groups;
    }

}

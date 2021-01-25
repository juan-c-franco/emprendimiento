package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Clase representante de group authorities.
 *
 * @author Juan Franco
 */
public class GroupAuthoritiesDTO implements java.io.Serializable {

    private BigDecimal id;
    private GroupsDTO groups;
    private String authority;

    /**
     * Constructor.
     */
    public GroupAuthoritiesDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param groups Grupo.
     * @param authority Role.
     */
    public GroupAuthoritiesDTO(BigDecimal id, GroupsDTO groups,
            String authority) {
        this.id = id;
        this.groups = groups;
        this.authority = authority;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getId() {
        return this.id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(BigDecimal id) {
        this.id = id;
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

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAuthority() {
        return this.authority;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param authority Valor a ser actualizado.
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}

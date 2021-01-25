package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Clase representante de la entidad Authorities.
 *
 * @author Juan Franco
 */
public class AuthoritiesDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal id;
    /**
     * Datos del usuario.
     */
    private UsersDTO users;
    /**
     * Autoriadad para ejecutar funcionalidad.
     */
    private String authority;

    /**
     * Constructor.
     */
    public AuthoritiesDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param users Datos de usuario.
     * @param authority Autoridad para reliazar una funcionalidad.
     */
    public AuthoritiesDTO(BigDecimal id, UsersDTO users, String authority) {
        this.id = id;
        this.users = users;
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

package com.growdata.emprendimiento.business.dtos.login;

import com.growdata.emprendimiento.persistence.entidad.Users;

/**
 * Clase solicitud restaurar contrase�a.
 *
 * @author Juan Franco
 */
public class RequestRestaurarContrasena {

    /**
     * Datos del usuario.
     */
    private Users user;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Users getUser() {
        return user;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param user Valor a ser actualizado.
     */
    public void setUser(Users user) {
        this.user = user;
    }

}

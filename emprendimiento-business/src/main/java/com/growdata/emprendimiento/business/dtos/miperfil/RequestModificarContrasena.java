package com.growdata.emprendimiento.business.dtos.miperfil;

import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;

/**
 * Clase solicitud modificar contraseña.
 *
 * @author Juan Franco
 */
public class RequestModificarContrasena {

    /**
     * Datos del usuario.
     */
    private UsersDTO userDTO;
    /**
     * Contraseña nueva.
     */
    private String contrasenaN;
    /**
     * Contraseña nueva.
     */
    private String contrasenaN2;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getContrasenaN() {
        return contrasenaN;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param contrasenaN Valor a ser actualizado.
     */
    public void setContrasenaN(String contrasenaN) {
        this.contrasenaN = contrasenaN;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getContrasenaN2() {
        return contrasenaN2;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param contrasenaN2 Valor a ser actualizado.
     */
    public void setContrasenaN2(String contrasenaN2) {
        this.contrasenaN2 = contrasenaN2;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public UsersDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param userDTO Valor a ser actualizado.
     */
    public void setUserDTO(UsersDTO userDTO) {
        this.userDTO = userDTO;
    }

}

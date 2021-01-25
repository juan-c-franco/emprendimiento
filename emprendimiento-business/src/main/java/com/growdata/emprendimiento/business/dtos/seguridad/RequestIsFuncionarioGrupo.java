package com.growdata.emprendimiento.business.dtos.seguridad;

/**
 * Clase solicitud es funcionario del grupo.
 *
 * @author Juan Franco
 */
public class RequestIsFuncionarioGrupo {

    /**
     * Nombre de usuario.
     */
    private String userName;
    /**
     * Grupo.
     */
    private String grupo;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param userName Valor a ser actualizado.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param grupo Valor a ser actualizado.
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}

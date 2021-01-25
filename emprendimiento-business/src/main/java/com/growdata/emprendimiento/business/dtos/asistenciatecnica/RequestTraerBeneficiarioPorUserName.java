package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;

/**
 * Clase solicitud beneficiario.
 *
 * @author Juan Franco
 */
public class RequestTraerBeneficiarioPorUserName {

    /**
     * Nombre de usuario.
     */
    private String userName;
    /**
     * Estado de usuario.
     */
    private BigDecimal estadoUsuario;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param userName Valor a ser actualizado.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadoUsuario Valor a ser actualizado.
     */
    public void setEstadoUsuario(BigDecimal estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}

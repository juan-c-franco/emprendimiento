/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

import com.growdata.emprendimiento.persistence.entidad.Users;
import java.sql.Timestamp;

/**
 * Clase solicitud log auditoria.
 *
 * @author Juan Franco
 */
public class RequestLogAuditoria {

    /**
     * Usuario.
     */
    private Users users;
    /**
     * Fecha de registro.
     */
    private Timestamp fecharegistro;
    /**
     * Módulo.
     */
    private String modulo;
    /**
     * Identificador del elemento.
     */
    private Long idelemento;
    /**
     * Acción.
     */
    private String accion;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param users Valor a ser actualizado.
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param modulo Valor a ser actualizado.
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Long getIdelemento() {
        return idelemento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idelemento Valor a ser actualizado.
     */
    public void setIdelemento(Long idelemento) {
        this.idelemento = idelemento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param accion Valor a ser actualizado.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}

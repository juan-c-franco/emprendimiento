/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

/**
 * Clase respuesta genérica.
 *
 * @author Juan Franco
 */
public class ResponseDTO {

    /**
     * Estado de la solicitud.
     */
    private String status;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Acción realizada.
     */
    private String accion;
    /**
     * Identificador.
     */
    private long id;

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

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getId() {
        return id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param status Valor a ser actualizado.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

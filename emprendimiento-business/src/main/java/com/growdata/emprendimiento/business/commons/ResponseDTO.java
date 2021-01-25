/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

/**
 * Clase respuesta gen�rica.
 *
 * @author Juan Franco
 */
public class ResponseDTO {

    /**
     * Estado de la solicitud.
     */
    private String status;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Acci�n realizada.
     */
    private String accion;
    /**
     * Identificador.
     */
    private long id;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param accion Valor a ser actualizado.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getId() {
        return id;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getStatus() {
        return status;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param status Valor a ser actualizado.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

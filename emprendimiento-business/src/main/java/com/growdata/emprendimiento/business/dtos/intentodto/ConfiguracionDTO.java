/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Clase representante de la entidad configuración.
 *
 * @author Juan Franco
 */
public class ConfiguracionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idconfiguracion;
    /**
     * Nombre de la configuración.
     */
    private String nombreconfiguracion;
    /**
     * Fecha última modificación.
     */
    private Timestamp fechamodificacion;
    /**
     * Activa o no.
     */
    private int valor;

    /**
     * Constructor.
     *
     * @param idconfiguracion Identificador.
     * @param nombreconfiguracion Nombre.
     * @param fechamodificacion Fecha última modificación.
     * @param valor Activa o no.
     */
    public ConfiguracionDTO(BigDecimal idconfiguracion,
            String nombreconfiguracion, Timestamp fechamodificacion,
            int valor) {
        this.idconfiguracion = idconfiguracion;
        this.nombreconfiguracion = nombreconfiguracion;
        this.fechamodificacion = fechamodificacion;
        this.valor = valor;
    }

    /**
     * Constructor.
     */
    public ConfiguracionDTO() {
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdconfiguracion() {
        return idconfiguracion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idconfiguracion Valor a ser actualizado.
     */
    public void setIdconfiguracion(BigDecimal idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreconfiguracion() {
        return nombreconfiguracion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreconfiguracion Valor a ser actualizado.
     */
    public void setNombreconfiguracion(String nombreconfiguracion) {
        this.nombreconfiguracion = nombreconfiguracion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechamodificacion() {
        return fechamodificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechamodificacion Valor a ser actualizado.
     */
    public void setFechamodificacion(Timestamp fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param valor Valor a ser actualizado.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}

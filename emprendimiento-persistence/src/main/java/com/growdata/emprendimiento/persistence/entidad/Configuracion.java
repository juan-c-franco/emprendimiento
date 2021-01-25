/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Configuracion implements java.io.Serializable {

    private BigDecimal idconfiguracion;
    private String nombreconfiguracion;
    private Timestamp fechamodificacion;
    private int valor;

    public Configuracion() {
    }

    public Configuracion(BigDecimal idconfiguracion, String nombreconfiguracion, Timestamp fechamodificacion, int valor) {
        this.idconfiguracion = idconfiguracion;
        this.nombreconfiguracion = nombreconfiguracion;
        this.fechamodificacion = fechamodificacion;
        this.valor = valor;
    }

    public BigDecimal getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(BigDecimal idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public String getNombreconfiguracion() {
        return nombreconfiguracion;
    }

    public void setNombreconfiguracion(String nombreconfiguracion) {
        this.nombreconfiguracion = nombreconfiguracion;
    }

    public Timestamp getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Timestamp fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

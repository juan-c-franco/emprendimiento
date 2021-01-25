/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestCategoria {

    private long idcategoria;
    private String nombrecategoria;
    private String descripcion;
    private short porcentajeaprobacion;
    private short calificacionaprobacion;

    public long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getPorcentajeaprobacion() {
        return porcentajeaprobacion;
    }

    public void setPorcentajeaprobacion(short porcentajeaprobacion) {
        this.porcentajeaprobacion = porcentajeaprobacion;
    }

    public short getCalificacionaprobacion() {
        return calificacionaprobacion;
    }

    public void setCalificacionaprobacion(short calificacionaprobacion) {
        this.calificacionaprobacion = calificacionaprobacion;
    }

}

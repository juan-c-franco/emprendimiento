/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.persistence.entidad.Categoria;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import java.util.Date;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestCapacitacion {

    private long idcapacitacionprograma;
    private Categoria categoria;
    private Estadocapacitacionprograma estadoCapacitacionPrograma;
    private long idoferenteinstitucion;
    private String nombrecapacitacionprograma;
    private Date fecharegistro;

    public long getIdcapacitacionprograma() {
        return idcapacitacionprograma;
    }

    public void setIdcapacitacionprograma(long idcapacitacionprograma) {
        this.idcapacitacionprograma = idcapacitacionprograma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estadocapacitacionprograma getEstadoCapacitacionPrograma() {
        return estadoCapacitacionPrograma;
    }

    public void setEstadoCapacitacionPrograma(Estadocapacitacionprograma estadoCapacitacionPrograma) {
        this.estadoCapacitacionPrograma = estadoCapacitacionPrograma;
    }

    public long getIdoferenteinstitucion() {
        return idoferenteinstitucion;
    }

    public void setIdoferenteinstitucion(long idoferenteinstitucion) {
        this.idoferenteinstitucion = idoferenteinstitucion;
    }

    public String getNombrecapacitacionprograma() {
        return nombrecapacitacionprograma;
    }

    public void setNombrecapacitacionprograma(String nombrecapacitacionprograma) {
        this.nombrecapacitacionprograma = nombrecapacitacionprograma;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

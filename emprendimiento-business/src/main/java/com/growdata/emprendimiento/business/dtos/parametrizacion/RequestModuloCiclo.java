/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import java.util.Date;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestModuloCiclo {

    private long idmodulociclo;
    private Capacitacionprograma capacitacionPrograma;
    private String nombremodulociclo;
    private short intensidadhoraria;
    private Date fecharegistro;

    public long getIdmodulociclo() {
        return idmodulociclo;
    }

    public void setIdmodulociclo(long idmodulociclo) {
        this.idmodulociclo = idmodulociclo;
    }

    public Capacitacionprograma getCapacitacionPrograma() {
        return capacitacionPrograma;
    }

    public void setCapacitacionPrograma(Capacitacionprograma capacitacionPrograma) {
        this.capacitacionPrograma = capacitacionPrograma;
    }

    public String getNombremodulociclo() {
        return nombremodulociclo;
    }

    public void setNombremodulociclo(String nombremodulociclo) {
        this.nombremodulociclo = nombremodulociclo;
    }

    public short getIntensidadhoraria() {
        return intensidadhoraria;
    }

    public void setIntensidadhoraria(short intensidadhoraria) {
        this.intensidadhoraria = intensidadhoraria;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

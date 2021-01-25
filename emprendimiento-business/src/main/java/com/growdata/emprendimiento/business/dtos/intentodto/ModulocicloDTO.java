/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Juan Franco
 */
public class ModulocicloDTO {

    private long idmodulociclo;
    private CapacitacionprogramaDTO capacitacionPrograma;
    private String nombremodulociclo;
    private short intensidadhoraria;
    private Date fecharegistro;
    private Set<SeguimientoasistenciaDTO> seguimientoAsistencias = new HashSet<SeguimientoasistenciaDTO>(0);

    public ModulocicloDTO() {
    }

    public ModulocicloDTO(long idmodulociclo, CapacitacionprogramaDTO capacitacionPrograma, String nombremodulociclo, short intensidadhoraria, Date fecharegistro) {
        this.idmodulociclo = idmodulociclo;
        this.capacitacionPrograma = capacitacionPrograma;
        this.nombremodulociclo = nombremodulociclo;
        this.intensidadhoraria = intensidadhoraria;
        this.fecharegistro = fecharegistro;
    }

    public long getIdmodulociclo() {
        return idmodulociclo;
    }

    public void setIdmodulociclo(long idmodulociclo) {
        this.idmodulociclo = idmodulociclo;
    }

    public CapacitacionprogramaDTO getCapacitacionPrograma() {
        return capacitacionPrograma;
    }

    public void setCapacitacionPrograma(CapacitacionprogramaDTO capacitacionPrograma) {
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

    public Set<SeguimientoasistenciaDTO> getSeguimientoAsistencias() {
        return seguimientoAsistencias;
    }

    public void setSeguimientoAsistencias(Set<SeguimientoasistenciaDTO> seguimientoAsistencias) {
        this.seguimientoAsistencias = seguimientoAsistencias;
    }

}

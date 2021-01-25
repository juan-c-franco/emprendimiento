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
 * Clase representante de la entidad Capacitacionprograma.
 *
 * @author Juan Franco
 */
public class CapacitacionprogramaDTO {

    /**
     * Identificador.
     */
    private long idcapacitacionprograma;
    /**
     * Categor�a.
     */
    private CategoriaDTO categoria;
    /**
     * Estado de la capacitaci�n.
     */
    private EstadocapacitacionprogramaDTO estadocapacitacionprograma;
    /**
     * Identificador oferente / instituci�n.
     */
    private long idoferenteinstitucion;
    /**
     * Nombre de la capacitaci�n.
     */
    private String nombrecapacitacionprograma;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Programaciones.
     */
    private Set<ProgramacionDTO> programacions
            = new HashSet<ProgramacionDTO>(0);
    /**
     * Modulos ciclo.
     */
    private Set<ModulocicloDTO> modulociclos = new HashSet<ModulocicloDTO>(0);

    /**
     * Constructor.
     */
    public CapacitacionprogramaDTO() {
    }

    /**
     * Constructor.
     *
     * @param idcapacitacionprograma Identificador.
     * @param categoria Categor�a.
     * @param estadocapacitacionprograma Estado de la capacitaci�n.
     * @param idoferenteinstitucion Identificador de la instituci�n oferente.
     * @param nombrecapacitacionprograma Nombre de la capacitaci�n.
     * @param fecharegistro Fecha de registro.
     */
    public CapacitacionprogramaDTO(long idcapacitacionprograma,
            CategoriaDTO categoria,
            EstadocapacitacionprogramaDTO estadocapacitacionprograma,
            long idoferenteinstitucion, String nombrecapacitacionprograma,
            Date fecharegistro) {
        this.idcapacitacionprograma = idcapacitacionprograma;
        this.categoria = categoria;
        this.estadocapacitacionprograma = estadocapacitacionprograma;
        this.idoferenteinstitucion = idoferenteinstitucion;
        this.nombrecapacitacionprograma = nombrecapacitacionprograma;
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdcapacitacionprograma() {
        return idcapacitacionprograma;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idcapacitacionprograma Valor a ser actualizado.
     */
    public void setIdcapacitacionprograma(long idcapacitacionprograma) {
        this.idcapacitacionprograma = idcapacitacionprograma;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadocapacitacionprogramaDTO getEstadocapacitacionprograma() {
        return estadocapacitacionprograma;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadocapacitacionprograma Valor a ser actualizado.
     */
    public void setEstadocapacitacionprograma(
            EstadocapacitacionprogramaDTO estadocapacitacionprograma) {
        this.estadocapacitacionprograma = estadocapacitacionprograma;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdoferenteinstitucion() {
        return idoferenteinstitucion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idoferenteinstitucion Valor a ser actualizado.
     */
    public void setIdoferenteinstitucion(long idoferenteinstitucion) {
        this.idoferenteinstitucion = idoferenteinstitucion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecapacitacionprograma() {
        return nombrecapacitacionprograma;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombrecapacitacionprograma Valor a ser actualizado.
     */
    public void setNombrecapacitacionprograma(
            String nombrecapacitacionprograma) {
        this.nombrecapacitacionprograma = nombrecapacitacionprograma;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ProgramacionDTO> getProgramacions() {
        return programacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param programacions Valor a ser actualizado.
     */
    public void setProgramacions(Set<ProgramacionDTO> programacions) {
        this.programacions = programacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ModulocicloDTO> getModulociclos() {
        return modulociclos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param modulociclos Valor a ser actualizado.
     */
    public void setModulociclos(Set<ModulocicloDTO> modulociclos) {
        this.modulociclos = modulociclos;
    }

}

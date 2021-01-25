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
     * Categoría.
     */
    private CategoriaDTO categoria;
    /**
     * Estado de la capacitación.
     */
    private EstadocapacitacionprogramaDTO estadocapacitacionprograma;
    /**
     * Identificador oferente / institución.
     */
    private long idoferenteinstitucion;
    /**
     * Nombre de la capacitación.
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
     * @param categoria Categoría.
     * @param estadocapacitacionprograma Estado de la capacitación.
     * @param idoferenteinstitucion Identificador de la institución oferente.
     * @param nombrecapacitacionprograma Nombre de la capacitación.
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
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdcapacitacionprograma() {
        return idcapacitacionprograma;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idcapacitacionprograma Valor a ser actualizado.
     */
    public void setIdcapacitacionprograma(long idcapacitacionprograma) {
        this.idcapacitacionprograma = idcapacitacionprograma;
    }

    /**
     * Método autogenerado para obtener una propiedad.
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
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadocapacitacionprogramaDTO getEstadocapacitacionprograma() {
        return estadocapacitacionprograma;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadocapacitacionprograma Valor a ser actualizado.
     */
    public void setEstadocapacitacionprograma(
            EstadocapacitacionprogramaDTO estadocapacitacionprograma) {
        this.estadocapacitacionprograma = estadocapacitacionprograma;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdoferenteinstitucion() {
        return idoferenteinstitucion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idoferenteinstitucion Valor a ser actualizado.
     */
    public void setIdoferenteinstitucion(long idoferenteinstitucion) {
        this.idoferenteinstitucion = idoferenteinstitucion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecapacitacionprograma() {
        return nombrecapacitacionprograma;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombrecapacitacionprograma Valor a ser actualizado.
     */
    public void setNombrecapacitacionprograma(
            String nombrecapacitacionprograma) {
        this.nombrecapacitacionprograma = nombrecapacitacionprograma;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ProgramacionDTO> getProgramacions() {
        return programacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param programacions Valor a ser actualizado.
     */
    public void setProgramacions(Set<ProgramacionDTO> programacions) {
        this.programacions = programacions;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ModulocicloDTO> getModulociclos() {
        return modulociclos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param modulociclos Valor a ser actualizado.
     */
    public void setModulociclos(Set<ModulocicloDTO> modulociclos) {
        this.modulociclos = modulociclos;
    }

}

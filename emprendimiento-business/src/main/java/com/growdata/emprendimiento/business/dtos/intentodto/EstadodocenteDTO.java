/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Estadodocente.
 *
 * @author Juan Franco
 */
public class EstadodocenteDTO {

    /**
     * Identificador.
     */
    private long idestadodocente;
    /**
     * Nombre del estado.
     */
    private String nombreestadodocente;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Docentes.
     */
    private Set<DocentesDTO> docenteses = new HashSet<DocentesDTO>(0);

    /**
     * Constructor.
     */
    public EstadodocenteDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadodocente Identificador.
     * @param nombreestadodocente Nombre del estado.
     * @param descripcion Descripción.
     */
    public EstadodocenteDTO(long idestadodocente, String nombreestadodocente,
            String descripcion) {
        this.idestadodocente = idestadodocente;
        this.nombreestadodocente = nombreestadodocente;
        this.descripcion = descripcion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdestadodocente() {
        return idestadodocente;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idestadodocente Valor a ser actualizado.
     */
    public void setIdestadodocente(long idestadodocente) {
        this.idestadodocente = idestadodocente;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadodocente() {
        return nombreestadodocente;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreestadodocente Valor a ser actualizado.
     */
    public void setNombreestadodocente(String nombreestadodocente) {
        this.nombreestadodocente = nombreestadodocente;
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

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<DocentesDTO> getDocenteses() {
        return docenteses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param docenteses Valor a ser actualizado.
     */
    public void setDocenteses(Set<DocentesDTO> docenteses) {
        this.docenteses = docenteses;
    }

}

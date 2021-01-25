/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Estadocapacitacionprograma.
 *
 * @author Juan Franco
 */
public class EstadocapacitacionprogramaDTO {

    /**
     * Identificador.
     */
    private long idestadocapacitacionprograma;
    /**
     * Nombre estado capacitación.
     */
    private String nombreestadocapacitacionprog;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Capacitaciones.
     */
    private Set<CapacitacionprogramaDTO> capacitacionprogramas
            = new HashSet<CapacitacionprogramaDTO>(0);

    /**
     * Constrcutor.
     */
    public EstadocapacitacionprogramaDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadocapacitacionprograma Identificador.
     * @param nombreestadocapacitacionprog Nombre del estado.
     * @param descripcion Descripción.
     */
    public EstadocapacitacionprogramaDTO(long idestadocapacitacionprograma,
            String nombreestadocapacitacionprog, String descripcion) {
        this.idestadocapacitacionprograma = idestadocapacitacionprograma;
        this.nombreestadocapacitacionprog = nombreestadocapacitacionprog;
        this.descripcion = descripcion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdestadocapacitacionprograma() {
        return idestadocapacitacionprograma;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idestadocapacitacionprograma Valor a ser actualizado.
     */
    public void setIdestadocapacitacionprograma(
            long idestadocapacitacionprograma) {
        this.idestadocapacitacionprograma = idestadocapacitacionprograma;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadocapacitacionprog() {
        return nombreestadocapacitacionprog;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreestadocapacitacionprog Valor a ser actualizado.
     */
    public void setNombreestadocapacitacionprog(
            String nombreestadocapacitacionprog) {
        this.nombreestadocapacitacionprog = nombreestadocapacitacionprog;
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
    public Set<CapacitacionprogramaDTO> getCapacitacionprogramas() {
        return capacitacionprogramas;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param capacitacionprogramas Valor a ser actualizado.
     */
    public void setCapacitacionprogramas(
            Set<CapacitacionprogramaDTO> capacitacionprogramas) {
        this.capacitacionprogramas = capacitacionprogramas;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad categoría.
 *
 * @author Juan Franco
 */
public class CategoriaDTO {

    /**
     * Identificador
     */
    private long idcategoria;
    /**
     * Nombre de la categoría.
     */
    private String nombrecategoria;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Porcentaje requerido para aprobar.
     */
    private short porcentajeaprobacion;
    /**
     * Calificación para aprobación.
     */
    private short calificacionaprobacion;
    /**
     * Capacitaciones.
     */
    private Set<CapacitacionprogramaDTO> capacitacionprogramas
            = new HashSet<CapacitacionprogramaDTO>(0);

    /**
     * Constructor.
     */
    public CategoriaDTO() {
    }

    /**
     * Constructor.
     *
     * @param idcategoria Identificador.
     * @param nombrecategoria Nombre de la categoría.
     * @param descripcion Descripción.
     * @param porcentajeaprobacion Porcentaje aprobación.
     * @param calificacionaprobacion Calificación necesaria.
     */
    public CategoriaDTO(long idcategoria, String nombrecategoria,
            String descripcion, short porcentajeaprobacion,
            short calificacionaprobacion) {
        this.idcategoria = idcategoria;
        this.nombrecategoria = nombrecategoria;
        this.descripcion = descripcion;
        this.porcentajeaprobacion = porcentajeaprobacion;
        this.calificacionaprobacion = calificacionaprobacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdcategoria() {
        return idcategoria;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idcategoria Valor a ser actualizado.
     */
    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecategoria() {
        return nombrecategoria;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombrecategoria Valor a ser actualizado.
     */
    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
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
    public short getPorcentajeaprobacion() {
        return porcentajeaprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param porcentajeaprobacion Valor a ser actualizado.
     */
    public void setPorcentajeaprobacion(short porcentajeaprobacion) {
        this.porcentajeaprobacion = porcentajeaprobacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getCalificacionaprobacion() {
        return calificacionaprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param calificacionaprobacion Valor a ser actualizado.
     */
    public void setCalificacionaprobacion(short calificacionaprobacion) {
        this.calificacionaprobacion = calificacionaprobacion;
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

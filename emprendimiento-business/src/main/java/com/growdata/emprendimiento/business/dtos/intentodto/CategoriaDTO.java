/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad categor�a.
 *
 * @author Juan Franco
 */
public class CategoriaDTO {

    /**
     * Identificador
     */
    private long idcategoria;
    /**
     * Nombre de la categor�a.
     */
    private String nombrecategoria;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Porcentaje requerido para aprobar.
     */
    private short porcentajeaprobacion;
    /**
     * Calificaci�n para aprobaci�n.
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
     * @param nombrecategoria Nombre de la categor�a.
     * @param descripcion Descripci�n.
     * @param porcentajeaprobacion Porcentaje aprobaci�n.
     * @param calificacionaprobacion Calificaci�n necesaria.
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
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdcategoria() {
        return idcategoria;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idcategoria Valor a ser actualizado.
     */
    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecategoria() {
        return nombrecategoria;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombrecategoria Valor a ser actualizado.
     */
    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getPorcentajeaprobacion() {
        return porcentajeaprobacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param porcentajeaprobacion Valor a ser actualizado.
     */
    public void setPorcentajeaprobacion(short porcentajeaprobacion) {
        this.porcentajeaprobacion = porcentajeaprobacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getCalificacionaprobacion() {
        return calificacionaprobacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacionaprobacion Valor a ser actualizado.
     */
    public void setCalificacionaprobacion(short calificacionaprobacion) {
        this.calificacionaprobacion = calificacionaprobacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<CapacitacionprogramaDTO> getCapacitacionprogramas() {
        return capacitacionprogramas;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param capacitacionprogramas Valor a ser actualizado.
     */
    public void setCapacitacionprogramas(
            Set<CapacitacionprogramaDTO> capacitacionprogramas) {
        this.capacitacionprogramas = capacitacionprogramas;
    }

}

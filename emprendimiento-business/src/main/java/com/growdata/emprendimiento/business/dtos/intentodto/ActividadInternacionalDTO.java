package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la tabla Actividad Internacional.
 *
 * @author Juan Franco
 */
public class ActividadInternacionalDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idactividadinternacional;
    /**
     * Nombre de la actividad internacional.
     */
    private String nombreactividadinternacional;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Emprendimientos formalizados.
     */
    private Set<FormalizadoDTO> formalizados = new HashSet<FormalizadoDTO>(0);

    /**
     * Constructor.
     */
    public ActividadInternacionalDTO() {
    }

    /**
     * Constructor.
     *
     * @param idactividadinternacional Identificador.
     * @param nombreactividadinternacional Nombre de la actividad.
     */
    public ActividadInternacionalDTO(BigDecimal idactividadinternacional,
            String nombreactividadinternacional) {
        this.idactividadinternacional = idactividadinternacional;
        this.nombreactividadinternacional = nombreactividadinternacional;
    }

    /**
     * Constructor.
     *
     * @param idactividadinternacional Identificador.
     * @param nombreactividadinternacional Nombre de la actividad.
     * @param descripcion Descripción.
     * @param formalizados Conjunto de emprendimientos formalizados.
     */
    public ActividadInternacionalDTO(BigDecimal idactividadinternacional,
            String nombreactividadinternacional, String descripcion,
            Set<FormalizadoDTO> formalizados) {
        this.idactividadinternacional = idactividadinternacional;
        this.nombreactividadinternacional = nombreactividadinternacional;
        this.descripcion = descripcion;
        this.formalizados = formalizados;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdactividadinternacional() {
        return this.idactividadinternacional;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idactividadinternacional Valor a ser actualizado.
     */
    public void setIdactividadinternacional(
            BigDecimal idactividadinternacional) {
        this.idactividadinternacional = idactividadinternacional;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreactividadinternacional() {
        return this.nombreactividadinternacional;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreactividadinternacional Valor a ser actualizado.
     */
    public void setNombreactividadinternacional(
            String nombreactividadinternacional) {
        this.nombreactividadinternacional = nombreactividadinternacional;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return this.descripcion;
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
    public Set<FormalizadoDTO> getFormalizados() {
        return this.formalizados;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param formalizados Valor a ser actualizado.
     */
    public void setFormalizados(Set<FormalizadoDTO> formalizados) {
        this.formalizados = formalizados;
    }

}

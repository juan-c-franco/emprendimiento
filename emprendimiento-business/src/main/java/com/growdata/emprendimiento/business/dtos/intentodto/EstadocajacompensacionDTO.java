package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad estadocajacompensacion.
 *
 * @author Juan Franco
 */
public class EstadocajacompensacionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idestadocajacompensacion;
    /**
     * Nombre del estado.
     */
    private String nombreestadocaja;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * CCF
     */
    private Set<CajacompensacionDTO> cajacompensacions
            = new HashSet<CajacompensacionDTO>(0);

    /**
     * Constructor.
     */
    public EstadocajacompensacionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadocajacompensacion Identificador.
     */
    public EstadocajacompensacionDTO(BigDecimal idestadocajacompensacion) {
        this.idestadocajacompensacion = idestadocajacompensacion;
    }

    /**
     * Constructor.
     *
     * @param idestadocajacompensacion Identificador.
     * @param nombreestadocaja Nombre del estado.
     * @param descripcion Descripci�n.
     * @param cajacompensacions Cajas de compensaci�n.
     */
    public EstadocajacompensacionDTO(BigDecimal idestadocajacompensacion,
            String nombreestadocaja, String descripcion,
            Set<CajacompensacionDTO> cajacompensacions) {
        this.idestadocajacompensacion = idestadocajacompensacion;
        this.nombreestadocaja = nombreestadocaja;
        this.descripcion = descripcion;
        this.cajacompensacions = cajacompensacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadocajacompensacion() {
        return this.idestadocajacompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idestadocajacompensacion Valor a ser actualizado.
     */
    public void setIdestadocajacompensacion(
            BigDecimal idestadocajacompensacion) {
        this.idestadocajacompensacion = idestadocajacompensacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadocaja() {
        return this.nombreestadocaja;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreestadocaja Valor a ser actualizado.
     */
    public void setNombreestadocaja(String nombreestadocaja) {
        this.nombreestadocaja = nombreestadocaja;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return this.descripcion;
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
    public Set<CajacompensacionDTO> getCajacompensacions() {
        return this.cajacompensacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param cajacompensacions Valor a ser actualizado.
     */
    public void setCajacompensacions(
            Set<CajacompensacionDTO> cajacompensacions) {
        this.cajacompensacions = cajacompensacions;
    }

}

package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Comiteevaluacion.
 *
 * @author Juan Franco
 */
public class ComiteevaluacionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idcomite;
    /**
     * Caja de compensaci�n.
     */
    private CajacompensacionDTO cajacompensacion;
    /**
     * Nombre del comit�
     */
    private String nombrecomite;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Sesiones comit�.
     */
    private Set<SesioncomiteDTO> sesioncomites
            = new HashSet<SesioncomiteDTO>(0);
    /**
     * Integrantes comit�.
     */
    private Set<IntegrantescomiteDTO> integrantescomites
            = new HashSet<IntegrantescomiteDTO>(0);

    /**
     * Constructor.
     */
    public ComiteevaluacionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idcomite Identificador.
     * @param cajacompensacion Caja de compensaci�n.
     */
    public ComiteevaluacionDTO(BigDecimal idcomite,
            CajacompensacionDTO cajacompensacion) {
        this.idcomite = idcomite;
        this.cajacompensacion = cajacompensacion;
    }

    /**
     * Constructor.
     *
     * @param idcomite Identificador.
     * @param cajacompensacion Caja de compensaci�n.
     * @param nombrecomite Nombre del comit�.
     * @param fecharegistro Fecha de registro.
     * @param descripcion Descripci�n.
     * @param sesioncomites Sesiones comit�.
     * @param integrantescomites Integrantes comit�.
     */
    public ComiteevaluacionDTO(BigDecimal idcomite,
            CajacompensacionDTO cajacompensacion, String nombrecomite,
            Date fecharegistro, String descripcion,
            Set<SesioncomiteDTO> sesioncomites,
            Set<IntegrantescomiteDTO> integrantescomites) {
        this.idcomite = idcomite;
        this.cajacompensacion = cajacompensacion;
        this.nombrecomite = nombrecomite;
        this.fecharegistro = fecharegistro;
        this.descripcion = descripcion;
        this.sesioncomites = sesioncomites;
        this.integrantescomites = integrantescomites;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdcomite() {
        return this.idcomite;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idcomite Valor a ser actualizado.
     */
    public void setIdcomite(BigDecimal idcomite) {
        this.idcomite = idcomite;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public CajacompensacionDTO getCajacompensacion() {
        return this.cajacompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param cajacompensacion Valor a ser actualizado.
     */
    public void setCajacompensacion(CajacompensacionDTO cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecomite() {
        return this.nombrecomite;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombrecomite Valor a ser actualizado.
     */
    public void setNombrecomite(String nombrecomite) {
        this.nombrecomite = nombrecomite;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return this.fecharegistro;
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
    public Set<SesioncomiteDTO> getSesioncomites() {
        return this.sesioncomites;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesioncomites Valor a ser actualizado.
     */
    public void setSesioncomites(Set<SesioncomiteDTO> sesioncomites) {
        this.sesioncomites = sesioncomites;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<IntegrantescomiteDTO> getIntegrantescomites() {
        return this.integrantescomites;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param integrantescomites Valor a ser actualizado.
     */
    public void setIntegrantescomites(
            Set<IntegrantescomiteDTO> integrantescomites) {
        this.integrantescomites = integrantescomites;
    }

}

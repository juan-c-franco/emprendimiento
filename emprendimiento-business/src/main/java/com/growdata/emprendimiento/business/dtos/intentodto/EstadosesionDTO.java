package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Estadosesi�n.
 *
 * @author Juan Franco
 */
public class EstadosesionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idestadosesion;
    /**
     * Nombre del estado.
     */
    private String nombreestadosesion;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Sesiones AAT.
     */
    private Set<SesionacompanamientoatDTO> sesionacompanamientoats
            = new HashSet<SesionacompanamientoatDTO>(0);
    /**
     * Sesiones Comit�.
     */
    private Set<SesioncomiteDTO> sesioncomites
            = new HashSet<SesioncomiteDTO>(0);
    /**
     * Sesiones.
     */
    private Set<SesionesDTO> sesioneses = new HashSet<SesionesDTO>(0);

    /**
     * Constructor.
     */
    public EstadosesionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadosesion Identificador.
     */
    public EstadosesionDTO(BigDecimal idestadosesion) {
        this.idestadosesion = idestadosesion;
    }

    /**
     * Constructor.
     *
     * @param idestadosesion Identificador.
     * @param nombreestadosesion Nombre del estado.
     * @param descripcion Descripci�n.
     * @param sesionacompanamientoats Sesiones AAT.
     * @param sesioncomites Sesiones comit�.
     * @param sesioneses Sesiones.
     */
    public EstadosesionDTO(BigDecimal idestadosesion, String nombreestadosesion,
            String descripcion,
            Set<SesionacompanamientoatDTO> sesionacompanamientoats,
            Set<SesioncomiteDTO> sesioncomites, Set<SesionesDTO> sesioneses) {
        this.idestadosesion = idestadosesion;
        this.nombreestadosesion = nombreestadosesion;
        this.descripcion = descripcion;
        this.sesionacompanamientoats = sesionacompanamientoats;
        this.sesioncomites = sesioncomites;
        this.sesioneses = sesioneses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadosesion() {
        return this.idestadosesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idestadosesion Valor a ser actualizado.
     */
    public void setIdestadosesion(BigDecimal idestadosesion) {
        this.idestadosesion = idestadosesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadosesion() {
        return this.nombreestadosesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreestadosesion Valor a ser actualizado.
     */
    public void setNombreestadosesion(String nombreestadosesion) {
        this.nombreestadosesion = nombreestadosesion;
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
    public Set<SesionacompanamientoatDTO> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionacompanamientoats Valor a ser actualizado.
     */
    public void setSesionacompanamientoats(
            Set<SesionacompanamientoatDTO> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
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
    public Set<SesionesDTO> getSesioneses() {
        return this.sesioneses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesioneses Valor a ser actualizado.
     */
    public void setSesioneses(Set<SesionesDTO> sesioneses) {
        this.sesioneses = sesioneses;
    }
}

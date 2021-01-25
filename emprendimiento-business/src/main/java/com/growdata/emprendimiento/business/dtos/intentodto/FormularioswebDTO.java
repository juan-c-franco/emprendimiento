package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad formularios web.
 *
 * @author Juan Franco
 */
public class FormularioswebDTO implements java.io.Serializable {

    /**
     * Identificador del formulario.
     */
    private BigDecimal idformulario;
    /**
     * Identificador del formulario padre.
     */
    private BigDecimal idformulariopadre;
    /**
     * Nombre del enlace.
     */
    private String etiqueta;
    /**
     * Descripci�n del enlace.
     */
    private String tooltip;
    /**
     * URL a donde dirige el enlace.
     */
    private String urlformulario;
    /**
     * Ubicaci�n en el submen�.
     */
    private BigDecimal posicion;
    /**
     * Roles necesarios para ver el enlace.
     */
    private String authorities;
    /**
     * Permisos.
     */
    private Set<PermisosDTO> permisoses = new HashSet<PermisosDTO>(0);

    /**
     * Constructor.
     */
    public FormularioswebDTO() {
    }

    /**
     * Constructor.
     *
     * @param idformulario Identificador del formulario.
     */
    public FormularioswebDTO(BigDecimal idformulario) {
        this.idformulario = idformulario;
    }

    /**
     * Constructor.
     *
     * @param idformulario Identificador del formulario.
     * @param idformulariopadre Identificador del formulario padre.
     * @param etiqueta Nombre del enlace.
     * @param tooltip Descripci�n del enlace.
     * @param urlformulario URL a donde dirige el enlace.
     * @param posicion Ubicaci�n en el submen�.
     * @param authorities Roles que pueden ver el enlace.
     * @param permisoses Permisos.
     */
    public FormularioswebDTO(BigDecimal idformulario,
            BigDecimal idformulariopadre, String etiqueta, String tooltip,
            String urlformulario, BigDecimal posicion, String authorities,
            Set<PermisosDTO> permisoses) {
        this.idformulario = idformulario;
        this.idformulariopadre = idformulariopadre;
        this.etiqueta = etiqueta;
        this.tooltip = tooltip;
        this.urlformulario = urlformulario;
        this.posicion = posicion;
        this.authorities = authorities;
        this.permisoses = permisoses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdformulario() {
        return this.idformulario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idformulario Valor a ser actualizado.
     */
    public void setIdformulario(BigDecimal idformulario) {
        this.idformulario = idformulario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdformulariopadre() {
        return this.idformulariopadre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idformulariopadre Valor a ser actualizado.
     */
    public void setIdformulariopadre(BigDecimal idformulariopadre) {
        this.idformulariopadre = idformulariopadre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param etiqueta Valor a ser actualizado.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getTooltip() {
        return this.tooltip;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tooltip Valor a ser actualizado.
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUrlformulario() {
        return this.urlformulario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param urlformulario Valor a ser actualizado.
     */
    public void setUrlformulario(String urlformulario) {
        this.urlformulario = urlformulario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getPosicion() {
        return this.posicion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param posicion Valor a ser actualizado.
     */
    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAuthorities() {
        return this.authorities;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param authorities Valor a ser actualizado.
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<PermisosDTO> getPermisoses() {
        return this.permisoses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param permisoses Valor a ser actualizado.
     */
    public void setPermisoses(Set<PermisosDTO> permisoses) {
        this.permisoses = permisoses;
    }

}

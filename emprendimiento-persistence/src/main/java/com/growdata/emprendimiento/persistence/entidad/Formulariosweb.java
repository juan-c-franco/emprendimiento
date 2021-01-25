package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

public class Formulariosweb implements java.io.Serializable {

    private BigDecimal idformulario;
    private BigDecimal idformulariopadre;
    private String etiqueta;
    private String tooltip;
    private String urlformulario;
    private BigDecimal posicion;
    private String authorities;
    private String iconomenu;

    public Formulariosweb() {
    }

    public Formulariosweb(BigDecimal idformulario) {
        this.idformulario = idformulario;
    }

    public Formulariosweb(BigDecimal idformulario, BigDecimal idformulariopadre, String etiqueta, String tooltip, String urlformulario, BigDecimal posicion, String authorities) {
        this.idformulario = idformulario;
        this.idformulariopadre = idformulariopadre;
        this.etiqueta = etiqueta;
        this.tooltip = tooltip;
        this.urlformulario = urlformulario;
        this.posicion = posicion;
        this.authorities = authorities;
    }

    public BigDecimal getIdformulario() {
        return this.idformulario;
    }

    public void setIdformulario(BigDecimal idformulario) {
        this.idformulario = idformulario;
    }

    public BigDecimal getIdformulariopadre() {
        return this.idformulariopadre;
    }

    public void setIdformulariopadre(BigDecimal idformulariopadre) {
        this.idformulariopadre = idformulariopadre;
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getUrlformulario() {
        return this.urlformulario;
    }

    public void setUrlformulario(String urlformulario) {
        this.urlformulario = urlformulario;
    }

    public BigDecimal getPosicion() {
        return this.posicion;
    }

    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getIconomenu() {
        return iconomenu;
    }

    public void setIconomenu(String iconomenu) {
        this.iconomenu = iconomenu;
    }

}

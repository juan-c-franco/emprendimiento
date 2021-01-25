package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Comiteevaluacion implements java.io.Serializable {

    private BigDecimal idcomite;
    private Cajacompensacion cajacompensacion;
    private String nombrecomite;
    private Date fecharegistro;
    private String descripcion;
    private Set<Sesioncomite> sesioncomites = new HashSet<Sesioncomite>(0);
    private Set<Integrantescomite> integrantescomites = new HashSet<Integrantescomite>(0);

    public Comiteevaluacion() {
    }

    public Comiteevaluacion(BigDecimal idcomite, Cajacompensacion cajacompensacion) {
        this.idcomite = idcomite;
        this.cajacompensacion = cajacompensacion;
    }

    public Comiteevaluacion(BigDecimal idcomite, Cajacompensacion cajacompensacion, String nombrecomite, Date fecharegistro, String descripcion, Set<Sesioncomite> sesioncomites, Set<Integrantescomite> integrantescomites) {
        this.idcomite = idcomite;
        this.cajacompensacion = cajacompensacion;
        this.nombrecomite = nombrecomite;
        this.fecharegistro = fecharegistro;
        this.descripcion = descripcion;
        this.sesioncomites = sesioncomites;
        this.integrantescomites = integrantescomites;
    }

    public BigDecimal getIdcomite() {
        return this.idcomite;
    }

    public void setIdcomite(BigDecimal idcomite) {
        this.idcomite = idcomite;
    }

    public Cajacompensacion getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(Cajacompensacion cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public String getNombrecomite() {
        return this.nombrecomite;
    }

    public void setNombrecomite(String nombrecomite) {
        this.nombrecomite = nombrecomite;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Sesioncomite> getSesioncomites() {
        return this.sesioncomites;
    }

    public void setSesioncomites(Set<Sesioncomite> sesioncomites) {
        this.sesioncomites = sesioncomites;
    }

    public Set<Integrantescomite> getIntegrantescomites() {
        return this.integrantescomites;
    }

    public void setIntegrantescomites(Set<Integrantescomite> integrantescomites) {
        this.integrantescomites = integrantescomites;
    }

}

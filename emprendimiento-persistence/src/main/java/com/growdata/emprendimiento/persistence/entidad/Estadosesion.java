package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Estadosesion implements java.io.Serializable {

    private BigDecimal idestadosesion;
    private String nombreestadosesion;
    private String descripcion;
    private Set<Sesionacompanamientoat> sesionacompanamientoats = new HashSet<Sesionacompanamientoat>(0);
    private Set<Sesioncomite> sesioncomites = new HashSet<Sesioncomite>(0);
    private Set<Sesiones> sesioneses = new HashSet<Sesiones>(0);
    private Set<Programacion> programaciones = new HashSet<Programacion>(0);

    public Estadosesion() {
    }

    public Estadosesion(BigDecimal idestadosesion) {
        this.idestadosesion = idestadosesion;
    }

    public Estadosesion(BigDecimal idestadosesion, String nombreestadosesion, String descripcion, Set<Sesionacompanamientoat> sesionacompanamientoats, Set<Sesioncomite> sesioncomites, Set<Sesiones> sesioneses, Set<Programacion> programaciones) {
        this.idestadosesion = idestadosesion;
        this.nombreestadosesion = nombreestadosesion;
        this.descripcion = descripcion;
        this.sesionacompanamientoats = sesionacompanamientoats;
        this.sesioncomites = sesioncomites;
        this.sesioneses = sesioneses;
        this.programaciones = programaciones;
    }

    public BigDecimal getIdestadosesion() {
        return this.idestadosesion;
    }

    public void setIdestadosesion(BigDecimal idestadosesion) {
        this.idestadosesion = idestadosesion;
    }

    public String getNombreestadosesion() {
        return this.nombreestadosesion;
    }

    public void setNombreestadosesion(String nombreestadosesion) {
        this.nombreestadosesion = nombreestadosesion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Sesionacompanamientoat> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    public void setSesionacompanamientoats(Set<Sesionacompanamientoat> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    public Set<Sesioncomite> getSesioncomites() {
        return this.sesioncomites;
    }

    public void setSesioncomites(Set<Sesioncomite> sesioncomites) {
        this.sesioncomites = sesioncomites;
    }

    public Set<Sesiones> getSesioneses() {
        return this.sesioneses;
    }

    public void setSesioneses(Set<Sesiones> sesioneses) {
        this.sesioneses = sesioneses;
    }

    public Set<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(Set<Programacion> programaciones) {
        this.programaciones = programaciones;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipoencuesta implements java.io.Serializable {

    private BigDecimal idtipoencuesta;
    private String nombreencuesta;
    private String descripcion;
    private Set<Encuesta> encuestas = new HashSet<Encuesta>(0);

    public Tipoencuesta() {
    }

    public Tipoencuesta(BigDecimal idtipoencuesta) {
        this.idtipoencuesta = idtipoencuesta;
    }

    public Tipoencuesta(BigDecimal idtipoencuesta, String nombreencuesta, String descripcion, Set<Encuesta> encuestas) {
        this.idtipoencuesta = idtipoencuesta;
        this.nombreencuesta = nombreencuesta;
        this.descripcion = descripcion;
        this.encuestas = encuestas;
    }

    public BigDecimal getIdtipoencuesta() {
        return this.idtipoencuesta;
    }

    public void setIdtipoencuesta(BigDecimal idtipoencuesta) {
        this.idtipoencuesta = idtipoencuesta;
    }

    public String getNombreencuesta() {
        return this.nombreencuesta;
    }

    public void setNombreencuesta(String nombreencuesta) {
        this.nombreencuesta = nombreencuesta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Encuesta> getEncuestas() {
        return this.encuestas;
    }

    public void setEncuestas(Set<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

}

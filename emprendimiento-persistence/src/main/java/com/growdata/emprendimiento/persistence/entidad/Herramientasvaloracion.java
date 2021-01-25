package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Herramientasvaloracion implements java.io.Serializable {

    private BigDecimal idherramienta;
    private String nombreherramienta;
    private String descripcion;
    private Set<Preguntas> preguntases = new HashSet<Preguntas>(0);
    private Set<Temasevaluacion> temasevaluacions = new HashSet<Temasevaluacion>(0);

    public Herramientasvaloracion() {
    }

    public Herramientasvaloracion(BigDecimal idherramienta) {
        this.idherramienta = idherramienta;
    }

    public Herramientasvaloracion(BigDecimal idherramienta, String nombreherramienta, String descripcion, Set<Preguntas> preguntases, Set<Temasevaluacion> temasevaluacions) {
        this.idherramienta = idherramienta;
        this.nombreherramienta = nombreherramienta;
        this.descripcion = descripcion;
        this.preguntases = preguntases;
        this.temasevaluacions = temasevaluacions;
    }
    
    public BigDecimal getIdherramienta() {
        return this.idherramienta;
    }

    public void setIdherramienta(BigDecimal idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getNombreherramienta() {
        return this.nombreherramienta;
    }

    public void setNombreherramienta(String nombreherramienta) {
        this.nombreherramienta = nombreherramienta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Preguntas> getPreguntases() {
        return this.preguntases;
    }

    public void setPreguntases(Set<Preguntas> preguntases) {
        this.preguntases = preguntases;
    }

    public Set<Temasevaluacion> getTemasevaluacions() {
        return this.temasevaluacions;
    }

    public void setTemasevaluacions(Set<Temasevaluacion> temasevaluacions) {
        this.temasevaluacions = temasevaluacions;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Preguntas implements java.io.Serializable {

    private BigDecimal idpregunta;
    private Cajacompensacion cajacompensacion;
    private Herramientasvaloracion herramientasvaloracion;
    private Temasevaluacion temasevaluacion;
    private String textopregunta;
    private Date fecharegistro;
    private Set<Respuestasencuesta> respuestasencuestas = new HashSet<Respuestasencuesta>(0);

    public Preguntas() {
    }

    public Preguntas(BigDecimal idpregunta, Cajacompensacion cajacompensacion, Herramientasvaloracion herramientasvaloracion, Temasevaluacion temasevaluacion) {
        this.idpregunta = idpregunta;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
        this.temasevaluacion = temasevaluacion;
    }

    public Preguntas(BigDecimal idpregunta, Cajacompensacion cajacompensacion, Herramientasvaloracion herramientasvaloracion, Temasevaluacion temasevaluacion, String textopregunta, Date fecharegistro, Set<Respuestasencuesta> respuestasencuestas) {
        this.idpregunta = idpregunta;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
        this.temasevaluacion = temasevaluacion;
        this.textopregunta = textopregunta;
        this.fecharegistro = fecharegistro;
        this.respuestasencuestas = respuestasencuestas;
    }

    public BigDecimal getIdpregunta() {
        return this.idpregunta;
    }

    public void setIdpregunta(BigDecimal idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Cajacompensacion getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(Cajacompensacion cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public Herramientasvaloracion getHerramientasvaloracion() {
        return this.herramientasvaloracion;
    }

    public void setHerramientasvaloracion(Herramientasvaloracion herramientasvaloracion) {
        this.herramientasvaloracion = herramientasvaloracion;
    }

    public Temasevaluacion getTemasevaluacion() {
        return this.temasevaluacion;
    }

    public void setTemasevaluacion(Temasevaluacion temasevaluacion) {
        this.temasevaluacion = temasevaluacion;
    }

    public String getTextopregunta() {
        return this.textopregunta;
    }

    public void setTextopregunta(String textopregunta) {
        this.textopregunta = textopregunta;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Respuestasencuesta> getRespuestasencuestas() {
        return this.respuestasencuestas;
    }

    public void setRespuestasencuestas(Set<Respuestasencuesta> respuestasencuestas) {
        this.respuestasencuestas = respuestasencuestas;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class Respuestasencuesta implements java.io.Serializable {

    private long idrespuesta;
    private Encuesta encuesta;
    private Preguntas preguntas;
    private String respuesta;
    private Date fecharegistro;

    public Respuestasencuesta() {
    }

    public Respuestasencuesta(long idrespuesta, Encuesta encuesta, Preguntas preguntas) {
        this.idrespuesta = idrespuesta;
        this.encuesta = encuesta;
        this.preguntas = preguntas;
    }

    public Respuestasencuesta(long idrespuesta, Encuesta encuesta, Preguntas preguntas, String respuesta, Date fecharegistro) {
        this.idrespuesta = idrespuesta;
        this.encuesta = encuesta;
        this.preguntas = preguntas;
        this.respuesta = respuesta;
        this.fecharegistro = fecharegistro;
    }

    public long getIdrespuesta() {
        return this.idrespuesta;
    }

    public void setIdrespuesta(long idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public Encuesta getEncuesta() {
        return this.encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Preguntas getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

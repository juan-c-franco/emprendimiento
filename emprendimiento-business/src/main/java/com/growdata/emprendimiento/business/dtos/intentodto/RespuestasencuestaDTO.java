package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class RespuestasencuestaDTO implements java.io.Serializable {

    private long idrespuesta;
    private EncuestaDTO encuesta;
    private PreguntasDTO preguntas;
    private String respuesta;
    private Date fecharegistro;

    public RespuestasencuestaDTO() {
    }

    public RespuestasencuestaDTO(long idrespuesta, EncuestaDTO encuesta, PreguntasDTO preguntas) {
        this.idrespuesta = idrespuesta;
        this.encuesta = encuesta;
        this.preguntas = preguntas;
    }

    public RespuestasencuestaDTO(long idrespuesta, EncuestaDTO encuesta, PreguntasDTO preguntas, String respuesta, Date fecharegistro) {
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

    public EncuestaDTO getEncuesta() {
        return this.encuesta;
    }

    public void setEncuesta(EncuestaDTO encuesta) {
        this.encuesta = encuesta;
    }

    public PreguntasDTO getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(PreguntasDTO preguntas) {
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

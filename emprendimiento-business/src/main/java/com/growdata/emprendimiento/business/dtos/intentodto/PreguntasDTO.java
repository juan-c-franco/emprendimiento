package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PreguntasDTO implements java.io.Serializable {

    private BigDecimal idpregunta;
    private CajacompensacionDTO cajacompensacion;
    private HerramientasvaloracionDTO herramientasvaloracion;
    private TemasevaluacionDTO temasevaluacion;
    private String textopregunta;
    private Date fecharegistro;
    private Set<RespuestasencuestaDTO> respuestasencuestas = new HashSet<RespuestasencuestaDTO>(0);

    public PreguntasDTO() {
    }

    public PreguntasDTO(BigDecimal idpregunta, CajacompensacionDTO cajacompensacion, HerramientasvaloracionDTO herramientasvaloracion, TemasevaluacionDTO temasevaluacion) {
        this.idpregunta = idpregunta;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
        this.temasevaluacion = temasevaluacion;
    }

    public PreguntasDTO(BigDecimal idpregunta, CajacompensacionDTO cajacompensacion, HerramientasvaloracionDTO herramientasvaloracion, TemasevaluacionDTO temasevaluacion, String textopregunta, Date fecharegistro, Set<RespuestasencuestaDTO> respuestasencuestas) {
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

    public CajacompensacionDTO getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(CajacompensacionDTO cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public HerramientasvaloracionDTO getHerramientasvaloracion() {
        return this.herramientasvaloracion;
    }

    public void setHerramientasvaloracion(HerramientasvaloracionDTO herramientasvaloracion) {
        this.herramientasvaloracion = herramientasvaloracion;
    }

    public TemasevaluacionDTO getTemasevaluacion() {
        return this.temasevaluacion;
    }

    public void setTemasevaluacion(TemasevaluacionDTO temasevaluacion) {
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

    public Set<RespuestasencuestaDTO> getRespuestasencuestas() {
        return this.respuestasencuestas;
    }

    public void setRespuestasencuestas(Set<RespuestasencuestaDTO> respuestasencuestas) {
        this.respuestasencuestas = respuestasencuestas;
    }

}

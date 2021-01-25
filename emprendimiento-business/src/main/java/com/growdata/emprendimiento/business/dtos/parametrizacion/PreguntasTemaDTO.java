package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PreguntasTemaDTO {

    private BigDecimal idpregunta;
    private CajacompensacionDTO cajaCompensacionDTO;
    private HerramientaValoracionDTO herramientaValoracionDTO;
    private TemasEvaluacionDTO temaEvaluacionDTO;
    private String textopregunta;
    private Date fecharegistro;
    private Set<Respuestasencuesta> respuestasencuestas = new HashSet<Respuestasencuesta>(0);

    public PreguntasTemaDTO() {
    }

    public PreguntasTemaDTO(BigDecimal idpregunta, CajacompensacionDTO cajaCompensacionDTO, HerramientaValoracionDTO herramientaValoracionDTO, TemasEvaluacionDTO temaEvaluacionDTO) {
        this.idpregunta = idpregunta;
        this.cajaCompensacionDTO = cajaCompensacionDTO;
        this.herramientaValoracionDTO = herramientaValoracionDTO;
        this.temaEvaluacionDTO = temaEvaluacionDTO;
    }

    public PreguntasTemaDTO(BigDecimal idpregunta, CajacompensacionDTO cajaCompensacionDTO, HerramientaValoracionDTO herramientaValoracionDTO, TemasEvaluacionDTO temaEvaluacionDTO, String textopregunta, Date fecharegistro, Set<Respuestasencuesta> respuestasencuestas) {
        this.idpregunta = idpregunta;
        this.cajaCompensacionDTO = cajaCompensacionDTO;
        this.herramientaValoracionDTO = herramientaValoracionDTO;
        this.temaEvaluacionDTO = temaEvaluacionDTO;
        this.textopregunta = textopregunta;
        this.fecharegistro = fecharegistro;
        this.respuestasencuestas = respuestasencuestas;
    }

    public BigDecimal getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(BigDecimal idpregunta) {
        this.idpregunta = idpregunta;
    }

    public CajacompensacionDTO getCajaCompensacionDTO() {
        return cajaCompensacionDTO;
    }

    public void setCajaCompensacionDTO(CajacompensacionDTO cajaCompensacionDTO) {
        this.cajaCompensacionDTO = cajaCompensacionDTO;
    }

    public HerramientaValoracionDTO getHerramientaValoracionDTO() {
        return herramientaValoracionDTO;
    }

    public void setHerramientaValoracionDTO(HerramientaValoracionDTO herramientaValoracionDTO) {
        this.herramientaValoracionDTO = herramientaValoracionDTO;
    }

    public TemasEvaluacionDTO getTemaEvaluacionDTO() {
        return temaEvaluacionDTO;
    }

    public void setTemaEvaluacionDTO(TemasEvaluacionDTO temaEvaluacionDTO) {
        this.temaEvaluacionDTO = temaEvaluacionDTO;
    }

    public String getTextopregunta() {
        return textopregunta;
    }

    public void setTextopregunta(String textopregunta) {
        this.textopregunta = textopregunta;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Respuestasencuesta> getRespuestasencuestas() {
        return respuestasencuestas;
    }

    public void setRespuestasencuestas(Set<Respuestasencuesta> respuestasencuestas) {
        this.respuestasencuestas = respuestasencuestas;
    }
}

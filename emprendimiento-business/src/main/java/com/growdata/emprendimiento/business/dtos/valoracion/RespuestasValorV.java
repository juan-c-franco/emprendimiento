package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;

public class RespuestasValorV {

    private BigDecimal idpregunta;
    private String respuesta;
    private BigDecimal idtema;

    public BigDecimal getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(BigDecimal idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public BigDecimal getIdtema() {
        return idtema;
    }

    public void setIdtema(BigDecimal idtema) {
        this.idtema = idtema;
    }

}

package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import java.math.BigDecimal;

public class RespuestasValor {

    private BigDecimal idpregunta;
    private String respuesta;

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

}

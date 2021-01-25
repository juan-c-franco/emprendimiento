package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import java.util.List;

public class RequestGuardarRespuestas {

    private List<RespuestasValor> respuestasValor;
    private long idEncuesta;

    public long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public List<RespuestasValor> getRespuestasValor() {
        return respuestasValor;
    }

    public void setRespuestasValor(List<RespuestasValor> respuestasValor) {
        this.respuestasValor = respuestasValor;
    }

}

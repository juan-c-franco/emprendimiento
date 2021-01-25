package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import java.util.List;

public class RequestCrearUsuario {

    private long idbeneficiario;
    private List<RespuestasValor> respuestasValor;
    private long idEncuesta;

    public List<RespuestasValor> getRespuestasValor() {
        return respuestasValor;
    }

    public void setRespuestasValor(List<RespuestasValor> respuestasValor) {
        this.respuestasValor = respuestasValor;
    }

    public long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public long getIdbeneficiario() {
        return idbeneficiario;
    }

    public void setIdbeneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

}

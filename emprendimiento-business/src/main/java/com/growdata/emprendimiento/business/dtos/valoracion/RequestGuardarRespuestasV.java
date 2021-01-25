package com.growdata.emprendimiento.business.dtos.valoracion;

import java.util.List;

public class RequestGuardarRespuestasV {

    private List<RespuestasValorV> respuestasV;
    private long idBeneficiario;

    public List<RespuestasValorV> getRespuestasV() {
        return respuestasV;
    }

    public void setRespuestasV(List<RespuestasValorV> respuestasV) {
        this.respuestasV = respuestasV;
    }

    public long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

}

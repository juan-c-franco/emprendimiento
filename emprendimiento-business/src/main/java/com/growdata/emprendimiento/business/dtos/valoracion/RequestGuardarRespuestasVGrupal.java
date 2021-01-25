package com.growdata.emprendimiento.business.dtos.valoracion;

import java.util.List;

public class RequestGuardarRespuestasVGrupal {

    private List<RespuestasValorV> respuestasV;
    private long idEmprendimiento;

    public List<RespuestasValorV> getRespuestasV() {
        return respuestasV;
    }

    public void setRespuestasV(List<RespuestasValorV> respuestasV) {
        this.respuestasV = respuestasV;
    }

    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

}

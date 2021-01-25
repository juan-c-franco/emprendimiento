package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import java.util.List;

public class RequestRegistroAsistencias {

    private List<AsistenciasValor> asistencias;

    private long idsesion;

    private long idfuncionario;

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public long getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(long idsesion) {
        this.idsesion = idsesion;
    }

    public List<AsistenciasValor> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<AsistenciasValor> asistencias) {
        this.asistencias = asistencias;
    }

}

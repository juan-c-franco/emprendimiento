package com.growdata.emprendimiento.business.dtos.sensibilizacion;

import java.util.List;

public class RequestRegistroAsistentesModificadas {

    private long idfuncionario;

    private List<AsistenciasValor> asistencias;

    public List<AsistenciasValor> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<AsistenciasValor> asistencias) {
        this.asistencias = asistencias;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

}

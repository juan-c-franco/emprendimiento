package com.growdata.emprendimiento.business.dtos.sensibilizacion;

public class RequestTraerEncuesta {

    private TraerEncuestaDTO traerEncuestaDTO;

    private long idfuncionario;

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public TraerEncuestaDTO getTraerEncuestaDTO() {
        return traerEncuestaDTO;
    }

    public void setTraerEncuestaDTO(TraerEncuestaDTO traerEncuestaDTO) {
        this.traerEncuestaDTO = traerEncuestaDTO;
    }

}

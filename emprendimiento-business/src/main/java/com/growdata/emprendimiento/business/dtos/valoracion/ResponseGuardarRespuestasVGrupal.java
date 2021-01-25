package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public class ResponseGuardarRespuestasVGrupal extends ResponseDTO {

    private List<TemasrutaacompanamientoatDTO> temasRuta;
    private long idRuta;

    public List<TemasrutaacompanamientoatDTO> getTemasRuta() {
        return temasRuta;
    }

    public void setTemasRuta(List<TemasrutaacompanamientoatDTO> temasRuta) {
        this.temasRuta = temasRuta;
    }

    public long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(long idRuta) {
        this.idRuta = idRuta;
    }

}

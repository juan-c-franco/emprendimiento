package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import java.util.List;

public class RequestGuardarTemasValoracionGrupal {

    private List<TemasrutaacompanamientoatDTO> temasRuta;
    private long idEmprendimiento;

    public List<TemasrutaacompanamientoatDTO> getTemasRuta() {
        return temasRuta;
    }

    public void setTemasRuta(List<TemasrutaacompanamientoatDTO> temasRuta) {
        this.temasRuta = temasRuta;
    }

    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

}

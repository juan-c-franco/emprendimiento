package com.growdata.emprendimiento.business.dtos.valoracion;

import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import java.util.List;

public class RequestGuardarTemasValoracionInd {

    private List<TemasrutacapacitacionDTO> temasRuta;
    private long idbeneficiario;
    private long idruta;

    public List<TemasrutacapacitacionDTO> getTemasRuta() {
        return temasRuta;
    }

    public void setTemasRuta(List<TemasrutacapacitacionDTO> temasRuta) {
        this.temasRuta = temasRuta;
    }

    public long getIdbeneficiario() {
        return idbeneficiario;
    }

    public void setIdbeneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    public long getIdruta() {
        return idruta;
    }

    public void setIdruta(long idruta) {
        this.idruta = idruta;
    }

}

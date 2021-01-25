/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SedesDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseSedes extends ResponseDTO {

    private List<SedesDTO> sedes;
    private InstitucionesDTO institucion;

    public InstitucionesDTO getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionesDTO institucion) {
        this.institucion = institucion;
    }

    public List<SedesDTO> getSedes() {
        return sedes;
    }

    public void setSedes(List<SedesDTO> sedes) {
        this.sedes = sedes;
    }

}

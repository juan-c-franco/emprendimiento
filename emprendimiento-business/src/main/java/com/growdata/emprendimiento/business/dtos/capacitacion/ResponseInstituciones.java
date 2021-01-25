/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseInstituciones extends ResponseDTO {

    private List<InstitucionesDTO> instituciones;

    public List<InstitucionesDTO> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(List<InstitucionesDTO> instituciones) {
        this.instituciones = instituciones;
    }

}

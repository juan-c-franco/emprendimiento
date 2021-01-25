/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CapacitacionprogramaDTO;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseTraerCapacitacion extends ResponseDTO {

    private CapacitacionprogramaDTO capacitacion;

    public CapacitacionprogramaDTO getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(CapacitacionprogramaDTO capacitacion) {
        this.capacitacion = capacitacion;
    }

}

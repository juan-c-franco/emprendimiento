/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CapacitacionprogramaDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseCapacitaciones extends ResponseDTO {

    private List<CapacitacionprogramaDTO> capacitaciones;

    public List<CapacitacionprogramaDTO> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<CapacitacionprogramaDTO> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

}

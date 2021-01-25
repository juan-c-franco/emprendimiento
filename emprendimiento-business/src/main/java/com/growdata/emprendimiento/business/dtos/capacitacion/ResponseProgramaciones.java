/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ProgramacionDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseProgramaciones extends ResponseDTO {

    private List<ProgramacionDTO> programaciones;

    public List<ProgramacionDTO> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(List<ProgramacionDTO> programaciones) {
        this.programaciones = programaciones;
    }

}

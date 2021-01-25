/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SeguimientoasistenciaDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseSeguimientoasistencia extends ResponseDTO {

    private List<SeguimientoasistenciaDTO> seguimientos;

    public List<SeguimientoasistenciaDTO> getSeguimientos() {
        return seguimientos;
    }

    public void setSeguimientos(List<SeguimientoasistenciaDTO> seguimientos) {
        this.seguimientos = seguimientos;
    }

}

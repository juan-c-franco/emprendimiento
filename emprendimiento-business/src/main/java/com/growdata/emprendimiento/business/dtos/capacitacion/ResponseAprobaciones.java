/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AprobacionDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseAprobaciones extends ResponseDTO {

    private List<AprobacionDTO> aprobaciones;

    public List<AprobacionDTO> getAprobaciones() {
        return aprobaciones;
    }

    public void setAprobaciones(List<AprobacionDTO> aprobaciones) {
        this.aprobaciones = aprobaciones;
    }

}

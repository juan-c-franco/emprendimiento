/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocapacitacionprogramaDTO;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseTraerEstadosCapacitacion extends ResponseDTO {

    private List<EstadocapacitacionprogramaDTO> estados;

    public List<EstadocapacitacionprogramaDTO> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadocapacitacionprogramaDTO> estados) {
        this.estados = estados;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadodocenteDTO;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseEstadoDocentes extends ResponseDTO {

    private List<EstadodocenteDTO> estadosDocente;

    public List<EstadodocenteDTO> getEstadosDocente() {
        return estadosDocente;
    }

    public void setEstadosDocente(List<EstadodocenteDTO> estadosDocente) {
        this.estadosDocente = estadosDocente;
    }

}

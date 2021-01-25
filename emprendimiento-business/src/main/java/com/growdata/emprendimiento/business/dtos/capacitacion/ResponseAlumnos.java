/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AlumnosDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseAlumnos extends ResponseDTO {

    private List<AlumnosDTO> alumnos;

    public List<AlumnosDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnosDTO> alumnos) {
        this.alumnos = alumnos;
    }

}

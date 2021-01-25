/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocentesDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseDocentes extends ResponseDTO {

    private List<DocentesDTO> docentes;

    public List<DocentesDTO> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<DocentesDTO> docentes) {
        this.docentes = docentes;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocentesDTO;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseTraerDocente extends ResponseDTO {

    private DocentesDTO docente;

    public DocentesDTO getDocente() {
        return docente;
    }

    public void setDocente(DocentesDTO docente) {
        this.docente = docente;
    }

}

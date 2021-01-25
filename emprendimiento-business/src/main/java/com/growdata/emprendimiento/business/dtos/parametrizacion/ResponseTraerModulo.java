/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ModulocicloDTO;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseTraerModulo extends ResponseDTO {

    private ModulocicloDTO modulo;

    public ModulocicloDTO getModulo() {
        return modulo;
    }

    public void setModulo(ModulocicloDTO modulo) {
        this.modulo = modulo;
    }

}

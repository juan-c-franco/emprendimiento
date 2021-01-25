/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ModulocicloDTO;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseModulosCiclo extends ResponseDTO {

    private List<ModulocicloDTO> modulos;

    public List<ModulocicloDTO> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModulocicloDTO> modulos) {
        this.modulos = modulos;
    }

}

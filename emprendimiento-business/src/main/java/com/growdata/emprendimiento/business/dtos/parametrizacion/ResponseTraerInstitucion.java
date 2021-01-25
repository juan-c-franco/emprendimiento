/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseTraerInstitucion extends ResponseDTO {

    private InstitucionesDTO institucion;

    public InstitucionesDTO getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionesDTO institucion) {
        this.institucion = institucion;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.RequestModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModuloCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModulosCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerModulo;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public interface ModuloCicloServicio {

    public ResponseModulosCiclo getModulos();
    
    public ResponseModulocicloCheck check(List<RequestModulocicloCheck> request, BigDecimal idProgramacion);

    public ResponseDTO crearModulo(RequestModuloCiclo request);

    public ResponseDTO modificarModulo(RequestModuloCiclo request);

    public ResponseTraerModulo traerModulo(RequestModuloCiclo request);

}

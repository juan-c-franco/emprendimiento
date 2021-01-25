/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseConfiguraciones;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.math.BigDecimal;

/**
 *
 * @author Juan Franco
 */
public interface ConfiguracionServicio {

    public ResponseConfiguraciones getConfiguraciones();

    public ResponseDTO setConfiguraciones(RequestConfiguraciones request);

    public ResponseConfiguraciones getConfiguracion(BigDecimal idConfiguracion);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ConfiguracionDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseConfiguraciones extends ResponseDTO {

    private List<ConfiguracionDTO> configuraciones;
    private ConfiguracionDTO configuracion;

    public ConfiguracionDTO getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionDTO configuracion) {
        this.configuracion = configuracion;
    }

    public List<ConfiguracionDTO> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<ConfiguracionDTO> configuraciones) {
        this.configuraciones = configuraciones;
    }

}

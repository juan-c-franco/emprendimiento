/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class RequestConfiguraciones {

    private List<Configuracion> configuraciones;

    public List<Configuracion> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<Configuracion> configuraciones) {
        this.configuraciones = configuraciones;
    }

}

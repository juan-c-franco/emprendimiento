/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface ConfiguracionDAO {

    public List<Configuracion> getConfiguraciones() throws Exception;

    public void setConfiguraciones(List<Configuracion> configuraciones) throws Exception;

    public Configuracion getConfiguracion(BigDecimal idConfiguracion) throws Exception;

}

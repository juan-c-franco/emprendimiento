/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseConfiguraciones;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.ConfiguracionServicio;
import com.growdata.emprendimiento.persistence.DAO.ConfiguracionDAO;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class ConfiguracionServicioImpl implements ConfiguracionServicio {

    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private ConfiguracionDAO configuracionDAO;

    /**
     * Servicio encargado de cargar todas las configuraciones
     *
     * @return Respuesta indicando si la consulta se realizó satisfactoriamente,
     * y la lista de configuraciones.
     */
    @Override
    public ResponseConfiguraciones getConfiguraciones() {
        ResponseConfiguraciones response = new ResponseConfiguraciones();
        try {
            response.setConfiguraciones(EntityToDTO.configuracionToConfiguracionDTO(configuracionDAO.getConfiguraciones()));
            response.setDescripcion(Mensajes.EXITO_CARGAR_CONFIGURACIONES);
            response.setStatus("1");
            response.setAccion(Acciones.CAMBIO_CONFIGURACIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGAR_CONFIGURACIONES);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Servicio encargado de guardar los cambios en las configuraciones.
     *
     * @param request Lista de configuraciones.
     * @return Respuesta si fue exitoso o no el proceso.
     */
    @Override
    public ResponseDTO setConfiguraciones(RequestConfiguraciones request) {
        ResponseDTO response = new ResponseDTO();
        try {
            configuracionDAO.setConfiguraciones(request.getConfiguraciones());
            response.setDescripcion(Mensajes.EXITO_GUARDAR_CONFIGURACIONES);
            response.setAccion(Acciones.CAMBIO_CONFIGURACIONES);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_GUARDAR_CONFIGURACIONES);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que trae una configuración a partir de su id
     *
     * @param idConfiguracion El id de la configuración
     * @return Una configuración
     */
    @Override
    public ResponseConfiguraciones getConfiguracion(BigDecimal idConfiguracion) {
        ResponseConfiguraciones response = new ResponseConfiguraciones();
        try {
            response.setConfiguracion(EntityToDTO.configToConfigDTO(configuracionDAO.getConfiguracion(idConfiguracion)));
            response.setDescripcion(Mensajes.EXITO_CARGAR_CONFIGURACIONES);
            response.setStatus("1");
            response.setAccion(Acciones.CAMBIO_CONFIGURACIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGAR_CONFIGURACIONES);
            response.setStatus("0");
        }
        return response;
    }

}

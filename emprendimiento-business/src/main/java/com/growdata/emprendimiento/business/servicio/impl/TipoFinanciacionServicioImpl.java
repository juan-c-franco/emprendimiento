/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerTiposFinanciacion;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerTiposFinanciacion;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaTiposFinanciacionToListaTiposFinanciacionDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.TipofinanciacionDTO;
import com.growdata.emprendimiento.business.servicio.TipoFinanciacionServicio;
import com.growdata.emprendimiento.persistence.DAO.TipoFinanciacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipofinanciacion;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class TipoFinanciacionServicioImpl implements TipoFinanciacionServicio {

    @Autowired
    private TipoFinanciacionDAO tipoFinanciacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los tipos de financiación
     *
     * @param request vacio
     * @return Una lista con los tipos de financiación
     */
    @Override
    public ResponseTraerTiposFinanciacion getTiposFinanciacion(RequestTraerTiposFinanciacion request) {
        ResponseTraerTiposFinanciacion response = new ResponseTraerTiposFinanciacion();

        List<Tipofinanciacion> tiposFinanciacion = new ArrayList();
        List<TipofinanciacionDTO> tiposFinanciacionDTO = new ArrayList();
        try {
            tiposFinanciacion = tipoFinanciacionDAO.getTiposFinanciacion();
            tiposFinanciacionDTO = listaTiposFinanciacionToListaTiposFinanciacionDTO(tiposFinanciacion);
            response.setTiposFinanciacionDTO(tiposFinanciacionDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_TIPOS_FINANCIACION);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

}

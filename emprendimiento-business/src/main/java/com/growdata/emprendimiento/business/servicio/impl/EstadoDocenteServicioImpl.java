/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEstadoDocentes;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.EstadoDocenteServicio;
import com.growdata.emprendimiento.persistence.DAO.EstadoDocenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Service
public class EstadoDocenteServicioImpl implements EstadoDocenteServicio {

    @Autowired
    private LoggerEmprendimiento log;

    @Autowired
    private EstadoDocenteDAO estadoDocenteDAO;

    /**
     * Metodo que trae todos los estados de un docente
     *
     * @return Una lista de estados de docente
     */
    @Override
    public ResponseEstadoDocentes getEstadosDocente() {

        ResponseEstadoDocentes response = new ResponseEstadoDocentes();
        try {
            response.setEstadosDocente(EntityToDTO.listEstadoDocenteToListEstadoDocenteDTO(estadoDocenteDAO.getEstadosDocente()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_DOCENTES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_DOCENTES);
        }
        return response;
    }
}

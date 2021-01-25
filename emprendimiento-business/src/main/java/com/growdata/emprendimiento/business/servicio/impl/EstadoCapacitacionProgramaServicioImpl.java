/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEstadosCapacitacion;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listEstadoCapacitacionToListEstadoCapacitacionDTO;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocapacitacionprogramaDTO;
import com.growdata.emprendimiento.business.servicio.EstadoCapacitacionProgramaServicio;
import com.growdata.emprendimiento.persistence.DAO.EstadoCapacitacionProgramaDAO;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Service
public class EstadoCapacitacionProgramaServicioImpl implements EstadoCapacitacionProgramaServicio {

    @Autowired
    private EstadoCapacitacionProgramaDAO estadoCapacitacionProgramaDAO;

    @Override
    public ResponseTraerEstadosCapacitacion getEstadosCapacitacion() {
        ResponseTraerEstadosCapacitacion response = new ResponseTraerEstadosCapacitacion();
        try {
            List<Estadocapacitacionprograma> estados = estadoCapacitacionProgramaDAO.getEstadosCapacitacion();
            List<EstadocapacitacionprogramaDTO> estadosDTO = listEstadoCapacitacionToListEstadoCapacitacionDTO(estados);
            response.setEstados(estadosDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_ESTADOS_CAPACITACION);
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_ESTADOS_CAPACITACION);
        }
        return response;
    }

}

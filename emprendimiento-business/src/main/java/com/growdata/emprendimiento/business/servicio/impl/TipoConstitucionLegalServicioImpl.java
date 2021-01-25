/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoconstitucionlegalDTO;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTipoConstitucionLegal;
import com.growdata.emprendimiento.business.servicio.TipoConstitucionLegalServicio;
import com.growdata.emprendimiento.persistence.DAO.TipoConstitucionLegalDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipoconstitucionlegal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/11/2018
 */
@Service
public class TipoConstitucionLegalServicioImpl
        implements TipoConstitucionLegalServicio {

    @Autowired
    private TipoConstitucionLegalDAO tipoConstitucionLegalDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio para ubicar todos los Tipos de Constitución Legal.
     *
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de Tipos de
     * Constitución Legal.
     */
    @Override
    public ResponseTipoConstitucionLegal getTiposConstitucionLegal() {
        ResponseTipoConstitucionLegal response
                = new ResponseTipoConstitucionLegal();
        List<TipoconstitucionlegalDTO> tiposDTO = new ArrayList<>();
        try {
            List<Tipoconstitucionlegal> tipos
                    = tipoConstitucionLegalDAO.getTiposConstitucionLegal();
            for (Tipoconstitucionlegal t : tipos) {
                tiposDTO.add(EntityToDTO
                        .tipoConstLegalToTipoConstLegalDTO(t));
            }
            response.setTipos(tiposDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_TIPOS_EMPRENDIMIENTO);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TIPOS_EMPRENDIMIENTIO);
        }
        return response;
    }

}

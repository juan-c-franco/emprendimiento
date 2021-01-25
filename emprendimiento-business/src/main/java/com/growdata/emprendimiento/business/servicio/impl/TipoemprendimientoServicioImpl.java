/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTiposEmprendimiento;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoemprendimientoDTO;
import com.growdata.emprendimiento.business.servicio.TipoemprendimientoServicio;
import com.growdata.emprendimiento.persistence.DAO.TipoemprendimientoDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipoemprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GrowData
 */
@Service
public class TipoemprendimientoServicioImpl implements TipoemprendimientoServicio {

    @Autowired
    private TipoemprendimientoDAO tipoemprendimientoDAO;
    @Autowired
    private LoggerEmprendimiento log;

    @Override
    public ResponseTiposEmprendimiento getTiposEmprendiemiento() {
        ResponseTiposEmprendimiento response = new ResponseTiposEmprendimiento();
        List<TipoemprendimientoDTO> tiposDTO = new ArrayList<>();
        try {
            List<Tipoemprendimiento> tipos = tipoemprendimientoDAO.getTiposEmprendiemiento();
            for (Tipoemprendimiento t : tipos) {
                tiposDTO.add(EntityToDTO.tipoEmprendimientoToTipoEmprendimientoDTO(t));
            }
            response.setTipos(tiposDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_TIPOS_CONSTITUCION_LEGAL);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TIPOS_CONSTITUCION_LEGAL);
        }
        return response;
    }

}

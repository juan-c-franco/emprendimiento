/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerTipoD;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerTipoD;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaTipoDocumendoIdToListaTipoDocumentoDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.growdata.emprendimiento.persistence.DAO.TipoDocumentoDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grow Data PC
 */
@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
    private TipoDocumentoDAO tipoDocumentoDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los tipos de documento
     *
     * @return Una lista con los tipos de documento
     */
    @Override
    @Transactional
    public List<Tipodocumentoid> getTipodocumentoid() {
        try {
            return tipoDocumentoDAO.getTipodocumentoid();
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
        }
        return null;
    }

    /**
     * Metodo que trae los tipos de documento
     *
     * @param request vacio
     * @return Una lista con los tipos de documento
     */
    @Override
    @Transactional
    public ResponseTraerTipoD getTipoDocumento(RequestTraerTipoD request) {
        ResponseTraerTipoD response = new ResponseTraerTipoD();
        try {
            List<Tipodocumentoid> tiposD = tipoDocumentoDAO.getTipodocumentoid();
            if (tiposD != null) {
                response.setTipoDTO(listaTipoDocumendoIdToListaTipoDocumentoDTO(tiposD));
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_TIPO_DOCUMENTO);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_TIPO_DOCUMENTO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion("");
        }
        return response;
    }

}

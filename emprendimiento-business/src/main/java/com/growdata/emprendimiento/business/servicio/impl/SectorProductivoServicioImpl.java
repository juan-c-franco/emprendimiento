/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseSectorProductivo;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.SectorproductivoDTO;
import com.growdata.emprendimiento.business.servicio.SectorProductivoServicio;
import com.growdata.emprendimiento.persistence.DAO.SectorProductivoDAO;
import com.growdata.emprendimiento.persistence.entidad.Sectorproductivo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/11/2018
 */
@Service
public class SectorProductivoServicioImpl implements SectorProductivoServicio {

    @Autowired
    private SectorProductivoDAO sectorProductivoDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio para ubicar todos los Sectores Productivos.
     *
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de Sectores
     * Productivos.
     */
    @Override
    public ResponseSectorProductivo getSectoresProductivos() {
        ResponseSectorProductivo response = new ResponseSectorProductivo();
        List<SectorproductivoDTO> sectoresDTO = new ArrayList<>();
        try {
            List<Sectorproductivo> sectores = sectorProductivoDAO.getSectoresProductivos();
            for (Sectorproductivo s : sectores) {
                sectoresDTO.add(EntityToDTO.sectorProductivoTOSectorProductivoDTO(s));
            }
            response.setSectores(sectoresDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_SECTORES_PRODUCTIVOS);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_SECTORES_PRODUCTIVOS);
        }
        return response;
    }

}

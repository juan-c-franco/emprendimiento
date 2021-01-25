package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseMunicipios;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.MunicipiosDTO;
import com.growdata.emprendimiento.business.servicio.MunicipiosServicio;
import com.growdata.emprendimiento.persistence.DAO.MunicipiosDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Municipios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 03/12/2018
 *
 * @author Juan Carlos Franco
 */
@Service
public class MunicipiosServicioImpl implements MunicipiosServicio {

    @Autowired
    private MunicipiosDAO municipiosDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio que busca los municipios de un determinado departamento
     *
     * @param iddepartamento Identificador del Departamennto
     * @return Respuesta si fue exitósa o no la búsqueda, y los Municipios que
     * cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponseMunicipios getMunicipiosPorDepartamento(BigDecimal iddepartamento) {
        ResponseMunicipios response = new ResponseMunicipios();
        List<MunicipiosDTO> municipiosDTO = new ArrayList<>();
        try {
            List<Municipios> municipios = municipiosDAO.getMunicipiosPorDepartamento(iddepartamento);
            for (Municipios m : municipios) {
                municipiosDTO.add(EntityToDTO.municipiosToMunicipiosDTO(m));
            }
            response.setMunicipios(municipiosDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_MUNICIPIOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_MUNICIPIOS);
        }
        return response;
    }
}

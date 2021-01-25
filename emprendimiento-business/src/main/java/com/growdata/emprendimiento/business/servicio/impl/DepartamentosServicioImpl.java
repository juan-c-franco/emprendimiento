package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseDepartamentos;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.DepartamentosDTO;
import com.growdata.emprendimiento.business.servicio.DepartamentosServicio;
import com.growdata.emprendimiento.persistence.DAO.DepartamentosDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Departamentos;
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
public class DepartamentosServicioImpl implements DepartamentosServicio {

    @Autowired
    private DepartamentosDAO departamentosDAO;
    @Autowired
    private LoggerEmprendimiento log;

    @Override
    public ResponseDepartamentos getDepartamentos() {
        ResponseDepartamentos response = new ResponseDepartamentos();
        List<DepartamentosDTO> departamentosDTO = new ArrayList<>();
        try {
            List<Departamentos> departamentos = departamentosDAO.getDepartamentos();
            for (Departamentos d : departamentos) {
                departamentosDTO.add(EntityToDTO.departamentoToDepartamentoDTO(d));
            }
            response.setDepartamentos(departamentosDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_DEPARTAMENTOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_DEPARTAMENTOS);
        }
        return response;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerGroups;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerGroups;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaGroupsToGroupsDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.GroupsServicio;
import com.growdata.emprendimiento.persistence.DAO.GroupsDAO;
import com.growdata.emprendimiento.persistence.entidad.Groups;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class GroupsServicioImpl implements GroupsServicio {

    @Autowired
    private GroupsDAO groupsDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los tipos de usuario
     *
     * @param request vacio
     * @return Una lista con los tipos de usuario
     */
    @Override
    @Transactional
    public ResponseTraerGroups getGroups(RequestTraerGroups request) {
        ResponseTraerGroups response = new ResponseTraerGroups();
        try {
            List<Groups> groups = groupsDAO.getGroups();
            if (groups != null) {
                response.setGroupsDTO(listaGroupsToGroupsDTO(groups));
                response.setDescripcion(Mensajes.EXITO_CARGA_GROUPS);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_GROUPS);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

}

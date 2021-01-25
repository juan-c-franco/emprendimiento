/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerTemasIndividuales;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerTemasIndividuales;
import com.growdata.emprendimiento.business.dtos.valoracion.TemasvaloracionindividualDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaTemasindividualesToListaTemasIndividualesDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.TemasIndividualesServicio;
import com.growdata.emprendimiento.persistence.DAO.TemasIndividualesDAO;
import com.growdata.emprendimiento.persistence.entidad.Temasvaloracionindividual;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class TemasIndividualesServicioImpl implements TemasIndividualesServicio {

    @Autowired
    private TemasIndividualesDAO temasIndividualesDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los temas individuales
     *
     * @param request vacio
     * @return Una lista con los temas de valoración individual
     */
    @Override
    public ResponseTraerTemasIndividuales traerTemas(RequestTraerTemasIndividuales request) {
        ResponseTraerTemasIndividuales response = new ResponseTraerTemasIndividuales();
        try {
            List<Temasvaloracionindividual> temas = temasIndividualesDAO.getTemas();
            if (temas.size() > 0) {
                List<TemasvaloracionindividualDTO> temasDTO = listaTemasindividualesToListaTemasIndividualesDTO(temas);
                response.setTemas(temasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGAR_TEMAS_INDIVIDUALES);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_TEMAS_INEXISTENTES);
            }

        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

}

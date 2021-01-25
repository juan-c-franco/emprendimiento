/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarPregunta;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.persistence.DAO.PreguntasDAO;
import com.growdata.emprendimiento.business.servicio.PreguntasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González GrowData
 *
 */
@Service
public class PreguntasServicioImpl implements PreguntasServicio {

    @Autowired
    private PreguntasDAO preguntasDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que borra una pregunta a partir de su id
     *
     * @param request Contiene el id de la pregunta
     * @return Respuesta si se borró la pregunta satisfactoriamente o no
     */
    @Override
    public ResponseBorrarPregunta borrarPreguntas(RequestBorrarPregunta request) {
        ResponseBorrarPregunta response = new ResponseBorrarPregunta();
        try {
            preguntasDAO.borrarPregunta(request.getIdPregunta());
            response.setDescripcion(Mensajes.EXITO_BORRAR_PREGUNTA);
            response.setStatus("1");
            response.setAccion(Acciones.BORRAR_PREGUNTA);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

}

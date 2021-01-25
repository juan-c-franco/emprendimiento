/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGuardarRespuestas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGuardarRespuestas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RespuestasValor;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.RespuestasEncuestaServicio;
import com.growdata.emprendimiento.persistence.DAO.EncuestaDAO;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andr?s Felipe Gonz?lez M. Grow Data PC
 */
@Service
public class RespuestasEncuestaServicioImpl implements RespuestasEncuestaServicio {

    @Autowired
    private EncuestaDAO encuestaDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que guarda las respuestas de la encuesta
     *
     * @param request Contiene el id de la encuesta y las respuestas
     * @return Respuesta si se guardaron las respuestas de la encuesta
     * satisfactoriamente o no
     */
    @Override
    @Transactional
    public ResponseGuardarRespuestas guardarRespuestas(RequestGuardarRespuestas request) {
        ResponseGuardarRespuestas response = new ResponseGuardarRespuestas();
        List<RespuestasValor> res = new ArrayList();
        res = request.getRespuestasValor();
        List<Respuestasencuesta> respuestas = new ArrayList();
        Date date = new Date();
        try {
            for (RespuestasValor r : res) {
                Respuestasencuesta re = new Respuestasencuesta();
                Encuesta encuesta = new Encuesta();
                encuesta.setIdencuesta(request.getIdEncuesta());
                Preguntas pregunta = new Preguntas();
                pregunta.setIdpregunta(r.getIdpregunta());
                re.setEncuesta(encuesta);
                re.setFecharegistro(date);
                re.setRespuesta(r.getRespuesta());
                re.setPreguntas(pregunta);
                respuestas.add(re);
            }
            encuestaDAO.actualizarEncuesta(request.getIdEncuesta(), date, respuestas);
            response.setAccion(Acciones.DILIGENCIAR_ENCUESTA);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRO_RESPUESTAS);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

}

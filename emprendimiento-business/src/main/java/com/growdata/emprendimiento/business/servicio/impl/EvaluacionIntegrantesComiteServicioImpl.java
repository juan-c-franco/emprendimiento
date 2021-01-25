/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseEvaluacionintegrantescomite;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.EvaluacionIntegrantesComiteServicio;
import com.growdata.emprendimiento.persistence.DAO.EvaluacionIntegrantesComiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionintegrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class EvaluacionIntegrantesComiteServicioImpl implements EvaluacionIntegrantesComiteServicio {

    @Autowired
    private EvaluacionIntegrantesComiteDAO evaluacionIntegrantesComiteDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que crea o actualiza una calificacion individual
     *
     * @param request Contiene la calificación, las observaciones, el id del
     * emprendimiento y el id del funcionario
     * @return Respuesta si se actualizó o creo satisfactoriamente la
     * calificación individual o no.
     */
    @Override
    public ResponseCalificarEmpIndividual calificacionIndividual(RequestCalificarEmpIndividual request) {
        ResponseCalificarEmpIndividual response = new ResponseCalificarEmpIndividual();
        try {
            Evaluacionintegrantescomite evaluacion = new Evaluacionintegrantescomite();
            Funcionario funcionario = new Funcionario();
            funcionario.setIdfuncionario(request.getIdfuncionario());
            Date date = new Date();
            evaluacion.setObservaciones(request.getObservaciones());
            evaluacion.setFecharegistro(date);
            evaluacion.setFuncionario(funcionario);
            evaluacion.setCalificacionindividual(request.getCalificacion());
            long id = evaluacionIntegrantesComiteDAO.calificacionIndividual(request.getIdemprendimiento(), evaluacion);
            response.setDescripcion(Mensajes.EXITO_REGISTRO_CALIFICACION_IND);
            response.setStatus("1");
            response.setAccion(Acciones.REGISTRAR_CALIFICACION_IND);
            response.setId(id);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Metodo que trae las calificaciones de comité de un emprendimiento a
     * partir de su id
     *
     * @param idEmprendimiento El id del emprendimiento
     * @return Una lista con las calificaciones del comité
     */
    @Override
    public ResponseEvaluacionintegrantescomite getCalificacionesPorEmprendimiento(long idEmprendimiento) {
        ResponseEvaluacionintegrantescomite response = new ResponseEvaluacionintegrantescomite();
        try {
            response.setEvaluaciones(evaluacionIntegrantesComiteDAO.getCalificacionesPorEmprendimiento(idEmprendimiento));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGAR_EVALUACION_INTEGRANTES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGAR_EVALUACION_INTEGRANTES);
            response.setStatus("0");
        }
        return response;
    }
}

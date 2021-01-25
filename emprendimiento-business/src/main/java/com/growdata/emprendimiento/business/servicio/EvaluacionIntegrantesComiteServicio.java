/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCalificarEmpIndividual;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseEvaluacionintegrantescomite;

public interface EvaluacionIntegrantesComiteServicio {

    public ResponseCalificarEmpIndividual calificacionIndividual(RequestCalificarEmpIndividual request);

    public ResponseEvaluacionintegrantescomite getCalificacionesPorEmprendimiento(long idEmprendimiento);
}

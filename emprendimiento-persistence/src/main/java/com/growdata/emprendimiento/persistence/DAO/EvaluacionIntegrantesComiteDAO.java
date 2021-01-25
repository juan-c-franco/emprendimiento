/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.commons.CalificacionIntegrantesComite;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionintegrantescomite;
import java.util.List;

public interface EvaluacionIntegrantesComiteDAO {

    public long calificacionIndividual(long idemprendimiento,
            Evaluacionintegrantescomite evaluacion) throws Exception;

    public List<CalificacionIntegrantesComite> getCalificacionesPorEmprendimiento(
            long idEmprendimiento) throws Exception;

}

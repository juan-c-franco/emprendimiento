package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseComiteEvaluacion;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;

public interface ComiteEvaluacionServicio {

    public ResponseComiteEvaluacion getComitePorIdFuncionario(long idFuncionario);

}

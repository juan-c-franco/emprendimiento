package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestCalificarEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

public interface EvaluacionemprendimientosServicio {

    public ResponseDTO calificacionDefinitiva(long idSesionComite, List<Character> aprobados,
            List<String> observaciones, List<Long> ids, String path);

}

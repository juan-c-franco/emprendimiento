/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ModuloscicloShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSeguimientoasistencia;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface SeguimientoasistenciaServicio {

    public ResponseAprobaciones registrarAsistenciaCapacitacion(BigDecimal idProgramacion, long idFuncionario,
            List<AlumnosShortDTO> lAlumnos, List<ModuloscicloShortDTO> lModulo, List<List<String>> registroGlobal);

    public ResponseSeguimientoasistencia getSeguimientoAlumnoModulo(BigDecimal idalumno, long idmodulociclo);
    
    public ResponseAprobaciones registrarAsistenciaCapacitacionMasiva(
            List<RequestCalificacionDTO> requestCalificaciones, long idFuncionario,
            BigDecimal idProgramacion);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface AprobacionServicio {

    public ResponseAprobaciones registrarCalificacionCapacitacion(BigDecimal idProgramacion, long idFuncionario,
            List<AlumnosShortDTO> lAlumnos, List<String> registroGlobal);
    
    public ResponseAprobaciones registrarCalificacionCapacitacionMasiva(
            List<RequestCalificacionDTO> requestCalificaciones, long idFuncionario,
            BigDecimal idProgramacion);

}

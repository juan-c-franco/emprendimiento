/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseProgramaciones;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juan Franco
 */
public interface ProgramacionServicio {

    public ResponseProgramaciones getProgramacion(BigDecimal idProgramacion);

    public ResponseProgramaciones getProgramaciones(long iddocente, Date desde);

    public ResponseProgramaciones getProgramacionPorSedeCapacitacion(BigDecimal idsede,
            long idcapacitacion, Date desde, Short vencidas);

    public ResponseDTO saveProgramaciones(Programacion programacion);

    public ResponseDTO updateProgramaciones(Programacion programacion);

    public ResponseDTO deleteProgramaciones(Programacion programacion);

}

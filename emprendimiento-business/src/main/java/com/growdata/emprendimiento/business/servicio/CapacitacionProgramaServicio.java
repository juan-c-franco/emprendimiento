/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseCapacitaciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCapacitacion;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 *
 * @author Juan Franco
 */
public interface CapacitacionProgramaServicio {

    public ResponseCapacitaciones getCapacitaciones(long idSede);

    public ResponseCapacitaciones getCapacitaciones();

    public ResponseDTO crearCapacitacion(RequestCapacitacion request);

    public ResponseDTO modificarCapacitacion(RequestCapacitacion request);

    public ResponseTraerCapacitacion traerCapacitacion(RequestTraerCapacitacion request);

    public ResponseCapacitaciones getCapacitacionesParametrizar();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseInstituciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerInstitucion;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 *
 * @author Juan Franco
 */
public interface InstitucionesServicio {

    public ResponseInstituciones getInstituciones();

    public ResponseDTO crearInstitucion(RequestInstitucion request);

    public ResponseDTO modificarInstitucion(RequestInstitucion request);

    public ResponseTraerInstitucion traerInstitucion(RequestTraerInstitucion request);

}

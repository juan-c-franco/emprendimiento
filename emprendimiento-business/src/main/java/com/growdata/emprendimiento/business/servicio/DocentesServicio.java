/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseDocentes;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestDocente;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerDocente;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 *
 * @author Juan Franco
 */
public interface DocentesServicio {

    public ResponseDocentes getDocentes(long idcapacitacionprograma);

    public ResponseDocentes getDocentes();

    public ResponseDocentes getDocentesParametrizar();

    public ResponseDTO crearDocente(RequestDocente request);

    public ResponseDTO modificarDocente(RequestDocente request);

    public ResponseTraerDocente traerDocente(RequestDocente request);

}

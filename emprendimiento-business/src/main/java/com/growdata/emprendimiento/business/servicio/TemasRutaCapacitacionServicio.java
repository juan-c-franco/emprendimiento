/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;

public interface TemasRutaCapacitacionServicio {

    public ResponseGuardarTemasValoracionInd crearTemas(RequestGuardarTemasValoracionInd request);
}

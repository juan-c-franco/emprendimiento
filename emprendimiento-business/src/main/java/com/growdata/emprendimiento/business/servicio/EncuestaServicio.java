/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerVInd;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerValoGrupal;

public interface EncuestaServicio {

    public ResponseTraerEncuesta getEncuesta(RequestTraerEncuesta request);

    public ResponseTraerEncuesta getEncuestaValoracion(RequestTraerEncuesta request);

    public ResponseTraerEncuesta getEncuestaValoracionInd(RequestTraerVInd request);

    public ResponseTraerEncuesta getEncuestaValoracionGrupal(RequestTraerValoGrupal request);

//    public ResponseCrearEncuesta crearEncuesta(RequestCrearEncuesta request);
}

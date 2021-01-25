package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoSesionPorNombre;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoSesionPorNombre;

public interface EstadoSesionServicio {

    public ResponseTraerEstadoSesionPorNombre getEstadoSesion(RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion);
}

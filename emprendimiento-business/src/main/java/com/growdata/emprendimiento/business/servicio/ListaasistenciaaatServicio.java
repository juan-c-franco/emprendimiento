package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsistentesSesionAAT;

public interface ListaasistenciaaatServicio {

    public ResponseAsistentesSesionAAT getLista(long idsesionacompanamientoat);

}

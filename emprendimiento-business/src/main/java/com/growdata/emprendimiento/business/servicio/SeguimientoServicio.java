package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

public interface SeguimientoServicio {

    public ResponseDTO guardarSeguimientoFormalizado(RequestRegistrarFormalizado request,
            RequestRegistrarInfoFinancieraBasica resquestFinan);

    public ResponseDTO guardarSeguimientoNoEstablecido(RequestNoEstablecido request,
            RequestRegistrarInfoFinancieraBasica resquestFinan);

}

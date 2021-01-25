package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinanciera;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerInfoFinancieraBasica;

public interface FinanciacionServicio {

    public ResponseRegistrarInfoFinancieraBasica guardarInfoFinancieraBasica(RequestRegistrarInfoFinancieraBasica request);

    public ResponseTraerInfoFinancieraBasica getInfoFinancieraBasicaPorId(RequestTraerInfoFinancieraBasica request);

    public ResponseRegistrarInfoFinancieraBasica guardarInfoFinanciera(RequestRegistrarInfoFinanciera request);

    public ResponseTraerInfoFinancieraBasica getInfoFinancieraPorId(RequestTraerInfoFinancieraBasica request);

}

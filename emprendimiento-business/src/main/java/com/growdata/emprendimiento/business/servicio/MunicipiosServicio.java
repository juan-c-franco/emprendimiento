package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseMunicipios;
import java.math.BigDecimal;

public interface MunicipiosServicio {

    public ResponseMunicipios getMunicipiosPorDepartamento(BigDecimal iddepartamento);

}

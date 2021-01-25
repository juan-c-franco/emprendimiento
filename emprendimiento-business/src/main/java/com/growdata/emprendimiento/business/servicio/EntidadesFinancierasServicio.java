/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarEntidadF;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEntidadesFinancieras;

public interface EntidadesFinancierasServicio {

    public ResponseTraerEntidadesFinancieras getEntidadesFinancierasAdmin(RequestTraerEntidadesFinancieras request);

    public ResponseRegistrarEntidadFinanciera setEntidadFinanciera(RequestRegistrarEntidadFinanciera request);

    public ResponseModificarEntidadFinanciera getEntidadFinanciera(RequestModificarEntidadF request);

    public ResponseModificarEntidadFinanciera2 setEntidadFinancieraM(RequestRegistrarEntidadFinanciera request);

    public ResponseTraerEntidadesFinancieras getEntidadesFinancieras(RequestTraerEntidadesFinancieras request);

    public ResponseRegistrarEntidadFinanciera borrarEntidadFinanciera(RequestBorrarEntidadFinanciera request);

}

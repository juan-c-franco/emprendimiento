/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCajas;
import java.math.BigDecimal;

public interface CajasDeCompensacionServicio {

    public ResponseTraerCajas getCajasDeCompensacion(RequestTraerCajas request);

    public ResponseTraerCajas getCajasDeCompensacionAdmin(RequestTraerCajas request);

    public ResponseRegistrarCaja setCajaCompensacion(RequestRegistrarCaja request);

    public ResponseModificarCaja2 setCajaCompensacionM(RequestModificarCaja2 request);

    public ResponseModificarCaja getCajaCompensacion(RequestModificarCaja request);

    public ResponseGestionarCuentas getNombresCajas(RequestGestionarCuentas request);

    public ResponseCajaCompensacion getCajaCompensacionPorId(BigDecimal idCaja);

    public ResponseRegistrarCaja borrarCajaCompensacion(RequestBorrarCajaCompensacion request);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseActualizarEmprendimiento;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestEmprendimientoPorDocEstados;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseGetEmprendimientoCompleto;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerEmprendimientoPorId;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRompimientoDeFases;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseTraerEmprendimientoPorNombre;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.math.BigDecimal;

public interface EmprendimientoServicio {

    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorNombre(RequestTraerEmprendimientoPorNombre request);

    public ResponseDTO guardarFormalizado(RequestRegistrarFormalizado request);

    public ResponseDTO guardarNoEstablecido(RequestNoEstablecido request);

    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDoc(RequestEmprendimientoPorDocEstados request);

    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorDoc2(RequestEmprendimientoPorDocEstados request);

    public ResponseTraerEmprendimientoPorNombre getEmprendimientoPorEdo(RequestEmprendimientoPorDocEstados request);

    public ResponseActualizarEmprendimiento updateEmprendimiento(RequestActualizarEmprendimiento requestActualizarEmprendimiento);

    public ResponseTraerEmprendimientoPorId getEmprendimientoPorId(RequestTraerEmprendimientoPorId request);

    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComite(long idSesionComite, int estadoEmprendimiento, BigDecimal idcajacompensacion);

    public ResponseTraerEmprendimientoPorNombre getEmprendimientosComitePorIdSesion(long idSesionComite, int estadoEmprendimiento);

    public ResponseGetEmprendimientoCompleto getEmprendimientoCompleto(RequestTraerEmprendimientoPorId request);

    public ResponseDTO rompimientoDeFases(RequestRompimientoDeFases request);
}

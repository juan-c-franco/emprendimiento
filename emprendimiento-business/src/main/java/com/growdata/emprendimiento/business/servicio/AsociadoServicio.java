/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetAsociadoXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetAsociadoXId;

public interface AsociadoServicio {

    public ResponseGetAsociadoXId getAsociadoXId(RequestGetAsociadoXId request);

    public ResponseTraerAsociadoPorUserName getAsociado(RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName);

    public ResponseAsociadosPorEmprendimiento getAsociadosPorEmprendimiento(RequestAsociadosPorEmprendimiento requestAsociadosPorEmprendimiento);
}

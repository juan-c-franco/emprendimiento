/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerLogA;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerLogA;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;

public interface LogAuditoriaServicio {

    public void registrarLog(RequestLogAuditoria request);

    public ResponseTraerLogA getLogsXFecha(RequestTraerLogA request);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerTipoD;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerTipoD;

import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import java.util.List;

public interface TipoDocumentoServicio {

    public List<Tipodocumentoid> getTipodocumentoid();

    public ResponseTraerTipoD getTipoDocumento(RequestTraerTipoD request);
}

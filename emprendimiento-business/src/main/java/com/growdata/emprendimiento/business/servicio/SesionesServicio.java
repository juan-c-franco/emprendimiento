/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerSesiones;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerSesionesV;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SesionesServicio {

    public List<Sesiones> getSesiones();

    //Deprecated?
    public ResponseTraerSesiones getSesionesXFuncionario(long idFuncionario);
    //Deprecated?

    public ResponseTraerSesiones getSesionesPorFuncionario(long idFuncionario);

    public ResponseTraerSesiones getSesionesPorFuncionarioTipoSesion(long idFuncionario,
            BigDecimal tiposesion, Date desde, int todas);

    public Sesiones getSesiones(long saveIdSesion);

    public ResponseDTO saveSesiones(Sesiones sesiones);

    public ResponseDTO updateSesiones(Sesiones sesion);

    public ResponseDTO deleteSesiones(Sesiones sesion);

    public ResponseDTO liberarSesiones(Sesiones sesion);

    public ResponseTraerSesiones getSesionesVXFuncionario(RequestTraerSesionesV request);
}

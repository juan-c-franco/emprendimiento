/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerSesionesComite;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesioncomiteDTO;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.Date;
import java.util.List;

public interface SesionesComiteServicio {

    public ResponseTraerSesionesComite getSesionesFuncionario(long idFuncionario,
            Date desde, Date hasta, int todas);

    public ResponseDTO saveSesiones(Sesioncomite sesiones, List<String> emprendimientos);

    public ResponseDTO updateSesiones(Sesioncomite sesion);

    public ResponseDTO deleteSesiones(Sesioncomite sesion);

    public SesioncomiteDTO getSesiones(long id);

    public ResponseTraerSesionesComite getSesionesFuncionarioComite(long idFuncionario,
            Date desde, Date hasta, int todas);
}

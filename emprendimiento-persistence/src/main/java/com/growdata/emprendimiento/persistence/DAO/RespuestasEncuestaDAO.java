/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;

public interface RespuestasEncuestaDAO {

    public String guardarRespuesta(Respuestasencuesta respuesta) throws Exception;
}

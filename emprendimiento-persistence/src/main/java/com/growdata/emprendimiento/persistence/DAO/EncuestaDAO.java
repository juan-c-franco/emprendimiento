/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import java.util.Date;
import java.util.List;

public interface EncuestaDAO {

    public Encuesta getEncuesta(int idBeneficiario, long idEncuesta) throws Exception;

    public void actualizarEncuesta(long idEncuesta, Date fecha,
            List<Respuestasencuesta> respuestas) throws Exception;

    public long crearEncuesta(Encuesta encuesta) throws Exception;
}

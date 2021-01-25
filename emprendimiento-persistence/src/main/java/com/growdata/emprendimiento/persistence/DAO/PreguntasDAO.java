/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import java.math.BigDecimal;
import java.util.List;

public interface PreguntasDAO {

    public List<Preguntas> getPreguntas(BigDecimal idcajacompensacion) throws Exception;

    public List<Preguntas> getPreguntasValoracion(BigDecimal idcajacompensacion) throws Exception;

    public List<Preguntas> getPreguntasValoracionInd(BigDecimal idcajacompensacion) throws Exception;

    public List<Preguntas> getPreguntasValoracionGrupal(BigDecimal idcajacompensacion) throws Exception;

    public void borrarPregunta(BigDecimal idPregunta) throws Exception;

}

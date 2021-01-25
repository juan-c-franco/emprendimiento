/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Herramientasvaloracion;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import java.math.BigDecimal;
import java.util.List;

public interface HerramientaValoracionDAO {

    public List<Herramientasvaloracion> getHerramientasValoracion() throws Exception;

    public Herramientasvaloracion getHerramientaValoracion(
            BigDecimal idHerramientaValoracion) throws Exception;

    public List<Temasevaluacion> getTemasEvaluacion(BigDecimal idCajaCompensacion,
            BigDecimal idHerramienta) throws Exception;

    public BigDecimal setTemaEvaluacion(Temasevaluacion temasEvaluacion) throws Exception;

    public Temasevaluacion getTraerTemaEvaluacion(BigDecimal idTemaEvaluacion) throws Exception;

    public String updateTemaEvaluacion(Temasevaluacion temasEvaluacion) throws Exception;

    public List<Preguntas> getTraerPreguntas(BigDecimal idTema,
            BigDecimal idCajaCompensacion, BigDecimal idHerramienta) throws Exception;

    public String updatePreguntaTema(Preguntas pregunta) throws Exception;

    public BigDecimal setPreguntaTema(Preguntas pregunta) throws Exception;

    public Preguntas getTraerPreguntaTema(BigDecimal idPregunta) throws Exception;
}

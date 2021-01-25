/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerHerramientaValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerHerramientasValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerPreguntasXTemaHerramientaCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerTemasPorCajaYHerramienta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseBorrarTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarPreguntaTema;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerHerramientaValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerHerramientasValoracion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerPregunta;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerPreguntasXTemaHerramientaCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerTemaEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerTemasPorCajaYHerramienta;

public interface HerramientaValoracionServicio {

    public ResponseTraerHerramientasValoracion getHerramientasValoracion(RequestTraerHerramientasValoracion request);

    public ResponseTraerHerramientaValoracion getHerramientaValoracion(RequestTraerHerramientaValoracion request);

    public ResponseTraerTemasPorCajaYHerramienta getTemasEvaluacion(RequestTraerTemasPorCajaYHerramienta request);

    public ResponseRegistrarTemaEvaluacion setTemaEvaluacion(RequestRegistrarTemaEvaluacion request);

    public ResponseTraerTemaEvaluacion getTraerTemaEvaluacion(RequestTraerTemaEvaluacion request);

    public ResponseTraerPreguntasXTemaHerramientaCaja getTraerPreguntas(RequestTraerPreguntasXTemaHerramientaCaja request);

    public ResponseRegistrarPreguntaTema setPreguntaTema(RequestRegistrarPreguntaTema request);

    public ResponseTraerPregunta getTraerPreguntaTema(RequestTraerPregunta request);

    public ResponseBorrarTema borrarTemaEvaluacion(RequestBorrarTema request);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.HerramientaValoracionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.PreguntasTemaDTO;
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
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.HerramientaValoracionServicio;
import com.growdata.emprendimiento.persistence.DAO.HerramientaValoracionDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Herramientasvaloracion;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Danny Fernando Guerrero Gelpud
 */
@Service
public class HerramientaValoracionServicioImpl implements HerramientaValoracionServicio {

    @Autowired
    private HerramientaValoracionDAO herramientaValoracionDAO;
    @Autowired
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae las herramientas de valoración
     *
     * @param request vacio
     * @return Una lista con las herramientas de valoración
     */
    @Override
    @Transactional
    public ResponseTraerHerramientasValoracion getHerramientasValoracion(RequestTraerHerramientasValoracion request) {
        ResponseTraerHerramientasValoracion response = new ResponseTraerHerramientasValoracion();
        try {
            List<Herramientasvaloracion> herramientasValoracion = herramientaValoracionDAO.getHerramientasValoracion();
            if (herramientasValoracion != null && herramientasValoracion.size() > 0) {
                List<HerramientaValoracionDTO> herramientasValoracionDTO = EntityToDTO.listaHerramientasValoracionToListaTraerHerramientasValoracionDTO(herramientasValoracion);
                response.setHerramientasValoracionDTO(herramientasValoracionDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_HERRAMIENTAS_VALORACION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_HERRAMIENTAS_VALORACION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_HERRAMIENTAS_VALORACION);
        }
        return response;
    }

    /**
     * Metodo que trae una herramienta de valoración a partir de su id
     *
     * @param request Contiene el id de la herramienta de valoración
     * @return Una herramienta de valoración
     */
    @Override
    public ResponseTraerHerramientaValoracion getHerramientaValoracion(RequestTraerHerramientaValoracion request) {
        ResponseTraerHerramientaValoracion response = new ResponseTraerHerramientaValoracion();
        try {
            Herramientasvaloracion herramientaValoracion = herramientaValoracionDAO.getHerramientaValoracion(request.getIdHerramientaValoracion());
            if (herramientaValoracion != null) {
                HerramientaValoracionDTO herramientaValoracionDTO = EntityToDTO.herramientaValoracionToHerramientaValoracionDTO(herramientaValoracion);
                response.setHerramientaValoracionDTO(herramientaValoracionDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_HERRAMIENTA_VALORACION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_HERRAMIENTA_VALORACION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_HERRAMIENTA_VALORACION);
        }
        return response;
    }

    /**
     * Metodo que trae los temas de evaluacion de una caja a partir de un id de
     * caja de compensacion y un id de herramienta
     *
     * @param request Contiene el id de la caja de compensación y el id de la
     * herramienta
     * @return Una lista con los temas de evaluación
     */
    @Override
    @Transactional
    public ResponseTraerTemasPorCajaYHerramienta getTemasEvaluacion(RequestTraerTemasPorCajaYHerramienta request) {
        ResponseTraerTemasPorCajaYHerramienta response = new ResponseTraerTemasPorCajaYHerramienta();
        try {
            List<Temasevaluacion> temasEvaluacion = herramientaValoracionDAO.getTemasEvaluacion(request.getIdCajaCompensacion(), request.getIdHerramienta());
            if (temasEvaluacion != null && temasEvaluacion.size() > 0) {
                List<TemasEvaluacionDTO> temasEvaluacionDTO = EntityToDTO.listaTemasEvaluacionToListaTemasEvaluacionDTO(temasEvaluacion);
                response.setTemasEvaluacion(temasEvaluacionDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_TEMAS_X_CAJA_HERRAMIENTA);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_TEMAS_X_CAJA_HERRAMIENTA);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TEMAS_X_CAJA_HERRAMIENTA);
        }
        return response;
    }

    /**
     * Metodo que crea un tema de evaluacion
     *
     * @param request Contiene el tema de evaluación a crear
     * @return Respuesta si se creo el tema de evaluación satisfactoriamente o
     * no
     */
    @Override
    @Transactional
    public ResponseRegistrarTemaEvaluacion setTemaEvaluacion(RequestRegistrarTemaEvaluacion request) {
        ResponseRegistrarTemaEvaluacion response = new ResponseRegistrarTemaEvaluacion();
        try {
            Temasevaluacion temasevaluacion = DTOToEntity.dtoTemaEvaluacionToTemaEvaluacion(request.getTemaEvaluacionDTO());
            BigDecimal id;
            String resp;
            if (temasevaluacion.getIdtema() != null) {
                resp = herramientaValoracionDAO.updateTemaEvaluacion(temasevaluacion);
                if (resp.equals("1")) {
                    response.setAccion(Acciones.MODIFICAR_TEMA);
                    response.setDescripcion(Mensajes.EXITO_UPDATE_TEMA_EVALUACION);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_UPDATE_TEMA_EVALUACION);
                    response.setStatus("0");
                }
            } else {
                id = herramientaValoracionDAO.setTemaEvaluacion(temasevaluacion);
                if (id != null) {
                    response.setAccion(Acciones.CREAR_TEMA);
                    response.setId(id.longValue());
                    response.setDescripcion(Mensajes.EXITO_REGISTRO_TEMA_EVALUACION);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_REGISTRO_TEMA_EVALUACION);
                    response.setStatus("0");
                }
            }
        } catch (Exception ex) {
            response.setDescripcion(Mensajes.ERROR_REGISTRO_TEMA_EVALUACION);
            response.setStatus("0");
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
        }
        return response;
    }

    /**
     * Metodo que trae un tema de evaluacion a partir de su id
     *
     * @param request Contiene el id del tema de evaluación
     * @return Un tema de evaluación
     */
    @Override
    public ResponseTraerTemaEvaluacion getTraerTemaEvaluacion(RequestTraerTemaEvaluacion request) {
        ResponseTraerTemaEvaluacion response = new ResponseTraerTemaEvaluacion();
        try {
            Temasevaluacion temaEvaluacion = herramientaValoracionDAO.getTraerTemaEvaluacion(request.getIdTemaEvaluacion());
            if (temaEvaluacion != null) {
                TemasEvaluacionDTO temaEvaluacionDTO = EntityToDTO.traerTemaEvaluacionDTO(temaEvaluacion);
                response.setTemaEvaluacion(temaEvaluacionDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_TEMA_EVALUACION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_TEMA_EVALUACION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_TEMA_EVALUACION);
        }
        return response;
    }

    /**
     * Metodo que trae las preguntas de un tema a partir de un id de tema, un id
     * de herramienta y un id de caja de compensacion
     *
     * @param request Contiene el id del tema, el id de la herramienta y el id
     * de la caja de compensación
     * @return Una lista con las preguntas
     */
    @Override
    @Transactional
    public ResponseTraerPreguntasXTemaHerramientaCaja getTraerPreguntas(RequestTraerPreguntasXTemaHerramientaCaja request) {
        ResponseTraerPreguntasXTemaHerramientaCaja response = new ResponseTraerPreguntasXTemaHerramientaCaja();
        try {
            List<Preguntas> preguntas = herramientaValoracionDAO.getTraerPreguntas(request.getIdTema(), request.getIdCajaCompensacion(), request.getIdHerramienta());
            if (preguntas != null && preguntas.size() > 0) {
                List<PreguntasTemaDTO> preguntasDTO = EntityToDTO.listaPreguntasToListaPreguntasHerramientaDTO(preguntas);
                response.setPreguntasDTO(preguntasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTAS_X_TEMA_CAJA_HERRAMIENTA);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_PREGUNTAS_X_TEMA_CAJA_HERRAMIENTA);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_PREGUNTAS_X_TEMA_CAJA_HERRAMIENTA);
        }
        return response;
    }

    /**
     * Metodo que crea una pregunta
     *
     * @param request Contiene la pregunta a crear
     * @return Respuesta si se creó la pregunta satisfactoriamente o no
     */
    @Override
    public ResponseRegistrarPreguntaTema setPreguntaTema(RequestRegistrarPreguntaTema request) {
        ResponseRegistrarPreguntaTema response = new ResponseRegistrarPreguntaTema();
        try {
            Preguntas pregunta = DTOToEntity.dtoPreguntaTemaToPreguntaTema(request.getPreguntaTemaDTO());
            String resp;
            BigDecimal id;
            if (pregunta.getIdpregunta() != null) {
                resp = herramientaValoracionDAO.updatePreguntaTema(pregunta);
                if (resp.equals("1")) {
                    response.setAccion(Acciones.MODIFICAR_PREGUNTA);
                    response.setDescripcion(Mensajes.EXITO_UPDATE_PREGUNTA_TEMA);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_UPDATE_PREGUNTA_TEMA);
                    response.setStatus("0");
                }
            } else {
                id = herramientaValoracionDAO.setPreguntaTema(pregunta);
                if (id != null) {
                    response.setAccion(Acciones.CREAR_PREGUNTA);
                    response.setId(id.longValue());
                    response.setDescripcion(Mensajes.EXITO_REGISTRO_PREGUNTA_TEMA);
                    response.setStatus("1");
                } else {
                    response.setDescripcion(Mensajes.ERROR_REGISTRO_PREGUNTA_TEMA);
                    response.setStatus("0");
                }
            }
        } catch (Exception ex) {
            response.setDescripcion(Mensajes.ERROR_REGISTRO_PREGUNTA_TEMA);
            response.setStatus("0");
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
        }
        return response;
    }

    /**
     * Metodo que trae una pregunta a partir de su id
     *
     * @param request Contiene el id de la pregunta
     * @return Una pregunta
     */
    @Override
    public ResponseTraerPregunta getTraerPreguntaTema(RequestTraerPregunta request) {
        ResponseTraerPregunta response = new ResponseTraerPregunta();
        try {
            Preguntas preguntaTema = herramientaValoracionDAO.getTraerPreguntaTema(request.getIdPregunta());
            if (preguntaTema != null) {
                PreguntasTemaDTO preguntasTemaDTO = EntityToDTO.traerPreguntaXTemaHerramientaCajaDTO(preguntaTema);
                response.setPreguntaTemaDTO(preguntasTemaDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTA_TEMA);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_PREGUNTA_TEMA);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_PREGUNTA_TEMA);
        }
        return response;
    }

    /**
     * Metodo que borra un tema apartir de el id de caja de compensación, el id
     * de tema y el id de herramienta
     *
     * @param request Contiene el id de la caja de compensación, el id del tema
     * y el id de la herramienta
     * @return Respuesta si se borró el tema satisfactoriamente o no
     */
    @Override
    public ResponseBorrarTema borrarTemaEvaluacion(RequestBorrarTema request) {
        ResponseBorrarTema response = new ResponseBorrarTema();
        try {
            temasEvaluacionDAO.borrarTemaEvaluacion(request.getIdTema(), request.getIdCajaCompensacion(), request.getIdHerramienta());
            response.setDescripcion(Mensajes.EXITO_BORRAR_TEMA_EVALUACION);
            response.setStatus("1");
            response.setAccion(Acciones.BORRAR_TEMA_EVALUACION);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }
}

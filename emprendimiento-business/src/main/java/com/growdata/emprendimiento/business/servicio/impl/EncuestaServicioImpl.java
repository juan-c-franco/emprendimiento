/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerEncuesta;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerVInd;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestTraerValoGrupal;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.servicio.EncuestaServicio;
import com.growdata.emprendimiento.persistence.DAO.EncuestaDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.PreguntasDAO;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class EncuestaServicioImpl implements EncuestaServicio {

    @Autowired
    private EncuestaDAO encuestaDAO;
    @Autowired
    private PreguntasDAO preguntasDAO;
    @Autowired
    private FuncionarioDAO funcionarioDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae una encuesta a partir de un id de beneficiario y un id de
     * encuesta
     *
     * @param request Contiene el id del beneficiario y el id de la encuesta
     * @return Una encuesta
     */
    @Override
    @Transactional
    public ResponseTraerEncuesta getEncuesta(RequestTraerEncuesta request) {
        //Traigo la encuesta para validar la fecha 
        ResponseTraerEncuesta response = new ResponseTraerEncuesta();
        int idBeneficiario = request.getTraerEncuestaDTO().getIdBeneficiario();
        long idEncuesta = request.getTraerEncuestaDTO().getIdEncuesta();
        try {
            Encuesta encuesta = encuestaDAO.getEncuesta(idBeneficiario, idEncuesta);
            Date date = new Date();
            //valido que la fecha sea menor a la fecha de vigencia de la encuesta
            if (date.compareTo(encuesta.getFechavigencia()) <= 0) {
                if (encuesta.getDiligenciada() != '0') {
                    String mensaje = Mensajes.ERROR_ENCUESTA_DILIGENCIADA;
                    response.setStatus("0");
                    response.setDescripcion(mensaje);

                } else {
                    Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(request.getIdfuncionario());
                    //Traigo las preguntas del dao
                    List<Preguntas> preguntas = preguntasDAO.getPreguntas(funcionario.getCajacompensacion().getIdcajacompensacion());
                    List<PreguntasDTO> preguntasDTO = EntityToDTO.listaPreguntasToListaPreguntasDTO(preguntas);
                    //setteo el response 
                    response.setPreguntasDTO(preguntasDTO);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTAS);
                }
            } else {
                response.setDescripcion(Mensajes.ERROR_ENCUESTA_VIGENCIA);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;

    }

    /**
     * Metodo que trae la encuesta de valoración a partir de un id de
     * beneficiario y un id de encuesta
     *
     * @param request Contiene el id del beneficiario y el id de la encuesta
     * @return Una encuesta
     */
    @Override
    public ResponseTraerEncuesta getEncuestaValoracion(RequestTraerEncuesta request) {
        //Traigo la encuesta para validar la fecha 
        ResponseTraerEncuesta response = new ResponseTraerEncuesta();
        int idBeneficiario = request.getTraerEncuestaDTO().getIdBeneficiario();
        long idEncuesta = request.getTraerEncuestaDTO().getIdEncuesta();
        try {
            Encuesta encuesta = encuestaDAO.getEncuesta(idBeneficiario, idEncuesta);
            Date date = new Date();
            //valido que la fecha sea menor a la fecha de vigencia de la encuesta
            if (date.compareTo(encuesta.getFechavigencia()) <= 0) {
                if (encuesta.getDiligenciada() != '0') {
                    String mensaje = Mensajes.ERROR_ENCUESTA_DILIGENCIADA;
                    response.setStatus("0");
                    response.setDescripcion(mensaje);

                } else {
                    Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(request.getIdfuncionario());
                    //Traigo las preguntas del dao
                    List<Preguntas> preguntas = preguntasDAO.getPreguntasValoracion(funcionario.getCajacompensacion().getIdcajacompensacion());
                    if (preguntas.size() > 0) {
                        List<PreguntasDTO> preguntasDTO = EntityToDTO.listaPreguntasToListaPreguntasDTO(preguntas);
                        //setteo el response 
                        response.setPreguntasDTO(preguntasDTO);
                        response.setStatus("1");
                        response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTAS);
                    } else {
                        response.setStatus("0");
                        response.setDescripcion(Mensajes.ERROR_ENCUESTA_NO_PARAMETRIZADA);
                    }

                }
            } else {
                response.setDescripcion(Mensajes.ERROR_ENCUESTA_VIGENCIA);
                response.setStatus("0");

            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que trae la encuesta de valoracion individual apartir del id de el
     * funcionario y del id del beneficiario
     *
     * @param request Contiene el id del funcionario y el id del beneficiario
     * @return Una encuesta
     */
    @Override
    public ResponseTraerEncuesta getEncuestaValoracionInd(RequestTraerVInd request) {

        ResponseTraerEncuesta response = new ResponseTraerEncuesta();
        long idBeneficiario = request.getIdBeneficiario();
        long idFuncionario = request.getIdFuncionario();
        try {
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(idFuncionario);
            //Traigo las preguntas del dao
            List<Preguntas> preguntas = preguntasDAO.getPreguntasValoracionInd(funcionario.getCajacompensacion().getIdcajacompensacion());
            if (preguntas.size() > 0) {
                List<PreguntasDTO> preguntasDTO = EntityToDTO.listaPreguntasToListaPreguntasDTO(preguntas);
                //setteo el response 
                response.setPreguntasDTO(preguntasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTAS);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_ENCUESTA_NO_PARAMETRIZADA);
            }

        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    /**
     * Metodo que trae la encuesta de valoracion grupal apartir del id del
     * funcionario y el id de el emprendimiento
     *
     * @param request Contiene el id del emprendimiento y el id del funcionario
     * @return Una encuesta
     */
    @Override
    public ResponseTraerEncuesta getEncuestaValoracionGrupal(RequestTraerValoGrupal request) {
        ResponseTraerEncuesta response = new ResponseTraerEncuesta();
        long idEmprendimiento = request.getIdEmprendimiento();
        long idFuncionario = request.getIdFuncionario();
        try {
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(idFuncionario);
            //Traigo las preguntas del dao
            List<Preguntas> preguntas = preguntasDAO.getPreguntasValoracionGrupal(funcionario.getCajacompensacion().getIdcajacompensacion());
            if (preguntas.size() > 0) {
                List<PreguntasDTO> preguntasDTO = EntityToDTO.listaPreguntasToListaPreguntasDTO(preguntas);
                //setteo el response 
                response.setPreguntasDTO(preguntasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_PREGUNTAS);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_ENCUESTA_NO_PARAMETRIZADA);
            }

        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

}

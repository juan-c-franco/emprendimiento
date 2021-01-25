/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinanciera;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.RequestTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseTraerInfoFinancieraBasica;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.financiacionToFinanciacionDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.financiacionToFinanciacionDTO2;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.FinanciacionDTO;
import com.growdata.emprendimiento.business.servicio.FinanciacionServicio;
import com.growdata.emprendimiento.persistence.DAO.FinanciacionDAO;
import com.growdata.emprendimiento.persistence.DAO.IntegrantescomiteDAO;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;

import com.growdata.emprendimiento.persistence.entidad.Tipofinanciacion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class FinanciacionServicioImpl implements FinanciacionServicio {

    @Autowired
    private FinanciacionDAO financiacionDAO;
    @Autowired
    private IntegrantescomiteDAO integrantesComiteDAO;
    @Autowired
    private EnviarEmail enviar;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que registra la informacion financiera basica de un emprendimiento
     *
     * @param request Contiene la informacion financiera basica de un
     * emprendimiento
     * @return Respuesta si se registró la información financiera básica
     * satisfactoriamente o no
     */
    @Override
    public ResponseRegistrarInfoFinancieraBasica guardarInfoFinancieraBasica(RequestRegistrarInfoFinancieraBasica request) {
        ResponseRegistrarInfoFinancieraBasica response = new ResponseRegistrarInfoFinancieraBasica();
        Financiacion financiacion = new Financiacion();
//        EnviarEmail enviar = new EnviarEmail();
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setIdemprendimiento(request.getIdEmprendimiento());
        Tipofinanciacion tipoFinanciacion = new Tipofinanciacion();
        tipoFinanciacion.setIdtipofinanciacion(request.getIdtipofinanciacion());
        Funcionario funcionario = new Funcionario();
        funcionario.setIdfuncionario(request.getIdFuncionario());
        financiacion.setFuncionario(funcionario);
        financiacion.setEmprendimiento(emprendimiento);
        financiacion.setCapitaltotal(request.getCapitaltotal());
        financiacion.setCapitaltrabajo(request.getCapitaltrabajo());
        financiacion.setCuotaspactadass(request.getCuotaspactadasS());
        financiacion.setEmpleosporgenerar(request.getEmpleosporgenerar());
        financiacion.setMesespuntoequilibrio(request.getMesespuntoequilibrio());
        financiacion.setMontofinanciacions(request.getMontofinanciacions());
        financiacion.setRecursospropiosae(request.getRecursospropiosae());
        financiacion.setTasaintertess(request.getTasaintertess());
        financiacion.setTipofinanciacionByIdtipofinanciacions(tipoFinanciacion);
        Date date = new Date();
        financiacion.setFecharegistro(date);
        List<Integrantescomite> integrantes = new ArrayList();
        String correo;
        try {
            Estadoemprendimiento estado = new Estadoemprendimiento();
            estado.setIdestadoemprendimiento(new BigDecimal(4));
            long id = financiacionDAO.guardarInformacionFinancieraBasica(financiacion, request.getIdEmprendimiento(), estado, request.getAprobado());
            if ("1".equals(request.getAprobado())) {
                integrantes = integrantesComiteDAO.getIntegrantesComitePorIdFuncionario(request.getIdFuncionario());
                for (Integrantescomite i : integrantes) {
                    correo = i.getFuncionario().getEmail();
                    enviar.setIdEmprendimiento(String.valueOf(request.getIdEmprendimiento()));
                    enviar.notificarGenerica(21, correo);
                }
            }
            response.setDescripcion(Mensajes.EXITO_REGISTRO_FINANCIACION);
            response.setStatus("1");
            response.setAccion(Acciones.REGISTRAR_INFO_F_BASICA);
            response.setId(id);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que trae la información financiera basica de un emprendimiento a
     * partir de un id de emprendimiento
     *
     * @param request Contiene el id del emprendimiento
     * @return La información financiera básica del emprendimiento
     */
    @Override
    public ResponseTraerInfoFinancieraBasica getInfoFinancieraBasicaPorId(RequestTraerInfoFinancieraBasica request) {
        ResponseTraerInfoFinancieraBasica response = new ResponseTraerInfoFinancieraBasica();
        Financiacion financiacion = new Financiacion();
        try {
            financiacion = financiacionDAO.getFinanciacionPorId(request.getIdEmprendimiento());
            if (financiacion != null) {
                FinanciacionDTO financiacionDTO = financiacionToFinanciacionDTO(financiacion);
                response.setFinanciacionDTO(financiacionDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_FINANCIACION);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_FINANCIACION_INEXISTENTE);
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Metodo que registra la información financiera de un emprendimiento
     *
     * @param request Contiene la información financiera de un emprendimiento
     * @return Respuesta si se registró la información financiera
     * satisfactoriamente o no
     */
    @Override
    public ResponseRegistrarInfoFinancieraBasica guardarInfoFinanciera(RequestRegistrarInfoFinanciera request) {
        ResponseRegistrarInfoFinancieraBasica response = new ResponseRegistrarInfoFinancieraBasica();
        Financiacion financiacion = new Financiacion();
        Tipofinanciacion tipofinanciacionByIdtipofinanciaciona = new Tipofinanciacion();
        tipofinanciacionByIdtipofinanciaciona.setIdtipofinanciacion(request.getIdtipofinanciacion());
        financiacion.setTipofinanciacionByIdtipofinanciaciona(tipofinanciacionByIdtipofinanciaciona);
        financiacion.setMontoa(request.getMontoa());
        financiacion.setTasainteresa(request.getTasainteresa());
        financiacion.setCuotaspactadasa(request.getCuotaspactadasa());
        Entidadesfinancieras entidad = request.getEntidadesfinancieras();
        financiacion.setEntidadesfinancieras(entidad);
        financiacion.setIdfinanciacion(request.getIdfinanciacion());
        try {
            Estadoemprendimiento estado = new Estadoemprendimiento();
            estado.setIdestadoemprendimiento(new BigDecimal(6));
            financiacionDAO.guardarInformacionFinanciera(financiacion, request.getIdEmprendimiento(), estado, request.getConfiguracion().getValor());
            response.setDescripcion(Mensajes.EXITO_REGISTRO_FINANCIACION);
            response.setStatus("1");
            response.setAccion(Acciones.REGISTRAR_INFO_F);
            response.setId(financiacion.getIdfinanciacion());
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que trae la información financiera de un emprendimiento a partir
     * de un id de emprendimiento
     *
     * @param request El id del emprendimiento
     * @return La información financiera del emprendimiento
     */
    @Override
    public ResponseTraerInfoFinancieraBasica getInfoFinancieraPorId(RequestTraerInfoFinancieraBasica request) {
        ResponseTraerInfoFinancieraBasica response = new ResponseTraerInfoFinancieraBasica();
        Financiacion financiacion = new Financiacion();
        try {
            financiacion = financiacionDAO.getFinanciacionPorId(request.getIdEmprendimiento());
            if (financiacion != null) {
                FinanciacionDTO financiacionDTO = financiacionToFinanciacionDTO2(financiacion);
                response.setFinanciacionDTO(financiacionDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_FINANCIACION);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_FINANCIACION_INEXISTENTE);
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }

        return response;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarEntidadF;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarEntidadFinanciera2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarEntidadFinanciera;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerEntidadesFinancieras;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TraerEntidadesFinancierasDTO;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.EntidadesFinancierasServicio;
import com.growdata.emprendimiento.persistence.DAO.EntidadesFinancierasDAO;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import java.math.BigDecimal;
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
public class EntidadesFinancierasServicioImpl implements EntidadesFinancierasServicio {

    @Autowired
    private EntidadesFinancierasDAO entidadesFinancierasDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae todas las entidades financieras del dao y las convierte
     * en dtos
     *
     * @param request vacio
     * @return Una lista con todas las entidades financieras
     */
    @Override
    @Transactional
    public ResponseTraerEntidadesFinancieras getEntidadesFinancierasAdmin(RequestTraerEntidadesFinancieras request) {
        ResponseTraerEntidadesFinancieras response = new ResponseTraerEntidadesFinancieras();
        try {
            List<Entidadesfinancieras> entidades = entidadesFinancierasDAO.getEntidadesFinancierasAdmin();
            if (entidades != null) {
                List<TraerEntidadesFinancierasDTO> entidadesDTO = EntityToDTO.listaEntidadesFinancierasToListaTraerEntidadesFinancierasDTO(entidades);

                response.setEntidadesDTO(entidadesDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_ENTIDADES_FINANCIERAS);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ENTIDADES_FINANCIERAS);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que crea una entidad financiera
     *
     * @param request Contiene la entidad financiera a crear
     * @return Respuesta si se creo satisfactoriamente la entidad financiera o
     * no
     */
    @Override
    @Transactional
    public ResponseRegistrarEntidadFinanciera setEntidadFinanciera(RequestRegistrarEntidadFinanciera request) {
        ResponseRegistrarEntidadFinanciera response = new ResponseRegistrarEntidadFinanciera();
        //convierto en entidad el dto
        Entidadesfinancieras entidad
                = DTOToEntity.dtoEntidadesFinancierasToEntidadesFinancieras(request.getEntidadesfinancierasDTO());
        Date date = new Date();
        entidad.setFecharegistro(date);
        //valido que todos los campos esten diligenciados
        if (!"".equals(request.getEntidadesfinancierasDTO().getDescripcion()) && !"".equals(request.getEntidadesfinancierasDTO().getNombreentidad())) {

            try {
                Entidadesfinancieras entidad2 = entidadesFinancierasDAO.getEntidadFinancieraPorNombre(entidad.getNombreentidad());
                if (entidad2 == null) {
                    BigDecimal id = entidadesFinancierasDAO.setEntidadFinanciera(entidad);

                    //valido si hubo errores registrando la entidad financiera
                    if (id != null) {
                        response.setId(id.longValue());
                        response.setAccion(Acciones.CREAR_ENTIDAD);
                        response.setDescripcion(Mensajes.EXITO_REGISTRANDO_ENTIDAD_FINANCIERA);
                        response.setStatus("1");
                    } else {
                        response.setDescripcion(Mensajes.ERROR_REGISTRO_ENTIDAD_FINANCIERA);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_ENTIDAD_EXIXTENTE);
                    response.setStatus("0");
                }
            } catch (Exception ex) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        } else {
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que trae una entidad financiera por su id
     *
     * @param request Contiene el id de la entidad financiera
     * @return Una entidad financiera
     */
    @Override
    @Transactional
    public ResponseModificarEntidadFinanciera getEntidadFinanciera(RequestModificarEntidadF request) {
        ResponseModificarEntidadFinanciera response = new ResponseModificarEntidadFinanciera();

        try {
            Entidadesfinancieras entidad = entidadesFinancierasDAO.getEntidadFinanciera(request.getIdentidadfinanciera());
            TraerEntidadesFinancierasDTO entidadDTO = EntityToDTO.entidadesFinancierasToTraerEntidadesFinancierasDTO(entidad);

            response.setEntidadDTO(entidadDTO);
            if (entidad != null) {
                response.setDescripcion(Mensajes.EXITO_CARGA_ENTIDAD_FINANCIERA);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ENTIDAD_FINANCIERA);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que actualiza una entidad financiera
     *
     * @param request Contiene una entidad financiera con la información a
     * actualizar
     * @return Respuesta si se actualizó la entidad financiera
     * satisfactoriamente o no
     */
    @Override
    public ResponseModificarEntidadFinanciera2 setEntidadFinancieraM(RequestRegistrarEntidadFinanciera request) {
        ResponseModificarEntidadFinanciera2 response = new ResponseModificarEntidadFinanciera2();

        //convierto en entidad el dto
        Entidadesfinancieras entidad
                = DTOToEntity.dtoEntidadesFinancierasToEntidadesFinancieras(request.getEntidadesfinancierasDTO());
        //valido que todos los campos esten diligenciados
        if (!"".equals(request.getEntidadesfinancierasDTO().getDescripcion()) && !"".equals(request.getEntidadesfinancierasDTO().getNombreentidad())) {

            try {
                Entidadesfinancieras entidad2 = entidadesFinancierasDAO.getEntidadFinancieraPorNombreM(entidad.getNombreentidad(), entidad.getIdentidadfinanciera());
                if (entidad2 == null) {
                    String resp = entidadesFinancierasDAO.setEntidadFinancieraM(entidad);

                    //valido si hubo errores registrando la entidad financiera
                    if ("1".equals(resp)) {
                        response.setAccion(Acciones.MODIFICAR_ENTIDAD);
                        response.setDescripcion(Mensajes.EXITO_MODIFICAR_ENTIDAD_FINANCIERA);
                        response.setStatus(resp);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_MODIFICAR_ENTIDAD_FINANCIERA);
                        response.setStatus(resp);
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_ENTIDAD_EXIXTENTE);
                    response.setStatus("0");
                }
            } catch (Exception ex) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
                response.setDescripcion(ex.getMessage());
                response.setStatus("0");
            }
        } else {
            response.setDescripcion(Mensajes.ERROR_PARAMETROS);
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Metodo que trae todas las entidades financieras activas
     *
     * @param request vacio
     * @return Una lista con las entidades financieras activas
     */
    @Override
    public ResponseTraerEntidadesFinancieras getEntidadesFinancieras(RequestTraerEntidadesFinancieras request) {
        ResponseTraerEntidadesFinancieras response = new ResponseTraerEntidadesFinancieras();
        try {
            List<Entidadesfinancieras> entidades = entidadesFinancierasDAO.getEntidadesFinancieras();
            if (entidades != null) {
                List<TraerEntidadesFinancierasDTO> entidadesDTO = EntityToDTO.listaEntidadesFinancierasToListaTraerEntidadesFinancierasDTO(entidades);

                response.setEntidadesDTO(entidadesDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_ENTIDADES_FINANCIERAS);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ENTIDADES_FINANCIERAS);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que borra una entidad financiera con su id
     *
     * @param request Contiene el id de la entidad financiera
     * @return Respuesta si se borro la entidad financiera satisfactoriamente o
     * no
     */
    @Override
    public ResponseRegistrarEntidadFinanciera borrarEntidadFinanciera(RequestBorrarEntidadFinanciera request) {
        ResponseRegistrarEntidadFinanciera response = new ResponseRegistrarEntidadFinanciera();
        try {
            entidadesFinancierasDAO.borrarEntidadFinanciera(request.getIdentidadesfinanciera());
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_BORRAR_ENTIDAD_FINANCIERA);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseCajaCompensacion;
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGestionarCuentas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModificarCaja2;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRegistrarCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCajas;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestBorrarCajaCompensacion;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.DTOToEntity.dtoCajaCompensacionToCajaCompensacion;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.cajaCompensacionToCajaCompensacionDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaCajaCompensacionToListaCajaCompensacionDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaCajaCompensacionTolistaGestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.CajasDeCompensacionServicio;
import com.growdata.emprendimiento.persistence.DAO.CajasDeCompensacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
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
public class CajasDeCompensacionServicioImpl implements CajasDeCompensacionServicio {

    @Autowired
    private CajasDeCompensacionDAO cajasDeCompensacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae las cajas de compensacion activas
     *
     * @param request vacio
     * @return Lista de cajas de compensación activas
     */
    @Override
    @Transactional
    public ResponseTraerCajas getCajasDeCompensacion(RequestTraerCajas request) {
        ResponseTraerCajas response = new ResponseTraerCajas();
        try {
            List<Cajacompensacion> cajas = cajasDeCompensacionDAO.getCajasDeCompensacion();
            //valido que efectivamente se hayan traido las cajas del DAO
            if (cajas != null) {
                List<CajacompensacionDTO> cajasDTO = listaCajaCompensacionToListaCajaCompensacionDTO(cajas);
                response.setCajasDTO(cajasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_CAJAS_COMPENSACION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_CAJAS_COMPENSACION);
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
     * Metodo que crea una caja de compensacion
     *
     * @param request Contiene la caja de compensación a crear
     * @return Respuesta si se creo la caja o no
     */
    @Override
    public ResponseRegistrarCaja setCajaCompensacion(RequestRegistrarCaja request) {
        ResponseRegistrarCaja response = new ResponseRegistrarCaja();
        if (!"".equals(request.getCajaDTO().getNombrecajacompensacion()) && !"".equals(request.getCajaDTO().getCodigoccf())) {
            Cajacompensacion caja = dtoCajaCompensacionToCajaCompensacion(request.getCajaDTO());
            Date date = new Date();
            caja.setFecharegistro(date);
            caja.setDepartamento("      ");
            try {
                Cajacompensacion caja2 = cajasDeCompensacionDAO.getCajaCompensacionPorNombre(caja.getNombrecajacompensacion());
                if (caja2 == null) {
                    BigDecimal id = cajasDeCompensacionDAO.setCajaCompensacion(caja);
                    if (id != null) {
                        response.setId(id.longValue());
                        response.setAccion(Acciones.CREAR_CAJA);
                        response.setDescripcion(Mensajes.EXITO_REGISTRO_CAJA_COMPENSACION);
                        response.setStatus("1");
                    } else {
                        response.setDescripcion(Mensajes.ERROR_REGISTRO_CAJA_COMPENSACION);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_CAJA_EXIXTENTE);
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
     * Metodo que trae una caja de compensación por su id
     *
     * @param request Contiene el id de la caja de compensación
     * @return Una caja de compensación
     */
    @Override
    public ResponseModificarCaja getCajaCompensacion(RequestModificarCaja request) {
        ResponseModificarCaja response = new ResponseModificarCaja();
        try {
            Cajacompensacion caja = cajasDeCompensacionDAO.getCajaCompensacion(request.getIdcajacompensacion());
            if (caja != null) {
                CajacompensacionDTO cajaDTO = cajaCompensacionToCajaCompensacionDTO(caja);
                response.setCajaDTO(cajaDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_CAJA_COMPENSACION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_CAJA_COMPENSACION);
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
     * Metodo que actualiza una caja de compensacion
     *
     * @param request Contiene la caja de compensación con los datos a
     * actualizar
     * @return Respuesta si se modificó la caja exitosamente o no
     */
    @Override
    public ResponseModificarCaja2 setCajaCompensacionM(RequestModificarCaja2 request) {
        ResponseModificarCaja2 response = new ResponseModificarCaja2();
        if (!"".equals(request.getCajaDTO().getNombrecajacompensacion()) && !"".equals(request.getCajaDTO().getCodigoccf())) {
            Cajacompensacion caja = dtoCajaCompensacionToCajaCompensacion(request.getCajaDTO());
            try {

                Cajacompensacion caja2 = cajasDeCompensacionDAO.getCajaCompensacionPorNombreM(caja.getNombrecajacompensacion(), caja.getIdcajacompensacion());
                if (caja2 == null) {
                    caja.setDepartamento("      ");
                    String resp = cajasDeCompensacionDAO.setCajaCompensacionM(caja);

                    if ("1".equals(resp)) {

                        response.setAccion(Acciones.MODIFICAR_CAJA);
                        response.setDescripcion(Mensajes.EXITO_MODIFICAR_CAJA_COMPENSACION);
                        response.setStatus(resp);
                    } else {
                        response.setDescripcion(Mensajes.ERROR_MODIFICAR_CAJA_COMPENSACION);
                        response.setStatus("0");
                    }
                } else {
                    response.setDescripcion(Mensajes.ERROR_CAJA_EXIXTENTE);
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
     * Servicio encargados ubicar todas las cajas de compensación activas.
     *
     * @param request Contiene los datos de la Caja de Compensación que se desea
     * ubicar.
     * @return Lista de Cajas de Compensación que cumplen con el criterior de
     * búsqueda.
     */
    @Override
    public ResponseGestionarCuentas getNombresCajas(RequestGestionarCuentas request) {
        ResponseGestionarCuentas response = new ResponseGestionarCuentas();
        try {
            List<Cajacompensacion> cajas = cajasDeCompensacionDAO.getCajasDeCompensacion();
            //valido que efectivamente se hayan traido las cajas del DAO
            if (cajas != null) {
                List<GestionarFuncionarioDTO> funcisDTO = listaCajaCompensacionTolistaGestionarFuncionarioDTO(cajas);
                response.setFuncisDTO(funcisDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_CAJAS_COMPENSACION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_CAJAS_COMPENSACION);
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
     * Metodo que trae todas las cajas de compensación
     *
     * @param request vacio
     * @return Lista con todas las cajas de compensación
     */
    @Override
    public ResponseTraerCajas getCajasDeCompensacionAdmin(RequestTraerCajas request) {
        ResponseTraerCajas response = new ResponseTraerCajas();
        try {
            List<Cajacompensacion> cajas = cajasDeCompensacionDAO.getCajasDeCompensacionAdmin();
            //valido que efectivamente se hayan traido las cajas del DAO
            if (cajas != null) {
                List<CajacompensacionDTO> cajasDTO = listaCajaCompensacionToListaCajaCompensacionDTO(cajas);
                response.setCajasDTO(cajasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_CAJAS_COMPENSACION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_CAJAS_COMPENSACION);
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
     * Metodo que trae una caja de compensacion por su id.
     *
     * @param idCaja Identificador de la caja de compensación
     * @return Respuesta con Caja de Compensación que cumpla con el criterio de
     * búsqueda.
     */
    public ResponseCajaCompensacion getCajaCompensacionPorId(BigDecimal idCaja) {
        ResponseCajaCompensacion response = new ResponseCajaCompensacion();
        try {
            response.setCaja(EntityToDTO.cajaCompensacionToCajaCompensacionDTO(
                    cajasDeCompensacionDAO.getCajaCompensacion(idCaja)));
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

    /**
     * Metodo que borra una caja de compensacion por su id
     *
     * @param request Contiene el id de la caja de compensación a borrar
     * @return Respuesta si se borró la caja de compensación exitosamente o no
     */
    @Override
    public ResponseRegistrarCaja borrarCajaCompensacion(RequestBorrarCajaCompensacion request) {
        ResponseRegistrarCaja response = new ResponseRegistrarCaja();
        try {
            cajasDeCompensacionDAO.borrarCajaCompensacion(request.getIdcajacompensacion());
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_BORRAR_CAJA_COMPENSACION);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }
}

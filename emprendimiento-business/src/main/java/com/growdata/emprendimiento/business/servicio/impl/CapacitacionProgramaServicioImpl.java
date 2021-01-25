/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerCapacitacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCapacitacion;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.capacitacionProgramaToCapacitacionProgramaDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CapacitacionprogramaDTO;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import java.util.Date;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseCapacitaciones;
import com.growdata.emprendimiento.business.servicio.CapacitacionProgramaServicio;
import com.growdata.emprendimiento.persistence.DAO.CapacitacionProgramaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class CapacitacionProgramaServicioImpl implements CapacitacionProgramaServicio {

    @Autowired
    private CapacitacionProgramaDAO capacitacionProgramaDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Mètodo responsable de traer todas las capacitaciòn dado un identificador
     * de Sede
     *
     * @param idSede Identificador de Sede
     * @return Respuesta si fue exitosa o no la consulta, ademàs de la Lista de
     * Capacitaciones.
     */
    @Override
    public ResponseCapacitaciones getCapacitaciones(long idSede) {
        ResponseCapacitaciones response = new ResponseCapacitaciones();
        try {
            response.setCapacitaciones(EntityToDTO.listCapacitacionProgramaToListCapacitacionProgramaDTO(capacitacionProgramaDAO.getCapacitaciones(idSede)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_CAPACITACIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_CAPACITACIONES);
        }
        return response;
    }

    /**
     * Mètodo encargado de ubicar todas las capacitaciones.
     *
     * @return Respuesta si fue exitosa o no la consulta, ademàs de la Lista de
     * Capacitaciones.
     */
    @Override
    public ResponseCapacitaciones getCapacitaciones() {
        ResponseCapacitaciones response = new ResponseCapacitaciones();
        try {
            response.setCapacitaciones(EntityToDTO.listCapacitacionProgramaToListCapacitacionProgramaDTO(capacitacionProgramaDAO.getCapacitaciones()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_CAPACITACIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_CAPACITACIONES);
        }
        return response;
    }

    /**
     * Metodo que crea una capacitación
     *
     * @param request Contiene toda la información de la capacitación a crear
     * @return Una respuesta si se creó la capacitación exitosamente o no
     */
    @Override
    public ResponseDTO crearCapacitacion(RequestCapacitacion request) {
        ResponseDTO response = new ResponseDTO();
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setCategoria(request.getCategoria());
        capacitacion.setEstadocapacitacionprograma(request.getEstadoCapacitacionPrograma());
        capacitacion.setFecharegistro(new Date());
        capacitacion.setIdoferenteinstitucion(request.getIdoferenteinstitucion());
        capacitacion.setNombrecapacitacionprograma(request.getNombrecapacitacionprograma());
        try {
            Capacitacionprograma validacion = capacitacionProgramaDAO.traerCapacitacionporNombre(capacitacion.getNombrecapacitacionprograma(), -1);
            if (validacion == null) {
                long id = capacitacionProgramaDAO.crearCapacitacion(capacitacion);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CREAR_CAPACITACION);
                response.setAccion(Acciones.CREAR_CAPACITACION);
                response.setId(id);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_CAPACITACION_REPETIDA);
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CREAR_CAPACITACION);
        }
        return response;
    }

    /**
     * Metodo que actualiza una capacitación
     *
     * @param request Contiene toda la información de la capacitación a
     * actualizar
     * @return Una respuesta si se actualizó la capacitación exitosamente o no
     */
    @Override
    public ResponseDTO modificarCapacitacion(RequestCapacitacion request) {
        ResponseDTO response = new ResponseDTO();
        Capacitacionprograma capacitacion = new Capacitacionprograma();
        capacitacion.setCategoria(request.getCategoria());
        capacitacion.setEstadocapacitacionprograma(request.getEstadoCapacitacionPrograma());
        capacitacion.setFecharegistro(new Date());
        capacitacion.setIdoferenteinstitucion(request.getIdoferenteinstitucion());
        capacitacion.setNombrecapacitacionprograma(request.getNombrecapacitacionprograma());
        capacitacion.setIdcapacitacionprograma(request.getIdcapacitacionprograma());
        try {
            Capacitacionprograma validacion = capacitacionProgramaDAO.traerCapacitacionporNombre(capacitacion.getNombrecapacitacionprograma(), capacitacion.getIdcapacitacionprograma());
            if (validacion == null) {
                capacitacionProgramaDAO.modificarCapacitacion(capacitacion);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_MODIFICAR_CAPACITACION);
                response.setAccion(Acciones.MODIFICAR_CAPACITACION);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_CAPACITACION_REPETIDA);
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_MODIFICAR_CAPACITACION);
        }
        return response;
    }

    /**
     * Metodo que trae una capacitación a partir de su id
     *
     * @param request Contiene el id de la capacitación a traer
     * @return Una respuesta que contiene una capacitación
     */
    @Override
    public ResponseTraerCapacitacion traerCapacitacion(RequestTraerCapacitacion request) {
        ResponseTraerCapacitacion response = new ResponseTraerCapacitacion();
        try {
            Capacitacionprograma capacitacion = capacitacionProgramaDAO.traerCapacitacion(request.getIdcapacitacionprograma());
            CapacitacionprogramaDTO capacitacionDTO = capacitacionProgramaToCapacitacionProgramaDTO(capacitacion);
            response.setCapacitacion(capacitacionDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_CAPACITACION);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_CAPACITACION);
        }
        return response;
    }

    /**
     * Metodo que trae todas las capacitaciones parametrizadas en el sistema
     *
     * @return Una respuesta que contiene una lista de capacitaciones
     */
    @Override
    public ResponseCapacitaciones getCapacitacionesParametrizar() {
        ResponseCapacitaciones response = new ResponseCapacitaciones();
        try {
            response.setCapacitaciones(EntityToDTO.listCapacitacionProgramaToListCapacitacionProgramaDTO(capacitacionProgramaDAO.getCapacitacionesParametrizar()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_CAPACITACIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_CAPACITACIONES);
        }
        return response;
    }

}

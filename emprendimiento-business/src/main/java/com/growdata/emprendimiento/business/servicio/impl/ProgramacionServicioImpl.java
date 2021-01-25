/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseProgramaciones;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.ProgramacionServicio;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class ProgramacionServicioImpl implements ProgramacionServicio {

    @Autowired
    private ProgramacionDAO programacionDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private Environment env;

    /**
     * Método encargado de ubicar las programaciones según un identificador de
     * Docente
     *
     * @param iddocente Identificador de Docente.
     * @param desde Fecha de Inicio de búsqueda
     * @return Respuesta que indica si la consulta fue exitosa o no, junto con
     * la lista de Programaciones.
     */
    @Override
    public ResponseProgramaciones getProgramaciones(long iddocente, Date desde) {
        ResponseProgramaciones response = new ResponseProgramaciones();
        try {
            if (desde == null) {
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, Integer.parseInt(env.getProperty("meses.muestra.calendario.programacion.sesion")));
                desde = cal.getTime();
            }

            response.setProgramaciones(EntityToDTO.listProgramacionToListProgramacionDTO(programacionDAO.getProgramaciones(iddocente, desde)));
            response.setDescripcion(Mensajes.EXITO_CARGANDO_PROGRAMACIONES);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_PROGRAMACIONES);
            response.setProgramaciones(new ArrayList<>());
        }
        return response;
    }

    /**
     * Servicio encargado de guardar la programación
     *
     * @param programacion Programación a crear
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO saveProgramaciones(Programacion programacion) {
        ResponseDTO response = new ResponseDTO();
        try {
            long id = programacionDAO.saveProgramaciones(programacion);
            mail.notificaProgramacionGenerica(38, programacion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_PROGRAMAR_SESIONES);
            response.setAccion(Acciones.REGISTRAR_PROGRAMACION);
            response.setId(id);
        } catch (HibernateException e) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EXISTE SOLAPE":
                    response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONES);
                    break;
                default:
                    log.writeToLogFile(ex);
                    response.setDescripcion(Mensajes.ERROR_PROGRAMAR_SESIONES);
            }
        }
        return response;
    }

    /**
     * Servicio responsable de actualizar una programación
     *
     * @param programacion Programación con los parametros que se desean
     * actualizar.
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO updateProgramaciones(Programacion programacion) {
        ResponseDTO response = new ResponseDTO();
        try {
            programacionDAO.updateProgramaciones(programacion);
            mail.notificaProgramacionGenerica(39, programacion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ACTUALIZAR_SESIONES);
            response.setAccion(Acciones.MODIFICAR_PROGRAMACION);
        } catch (HibernateException ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        } catch (Exception ex) {
            response.setStatus("0");
            switch (ex.getMessage()) {
                case "EXISTE SOLAPE":
                    response.setDescripcion(Mensajes.ERROR_SOLAPE_SESIONES);
                    break;
                default:
                    log.writeToLogFile(ex);
                    response.setDescripcion(Mensajes.ERROR_ACTUALIZAR_SESIONES);
            }

        }
        return response;
    }

    /**
     * Servicio encargado de cancelar una programación.
     *
     * @param programacion Programación que se desea cancelar
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO deleteProgramaciones(Programacion programacion) {
        ResponseDTO response = new ResponseDTO();
        try {
            mail.notificaProgramacionGenerica(37, programacion);
            programacionDAO.deleteProgramaciones(programacion);
//            new EnviarEmail().notificaBeneficiariosGenerica(7, sesion);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ELIMINAR_SESIONES);
            response.setAccion(Acciones.ELIMINAR_PROGRAMACION);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_HIBERNATE);
        }
        return response;
    }

    /**
     * Método encargado de ubicar un programación por su identificador.
     *
     * @param idProgramacion Identificador de la programación
     * @return Respuesta si fue exitosa o no la consulta, además de la lista con
     * una programación.
     */
    @Override
    public ResponseProgramaciones getProgramacion(BigDecimal idProgramacion) {
        ResponseProgramaciones response = new ResponseProgramaciones();
        try {
            Programacion programacion = programacionDAO.getProgramacion(idProgramacion);
            if (programacion != null) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_CARGANDO_PROGRAMACIONES);
                response.setProgramaciones(new ArrayList<>());
            }
            response.getProgramaciones().add(EntityToDTO.programacionToProgramacionDTOFull(programacion));
            response.setDescripcion(Mensajes.EXITO_CARGANDO_PROGRAMACIONES);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_PROGRAMACIONES);
            response.setProgramaciones(new ArrayList<>());
        }
        return response;
    }

    /**
     * Método encargado de ubicar las Programaciones por Sede y Capacitación.
     *
     * @param idsede Identificador de la Sede
     * @param idcapacitacion Identificador de la Capacitación
     * @param desde Indica desde que fecha se hará la búsqueda.
     * @param vencidas Indica si las sesiones que se desean ubicar deben estar
     * en el pasado.
     * @return Respuesta si fue exitosa o no la consulta, junto con la Lista de
     * Programaciones.
     */
    @Override
    public ResponseProgramaciones getProgramacionPorSedeCapacitacion(BigDecimal idsede,
            long idcapacitacion, Date desde, Short vencidas) {
        ResponseProgramaciones response = new ResponseProgramaciones();
        try {
            response.setProgramaciones(
                    EntityToDTO.listProgramacionToListProgramacionDTO(
                            programacionDAO.getProgramacionPorSedeCapacitacion(
                                    idsede, idcapacitacion, desde, vencidas)));
            response.setDescripcion(Mensajes.EXITO_CARGANDO_PROGRAMACIONES);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_PROGRAMACIONES);
            response.setProgramaciones(new ArrayList<>());
        }
        return response;
    }

}

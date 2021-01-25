/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.AprobacionServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class AprobacionServicioImpl implements AprobacionServicio {

    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private AprobacionDAO aprobacionDAO;
    @Autowired
    private AlumnosDAO alumnosDAO;
    @Autowired
    private EnviarEmail enviar;

    /**
     * Método encargado de registrar calificaciones a las Capacitaciones.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param idFuncionario Identificador del Funcionario que realiza el
     * registro.
     * @param lAlumnos Lista de Alumnos.s
     * @param registroGlobal Arreglo de horas a registrar.
     * @return Respuesta si fue exitoso o no el registro.
     */
    @Override
    public ResponseAprobaciones registrarCalificacionCapacitacion(BigDecimal idProgramacion, long idFuncionario,
            List<AlumnosShortDTO> lAlumnos, List<String> registroGlobal) {
        ResponseAprobaciones response = new ResponseAprobaciones();
        try {
            List<Aprobacion> registros = new ArrayList<>();
            int indexA = 0;
            for (String s : registroGlobal) {
                registros.add(new Aprobacion(null, new Funcionario(idFuncionario),
                        new Alumnos(lAlumnos.get(indexA).getIdalumno()),
                        new Short("0"), new Short("-2"), new Short(s), new Date()));
                indexA++;
            }

            aprobacionDAO.registrarCalificacionCapacitacion(registros, idProgramacion);
            registros = aprobacionDAO.getAprobacionesPorProgramacion(idProgramacion);

            for (Aprobacion apr : registros) {
                enviar.setNombres(apr.getAlumnos().getBeneficiario().getPrimernombre() + " "
                        + (apr.getAlumnos().getBeneficiario().getSegundonombre() != null ? apr.getAlumnos().getBeneficiario().getSegundonombre() : ""));
                enviar.setApellidos(apr.getAlumnos().getBeneficiario().getPrimerapellido() + " "
                        + (apr.getAlumnos().getBeneficiario().getSegundoapellido() != null ? apr.getAlumnos().getBeneficiario().getSegundoapellido() : ""));
                enviar.setTipoSesion(apr.getAlumnos().getProgramacion().getCapacitacionprograma().getNombrecapacitacionprograma());
                enviar.setHoras((apr.getCalificacionfinal() == 1 ? Mensajes.APROBADO : Mensajes.REPROBADO));
                enviar.notificarGenerica(42, apr.getAlumnos().getBeneficiario().getEmail());
            }

            response.setAprobaciones(EntityToDTO.listAprobacionToListAprobacionDTO(registros));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRANDO_CALIFICACION_PROGRAMACIONES);
            response.setAccion(Acciones.REGISTRAR_CALIFICACION_PROGRAMACION);
            response.setId(new Long(idProgramacion.toString()));
        } catch (Exception ex) {
            response.setStatus("0");
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_REGISTRANDO_CALIFICACION_PROGRAMACIONES);
        }
        return response;
    }

    /**
     * Método encargado de registrar calificaciones a las Capacitaciones.
     *
     * @param requestCalificaciones Lista de Calificaciones.
     * @param idFuncionario Identificador del Funcionario.
     * @param idProgramacion Identificador de la Programación.
     * @return Respuesta si fue exitoso o no el registro.
     */
    @Override
    public ResponseAprobaciones registrarCalificacionCapacitacionMasiva(
            List<RequestCalificacionDTO> requestCalificaciones, long idFuncionario,
            BigDecimal idProgramacion) {
        ResponseAprobaciones response = new ResponseAprobaciones();
        try {
            List<Aprobacion> registros = new ArrayList<>();
            for (RequestCalificacionDTO r : requestCalificaciones) {
                registros.add(new Aprobacion(null, new Funcionario(idFuncionario),
                        new Alumnos(r.getIdalumno()),
                        new Short("0"), new Short("-1"), r.getCalificacionfinal(), new Date()));
            }

            aprobacionDAO.registrarCalificacionCapacitacion(registros, idProgramacion);
            registros = aprobacionDAO.getAprobacionesPorProgramacion(idProgramacion);

            for (Aprobacion apr : registros) {
                enviar.setNombres(apr.getAlumnos().getBeneficiario().getPrimernombre() + " "
                        + (apr.getAlumnos().getBeneficiario().getSegundonombre() != null ? apr.getAlumnos().getBeneficiario().getSegundonombre() : ""));
                enviar.setApellidos(apr.getAlumnos().getBeneficiario().getPrimerapellido() + " "
                        + (apr.getAlumnos().getBeneficiario().getSegundoapellido() != null ? apr.getAlumnos().getBeneficiario().getSegundoapellido() : ""));
                enviar.setTipoSesion(apr.getAlumnos().getProgramacion().getCapacitacionprograma().getNombrecapacitacionprograma());
                enviar.setHoras((apr.getCalificacionfinal() == 1 ? Mensajes.APROBADO : Mensajes.REPROBADO));
                enviar.notificarGenerica(42, apr.getAlumnos().getBeneficiario().getEmail());
            }

            response.setAprobaciones(EntityToDTO.listAprobacionToListAprobacionDTO(registros));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRANDO_CALIFICACION_PROGRAMACIONES);
            response.setAccion(Acciones.REGISTRAR_CALIFICACION_PROGRAMACION);
            response.setId(new Long(idProgramacion.toString()));
        } catch (Exception ex) {
            response.setStatus("0");
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_REGISTRANDO_CALIFICACION_PROGRAMACIONES);
        }
        return response;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.AlumnosShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ModuloscicloShortDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.RequestCalificacionDTO;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAprobaciones;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSeguimientoasistencia;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.SeguimientoasistenciaServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.DAO.ModuloCicloDAO;
import com.growdata.emprendimiento.persistence.DAO.SeguimientoasistenciaDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import com.growdata.emprendimiento.persistence.entidad.Seguimientoasistencia;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class SeguimientoasistenciaServicioImpl implements SeguimientoasistenciaServicio {

    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private SeguimientoasistenciaDAO seguimientoasistenciaDAO;
    @Autowired
    private AprobacionDAO aprobacionDAO;
    @Autowired
    private ModuloCicloDAO moduloCicloDAO;
    @Autowired
    private AlumnosDAO alumnosDAO;
    @Autowired
    private EnviarEmail enviar;

    /**
     * Método encargado de registrar la asistencia a las Capacitaciones.
     *
     * @param idProgramacion Identificador de la Programación.
     * @param idFuncionario Identificador del Funcionario que realiza el
     * registro.
     * @param lAlumnos Lista de Alumnos.
     * @param lModulo Lista de Modulos.
     * @param registroGlobal Arreglo de horas a registrar.
     * @return Respuesta si fue exitoso o no el registro, además de la lista de
     * Aprobaciones.
     */
    @Override
    public ResponseAprobaciones registrarAsistenciaCapacitacion(BigDecimal idProgramacion, long idFuncionario,
            List<AlumnosShortDTO> lAlumnos, List<ModuloscicloShortDTO> lModulo, List<List<String>> registroGlobal) {
        ResponseAprobaciones response = new ResponseAprobaciones();
        try {
            List<Seguimientoasistencia> registros = new ArrayList<>();
            Set<Long> modulos = new HashSet<>(0);
            Set<BigDecimal> alumnos = new HashSet<>(0);
            List<Modulociclo> modulosList = new ArrayList<>();
            List<Alumnos> alumnosList = new ArrayList<>();
            int indexA = 0;
            for (List<String> l : registroGlobal) {
                int indexM = 0;
                for (String hora : l) {
                    if (hora != null && !"".equals(hora)) {
                        modulos.add(lModulo.get(indexM).getIdmodulociclo());
                        alumnos.add(lAlumnos.get(indexA).getIdalumno());
                        Seguimientoasistencia asistencia = new Seguimientoasistencia(null,
                                new Funcionario(idFuncionario), new Alumnos(lAlumnos.get(indexA).getIdalumno()),
                                new Modulociclo(lModulo.get(indexM).getIdmodulociclo()), new Short(hora), new Date());
                        registros.add(asistencia);
                    }
                    indexM++;
                }
                indexA++;
            }

            for (Long m : modulos) {
                modulosList.add(moduloCicloDAO.traerModulo(m));
            }

            for (BigDecimal a : alumnos) {
                alumnosList.add(alumnosDAO.getAlumno(a));
            }

            seguimientoasistenciaDAO.registrarAsistenciaCapacitacion(registros, idProgramacion, idFuncionario);

            for (Seguimientoasistencia s : registros) {
                for (Alumnos a : alumnosList) {
                    if (a.getIdalumno().compareTo(s.getAlumnos().getIdalumno()) == 0) {
                        for (Modulociclo m : modulosList) {
                            if (m.getIdmodulociclo() == s.getModulociclo().getIdmodulociclo()) {
                                enviar.setNombres(a.getBeneficiario().getPrimernombre() + " "
                                        + (a.getBeneficiario().getSegundonombre() != null ? a.getBeneficiario().getSegundonombre() : ""));
                                enviar.setApellidos(a.getBeneficiario().getPrimerapellido() + " "
                                        + (a.getBeneficiario().getSegundoapellido() != null ? a.getBeneficiario().getSegundoapellido() : ""));
                                enviar.setTipoSesion(m.getCapacitacionprograma().getNombrecapacitacionprograma() + " - " + m.getNombremodulociclo());
                                enviar.setHoras(String.valueOf(s.getCantidadhorasasistencia()));
                                enviar.notificarGenerica(41, a.getBeneficiario().getEmail());
                            }
                        }
                    }
                }

            }
            response.setAprobaciones(EntityToDTO.listAprobacionToListAprobacionDTO(aprobacionDAO.getAprobacionesPorProgramacion(idProgramacion)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRANDO_ASISTENCIA_PROGRAMACIONES);
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA_PROGRAMACION);
            response.setId(new Long(idProgramacion.toString()));
        } catch (Exception ex) {
            response.setStatus("0");
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_REGISTRANDO_ASISTENCIA_PROGRAMACIONES);
        }
        return response;
    }

    /**
     * Método encargado de ubicar un Seguimientoasistencia según su Alumno y
     * Modulociclo.
     *
     * @param idalumno Identificador del Alumno.
     * @param idmodulociclo Identificador del Modulociclo.
     *
     * @return Respuesta si fue exitosa o no la consulta, junto con la lista de
     * Seguimientoasistencia.
     */
    @Override
    public ResponseSeguimientoasistencia getSeguimientoAlumnoModulo(BigDecimal idalumno, long idmodulociclo) {
        ResponseSeguimientoasistencia response = new ResponseSeguimientoasistencia();
        try {
            response.setSeguimientos(EntityToDTO.listSeguimientoasistenciaToListSeguimientoAsistenciaDTO(seguimientoasistenciaDAO.getSeguimientoAlumnoModulo(idalumno, idmodulociclo)));
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEGUIMIENTOASISTENCIA);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEGUIMIENTOASISTENCIA);
            response.setSeguimientos(new ArrayList<>());
        }
        return response;
    }

    /**
     * Método encargado de registrar asistencias a las Capacitaciones.
     *
     * @param requestCalificaciones Lista de Calificaciones.
     * @param idFuncionario Identificador del Funcionario.
     * @param idProgramacion Identificador de la Programación.
     * @return Respuesta si fue exitoso o no el registro.
     */
    @Override
    public ResponseAprobaciones registrarAsistenciaCapacitacionMasiva(
            List<RequestCalificacionDTO> requestCalificaciones, long idFuncionario,
            BigDecimal idProgramacion) {
        ResponseAprobaciones response = new ResponseAprobaciones();
        try {
            List<Seguimientoasistencia> registros = new ArrayList<>();
            Set<Long> modulos = new HashSet<>(0);
            Set<BigDecimal> alumnos = new HashSet<>(0);
            List<Modulociclo> modulosList = new ArrayList<>();
            List<Alumnos> alumnosList = new ArrayList<>();
            for (RequestCalificacionDTO r : requestCalificaciones) {
                modulos.add(r.getIdmodulociclo());
                alumnos.add(r.getIdalumno());
                Seguimientoasistencia asistencia = new Seguimientoasistencia(null,
                        new Funcionario(idFuncionario), new Alumnos(r.getIdalumno()),
                        new Modulociclo(r.getIdmodulociclo()), r.getCalificacionfinal(), new Date());
                registros.add(asistencia);
            }

            for (Long m : modulos) {
                modulosList.add(moduloCicloDAO.traerModulo(m));
            }

            for (BigDecimal a : alumnos) {
                alumnosList.add(alumnosDAO.getAlumno(a));
            }

            seguimientoasistenciaDAO.registrarAsistenciaCapacitacion(registros, idProgramacion, idFuncionario);

            for (Seguimientoasistencia s : registros) {
                for (Alumnos a : alumnosList) {
                    if (a.getIdalumno().compareTo(s.getAlumnos().getIdalumno()) == 0) {
                        for (Modulociclo m : modulosList) {
                            if (m.getIdmodulociclo() == s.getModulociclo().getIdmodulociclo()) {
                                enviar.setNombres(a.getBeneficiario().getPrimernombre() + " "
                                        + (a.getBeneficiario().getSegundonombre() != null ? a.getBeneficiario().getSegundonombre() : ""));
                                enviar.setApellidos(a.getBeneficiario().getPrimerapellido() + " "
                                        + (a.getBeneficiario().getSegundoapellido() != null ? a.getBeneficiario().getSegundoapellido() : ""));
                                enviar.setTipoSesion(m.getCapacitacionprograma().getNombrecapacitacionprograma() + " - " + m.getNombremodulociclo());
                                enviar.setHoras(String.valueOf(s.getCantidadhorasasistencia()));
                                enviar.notificarGenerica(41, a.getBeneficiario().getEmail());
                            }
                        }
                    }
                }

            }
            response.setAprobaciones(EntityToDTO.listAprobacionToListAprobacionDTO(aprobacionDAO.getAprobacionesPorProgramacion(idProgramacion)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_REGISTRANDO_ASISTENCIA_PROGRAMACIONES);
            response.setAccion(Acciones.REGISTRAR_ASISTENCIA_PROGRAMACION);
            response.setId(new Long(idProgramacion.toString()));
        } catch (Exception ex) {
            response.setStatus("0");
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_REGISTRANDO_ASISTENCIA_PROGRAMACIONES);
        }
        return response;
    }

}

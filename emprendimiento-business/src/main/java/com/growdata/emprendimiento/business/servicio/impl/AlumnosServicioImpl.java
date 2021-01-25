/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAlumnos;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.AlumnosServicio;
import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.DAO.SedesDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Sedes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javassist.tools.reflect.CannotCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class AlumnosServicioImpl implements AlumnosServicio {

    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private AlumnosDAO alumnosDAO;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private EnviarEmail enviar;
    @Autowired
    private ProgramacionDAO programacionDAO;
    @Autowired
    private SedesDAO sedesDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private FuncionarioDAO funcionarioDAO;

    /**
     * Método encargado de ubicar la lista de Alumnos según la programación.
     *
     * @param idprogramacion Identificador de la Programación
     * @return Respuesta si fue exitosa o no la búsqueda, además de la lista de
     * alumnos asociados a la programación.
     */
    @Override
    public ResponseAlumnos getLista(BigDecimal idprogramacion) {
        ResponseAlumnos response = new ResponseAlumnos();
        try {
            response.setAlumnos(EntityToDTO.listAlumnosToListAlumnosDTOFull(alumnosDAO.getLista(idprogramacion)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_ALUMNOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGANDO_ALUMNOS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método encargado de asociar un Beneficiario a una Programación.
     *
     * @param idprogramacion Identificador de la Programación.
     * @param idBeneficiario Identificador del Beneficiario.
     * @param idFuncionario Identificador del Funcionario.
     * @return Respuesta si fue exitoso o no el proceso.
     */
    @Override
    public ResponseDTO asociarBeneficiarioProgramacion(BigDecimal idprogramacion,
            long idBeneficiario, long idFuncionario) {
        ResponseDTO response = new ResponseDTO();
        try {
            List<String> estados = new ArrayList<>(1);
            estados.add("Acompañamiento y Asistencia Técnica");
            Beneficiario beneficiario = beneficiarioDAO.getBeneficiarioPorId(idBeneficiario);
            Programacion programacion = programacionDAO.getProgramacion(idprogramacion);
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(idFuncionario);
            Emprendimiento emprendimiento = emprendimientoDAO
                    .getEmprendimientoPorBeneficiarioYFuncionario(
                            estados, beneficiario.getNumerodocumento(),
                            funcionario.getCajacompensacion()
                                    .getIdcajacompensacion());
            if (emprendimiento == null) {
                throw new CannotCreateException("El beneficiario no tiene un "
                        + "emprendimiento en estado Acompañamiento y Asistencia"
                        + " Técnica");
            }
            Sedes sede = sedesDAO.getSedesPorId(programacion.getIdInstitucion());
            Alumnos alumno = new Alumnos(null, beneficiario, new Funcionario(idFuncionario),
                    programacion, new Date(), null, null);
            response.setId(alumnosDAO.asociarBeneficiarioProgramacion(alumno));

            enviar.setNombres(beneficiario.getPrimerapellido() + " "
                    + (beneficiario.getSegundoapellido() != null ? beneficiario.getSegundoapellido() : ""));
            enviar.setApellidos(beneficiario.getPrimernombre() + " "
                    + (beneficiario.getSegundonombre() != null ? beneficiario.getSegundonombre() : ""));
            enviar.setTipoSesion(programacion.getCapacitacionprograma().getNombrecapacitacionprograma());
            enviar.setFechaInicio(programacion.getFechainicioprogramacion().toString());
            enviar.setFechaFin(programacion.getFechafinalrogramacion().toString());
            enviar.setUbicacionSesion(sede.getNombre() + " - " + programacion.getUbicacion());
            enviar.notificarGenerica(8, beneficiario.getEmail());
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_ASOCIANDO_ALUMNO);
            response.setAccion(Acciones.ASOCIAR_PROGRAMACION);
        } catch (CannotCreateException ex) {
            response.setDescripcion(ex.getMessage());
            log.writeToLogFile(ex);
            response.setStatus("0");
        } catch (Exception ex) {
            response.setDescripcion(Mensajes.ERROR_ASOCIANDO_ALUMNO);
            log.writeToLogFile(ex);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método encargado de ubicar un Alumno por su número de documento.
     *
     * @param tipo Tipo de documento de identificación.
     * @param numeroDocumento Número de documento de identificación.
     * @param idProgramacion Identificador de la Progamación.
     * @return Respuesta si fue exitosa o no la consulta, lista de Alumnos que
     * cumple con los criterios de búsqueda.
     */
    @Override
    public ResponseAlumnos getAlumnoPorDocumento(String tipo, String numeroDocumento,
            BigDecimal idProgramacion) {
        ResponseAlumnos response = new ResponseAlumnos();
        try {
            List<Alumnos> alumnos = alumnosDAO.getAlumnoPorDocumento(tipo, numeroDocumento, idProgramacion);
            if (alumnos.isEmpty()) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_ALUMNO_NO_EXISTE);
                return response;
            }
            response.setAlumnos(EntityToDTO.listAlumnosToListAlumnosDTO(alumnos));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_ALUMNOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGANDO_ALUMNOS);
            response.setStatus("0");
        }
        return response;
    }

}

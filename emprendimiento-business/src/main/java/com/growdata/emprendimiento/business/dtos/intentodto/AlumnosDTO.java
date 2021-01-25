/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Alumnos.
 *
 * @author Juan Franco
 */
public class AlumnosDTO {

    /**
     * Identificador.
     */
    private BigDecimal idalumno;
    /**
     * Datos del beneficiario.
     */
    private BeneficiarioDTO beneficiario;
    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionario;
    /**
     * Datos de la programación.
     */
    private ProgramacionDTO programacion;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Aprobaciones del alumno.
     */
    private Set<AprobacionDTO> aprobacions = new HashSet<AprobacionDTO>(0);
    /**
     * Asistencia del alumno.
     */
    private Set<SeguimientoasistenciaDTO> seguimientoasistencias
            = new HashSet<SeguimientoasistenciaDTO>(0);

    /**
     * Constructor.
     */
    public AlumnosDTO() {
    }

    /**
     * Constructor.
     *
     * @param idalumno Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param funcionario Datos del funcionario.
     * @param programacion Datos de la programación.
     * @param fecharegistro Fecha de registro.
     */
    public AlumnosDTO(BigDecimal idalumno, BeneficiarioDTO beneficiario,
            FuncionarioDTO funcionario, ProgramacionDTO programacion,
            Date fecharegistro) {
        this.idalumno = idalumno;
        this.beneficiario = beneficiario;
        this.funcionario = funcionario;
        this.programacion = programacion;
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdalumno() {
        return idalumno;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idalumno Valor a ser actualizado.
     */
    public void setIdalumno(BigDecimal idalumno) {
        this.idalumno = idalumno;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param beneficiario Valor a ser actualizado.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param funcionario Valor a ser actualizado.
     */
    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public ProgramacionDTO getProgramacion() {
        return programacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param programacion Valor a ser actualizado.
     */
    public void setProgramacion(ProgramacionDTO programacion) {
        this.programacion = programacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<AprobacionDTO> getAprobacions() {
        return aprobacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param aprobacions Valor a ser actualizado.
     */
    public void setAprobacions(Set<AprobacionDTO> aprobacions) {
        this.aprobacions = aprobacions;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SeguimientoasistenciaDTO> getSeguimientoasistencias() {
        return seguimientoasistencias;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param seguimientoasistencias Valor a ser actualizado.
     */
    public void setSeguimientoasistencias(
            Set<SeguimientoasistenciaDTO> seguimientoasistencias) {
        this.seguimientoasistencias = seguimientoasistencias;
    }

}

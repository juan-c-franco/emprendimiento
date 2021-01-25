/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase representante de la entidad Aprobaci�n.
 *
 * @author Juan Franco
 */
public class AprobacionDTO {

    /**
     * Identificador.
     */
    private BigDecimal idaprobacion;
    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionario;
    /**
     * Datos del alumno.
     */
    private AlumnosDTO alumnos;
    /**
     * Porcentaje de aprobaci�n.
     */
    private short porcentajeaprobacionobtenido;
    /**
     * Calificaci�n final obtenida.
     */
    private short calificacionfinal;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Calificaci�n del funcionario.
     */
    private short calificacionfuncionario;

    /**
     * Constructor.
     */
    public AprobacionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idaprobacion Identificador.
     * @param funcionario Datos del funcionario
     * @param alumnos Datos del alumno.
     * @param porcentajeaprobacionobtenido Porcentaje de aprobaci�n.
     * @param calificacionfinal Calificaci�n final.
     * @param calificacionfuncionario Calificaci�n del funcionario.
     * @param fecharegistro
     */
    public AprobacionDTO(BigDecimal idaprobacion, FuncionarioDTO funcionario,
            AlumnosDTO alumnos, short porcentajeaprobacionobtenido,
            short calificacionfinal, short calificacionfuncionario,
            Date fecharegistro) {
        this.idaprobacion = idaprobacion;
        this.funcionario = funcionario;
        this.alumnos = alumnos;
        this.porcentajeaprobacionobtenido = porcentajeaprobacionobtenido;
        this.calificacionfinal = calificacionfinal;
        this.fecharegistro = fecharegistro;
        this.calificacionfuncionario = calificacionfuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdaprobacion() {
        return idaprobacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idaprobacion Valor a ser actualizado.
     */
    public void setIdaprobacion(BigDecimal idaprobacion) {
        this.idaprobacion = idaprobacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param funcionario Valor a ser actualizado.
     */
    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public AlumnosDTO getAlumnos() {
        return alumnos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param alumnos Valor a ser actualizado.
     */
    public void setAlumnos(AlumnosDTO alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getPorcentajeaprobacionobtenido() {
        return porcentajeaprobacionobtenido;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param porcentajeaprobacionobtenido Valor a ser actualizado.
     */
    public void setPorcentajeaprobacionobtenido(
            short porcentajeaprobacionobtenido) {
        this.porcentajeaprobacionobtenido = porcentajeaprobacionobtenido;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getCalificacionfinal() {
        return calificacionfinal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacionfinal Valor a ser actualizado.
     */
    public void setCalificacionfinal(short calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getCalificacionfuncionario() {
        return calificacionfuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacionfuncionario Valor a ser actualizado.
     */
    public void setCalificacionfuncionario(short calificacionfuncionario) {
        this.calificacionfuncionario = calificacionfuncionario;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase representante de la entidad Aprobación.
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
     * Porcentaje de aprobación.
     */
    private short porcentajeaprobacionobtenido;
    /**
     * Calificación final obtenida.
     */
    private short calificacionfinal;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Calificación del funcionario.
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
     * @param porcentajeaprobacionobtenido Porcentaje de aprobación.
     * @param calificacionfinal Calificación final.
     * @param calificacionfuncionario Calificación del funcionario.
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
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdaprobacion() {
        return idaprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idaprobacion Valor a ser actualizado.
     */
    public void setIdaprobacion(BigDecimal idaprobacion) {
        this.idaprobacion = idaprobacion;
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
    public AlumnosDTO getAlumnos() {
        return alumnos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param alumnos Valor a ser actualizado.
     */
    public void setAlumnos(AlumnosDTO alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getPorcentajeaprobacionobtenido() {
        return porcentajeaprobacionobtenido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param porcentajeaprobacionobtenido Valor a ser actualizado.
     */
    public void setPorcentajeaprobacionobtenido(
            short porcentajeaprobacionobtenido) {
        this.porcentajeaprobacionobtenido = porcentajeaprobacionobtenido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getCalificacionfinal() {
        return calificacionfinal;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param calificacionfinal Valor a ser actualizado.
     */
    public void setCalificacionfinal(short calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
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
    public short getCalificacionfuncionario() {
        return calificacionfuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param calificacionfuncionario Valor a ser actualizado.
     */
    public void setCalificacionfuncionario(short calificacionfuncionario) {
        this.calificacionfuncionario = calificacionfuncionario;
    }

}

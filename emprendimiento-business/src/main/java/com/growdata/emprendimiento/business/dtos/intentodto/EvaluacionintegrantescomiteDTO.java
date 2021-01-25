package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase representante de la entidad Evaluacionintegrantescomite.
 *
 * @author Juan Franco
 */
public class EvaluacionintegrantescomiteDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idevaluacionintegrante;
    /**
     * Datos de la evaluaci�n.
     */
    private EvaluacionemprendimientoDTO evaluacionemprendimiento;
    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionario;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Calificaci�n individual del integrante comit�.
     */
    private BigDecimal calificacionindividual;
    /**
     * Observaciones.
     */
    private String observaciones;

    /**
     * Constructor.
     */
    public EvaluacionintegrantescomiteDTO() {
    }

    /**
     * Constructor.
     *
     * @param idevaluacionintegrante Identificador.
     * @param evaluacionemprendimiento Datos de la evaluaci�n.
     * @param funcionario Datos del funcionario.
     */
    public EvaluacionintegrantescomiteDTO(long idevaluacionintegrante,
            EvaluacionemprendimientoDTO evaluacionemprendimiento,
            FuncionarioDTO funcionario) {
        this.idevaluacionintegrante = idevaluacionintegrante;
        this.evaluacionemprendimiento = evaluacionemprendimiento;
        this.funcionario = funcionario;
    }

    /**
     * Constructor.
     *
     * @param idevaluacionintegrante Identificador.
     * @param evaluacionemprendimiento Datos de la evaluaci�n emprendimiento.
     * @param funcionario Datos del funcionario.
     * @param fecharegistro Fecha de registro.
     * @param calificacionindividual Calificaci�n individual del integrante.
     * @param observaciones Observaciones.
     */
    public EvaluacionintegrantescomiteDTO(long idevaluacionintegrante,
            EvaluacionemprendimientoDTO evaluacionemprendimiento,
            FuncionarioDTO funcionario, Date fecharegistro,
            BigDecimal calificacionindividual, String observaciones) {
        this.idevaluacionintegrante = idevaluacionintegrante;
        this.evaluacionemprendimiento = evaluacionemprendimiento;
        this.funcionario = funcionario;
        this.fecharegistro = fecharegistro;
        this.calificacionindividual = calificacionindividual;
        this.observaciones = observaciones;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdevaluacionintegrante() {
        return this.idevaluacionintegrante;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idevaluacionintegrante Valor a ser actualizado.
     */
    public void setIdevaluacionintegrante(long idevaluacionintegrante) {
        this.idevaluacionintegrante = idevaluacionintegrante;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EvaluacionemprendimientoDTO getEvaluacionemprendimiento() {
        return this.evaluacionemprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param evaluacionemprendimiento Valor a ser actualizado.
     */
    public void setEvaluacionemprendimiento(
            EvaluacionemprendimientoDTO evaluacionemprendimiento) {
        this.evaluacionemprendimiento = evaluacionemprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionario() {
        return this.funcionario;
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
    public Date getFecharegistro() {
        return this.fecharegistro;
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
    public BigDecimal getCalificacionindividual() {
        return this.calificacionindividual;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacionindividual Valor a ser actualizado.
     */
    public void setCalificacionindividual(BigDecimal calificacionindividual) {
        this.calificacionindividual = calificacionindividual;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param observaciones Valor a ser actualizado.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

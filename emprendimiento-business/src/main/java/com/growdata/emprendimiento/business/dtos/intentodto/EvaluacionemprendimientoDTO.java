package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Evaluacionemprendimiento.
 *
 * @author Juan Franco
 */
public class EvaluacionemprendimientoDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idevaluacion;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Prioridad.
     */
    private TipoprioridadDTO tipoprioridad;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Calificación final.
     */
    private BigDecimal calificacionfinal;
    /**
     * Aprobado o no.
     */
    private Character aprobado;
    /**
     * Observaciones.
     */
    private String observaciones;
    /**
     * Fecha de evaluación.
     */
    private Date fechaevaluacion;
    /**
     * Evaluación integrantes.
     */
    private Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites
            = new HashSet<EvaluacionintegrantescomiteDTO>(0);

    /**
     * Constructor.
     */
    public EvaluacionemprendimientoDTO() {
    }

    /**
     * Constructor.
     *
     * @param idevaluacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     * @param tipoprioridad Prioridad.
     */
    public EvaluacionemprendimientoDTO(long idevaluacion,
            EmprendimientoDTO emprendimiento, TipoprioridadDTO tipoprioridad) {
        this.idevaluacion = idevaluacion;
        this.emprendimiento = emprendimiento;
        this.tipoprioridad = tipoprioridad;
    }

    /**
     * Constructor.
     *
     * @param idevaluacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     * @param tipoprioridad Prioridad.
     * @param fecharegistro Fecha de registro.
     * @param calificacionfinal Calificación final.
     * @param aprobado Aprobado o no.
     * @param observaciones Observaciones.
     * @param fechaevaluacion Fecha de evaluación.
     * @param evaluacionintegrantescomites Evaluaciones integrantes comité.
     */
    public EvaluacionemprendimientoDTO(long idevaluacion,
            EmprendimientoDTO emprendimiento, TipoprioridadDTO tipoprioridad,
            Date fecharegistro, BigDecimal calificacionfinal,
            Character aprobado, String observaciones, Date fechaevaluacion,
            Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites) {
        this.idevaluacion = idevaluacion;
        this.emprendimiento = emprendimiento;
        this.tipoprioridad = tipoprioridad;
        this.fecharegistro = fecharegistro;
        this.calificacionfinal = calificacionfinal;
        this.aprobado = aprobado;
        this.observaciones = observaciones;
        this.fechaevaluacion = fechaevaluacion;
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdevaluacion() {
        return this.idevaluacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idevaluacion Valor a ser actualizado.
     */
    public void setIdevaluacion(long idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipoprioridadDTO getTipoprioridad() {
        return this.tipoprioridad;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoprioridad Valor a ser actualizado.
     */
    public void setTipoprioridad(TipoprioridadDTO tipoprioridad) {
        this.tipoprioridad = tipoprioridad;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return this.fecharegistro;
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
    public BigDecimal getCalificacionfinal() {
        return this.calificacionfinal;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param calificacionfinal Valor a ser actualizado.
     */
    public void setCalificacionfinal(BigDecimal calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getAprobado() {
        return this.aprobado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param aprobado Valor a ser actualizado.
     */
    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param observaciones Valor a ser actualizado.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechaevaluacion() {
        return this.fechaevaluacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechaevaluacion Valor a ser actualizado.
     */
    public void setFechaevaluacion(Date fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EvaluacionintegrantescomiteDTO>
            getEvaluacionintegrantescomites() {
        return this.evaluacionintegrantescomites;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param evaluacionintegrantescomites Valor a ser actualizado.
     */
    public void setEvaluacionintegrantescomites(
            Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites) {
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

}

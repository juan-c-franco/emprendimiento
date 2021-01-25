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
     * Calificaci�n final.
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
     * Fecha de evaluaci�n.
     */
    private Date fechaevaluacion;
    /**
     * Evaluaci�n integrantes.
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
     * @param calificacionfinal Calificaci�n final.
     * @param aprobado Aprobado o no.
     * @param observaciones Observaciones.
     * @param fechaevaluacion Fecha de evaluaci�n.
     * @param evaluacionintegrantescomites Evaluaciones integrantes comit�.
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
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdevaluacion() {
        return this.idevaluacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idevaluacion Valor a ser actualizado.
     */
    public void setIdevaluacion(long idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipoprioridadDTO getTipoprioridad() {
        return this.tipoprioridad;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipoprioridad Valor a ser actualizado.
     */
    public void setTipoprioridad(TipoprioridadDTO tipoprioridad) {
        this.tipoprioridad = tipoprioridad;
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
    public BigDecimal getCalificacionfinal() {
        return this.calificacionfinal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param calificacionfinal Valor a ser actualizado.
     */
    public void setCalificacionfinal(BigDecimal calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getAprobado() {
        return this.aprobado;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param aprobado Valor a ser actualizado.
     */
    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
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

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechaevaluacion() {
        return this.fechaevaluacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechaevaluacion Valor a ser actualizado.
     */
    public void setFechaevaluacion(Date fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EvaluacionintegrantescomiteDTO>
            getEvaluacionintegrantescomites() {
        return this.evaluacionintegrantescomites;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param evaluacionintegrantescomites Valor a ser actualizado.
     */
    public void setEvaluacionintegrantescomites(
            Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites) {
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

}

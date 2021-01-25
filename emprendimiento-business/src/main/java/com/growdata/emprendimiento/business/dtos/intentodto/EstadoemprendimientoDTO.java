package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Estadoemprendimiento.
 *
 * @author Juan Franco
 */
public class EstadoemprendimientoDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idestadoemprendimiento;
    /**
     * Nombre del estado.
     */
    private String nombreestadoemprendimiento;
    /**
     * Descripción.
     */
    private String descripcion;
    /**
     * Emprendimientos.
     */
    private Set<EmprendimientoDTO> emprendimientos = new HashSet<EmprendimientoDTO>(0);
    /**
     * Registros los estado emprendimiento.
     */
    private Set<LogestadoemprendimientoDTO> logestadoemprendimientos = new HashSet<LogestadoemprendimientoDTO>(0);

    /**
     * Constructor.
     */
    public EstadoemprendimientoDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadoemprendimiento Identificador.
     */
    public EstadoemprendimientoDTO(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    /**
     * Constructor.
     *
     * @param idestadoemprendimiento Identificador.
     * @param nombreestadoemprendimiento Nombre del estado.
     * @param descripcion Descripción.
     * @param emprendimientos Emprendimientos.
     * @param logestadoemprendimientos Log de estados emprendimiento.
     */
    public EstadoemprendimientoDTO(BigDecimal idestadoemprendimiento, String nombreestadoemprendimiento, String descripcion, Set<EmprendimientoDTO> emprendimientos, Set<LogestadoemprendimientoDTO> logestadoemprendimientos) {
        this.idestadoemprendimiento = idestadoemprendimiento;
        this.nombreestadoemprendimiento = nombreestadoemprendimiento;
        this.descripcion = descripcion;
        this.emprendimientos = emprendimientos;
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadoemprendimiento() {
        return this.idestadoemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idestadoemprendimiento Valor a ser actualizado.
     */
    public void setIdestadoemprendimiento(BigDecimal idestadoemprendimiento) {
        this.idestadoemprendimiento = idestadoemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadoemprendimiento() {
        return this.nombreestadoemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreestadoemprendimiento Valor a ser actualizado.
     */
    public void setNombreestadoemprendimiento(
            String nombreestadoemprendimiento) {
        this.nombreestadoemprendimiento = nombreestadoemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EmprendimientoDTO> getEmprendimientos() {
        return this.emprendimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimientos Valor a ser actualizado.
     */
    public void setEmprendimientos(Set<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<LogestadoemprendimientoDTO> getLogestadoemprendimientos() {
        return this.logestadoemprendimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param logestadoemprendimientos Valor a ser actualizado.
     */
    public void setLogestadoemprendimientos(
            Set<LogestadoemprendimientoDTO> logestadoemprendimientos) {
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

}

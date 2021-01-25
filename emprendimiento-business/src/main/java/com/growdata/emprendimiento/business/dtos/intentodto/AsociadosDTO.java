package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Clase representante de la entidad Asociados.
 *
 * @author Juan Franco
 */
public class AsociadosDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idasociado;
    /**
     * Datos del beneficiario.
     */
    private BeneficiarioDTO beneficiario;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Indica si es lider o no de emprendimiento.
     */
    private Character lider;

    /**
     * Constructor.
     */
    public AsociadosDTO() {
    }

    /**
     * Constructor.
     *
     * @param idasociado Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param emprendimiento Datos del emprendimiento.
     */
    public AsociadosDTO(long idasociado, BeneficiarioDTO beneficiario,
            EmprendimientoDTO emprendimiento) {
        this.idasociado = idasociado;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
    }

    /**
     * Constructor.
     *
     * @param idasociado Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param emprendimiento Datos del emprendimiento.
     * @param fecharegistro Fecha de registro.
     * @param lider Es lider de emprendimiento?
     */
    public AsociadosDTO(long idasociado, BeneficiarioDTO beneficiario,
            EmprendimientoDTO emprendimiento, Date fecharegistro,
            Character lider) {
        this.idasociado = idasociado;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.fecharegistro = fecharegistro;
        this.lider = lider;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdasociado() {
        return this.idasociado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idasociado Valor a ser actualizado.
     */
    public void setIdasociado(long idasociado) {
        this.idasociado = idasociado;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
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
    public Character getLider() {
        return lider;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param lider Valor a ser actualizado.
     */
    public void setLider(Character lider) {
        this.lider = lider;
    }

}

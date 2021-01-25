package com.growdata.emprendimiento.business.dtos.evaluacion;

import java.math.BigDecimal;

/**
 * Clase solicitud registrar información financiera básica.
 *
 * @author Juan Franco
 */
public class RequestRegistrarInfoFinancieraBasica {

    /**
     * Identificador del emprendimiento.
     */
    private long idEmprendimiento;
    /**
     * Identificador del funcionario.
     */
    private long idFuncionario;
    /**
     * Identificador tipo de financiación.
     */
    private BigDecimal idtipofinanciacion;
    /**
     * Monto financiación.
     */
    private long montofinanciacions;
    /**
     * Cuotas pactadas.
     */
    private BigDecimal cuotaspactadasS;
    /**
     * Tasa de interés.
     */
    private BigDecimal tasaintertess;
    /**
     * Cantidad de recursos propios.
     */
    private long recursospropiosae;
    /**
     * Cantidad de empleos por generar.
     */
    private BigDecimal empleosporgenerar;
    /**
     * Cantidad de empleos generados.
     */
    private BigDecimal empleosgenerados;
    /**
     * Capital total.
     */
    private long capitaltotal;
    /**
     * Capital de trabajo.
     */
    private long capitaltrabajo;
    /**
     * Cantidad de meses para punto de equilibrio.
     */
    private BigDecimal mesespuntoequilibrio;
    /**
     * Emprendimiento aprobado para financiación.
     */
    private String aprobado;

    /**
     * Constructor.
     */
    public RequestRegistrarInfoFinancieraBasica() {
    }

    /**
     * Constructor.
     *
     * @param idEmprendimiento Identificador de emprendimiento.
     * @param idFuncionario Identificador del funcionario.
     * @param idtipofinanciacion Identificador tipo de financiación.
     * @param montofinanciacions Monto a financiar.
     * @param cuotaspactadasS Cantidad de cuotas pactadas.
     * @param tasaintertess Tasad de interés.
     * @param recursospropiosae Cantidad de recursos propios.
     * @param empleosporgenerar Cantidad empleos por generar.
     * @param empleosgenerados Cantidad empleos generados.
     * @param capitaltotal Capital total.
     * @param capitaltrabajo Capital de trabajo.
     * @param mesespuntoequilibrio Meses para punto de equilibrio.
     * @param aprobado Aprobado para financiación.
     */
    public RequestRegistrarInfoFinancieraBasica(long idEmprendimiento,
            long idFuncionario, BigDecimal idtipofinanciacion,
            long montofinanciacions, BigDecimal cuotaspactadasS,
            BigDecimal tasaintertess, long recursospropiosae,
            BigDecimal empleosporgenerar, BigDecimal empleosgenerados,
            long capitaltotal, long capitaltrabajo,
            BigDecimal mesespuntoequilibrio, String aprobado) {
        this.idEmprendimiento = idEmprendimiento;
        this.idFuncionario = idFuncionario;
        this.idtipofinanciacion = idtipofinanciacion;
        this.montofinanciacions = montofinanciacions;
        this.cuotaspactadasS = cuotaspactadasS;
        this.tasaintertess = tasaintertess;
        this.recursospropiosae = recursospropiosae;
        this.empleosporgenerar = empleosporgenerar;
        this.empleosgenerados = empleosgenerados;
        this.capitaltotal = capitaltotal;
        this.capitaltrabajo = capitaltrabajo;
        this.mesespuntoequilibrio = mesespuntoequilibrio;
        this.aprobado = aprobado;
    }

    public String getAprobado() {
        return aprobado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param aprobado Valor a ser actualizado.
     */
    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idEmprendimiento Valor a ser actualizado.
     */
    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idFuncionario Valor a ser actualizado.
     */
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public BigDecimal getIdtipofinanciacion() {
        return idtipofinanciacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idtipofinanciacion Valor a ser actualizado.
     */
    public void setIdtipofinanciacion(BigDecimal idtipofinanciacion) {
        this.idtipofinanciacion = idtipofinanciacion;
    }

    public long getMontofinanciacions() {
        return montofinanciacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param montofinanciacions Valor a ser actualizado.
     */
    public void setMontofinanciacions(long montofinanciacions) {
        this.montofinanciacions = montofinanciacions;
    }

    public BigDecimal getCuotaspactadasS() {
        return cuotaspactadasS;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cuotaspactadasS Valor a ser actualizado.
     */
    public void setCuotaspactadasS(BigDecimal cuotaspactadasS) {
        this.cuotaspactadasS = cuotaspactadasS;
    }

    public BigDecimal getTasaintertess() {
        return tasaintertess;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tasaintertess Valor a ser actualizado.
     */
    public void setTasaintertess(BigDecimal tasaintertess) {
        this.tasaintertess = tasaintertess;
    }

    public long getRecursospropiosae() {
        return recursospropiosae;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param recursospropiosae Valor a ser actualizado.
     */
    public void setRecursospropiosae(long recursospropiosae) {
        this.recursospropiosae = recursospropiosae;
    }

    public BigDecimal getEmpleosporgenerar() {
        return empleosporgenerar;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param empleosporgenerar Valor a ser actualizado.
     */
    public void setEmpleosporgenerar(BigDecimal empleosporgenerar) {
        this.empleosporgenerar = empleosporgenerar;
    }

    public long getCapitaltotal() {
        return capitaltotal;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param capitaltotal Valor a ser actualizado.
     */
    public void setCapitaltotal(long capitaltotal) {
        this.capitaltotal = capitaltotal;
    }

    public long getCapitaltrabajo() {
        return capitaltrabajo;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param capitaltrabajo Valor a ser actualizado.
     */
    public void setCapitaltrabajo(long capitaltrabajo) {
        this.capitaltrabajo = capitaltrabajo;
    }

    public BigDecimal getMesespuntoequilibrio() {
        return mesespuntoequilibrio;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param mesespuntoequilibrio Valor a ser actualizado.
     */
    public void setMesespuntoequilibrio(BigDecimal mesespuntoequilibrio) {
        this.mesespuntoequilibrio = mesespuntoequilibrio;
    }

    public BigDecimal getEmpleosgenerados() {
        return empleosgenerados;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param empleosgenerados Valor a ser actualizado.
     */
    public void setEmpleosgenerados(BigDecimal empleosgenerados) {
        this.empleosgenerados = empleosgenerados;
    }
}

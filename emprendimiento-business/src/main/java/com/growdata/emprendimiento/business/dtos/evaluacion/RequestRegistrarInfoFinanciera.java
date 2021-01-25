package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.dtos.intentodto.ConfiguracionDTO;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Tipofinanciacion;
import java.math.BigDecimal;

/**
 * Clase solicitud registro información financiera.
 *
 * @author Juan Franco
 */
public class RequestRegistrarInfoFinanciera {

    /**
     * Monto aprobado.
     */
    private Long montoa;
    /**
     * Tasa de interés.
     */
    private BigDecimal tasainteresa;
    /**
     * Cuotas pactadas.
     */
    private BigDecimal cuotaspactadasa;
    /**
     * Tipo de financiación.
     */
    private Tipofinanciacion tipofinanciacionByIdtipofinanciaciona;
    /**
     * Entidad financiera.
     */
    private Entidadesfinancieras entidadesfinancieras;
    /**
     * Identificador de la financiación.
     */
    private long idfinanciacion;
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
     * Monto a financiar.
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
     * Empleos por generar.
     */
    private BigDecimal empleosporgenerar;
    /**
     * Capital total.
     */
    private long capitaltotal;
    /**
     * Capital de trabajo.
     */
    private long capitaltrabajo;
    /**
     * Meses estimados para punto de equilibrio.
     */
    private BigDecimal mesespuntoequilibrio;
    /**
     * Configuración.
     */
    private ConfiguracionDTO configuracion;

    public ConfiguracionDTO getConfiguracion() {
        return configuracion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param configuracion Valor a ser actualizado.
     */
    public void setConfiguracion(ConfiguracionDTO configuracion) {
        this.configuracion = configuracion;
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

    public long getIdfinanciacion() {
        return idfinanciacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idfinanciacion Valor a ser actualizado.
     */
    public void setIdfinanciacion(long idfinanciacion) {
        this.idfinanciacion = idfinanciacion;
    }

    public Long getMontoa() {
        return montoa;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param montoa Valor a ser actualizado.
     */
    public void setMontoa(Long montoa) {
        this.montoa = montoa;
    }

    public BigDecimal getTasainteresa() {
        return tasainteresa;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tasainteresa Valor a ser actualizado.
     */
    public void setTasainteresa(BigDecimal tasainteresa) {
        this.tasainteresa = tasainteresa;
    }

    public BigDecimal getCuotaspactadasa() {
        return cuotaspactadasa;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cuotaspactadasa Valor a ser actualizado.
     */
    public void setCuotaspactadasa(BigDecimal cuotaspactadasa) {
        this.cuotaspactadasa = cuotaspactadasa;
    }

    public Tipofinanciacion getTipofinanciacionByIdtipofinanciaciona() {
        return tipofinanciacionByIdtipofinanciaciona;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipofinanciacionByIdtipofinanciaciona Valor a ser actualizado.
     */
    public void setTipofinanciacionByIdtipofinanciaciona(
            Tipofinanciacion tipofinanciacionByIdtipofinanciaciona) {
        this.tipofinanciacionByIdtipofinanciaciona
                = tipofinanciacionByIdtipofinanciaciona;
    }

    public Entidadesfinancieras getEntidadesfinancieras() {
        return entidadesfinancieras;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param entidadesfinancieras Valor a ser actualizado.
     */
    public void setEntidadesfinancieras(
            Entidadesfinancieras entidadesfinancieras) {
        this.entidadesfinancieras = entidadesfinancieras;
    }

}

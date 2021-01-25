package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase representante de la entidad financiaci�n.
 *
 * @author Juan Franco
 */
public class FinanciacionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idfinanciacion;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Entidad financiera.
     */
    private EntidadesfinancierasDTO entidadesfinancieras;
    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionario;
    /**
     * Tipo financiaci�n solicitada.
     */
    private TipofinanciacionDTO tipofinanciacionByIdtipofinanciacions;
    /**
     * Tipo financiaci�n aprobada.
     */
    private TipofinanciacionDTO tipofinanciacionByIdtipofinanciaciona;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Monto financiaci�n solicitada.
     */
    private Long montofinanciacions;
    /**
     * Cuotas solicitadas.
     */
    private BigDecimal cuotaspactadass;
    /**
     * Tasa de inter� solicitada.
     */
    private BigDecimal tasaintertess;
    /**
     * Monto recursos propios.
     */
    private Long recursospropiosae;
    /**
     * Cantidad de empleos generados.
     */
    private BigDecimal empleosgenerados;
    /**
     * Cantidad de empleos por generar.
     */
    private BigDecimal empleosporgenerar;
    /**
     * Capital total.
     */
    private Long capitaltotal;
    /**
     * Capital de trabajo.
     */
    private Long capitaltrabajo;
    /**
     * Meses para punto de equilibrio.
     */
    private BigDecimal mesespuntoequilibrio;
    /**
     * Monto aprobado.
     */
    private Long montoa;
    /**
     * Tasa de intereses aprobados.
     */
    private BigDecimal tasainteresa;
    /**
     * Cuotas pactadas aprobadas.
     */
    private BigDecimal cuotaspactadasa;

    /**
     * Constructor.
     */
    public FinanciacionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idfinanciacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     * @param entidadesfinancieras Entidad financiera.
     * @param funcionario Datos del funcionario.
     * @param tipofinanciacionByIdtipofinanciacions Tipo financiaci�n
     * solicitada.
     * @param tipofinanciacionByIdtipofinanciaciona Tipo financiaci�n aprobada.
     */
    public FinanciacionDTO(long idfinanciacion,
            EmprendimientoDTO emprendimiento,
            EntidadesfinancierasDTO entidadesfinancieras,
            FuncionarioDTO funcionario,
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciacions,
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciaciona) {
        this.idfinanciacion = idfinanciacion;
        this.emprendimiento = emprendimiento;
        this.entidadesfinancieras = entidadesfinancieras;
        this.funcionario = funcionario;
        this.tipofinanciacionByIdtipofinanciacions
                = tipofinanciacionByIdtipofinanciacions;
        this.tipofinanciacionByIdtipofinanciaciona
                = tipofinanciacionByIdtipofinanciaciona;
    }

    /**
     * Constructor.
     *
     * @param idfinanciacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     * @param entidadesfinancieras Entidad financiera.
     * @param funcionario Datos del funcionario.
     * @param tipofinanciacionByIdtipofinanciacions Tipo de financiaci�n
     * solicitada.
     * @param tipofinanciacionByIdtipofinanciaciona Tipo de financiaci�n
     * aprobada.
     * @param fecharegistro Fecha de registro.
     * @param montofinanciacions Monto a financiar solicitado.
     * @param cuotaspactadass Cuotas pactadas solicitado.
     * @param tasaintertess Tasa de inter�s solicitado.
     * @param recursospropiosae Monto de recursos propios.
     * @param empleosgenerados Cantidad de empleos generados.
     * @param empleosporgenerar Cantidad de empleos por generar.
     * @param capitaltotal Capital total.
     * @param capitaltrabajo Capital de trabajo.
     * @param mesespuntoequilibrio Meses estimados para punto de equilibrio.
     * @param montoa Monto aprobado.
     * @param tasainteresa Tasa de inter�s aprobada.
     * @param cuotaspactadasa Cuotas pactadas aprobadas.
     */
    public FinanciacionDTO(long idfinanciacion,
            EmprendimientoDTO emprendimiento,
            EntidadesfinancierasDTO entidadesfinancieras,
            FuncionarioDTO funcionario,
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciacions,
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciaciona,
            Date fecharegistro, Long montofinanciacions,
            BigDecimal cuotaspactadass, BigDecimal tasaintertess,
            Long recursospropiosae, BigDecimal empleosgenerados,
            BigDecimal empleosporgenerar, Long capitaltotal,
            Long capitaltrabajo, BigDecimal mesespuntoequilibrio,
            Long montoa, BigDecimal tasainteresa, BigDecimal cuotaspactadasa) {
        this.idfinanciacion = idfinanciacion;
        this.emprendimiento = emprendimiento;
        this.entidadesfinancieras = entidadesfinancieras;
        this.funcionario = funcionario;
        this.tipofinanciacionByIdtipofinanciacions
                = tipofinanciacionByIdtipofinanciacions;
        this.tipofinanciacionByIdtipofinanciaciona
                = tipofinanciacionByIdtipofinanciaciona;
        this.fecharegistro = fecharegistro;
        this.montofinanciacions = montofinanciacions;
        this.cuotaspactadass = cuotaspactadass;
        this.tasaintertess = tasaintertess;
        this.recursospropiosae = recursospropiosae;
        this.empleosgenerados = empleosgenerados;
        this.empleosporgenerar = empleosporgenerar;
        this.capitaltotal = capitaltotal;
        this.capitaltrabajo = capitaltrabajo;
        this.mesespuntoequilibrio = mesespuntoequilibrio;
        this.montoa = montoa;
        this.tasainteresa = tasainteresa;
        this.cuotaspactadasa = cuotaspactadasa;
    }

    public long getIdfinanciacion() {
        return this.idfinanciacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idfinanciacion Valor a ser actualizado.
     */
    public void setIdfinanciacion(long idfinanciacion) {
        this.idfinanciacion = idfinanciacion;
    }

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

    public EntidadesfinancierasDTO getEntidadesfinancieras() {
        return this.entidadesfinancieras;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param entidadesfinancieras Valor a ser actualizado.
     */
    public void setEntidadesfinancieras(
            EntidadesfinancierasDTO entidadesfinancieras) {
        this.entidadesfinancieras = entidadesfinancieras;
    }

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

    public TipofinanciacionDTO getTipofinanciacionByIdtipofinanciacions() {
        return this.tipofinanciacionByIdtipofinanciacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipofinanciacionByIdtipofinanciacions Valor a ser actualizado.
     */
    public void setTipofinanciacionByIdtipofinanciacions(
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciacions) {
        this.tipofinanciacionByIdtipofinanciacions
                = tipofinanciacionByIdtipofinanciacions;
    }

    public TipofinanciacionDTO getTipofinanciacionByIdtipofinanciaciona() {
        return this.tipofinanciacionByIdtipofinanciaciona;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipofinanciacionByIdtipofinanciaciona Valor a ser actualizado.
     */
    public void setTipofinanciacionByIdtipofinanciaciona(
            TipofinanciacionDTO tipofinanciacionByIdtipofinanciaciona) {
        this.tipofinanciacionByIdtipofinanciaciona
                = tipofinanciacionByIdtipofinanciaciona;
    }

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

    public Long getMontofinanciacions() {
        return this.montofinanciacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param montofinanciacions Valor a ser actualizado.
     */
    public void setMontofinanciacions(Long montofinanciacions) {
        this.montofinanciacions = montofinanciacions;
    }

    public BigDecimal getCuotaspactadass() {
        return this.cuotaspactadass;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param cuotaspactadass Valor a ser actualizado.
     */
    public void setCuotaspactadass(BigDecimal cuotaspactadass) {
        this.cuotaspactadass = cuotaspactadass;
    }

    public BigDecimal getTasaintertess() {
        return this.tasaintertess;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tasaintertess Valor a ser actualizado.
     */
    public void setTasaintertess(BigDecimal tasaintertess) {
        this.tasaintertess = tasaintertess;
    }

    public Long getRecursospropiosae() {
        return this.recursospropiosae;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param recursospropiosae Valor a ser actualizado.
     */
    public void setRecursospropiosae(Long recursospropiosae) {
        this.recursospropiosae = recursospropiosae;
    }

    public BigDecimal getEmpleosgenerados() {
        return this.empleosgenerados;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param empleosgenerados Valor a ser actualizado.
     */
    public void setEmpleosgenerados(BigDecimal empleosgenerados) {
        this.empleosgenerados = empleosgenerados;
    }

    public BigDecimal getEmpleosporgenerar() {
        return this.empleosporgenerar;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param empleosporgenerar Valor a ser actualizado.
     */
    public void setEmpleosporgenerar(BigDecimal empleosporgenerar) {
        this.empleosporgenerar = empleosporgenerar;
    }

    public Long getCapitaltotal() {
        return this.capitaltotal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param capitaltotal Valor a ser actualizado.
     */
    public void setCapitaltotal(Long capitaltotal) {
        this.capitaltotal = capitaltotal;
    }

    public Long getCapitaltrabajo() {
        return this.capitaltrabajo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param capitaltrabajo Valor a ser actualizado.
     */
    public void setCapitaltrabajo(Long capitaltrabajo) {
        this.capitaltrabajo = capitaltrabajo;
    }

    public BigDecimal getMesespuntoequilibrio() {
        return this.mesespuntoequilibrio;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param mesespuntoequilibrio Valor a ser actualizado.
     */
    public void setMesespuntoequilibrio(BigDecimal mesespuntoequilibrio) {
        this.mesespuntoequilibrio = mesespuntoequilibrio;
    }

    public Long getMontoa() {
        return this.montoa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param montoa Valor a ser actualizado.
     */
    public void setMontoa(Long montoa) {
        this.montoa = montoa;
    }

    public BigDecimal getTasainteresa() {
        return this.tasainteresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tasainteresa Valor a ser actualizado.
     */
    public void setTasainteresa(BigDecimal tasainteresa) {
        this.tasainteresa = tasainteresa;
    }

    public BigDecimal getCuotaspactadasa() {
        return this.cuotaspactadasa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param cuotaspactadasa Valor a ser actualizado.
     */
    public void setCuotaspactadasa(BigDecimal cuotaspactadasa) {
        this.cuotaspactadasa = cuotaspactadasa;
    }

}

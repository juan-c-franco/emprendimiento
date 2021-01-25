package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase representante de la entidad financiación.
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
     * Tipo financiación solicitada.
     */
    private TipofinanciacionDTO tipofinanciacionByIdtipofinanciacions;
    /**
     * Tipo financiación aprobada.
     */
    private TipofinanciacionDTO tipofinanciacionByIdtipofinanciaciona;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Monto financiación solicitada.
     */
    private Long montofinanciacions;
    /**
     * Cuotas solicitadas.
     */
    private BigDecimal cuotaspactadass;
    /**
     * Tasa de interé solicitada.
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
     * @param tipofinanciacionByIdtipofinanciacions Tipo financiación
     * solicitada.
     * @param tipofinanciacionByIdtipofinanciaciona Tipo financiación aprobada.
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
     * @param tipofinanciacionByIdtipofinanciacions Tipo de financiación
     * solicitada.
     * @param tipofinanciacionByIdtipofinanciaciona Tipo de financiación
     * aprobada.
     * @param fecharegistro Fecha de registro.
     * @param montofinanciacions Monto a financiar solicitado.
     * @param cuotaspactadass Cuotas pactadas solicitado.
     * @param tasaintertess Tasa de interés solicitado.
     * @param recursospropiosae Monto de recursos propios.
     * @param empleosgenerados Cantidad de empleos generados.
     * @param empleosporgenerar Cantidad de empleos por generar.
     * @param capitaltotal Capital total.
     * @param capitaltrabajo Capital de trabajo.
     * @param mesespuntoequilibrio Meses estimados para punto de equilibrio.
     * @param montoa Monto aprobado.
     * @param tasainteresa Tasa de interés aprobada.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
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
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cuotaspactadasa Valor a ser actualizado.
     */
    public void setCuotaspactadasa(BigDecimal cuotaspactadasa) {
        this.cuotaspactadasa = cuotaspactadasa;
    }

}

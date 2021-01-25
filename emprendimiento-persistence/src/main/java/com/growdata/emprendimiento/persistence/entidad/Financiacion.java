package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class Financiacion implements java.io.Serializable {

    private long idfinanciacion;
    private Emprendimiento emprendimiento;
    private Entidadesfinancieras entidadesfinancieras;
    private Funcionario funcionario;
    private Tipofinanciacion tipofinanciacionByIdtipofinanciacions;
    private Tipofinanciacion tipofinanciacionByIdtipofinanciaciona;
    private Date fecharegistro;
    private Long montofinanciacions;
    private BigDecimal cuotaspactadass;
    private BigDecimal tasaintertess;
    private Long recursospropiosae;
    private BigDecimal empleosgenerados;
    private BigDecimal empleosporgenerar;
    private Long capitaltotal;
    private Long capitaltrabajo;
    private BigDecimal mesespuntoequilibrio;
    private Long montoa;
    private BigDecimal tasainteresa;
    private BigDecimal cuotaspactadasa;

    public Financiacion() {
    }

    public Financiacion(long idfinanciacion, Emprendimiento emprendimiento, Entidadesfinancieras entidadesfinancieras, Funcionario funcionario, Tipofinanciacion tipofinanciacionByIdtipofinanciacions, Tipofinanciacion tipofinanciacionByIdtipofinanciaciona) {
        this.idfinanciacion = idfinanciacion;
        this.emprendimiento = emprendimiento;
        this.entidadesfinancieras = entidadesfinancieras;
        this.funcionario = funcionario;
        this.tipofinanciacionByIdtipofinanciacions = tipofinanciacionByIdtipofinanciacions;
        this.tipofinanciacionByIdtipofinanciaciona = tipofinanciacionByIdtipofinanciaciona;
    }

    public Financiacion(long idfinanciacion, Emprendimiento emprendimiento, Entidadesfinancieras entidadesfinancieras, Funcionario funcionario, Tipofinanciacion tipofinanciacionByIdtipofinanciacions, Tipofinanciacion tipofinanciacionByIdtipofinanciaciona, Date fecharegistro, Long montofinanciacions, BigDecimal cuotaspactadass, BigDecimal tasaintertess, Long recursospropiosae, BigDecimal empleosgenerados, BigDecimal empleosporgenerar, Long capitaltotal, Long capitaltrabajo, BigDecimal mesespuntoequilibrio, Long montoa, BigDecimal tasainteresa, BigDecimal cuotaspactadasa) {
        this.idfinanciacion = idfinanciacion;
        this.emprendimiento = emprendimiento;
        this.entidadesfinancieras = entidadesfinancieras;
        this.funcionario = funcionario;
        this.tipofinanciacionByIdtipofinanciacions = tipofinanciacionByIdtipofinanciacions;
        this.tipofinanciacionByIdtipofinanciaciona = tipofinanciacionByIdtipofinanciaciona;
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

    public void setIdfinanciacion(long idfinanciacion) {
        this.idfinanciacion = idfinanciacion;
    }

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Entidadesfinancieras getEntidadesfinancieras() {
        return this.entidadesfinancieras;
    }

    public void setEntidadesfinancieras(Entidadesfinancieras entidadesfinancieras) {
        this.entidadesfinancieras = entidadesfinancieras;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Tipofinanciacion getTipofinanciacionByIdtipofinanciacions() {
        return this.tipofinanciacionByIdtipofinanciacions;
    }

    public void setTipofinanciacionByIdtipofinanciacions(Tipofinanciacion tipofinanciacionByIdtipofinanciacions) {
        this.tipofinanciacionByIdtipofinanciacions = tipofinanciacionByIdtipofinanciacions;
    }

    public Tipofinanciacion getTipofinanciacionByIdtipofinanciaciona() {
        return this.tipofinanciacionByIdtipofinanciaciona;
    }

    public void setTipofinanciacionByIdtipofinanciaciona(Tipofinanciacion tipofinanciacionByIdtipofinanciaciona) {
        this.tipofinanciacionByIdtipofinanciaciona = tipofinanciacionByIdtipofinanciaciona;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Long getMontofinanciacions() {
        return this.montofinanciacions;
    }

    public void setMontofinanciacions(Long montofinanciacions) {
        this.montofinanciacions = montofinanciacions;
    }

    public BigDecimal getCuotaspactadass() {
        return this.cuotaspactadass;
    }

    public void setCuotaspactadass(BigDecimal cuotaspactadass) {
        this.cuotaspactadass = cuotaspactadass;
    }

    public BigDecimal getTasaintertess() {
        return this.tasaintertess;
    }

    public void setTasaintertess(BigDecimal tasaintertess) {
        this.tasaintertess = tasaintertess;
    }

    public Long getRecursospropiosae() {
        return this.recursospropiosae;
    }

    public void setRecursospropiosae(Long recursospropiosae) {
        this.recursospropiosae = recursospropiosae;
    }

    public BigDecimal getEmpleosgenerados() {
        return this.empleosgenerados;
    }

    public void setEmpleosgenerados(BigDecimal empleosgenerados) {
        this.empleosgenerados = empleosgenerados;
    }

    public BigDecimal getEmpleosporgenerar() {
        return this.empleosporgenerar;
    }

    public void setEmpleosporgenerar(BigDecimal empleosporgenerar) {
        this.empleosporgenerar = empleosporgenerar;
    }

    public Long getCapitaltotal() {
        return this.capitaltotal;
    }

    public void setCapitaltotal(Long capitaltotal) {
        this.capitaltotal = capitaltotal;
    }

    public Long getCapitaltrabajo() {
        return this.capitaltrabajo;
    }

    public void setCapitaltrabajo(Long capitaltrabajo) {
        this.capitaltrabajo = capitaltrabajo;
    }

    public BigDecimal getMesespuntoequilibrio() {
        return this.mesespuntoequilibrio;
    }

    public void setMesespuntoequilibrio(BigDecimal mesespuntoequilibrio) {
        this.mesespuntoequilibrio = mesespuntoequilibrio;
    }

    public Long getMontoa() {
        return this.montoa;
    }

    public void setMontoa(Long montoa) {
        this.montoa = montoa;
    }

    public BigDecimal getTasainteresa() {
        return this.tasainteresa;
    }

    public void setTasainteresa(BigDecimal tasainteresa) {
        this.tasainteresa = tasainteresa;
    }

    public BigDecimal getCuotaspactadasa() {
        return this.cuotaspactadasa;
    }

    public void setCuotaspactadasa(BigDecimal cuotaspactadasa) {
        this.cuotaspactadasa = cuotaspactadasa;
    }

}

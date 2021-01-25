package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RequestNoEstablecido {

    private Long idFuncionario;
    private BigDecimal idNoEstablecido;
    private Long idEmprendimiento;
    private BigDecimal idcajacompensacion;
    private String nombreEmprendimiento;
    private BigDecimal tEmprendimiento;
    private String formalizado;
    private BigDecimal constitucion;
    private BigDecimal sector;
    private List<String> beneficiarios;
    private String prodServ;
    private Date cuandoInicia;
    private String observaciones;
    private boolean finalizado;
    private String observacionesS;
    private int requierePlan;

    public RequestNoEstablecido() {
    }

    public RequestNoEstablecido(Long idFuncionario, BigDecimal idcajacompensacion, String nombreEmprendimiento, BigDecimal tEmprendimiento, BigDecimal constitucion, BigDecimal sector, List<String> beneficiarios, String prodServ, Date cuandoInicia, String observaciones) {
        this.idFuncionario = idFuncionario;
        this.idcajacompensacion = idcajacompensacion;
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.tEmprendimiento = tEmprendimiento;
        this.constitucion = constitucion;
        this.sector = sector;
        this.beneficiarios = beneficiarios;
        this.prodServ = prodServ;
        this.cuandoInicia = cuandoInicia;
        this.observaciones = observaciones;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public BigDecimal gettEmprendimiento() {
        return tEmprendimiento;
    }

    public void settEmprendimiento(BigDecimal tEmprendimiento) {
        this.tEmprendimiento = tEmprendimiento;
    }

    public BigDecimal getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(BigDecimal constitucion) {
        this.constitucion = constitucion;
    }

    public BigDecimal getSector() {
        return sector;
    }

    public void setSector(BigDecimal sector) {
        this.sector = sector;
    }

    public List<String> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<String> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public String getProdServ() {
        return prodServ;
    }

    public void setProdServ(String prodServ) {
        this.prodServ = prodServ;
    }

    public Date getCuandoInicia() {
        return cuandoInicia;
    }

    public void setCuandoInicia(Date cuandoInicia) {
        this.cuandoInicia = cuandoInicia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    private boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkNullsEmprendimiento() {

        if (this.beneficiarios == null || this.beneficiarios.size() == 0
                || isNullOrEmpty(this.nombreEmprendimiento) || this.tEmprendimiento == null) {
            return false;
        }

        return true;
    }

    public boolean checkNullsNoEstablecido() {

        if (this.constitucion == null
                || this.idFuncionario == null || this.idcajacompensacion == null
                || isNullOrEmpty(this.prodServ) || this.sector == null
                || this.observaciones == null || this.cuandoInicia == null) {
            return false;
        }

        return true;
    }

    public BigDecimal getIdNoEstablecido() {
        return idNoEstablecido;
    }

    public void setIdNoEstablecido(BigDecimal idNoEstablecido) {
        this.idNoEstablecido = idNoEstablecido;
    }

    public String getFormalizado() {
        return formalizado;
    }

    public void setFormalizado(String formalizado) {
        this.formalizado = formalizado;
    }

    public Long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(Long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getObservacionesS() {
        return observacionesS;
    }

    public void setObservacionesS(String observacionesS) {
        this.observacionesS = observacionesS;
    }

    public int getRequierePlan() {
        return requierePlan;
    }

    public void setRequierePlan(int requierePlan) {
        this.requierePlan = requierePlan;
    }

}

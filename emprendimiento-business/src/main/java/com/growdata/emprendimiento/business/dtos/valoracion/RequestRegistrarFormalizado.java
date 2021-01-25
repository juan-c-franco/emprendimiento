package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RequestRegistrarFormalizado {

    private Long idEmprendimiento;
    private Long idFormalizado;
    private Long idFuncionario;
    private BigDecimal idcajacompensacion;
    private String nombreEmprendimiento;
    private String nombreEmpresa;
    private String nit;
    private String nRegistroMercantil;
    private String nombreRepresentante;
    private String direccion;
    private Long telefono;
    private int idmunicipio;
    private String email;
    private String web;
    private String formalizado;
    private BigDecimal constitucion;
    private BigDecimal sector;
    private BigDecimal tEmprendimiento;
    private List<List<String>> paisesComercializa;
    private List<String> beneficiarios;
    private Character negInternet;
    private String prodServ;
    private Date fechaRenov;
    private Date fechaInicio;
    private BigDecimal actividad;
    private BigDecimal empDirectos;
    private BigDecimal empIndirectos;
    private String observacionesS;
    private int requierePlan;
    private boolean finalizado;

    public RequestRegistrarFormalizado() {
    }

    public RequestRegistrarFormalizado(Long idEmprendimiento, Long idFormalizado, Long idFuncionario, BigDecimal idcajacompensacion, String nombreEmprendimiento, String nombreEmpresa, String nit, String nRegistroMercantil, String nombreRepresentante, String direccion, Long telefono, int idmunicipio, String email, String web, String formalizado, BigDecimal constitucion, BigDecimal sector, BigDecimal tEmprendimiento, List<List<String>> paisesComercializa, List<String> beneficiarios, Character negInternet, String prodServ, Date fechaRenov, Date fechaInicio, BigDecimal actividad, BigDecimal empDirectos, BigDecimal empIndirectos, String observaciones, int requierePlan, boolean finalizado) {
        this.idEmprendimiento = idEmprendimiento;
        this.idFormalizado = idFormalizado;
        this.idFuncionario = idFuncionario;
        this.idcajacompensacion = idcajacompensacion;
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.nRegistroMercantil = nRegistroMercantil;
        this.nombreRepresentante = nombreRepresentante;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idmunicipio = idmunicipio;
        this.email = email;
        this.web = web;
        this.formalizado = formalizado;
        this.constitucion = constitucion;
        this.sector = sector;
        this.tEmprendimiento = tEmprendimiento;
        this.paisesComercializa = paisesComercializa;
        this.beneficiarios = beneficiarios;
        this.negInternet = negInternet;
        this.prodServ = prodServ;
        this.fechaRenov = fechaRenov;
        this.fechaInicio = fechaInicio;
        this.actividad = actividad;
        this.empDirectos = empDirectos;
        this.empIndirectos = empIndirectos;
        this.observacionesS = observaciones;
        this.requierePlan = requierePlan;
        this.finalizado = finalizado;
    }

    public Long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(Long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    public Long getIdFormalizado() {
        return idFormalizado;
    }

    public void setIdFormalizado(Long idFormalizado) {
        this.idFormalizado = idFormalizado;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getnRegistroMercantil() {
        return nRegistroMercantil;
    }

    public void setnRegistroMercantil(String nRegistroMercantil) {
        this.nRegistroMercantil = nRegistroMercantil;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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

    public BigDecimal gettEmprendimiento() {
        return tEmprendimiento;
    }

    public void settEmprendimiento(BigDecimal tEmprendimiento) {
        this.tEmprendimiento = tEmprendimiento;
    }

    public List<List<String>> getPaisesComercializa() {
        return paisesComercializa;
    }

    public void setPaisesComercializa(List<List<String>> paisesComercializa) {
        this.paisesComercializa = paisesComercializa;
    }

    public List<String> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<String> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public Character getNegInternet() {
        return negInternet;
    }

    public void setNegInternet(Character negInternet) {
        this.negInternet = negInternet;
    }

    public String getProdServ() {
        return prodServ;
    }

    public void setProdServ(String prodServ) {
        this.prodServ = prodServ;
    }

    public Date getFechaRenov() {
        return fechaRenov;
    }

    public void setFechaRenov(Date fechaRenov) {
        this.fechaRenov = fechaRenov;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigDecimal getActividad() {
        return actividad;
    }

    public void setActividad(BigDecimal actividad) {
        this.actividad = actividad;
    }

    public BigDecimal getEmpDirectos() {
        return empDirectos;
    }

    public void setEmpDirectos(BigDecimal empDirectos) {
        this.empDirectos = empDirectos;
    }

    public BigDecimal getEmpIndirectos() {
        return empIndirectos;
    }

    public void setEmpIndirectos(BigDecimal empIndirectos) {
        this.empIndirectos = empIndirectos;
    }

    public String getFormalizado() {
        return formalizado;
    }

    public void setFormalizado(String formalizado) {
        this.formalizado = formalizado;
    }

    private boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
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

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean checkNullsEmprendimiento() {

        if (this.beneficiarios == null || this.beneficiarios.size() == 0
                || isNullOrEmpty(this.nombreEmprendimiento) || this.tEmprendimiento == null) {
            return false;
        }

        return true;
    }

    public boolean checkNullsFormalizado() {

        if (this.actividad == null
                || this.constitucion == null || isNullOrEmpty(this.direccion) || isNullOrEmpty(this.email)
                || this.empDirectos == null || this.empIndirectos == null || this.fechaInicio == null
                || this.fechaRenov == null || this.idFuncionario == null || this.idcajacompensacion == null
                || this.idmunicipio == 0 || this.nRegistroMercantil == null || isNullOrEmpty(this.nit)
                || isNullOrEmpty(this.nombreEmpresa) || this.isNullOrEmpty(this.nombreRepresentante)
                || isNullOrEmpty(this.prodServ) || this.sector == null
                || this.telefono == null) {
            return false;
        }

        return true;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Formalizado implements java.io.Serializable {

    private long idformalizacion;
    private Emprendimiento emprendimiento;
    private Tipoconstitucionlegal tipoconstitucionlegal;
    private Sectorproductivo sectorproductivo;
    private Actividadinternacional actividadinternacional;
    private String nombreempresa;
    private String representantelegal;
    private String productoservicioofrece;
    private Character negociosinternet;
    private String numeroregistromercantil;
    private Date fecharenovacion;
    private String nit;
    private Date fechainiciolabores;
    private BigDecimal empleosdirectos;
    private BigDecimal empleosindirectos;
    private String direccionempresa;
    private Long telefonoempresa;
    private int municipio;
    private String emailempresa;
    private String sitioweb;
    private Set<Paisescomercializa> paisescomercializas = new HashSet<Paisescomercializa>(0);
//    private Set<Emprendimiento> emprendimientos = new HashSet<Emprendimiento>(0);

    public Formalizado() {
    }

    public Formalizado(long idformalizacion, Emprendimiento emprendimiento) {
        this.idformalizacion = idformalizacion;
        this.emprendimiento = emprendimiento;
    }

    public long getIdformalizacion() {
        return idformalizacion;
    }

    public void setIdformalizacion(long idformalizacion) {
        this.idformalizacion = idformalizacion;
    }

    public Emprendimiento getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Tipoconstitucionlegal getTipoconstitucionlegal() {
        return tipoconstitucionlegal;
    }

    public void setTipoconstitucionlegal(Tipoconstitucionlegal tipoconstitucionlegal) {
        this.tipoconstitucionlegal = tipoconstitucionlegal;
    }

    public Sectorproductivo getSectorproductivo() {
        return sectorproductivo;
    }

    public void setSectorproductivo(Sectorproductivo sectorproductivo) {
        this.sectorproductivo = sectorproductivo;
    }

    public Actividadinternacional getActividadinternacional() {
        return actividadinternacional;
    }

    public void setActividadinternacional(Actividadinternacional actividadinternacional) {
        this.actividadinternacional = actividadinternacional;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getRepresentantelegal() {
        return representantelegal;
    }

    public void setRepresentantelegal(String representantelegal) {
        this.representantelegal = representantelegal;
    }

    public String getProductoservicioofrece() {
        return productoservicioofrece;
    }

    public void setProductoservicioofrece(String productoservicioofrece) {
        this.productoservicioofrece = productoservicioofrece;
    }

    public Character getNegociosinternet() {
        return negociosinternet;
    }

    public void setNegociosinternet(Character negociosinternet) {
        this.negociosinternet = negociosinternet;
    }

    public String getNumeroregistromercantil() {
        return numeroregistromercantil;
    }

    public void setNumeroregistromercantil(String numeroregistromercantil) {
        this.numeroregistromercantil = numeroregistromercantil;
    }

    public Date getFecharenovacion() {
        return fecharenovacion;
    }

    public void setFecharenovacion(Date fecharenovacion) {
        this.fecharenovacion = fecharenovacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechainiciolabores() {
        return fechainiciolabores;
    }

    public void setFechainiciolabores(Date fechainiciolabores) {
        this.fechainiciolabores = fechainiciolabores;
    }

    public BigDecimal getEmpleosdirectos() {
        return empleosdirectos;
    }

    public void setEmpleosdirectos(BigDecimal empleosdirectos) {
        this.empleosdirectos = empleosdirectos;
    }

    public BigDecimal getEmpleosindirectos() {
        return empleosindirectos;
    }

    public void setEmpleosindirectos(BigDecimal empleosindirectos) {
        this.empleosindirectos = empleosindirectos;
    }

    public String getDireccionempresa() {
        return direccionempresa;
    }

    public void setDireccionempresa(String direccionempresa) {
        this.direccionempresa = direccionempresa;
    }

    public Long getTelefonoempresa() {
        return telefonoempresa;
    }

    public void setTelefonoempresa(Long telefonoempresa) {
        this.telefonoempresa = telefonoempresa;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public String getEmailempresa() {
        return emailempresa;
    }

    public void setEmailempresa(String emailempresa) {
        this.emailempresa = emailempresa;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public Set<Paisescomercializa> getPaisescomercializas() {
        return paisescomercializas;
    }

    public void setPaisescomercializas(Set<Paisescomercializa> paisescomercializas) {
        this.paisescomercializas = paisescomercializas;
    }

//    public Set<Emprendimiento> getEmprendimientos() {
//        return emprendimientos;
//    }
//
//    public void setEmprendimientos(Set<Emprendimiento> emprendimientos) {
//        this.emprendimientos = emprendimientos;
//    }
    public Formalizado(long idformalizacion, Emprendimiento emprendimiento, Tipoconstitucionlegal tipoconstitucionlegal, Sectorproductivo sectorproductivo, Actividadinternacional actividadinternacional, String nombreempresa, String representantelegal, String productoservicioofrece, Character negociosinternet, String numeroregistromercantil, Date fecharenovacion, String nit, Date fechainiciolabores, BigDecimal empleosdirectos, BigDecimal empleosindirectos, String direccionempresa, Long telefonoempresa, int municipio, String emailempresa, String sitioweb) {
        this.idformalizacion = idformalizacion;
        this.emprendimiento = emprendimiento;
        this.tipoconstitucionlegal = tipoconstitucionlegal;
        this.sectorproductivo = sectorproductivo;
        this.actividadinternacional = actividadinternacional;
        this.nombreempresa = nombreempresa;
        this.representantelegal = representantelegal;
        this.productoservicioofrece = productoservicioofrece;
        this.negociosinternet = negociosinternet;
        this.numeroregistromercantil = numeroregistromercantil;
        this.fecharenovacion = fecharenovacion;
        this.nit = nit;
        this.fechainiciolabores = fechainiciolabores;
        this.empleosdirectos = empleosdirectos;
        this.empleosindirectos = empleosindirectos;
        this.direccionempresa = direccionempresa;
        this.telefonoempresa = telefonoempresa;
        this.municipio = municipio;
        this.emailempresa = emailempresa;
        this.sitioweb = sitioweb;
    }

}

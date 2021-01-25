package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad formalizado.
 *
 * @author Juan Franco
 */
public class FormalizadoDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idformalizacion;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Tipo de constituci�n legal.
     */
    private TipoconstitucionlegalDTO tipoconstitucionlegal;
    /**
     * Sector productivo.
     */
    private SectorproductivoDTO sectorproductivo;
    /**
     * Actividad Internacional
     */
    private ActividadInternacionalDTO actividadinternacional;
    /**
     * Nombre de la empresa.
     */
    private String nombreempresa;
    /**
     * Nombre del representante legal.
     */
    private String representantelegal;
    /**
     * Lista de productos y servicio que ofrece.
     */
    private String productoservicioofrece;
    /**
     * Tiene o no ventas por internet.
     */
    private Character negociosinternet;
    /**
     * N�mero de registro mercantil.
     */
    private String numeroregistromercantil;
    /**
     * Fecha de renovaci�n.
     */
    private Date fecharenovacion;
    /**
     * NIT
     */
    private String nit;
    /**
     * Fecha de inicio de labores.
     */
    private Date fechainiciolabores;
    /**
     * Cantidad de empleados directos.
     */
    private BigDecimal empleosdirectos;
    /**
     * Cantidad de empleados indirectos.
     */
    private BigDecimal empleosindirectos;
    /**
     * Direcci�n de la empresa.
     */
    private String direccionempresa;
    /**
     * Tel�fono de la empresa.
     */
    private Long telefonoempresa;
    /**
     * Identificador del municipio.
     */
    private int municipios;
    /**
     * Municipio.
     */
    private MunicipiosDTO municipio;
    /**
     * Correo electr�nico.
     */
    private String emailempresa;
    /**
     * URL p�gina web.
     */
    private String sitioweb;
    /**
     * Paises con los que comercializa.
     */
    private Set<PaisescomercializaDTO> paisescomercializas
            = new HashSet<PaisescomercializaDTO>(0);
    /**
     * Emprendimientos.
     */
    private Set<EmprendimientoDTO> emprendimientos
            = new HashSet<EmprendimientoDTO>(0);

    /**
     * Constructor.
     */
    public FormalizadoDTO() {
    }

    /**
     * Constructor.
     *
     * @param idformalizacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     */
    public FormalizadoDTO(long idformalizacion,
            EmprendimientoDTO emprendimiento) {
        this.idformalizacion = idformalizacion;
        this.emprendimiento = emprendimiento;
    }

    /**
     * Constructor.
     *
     * @param idformalizacion Identificador.
     * @param emprendimiento Datos del emprendimiento.
     * @param tipoconstitucionlegal Tipo de constituci�n legal.
     * @param sectorproductivo Sector productivo.
     * @param actividadinternacional Actividad Internacional.
     * @param nombreempresa Nombre de la empresa.
     * @param representantelegal Nombre del representante legal.
     * @param productoservicioofrece Productos y servicios ofrecidos.
     * @param negociosinternet Realiza negocios por internet.
     * @param numeroregistromercantil N�mero de registro mercantil.
     * @param fecharenovacion Fecha de renovaci�n de matricula.
     * @param nit NIT.
     * @param fechainiciolabores Fecha de inicio de labores.
     * @param empleosdirectos Cantidad de empleos directos.
     * @param empleosindirectos Cantidad de empleos indirectos.
     * @param direccionempresa Direcci�n de la empresa.
     * @param telefonoempresa Tel�fono de la empresa.
     * @param municipios Municipio.
     * @param emailempresa Correo electr�nico.
     * @param sitioweb URl p�gina web.
     * @param emprendimientos Emprendimientos.
     */
    public FormalizadoDTO(long idformalizacion,
            EmprendimientoDTO emprendimiento,
            TipoconstitucionlegalDTO tipoconstitucionlegal,
            SectorproductivoDTO sectorproductivo,
            ActividadInternacionalDTO actividadinternacional,
            String nombreempresa, String representantelegal,
            String productoservicioofrece, Character negociosinternet,
            String numeroregistromercantil, Date fecharenovacion, String nit,
            Date fechainiciolabores, BigDecimal empleosdirectos,
            BigDecimal empleosindirectos, String direccionempresa,
            Long telefonoempresa, int municipios, String emailempresa,
            String sitioweb, Set<EmprendimientoDTO> emprendimientos) {
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
        this.municipios = municipios;
        this.emailempresa = emailempresa;
        this.sitioweb = sitioweb;
        this.emprendimientos = emprendimientos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdformalizacion() {
        return this.idformalizacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idformalizacion Valor a ser actualizado.
     */
    public void setIdformalizacion(long idformalizacion) {
        this.idformalizacion = idformalizacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
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

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipoconstitucionlegalDTO getTipoconstitucionlegal() {
        return this.tipoconstitucionlegal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipoconstitucionlegal Valor a ser actualizado.
     */
    public void setTipoconstitucionlegal(
            TipoconstitucionlegalDTO tipoconstitucionlegal) {
        this.tipoconstitucionlegal = tipoconstitucionlegal;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public SectorproductivoDTO getSectorproductivo() {
        return this.sectorproductivo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sectorproductivo Valor a ser actualizado.
     */
    public void setSectorproductivo(SectorproductivoDTO sectorproductivo) {
        this.sectorproductivo = sectorproductivo;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public ActividadInternacionalDTO getActividadinternacional() {
        return this.actividadinternacional;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param actividadinternacional Valor a ser actualizado.
     */
    public void setActividadinternacional(
            ActividadInternacionalDTO actividadinternacional) {
        this.actividadinternacional = actividadinternacional;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreempresa() {
        return this.nombreempresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreempresa Valor a ser actualizado.
     */
    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getRepresentantelegal() {
        return this.representantelegal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param representantelegal Valor a ser actualizado.
     */
    public void setRepresentantelegal(String representantelegal) {
        this.representantelegal = representantelegal;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getProductoservicioofrece() {
        return this.productoservicioofrece;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param productoservicioofrece Valor a ser actualizado.
     */
    public void setProductoservicioofrece(String productoservicioofrece) {
        this.productoservicioofrece = productoservicioofrece;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getNegociosinternet() {
        return this.negociosinternet;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param negociosinternet Valor a ser actualizado.
     */
    public void setNegociosinternet(Character negociosinternet) {
        this.negociosinternet = negociosinternet;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumeroregistromercantil() {
        return this.numeroregistromercantil;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param numeroregistromercantil Valor a ser actualizado.
     */
    public void setNumeroregistromercantil(String numeroregistromercantil) {
        this.numeroregistromercantil = numeroregistromercantil;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharenovacion() {
        return this.fecharenovacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharenovacion Valor a ser actualizado.
     */
    public void setFecharenovacion(Date fecharenovacion) {
        this.fecharenovacion = fecharenovacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNit() {
        return this.nit;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nit Valor a ser actualizado.
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechainiciolabores() {
        return this.fechainiciolabores;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechainiciolabores Valor a ser actualizado.
     */
    public void setFechainiciolabores(Date fechainiciolabores) {
        this.fechainiciolabores = fechainiciolabores;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getEmpleosdirectos() {
        return this.empleosdirectos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param empleosdirectos Valor a ser actualizado.
     */
    public void setEmpleosdirectos(BigDecimal empleosdirectos) {
        this.empleosdirectos = empleosdirectos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getEmpleosindirectos() {
        return this.empleosindirectos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param empleosindirectos Valor a ser actualizado.
     */
    public void setEmpleosindirectos(BigDecimal empleosindirectos) {
        this.empleosindirectos = empleosindirectos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDireccionempresa() {
        return this.direccionempresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param direccionempresa Valor a ser actualizado.
     */
    public void setDireccionempresa(String direccionempresa) {
        this.direccionempresa = direccionempresa;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Long getTelefonoempresa() {
        return this.telefonoempresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param telefonoempresa Valor a ser actualizado.
     */
    public void setTelefonoempresa(Long telefonoempresa) {
        this.telefonoempresa = telefonoempresa;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public int getMunicipios() {
        return municipios;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param municipios Valor a ser actualizado.
     */
    public void setMunicipios(int municipios) {
        this.municipios = municipios;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getEmailempresa() {
        return this.emailempresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emailempresa Valor a ser actualizado.
     */
    public void setEmailempresa(String emailempresa) {
        this.emailempresa = emailempresa;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSitioweb() {
        return this.sitioweb;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sitioweb Valor a ser actualizado.
     */
    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EmprendimientoDTO> getEmprendimientos() {
        return this.emprendimientos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimientos Valor a ser actualizado.
     */
    public void setEmprendimientos(Set<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<PaisescomercializaDTO> getPaisescomercializas() {
        return paisescomercializas;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param paisescomercializas Valor a ser actualizado.
     */
    public void setPaisescomercializas(
            Set<PaisescomercializaDTO> paisescomercializas) {
        this.paisescomercializas = paisescomercializas;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public MunicipiosDTO getMunicipio() {
        return municipio;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param municipio Valor a ser actualizado.
     */
    public void setMunicipio(MunicipiosDTO municipio) {
        this.municipio = municipio;
    }

}

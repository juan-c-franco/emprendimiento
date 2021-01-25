package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class NoestablecidoDTO implements java.io.Serializable {

    private BigDecimal idnoestablecido;
    private EmprendimientoDTO emprendimiento;
    private TipoconstitucionlegalDTO tipoconstitucionlegal;
    private SectorproductivoDTO sectorproductivo;
    private String productoservicioofrece;
    private Date cuandoinicia;
    private String observaciones;

    public NoestablecidoDTO() {
    }

    public NoestablecidoDTO(BigDecimal idnoestablecido, EmprendimientoDTO emprendimiento) {
        this.idnoestablecido = idnoestablecido;
        this.emprendimiento = emprendimiento;
    }

    public NoestablecidoDTO(BigDecimal idnoestablecido, EmprendimientoDTO emprendimiento, TipoconstitucionlegalDTO tipoconstitucionlegal, SectorproductivoDTO sectorproductivo, String productoservicioofrece, Date cuandoinicia, String observaciones) {
        this.idnoestablecido = idnoestablecido;
        this.emprendimiento = emprendimiento;
        this.tipoconstitucionlegal = tipoconstitucionlegal;
        this.sectorproductivo = sectorproductivo;
        this.productoservicioofrece = productoservicioofrece;
        this.cuandoinicia = cuandoinicia;
        this.observaciones = observaciones;
    }

    public BigDecimal getIdnoestablecido() {
        return this.idnoestablecido;
    }

    public void setIdnoestablecido(BigDecimal idnoestablecido) {
        this.idnoestablecido = idnoestablecido;
    }

    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public TipoconstitucionlegalDTO getTipoconstitucionlegal() {
        return this.tipoconstitucionlegal;
    }

    public void setTipoconstitucionlegal(TipoconstitucionlegalDTO tipoconstitucionlegal) {
        this.tipoconstitucionlegal = tipoconstitucionlegal;
    }

    public SectorproductivoDTO getSectorproductivo() {
        return this.sectorproductivo;
    }

    public void setSectorproductivo(SectorproductivoDTO sectorproductivo) {
        this.sectorproductivo = sectorproductivo;
    }

    public String getProductoservicioofrece() {
        return this.productoservicioofrece;
    }

    public void setProductoservicioofrece(String productoservicioofrece) {
        this.productoservicioofrece = productoservicioofrece;
    }

    public Date getCuandoinicia() {
        return this.cuandoinicia;
    }

    public void setCuandoinicia(Date cuandoinicia) {
        this.cuandoinicia = cuandoinicia;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

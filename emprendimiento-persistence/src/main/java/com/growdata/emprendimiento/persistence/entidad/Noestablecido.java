package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class Noestablecido implements java.io.Serializable {

    private BigDecimal idnoestablecido;
    private Emprendimiento emprendimiento;
    private Tipoconstitucionlegal tipoconstitucionlegal;
    private Sectorproductivo sectorproductivo;
    private String productoservicioofrece;
    private Date cuandoinicia;
    private String observaciones;

    public Noestablecido() {
    }

    public Noestablecido(BigDecimal idnoestablecido, Emprendimiento emprendimiento) {
        this.idnoestablecido = idnoestablecido;
        this.emprendimiento = emprendimiento;
    }

    public Noestablecido(BigDecimal idnoestablecido, Emprendimiento emprendimiento, Tipoconstitucionlegal tipoconstitucionlegal, Sectorproductivo sectorproductivo, String productoservicioofrece, Date cuandoinicia, String observaciones) {
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

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Tipoconstitucionlegal getTipoconstitucionlegal() {
        return this.tipoconstitucionlegal;
    }

    public void setTipoconstitucionlegal(Tipoconstitucionlegal tipoconstitucionlegal) {
        this.tipoconstitucionlegal = tipoconstitucionlegal;
    }

    public Sectorproductivo getSectorproductivo() {
        return this.sectorproductivo;
    }

    public void setSectorproductivo(Sectorproductivo sectorproductivo) {
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

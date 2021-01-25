package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SectorproductivoDTO implements java.io.Serializable {

    private BigDecimal idsectorproductivo;
    private String nombresectorproductivo;
    private String descripcion;
    private Set<FormalizadoDTO> formalizados = new HashSet<FormalizadoDTO>(0);
    private Set<NoestablecidoDTO> noestablecidos = new HashSet<NoestablecidoDTO>(0);

    public SectorproductivoDTO() {
    }

    public SectorproductivoDTO(BigDecimal idsectorproductivo, String nombresectorproductivo) {
        this.idsectorproductivo = idsectorproductivo;
        this.nombresectorproductivo = nombresectorproductivo;
    }

    public SectorproductivoDTO(BigDecimal idsectorproductivo, String nombresectorproductivo, String descripcion, Set<FormalizadoDTO> formalizados, Set<NoestablecidoDTO> noestablecidos) {
        this.idsectorproductivo = idsectorproductivo;
        this.nombresectorproductivo = nombresectorproductivo;
        this.descripcion = descripcion;
        this.formalizados = formalizados;
        this.noestablecidos = noestablecidos;
    }

    public BigDecimal getIdsectorproductivo() {
        return this.idsectorproductivo;
    }

    public void setIdsectorproductivo(BigDecimal idsectorproductivo) {
        this.idsectorproductivo = idsectorproductivo;
    }

    public String getNombresectorproductivo() {
        return this.nombresectorproductivo;
    }

    public void setNombresectorproductivo(String nombresectorproductivo) {
        this.nombresectorproductivo = nombresectorproductivo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<FormalizadoDTO> getFormalizados() {
        return this.formalizados;
    }

    public void setFormalizados(Set<FormalizadoDTO> formalizados) {
        this.formalizados = formalizados;
    }

    public Set<NoestablecidoDTO> getNoestablecidos() {
        return this.noestablecidos;
    }

    public void setNoestablecidos(Set<NoestablecidoDTO> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

}

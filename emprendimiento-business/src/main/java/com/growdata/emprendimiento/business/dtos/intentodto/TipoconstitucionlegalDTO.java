package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipoconstitucionlegalDTO implements java.io.Serializable {

    private BigDecimal idtipoconstitucionlegal;
    private String nombretipoconstitucionlegal;
    private String descripcion;
    private Set<NoestablecidoDTO> noestablecidos = new HashSet<NoestablecidoDTO>(0);
    private Set<FormalizadoDTO> formalizados = new HashSet<FormalizadoDTO>(0);

    public TipoconstitucionlegalDTO() {
    }

    public TipoconstitucionlegalDTO(BigDecimal idtipoconstitucionlegal, String nombretipoconstitucionlegal) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
    }

    public TipoconstitucionlegalDTO(BigDecimal idtipoconstitucionlegal, String nombretipoconstitucionlegal, String descripcion, Set<NoestablecidoDTO> noestablecidos, Set<FormalizadoDTO> formalizados) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
        this.descripcion = descripcion;
        this.noestablecidos = noestablecidos;
        this.formalizados = formalizados;
    }

    public BigDecimal getIdtipoconstitucionlegal() {
        return this.idtipoconstitucionlegal;
    }

    public void setIdtipoconstitucionlegal(BigDecimal idtipoconstitucionlegal) {
        this.idtipoconstitucionlegal = idtipoconstitucionlegal;
    }

    public String getNombretipoconstitucionlegal() {
        return this.nombretipoconstitucionlegal;
    }

    public void setNombretipoconstitucionlegal(String nombretipoconstitucionlegal) {
        this.nombretipoconstitucionlegal = nombretipoconstitucionlegal;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<NoestablecidoDTO> getNoestablecidos() {
        return this.noestablecidos;
    }

    public void setNoestablecidos(Set<NoestablecidoDTO> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

    public Set<FormalizadoDTO> getFormalizados() {
        return this.formalizados;
    }

    public void setFormalizados(Set<FormalizadoDTO> formalizados) {
        this.formalizados = formalizados;
    }

}

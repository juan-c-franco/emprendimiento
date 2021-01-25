package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TiposesionDTO implements java.io.Serializable {

    private BigDecimal idtiposesion;
    private String nombresesion;
    private String descripcion;
    private Set<SesionesDTO> sesioneses = new HashSet<SesionesDTO>(0);

    public TiposesionDTO() {
    }

    public TiposesionDTO(BigDecimal idtiposesion) {
        this.idtiposesion = idtiposesion;
    }

    public TiposesionDTO(BigDecimal idtiposesion, String nombresesion, String descripcion, Set<SesionesDTO> sesioneses) {
        this.idtiposesion = idtiposesion;
        this.nombresesion = nombresesion;
        this.descripcion = descripcion;
        this.sesioneses = sesioneses;
    }

    public BigDecimal getIdtiposesion() {
        return this.idtiposesion;
    }

    public void setIdtiposesion(BigDecimal idtiposesion) {
        this.idtiposesion = idtiposesion;
    }

    public String getNombresesion() {
        return this.nombresesion;
    }

    public void setNombresesion(String nombresesion) {
        this.nombresesion = nombresesion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<SesionesDTO> getSesioneses() {
        return this.sesioneses;
    }

    public void setSesioneses(Set<SesionesDTO> sesioneses) {
        this.sesioneses = sesioneses;
    }

}

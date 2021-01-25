package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipoencuestaDTO implements java.io.Serializable {

    private BigDecimal idtipoencuesta;
    private String nombreencuesta;
    private String descripcion;
    private Set<EncuestaDTO> encuestas = new HashSet<EncuestaDTO>(0);

    public TipoencuestaDTO() {
    }

    public TipoencuestaDTO(BigDecimal idtipoencuesta) {
        this.idtipoencuesta = idtipoencuesta;
    }

    public TipoencuestaDTO(BigDecimal idtipoencuesta, String nombreencuesta, String descripcion, Set<EncuestaDTO> encuestas) {
        this.idtipoencuesta = idtipoencuesta;
        this.nombreencuesta = nombreencuesta;
        this.descripcion = descripcion;
        this.encuestas = encuestas;
    }

    public BigDecimal getIdtipoencuesta() {
        return this.idtipoencuesta;
    }

    public void setIdtipoencuesta(BigDecimal idtipoencuesta) {
        this.idtipoencuesta = idtipoencuesta;
    }

    public String getNombreencuesta() {
        return this.nombreencuesta;
    }

    public void setNombreencuesta(String nombreencuesta) {
        this.nombreencuesta = nombreencuesta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<EncuestaDTO> getEncuestas() {
        return this.encuestas;
    }

    public void setEncuestas(Set<EncuestaDTO> encuestas) {
        this.encuestas = encuestas;
    }

}

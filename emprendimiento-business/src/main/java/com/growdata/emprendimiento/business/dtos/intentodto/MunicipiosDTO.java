package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class MunicipiosDTO {

    private BigDecimal id;
    private DepartamentosDTO departamentos;
    private String divipola;
    private String nombre;
    private Set<SedesDTO> sedeses = new HashSet<SedesDTO>(0);

    public MunicipiosDTO() {
    }

    public MunicipiosDTO(BigDecimal id) {
        this.id = id;
    }

    public MunicipiosDTO(BigDecimal id, DepartamentosDTO departamentos, String divipola, String nombre) {
        this.id = id;
        this.departamentos = departamentos;
        this.divipola = divipola;
        this.nombre = nombre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public DepartamentosDTO getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(DepartamentosDTO departamentos) {
        this.departamentos = departamentos;
    }

    public String getDivipola() {
        return divipola;
    }

    public void setDivipola(String divipola) {
        this.divipola = divipola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<SedesDTO> getSedeses() {
        return sedeses;
    }

    public void setSedeses(Set<SedesDTO> sedeses) {
        this.sedeses = sedeses;
    }

}

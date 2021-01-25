package com.growdata.emprendimiento.business.dtos.intentodto;

import java.util.HashSet;
import java.util.Set;

public class PaisesDTO implements java.io.Serializable {

    private int idpais;
    private String nombrepais;
    private Set<PaisescomercializaDTO> paisescomercializas = new HashSet<PaisescomercializaDTO>(0);

    public PaisesDTO(int idpais, String nombrepais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
    }

    public PaisesDTO() {

    }

    public PaisesDTO(int idpais, String nombrepais, Set<PaisescomercializaDTO> paisescomercializas) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
        this.paisescomercializas = paisescomercializas;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public Set<PaisescomercializaDTO> getPaisescomercializas() {
        return paisescomercializas;
    }

    public void setPaisescomercializas(Set<PaisescomercializaDTO> paisescomercializas) {
        this.paisescomercializas = paisescomercializas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.entidad;

import java.util.HashSet;
import java.util.Set;

public class Paises implements java.io.Serializable {

    private int idpais;
    private String nombrepais;
    private Set<Paisescomercializa> paisescomercializas = new HashSet<Paisescomercializa>(0);

    public Paises() {

    }

    public Paises(int idpais, String nombrepais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
    }

    public Paises(int idpais, String nombrepais, Set<Paisescomercializa> paisescomercializas) {
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

    public Set<Paisescomercializa> getPaisescomercializas() {
        return paisescomercializas;
    }

    public void setPaisescomercializas(Set<Paisescomercializa> paisescomercializas) {
        this.paisescomercializas = paisescomercializas;
    }

}

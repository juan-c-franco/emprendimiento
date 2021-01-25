package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

public class Paisescomercializa implements java.io.Serializable {

    private long idpaisescomercializa;
    private Formalizado formalizado;
    private Paises paises;

    public Paisescomercializa() {
    }

    public Paisescomercializa(long idpaisescomercializa, Formalizado formalizado) {
        this.idpaisescomercializa = idpaisescomercializa;
        this.formalizado = formalizado;
    }

    public Paisescomercializa(long idpaisescomercializa, Formalizado formalizado, Paises paises) {
        this.idpaisescomercializa = idpaisescomercializa;
        this.formalizado = formalizado;
        this.paises = paises;
    }

    public long getIdpaisescomercializa() {
        return this.idpaisescomercializa;
    }

    public void setIdpaisescomercializa(long idpaisescomercializa) {
        this.idpaisescomercializa = idpaisescomercializa;
    }

    public Formalizado getFormalizado() {
        return formalizado;
    }

    public void setFormalizado(Formalizado formalizado) {
        this.formalizado = formalizado;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

}

package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

public class PaisescomercializaDTO implements java.io.Serializable {

    private long idpaisescomercializa;
    private FormalizadoDTO formalizado;
    private PaisesDTO paises;

    public PaisescomercializaDTO() {
    }

    public PaisescomercializaDTO(long idpaisescomercializa, FormalizadoDTO formalizado) {
        this.idpaisescomercializa = idpaisescomercializa;
        this.formalizado = formalizado;
    }

    public PaisescomercializaDTO(long idpaisescomercializa, FormalizadoDTO formalizado, PaisesDTO paises) {
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

    public FormalizadoDTO getFormalizado() {
        return formalizado;
    }

    public void setFormalizado(FormalizadoDTO formalizado) {
        this.formalizado = formalizado;
    }

    public PaisesDTO getPaises() {
        return paises;
    }

    public void setPaises(PaisesDTO paises) {
        this.paises = paises;
    }
}

package com.growdata.emprendimiento.business.dtos.sensibilizacion;

public class RequestAsociarBeneficiarioSesion {

    private long idbeneficiario;

    private long idsesion;

    private String email;

    public long getIdbeneficiario() {
        return idbeneficiario;
    }

    public void setIdbeneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    public long getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(long idsesion) {
        this.idsesion = idsesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

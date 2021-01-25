package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class LoginiciosesionDTO implements java.io.Serializable {

    private long idloginiciosesion;
    private CuentausuarioDTO cuentausuario;
    private Date fecharegistro;

    public LoginiciosesionDTO() {
    }

    public LoginiciosesionDTO(long idloginiciosesion, CuentausuarioDTO cuentausuario) {
        this.idloginiciosesion = idloginiciosesion;
        this.cuentausuario = cuentausuario;
    }

    public LoginiciosesionDTO(long idloginiciosesion, CuentausuarioDTO cuentausuario, Date fecharegistro) {
        this.idloginiciosesion = idloginiciosesion;
        this.cuentausuario = cuentausuario;
        this.fecharegistro = fecharegistro;
    }

    public long getIdloginiciosesion() {
        return this.idloginiciosesion;
    }

    public void setIdloginiciosesion(long idloginiciosesion) {
        this.idloginiciosesion = idloginiciosesion;
    }

    public CuentausuarioDTO getCuentausuario() {
        return this.cuentausuario;
    }

    public void setCuentausuario(CuentausuarioDTO cuentausuario) {
        this.cuentausuario = cuentausuario;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

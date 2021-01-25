package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

public class PermisosDTO implements java.io.Serializable {

    private BigDecimal idpermisos;
    private FormularioswebDTO formulariosweb;
    private RolesDTO roles;
    private Character consultar;
    private Character actualizar;
    private Character agregar;
    private Character borrar;

    public PermisosDTO() {
    }

    public PermisosDTO(BigDecimal idpermisos, FormularioswebDTO formulariosweb, RolesDTO roles) {
        this.idpermisos = idpermisos;
        this.formulariosweb = formulariosweb;
        this.roles = roles;
    }

    public PermisosDTO(BigDecimal idpermisos, FormularioswebDTO formulariosweb, RolesDTO roles, Character consultar, Character actualizar, Character agregar, Character borrar) {
        this.idpermisos = idpermisos;
        this.formulariosweb = formulariosweb;
        this.roles = roles;
        this.consultar = consultar;
        this.actualizar = actualizar;
        this.agregar = agregar;
        this.borrar = borrar;
    }

    public BigDecimal getIdpermisos() {
        return this.idpermisos;
    }

    public void setIdpermisos(BigDecimal idpermisos) {
        this.idpermisos = idpermisos;
    }

    public FormularioswebDTO getFormulariosweb() {
        return this.formulariosweb;
    }

    public void setFormulariosweb(FormularioswebDTO formulariosweb) {
        this.formulariosweb = formulariosweb;
    }

    public RolesDTO getRoles() {
        return this.roles;
    }

    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }

    public Character getConsultar() {
        return this.consultar;
    }

    public void setConsultar(Character consultar) {
        this.consultar = consultar;
    }

    public Character getActualizar() {
        return this.actualizar;
    }

    public void setActualizar(Character actualizar) {
        this.actualizar = actualizar;
    }

    public Character getAgregar() {
        return this.agregar;
    }

    public void setAgregar(Character agregar) {
        this.agregar = agregar;
    }

    public Character getBorrar() {
        return this.borrar;
    }

    public void setBorrar(Character borrar) {
        this.borrar = borrar;
    }

}

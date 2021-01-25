package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;

public class UsuarioComiteDTO {

    private BigDecimal idIntegranteComite;
    private String nombres;
    private String apellidos;
    private String groupName;
    private BigDecimal idFuncionario;

    public BigDecimal getIdIntegranteComite() {
        return idIntegranteComite;
    }

    public void setIdIntegranteComite(BigDecimal idIntegranteComite) {
        this.idIntegranteComite = idIntegranteComite;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BigDecimal getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(BigDecimal idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.commons;

public class CorreosAsistencias {

    private String valor;
    private String correo;
    private long idEncuesta;
    private long idBeneficiario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    

    public long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}

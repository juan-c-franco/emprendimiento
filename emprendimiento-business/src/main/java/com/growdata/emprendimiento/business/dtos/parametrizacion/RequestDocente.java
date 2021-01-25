/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.persistence.entidad.Estadodocente;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import java.util.Date;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestDocente {

    private long iddocente;
    private Estadodocente estadoDocente;
    private String primernombre;
    private String segundonombre;
    private String primerapellido;
    private String segundoapellido;
    private String email;
    private long telefono;
    private Tipodocumentoid tipodocumentoid;
    private String numerodocumento;
    private Date fecharegistro;

    public long getIddocente() {
        return iddocente;
    }

    public void setIddocente(long iddocente) {
        this.iddocente = iddocente;
    }

    public Estadodocente getEstadoDocente() {
        return estadoDocente;
    }

    public void setEstadoDocente(Estadodocente estadoDocente) {
        this.estadoDocente = estadoDocente;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Tipodocumentoid getTipodocumentoid() {
        return tipodocumentoid;
    }

    public void setTipodocumentoid(Tipodocumentoid tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 11/07/2019 04:10:46 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Docentes generated by hbm2java
 */
public class Docentes implements java.io.Serializable {

    private long iddocente;
    private Tipodocumentoid tipodocumentoid;
    private Estadodocente estadodocente;
    private String primernombre;
    private String segundonombre;
    private String primerapellido;
    private String segundoapellido;
    private String email;
    private long telefono;
    private String numerodocumento;
    private Date fecharegistro;
    private Set<Programacion> programacions = new HashSet<Programacion>(0);

    public Docentes() {
    }

    public Docentes(long iddocente) {
        this.iddocente = iddocente;
    }

    public Docentes(long iddocente, Tipodocumentoid tipodocumentoid, Estadodocente estadodocente, String primernombre, String primerapellido, String email, long telefono, String numerodocumento, Date fecharegistro) {
        this.iddocente = iddocente;
        this.tipodocumentoid = tipodocumentoid;
        this.estadodocente = estadodocente;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.email = email;
        this.telefono = telefono;
        this.numerodocumento = numerodocumento;
        this.fecharegistro = fecharegistro;
    }

    public Docentes(long iddocente, Tipodocumentoid tipodocumentoid, Estadodocente estadodocente, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String email, long telefono, String numerodocumento, Date fecharegistro, Set<Programacion> programacions) {
        this.iddocente = iddocente;
        this.tipodocumentoid = tipodocumentoid;
        this.estadodocente = estadodocente;
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.email = email;
        this.telefono = telefono;
        this.numerodocumento = numerodocumento;
        this.fecharegistro = fecharegistro;
        this.programacions = programacions;
    }

    public long getIddocente() {
        return this.iddocente;
    }

    public void setIddocente(long iddocente) {
        this.iddocente = iddocente;
    }

    public Tipodocumentoid getTipodocumentoid() {
        return this.tipodocumentoid;
    }

    public void setTipodocumentoid(Tipodocumentoid tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public Estadodocente getEstadodocente() {
        return this.estadodocente;
    }

    public void setEstadodocente(Estadodocente estadodocente) {
        this.estadodocente = estadodocente;
    }

    public String getPrimernombre() {
        return this.primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return this.segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return this.primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return this.segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return this.telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getNumerodocumento() {
        return this.numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Programacion> getProgramacions() {
        return this.programacions;
    }

    public void setProgramacions(Set<Programacion> programacions) {
        this.programacions = programacions;
    }

}
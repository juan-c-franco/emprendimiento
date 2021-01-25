/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestInstitucion {

    private BigDecimal id;
    private Timestamp fechaAprobacion;
    private String correoElectronico;
    private String numeroTelefono;
    private Timestamp fechaCreacion;
    private Long digitoVerificacion;
    private String nombreInstitucion;
    private int naturalezaJuridica;
    private Timestamp fechaModificacion;
    private String nit;
    private char origen;
    private Blob certificacionCalidad;
    private Date vencimientoCertificacion;
    private char estado;
    private BigDecimal idUsuarioCreacion;
    private BigDecimal tipoDocumento;
    private BigDecimal idUsuarioModificacion;
    private BigDecimal tipoInstitucionId;
    private char estadoAprobacion;
    private BigDecimal tipoCertificacion;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Timestamp getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Timestamp fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(Long digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public int getNaturalezaJuridica() {
        return naturalezaJuridica;
    }

    public void setNaturalezaJuridica(int naturalezaJuridica) {
        this.naturalezaJuridica = naturalezaJuridica;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public char getOrigen() {
        return origen;
    }

    public void setOrigen(char origen) {
        this.origen = origen;
    }

    public Blob getCertificacionCalidad() {
        return certificacionCalidad;
    }

    public void setCertificacionCalidad(Blob certificacionCalidad) {
        this.certificacionCalidad = certificacionCalidad;
    }

    public Date getVencimientoCertificacion() {
        return vencimientoCertificacion;
    }

    public void setVencimientoCertificacion(Date vencimientoCertificacion) {
        this.vencimientoCertificacion = vencimientoCertificacion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public BigDecimal getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(BigDecimal idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public BigDecimal getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(BigDecimal tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigDecimal getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    public void setIdUsuarioModificacion(BigDecimal idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    public BigDecimal getTipoInstitucionId() {
        return tipoInstitucionId;
    }

    public void setTipoInstitucionId(BigDecimal tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    public char getEstadoAprobacion() {
        return estadoAprobacion;
    }

    public void setEstadoAprobacion(char estadoAprobacion) {
        this.estadoAprobacion = estadoAprobacion;
    }

    public BigDecimal getTipoCertificacion() {
        return tipoCertificacion;
    }

    public void setTipoCertificacion(BigDecimal tipoCertificacion) {
        this.tipoCertificacion = tipoCertificacion;
    }

}

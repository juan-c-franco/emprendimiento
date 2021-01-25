/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Juan Franco
 */
public class SedesDTO {

    private BigDecimal id;
    private DepartamentosDTO departamentos;
    private MunicipiosDTO municipios;
    private String direccion;
    private String codigo;
    private Timestamp fechaCreacion;
    private BigDecimal idUsuarioCreacion;
    private BigDecimal idInstitucion;
    private Timestamp fechaModificacion;
    private BigDecimal idUsuarioModificacion;
    private String nombre;
    private boolean principal;
    private char estado;

    public SedesDTO() {
    }

    public SedesDTO(BigDecimal id, DepartamentosDTO departamentos, MunicipiosDTO municipios, String direccion, String codigo, Timestamp fechaCreacion, BigDecimal idUsuarioCreacion, BigDecimal idInstitucion, Timestamp fechaModificacion, BigDecimal idUsuarioModificacion, String nombre, boolean principal, char estado) {
        this.id = id;
        this.departamentos = departamentos;
        this.municipios = municipios;
        this.direccion = direccion;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioCreacion = idUsuarioCreacion;
        this.idInstitucion = idInstitucion;
        this.fechaModificacion = fechaModificacion;
        this.idUsuarioModificacion = idUsuarioModificacion;
        this.nombre = nombre;
        this.principal = principal;
        this.estado = estado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public DepartamentosDTO getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(DepartamentosDTO departamentos) {
        this.departamentos = departamentos;
    }

    public MunicipiosDTO getMunicipios() {
        return municipios;
    }

    public void setMunicipios(MunicipiosDTO municipios) {
        this.municipios = municipios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(BigDecimal idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public BigDecimal getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(BigDecimal idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    public void setIdUsuarioModificacion(BigDecimal idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}

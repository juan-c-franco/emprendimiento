/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Clase representante de la entidad instituciones.
 *
 * @author Juan Franco
 */
public class InstitucionesDTO {

    /**
     * Identificador.
     */
    private BigDecimal id;
    /**
     * Fecha de Aprobación.
     */
    private Timestamp fechaAprobacion;
    /**
     * Correo electrónico.
     */
    private String correoElectronico;
    /**
     * Teléfono.
     */
    private String numeroTelefono;
    /**
     * Fecha de creación.
     */
    private Timestamp fechaCreacion;
    /**
     * Dígito de verificación.
     */
    private Long digitoVerificacion;
    /**
     * Nombre.
     */
    private String nombreInstitucion;
    /**
     * Naturaleza Juridica.
     */
    private int naturalezaJuridica;
    /**
     * Fecha última modificación.
     */
    private Timestamp fechaModificacion;
    /**
     * NIT.
     */
    private String nit;
    /**
     * Origen.
     */
    private char origen;
//    private Blob certificacionCalidad;
    /**
     * Fecha de vencimiento de certificación.
     */
    private Date vencimientoCertificacion;
    /**
     * Estado.
     */
    private char estado;
    /**
     * Identificador del usuario creador.
     */
    private BigDecimal idUsuarioCreacion;
    /**
     * Tipo de documento.
     */
    private BigDecimal tipoDocumento;
    /**
     * Identificador del usuario modificador.
     */
    private BigDecimal idUsuarioModificacion;
    /**
     * Identificador tipo de institución.
     */
    private BigDecimal tipoInstitucionId;
    /**
     * Estado aprobación.
     */
    private char estadoAprobacion;
    /**
     * Tipo certificación.
     */
    private BigDecimal tipoCertificacion;

    /**
     * Constructor.
     */
    public InstitucionesDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param fechaAprobacion Fecha de aprobación.
     * @param correoElectronico Correo electrónico.
     * @param numeroTelefono Teléfono.
     * @param fechaCreacion Fecha de creaciación.
     * @param digitoVerificacion Dígito de verificación.
     * @param nombreInstitucion Nombre de la institución.
     * @param naturalezaJuridica Naturaleza Jurídica.
     * @param fechaModificacion Fecha de modoficación.
     * @param nit NIT.
     * @param origen Origen.
     * @param vencimientoCertificacion Fecha de vencimiento de certificación.
     * @param estado Estado de aprobación.
     * @param idUsuarioCreacion Identificador del usuario creador.
     * @param tipoDocumento Tipo de documento.
     * @param idUsuarioModificacion Identificador del usuario modificador.
     * @param tipoInstitucionId Identificador del tipo de institución.
     * @param estadoAprobacion Estado de la aprobación.
     * @param tipoCertificacion Tipo de certificación.
     */
    public InstitucionesDTO(BigDecimal id, Timestamp fechaAprobacion,
            String correoElectronico, String numeroTelefono,
            Timestamp fechaCreacion, Long digitoVerificacion,
            String nombreInstitucion, int naturalezaJuridica,
            Timestamp fechaModificacion, String nit, char origen,
            Date vencimientoCertificacion, char estado,
            BigDecimal idUsuarioCreacion, BigDecimal tipoDocumento,
            BigDecimal idUsuarioModificacion, BigDecimal tipoInstitucionId,
            char estadoAprobacion, BigDecimal tipoCertificacion) {
        this.id = id;
        this.fechaAprobacion = fechaAprobacion;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.fechaCreacion = fechaCreacion;
        this.digitoVerificacion = digitoVerificacion;
        this.nombreInstitucion = nombreInstitucion;
        this.naturalezaJuridica = naturalezaJuridica;
        this.fechaModificacion = fechaModificacion;
        this.nit = nit;
        this.origen = origen;
//        this.certificacionCalidad = certificacionCalidad;
        this.vencimientoCertificacion = vencimientoCertificacion;
        this.estado = estado;
        this.idUsuarioCreacion = idUsuarioCreacion;
        this.tipoDocumento = tipoDocumento;
        this.idUsuarioModificacion = idUsuarioModificacion;
        this.tipoInstitucionId = tipoInstitucionId;
        this.estadoAprobacion = estadoAprobacion;
        this.tipoCertificacion = tipoCertificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechaAprobacion() {
        return fechaAprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechaAprobacion Valor a ser actualizado.
     */
    public void setFechaAprobacion(Timestamp fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param correoElectronico Valor a ser actualizado.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param numeroTelefono Valor a ser actualizado.
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechaCreacion Valor a ser actualizado.
     */
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Long getDigitoVerificacion() {
        return digitoVerificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param digitoVerificacion Valor a ser actualizado.
     */
    public void setDigitoVerificacion(Long digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreInstitucion Valor a ser actualizado.
     */
    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public int getNaturalezaJuridica() {
        return naturalezaJuridica;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param naturalezaJuridica Valor a ser actualizado.
     */
    public void setNaturalezaJuridica(int naturalezaJuridica) {
        this.naturalezaJuridica = naturalezaJuridica;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechaModificacion Valor a ser actualizado.
     */
    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNit() {
        return nit;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nit Valor a ser actualizado.
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public char getOrigen() {
        return origen;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param origen Valor a ser actualizado.
     */
    public void setOrigen(char origen) {
        this.origen = origen;
    }

//    public Blob getCertificacionCalidad() {
//        return certificacionCalidad;
//    }
//
//    public void setCertificacionCalidad(Blob certificacionCalidad) {
//        this.certificacionCalidad = certificacionCalidad;
//    }
    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getVencimientoCertificacion() {
        return vencimientoCertificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param vencimientoCertificacion Valor a ser actualizado.
     */
    public void setVencimientoCertificacion(Date vencimientoCertificacion) {
        this.vencimientoCertificacion = vencimientoCertificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public char getEstado() {
        return estado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estado Valor a ser actualizado.
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idUsuarioCreacion Valor a ser actualizado.
     */
    public void setIdUsuarioCreacion(BigDecimal idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoDocumento Valor a ser actualizado.
     */
    public void setTipoDocumento(BigDecimal tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idUsuarioModificacion Valor a ser actualizado.
     */
    public void setIdUsuarioModificacion(BigDecimal idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getTipoInstitucionId() {
        return tipoInstitucionId;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoInstitucionId Valor a ser actualizado.
     */
    public void setTipoInstitucionId(BigDecimal tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public char getEstadoAprobacion() {
        return estadoAprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadoAprobacion Valor a ser actualizado.
     */
    public void setEstadoAprobacion(char estadoAprobacion) {
        this.estadoAprobacion = estadoAprobacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getTipoCertificacion() {
        return tipoCertificacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoCertificacion Valor a ser actualizado.
     */
    public void setTipoCertificacion(BigDecimal tipoCertificacion) {
        this.tipoCertificacion = tipoCertificacion;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import com.growdata.emprendimiento.business.dtos.seguridad.TipodocumentoidDTO;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad docentes.
 *
 * @author Juan Franco
 */
public class DocentesDTO {

    /**
     * Identificador.
     */
    private long iddocente;
    /**
     * Tipo de documento de identificación.
     */
    private TipodocumentoidDTO tipodocumentoid;
    /**
     * Estado del docente.
     */
    private EstadodocenteDTO estadodocente;
    /**
     * Primer nombre.
     */
    private String primernombre;
    /**
     * Segundo nombre.
     */
    private String segundonombre;
    /**
     * Primer apellido.
     */
    private String primerapellido;
    /**
     * Segundo apellido.
     */
    private String segundoapellido;
    /**
     * Correo electrónico.
     */
    private String email;
    /**
     * Teléfono.
     */
    private long telefono;
    /**
     * Número de documento.
     */
    private String numerodocumento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Programaciones.
     */
    private Set<ProgramacionDTO> programacions = new HashSet<ProgramacionDTO>(0);

    /**
     * Constructor.
     */
    public DocentesDTO() {
    }

    /**
     * Constructor.
     *
     * @param iddocente Identificador.
     * @param tipodocumentoid Tipo documento de identificación.
     * @param estadodocente Estado del docente.
     * @param primernombre Primer nombre.
     * @param segundonombre Segundo nombre.
     * @param primerapellido Primer apellido.
     * @param segundoapellido Segundo apellido.
     * @param email Correo electrónico.
     * @param telefono Teléfono.
     * @param numerodocumento Número de documento.
     * @param fecharegistro Fecha de registro.
     */
    public DocentesDTO(long iddocente, TipodocumentoidDTO tipodocumentoid,
            EstadodocenteDTO estadodocente, String primernombre,
            String segundonombre, String primerapellido, String segundoapellido,
            String email, long telefono, String numerodocumento,
            Date fecharegistro) {
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
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIddocente() {
        return iddocente;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param iddocente Valor a ser actualizado.
     */
    public void setIddocente(long iddocente) {
        this.iddocente = iddocente;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipodocumentoidDTO getTipodocumentoid() {
        return tipodocumentoid;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipodocumentoid Valor a ser actualizado.
     */
    public void setTipodocumentoid(TipodocumentoidDTO tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadodocenteDTO getEstadodocente() {
        return estadodocente;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadodocente Valor a ser actualizado.
     */
    public void setEstadodocente(EstadodocenteDTO estadodocente) {
        this.estadodocente = estadodocente;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimernombre() {
        return primernombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primernombre Valor a ser actualizado.
     */
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundonombre() {
        return segundonombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundonombre Valor a ser actualizado.
     */
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimerapellido() {
        return primerapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primerapellido Valor a ser actualizado.
     */
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundoapellido() {
        return segundoapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundoapellido Valor a ser actualizado.
     */
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param email Valor a ser actualizado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param telefono Valor a ser actualizado.
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param numerodocumento Valor a ser actualizado.
     */
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ProgramacionDTO> getProgramacions() {
        return programacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param programacions Valor a ser actualizado.
     */
    public void setProgramacions(Set<ProgramacionDTO> programacions) {
        this.programacions = programacions;
    }

}

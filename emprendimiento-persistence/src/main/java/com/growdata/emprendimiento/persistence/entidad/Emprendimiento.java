package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Emprendimiento implements java.io.Serializable {

    private long idemprendimiento;
    private Cajacompensacion cajacompensacion;
    private Estadoemprendimiento estadoemprendimiento;
    private Integer formalizado;
    private Tipoemprendimiento tipoemprendimiento;
    private String nombreemprendimiento;
    private Date fecharegistro;
    private Set<Rutaacompanamientoat> rutaacompanamientoats = new HashSet<Rutaacompanamientoat>(0);
    private Set<Formalizado> formalizados = new HashSet<Formalizado>(0);
    private Set<Documentos> documentoses = new HashSet<Documentos>(0);
    private Set<Noestablecido> noestablecidos = new HashSet<Noestablecido>(0);
    private Set<Asociados> asociadoses = new HashSet<Asociados>(0);
    private Set<Evaluacionemprendimientos> evaluacionemprendimientoses = new HashSet<Evaluacionemprendimientos>(0);
    private Set<Financiacion> financiacions = new HashSet<Financiacion>(0);
    private Set<Seguimiento> seguimientos = new HashSet<Seguimiento>(0);
    private Set<Logestadoemprendimiento> logestadoemprendimientos = new HashSet<Logestadoemprendimiento>(0);

    public Emprendimiento() {
    }

    public Emprendimiento(long idemprendimiento, Estadoemprendimiento estadoemprendimiento, Tipoemprendimiento tipoemprendimiento) {
        this.idemprendimiento = idemprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
        this.tipoemprendimiento = tipoemprendimiento;
    }

    public Emprendimiento(long idemprendimiento, Cajacompensacion cajacompensacion, Estadoemprendimiento estadoemprendimiento, Integer formalizado, Tipoemprendimiento tipoemprendimiento, String nombreemprendimiento, Date fecharegistro, Set<Rutaacompanamientoat> rutaacompanamientoats, Set<Formalizado> formalizados, Set<Documentos> documentoses, Set<Noestablecido> noestablecidos, Set<Asociados> asociadoses, Set<Evaluacionemprendimientos> evaluacionemprendimientoses, Set<Financiacion> financiacions, Set<Seguimiento> seguimientos, Set<Logestadoemprendimiento> logestadoemprendimientos) {
        this.idemprendimiento = idemprendimiento;
        this.cajacompensacion = cajacompensacion;
        this.estadoemprendimiento = estadoemprendimiento;
        this.formalizado = formalizado;
        this.tipoemprendimiento = tipoemprendimiento;
        this.nombreemprendimiento = nombreemprendimiento;
        this.fecharegistro = fecharegistro;
        this.rutaacompanamientoats = rutaacompanamientoats;
        this.formalizados = formalizados;
        this.documentoses = documentoses;
        this.noestablecidos = noestablecidos;
        this.asociadoses = asociadoses;
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
        this.financiacions = financiacions;
        this.seguimientos = seguimientos;
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

    public long getIdemprendimiento() {
        return this.idemprendimiento;
    }

    public void setIdemprendimiento(long idemprendimiento) {
        this.idemprendimiento = idemprendimiento;
    }

    public Cajacompensacion getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(Cajacompensacion cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public Estadoemprendimiento getEstadoemprendimiento() {
        return this.estadoemprendimiento;
    }

    public void setEstadoemprendimiento(Estadoemprendimiento estadoemprendimiento) {
        this.estadoemprendimiento = estadoemprendimiento;
    }

    public Integer getFormalizado() {
        return this.formalizado;
    }

    public void setFormalizado(Integer formalizado) {
        this.formalizado = formalizado;
    }

    public Tipoemprendimiento getTipoemprendimiento() {
        return this.tipoemprendimiento;
    }

    public void setTipoemprendimiento(Tipoemprendimiento tipoemprendimiento) {
        this.tipoemprendimiento = tipoemprendimiento;
    }

    public String getNombreemprendimiento() {
        return this.nombreemprendimiento;
    }

    public void setNombreemprendimiento(String nombreemprendimiento) {
        this.nombreemprendimiento = nombreemprendimiento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Rutaacompanamientoat> getRutaacompanamientoats() {
        return this.rutaacompanamientoats;
    }

    public void setRutaacompanamientoats(Set<Rutaacompanamientoat> rutaacompanamientoats) {
        this.rutaacompanamientoats = rutaacompanamientoats;
    }

    public Set<Formalizado> getFormalizados() {
        return this.formalizados;
    }

    public void setFormalizados(Set<Formalizado> formalizados) {
        this.formalizados = formalizados;
    }

    public Set<Documentos> getDocumentoses() {
        return this.documentoses;
    }

    public void setDocumentoses(Set<Documentos> documentoses) {
        this.documentoses = documentoses;
    }

    public Set<Noestablecido> getNoestablecidos() {
        return this.noestablecidos;
    }

    public void setNoestablecidos(Set<Noestablecido> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

    public Set<Asociados> getAsociadoses() {
        return this.asociadoses;
    }

    public void setAsociadoses(Set<Asociados> asociadoses) {
        this.asociadoses = asociadoses;
    }

    public Set<Evaluacionemprendimientos> getEvaluacionemprendimientoses() {
        return this.evaluacionemprendimientoses;
    }

    public void setEvaluacionemprendimientoses(Set<Evaluacionemprendimientos> evaluacionemprendimientoses) {
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

    public Set<Financiacion> getFinanciacions() {
        return this.financiacions;
    }

    public void setFinanciacions(Set<Financiacion> financiacions) {
        this.financiacions = financiacions;
    }

    public Set<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(Set<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public Set<Logestadoemprendimiento> getLogestadoemprendimientos() {
        return this.logestadoemprendimientos;
    }

    public void setLogestadoemprendimientos(Set<Logestadoemprendimiento> logestadoemprendimientos) {
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

}

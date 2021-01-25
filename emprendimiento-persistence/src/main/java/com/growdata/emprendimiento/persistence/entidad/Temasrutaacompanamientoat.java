package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Temasrutaacompanamientoat implements java.io.Serializable {

    private long idtemarutaacompanamientoat;
    private Rutaacompanamientoat rutaacompanamientoat;
    private Temasevaluacion temasevaluacion;
    private Date fecharegistro;
    private BigDecimal cantidadhorasplaneadas;
    private String urldocumentotema;
    private String descripciondocumento;
    private Set<Sesionacompanamientoat> sesionacompanamientoats = new HashSet<Sesionacompanamientoat>(0);

    public Temasrutaacompanamientoat() {
    }

    public Temasrutaacompanamientoat(long idtemarutaacompanamientoat, Rutaacompanamientoat rutaacompanamientoat) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    public Temasrutaacompanamientoat(long idtemarutaacompanamientoat, Rutaacompanamientoat rutaacompanamientoat, Temasevaluacion temasevaluacion, Date fecharegistro, BigDecimal cantidadhorasplaneadas, String urldocumentotema, String descripciondocumento, Set<Sesionacompanamientoat> sesionacompanamientoats) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
        this.rutaacompanamientoat = rutaacompanamientoat;
        this.temasevaluacion = temasevaluacion;
        this.fecharegistro = fecharegistro;
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
        this.urldocumentotema = urldocumentotema;
        this.descripciondocumento = descripciondocumento;
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    public long getIdtemarutaacompanamientoat() {
        return this.idtemarutaacompanamientoat;
    }

    public void setIdtemarutaacompanamientoat(long idtemarutaacompanamientoat) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
    }

    public Rutaacompanamientoat getRutaacompanamientoat() {
        return this.rutaacompanamientoat;
    }

    public void setRutaacompanamientoat(Rutaacompanamientoat rutaacompanamientoat) {
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    public Temasevaluacion getTemasevaluacion() {
        return this.temasevaluacion;
    }

    public void setTemasevaluacion(Temasevaluacion temasevaluacion) {
        this.temasevaluacion = temasevaluacion;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getCantidadhorasplaneadas() {
        return this.cantidadhorasplaneadas;
    }

    public void setCantidadhorasplaneadas(BigDecimal cantidadhorasplaneadas) {
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
    }

    public String getUrldocumentotema() {
        return this.urldocumentotema;
    }

    public void setUrldocumentotema(String urldocumentotema) {
        this.urldocumentotema = urldocumentotema;
    }

    public String getDescripciondocumento() {
        return this.descripciondocumento;
    }

    public void setDescripciondocumento(String descripciondocumento) {
        this.descripciondocumento = descripciondocumento;
    }

    public Set<Sesionacompanamientoat> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    public void setSesionacompanamientoats(Set<Sesionacompanamientoat> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

}

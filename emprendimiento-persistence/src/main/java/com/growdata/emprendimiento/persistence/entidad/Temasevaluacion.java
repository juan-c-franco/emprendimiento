package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Temasevaluacion implements java.io.Serializable {

    private BigDecimal idtema;
    private Cajacompensacion cajacompensacion;
    private Herramientasvaloracion herramientasvaloracion;
    private String nombretema;
    private String descripcion;
    private Date fecharegistro;
    private BigDecimal horasbasico;
    private BigDecimal calificacionintermedio;
    private BigDecimal horasavanzado;
    private BigDecimal calificacionavanzado;
    private Character requieredocumento;
    private Long calificacionbasico;
    private Long horasintermedio;
    private char estado;
    private Set<Temasrutaacompanamientoat> temasrutaacompanamientoats = new HashSet<Temasrutaacompanamientoat>(0);
    private Set<Preguntas> preguntases = new HashSet<Preguntas>(0);

    public Temasevaluacion() {
    }

    public Temasevaluacion(BigDecimal idtema, Cajacompensacion cajacompensacion, Herramientasvaloracion herramientasvaloracion) {
        this.idtema = idtema;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
    }

    public Temasevaluacion(BigDecimal idtema, Cajacompensacion cajacompensacion, Herramientasvaloracion herramientasvaloracion, String nombretema, String descripcion, Date fecharegistro, BigDecimal horasbasico, BigDecimal calificacionintermedio, BigDecimal horasavanzado, BigDecimal calificacionavanzado, Character requieredocumento, Long calificacionbasico, Long horasintermedio, char estado, Set<Temasrutaacompanamientoat> temasrutaacompanamientoats, Set<Preguntas> preguntases) {
        this.idtema = idtema;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
        this.nombretema = nombretema;
        this.descripcion = descripcion;
        this.fecharegistro = fecharegistro;
        this.horasbasico = horasbasico;
        this.calificacionintermedio = calificacionintermedio;
        this.horasavanzado = horasavanzado;
        this.calificacionavanzado = calificacionavanzado;
        this.requieredocumento = requieredocumento;
        this.calificacionbasico = calificacionbasico;
        this.horasintermedio = horasintermedio;
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
        this.preguntases = preguntases;
        this.estado = estado;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public BigDecimal getIdtema() {
        return this.idtema;
    }

    public void setIdtema(BigDecimal idtema) {
        this.idtema = idtema;
    }

    public Cajacompensacion getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(Cajacompensacion cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public Herramientasvaloracion getHerramientasvaloracion() {
        return this.herramientasvaloracion;
    }

    public void setHerramientasvaloracion(Herramientasvaloracion herramientasvaloracion) {
        this.herramientasvaloracion = herramientasvaloracion;
    }

    public String getNombretema() {
        return this.nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getHorasbasico() {
        return this.horasbasico;
    }

    public void setHorasbasico(BigDecimal horasbasico) {
        this.horasbasico = horasbasico;
    }

    public BigDecimal getCalificacionintermedio() {
        return this.calificacionintermedio;
    }

    public void setCalificacionintermedio(BigDecimal calificacionintermedio) {
        this.calificacionintermedio = calificacionintermedio;
    }

    public BigDecimal getHorasavanzado() {
        return this.horasavanzado;
    }

    public void setHorasavanzado(BigDecimal horasavanzado) {
        this.horasavanzado = horasavanzado;
    }

    public BigDecimal getCalificacionavanzado() {
        return this.calificacionavanzado;
    }

    public void setCalificacionavanzado(BigDecimal calificacionavanzado) {
        this.calificacionavanzado = calificacionavanzado;
    }

    public Character getRequieredocumento() {
        return this.requieredocumento;
    }

    public void setRequieredocumento(Character requieredocumento) {
        this.requieredocumento = requieredocumento;
    }

    public Long getCalificacionbasico() {
        return this.calificacionbasico;
    }

    public void setCalificacionbasico(Long calificacionbasico) {
        this.calificacionbasico = calificacionbasico;
    }

    public Long getHorasintermedio() {
        return this.horasintermedio;
    }

    public void setHorasintermedio(Long horasintermedio) {
        this.horasintermedio = horasintermedio;
    }

    public Set<Temasrutaacompanamientoat> getTemasrutaacompanamientoats() {
        return this.temasrutaacompanamientoats;
    }

    public void setTemasrutaacompanamientoats(Set<Temasrutaacompanamientoat> temasrutaacompanamientoats) {
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
    }

    public Set<Preguntas> getPreguntases() {
        return this.preguntases;
    }

    public void setPreguntases(Set<Preguntas> preguntases) {
        this.preguntases = preguntases;
    }

}

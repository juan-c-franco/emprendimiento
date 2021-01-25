package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TemasevaluacionDTO implements java.io.Serializable {

    private BigDecimal idtema;
    private CajacompensacionDTO cajacompensacion;
    private HerramientasvaloracionDTO herramientasvaloracion;
    private String nombretema;
    private String descripcion;
    private Date fecharegistro;
    private BigDecimal horasbasico;
    private BigDecimal calificacionintermedio;
    private BigDecimal horasavanzado;
    private BigDecimal calificacionavanzado;
    private Character requieredocumento;
    private char estado;
    private Set<PreguntasDTO> preguntases = new HashSet<PreguntasDTO>(0);

    public TemasevaluacionDTO() {
    }

    public TemasevaluacionDTO(BigDecimal idtema, CajacompensacionDTO cajacompensacion, HerramientasvaloracionDTO herramientasvaloracion) {
        this.idtema = idtema;
        this.cajacompensacion = cajacompensacion;
        this.herramientasvaloracion = herramientasvaloracion;
    }

    public TemasevaluacionDTO(BigDecimal idtema, CajacompensacionDTO cajacompensacion, HerramientasvaloracionDTO herramientasvaloracion, String nombretema, String descripcion, Date fecharegistro, BigDecimal horasbasico, BigDecimal calificacionintermedio, BigDecimal horasavanzado, BigDecimal calificacionavanzado, Character requieredocumento, char estado, Set<PreguntasDTO> preguntases) {
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

    public CajacompensacionDTO getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(CajacompensacionDTO cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public HerramientasvaloracionDTO getHerramientasvaloracion() {
        return this.herramientasvaloracion;
    }

    public void setHerramientasvaloracion(HerramientasvaloracionDTO herramientasvaloracion) {
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

    public Set<PreguntasDTO> getPreguntases() {
        return this.preguntases;
    }

    public void setPreguntases(Set<PreguntasDTO> preguntases) {
        this.preguntases = preguntases;
    }

}

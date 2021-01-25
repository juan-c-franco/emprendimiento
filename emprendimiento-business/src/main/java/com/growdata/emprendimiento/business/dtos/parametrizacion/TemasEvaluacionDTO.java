package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import java.math.BigDecimal;
import java.util.Date;

public class TemasEvaluacionDTO {

    private BigDecimal idtema;
    private CajacompensacionDTO cajaCompensacionDTO;
    private HerramientaValoracionDTO herramientaValoracionDTO;
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
    //private Set<Temasrutaacompanamientoat> temasrutaacompanamientoats = new HashSet<Temasrutaacompanamientoat>(0);
    //private Set<PreguntasDTO> preguntases = new HashSet<PreguntasDTO>(0);

    public TemasEvaluacionDTO() {
    }

    public TemasEvaluacionDTO(BigDecimal idtema, CajacompensacionDTO cajaCompensacionDTO, HerramientaValoracionDTO herramientaValoracionDTO) {
        this.idtema = idtema;
        this.cajaCompensacionDTO = cajaCompensacionDTO;
        this.herramientaValoracionDTO = herramientaValoracionDTO;
    }

    public TemasEvaluacionDTO(BigDecimal idtema, CajacompensacionDTO cajaCompensacionDTO, HerramientaValoracionDTO herramientaValoracionDTO, String nombretema, String descripcion, Date fecharegistro, BigDecimal horasbasico, BigDecimal calificacionintermedio, BigDecimal horasavanzado, BigDecimal calificacionavanzado, Character requieredocumento, Long calificacionbasico, Long horasintermedio, char estado) {
        this.idtema = idtema;
        this.cajaCompensacionDTO = cajaCompensacionDTO;
        this.herramientaValoracionDTO = herramientaValoracionDTO;
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
        this.estado = estado;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public BigDecimal getIdtema() {
        return idtema;
    }

    public void setIdtema(BigDecimal idtema) {
        this.idtema = idtema;
    }

    public CajacompensacionDTO getCajaCompensacionDTO() {
        return cajaCompensacionDTO;
    }

    public void setCajaCompensacionDTO(CajacompensacionDTO cajaCompensacionDTO) {
        this.cajaCompensacionDTO = cajaCompensacionDTO;
    }

    public HerramientaValoracionDTO getHerramientaValoracionDTO() {
        return herramientaValoracionDTO;
    }

    public void setHerramientaValoracionDTO(HerramientaValoracionDTO herramientaValoracionDTO) {
        this.herramientaValoracionDTO = herramientaValoracionDTO;
    }

    public String getNombretema() {
        return nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getHorasbasico() {
        return horasbasico;
    }

    public void setHorasbasico(BigDecimal horasbasico) {
        this.horasbasico = horasbasico;
    }

    public BigDecimal getCalificacionintermedio() {
        return calificacionintermedio;
    }

    public void setCalificacionintermedio(BigDecimal calificacionintermedio) {
        this.calificacionintermedio = calificacionintermedio;
    }

    public BigDecimal getHorasavanzado() {
        return horasavanzado;
    }

    public void setHorasavanzado(BigDecimal horasavanzado) {
        this.horasavanzado = horasavanzado;
    }

    public BigDecimal getCalificacionavanzado() {
        return calificacionavanzado;
    }

    public void setCalificacionavanzado(BigDecimal calificacionavanzado) {
        this.calificacionavanzado = calificacionavanzado;
    }

    public Character getRequieredocumento() {
        return requieredocumento;
    }

    public void setRequieredocumento(Character requieredocumento) {
        this.requieredocumento = requieredocumento;
    }

    public Long getCalificacionbasico() {
        return calificacionbasico;
    }

    public void setCalificacionbasico(Long calificacionbasico) {
        this.calificacionbasico = calificacionbasico;
    }

    public Long getHorasintermedio() {
        return horasintermedio;
    }

    public void setHorasintermedio(Long horasintermedio) {
        this.horasintermedio = horasintermedio;
    }
}

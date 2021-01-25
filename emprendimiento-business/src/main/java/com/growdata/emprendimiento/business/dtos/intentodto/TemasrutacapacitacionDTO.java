package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class TemasrutacapacitacionDTO implements java.io.Serializable {

    private long idtemarutacapacitacion;
    private RutacapacitacionDTO rutacapacitacion;
    private String nombretema;
    private Date fecharregistro;
    private BigDecimal cantidadhorasplaneadas;
    private short porcentajeAprobacion;

    public TemasrutacapacitacionDTO() {
    }

    public TemasrutacapacitacionDTO(long idtemarutacapacitacion, RutacapacitacionDTO rutacapacitacion) {
        this.idtemarutacapacitacion = idtemarutacapacitacion;
        this.rutacapacitacion = rutacapacitacion;
    }

    public TemasrutacapacitacionDTO(long idtemarutacapacitacion, RutacapacitacionDTO rutacapacitacion, String nombretema, Date fecharregistro, BigDecimal cantidadhorasplaneadas) {
        this.idtemarutacapacitacion = idtemarutacapacitacion;
        this.rutacapacitacion = rutacapacitacion;
        this.nombretema = nombretema;
        this.fecharregistro = fecharregistro;
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
    }

    public long getIdtemarutacapacitacion() {
        return this.idtemarutacapacitacion;
    }

    public void setIdtemarutacapacitacion(long idtemarutacapacitacion) {
        this.idtemarutacapacitacion = idtemarutacapacitacion;
    }

    public RutacapacitacionDTO getRutacapacitacion() {
        return this.rutacapacitacion;
    }

    public void setRutacapacitacion(RutacapacitacionDTO rutacapacitacion) {
        this.rutacapacitacion = rutacapacitacion;
    }

    public String getNombretema() {
        return this.nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public Date getFecharregistro() {
        return this.fecharregistro;
    }

    public void setFecharregistro(Date fecharregistro) {
        this.fecharregistro = fecharregistro;
    }

    public BigDecimal getCantidadhorasplaneadas() {
        return this.cantidadhorasplaneadas;
    }

    public void setCantidadhorasplaneadas(BigDecimal cantidadhorasplaneadas) {
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
    }

    public short getPorcentajeAprobacion() {
        return porcentajeAprobacion;
    }

    public void setPorcentajeAprobacion(short porcentajeAprobacion) {
        this.porcentajeAprobacion = porcentajeAprobacion;
    }

}

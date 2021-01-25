package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class Temasrutacapacitacion implements java.io.Serializable {

    private long idtemarutacapacitacion;
    private Rutacapacitacion rutacapacitacion;
    private String nombretema;
    private Date fecharregistro;
    private BigDecimal cantidadhorasplaneadas;

    public Temasrutacapacitacion() {
    }

    public Temasrutacapacitacion(long idtemarutacapacitacion, Rutacapacitacion rutacapacitacion) {
        this.idtemarutacapacitacion = idtemarutacapacitacion;
        this.rutacapacitacion = rutacapacitacion;
    }

    public Temasrutacapacitacion(long idtemarutacapacitacion, Rutacapacitacion rutacapacitacion, String nombretema, Date fecharregistro, BigDecimal cantidadhorasplaneadas) {
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

    public Rutacapacitacion getRutacapacitacion() {
        return this.rutacapacitacion;
    }

    public void setRutacapacitacion(Rutacapacitacion rutacapacitacion) {
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import java.math.BigDecimal;

/**
 *
 * @author Juan Franco
 */
public class RequestCalificacionDTO {

    private BigDecimal idalumno;
    private long idmodulociclo;
    private short calificacionfinal;

    public RequestCalificacionDTO() {
    }

    public RequestCalificacionDTO(BigDecimal idalumno, short calificacionfinal) {
        this.idalumno = idalumno;
        this.calificacionfinal = calificacionfinal;
    }

    public RequestCalificacionDTO(BigDecimal idalumno, long idmodulociclo, short calificacionfinal) {
        this.idalumno = idalumno;
        this.idmodulociclo = idmodulociclo;
        this.calificacionfinal = calificacionfinal;
    }

    public BigDecimal getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(BigDecimal idalumno) {
        this.idalumno = idalumno;
    }

    public long getIdmodulociclo() {
        return idmodulociclo;
    }

    public void setIdmodulociclo(long idmodulociclo) {
        this.idmodulociclo = idmodulociclo;
    }

    public short getCalificacionfinal() {
        return calificacionfinal;
    }

    public void setCalificacionfinal(short calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

}

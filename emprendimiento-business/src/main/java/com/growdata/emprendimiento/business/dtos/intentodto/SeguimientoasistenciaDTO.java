/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juan Franco
 */
public class SeguimientoasistenciaDTO {

    private BigDecimal idseguimientoasistencia;
    private FuncionarioDTO funcionario;
    private AlumnosDTO alumnos;
    private ModulocicloDTO modulociclo;
    private short cantidadhorasasistencia;
    private Date fecharegistro;

    public SeguimientoasistenciaDTO() {
    }

    public SeguimientoasistenciaDTO(BigDecimal idseguimientoasistencia, FuncionarioDTO funcionario, AlumnosDTO alumnos, ModulocicloDTO modulociclo, short cantidadhorasasistencia, Date fecharegistro) {
        this.idseguimientoasistencia = idseguimientoasistencia;
        this.funcionario = funcionario;
        this.alumnos = alumnos;
        this.modulociclo = modulociclo;
        this.cantidadhorasasistencia = cantidadhorasasistencia;
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getIdseguimientoasistencia() {
        return idseguimientoasistencia;
    }

    public void setIdseguimientoasistencia(BigDecimal idseguimientoasistencia) {
        this.idseguimientoasistencia = idseguimientoasistencia;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public AlumnosDTO getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(AlumnosDTO alumnos) {
        this.alumnos = alumnos;
    }

    public ModulocicloDTO getModulociclo() {
        return modulociclo;
    }

    public void setModulociclo(ModulocicloDTO modulociclo) {
        this.modulociclo = modulociclo;
    }

    public short getCantidadhorasasistencia() {
        return cantidadhorasasistencia;
    }

    public void setCantidadhorasasistencia(short cantidadhorasasistencia) {
        this.cantidadhorasasistencia = cantidadhorasasistencia;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

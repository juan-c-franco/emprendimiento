/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Juan Franco
 */
public class ProgramacionDTO {

    private BigDecimal idprogramacion;
    private FuncionarioDTO funcionario;
    private EstadosesionDTO estadosesion;
    private CapacitacionprogramaDTO capacitacionprograma;
    private DocentesDTO docentes;
    private BigDecimal idInstitucion;
    private Timestamp fechainicioprogramacion;
    private Timestamp fechafinalrogramacion;
    private short maxasistentes;
    private Date fecharegistro;
    private String ubicacion;
    private Set<AlumnosDTO> alumnoses = new HashSet<AlumnosDTO>(0);

    public ProgramacionDTO() {
    }

    public ProgramacionDTO(BigDecimal idprogramacion, FuncionarioDTO funcionario, EstadosesionDTO estadosesion, CapacitacionprogramaDTO capacitacionprograma, DocentesDTO docentes, BigDecimal idInstitucion, Timestamp fechainicioprogramacion, Timestamp fechafinalrogramacion, short maxasistentes, Date fecharegistro, String ubicacion) {
        this.idprogramacion = idprogramacion;
        this.funcionario = funcionario;
        this.estadosesion = estadosesion;
        this.capacitacionprograma = capacitacionprograma;
        this.docentes = docentes;
        this.idInstitucion = idInstitucion;
        this.fechainicioprogramacion = fechainicioprogramacion;
        this.fechafinalrogramacion = fechafinalrogramacion;
        this.maxasistentes = maxasistentes;
        this.fecharegistro = fecharegistro;
        this.ubicacion = ubicacion;
    }

    public BigDecimal getIdprogramacion() {
        return idprogramacion;
    }

    public void setIdprogramacion(BigDecimal idprogramacion) {
        this.idprogramacion = idprogramacion;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public EstadosesionDTO getEstadosesion() {
        return estadosesion;
    }

    public void setEstadosesion(EstadosesionDTO estadosesion) {
        this.estadosesion = estadosesion;
    }

    public CapacitacionprogramaDTO getCapacitacionprograma() {
        return capacitacionprograma;
    }

    public void setCapacitacionprograma(CapacitacionprogramaDTO capacitacionprograma) {
        this.capacitacionprograma = capacitacionprograma;
    }

    public DocentesDTO getDocentes() {
        return docentes;
    }

    public void setDocentes(DocentesDTO docentes) {
        this.docentes = docentes;
    }

    public BigDecimal getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(BigDecimal idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Timestamp getFechainicioprogramacion() {
        return fechainicioprogramacion;
    }

    public void setFechainicioprogramacion(Timestamp fechainicioprogramacion) {
        this.fechainicioprogramacion = fechainicioprogramacion;
    }

    public Timestamp getFechafinalrogramacion() {
        return fechafinalrogramacion;
    }

    public void setFechafinalrogramacion(Timestamp fechafinalrogramacion) {
        this.fechafinalrogramacion = fechafinalrogramacion;
    }

    public short getMaxasistentes() {
        return maxasistentes;
    }

    public void setMaxasistentes(short maxasistentes) {
        this.maxasistentes = maxasistentes;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<AlumnosDTO> getAlumnoses() {
        return alumnoses;
    }

    public void setAlumnoses(Set<AlumnosDTO> alumnoses) {
        this.alumnoses = alumnoses;
    }

}

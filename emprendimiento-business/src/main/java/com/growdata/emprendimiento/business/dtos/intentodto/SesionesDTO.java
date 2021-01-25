package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SesionesDTO implements java.io.Serializable {

    private long idsesion;
    private EstadosesionDTO estadosesion;
    private FuncionarioDTO funcionario;
    private TiposesionDTO tiposesion;
    private Timestamp fechainicio;
    private Timestamp fechafinal;
    private Timestamp fecharegistro;
    private String descripcion;
    private String ubicacion;
    private long maxAsistentes;
    private Set<ListaasistenciaDTO> listaasistencias = new HashSet<ListaasistenciaDTO>(0);

    public SesionesDTO() {
    }

    public SesionesDTO(long idsesion) {
        this.idsesion = idsesion;
    }

    public SesionesDTO(long idsesion, EstadosesionDTO estadosesion, FuncionarioDTO funcionario, TiposesionDTO tiposesion) {
        this.idsesion = idsesion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.tiposesion = tiposesion;
    }

    public SesionesDTO(long idsesion, EstadosesionDTO estadosesion, FuncionarioDTO funcionario, TiposesionDTO tiposesion, Timestamp fechainicio, Timestamp fechafinal, Timestamp fecharegistro, Set<ListaasistenciaDTO> listaasistencias) {
        this.idsesion = idsesion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.tiposesion = tiposesion;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fecharegistro = fecharegistro;
        this.listaasistencias = listaasistencias;
    }

    public long getIdsesion() {
        return this.idsesion;
    }

    public void setIdsesion(long idsesion) {
        this.idsesion = idsesion;
    }

    public EstadosesionDTO getEstadosesion() {
        return this.estadosesion;
    }

    public void setEstadosesion(EstadosesionDTO estadosesion) {
        this.estadosesion = estadosesion;
    }

    public FuncionarioDTO getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public TiposesionDTO getTiposesion() {
        return this.tiposesion;
    }

    public void setTiposesion(TiposesionDTO tiposesion) {
        this.tiposesion = tiposesion;
    }

    public Date getFechainicio() {
        return this.fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechafinal() {
        return this.fechafinal;
    }

    public void setFechafinal(Timestamp fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<ListaasistenciaDTO> getListaasistencias() {
        return this.listaasistencias;
    }

    public void setListaasistencias(Set<ListaasistenciaDTO> listaasistencias) {
        this.listaasistencias = listaasistencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public long getMaxAsistentes() {
        return maxAsistentes;
    }

    public void setMaxAsistentes(long maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

}

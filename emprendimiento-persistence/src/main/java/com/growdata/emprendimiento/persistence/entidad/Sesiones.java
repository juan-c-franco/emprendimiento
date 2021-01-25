package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Sesiones implements java.io.Serializable {

    private long idsesion;
    private Estadosesion estadosesion;
    private Funcionario funcionario;
    private String descripcion;
    private Long maxAsistentes;
    private Tiposesion tiposesion;
    private Timestamp fechainicio;
    private Timestamp fechafinal;
    private Timestamp fecharegistro;
    private String ubicacion;
    private Set<Listaasistencia> listaasistencias = new HashSet<Listaasistencia>(0);

    public Sesiones() {
    }

    public Sesiones(long idsesion, Estadosesion estadosesion, Funcionario funcionario, Tiposesion tiposesion) {
        this.idsesion = idsesion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.tiposesion = tiposesion;
    }

    public Sesiones(long idsesion, Estadosesion estadosesion, Funcionario funcionario, Tiposesion tiposesion, Timestamp fechainicio, Timestamp fechafinal, Timestamp fecharegistro, Set<Listaasistencia> listaasistencias) {
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

    public Estadosesion getEstadosesion() {
        return this.estadosesion;
    }

    public void setEstadosesion(Estadosesion estadosesion) {
        this.estadosesion = estadosesion;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getMaxAsistentes() {
        return maxAsistentes;
    }

    public void setMaxAsistentes(Long maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

    public Tiposesion getTiposesion() {
        return this.tiposesion;
    }

    public void setTiposesion(Tiposesion tiposesion) {
        this.tiposesion = tiposesion;
    }

    public Timestamp getFechainicio() {
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

    public Timestamp getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Listaasistencia> getListaasistencias() {
        return this.listaasistencias;
    }

    public void setListaasistencias(Set<Listaasistencia> listaasistencias) {
        this.listaasistencias = listaasistencias;
    }

}

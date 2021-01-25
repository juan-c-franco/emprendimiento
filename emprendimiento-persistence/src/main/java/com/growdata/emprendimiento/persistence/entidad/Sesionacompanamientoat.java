package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Sesionacompanamientoat implements java.io.Serializable {

    private long idsesionacompanamientoat;
    private Estadosesion estadosesion;
    private Funcionario funcionario;
    private Rutaacompanamientoat rutaacompanamientoat;
    private Temasrutaacompanamientoat temasrutaacompanamientoat;
    private Timestamp fechainicio;
    private Timestamp fechafinal;
    private Timestamp fecharegistro;
    private String observaciones;
    private String ubicacion;
    private Set<Listaasistenciaaat> listaasistenciaaats = new HashSet<Listaasistenciaaat>(0);

    public Sesionacompanamientoat() {
    }

    public Sesionacompanamientoat(long idsesionacompanamientoat, Estadosesion estadosesion, Rutaacompanamientoat rutaacompanamientoat, Temasrutaacompanamientoat temasrutaacompanamientoat) {
        this.idsesionacompanamientoat = idsesionacompanamientoat;
        this.estadosesion = estadosesion;
        this.rutaacompanamientoat = rutaacompanamientoat;
        this.temasrutaacompanamientoat = temasrutaacompanamientoat;
    }

    public Sesionacompanamientoat(long idsesionacompanamientoat, Estadosesion estadosesion, Funcionario funcionario, Rutaacompanamientoat rutaacompanamientoat, Temasrutaacompanamientoat temasrutaacompanamientoat, Timestamp fechainicio, Timestamp fechafinal, Timestamp fecharegistro, String observaciones, String ubicacion, Set<Listaasistenciaaat> listaasistenciaaats) {
        this.idsesionacompanamientoat = idsesionacompanamientoat;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.rutaacompanamientoat = rutaacompanamientoat;
        this.temasrutaacompanamientoat = temasrutaacompanamientoat;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fecharegistro = fecharegistro;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.listaasistenciaaats = listaasistenciaaats;
    }

    public long getIdsesionacompanamientoat() {
        return this.idsesionacompanamientoat;
    }

    public void setIdsesionacompanamientoat(long idsesionacompanamientoat) {
        this.idsesionacompanamientoat = idsesionacompanamientoat;
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

    public Rutaacompanamientoat getRutaacompanamientoat() {
        return this.rutaacompanamientoat;
    }

    public void setRutaacompanamientoat(Rutaacompanamientoat rutaacompanamientoat) {
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    public Temasrutaacompanamientoat getTemasrutaacompanamientoat() {
        return this.temasrutaacompanamientoat;
    }

    public void setTemasrutaacompanamientoat(Temasrutaacompanamientoat temasrutaacompanamientoat) {
        this.temasrutaacompanamientoat = temasrutaacompanamientoat;
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

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Listaasistenciaaat> getListaasistenciaaats() {
        return this.listaasistenciaaats;
    }

    public void setListaasistenciaaats(Set<Listaasistenciaaat> listaasistenciaaats) {
        this.listaasistenciaaats = listaasistenciaaats;
    }

}

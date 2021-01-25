package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Sesioncomite implements java.io.Serializable {

    private long idsesioncomite;
    private Comiteevaluacion comiteevaluacion;
    private Estadosesion estadosesion;
    private Funcionario funcionario;
    private Timestamp fechainicio;
    private Timestamp fechafinal;
    private Timestamp fecharegistro;
    private String urlacta;
    private Set<Evaluacionemprendimientos> evaluacionemprendimientoses = new HashSet<Evaluacionemprendimientos>(0);
    private String ubicacion;

    public Sesioncomite() {
    }

    public Sesioncomite(long idsesioncomite, Comiteevaluacion comiteevaluacion, Estadosesion estadosesion, Funcionario funcionario) {
        this.idsesioncomite = idsesioncomite;
        this.comiteevaluacion = comiteevaluacion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
    }

    public Sesioncomite(long idsesioncomite, Comiteevaluacion comiteevaluacion, Estadosesion estadosesion, Funcionario funcionario, Timestamp fechainicio, Timestamp fechafinal, Timestamp fecharegistro, String urlacta, String ubicacion) {
        this.idsesioncomite = idsesioncomite;
        this.comiteevaluacion = comiteevaluacion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fecharegistro = fecharegistro;
        this.urlacta = urlacta;
        this.ubicacion = ubicacion;
    }

    public long getIdsesioncomite() {
        return idsesioncomite;
    }

    public void setIdsesioncomite(long idsesioncomite) {
        this.idsesioncomite = idsesioncomite;
    }

    public Comiteevaluacion getComiteevaluacion() {
        return comiteevaluacion;
    }

    public void setComiteevaluacion(Comiteevaluacion comiteevaluacion) {
        this.comiteevaluacion = comiteevaluacion;
    }

    public Estadosesion getEstadosesion() {
        return estadosesion;
    }

    public void setEstadosesion(Estadosesion estadosesion) {
        this.estadosesion = estadosesion;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Timestamp fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getUrlacta() {
        return urlacta;
    }

    public void setUrlacta(String urlacta) {
        this.urlacta = urlacta;
    }

    public Set<Evaluacionemprendimientos> getEvaluacionemprendimientoses() {
        return evaluacionemprendimientoses;
    }

    public void setEvaluacionemprendimientoses(Set<Evaluacionemprendimientos> evaluacionemprendimientoses) {
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class Evaluacionintegrantescomite implements java.io.Serializable {

    private long idevaluacionintegrante;
    private Evaluacionemprendimientos evaluacionemprendimientos;
    private Funcionario funcionario;
    private Date fecharegistro;
    private BigDecimal calificacionindividual;
    private String observaciones;

    public Evaluacionintegrantescomite() {
    }

    public Evaluacionintegrantescomite(long idevaluacionintegrante, Evaluacionemprendimientos evaluacionemprendimientos, Funcionario funcionario) {
        this.idevaluacionintegrante = idevaluacionintegrante;
        this.evaluacionemprendimientos = evaluacionemprendimientos;
        this.funcionario = funcionario;
    }

    public Evaluacionintegrantescomite(long idevaluacionintegrante, Evaluacionemprendimientos evaluacionemprendimientos, Funcionario funcionario, Date fecharegistro, BigDecimal calificacionindividual, String observaciones) {
        this.idevaluacionintegrante = idevaluacionintegrante;
        this.evaluacionemprendimientos = evaluacionemprendimientos;
        this.funcionario = funcionario;
        this.fecharegistro = fecharegistro;
        this.calificacionindividual = calificacionindividual;
        this.observaciones = observaciones;
    }

    public long getIdevaluacionintegrante() {
        return this.idevaluacionintegrante;
    }

    public void setIdevaluacionintegrante(long idevaluacionintegrante) {
        this.idevaluacionintegrante = idevaluacionintegrante;
    }

    public Evaluacionemprendimientos getEvaluacionemprendimientos() {
        return this.evaluacionemprendimientos;
    }

    public void setEvaluacionemprendimientos(Evaluacionemprendimientos evaluacionemprendimientos) {
        this.evaluacionemprendimientos = evaluacionemprendimientos;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getCalificacionindividual() {
        return this.calificacionindividual;
    }

    public void setCalificacionindividual(BigDecimal calificacionindividual) {
        this.calificacionindividual = calificacionindividual;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class Integrantescomite implements java.io.Serializable {

    private BigDecimal idintegrante;
    private Comiteevaluacion comiteevaluacion;
    private Funcionario funcionario;
    private Date fecharegistro;

    public Integrantescomite() {
    }

    public Integrantescomite(BigDecimal idintegrante, Comiteevaluacion comiteevaluacion, Funcionario funcionario) {
        this.idintegrante = idintegrante;
        this.comiteevaluacion = comiteevaluacion;
        this.funcionario = funcionario;
    }

    public Integrantescomite(BigDecimal idintegrante, Comiteevaluacion comiteevaluacion, Funcionario funcionario, Date fecharegistro) {
        this.idintegrante = idintegrante;
        this.comiteevaluacion = comiteevaluacion;
        this.funcionario = funcionario;
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getIdintegrante() {
        return this.idintegrante;
    }

    public void setIdintegrante(BigDecimal idintegrante) {
        this.idintegrante = idintegrante;
    }

    public Comiteevaluacion getComiteevaluacion() {
        return this.comiteevaluacion;
    }

    public void setComiteevaluacion(Comiteevaluacion comiteevaluacion) {
        this.comiteevaluacion = comiteevaluacion;
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

}

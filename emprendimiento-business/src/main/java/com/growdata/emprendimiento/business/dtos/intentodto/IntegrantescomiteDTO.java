package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class IntegrantescomiteDTO implements java.io.Serializable {

    private BigDecimal idintegrantes;
    private ComiteevaluacionDTO comiteevaluacion;
    private FuncionarioDTO funcionario;
    private Date fecharegistro;

    public IntegrantescomiteDTO() {
    }

    public IntegrantescomiteDTO(BigDecimal idintegrantes, ComiteevaluacionDTO comiteevaluacion, FuncionarioDTO funcionario) {
        this.idintegrantes = idintegrantes;
        this.comiteevaluacion = comiteevaluacion;
        this.funcionario = funcionario;
    }

    public IntegrantescomiteDTO(BigDecimal idintegrantes, ComiteevaluacionDTO comiteevaluacion, FuncionarioDTO funcionario, Date fecharegistro) {
        this.idintegrantes = idintegrantes;
        this.comiteevaluacion = comiteevaluacion;
        this.funcionario = funcionario;
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getIdintegrantes() {
        return this.idintegrantes;
    }

    public void setIdintegrantes(BigDecimal idintegrantes) {
        this.idintegrantes = idintegrantes;
    }

    public ComiteevaluacionDTO getComiteevaluacion() {
        return this.comiteevaluacion;
    }

    public void setComiteevaluacion(ComiteevaluacionDTO comiteevaluacion) {
        this.comiteevaluacion = comiteevaluacion;
    }

    public FuncionarioDTO getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}

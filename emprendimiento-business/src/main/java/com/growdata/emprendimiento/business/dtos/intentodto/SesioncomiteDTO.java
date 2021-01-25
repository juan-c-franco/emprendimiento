package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class SesioncomiteDTO implements java.io.Serializable {

    private long idsesioncomite;
    private ComiteevaluacionDTO comiteevaluacion;
    private EstadosesionDTO estadosesion;
    private FuncionarioDTO funcionario;
    private Timestamp fechainicio;
    private Timestamp fechafinal;
    private Timestamp fecharegistro;
    private String urlacta;
    private Set<EvaluacionemprendimientoDTO> evaluacionemprendimientoses = new HashSet<EvaluacionemprendimientoDTO>(0);
    private String ubicacion;

    public SesioncomiteDTO() {
    }

    public SesioncomiteDTO(long idsesioncomite, ComiteevaluacionDTO comiteevaluacion, EstadosesionDTO estadosesion, FuncionarioDTO funcionario) {
        this.idsesioncomite = idsesioncomite;
        this.comiteevaluacion = comiteevaluacion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
    }

    public SesioncomiteDTO(long idsesioncomite, ComiteevaluacionDTO comiteevaluacion, EstadosesionDTO estadosesion, FuncionarioDTO funcionario, Timestamp fechainicio, Timestamp fechafinal, Timestamp fecharegistro, String urlacta) {
        this.idsesioncomite = idsesioncomite;
        this.comiteevaluacion = comiteevaluacion;
        this.estadosesion = estadosesion;
        this.funcionario = funcionario;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fecharegistro = fecharegistro;
        this.urlacta = urlacta;
    }

    public long getIdsesioncomite() {
        return idsesioncomite;
    }

    public void setIdsesioncomite(long idsesioncomite) {
        this.idsesioncomite = idsesioncomite;
    }

    public ComiteevaluacionDTO getComiteevaluacion() {
        return comiteevaluacion;
    }

    public void setComiteevaluacion(ComiteevaluacionDTO comiteevaluacion) {
        this.comiteevaluacion = comiteevaluacion;
    }

    public EstadosesionDTO getEstadosesion() {
        return estadosesion;
    }

    public void setEstadosesion(EstadosesionDTO estadosesion) {
        this.estadosesion = estadosesion;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
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

    public Set<EvaluacionemprendimientoDTO> getEvaluacionemprendimientoses() {
        return evaluacionemprendimientoses;
    }

    public void setEvaluacionemprendimientoses(Set<EvaluacionemprendimientoDTO> evaluacionemprendimientoses) {
        this.evaluacionemprendimientoses = evaluacionemprendimientoses;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}

package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Caja de Compensaci�n.
 *
 * @author Juan Franco
 */
public class CajacompensacionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idcajacompensacion;
    /**
     * Estado de la caja de compensaci�n.
     */
    private EstadocajacompensacionDTO estadocajacompensacion;
    /**
     * Nombre de la caja de compensaci�n.
     */
    private String nombrecajacompensacion;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * C�digo de la caja de compensaci�n.
     */
    private String codigoccf;
    /**
     * Departamento.
     */
    private String departamento;
    /**
     * Temas de evaluaci�n
     */
    private Set<TemasevaluacionDTO> temasevaluacions
            = new HashSet<TemasevaluacionDTO>(0);
    /**
     * Funcionarios.
     */
    private Set<FuncionarioDTO> funcionarios = new HashSet<FuncionarioDTO>(0);
    /**
     * Comite de evaluaci�n.
     */
    private Set<ComiteevaluacionDTO> comiteevaluacions
            = new HashSet<ComiteevaluacionDTO>(0);
    /**
     * Emprendimientos.
     */
    private Set<EmprendimientoDTO> emprendimientos
            = new HashSet<EmprendimientoDTO>(0);
    /**
     * Preguntas.
     */
    private Set<PreguntasDTO> preguntases = new HashSet<PreguntasDTO>(0);

    /**
     * Constructor.
     */
    public CajacompensacionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idcajacompensacion Identificador.
     * @param estadocajacompensacion Estado de la caja.
     * @param nombrecajacompensacion Nombre de la caja compensaci�n.
     * @param fecharegistro Fecha de registro.
     * @param codigoccf Codigo caja de compensaci�n.
     * @param departamento Departamento.
     */
    public CajacompensacionDTO(BigDecimal idcajacompensacion,
            EstadocajacompensacionDTO estadocajacompensacion,
            String nombrecajacompensacion, Date fecharegistro,
            String codigoccf, String departamento) {
        this.idcajacompensacion = idcajacompensacion;
        this.estadocajacompensacion = estadocajacompensacion;
        this.nombrecajacompensacion = nombrecajacompensacion;
        this.fecharegistro = fecharegistro;
        this.codigoccf = codigoccf;
        this.departamento = departamento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idcajacompensacion Valor a ser actualizado.
     */
    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadocajacompensacionDTO getEstadocajacompensacion() {
        return estadocajacompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadocajacompensacion Valor a ser actualizado.
     */
    public void setEstadocajacompensacion(
            EstadocajacompensacionDTO estadocajacompensacion) {
        this.estadocajacompensacion = estadocajacompensacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombrecajacompensacion() {
        return nombrecajacompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombrecajacompensacion Valor a ser actualizado.
     */
    public void setNombrecajacompensacion(String nombrecajacompensacion) {
        this.nombrecajacompensacion = nombrecajacompensacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getCodigoccf() {
        return codigoccf;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param codigoccf Valor a ser actualizado.
     */
    public void setCodigoccf(String codigoccf) {
        this.codigoccf = codigoccf;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param departamento Valor a ser actualizado.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<TemasevaluacionDTO> getTemasevaluacions() {
        return temasevaluacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasevaluacions Valor a ser actualizado.
     */
    public void setTemasevaluacions(Set<TemasevaluacionDTO> temasevaluacions) {
        this.temasevaluacions = temasevaluacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param funcionarios Valor a ser actualizado.
     */
    public void setFuncionarios(Set<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ComiteevaluacionDTO> getComiteevaluacions() {
        return comiteevaluacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param comiteevaluacions Valor a ser actualizado.
     */
    public void setComiteevaluacions(
            Set<ComiteevaluacionDTO> comiteevaluacions) {
        this.comiteevaluacions = comiteevaluacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EmprendimientoDTO> getEmprendimientos() {
        return emprendimientos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimientos Valor a ser actualizado.
     */
    public void setEmprendimientos(Set<EmprendimientoDTO> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<PreguntasDTO> getPreguntases() {
        return preguntases;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param preguntases Valor a ser actualizado.
     */
    public void setPreguntases(Set<PreguntasDTO> preguntases) {
        this.preguntases = preguntases;
    }

}

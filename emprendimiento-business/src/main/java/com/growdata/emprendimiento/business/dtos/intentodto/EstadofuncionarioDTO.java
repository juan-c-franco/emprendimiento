package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Estadofuncionario.
 *
 * @author Juan Franco
 */
public class EstadofuncionarioDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idestadofuncionario;
    /**
     * Nombre del estado.
     */
    private String nombreestado;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Funcionarios.
     */
    private Set<FuncionarioDTO> funcionarios = new HashSet<FuncionarioDTO>(0);

    /**
     * Constructor.
     */
    public EstadofuncionarioDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadofuncionario Identificador.
     * @param nombreestado Nombre del estado.
     * @param descripcion Descripci�n.
     */
    public EstadofuncionarioDTO(BigDecimal idestadofuncionario,
            String nombreestado, String descripcion) {
        this.idestadofuncionario = idestadofuncionario;
        this.nombreestado = nombreestado;
        this.descripcion = descripcion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadofuncionario() {
        return idestadofuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idestadofuncionario Valor a ser actualizado.
     */
    public void setIdestadofuncionario(BigDecimal idestadofuncionario) {
        this.idestadofuncionario = idestadofuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestado() {
        return nombreestado;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreestado Valor a ser actualizado.
     */
    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

}

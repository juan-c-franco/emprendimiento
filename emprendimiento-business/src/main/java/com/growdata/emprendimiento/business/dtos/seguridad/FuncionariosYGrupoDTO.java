package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.EstadofuncionarioDTO;

/**
 * Clase contenedora de los datos de un funcionario y grupo al que pertenece.
 *
 * @author Juan Franco
 */
public class FuncionariosYGrupoDTO {

    /**
     * Identificador del funcionario.
     */
    private long idfuncionario;
    /**
     * Primer nombre.
     */
    private String primernombre;
    /**
     * Primer apellido.
     */
    private String primerapellido;
    /**
     * Segundo nombre.
     */
    private String segundonombre;
    /**
     * Segundo apellido.
     */
    private String segundoapellido;
    /**
     * Número de documento.
     */
    private String numerodocumento;
    /**
     * Estado del funcionario.
     */
    private EstadofuncionarioDTO estadofuncionario;
    /**
     * Nombre del grupo.
     */
    private String groupName;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idfuncionario Valor a ser actualizado.
     */
    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimernombre() {
        return primernombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primernombre Valor a ser actualizado.
     */
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimerapellido() {
        return primerapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primerapellido Valor a ser actualizado.
     */
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundonombre() {
        return segundonombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundonombre Valor a ser actualizado.
     */
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundoapellido() {
        return segundoapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundoapellido Valor a ser actualizado.
     */
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param numerodocumento Valor a ser actualizado.
     */
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadofuncionarioDTO getEstadofuncionario() {
        return estadofuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadofuncionario Valor a ser actualizado.
     */
    public void setEstadofuncionario(EstadofuncionarioDTO estadofuncionario) {
        this.estadofuncionario = estadofuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param groupName Valor a ser actualizado.
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}

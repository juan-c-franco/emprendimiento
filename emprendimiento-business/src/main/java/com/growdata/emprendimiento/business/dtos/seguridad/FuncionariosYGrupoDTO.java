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
     * N�mero de documento.
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
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idfuncionario Valor a ser actualizado.
     */
    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimernombre() {
        return primernombre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param primernombre Valor a ser actualizado.
     */
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimerapellido() {
        return primerapellido;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param primerapellido Valor a ser actualizado.
     */
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundonombre() {
        return segundonombre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param segundonombre Valor a ser actualizado.
     */
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundoapellido() {
        return segundoapellido;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param segundoapellido Valor a ser actualizado.
     */
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param numerodocumento Valor a ser actualizado.
     */
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadofuncionarioDTO getEstadofuncionario() {
        return estadofuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadofuncionario Valor a ser actualizado.
     */
    public void setEstadofuncionario(EstadofuncionarioDTO estadofuncionario) {
        this.estadofuncionario = estadofuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param groupName Valor a ser actualizado.
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}

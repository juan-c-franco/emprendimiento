package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import java.math.BigDecimal;

/**
 * Clase solicitud modificar funcionario.
 *
 * @author Juan Franco
 */
public class RequestModificarFuncionario2 {

    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionarioDTO;
    /**
     * Identificador estado funcionario.
     */
    private BigDecimal idestadofuncionario;
    /**
     * Identificador.
     */
    private int id;
    /**
     * Tipo de documento.
     */
    private BigDecimal idtipodocumento;
    /**
     * Contraseña.
     */
    private String contr;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getContr() {
        return contr;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param contr Valor a ser actualizado.
     */
    public void setContr(String contr) {
        this.contr = contr;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionarioDTO() {
        return funcionarioDTO;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param funcionarioDTO Valor a ser actualizado.
     */
    public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        this.funcionarioDTO = funcionarioDTO;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadofuncionario() {
        return idestadofuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idestadofuncionario Valor a ser actualizado.
     */
    public void setIdestadofuncionario(BigDecimal idestadofuncionario) {
        this.idestadofuncionario = idestadofuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public int getId() {
        return id;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdtipodocumento() {
        return idtipodocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idtipodocumento Valor a ser actualizado.
     */
    public void setIdtipodocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

}

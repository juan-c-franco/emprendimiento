package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import java.math.BigDecimal;

/**
 * Clase solicitud registrar funcionario.
 *
 * @author Juan Franco
 */
public class RequestRegistrarFuncionario {

    /**
     * Datos del funcionario.
     */
    private FuncionarioDTO funcionarioDTO;
    /**
     * Identificador estado del funcionario.
     */
    private BigDecimal idestadofuncionario;
    /**
     * Identificador.
     */
    private int id;
    /**
     * Identificador tipo de documento.
     */
    private BigDecimal idtipodocumento;
    /**
     * Identificador caja de compensación.
     */
    private BigDecimal idcajacompensacion;

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

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idcajacompensacion Valor a ser actualizado.
     */
    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

}

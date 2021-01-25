package com.growdata.emprendimiento.business.dtos.seguridad;

import java.math.BigDecimal;

/**
 * Clase solicitud para traer funcionarios por grupo y ccf.
 *
 * @author Juan Franco
 */
public class RequestTraerFuncionariosPorGrupoCaja {

    /**
     * Grupo.
     */
    private String grupo;
    /**
     * Identificador CCF.
     */
    private BigDecimal idCajaCompensacion;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param grupo Valor a ser actualizado.
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idCajaCompensacion Valor a ser actualizado.
     */
    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

}

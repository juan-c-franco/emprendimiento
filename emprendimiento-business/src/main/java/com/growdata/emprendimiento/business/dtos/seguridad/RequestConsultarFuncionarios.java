package com.growdata.emprendimiento.business.dtos.seguridad;

import java.math.BigDecimal;

/**
 * Clase solicitud consultar funcionarios.
 *
 * @author Juan Franco
 */
public class RequestConsultarFuncionarios {

    /**
     * Identificador caja de compensación.
     */
    private BigDecimal idcajacompensacion;

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

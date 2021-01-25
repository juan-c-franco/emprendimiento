package com.growdata.emprendimiento.business.dtos.evaluacion;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase solicitud emprendimientos por caja.
 *
 * @author Juan Franco
 */
public class RequestGetEmprendimientoPorDocYCajaPocosDatos {

    /**
     * Estados del emprendimiento.
     */
    private List<String> estados;

    /**
     * Identificador de la caja de compensaci�n.
     */
    private BigDecimal idcajacompensacion;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstados() {
        return estados;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estados Valor a ser actualizado.
     */
    public void setEstados(List<String> estados) {
        this.estados = estados;
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

}

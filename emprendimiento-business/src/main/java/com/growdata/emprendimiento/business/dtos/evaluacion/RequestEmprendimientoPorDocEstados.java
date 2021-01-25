package com.growdata.emprendimiento.business.dtos.evaluacion;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase solicitud emprendimientos por estados.
 *
 * @author Juan Franco
 */
public class RequestEmprendimientoPorDocEstados {

    /**
     * Número de identificación.
     */
    private String doc;
    /**
     * Estados de los emprendimientos.
     */
    private List<String> estados;
    /**
     * Identificador de la caja de compensación.
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
     * @param id Valor a ser actualizado.
     */
    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDoc() {
        return doc;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstados() {
        return estados;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

}

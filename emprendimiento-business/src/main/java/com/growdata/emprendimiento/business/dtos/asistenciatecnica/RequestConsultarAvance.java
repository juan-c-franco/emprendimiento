package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase solicitud consultar avance.
 *
 * @author Juan Franco
 */
public class RequestConsultarAvance {

    /**
     * EStados emprendimientos.
     */
    private List<String> estadosEmprendimiento;
    /**
     * Estados sesiones.
     */
    private List<String> estadosSesion;
    /**
     * Número documento beneficiario.
     */
    private String numeroDocumentoBen;
    /**
     * Identificador del asistente técnico.
     */
    private long idAsistenteTecnico;
    /**
     * Identificador de la caja de compensación.
     */
    private BigDecimal idCajaCompensacion;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosEmprendimiento() {
        return estadosEmprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadosEmprendimiento Valor a ser actualizado.
     */
    public void setEstadosEmprendimiento(List<String> estadosEmprendimiento) {
        this.estadosEmprendimiento = estadosEmprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosSesion() {
        return estadosSesion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadosSesion Valor a ser actualizado.
     */
    public void setEstadosSesion(List<String> estadosSesion) {
        this.estadosSesion = estadosSesion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumeroDocumentoBen() {
        return numeroDocumentoBen;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param numeroDocumentoBen Valor a ser actualizado.
     */
    public void setNumeroDocumentoBen(String numeroDocumentoBen) {
        this.numeroDocumentoBen = numeroDocumentoBen;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdAsistenteTecnico() {
        return idAsistenteTecnico;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idAsistenteTecnico Valor a ser actualizado.
     */
    public void setIdAsistenteTecnico(long idAsistenteTecnico) {
        this.idAsistenteTecnico = idAsistenteTecnico;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idCajaCompensacion Valor a ser actualizado.
     */
    public void setIdCajaCompensacion(BigDecimal idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }
}

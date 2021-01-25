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
     * N�mero documento beneficiario.
     */
    private String numeroDocumentoBen;
    /**
     * Identificador del asistente t�cnico.
     */
    private long idAsistenteTecnico;
    /**
     * Identificador de la caja de compensaci�n.
     */
    private BigDecimal idCajaCompensacion;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosEmprendimiento() {
        return estadosEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadosEmprendimiento Valor a ser actualizado.
     */
    public void setEstadosEmprendimiento(List<String> estadosEmprendimiento) {
        this.estadosEmprendimiento = estadosEmprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosSesion() {
        return estadosSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadosSesion Valor a ser actualizado.
     */
    public void setEstadosSesion(List<String> estadosSesion) {
        this.estadosSesion = estadosSesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumeroDocumentoBen() {
        return numeroDocumentoBen;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param numeroDocumentoBen Valor a ser actualizado.
     */
    public void setNumeroDocumentoBen(String numeroDocumentoBen) {
        this.numeroDocumentoBen = numeroDocumentoBen;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdAsistenteTecnico() {
        return idAsistenteTecnico;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idAsistenteTecnico Valor a ser actualizado.
     */
    public void setIdAsistenteTecnico(long idAsistenteTecnico) {
        this.idAsistenteTecnico = idAsistenteTecnico;
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

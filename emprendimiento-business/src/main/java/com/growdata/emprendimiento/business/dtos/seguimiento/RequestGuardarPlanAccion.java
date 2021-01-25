package com.growdata.emprendimiento.business.dtos.seguimiento;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase solicitud guardar plan de acción.
 *
 * @author Juan Franco
 */
public class RequestGuardarPlanAccion {

    /**
     * Identificador del beneficiario.
     */
    private long idBeneficiario;
    /**
     * Identificador del emprendimiento.
     */
    private long idEmprendimiento;
    /**
     * Identificador del tipo de documento.
     */
    private BigDecimal idTipoDocumento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * URL del documento.
     */
    private String urlarchivo;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdBeneficiario() {
        return idBeneficiario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idBeneficiario Valor a ser actualizado.
     */
    public void setIdBeneficiario(long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idEmprendimiento Valor a ser actualizado.
     */
    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idTipoDocumento Valor a ser actualizado.
     */
    public void setIdTipoDocumento(BigDecimal idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUrlarchivo() {
        return urlarchivo;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param urlarchivo Valor a ser actualizado.
     */
    public void setUrlarchivo(String urlarchivo) {
        this.urlarchivo = urlarchivo;
    }

}

package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.math.BigDecimal;

/**
 * Clase solicitud documentos.
 *
 * @author Juan Franco
 */
public class RequestTraerDocumentos {

    /**
     * Identificador del emprendimiento.
     */
    private long idEmprendimiento;
    /**
     * Identificador tipo de documento.
     */
    private BigDecimal idTipoDocumento;

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
}

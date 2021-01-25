package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.util.List;

/**
 * Clase solicitud beneficiario temas ruta.
 *
 * @author Juan Franco
 */
public class RequestTraerBeneEmprTemasPorDocBeneficiario {

    /**
     * Estado del emprendimiento.
     */
    private List<String> estadosEmprendimiento;

    /**
     * N�mero de documento del beneficiario.
     */
    private String numeroDocumentoBen;

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
}

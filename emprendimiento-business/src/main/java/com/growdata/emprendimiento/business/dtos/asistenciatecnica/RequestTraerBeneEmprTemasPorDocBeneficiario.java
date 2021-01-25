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
     * Número de documento del beneficiario.
     */
    private String numeroDocumentoBen;

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
}

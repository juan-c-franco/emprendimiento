package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.List;

/**
 * Clase que representa un emprendimiento al consultar avance.
 *
 * @author Juan Franco
 */
public class ConsultarAvanceComplexDTO {

    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Lista de temas ruta AAT.
     */
    private List<TemasrutaacompanamientoatDTO> temasRutasAAT;
    /**
     * Lista de beneficiarios.
     */
    private List<BeneficiarioAATDTO> beneficiarios;
    /**
     * Indica si el documento esta establecido o no.
     */
    private boolean docSet;
    /**
     * Lista de los avances.
     */
    private List<Short> porcentajesAprobacion;
    /**
     * Indica si se debe permitir aprobar.
     */
    private boolean permiteAprobar;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return emprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TemasrutaacompanamientoatDTO> getTemasRutasAAT() {
        return temasRutasAAT;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param temasRutasAAT Valor a ser actualizado.
     */
    public void setTemasRutasAAT(
            List<TemasrutaacompanamientoatDTO> temasRutasAAT) {
        this.temasRutasAAT = temasRutasAAT;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<BeneficiarioAATDTO> getBeneficiarios() {
        return beneficiarios;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param beneficiarios Valor a ser actualizado.
     */
    public void setBeneficiarios(List<BeneficiarioAATDTO> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public boolean isDocSet() {
        return docSet;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param docSet Valor a ser actualizado.
     */
    public void setDocSet(boolean docSet) {
        this.docSet = docSet;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<Short> getPorcentajesAprobacion() {
        return porcentajesAprobacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param porcentajesAprobacion Valor a ser actualizado.
     */
    public void setPorcentajesAprobacion(List<Short> porcentajesAprobacion) {
        this.porcentajesAprobacion = porcentajesAprobacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public boolean isPermiteAprobar() {
        return permiteAprobar;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param permiteAprobar Valor a ser actualizado.
     */
    public void setPermiteAprobar(boolean permiteAprobar) {
        this.permiteAprobar = permiteAprobar;
    }

}

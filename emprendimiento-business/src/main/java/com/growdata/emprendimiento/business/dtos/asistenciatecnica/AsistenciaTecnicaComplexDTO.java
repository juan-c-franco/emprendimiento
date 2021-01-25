package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.util.List;

/**
 * Clase con datos de asistencia técnica.
 *
 * @author Juan Franco
 */
public class AsistenciaTecnicaComplexDTO {

    /**
     * Datos del beneficiario.
     */
    private BeneficiarioAATDTO beneficiarioAAT;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoAATDTO emprendimientoAAT;
    /**
     * Lista temas ruta acompañamiento.
     */
    private List<TemasrutaacompanamientoatDTO> temasRutasAAT;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioAATDTO getBeneficiarioAAT() {
        return beneficiarioAAT;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param beneficiarioAAT Valor a ser actualizado.
     */
    public void setBeneficiarioAAT(BeneficiarioAATDTO beneficiarioAAT) {
        this.beneficiarioAAT = beneficiarioAAT;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoAATDTO getEmprendimientoAAT() {
        return emprendimientoAAT;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param emprendimientoAAT Valor a ser actualizado.
     */
    public void setEmprendimientoAAT(EmprendimientoAATDTO emprendimientoAAT) {
        this.emprendimientoAAT = emprendimientoAAT;
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
}

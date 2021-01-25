package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.List;

/**
 * Clase solicitud actualizar emprendimiento.
 *
 * @author Juan Franco
 */
public class RequestActualizarEmprendimiento {

    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Lista de beneficiarios.
     */
    private List<BeneficiarioAATDTO> beneficiarios;

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
}

package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 * Clase respuesta asociados a emprendimiento.
 *
 * @author Juan Franco
 */
public class ResponseAsociadosPorEmprendimiento extends ResponseDTO {

    /**
     * Lista de beneficiarios asociados.
     */
    private List<BeneficiarioAATDTO> beneficiarios;

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

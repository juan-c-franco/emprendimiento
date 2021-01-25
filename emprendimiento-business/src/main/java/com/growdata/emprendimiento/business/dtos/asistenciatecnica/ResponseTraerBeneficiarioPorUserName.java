package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;

/**
 * Clase respuesta beneficiario.
 *
 * @author Juan Franco
 */
public class ResponseTraerBeneficiarioPorUserName extends ResponseDTO {

    /**
     * Beneficiario.
     */
    private BeneficiarioDTO beneficiario;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param beneficiario Valor a ser actualizado.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }
}

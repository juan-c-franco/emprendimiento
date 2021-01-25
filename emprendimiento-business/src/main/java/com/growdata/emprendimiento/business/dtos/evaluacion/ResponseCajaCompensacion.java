package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta caja de compensación.
 *
 * @author Juan Franco
 */
public class ResponseCajaCompensacion extends ResponseDTO {

    /**
     * Datos caja de compensación.
     */
    private CajacompensacionDTO caja;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public CajacompensacionDTO getCaja() {
        return caja;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param caja Valor a ser actualizado.
     */
    public void setCaja(CajacompensacionDTO caja) {
        this.caja = caja;
    }
}

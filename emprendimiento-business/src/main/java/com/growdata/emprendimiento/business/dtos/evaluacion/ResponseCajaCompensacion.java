package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 * Clase respuesta caja de compensaci�n.
 *
 * @author Juan Franco
 */
public class ResponseCajaCompensacion extends ResponseDTO {

    /**
     * Datos caja de compensaci�n.
     */
    private CajacompensacionDTO caja;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public CajacompensacionDTO getCaja() {
        return caja;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param caja Valor a ser actualizado.
     */
    public void setCaja(CajacompensacionDTO caja) {
        this.caja = caja;
    }
}

package com.growdata.emprendimiento.business.dtos.seguridad;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import java.util.List;

/**
 * Clase respuesta sesiones.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesiones extends ResponseDTO {

    /**
     * Sesiones.
     */
    private List<SesionesDTO> sesiones;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<SesionesDTO> getSesiones() {
        return sesiones;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesiones Valor a ser actualizado.
     */
    public void setSesiones(List<SesionesDTO> sesiones) {
        this.sesiones = sesiones;
    }

}

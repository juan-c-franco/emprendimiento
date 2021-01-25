package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesioncomiteDTO;
import java.util.List;

/**
 * Clase respuesta sesiones comité.
 *
 * @author Juan Franco
 */
public class ResponseTraerSesionesComite extends ResponseDTO {

    /**
     * Sesiones comité.
     */
    private List<SesioncomiteDTO> sesiones;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<SesioncomiteDTO> getSesiones() {
        return sesiones;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesiones Valor a ser actualizado.
     */
    public void setSesiones(List<SesioncomiteDTO> sesiones) {
        this.sesiones = sesiones;
    }
}

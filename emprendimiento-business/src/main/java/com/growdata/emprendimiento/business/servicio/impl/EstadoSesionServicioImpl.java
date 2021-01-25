package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoSesionPorNombre;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoSesionPorNombre;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;
import com.growdata.emprendimiento.business.servicio.EstadoSesionServicio;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.DAO.EstadoSesionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoSesionServicioImpl implements EstadoSesionServicio {

    @Autowired
    private EstadoSesionDAO estadoSesionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio encargado de ubicar las entidades Estadosesion a través de su nombre.
     *
     * @param requestTraerEstadoSesion Nombre del Estado de la sesión
     * @return EstadoSesion que cumpla con los criterios de búsqueda.
     */
    @Override
    public ResponseTraerEstadoSesionPorNombre getEstadoSesion(RequestTraerEstadoSesionPorNombre requestTraerEstadoSesion) {
        ResponseTraerEstadoSesionPorNombre response = new ResponseTraerEstadoSesionPorNombre();
        try {
            Estadosesion estadoSesion = estadoSesionDAO.getEstadoSesion(requestTraerEstadoSesion.getNombreEstadoSesion());
            if (estadoSesion != null) {
                EstadosesionDTO estadoSesionDTO = EntityToDTO.estadoSesionToEstadoSesionDTO(estadoSesion);
                response.setEstadoSesionDTO(estadoSesionDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_ESTADO_SESION);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ESTADO_SESION);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_ESTADO_SESION);
        }
        return response;
    }
}

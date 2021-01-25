package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponseActividadInternacional;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.ActividadInternacionalDTO;
import com.growdata.emprendimiento.business.servicio.ActividadInternacionalServicio;
import com.growdata.emprendimiento.persistence.DAO.ActividadInternacionalDAO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/11/2018
 */
@Service
public class ActividadInternacionalServicioImpl implements ActividadInternacionalServicio {

    @Autowired
    private ActividadInternacionalDAO actividadInternacionalDAO;

    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio para ubicar todos las Actividades Internacionales.
     *
     * @return Respuesta si fue exitósa o no la búsqueda, y lista de Actividades
     * Internacionales.
     */
    @Override
    public ResponseActividadInternacional getActividadesInternacionales() {
        ResponseActividadInternacional response = new ResponseActividadInternacional();
        List<ActividadInternacionalDTO> actividadesDTO = new ArrayList<>();
        try {
            List<Actividadinternacional> actividades = actividadInternacionalDAO
                    .getActividadesInternacionales();
            for (Actividadinternacional a : actividades) {
                actividadesDTO.add(EntityToDTO.actInternacionalTOActInternacionalDTO(a));
            }
            response.setActividades(actividadesDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_ACTIVIDADES_INTERNACIONALES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_ACTIVIDADES_INTERNACIONALES);
        }
        return response;
    }

}

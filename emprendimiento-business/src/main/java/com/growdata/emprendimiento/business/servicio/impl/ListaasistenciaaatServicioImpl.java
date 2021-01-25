package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsistentesSesionAAT;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.ListaasistenciaaatServicio;
import com.growdata.emprendimiento.persistence.DAO.ListaasistenciaaatDAO;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Fecha: 22/01/2019
 *
 * @author Juan Carlos Franco
 */
@Service
public class ListaasistenciaaatServicioImpl implements ListaasistenciaaatServicio {

    @Autowired
    private ListaasistenciaaatDAO listaasistenciaaatDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae una lista de asistencia de una sesion a partir de un id
     * de sesion
     *
     * @param idsesionacompanamientoat El id de la sesión
     * @return Una lista de asistencia
     */
    @Override
    @Transactional
    public ResponseAsistentesSesionAAT getLista(long idsesionacompanamientoat) {
        ResponseAsistentesSesionAAT response = new ResponseAsistentesSesionAAT();
        List<ListaasistenciaaatDTO> asistenciasDTO = new ArrayList();
        try {
            List<Listaasistenciaaat> asistencias = listaasistenciaaatDAO.getLista(idsesionacompanamientoat);

            if (asistencias.size() > 0) {
                asistenciasDTO = EntityToDTO.listasAATToListaAATDTO(asistencias);
                response.setAsistenciaDTO(asistenciasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CARGA_ASISTENTES_SESION);
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ASISTENTES_SESION);
                response.setStatus("0");
                //response.setAsistenciaDTO(asistenciasDTO);
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;

    }

}

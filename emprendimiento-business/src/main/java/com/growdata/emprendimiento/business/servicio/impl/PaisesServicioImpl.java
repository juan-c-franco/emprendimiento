package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.ResponsePaises;
import com.growdata.emprendimiento.business.dtos.intentodto.PaisesDTO;
import com.growdata.emprendimiento.business.servicio.PaisesServicio;
import com.growdata.emprendimiento.persistence.DAO.PaisesDAO;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/11/2018
 */
@Service
public class PaisesServicioImpl implements PaisesServicio {

    @Autowired
    private PaisesDAO paisesDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio para ubicar todos los paises.
     *
     * @return Respuesta si fue exitósa o no la búsqueda, y Lista de Paises que
     * cumplan con los criterios de búsqueda.
     */
    @Override
    public ResponsePaises getPaises() {
        ResponsePaises response = new ResponsePaises();
        List<PaisesDTO> paisesDTO = new ArrayList<>();
        try {
            List<Paises> paises = paisesDAO.getPaises();
            for (Paises p : paises) {
                paisesDTO.add(EntityToDTO.paisesToPaisesDTO(p));
            }
            response.setPaises(paisesDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_PAISES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_PAISES);
        }
        return response;
    }

}

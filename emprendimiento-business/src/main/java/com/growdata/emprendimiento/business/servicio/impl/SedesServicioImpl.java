/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSedes;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.SedesDTO;
import com.growdata.emprendimiento.business.servicio.SedesServicio;
import com.growdata.emprendimiento.persistence.DAO.SedesDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class SedesServicioImpl implements SedesServicio {

    @Autowired
    private SedesDAO sedesDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Método encargado de ubicar todas las Sedes dado el identificador del
     * Oferente
     *
     * @param idoferenteinstitucion Identificador del Oferente
     * @return Respuesta que indica si fue satisfactoria o no la consulta, junto
     * con la Lista de Sedes.
     */
    @Override
    public ResponseSedes getSedesPorOferente(BigDecimal idoferenteinstitucion) {
        ResponseSedes response = new ResponseSedes();
        try {
            response.setSedes(EntityToDTO.listSedesToListSedesDTO(sedesDAO.getSedesPorOferente(idoferenteinstitucion)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEDES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEDES);
        }
        return response;

    }

    /**
     * Método que trae todas las sedes parametrizadas en el sistema
     *
     * @return Una lista de sedes
     */
    @Override
    public ResponseSedes getSedes() {
        ResponseSedes response = new ResponseSedes();
        try {
            response.setSedes(EntityToDTO.listSedesToListSedesDTO(sedesDAO.getSedesParametrizar()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEDES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEDES);
        }
        return response;
    }

    /**
     * Método que trae una sede a partir de su id
     *
     * @param id El id de la sede a traer
     * @return Una lista de sedes que solo contiene la sede con el id
     * suministrado
     */
    @Override
    public ResponseSedes getSedePorID(BigDecimal id) {
        ResponseSedes response = new ResponseSedes();
        try {
            response.setSedes(EntityToDTO.listSedesToListSedesDTO(sedesDAO.getSedeporId(id)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEDES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEDES);
        }
        return response;
    }

    /**
     * Método encargado de ubicar todas las Sedes dado el identificador del
     * Oferente
     *
     * @param municipio Identificador del Municipio
     * @return Respuesta que indica si fue satisfactoria o no la consulta, junto
     * con la Lista de Sedes.
     */
    @Override
    public ResponseSedes getSedesPorMunicipio(BigDecimal municipio) {
        ResponseSedes response = new ResponseSedes();
        try {
            response.setSedes(EntityToDTO.listSedesToListSedesDTO(sedesDAO.getSedesPorMunicipio(municipio)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEDES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEDES);
        }
        return response;
    }

    /**
     * Métedo encargado de ubicar una Sede por su identificador.
     *
     * @param Id Identificador de la Sede.
     * @return Response si fue exitóso o no la consulta, lista de Sedes que
     * cumplen con los parámetros de búsqueda.
     */
    @Override
    public ResponseSedes getSedesPorId(BigDecimal Id) {
        ResponseSedes response = new ResponseSedes();
        List<SedesDTO> sedes = new ArrayList<>();
        try {
            sedes.add(EntityToDTO.sedesToSedesDTO(sedesDAO.getSedesPorId(Id)));
            response.setSedes(sedes);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_SEDES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_SEDES);
        }
        return response;
    }

}

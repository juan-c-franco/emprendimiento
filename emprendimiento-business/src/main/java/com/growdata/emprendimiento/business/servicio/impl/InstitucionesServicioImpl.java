/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerInstitucion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerInstitucion;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Instituciones;
import java.math.BigDecimal;
import java.sql.Timestamp;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseInstituciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.InstitucionesServicio;
import com.growdata.emprendimiento.persistence.DAO.InstitucionesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class InstitucionesServicioImpl implements InstitucionesServicio {

    @Autowired
    private InstitucionesDAO institucionesDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Mètodo encargado de ubicar todas las Instituciones
     *
     * @return Respuesta que indica si fue satisfactoria o no la consulta, junto
     * con la Lista de Instituciones.
     */
    @Override
    public ResponseInstituciones getInstituciones() {
        ResponseInstituciones response = new ResponseInstituciones();
        try {
            response.setInstituciones(EntityToDTO.listInstitucionesToListInstitucionesDto(institucionesDAO.getInstituciones()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_INSTITUCIONES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_INSTITUCIONES);
        }
        return response;
    }

    /**
     * Metodo que crea una institución/oferente
     *
     * @param request Contiene la información de la institución a crear
     * @return Respuesta si se creó la institución exitosamente o no
     */
    @Override
    public ResponseDTO crearInstitucion(RequestInstitucion request) {
        ResponseDTO response = new ResponseDTO();
        Instituciones institucion = new Instituciones();
        institucion.setCorreoElectronico(request.getCorreoElectronico());
        institucion.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        institucion.setNombreInstitucion(request.getNombreInstitucion());
        institucion.setNaturalezaJuridica(request.getNaturalezaJuridica());
        institucion.setNit(request.getNit());
        institucion.setOrigen(request.getOrigen());
        institucion.setEstado(request.getEstado());
        institucion.setNumeroTelefono(request.getNumeroTelefono());
        institucion.setDigitoVerificacion(request.getDigitoVerificacion());
        institucion.setIdUsuarioCreacion(new BigDecimal(45)); //crear usuario en simpc
        institucion.setTipoDocumento(request.getTipoDocumento());
        institucion.setTipoInstitucionId(request.getTipoInstitucionId());//Preguntar
        institucion.setEstadoAprobacion(request.getEstadoAprobacion());//preguntar
        institucion.setTipoCertificacion(request.getTipoCertificacion());
        try {
            Instituciones validacion = institucionesDAO.traerInstitucionporNombre(institucion.getNombreInstitucion(), new BigDecimal(-1));
            if (validacion == null) {
                BigDecimal id = institucionesDAO.crearInstitucion(institucion);
                response.setDescripcion(Mensajes.EXITO_CREAR_INSTITUCION);
                response.setStatus("1");
                response.setAccion(Acciones.CREAR_INSTITUCION);
                response.setId(id.longValue());
            } else {
                response.setDescripcion(Mensajes.ERROR_INSTITUCION_REPETIDA);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            response.setDescripcion(Mensajes.ERROR_CREAR_INSTITUCION);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que actualiza una institución/oferente
     *
     * @param request Contiene la información de la institución a actualizar
     * @return Respuesta si se actualizó la institución exitosamente o no
     */
    @Override
    public ResponseDTO modificarInstitucion(RequestInstitucion request) {
        ResponseDTO response = new ResponseDTO();
        Instituciones institucion = new Instituciones();
        institucion.setId(request.getId());
        institucion.setCorreoElectronico(request.getCorreoElectronico());
        institucion.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        institucion.setNombreInstitucion(request.getNombreInstitucion());
        institucion.setNaturalezaJuridica(request.getNaturalezaJuridica());
        institucion.setNit(request.getNit());
        institucion.setOrigen(request.getOrigen());
        institucion.setEstado(request.getEstado());
        institucion.setNumeroTelefono(request.getNumeroTelefono());
        institucion.setDigitoVerificacion(request.getDigitoVerificacion());
        institucion.setIdUsuarioModificacion(new BigDecimal(45)); //crear usuario en simpc
        institucion.setTipoDocumento(new BigDecimal(2));//mirar en simpc para ponerselo
        institucion.setTipoInstitucionId(request.getTipoInstitucionId());//Preguntar
        institucion.setEstadoAprobacion(request.getEstadoAprobacion());//preguntar
        institucion.setTipoCertificacion(request.getTipoCertificacion());//preguntar
        try {
            Instituciones validacion = institucionesDAO.traerInstitucionporNombre(institucion.getNombreInstitucion(), institucion.getId());
            if (validacion == null) {
                institucionesDAO.modificarInstitucion(institucion);
                response.setDescripcion(Mensajes.EXITO_MODIFICAR_INSTITUCION);
                response.setStatus("1");
                response.setAccion(Acciones.MODIFICAR_INSTITUCION);
                response.setId(request.getId().longValue());
            } else {
                response.setDescripcion(Mensajes.ERROR_INSTITUCION_REPETIDA);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            response.setDescripcion(Mensajes.ERROR_MODIFICAR_INSTITUCION);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que trae una institución a partir de su Id
     *
     * @param request Contiene el id de la institución
     * @return Una institución
     */
    @Override
    public ResponseTraerInstitucion traerInstitucion(RequestTraerInstitucion request) {
        ResponseTraerInstitucion response = new ResponseTraerInstitucion();
        try {
            Instituciones institucion = institucionesDAO.traerInstitucion(request.getId());
            InstitucionesDTO dto = EntityToDTO.institucionesToInstitucionesDto(institucion);
            response.setInstitucion(dto);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_INSTITUCION);
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_INSTITUCION);
        }
        return response;
    }

}

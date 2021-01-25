/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseDocentes;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestDocente;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerDocente;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.docentesToDocentesDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.DocentesServicio;
import com.growdata.emprendimiento.persistence.DAO.DocentesDAO;
import com.growdata.emprendimiento.persistence.entidad.Docentes;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Franco
 */
@Service
public class DocentesServicioImpl implements DocentesServicio {

    @Autowired
    private DocentesDAO docentesDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Método encargado de traer todos los Docentes dado el identificador de la
     * CapacitaciónPrograma
     *
     * @param idcapacitacionprograma Identificador CapacitaciónPrograma
     * @return Respuesta si fue exitosa o no la búsqueda, además de la Lista de
     * Docentes.
     */
    @Override
    public ResponseDocentes getDocentes(long idcapacitacionprograma) {
        ResponseDocentes response = new ResponseDocentes();
        try {
            response.setDocentes(EntityToDTO.listDocentesToListDocentesDTO(docentesDAO.getDocentes(idcapacitacionprograma)));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGANDO_DOCENTES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGANDO_DOCENTES);
        }
        return response;
    }

    /**
     * Método encargado de ubicar todos los docentes.
     *
     * @return Respuesta si fue exitosa o no la respuesta, además de la lista de
     * Docentes.
     */
    @Override
    public ResponseDocentes getDocentes() {
        ResponseDocentes response = new ResponseDocentes();
        try {
            response.setDocentes(EntityToDTO.listDocentesToListDocentesDTO(docentesDAO.getDocentes()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_DOCENTES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_DOCENTES);
        }
        return response;
    }

    /**
     * Método encargado de traer todos los docentes.
     *
     * @return Respuesta si fue exitosa o no la respuesta, además de la lista de
     * Docentes.
     */
    @Override
    public ResponseDocentes getDocentesParametrizar() {
        ResponseDocentes response = new ResponseDocentes();
        try {
            response.setDocentes(EntityToDTO.listDocentesToListDocentesDTO(docentesDAO.getDocentesParametrizar()));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_DOCENTES);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_DOCENTES);
        }
        return response;
    }

    /**
     * Método que crea un docente
     *
     * @param request Contiene el docente a crear
     * @return Una respuesta si se creó el docente exitosamente o no
     */
    @Override
    public ResponseDTO crearDocente(RequestDocente request) {
        ResponseDTO response = new ResponseDTO();
        Docentes docente = new Docentes();
        docente.setEmail(request.getEmail());
        docente.setEstadodocente(request.getEstadoDocente());
        docente.setFecharegistro(new Date());
        docente.setTipodocumentoid(request.getTipodocumentoid());
        docente.setNumerodocumento(request.getNumerodocumento());
        docente.setPrimerapellido(request.getPrimerapellido());
        docente.setPrimernombre(request.getPrimernombre());
        docente.setSegundoapellido(request.getSegundoapellido());
        docente.setSegundonombre(request.getSegundonombre());
        docente.setTelefono(request.getTelefono());
        try {
            Docentes validacionEmail = docentesDAO.traerDocentePorEmail(docente.getEmail(), -1);
            if (validacionEmail == null) {
                Docentes validacionDocumento = docentesDAO.traerDocentePorDocumento(docente.getNumerodocumento(), docente.getTipodocumentoid().getIdtipodocumento(), -1);
                if (validacionDocumento == null) {
                    long id = docentesDAO.crearDocente(docente);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CREAR_DOCENTE);
                    response.setId(id);
                    response.setAccion(Acciones.CREAR_DOCENTE);
                } else {
                    response.setDescripcion(Mensajes.ERROR_DOCENTE_REPETIDO_D);
                    response.setStatus("0");
                }
            } else {
                response.setDescripcion(Mensajes.ERROR_DOCENTE_REPETIDO_E);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CREAR_DOCENTE);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método que actualiza un docente
     *
     * @param request Contiene el docente a actualizar
     * @return Una respuesta si se actualizó el docente exitosamente o no
     */
    @Override
    public ResponseDTO modificarDocente(RequestDocente request) {
        ResponseDTO response = new ResponseDTO();
        Docentes docente = new Docentes();
        docente.setEmail(request.getEmail());
        docente.setEstadodocente(request.getEstadoDocente());
        docente.setFecharegistro(new Date());
        docente.setTipodocumentoid(request.getTipodocumentoid());
        docente.setNumerodocumento(request.getNumerodocumento());
        docente.setPrimerapellido(request.getPrimerapellido());
        docente.setPrimernombre(request.getPrimernombre());
        docente.setSegundoapellido(request.getSegundoapellido());
        docente.setSegundonombre(request.getSegundonombre());
        docente.setTelefono(request.getTelefono());
        docente.setIddocente(request.getIddocente());
        try {
            Docentes validacionEmail = docentesDAO.traerDocentePorEmail(docente.getEmail(), docente.getIddocente());
            if (validacionEmail == null) {
                Docentes validacionDocumento = docentesDAO.traerDocentePorDocumento(docente.getNumerodocumento(), docente.getTipodocumentoid().getIdtipodocumento(), docente.getIddocente());
                if (validacionDocumento == null) {
                    docentesDAO.modificarDocente(docente);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_MODIFICAR_DOCENTE);
                    response.setAccion(Acciones.MODIFICAR_DOCENTE);
                } else {
                    response.setDescripcion(Mensajes.ERROR_DOCENTE_REPETIDO_D);
                    response.setStatus("0");
                }
            } else {
                response.setDescripcion(Mensajes.ERROR_DOCENTE_REPETIDO_E);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_MODIFICAR_DOCENTE);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método que trae un docente a partir de un id
     *
     * @param request Contiene el id del docente a traer
     * @return Una respuesta que contiene un docente
     */
    @Override
    public ResponseTraerDocente traerDocente(RequestDocente request) {
        ResponseTraerDocente response = new ResponseTraerDocente();
        try {
            response.setDocente(docentesToDocentesDTO(docentesDAO.traerDocente(request.getIddocente())));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_DOCENTE);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_DOCENTE);
        }
        return response;
    }

}

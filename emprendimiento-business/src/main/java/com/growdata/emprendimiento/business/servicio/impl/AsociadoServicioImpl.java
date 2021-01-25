/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.BeneficiarioAATDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseAsociadosPorEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerAsociadoPorUserName;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetAsociadoXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetAsociadoXId;
import com.growdata.emprendimiento.business.commons.EntityToDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.AsociadosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.servicio.AsociadoServicio;
import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class AsociadoServicioImpl implements AsociadoServicio {

    @Autowired
    private AsociadoDAO asociadoDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private TemasRutaCapacitacionDAO temasRutaCapacitacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que revisa si un beneficiaro es asociado de un emprendimiento a
     * partir de su id
     *
     * @param request Contiene el id del beneficiario y el id de la caja de
     * compensación
     * @return Respuesta si el beneficiario es asociado o no de un
     * emprendimiento
     */
    @Override
    public ResponseGetAsociadoXId getAsociadoXId(RequestGetAsociadoXId request) {
        ResponseGetAsociadoXId response = new ResponseGetAsociadoXId();
        Asociados asociado = new Asociados();
        Emprendimiento emp = new Emprendimiento();
        List<String> estados = new ArrayList<>();
        estados.add("1");
        estados.add("2");

        try {
            asociado = asociadoDAO.getAsociadoXId(request.getIdBeneficiario());
            if (asociado != null) {
                emp = emprendimientoDAO.getEmprendimientoXIdYEstado(
                        asociado.getEmprendimiento().getIdemprendimiento(), estados,
                        request.getIdCajacompensacion());
                if (emp != null) {
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CARGA_ASOCIADOS);
                } else {
                    response.setStatus("0");
                    response.setDescripcion(Mensajes.ERROR_CARGA_EMPRENDIMIENTO);
                }
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_ASOCIADO);
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }

        return response;
    }

    /**
     * Servicio encargado de ubicar asociados a un emprendimiento dado su nombre 
     * de usuario y un determinado estado de usuario.
     *
     * @param requestTraerAsociadoPorUserName Contiene los datos del usuario.
     * @return Asociado vinculado al emprendimiento
     */
    @Override
    public ResponseTraerAsociadoPorUserName getAsociado(RequestTraerAsociadoPorUserName requestTraerAsociadoPorUserName) {
        ResponseTraerAsociadoPorUserName response = new ResponseTraerAsociadoPorUserName();
        try {
            Asociados asociado = asociadoDAO.getAsociadoPorUserName(requestTraerAsociadoPorUserName.getEstadoUsuario(), requestTraerAsociadoPorUserName.getUserName());
            if (asociado != null) {
                AsociadosDTO asociadoDTO = EntityToDTO.asociadoToAsociadoDTO(asociado);
                response.setAsociadoDTO(asociadoDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_ASOCIADO);
                response.setStatus("1");

            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_ASOCIADO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_ASOCIADO);
        }
        return response;
    }

    /**
     * Servicio encargados de ubicar los asociados vinculados a un emprendimiento.
     *
     * @param requestAsociadosPorEmprendimiento Información del emprendimiento.
     * @return Respuesta que indica si fue exitosa o no la busqueda, y los
     * asociados vinculados al emprendimiento.
     */
    @Override
    public ResponseAsociadosPorEmprendimiento getAsociadosPorEmprendimiento(RequestAsociadosPorEmprendimiento requestAsociadosPorEmprendimiento) {
        ResponseAsociadosPorEmprendimiento response = new ResponseAsociadosPorEmprendimiento();
        try {
            List<Asociados> asociados = asociadoDAO.getAsociadosPorEmprendimiento(requestAsociadosPorEmprendimiento.getIdEmprendimiento());
            if (asociados != null) {
                List<BeneficiarioAATDTO> beneficiariosAATDTO = new ArrayList<>();
                for (Asociados asociado : asociados) {
//                asociados.forEach((asociado) -> {
                    AsociadosDTO asociadoDTO = EntityToDTO.asociadoToAsociadoDTO(asociado);
                    BeneficiarioDTO beneficiarioDTO = asociadoDTO.getBeneficiario();
                    BeneficiarioAATDTO beneficiarioAATDTO = new BeneficiarioAATDTO();
                    beneficiarioAATDTO.setIdbeneficiario(beneficiarioDTO.getIdbeneficiario());
                    beneficiarioAATDTO.setNombres(beneficiarioDTO.getPrimernombre() + " " + (beneficiarioDTO.getSegundonombre() != null ? beneficiarioDTO.getSegundonombre() : ""));
//                    beneficiarioAATDTO.setNombres(beneficiarioDTO.getPrimernombre());
                    beneficiarioAATDTO.setApellidos(beneficiarioDTO.getPrimerapellido() + " " + (beneficiarioDTO.getSegundoapellido() != null ? beneficiarioDTO.getSegundoapellido() : ""));
//                    beneficiarioAATDTO.setApellidos(beneficiarioDTO.getPrimerapellido());
                    beneficiarioAATDTO.setTipodocumento(beneficiarioDTO.getTipodocumentoid().getNombredocumento());
                    beneficiarioAATDTO.setNumerodocumento(beneficiarioDTO.getNumerodocumento());
                    beneficiarioAATDTO.setEmail(beneficiarioDTO.getEmail());
                    beneficiarioAATDTO.setTelefono(beneficiarioDTO.getTelefono());

                    List<Temasrutacapacitacion> temasRutaCapacitacion = temasRutaCapacitacionDAO.getTemasRutaCapacitacionPorBeneficiario(beneficiarioDTO.getIdbeneficiario());
                    List<TemasrutacapacitacionDTO> temasRutaCapacitacionDTO = EntityToDTO.listaTemasRutaCapacitacionToListaTemasRutaCapacitacionDTO(temasRutaCapacitacion);
                    beneficiarioAATDTO.setTemasRutaCapacitacionDTO(temasRutaCapacitacionDTO);
                    beneficiariosAATDTO.add(beneficiarioAATDTO);
                }
                response.setBeneficiarios(beneficiariosAATDTO);
                response.setDescripcion(Mensajes.EXITO_CARGA_BENEFICIARIO);
                response.setStatus("1");
            } else {
                response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO);
                response.setStatus("0");
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CARGA_BENEFICIARIO);
        }
        return response;
    }
}

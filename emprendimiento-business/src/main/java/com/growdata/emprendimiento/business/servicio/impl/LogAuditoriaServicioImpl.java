/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerLogA;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerLogA;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaLogToListaLogDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.persistence.entidad.Logauditoria;
import com.growdata.emprendimiento.business.commons.RequestLogAuditoria;
import com.growdata.emprendimiento.business.dtos.intentodto.LogauditoriaDTO;
import com.growdata.emprendimiento.business.servicio.LogAuditoriaServicio;
import com.growdata.emprendimiento.persistence.DAO.LogAuditoriaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class LogAuditoriaServicioImpl implements LogAuditoriaServicio {

    @Autowired
    private LogAuditoriaDAO logAuditoriaDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que guarda un registro en el log de auditoria
     *
     * @param request Contiene la informacion del registro a guardar
     */
    @Override
    public void registrarLog(RequestLogAuditoria request) {

        try {
            Logauditoria logObj = new Logauditoria();
            logObj.setAccion(request.getAccion());
            logObj.setFecharegistro(request.getFecharegistro());
            logObj.setIdelemento(request.getIdelemento());
            logObj.setModulo(request.getModulo());
            logObj.setUsers(request.getUsers());

            logAuditoriaDAO.registrarLog(logObj);
        } catch (Exception ex) {
            log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
        }
    }

    /**
     * Metodo que trae registros del log de auditoría que se encuentren entre
     * una fecha inicial y una fecha final
     *
     * @param request Contiene la fecha inicial y la fecha final
     * @return una lista de registros del lod de auditoría
     */
    @Override
    public ResponseTraerLogA getLogsXFecha(RequestTraerLogA request) {
        ResponseTraerLogA response = new ResponseTraerLogA();
        List<Logauditoria> logs = new ArrayList();
        List<LogauditoriaDTO> logsDTO = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(request.getFechaF());
        cal.add(Calendar.DATE, 1);
        Date nuevaFecha = cal.getTime();
        request.setFechaF(nuevaFecha);

        try {
            logs = logAuditoriaDAO.getLogsXFecha(request.getFechaI(), request.getFechaF());
            if (logs.size() > 0) {
                logsDTO = listaLogToListaLogDTO(logs);
                response.setLogs(logsDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.LOG_AUDITORIA_EXITO);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.LOG_AUDITORIA_VACIO);
            }
        } catch (Exception ex) {
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        return response;
    }

}

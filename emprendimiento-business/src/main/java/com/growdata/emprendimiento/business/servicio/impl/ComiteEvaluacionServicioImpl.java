package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.ResponseComiteEvaluacion;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.ComiteEvaluacionServicio;
import com.growdata.emprendimiento.persistence.DAO.ComiteEvaluacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 04/12/2018
 *
 * @author Juan Carlos Franco
 */
@Service
public class ComiteEvaluacionServicioImpl implements ComiteEvaluacionServicio {

    @Autowired
    private ComiteEvaluacionDAO comiteEvaluacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Servicio encargado de ubicar un Comité de Evaluación dado uno de los 
     * funcionarios que pertenece al mismo.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Respuesta si fue exitósa o no la búsqueda, y Comité de Evaluación
     * que cumpla con el criterio de búsqueda.
     */
    @Override
    public ResponseComiteEvaluacion getComitePorIdFuncionario(long idFuncionario) {
        ResponseComiteEvaluacion response = new ResponseComiteEvaluacion();
        try {
            response.setComite(comiteEvaluacionDAO.getComitePorIdFuncionario(idFuncionario));
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CARGA_COMITE_EVALUACION);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CARGA_COMITE_EVALUACION);
            response.setStatus("0");
        }
        return response;
    }

}

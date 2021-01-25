/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.EvaluacionemprendimientosServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.EvaluacionemprendimientosDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 10/12/2018
 *
 * @author Juan Carlos Franco
 */
@Service
public class EvaluacionemprendimientosServicioImpl implements EvaluacionemprendimientosServicio {

    @Autowired
    private EvaluacionemprendimientosDAO evaluacionEmprendimientosDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private EnviarEmail enviar;

    /**
     * Servicio calificar los emprendimientos revisados en una Sesión Comité.
     *
     * @param idSesionComite Identificador de la Sesión Comité
     * @param aprobados Lista de Calificaciones
     * @param observaciones Lista de Observaciones
     * @param ids Lista de identificadores de emprendimientos
     * @param path Path donde se almacenó el acta adjunta
     * @return Indica si fue exitóso o no el cambio
     */
    @Override
    public ResponseDTO calificacionDefinitiva(long idSesionComite, List<Character> aprobados,
            List<String> observaciones, List<Long> ids, String path) {
        ResponseDTO response = new ResponseDTO();
        Sesioncomite sesion = new Sesioncomite();
        sesion.setIdsesioncomite(idSesionComite);
        sesion.setUrlacta(path);

        try {
            long id = evaluacionEmprendimientosDAO.save(sesion, aprobados, observaciones, ids);
            int index = 0;
            for (Long l : ids) {
                Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorId(l);
                for (Asociados a : emprendimiento.getAsociadoses()) {
                    enviar.setNombres(a.getBeneficiario().getPrimernombre() + " "
                            + (a.getBeneficiario().getSegundonombre() != null ? a.getBeneficiario().getSegundonombre() : ""));
                    enviar.setApellidos(a.getBeneficiario().getPrimerapellido() + " "
                            + (a.getBeneficiario().getSegundoapellido() != null ? a.getBeneficiario().getSegundoapellido() : ""));
                    enviar.setTipoSesion(observaciones.get(index));
                    enviar.setHoras(aprobados.get(index) == '1' ? "Aprobado" : "Reprobado");
                    enviar.setNombreEstadoEmprendimiento(aprobados.get(index) == '1' ? "Financiación" : "Registro");
                    enviar.notificarGenerica(45, a.getBeneficiario().getEmail());
                    index++;
                }
                
            }
            response.setDescripcion(Mensajes.EXITO_REGISTRO_CALIFICACION_IND);
            response.setStatus("1");
            response.setAccion(Acciones.REGISTRAR_CALIFICACION_DEF);
            response.setId(id);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_REGISTRO_CALIFICACION_IND);
            response.setStatus("0");
        }

        return response;
    }

}

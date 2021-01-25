/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface AprobacionDAO {

    public void registrarCalificacionCapacitacion(List<Aprobacion> registroGlobal, BigDecimal idProgramacion) throws Exception;

    public Aprobacion getAprobacionPorId(BigDecimal idalumno) throws Exception;
    
    public List<Aprobacion> getAprobacionesPorProgramacion(BigDecimal idProgramacion) throws Exception;
    
    public List<Aprobacion> getAprobacionesPorNumeroDocumento(String tipo, String numeroDocumento) throws Exception;

}

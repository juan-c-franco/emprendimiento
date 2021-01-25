/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Seguimientoasistencia;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface SeguimientoasistenciaDAO {

    public void registrarAsistenciaCapacitacion(List<Seguimientoasistencia> registroGlobal,
            BigDecimal idprogramacion,long idFuncionario) throws Exception;

    public List<Seguimientoasistencia> getSeguimientoAlumnoModulo(BigDecimal idalumno, long idmodulociclo) throws Exception;
    
    public List<Seguimientoasistencia> getSeguimientoNumeroDocumento(String tipo, String numeroDocumento) throws Exception;

}

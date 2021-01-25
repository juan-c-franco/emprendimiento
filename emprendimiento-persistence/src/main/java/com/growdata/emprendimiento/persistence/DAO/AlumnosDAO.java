/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface AlumnosDAO {
    
    public List<Alumnos> getLista(BigDecimal idprogramacion) throws Exception;
    
    public long asociarBeneficiarioProgramacion(Alumnos alumno) throws Exception;
    
    public Alumnos getAlumno(BigDecimal idalumno) throws Exception;
    
    public List<Alumnos> getAlumnoPorDocumento(String tipo, String numeroDocumento, 
            BigDecimal idProgramacion) throws Exception;
    
}

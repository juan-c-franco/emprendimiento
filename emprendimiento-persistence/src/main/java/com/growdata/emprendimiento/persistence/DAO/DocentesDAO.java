/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Docentes;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface DocentesDAO {

    public List<Docentes> getDocentes(long idcapacitacionprograma) throws Exception;
    
    public List<Docentes> getDocentes() throws Exception;
    
    public List<Docentes> getDocentesParametrizar() throws Exception;

    public long crearDocente(Docentes docente) throws Exception;
    
    public void modificarDocente(Docentes docente) throws Exception;
    
    public Docentes traerDocente(long id) throws Exception;
    
    public Docentes traerDocentePorEmail(String email, long id) throws Exception;
    
    public Docentes traerDocentePorDocumento(String numerodocumento, BigDecimal idtipodocumento, long id) throws Exception;
}

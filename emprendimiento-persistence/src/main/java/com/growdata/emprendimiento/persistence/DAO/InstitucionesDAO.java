/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidadSIMPC.Instituciones;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface InstitucionesDAO {
    
    public List<Instituciones> getInstituciones();
    
    public BigDecimal crearInstitucion(Instituciones institucion) throws Exception;
    
    public void modificarInstitucion(Instituciones institucion) throws Exception;
    
    public Instituciones traerInstitucion(BigDecimal id) throws Exception;
    
    public Instituciones traerInstitucionporNombre(String nombre, BigDecimal id) throws Exception;
    
}

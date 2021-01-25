/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidadSIMPC.Sedes;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface SedesDAO {
    
    public List<Sedes> getSedesPorOferente(BigDecimal idOferente) throws Exception;
    
    public List<Sedes> getSedesPorMunicipio(BigDecimal municipio) throws Exception;
    
    public Sedes getSedesPorId(BigDecimal Id) throws Exception;
    
    public List<Sedes> getSedesParametrizar() throws Exception;
    
    public List<Sedes> getSedeporId(BigDecimal id) throws Exception;
    
}

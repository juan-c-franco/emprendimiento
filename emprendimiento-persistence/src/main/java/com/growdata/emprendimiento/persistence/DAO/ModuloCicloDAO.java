/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public interface ModuloCicloDAO {
    
    public List<Modulociclo> getModulos() throws Exception;
    
    public Boolean moduloCheck(long id, BigDecimal idProgramacion);
    
    public long crearModulo(Modulociclo modulo) throws Exception;
    
    public void modificarModulo(Modulociclo modulo) throws Exception;
    
    public Modulociclo traerModulo(long id) throws Exception;
    
    public Modulociclo traerModuloporNombre(String nombre, long id, long idcapacitacionprograma) throws Exception;
}

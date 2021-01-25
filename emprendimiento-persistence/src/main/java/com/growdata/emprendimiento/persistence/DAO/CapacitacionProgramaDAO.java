/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public interface CapacitacionProgramaDAO {

    public List<Capacitacionprograma> getCapacitaciones(long idSede) throws Exception;
    
    public long crearCapacitacion(Capacitacionprograma capacitacion) throws Exception;
    
    public void modificarCapacitacion(Capacitacionprograma capacitacion) throws Exception;
    
    public Capacitacionprograma traerCapacitacion(long id) throws Exception;
    
    public Capacitacionprograma traerCapacitacionporNombre(String nombre, long id) throws Exception;
    
    public List<Capacitacionprograma> getCapacitacionesParametrizar() throws Exception;
    public List<Capacitacionprograma> getCapacitaciones() throws Exception;

}

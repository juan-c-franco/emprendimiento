/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import java.util.List;

/**
 *
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */

public interface EstadoCapacitacionProgramaDAO {

  public List<Estadocapacitacionprograma> getEstadosCapacitacion() throws Exception;
    
    
}

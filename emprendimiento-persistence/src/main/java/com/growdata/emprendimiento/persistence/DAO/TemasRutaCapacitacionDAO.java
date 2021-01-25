/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import java.util.List;

public interface TemasRutaCapacitacionDAO {

    public long crearTema(List<Temasrutacapacitacion> temasRuta) throws Exception;

    public List<Temasrutacapacitacion> getTemasRutaCapacitacionPorBeneficiario(long idbeneficiario) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Paises;
import java.util.List;
import javax.persistence.NoResultException;

public interface PaisesDAO {

    public List<Paises> getPaises() throws Exception;

    public Paises getPaisesPorId(int idPais) throws NoResultException, Exception;

}

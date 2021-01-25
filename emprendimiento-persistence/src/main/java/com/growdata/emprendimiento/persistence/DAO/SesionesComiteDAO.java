/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

public interface SesionesComiteDAO {

    public List<Sesioncomite> getSesionesFuncionario(long idFuncionario,
            Date desde, Date hasta, int todas) throws Exception;

    public long saveSesiones(Sesioncomite sesion,
            List<Emprendimiento> emprendimientos) throws Exception, HibernateException;

    public void updateSesiones(Sesioncomite sesion) throws Exception, HibernateException;

    public void deleteSesiones(Sesioncomite sesion) throws HibernateException, Exception;

    public Sesioncomite getSesiones(long id) throws Exception;

    public List<Sesioncomite> getSesionesFuncionarioComite(long idFuncionario,
            Date desde, Date hasta, int todas) throws Exception;
}

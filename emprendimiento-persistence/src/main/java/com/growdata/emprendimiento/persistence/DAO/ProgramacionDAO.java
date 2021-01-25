/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Programacion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Juan Franco
 */
public interface ProgramacionDAO {
    
    public List<Programacion> getProgramaciones(long iddocente, Date desde) throws Exception;
    
    public List<Programacion> getProgramacionPorSedeCapacitacion(BigDecimal idsede, 
            long idcapacitacion, Date desde, Short vencidas) throws Exception;
    
    public Programacion getProgramacion(BigDecimal id) throws Exception;

    public long saveProgramaciones(Programacion programacion) throws Exception, HibernateException;

    public void updateProgramaciones(Programacion programacion) throws Exception, HibernateException;

    public void deleteProgramaciones(Programacion programacion) throws HibernateException, Exception;

}

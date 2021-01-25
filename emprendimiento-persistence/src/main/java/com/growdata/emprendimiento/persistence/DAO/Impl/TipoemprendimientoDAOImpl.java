/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TipoemprendimientoDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipoemprendimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Franco Fecha: 20/11/2018
 */
@Repository
public class TipoemprendimientoDAOImpl implements TipoemprendimientoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Override
    public List<Tipoemprendimiento> getTiposEmprendiemiento() throws Exception {
        List<Tipoemprendimiento> tipos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Tipoemprendimiento order by nombretipoemprendimiento", Tipoemprendimiento.class);
            //obtener  resultado
            tipos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return tipos;
    }

}

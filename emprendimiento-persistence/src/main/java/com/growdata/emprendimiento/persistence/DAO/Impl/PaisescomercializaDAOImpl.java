/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.PaisescomercializaDAO;
import com.growdata.emprendimiento.persistence.entidad.Paisescomercializa;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GrowData
 */
@Repository
public class PaisescomercializaDAOImpl implements PaisescomercializaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Override
    public List<Paisescomercializa> getPaisescomercializaPorFormalizado(long idformalizacion) throws Exception {
        List<Paisescomercializa> paises = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Paisescomercializa p"
                            + " where p.formalizado.idformalizacion = :idF"
                            + " order by p.paises.nombrepais", Paisescomercializa.class);
            //obtener  resultado
            elQuery.setParameter("idF", idformalizacion);
            paises = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return paises;
    }
}

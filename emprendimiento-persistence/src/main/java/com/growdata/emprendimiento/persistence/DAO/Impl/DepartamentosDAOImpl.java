package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.DepartamentosDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Departamentos;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 03/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class DepartamentosDAOImpl implements DepartamentosDAO {

    private SessionFactory sessionFactory = HibernateJdbcSimpc.getSession();

    @Override
    public List<Departamentos> getDepartamentos() throws Exception {
        List<Departamentos> departamentos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Departamentos order by nombre", Departamentos.class);
            //obtener  resultado
            departamentos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return departamentos;
    }
}

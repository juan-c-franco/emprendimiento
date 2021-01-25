/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.FormalizadoDAO;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 07/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class FormalizadoDAOImpl implements FormalizadoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de ubicar un Formalizado por idformalizacion.
     *
     * @param idformalizacion Identificador de Formalizado
     * @return Formalizado que cumpla con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Formalizado getFormalizadoPorId(long idformalizacion) throws Exception {
        Formalizado formalizado = new Formalizado();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Formalizado "
                    + "where idformalizacion=:id", Formalizado.class);
            q.setParameter("id", idformalizacion);
            formalizado = (Formalizado) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            formalizado = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return formalizado;
    }
}

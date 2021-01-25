/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.NoestablecidoDAO;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha 19/03/2019
 *
 * @author Juan Franco
 */
@Repository
public class NoestablecidoDAOImpl implements NoestablecidoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de ubicar un NoEstablecido.
     *
     * @param id Identificador del NoEstablecido
     * @return NoEstablecido que cumpla con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Noestablecido getNoEstablecidoPorId(BigDecimal id)
            throws Exception {
        Noestablecido formalizado = new Noestablecido();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Noestablecido "
                    + "where idnoestablecido=:id", Noestablecido.class);
            q.setParameter("id", id);
            formalizado = (Noestablecido) q.getSingleResult();
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

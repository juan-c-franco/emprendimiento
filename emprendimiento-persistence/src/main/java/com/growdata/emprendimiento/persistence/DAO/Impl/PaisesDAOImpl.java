/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.PaisesDAO;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GrowData
 */
@Repository
public class PaisesDAOImpl implements PaisesDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO para ubicar todos los paises.
     *
     * @return Lista de Paises
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Paises> getPaises() throws Exception {
        List<Paises> paises = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Paises order by nombrepais", Paises.class);
            //obtener  resultado
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

    /**
     * DAO encargado de ubicar un pais por su Identificador.
     *
     * @param idPais Identificador del Pais
     * @return Pais que cumple con los criterios de búsqueda.
     * @throws NoResultException Exception lanzada por getSingleResult()
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    public Paises getPaisesPorId(int idPais) throws NoResultException, Exception {
        Paises paises = new Paises();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Paises"
                            + " where idpais = :id", Paises.class);
            elQuery.setParameter("id", idPais);
            //obtener  resultado
            paises = (Paises) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException ex) {
            throw ex;
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

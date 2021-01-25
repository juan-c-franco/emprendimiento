/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TipoConstitucionLegalDAO;
import com.growdata.emprendimiento.persistence.entidad.Tipoconstitucionlegal;
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
public class TipoConstitucionLegalDAOImpl implements TipoConstitucionLegalDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO para ubicar todos los Tipos de Constitución Legal.
     *
     * @return Lista de Tipos de Constitución Legal
     * @throws Exception Cualquier Exception que pueda ser lanzda.
     */
    @Override
    public List<Tipoconstitucionlegal> getTiposConstitucionLegal() throws Exception {
        List<Tipoconstitucionlegal> tipos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Tipoconstitucionlegal order by nombretipoconstitucionlegal", Tipoconstitucionlegal.class);
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

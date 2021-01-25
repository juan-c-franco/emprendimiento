/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SectorProductivoDAO;
import com.growdata.emprendimiento.persistence.entidad.Sectorproductivo;
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
public class SectorProductivoDAOImpl implements SectorProductivoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO para ubicar todos los Sectores Productivos.
     *
     * @return Lista de Sectores Productivos.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Sectorproductivo> getSectoresProductivos() throws Exception {
        List<Sectorproductivo> sectores = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Sectorproductivo order by nombresectorproductivo", Sectorproductivo.class);
            //obtener  resultado
            sectores = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return sectores;
    }

}

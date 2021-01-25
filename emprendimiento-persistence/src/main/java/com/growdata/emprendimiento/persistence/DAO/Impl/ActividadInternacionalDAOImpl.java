/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ActividadInternacionalDAO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
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
public class ActividadInternacionalDAOImpl implements ActividadInternacionalDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO para ubicar todos las Actividades Internacionales.
     *
     * @return Lista de Actividades Internacionales
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Actividadinternacional> getActividadesInternacionales() throws Exception {
        List<Actividadinternacional> actividades = new ArrayList();
        System.out.println("Antes");
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Actividadinternacional order by nombreactividadinternacional", Actividadinternacional.class);
            //obtener  resultado

            actividades = elQuery.getResultList();
            System.out.println(actividades.toString());
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return actividades;
    }

}

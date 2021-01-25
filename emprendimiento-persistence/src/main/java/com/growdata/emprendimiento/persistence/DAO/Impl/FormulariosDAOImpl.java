/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.FormulariosDAO;
import com.growdata.emprendimiento.persistence.entidad.Formulariosweb;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class FormulariosDAOImpl implements FormulariosDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los formularios de la BD
     *
     * @return Una lista con los formularios
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Formulariosweb> getFormularios() throws Exception {

        List<Formulariosweb> formularios = null;
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        // Session sesion = sessionFactory.getCurrentSession();

        try {
            //Empezar ]Transaccion
            sesion.beginTransaction();
            //creo el query
            Query<Formulariosweb> elQuery
                    = sesion.createQuery("from Formulariosweb order by posicion, idformulario", Formulariosweb.class);

            //obtener resultado
            formularios = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return formularios;
    }
}

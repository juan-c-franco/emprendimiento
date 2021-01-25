/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TemasIndividualesDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;

import com.growdata.emprendimiento.persistence.entidad.Temasvaloracionindividual;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
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
public class TemasIndividualesDAOImpl implements TemasIndividualesDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los temas individuales de la BD
     *
     * @return Una lista de temas individuales
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Temasvaloracionindividual> getTemas() throws Exception {
        List<Temasvaloracionindividual> temas = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Temasvaloracionindividual", Temasvaloracionindividual.class);

            //obtengo resultados del query
            temas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_TEMA_INDIVIDUAL, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return temas;
    }

}

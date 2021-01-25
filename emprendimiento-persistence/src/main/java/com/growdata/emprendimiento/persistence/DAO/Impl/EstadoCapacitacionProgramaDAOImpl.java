/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EstadoCapacitacionProgramaDAO;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */
@Repository
public class EstadoCapacitacionProgramaDAOImpl implements EstadoCapacitacionProgramaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    /**
     * Metodo que trae los estados de capacitaci�n de la BD
     * @return Una lista de estados de capacitaci�n
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Estadocapacitacionprograma> getEstadosCapacitacion() throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Estadocapacitacionprograma> estados = new ArrayList();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Estadocapacitacionprograma", Estadocapacitacionprograma.class);
            estados = elQuery.getResultList();
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return estados;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EstadoDocenteDAO;
import com.growdata.emprendimiento.persistence.entidad.Estadodocente;
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
public class EstadoDocenteDAOImpl implements EstadoDocenteDAO {

  private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    /**
     * M�todo que trae todos los estados de un docente
     * @return Una lista con todos los estados de un docente
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Estadodocente> getEstadosDocente() throws Exception {
        List<Estadodocente> estadoDocentes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Estadodocente ", Estadodocente.class);
            //obtener  resultado
            estadoDocentes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return estadoDocentes;
    }
}

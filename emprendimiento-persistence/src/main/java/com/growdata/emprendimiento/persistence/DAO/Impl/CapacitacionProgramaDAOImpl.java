/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.CapacitacionProgramaDAO;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
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
 * @author Juan Franco
 */
@Repository
public class CapacitacionProgramaDAOImpl implements CapacitacionProgramaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Mètodo encargado de ubicar todas las Instituciones segùn el identificador
     * de Sede.
     *
     * @param idSede Identificador de la Sede.
     * @return Lista de Capacitaciones.
     * @throws java.lang.Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Capacitacionprograma> getCapacitaciones(long idSede) throws Exception {
        List<Capacitacionprograma> capacitaciones = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Capacitacionprograma c"
                            + " INNER JOIN Programacion p ON p.capacitacionprograma.idcapacitacionprograma = c.idcapacitacionprograma"
                            + " where c.estadocapacitacionprograma.idestadocapacitacionprograma = 1"
                            + " AND p.sedes.idInstitucion = :idSede"
                            + " order by c.nombrecapacitacionprograma", Capacitacionprograma.class);
            elQuery.setParameter("idSede", idSede);
            //obtener  resultado
            capacitaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return capacitaciones;
    }

    /**
     * Mètodo encargado de ubicar todas las Capacitaciones
     *
     * @return Lista de Capacitaciones
     * @throws java.lang.Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Capacitacionprograma> getCapacitaciones() throws Exception {
        List<Capacitacionprograma> capacitaciones = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery = sesion.createQuery("from Capacitacionprograma c"
                    + " where c.estadocapacitacionprograma.idestadocapacitacionprograma = 1"
                    + " order by c.nombrecapacitacionprograma", Capacitacionprograma.class);
            capacitaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return capacitaciones;
    }

    /**
     * Método que crea una capacitación en la BD
     *
     * @param capacitacion La capacitación a crear
     * @return El id de la capacitación creada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long crearCapacitacion(Capacitacionprograma capacitacion) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            id = (long) sesion.save(capacitacion);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Método que actualiza una capacitación en la BD
     *
     * @param capacitacion La capacitación a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void modificarCapacitacion(Capacitacionprograma capacitacion) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(capacitacion);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Método que trae una capacitación de la Bd a partir de su id
     *
     * @param id El id de la capacitación a traer
     * @return Una capacitación
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Capacitacionprograma traerCapacitacion(long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Capacitacionprograma capacitacion = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Capacitacionprograma where idcapacitacionprograma=:id", Capacitacionprograma.class);
            elQuery.setParameter("id", id);
            capacitacion = (Capacitacionprograma) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return capacitacion;
    }

    /**
     * Método que trae una capacitación de la BD a partir de su nombre,
     * excluyendo la que tenga el id suministrado
     *
     * @param nombre El nombre de la capacitación a traer
     * @param id El id para excluir una capacitación
     * @return Una capacitación
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Capacitacionprograma traerCapacitacionporNombre(String nombre, long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Capacitacionprograma capacitacion = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Capacitacionprograma where nombrecapacitacionprograma =:nombre"
                            + " and idcapacitacionprograma !=:id", Capacitacionprograma.class);
            elQuery.setParameter("id", id);
            elQuery.setParameter("nombre", nombre);
            capacitacion = (Capacitacionprograma) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return capacitacion;
    }

    /**
     * Método que trae todas las capacitaciones de la BD
     *
     * @return Una lista de capacitaciones
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Capacitacionprograma> getCapacitacionesParametrizar() throws Exception {
        List<Capacitacionprograma> capacitaciones = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery = sesion.createQuery("from Capacitacionprograma", Capacitacionprograma.class);
            //obtener  resultado
            capacitaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return capacitaciones;
    }

}

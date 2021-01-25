/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.InstitucionesDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Instituciones;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.math.BigDecimal;
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
public class InstitucionesDAOImpl implements InstitucionesDAO {

    private SessionFactory sessionFactory1 = HibernateJdbcSimpc.getSession();

    /**
     * Método encargado de ubicar todas las Instituciones.
     * 
     * @return Lista de Instituciones
     * Metodo que trae la lista de instituciones/oferentes de la BD
     *
     * @return Lista de instituciones/oferentes
     */
    @Override
    public List<Instituciones> getInstituciones() {
        List<Instituciones> instituciones = new ArrayList();
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Instituciones "
                            + " where estado = 'A' and estadoAprobacion = 'A'"
                            + " order by nombreInstitucion", Instituciones.class);
            //obtener  resultado
            instituciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return instituciones;
    }

    /**
     * Metodo que crea una Institución/Oferente en la BD
     *
     * @param institucion La institución a crear
     * @return El id de la institución creada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public BigDecimal crearInstitucion(Instituciones institucion) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        BigDecimal id = null;
        try {
            sesion.beginTransaction();
            id = (BigDecimal) sesion.save(institucion);
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
     * Metodo que actualiza una Institución/Oferente en la BD
     *
     * @param institucion La institución a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void modificarInstitucion(Instituciones institucion) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();

        try {
            sesion.beginTransaction();
            sesion.update(institucion);
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
     * Metodo que trae una institución de la BD a partir de su id
     *
     * @param id El id de la institución
     * @return Una institución
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Instituciones traerInstitucion(BigDecimal id) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        Instituciones institucion = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Instituciones where id =:id", Instituciones.class);
            elQuery.setParameter("id", id);
            institucion = (Instituciones) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return institucion;
    }

    @Override
    public Instituciones traerInstitucionporNombre(String nombre, BigDecimal id) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        Instituciones institucion = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Instituciones where nombreInstitucion =:nombre and id !=:id", Instituciones.class);
            elQuery.setParameter("id", id);
            elQuery.setParameter("nombre", nombre);
            institucion = (Instituciones) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        }catch (NoResultException n){
            return null;
        }catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return institucion;
    }

}

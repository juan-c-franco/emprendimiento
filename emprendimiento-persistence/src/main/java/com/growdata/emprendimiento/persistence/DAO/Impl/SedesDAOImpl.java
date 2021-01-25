/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SedesDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Sedes;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Franco
 */
@Repository
public class SedesDAOImpl implements SedesDAO {

    private SessionFactory sessionFactory = HibernateJdbcSimpc.getSession();

    /**
     * Método para ubicar todas las sedes dado un Oferente.
     *
     * @param idOferente Identificador del Oferente
     * @return Lista con las sedes que cumplan con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Sedes> getSedesPorOferente(BigDecimal idOferente) throws Exception {
        List<Sedes> sedes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Sedes "
                            + " where idInstitucion = :idOferente"
                            + " and  estado = 'A'"
                            + " order by nombre", Sedes.class);
            elQuery.setParameter("idOferente", idOferente);
            //obtener  resultado
            sedes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sedes;
    }
    /**
     * Método que trae todas las sedes parametrizadas de la BD
     * @return Una lista de sedes
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Sedes> getSedesParametrizar() throws Exception {
          List<Sedes> sedes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Sedes", Sedes.class);
            //obtener  resultado
            sedes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sedes;
    }
    /**
     * Método que trae una sede de la BD a partir de su id
     * @param id El id de la sede a traer
     * @return Una sede
     * @throws Exception Cualquier Exception que pueda ser lanzada 
     */
    @Override
    public List<Sedes> getSedeporId(BigDecimal id) throws Exception {
            Sedes sede = new Sedes();
            List<Sedes> sedes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sede = (Sedes) sesion.get(Sedes.class, id);        
            sesion.getTransaction().commit();
            sedes.add(sede);
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sedes;
    }

    /**
     * Método encargado de ubicar las Sedes por Municipio.
     *
     * @param municipio Identificador del Municipio.
     * @return Lista de sedes que cumplan con el criterio de búsqueda.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Sedes> getSedesPorMunicipio(BigDecimal municipio) throws Exception {
        List<Sedes> sedes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Sedes "
                            + " where municipios.id = :municipio"
                            + " and  estado = 'A'"
                            + " order by nombre", Sedes.class);
            elQuery.setParameter("municipio", municipio);
            //obtener  resultado
            sedes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sedes;
    }

    /**
     * Método encargado de ubicar una sede por su Identifiacor.
     *
     * @param Id Identificador de la sede.
     * @return Sede que cumple con los parámetros.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Sedes getSedesPorId(BigDecimal Id) throws Exception {
        Sedes sede = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Sedes "
                            + " where id = :Id", Sedes.class);
            elQuery.setParameter("Id", Id);
            //obtener  resultado
            sede = (Sedes) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sede;
    }

}

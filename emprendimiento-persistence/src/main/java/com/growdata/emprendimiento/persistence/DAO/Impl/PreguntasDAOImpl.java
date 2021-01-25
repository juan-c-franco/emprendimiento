/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.PreguntasDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;

import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grow Data PC
 */
@Repository
public class PreguntasDAOImpl implements PreguntasDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae las preguntas de sensibilización de una caja de
     * compensación de la BD
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @return Una lista de preguntas
     * @throws java.lang.Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    @Transactional
    public List<Preguntas> getPreguntas(BigDecimal idcajacompensacion) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Preguntas> preguntas = new ArrayList();
        try {
            //Empezar transaccion
            sesion.beginTransaction();
            //crear query
            Query<Preguntas> elQuery
                    = sesion.createQuery("select p from Preguntas p, Temasevaluacion t where p.herramientasvaloracion.idherramienta=1 and"
                            + " p.cajacompensacion.idcajacompensacion=:idcajacompensacion"
                            + " and p.temasevaluacion.idtema = t.idtema"
                            + " and t.estado=1", Preguntas.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtener  resultado
            preguntas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            throw new Exception(MensajesBD.ERROR_PREGUNTAS_INEXISTENTES, n);
        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_PREGUNTAS_INEXISTENTES)) {
                throw new Exception(MensajesBD.ERROR_PREGUNTAS_INEXISTENTES, ex);
            }
            throw new Exception(MensajesBD.ERROR_PREGUNTAS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return preguntas;
    }

    /**
     * Metodo que trae las preguntas de valoracion de la BD a partir de un id de
     * caja de compensacion
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @return Una lista de preguntas
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Preguntas> getPreguntasValoracion(BigDecimal idcajacompensacion) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Preguntas> preguntas = new ArrayList();
        try {
            //Empezar transaccion
            sesion.beginTransaction();
            //crear query
            Query<Preguntas> elQuery
                    = sesion.createQuery("select p from Preguntas p, Temasevaluacion t where p.herramientasvaloracion.idherramienta=5 and"
                            + " p.cajacompensacion.idcajacompensacion=:idcajacompensacion"
                            + " and p.temasevaluacion.idtema = t.idtema"
                            + " and t.estado=1"
                            + " order by p.temasevaluacion.idtema asc", Preguntas.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtener  resultado
            preguntas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_PREGUNTAS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return preguntas;
    }

    /**
     * Metodo que trae las preguntas de valoracion individual de la BD a partir
     * de un id de caja de compensacion
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @return Una lista de preguntas
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Preguntas> getPreguntasValoracionInd(BigDecimal idcajacompensacion) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Preguntas> preguntas = new ArrayList();
        try {
            //Empezar transaccion
            sesion.beginTransaction();
            //crear query
            Query<Preguntas> elQuery
                    = sesion.createQuery("select p from Preguntas p, Temasevaluacion t where p.herramientasvaloracion.idherramienta=2 and"
                            + " p.cajacompensacion.idcajacompensacion=:idcajacompensacion"
                            + " and p.temasevaluacion.idtema = t.idtema"
                            + " and t.estado=1", Preguntas.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtener  resultado
            preguntas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_PREGUNTAS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return preguntas;
    }

    /**
     * Metodo que trae las preguntas de valoracion grupal de la BD a partir de
     * un id de caja de compensacion
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @return Una lista de preguntas
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Preguntas> getPreguntasValoracionGrupal(BigDecimal idcajacompensacion) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Preguntas> preguntas = new ArrayList();
        try {
            //Empezar transaccion
            sesion.beginTransaction();
            //crear query
            Query<Preguntas> elQuery
                    = sesion.createQuery("select p from Preguntas p, Temasevaluacion t where p.herramientasvaloracion.idherramienta=3 and"
                            + " p.cajacompensacion.idcajacompensacion=:idcajacompensacion"
                            + " and p.temasevaluacion.idtema = t.idtema"
                            + " and t.estado=1", Preguntas.class);       
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtener  resultado
            preguntas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_PREGUNTAS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return preguntas;
    }

    /**
     * Metodo que borra una pregunta de la BD por su id
     *
     * @param idPregunta El id de la pregunta
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public void borrarPregunta(BigDecimal idPregunta) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //Empezar transaccion
            sesion.beginTransaction();
            //crear query
            Query<Preguntas> elQuery
                    = sesion.createQuery("delete from Preguntas where idpregunta=:idPregunta");
            elQuery.setParameter("idPregunta", idPregunta);
            elQuery.executeUpdate();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_BORRAR_PREGUNTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.HerramientaValoracionDAO;
import com.growdata.emprendimiento.persistence.entidad.Herramientasvaloracion;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Danny Fernando Guerrero Gelpud
 */
@Repository
public class HerramientaValoracionDAOImpl implements HerramientaValoracionDAO {

    private final SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae las herramientas de valoracion de la BD
     *
     * @return Una lista con las herramientas de valoración
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Herramientasvaloracion> getHerramientasValoracion() throws Exception {
        List<Herramientasvaloracion> herramientasValoracion = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Herramientasvaloracion", Herramientasvaloracion.class);
            herramientasValoracion = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return herramientasValoracion;
    }

    /**
     * Metodo que trae una herramienta de valoracion a partir de su id de la BD
     *
     * @param idHerramientaValoracion El id de la herramienta de valoración
     * @return Una herramienta de valoración
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Herramientasvaloracion getHerramientaValoracion(BigDecimal idHerramientaValoracion) throws Exception {
        Herramientasvaloracion herramientasvaloracion = new Herramientasvaloracion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Herramientasvaloracion where idherramienta=:idherramienta ", Herramientasvaloracion.class);
            q.setParameter("idherramienta", idHerramientaValoracion);
            herramientasvaloracion = (Herramientasvaloracion) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return herramientasvaloracion;
    }

    /**
     * Metodo que trae los temas de evaluacion de una caja de la BD a partir de
     * un id de caja de compensacion y un id de herramienta de valoración
     *
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idHerramienta El id de la herramienta de valoración
     * @return Una lista de temas de evaluación
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Temasevaluacion> getTemasEvaluacion(BigDecimal idCajaCompensacion,
            BigDecimal idHerramienta) throws Exception {
        List<Temasevaluacion> temasEvaluacion = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Temasevaluacion where cajacompensacion.idcajacompensacion=:idCajaCompensacion and herramientasvaloracion.idherramienta=:idherramienta ", Temasevaluacion.class);
            q.setParameter("idCajaCompensacion", idCajaCompensacion);
            q.setParameter("idherramienta", idHerramienta);
            temasEvaluacion = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return temasEvaluacion;
    }

    /**
     * Metodo que crea un tema de evaluacion en la BD
     *
     * @param temasEvaluacion el tema de evaluación a crear
     * @return El id del tema de evaluación creado
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public BigDecimal setTemaEvaluacion(Temasevaluacion temasEvaluacion) throws Exception {
        BigDecimal id = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            id = (BigDecimal) sesion.save(temasEvaluacion);
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
     * Metodo que trae un tema de evaluacion a partir de su id de la BD
     *
     * @param idTemaEvaluacion El id del tema de evaluación
     * @return Un tema de evaluación
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Temasevaluacion getTraerTemaEvaluacion(BigDecimal idTemaEvaluacion) throws Exception {
        Temasevaluacion temaEvaluacion = new Temasevaluacion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Temasevaluacion where idtema=:idtema ", Temasevaluacion.class);
            q.setParameter("idtema", idTemaEvaluacion);
            temaEvaluacion = (Temasevaluacion) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return temaEvaluacion;
    }

    /**
     * Metodo que actualiza un tema de evaluacion
     *
     * @param temasEvaluacion El tema de evaluación con la información a
     * actualizar
     * @return Una respuesta que dice si el tema se actualizo exitosamente o no
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public String updateTemaEvaluacion(Temasevaluacion temasEvaluacion) throws Exception {
        String resp = "";
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(temasEvaluacion);
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae las preguntas de un tema de la BD a partir de un id de
     * tema, un id de caja de compensacion y un id de herramienta
     *
     * @param idTema El id del tema
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idHerramienta El id de la herramienta de evaluación
     * @return Una lista de preguntas
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Preguntas> getTraerPreguntas(BigDecimal idTema,
            BigDecimal idCajaCompensacion, BigDecimal idHerramienta) throws Exception {
        List<Preguntas> preguntas = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Preguntas where temasevaluacion.idtema=:idTema and cajacompensacion.idcajacompensacion=:idCajaCompensacion and herramientasvaloracion.idherramienta=:idherramienta ", Preguntas.class);
            q.setParameter("idTema", idTema);
            q.setParameter("idCajaCompensacion", idCajaCompensacion);
            q.setParameter("idherramienta", idHerramienta);
            preguntas = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return preguntas;
    }

    /**
     * Metodo que actualiza una pregunta en la BD
     *
     * @param pregunta La pregunta con la información a actualizar
     * @return Respuesta que dice si se actualizó la pregunta exitosamente o no
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public String updatePreguntaTema(Preguntas pregunta) throws Exception {
        String resp = "";
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(pregunta);
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que crea una pregunta en la BD
     *
     * @param pregunta La pregunta a crear
     * @return El id de la pregunta creada
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public BigDecimal setPreguntaTema(Preguntas pregunta) throws Exception {
        BigDecimal id = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            id = (BigDecimal) sesion.save(pregunta);
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
     * Metodo que trae una pregunta de la BD a partir de su id
     *
     * @param idPregunta El id de la pregunta
     * @return Una pregunta
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Preguntas getTraerPreguntaTema(BigDecimal idPregunta) throws Exception {
        Preguntas pregunta = new Preguntas();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Preguntas where idpregunta=:idpregunta ", Preguntas.class);
            q.setParameter("idpregunta", idPregunta);
            pregunta = (Preguntas) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return pregunta;
    }
}

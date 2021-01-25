/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class TemasEvaluacionDAOImpl implements TemasEvaluacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae un tema de evaluacion a partir de su id
     *
     * @param idTema El id del tema de evaluación
     * @return Un tema de evaluación
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Temasevaluacion traerTemasPorTema(BigDecimal idTema) throws Exception {
        Temasevaluacion tema = new Temasevaluacion();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Temasevaluacion where idtema=:idTema", Temasevaluacion.class);
            elQuery.setParameter("idTema", idTema);
            //obtengo resultados del query
            tema = (Temasevaluacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_TEMA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return tema;
    }

    /**
     * Metodo que borra un tema y todas las preguntas que este contenga apartir
     * de un id de tema, un id de caja de compensacion y un id de herramienta
     *
     * @param idTema El id del tema de evaluación
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idHerramienta El id de la herramienta de evaluación
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public void borrarTemaEvaluacion(BigDecimal idTema, BigDecimal idCajaCompensacion,
            BigDecimal idHerramienta) throws Exception {

        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery = sesion.createQuery("delete from Preguntas where idtema=:idTema and"
                    + " idcajacompensacion=:idCajaCompensacion and idherramienta=:idHerramienta");
            elQuery.setParameter("idTema", idTema);
            elQuery.setParameter("idCajaCompensacion", idCajaCompensacion);
            elQuery.setParameter("idHerramienta", idHerramienta);
            Query elQuery2
                    = sesion.createQuery("delete from Temasevaluacion where idtema=:idTema");
            elQuery2.setParameter("idTema", idTema);
            elQuery.executeUpdate();
            elQuery2.executeUpdate();
            sesion.getTransaction().commit();
        } catch (ConstraintViolationException c) {
            throw new Exception(MensajesBD.ERROR_BORRAR_TEMA_C, c);
        } catch (Exception ex) {
            if (ex.equals(MensajesBD.ERROR_BORRAR_TEMA_C)) {
                sesion.getTransaction().rollback();
                throw new Exception(MensajesBD.ERROR_BORRAR_TEMA_C, ex);
            } else {
                sesion.getTransaction().rollback();
                throw new Exception(MensajesBD.ERROR_BORRAR_TEMA, ex);
            }
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

    }

}

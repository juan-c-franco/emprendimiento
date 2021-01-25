/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EvaluacionIntegrantesComiteDAO;
import com.growdata.emprendimiento.persistence.commons.CalificacionIntegrantesComite;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionemprendimientos;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionintegrantescomite;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class EvaluacionIntegrantesComiteDAOImpl implements EvaluacionIntegrantesComiteDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que crea o actualiza una calificacion individual
     *
     * @param idemprendimiento El id del emprendimiento
     * @param evaluacion La evaluación a crear o actualizar
     * @return El id de la calificación creada o actualizada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long calificacionIndividual(long idemprendimiento, Evaluacionintegrantescomite evaluacion) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Evaluacionemprendimientos eval = new Evaluacionemprendimientos();
        long id;
        try {
            sesion.beginTransaction();
            try {
                Query elQuery = sesion.createQuery("from Evaluacionemprendimientos where idemprendimiento=:idemprendimiento and fecharegistro = (select max(fecharegistro) from Evaluacionemprendimientos)");
                elQuery.setParameter("idemprendimiento", idemprendimiento);
                eval = (Evaluacionemprendimientos) elQuery.getSingleResult();

            } catch (NoResultException n) {
                throw new Exception(MensajesBD.ERROR_CARGA_EVALUACION_EMPRENDIMIENTO, n);
            } catch (Exception ex) {
                if (ex.getMessage().equals(MensajesBD.ERROR_CARGA_EVALUACION_EMPRENDIMIENTO)) {
                    throw new Exception(MensajesBD.ERROR_CARGA_EVALUACION_EMPRENDIMIENTO, ex);
                }
                throw new Exception(MensajesBD.ERROR_REGISTRO_EVALUACION_INDIVIDUAL, ex);
            }

            Query elQuery2 = sesion.createQuery("from Evaluacionintegrantescomite where"
                    + " idfuncionario=:idfuncionario and idevaluacion=:idevaluacion", Evaluacionintegrantescomite.class);
            elQuery2.setParameter("idevaluacion", eval.getIdevaluacion());
            elQuery2.setParameter("idfuncionario", evaluacion.getFuncionario().getIdfuncionario());
            Evaluacionintegrantescomite e = (Evaluacionintegrantescomite) elQuery2.getSingleResult();
            throw new Exception(MensajesBD.ERROR_REGISTRO_EVA_IND_EXISTENTE);
        } catch (NoResultException n) {
            evaluacion.setEvaluacionemprendimientos(eval);
            id = (long) sesion.save(evaluacion);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_REGISTRO_EVA_IND_EXISTENTE)) {
                throw new Exception(MensajesBD.ERROR_REGISTRO_EVA_IND_EXISTENTE, ex);
            }
            if (ex.getMessage().equals(MensajesBD.ERROR_CARGA_EVALUACION_EMPRENDIMIENTO)) {
                throw new Exception(MensajesBD.ERROR_CARGA_EVALUACION_EMPRENDIMIENTO, ex);
            }
            throw new Exception(MensajesBD.ERROR_REGISTRO_EVALUACION_INDIVIDUAL, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae las calificaciones de comité de un emprendimiento de la
     * BD a partir de su id
     *
     * @param idEmprendimiento El id del emprendimiento
     * @return Una lista de calificaciones de comité de un emprendimiento
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<CalificacionIntegrantesComite> getCalificacionesPorEmprendimiento(long idEmprendimiento) throws Exception {
        List<CalificacionIntegrantesComite> evaluacioness;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("SELECT new list(fn.primernombre, fn.primerapellido, ei.calificacionindividual)"
                    + " FROM Integrantescomite it"
                    + " INNER JOIN Comiteevaluacion ct ON ct.idcomite = it.comiteevaluacion.idcomite"
                    + " INNER JOIN Funcionario fn ON fn.idfuncionario = it.funcionario.idfuncionario"
                    + " INNER JOIN Evaluacionemprendimientos ev ON ev.emprendimiento.idemprendimiento = :id"
                    + " FULL JOIN Evaluacionintegrantescomite ei ON ei.evaluacionemprendimientos.idevaluacion = ev.idevaluacion AND ei.funcionario.idfuncionario = fn.idfuncionario"
                    + " INNER JOIN Cajacompensacion cj ON cj.idcajacompensacion = ct.cajacompensacion.idcajacompensacion"
                    + " WHERE ev.emprendimiento.cajacompensacion.idcajacompensacion = cj.idcajacompensacion");
            q.setParameter("id", idEmprendimiento);
            evaluacioness = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return evaluacioness;
    }
}

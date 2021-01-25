/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EncuestaDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.Date;
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
public class EncuestaDAOImpl implements EncuestaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae una encuesta a partir de un id de beneficiario y un id de
     * encuesta
     *
     * @param idBeneficiario El id del beneficiario
     * @param idEncuesta El id de la encuesta
     * @return Una encuesta
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Encuesta getEncuesta(int idBeneficiario, long idEncuesta) throws Exception {
        Encuesta encuesta = new Encuesta();
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        // Session sesion = sessionFactory.getCurrentSession();

        try {
            //Empezar ]Transaccion
            sesion.beginTransaction();
            //creo el query
            Query elQuery
                    = sesion.createQuery("from Encuesta where idbeneficiario=:idBeneficiario and idencuesta=:idEncuesta", Encuesta.class);
            elQuery.setParameter("idBeneficiario", idBeneficiario);
            elQuery.setParameter("idEncuesta", idEncuesta);
            //obtener resultado

            encuesta = (Encuesta) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            throw new Exception(MensajesBD.ERROR_ENCUESTA_INEXISTENTE, n);
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGAR_ENCUESTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return encuesta;
    }

    /**
     * Metodo que actualiza la encuesta en al BD y guarda las respuestas en la
     * BD
     *
     * @param idEncuesta El id de la encuesta
     * @param fecha La fecha de diligenciamiento
     * @param respuestas Las respuestas de la encuesta
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void actualizarEncuesta(long idEncuesta, Date fecha, List<Respuestasencuesta> respuestas) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();

            Query elQuery
                    = sesion.createQuery("update Encuesta set diligenciada = '1',"
                            + " fechadiligenciamiento=:fecha"
                            + " where idEncuesta =:idEncuesta");
            elQuery.setParameter("idEncuesta", idEncuesta);
            elQuery.setParameter("fecha", fecha);
            elQuery.executeUpdate();
            respuestas.forEach((r) -> {
                sesion.save(r);
            });
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_REGISTRO_DILIGENCIAMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Metodo que crea una encuesta en la BD
     *
     * @param encuesta La encuesta a crear
     * @return El id de la encuesta creada
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public long crearEncuesta(Encuesta encuesta) throws Exception {

        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        // Session sesion = sessionFactory.getCurrentSession();
        long idEncuesta;
        try {
            //Empezar ]Transaccion
            sesion.beginTransaction();
            //creo el query
            idEncuesta = (long) sesion.save(encuesta);

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CREANDO_ENCUESTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return idEncuesta;
    }

}

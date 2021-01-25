/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.RutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
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
public class RutaAcompanamientoATDAOImpl implements RutaAcompanamientoATDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que crea una ruta de acompañamiento
     *
     * @param ruta La ruta a crear
     * @return El id de la ruta creada
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public long crearRuta(Rutaacompanamientoat ruta) throws Exception {
        long id = -1;
        Rutaacompanamientoat ruta2 = new Rutaacompanamientoat();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Emprendimiento where Idemprendimiento =:idEmprendimiento", Emprendimiento.class);
            elQuery.setParameter("idEmprendimiento", ruta.getEmprendimiento().getIdemprendimiento());
            Emprendimiento emp = (Emprendimiento) elQuery.getSingleResult();
            ruta.setEmprendimiento(emp);
            // creo el query
            id = (Long) sesion.save(ruta);
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CREACION_RUTA_ACOMPANAMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae una ruta de acompañamiento a partir de un id de
     * emprendimiento
     *
     * @param idEmprendimiento El id del emprendimiento
     * @return Una ruta de acompañamiento
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Rutaacompanamientoat getRuta(long idEmprendimiento) throws Exception {
        Rutaacompanamientoat ruta = new Rutaacompanamientoat();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery = sesion.createQuery("from Rutaacompanamientoat where idemprendimiento=:idEmprendimiento", Rutaacompanamientoat.class);
            elQuery.setParameter("idEmprendimiento", idEmprendimiento);
            ruta = (Rutaacompanamientoat) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CREACION_RUTA_ACOMPANAMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return ruta;
    }

}

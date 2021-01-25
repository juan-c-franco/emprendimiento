/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.RutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Rutacapacitacion;
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
public class RutaCapacitacionDAOImpl implements RutaCapacitacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que crea una ruta de capacitacion en la BD
     *
     * @param ruta La ruta a crear
     * @return El id de la ruta creada
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public long crearRuta(Rutacapacitacion ruta) throws Exception {
        long id = -1;
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            id = (Long) sesion.save(ruta);

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CREACION_RUTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae una ruta de capacitacion de la BD a partir de un id de un
     * beneficiario
     *
     * @param idBeneficiario El id del beneficiario
     * @return Una ruta de capacitación
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Rutacapacitacion getRuta(long idBeneficiario) throws Exception {
        //obtener sesion de hibernate
        Rutacapacitacion rutaCapacitacion = new Rutacapacitacion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery = sesion.createQuery("from Rutacapacitacion where idbeneficiario=:idBeneficiario", Rutacapacitacion.class);
            elQuery.setParameter("idBeneficiario", idBeneficiario);
            rutaCapacitacion = (Rutacapacitacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            
            throw new Exception(MensajesBD.ERROR_TRAER_RUTA);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return rutaCapacitacion;
    }

}

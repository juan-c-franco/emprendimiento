/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EntidadesFinancierasDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
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
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class EntidadesFinancierasDAOImpl implements EntidadesFinancierasDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * metodo que trae todas las entidades financieras de la BD
     *
     * @return Una lista con todas las entidades financieras
     */
    @Override
    public List<Entidadesfinancieras> getEntidadesFinancierasAdmin() throws Exception {
        List<Entidadesfinancieras> entidades = new ArrayList();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {

            //empiezo la transaccion
            sesion.beginTransaction();
            //creo el query
            Query<Entidadesfinancieras> elQuery
                    = sesion.createQuery("from Entidadesfinancieras", Entidadesfinancieras.class);
            //obtener resultados del query
            entidades = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ENTIDADES, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return entidades;
    }

    /**
     * Metodo que crea una entidad financiera
     *
     * @param entidad La entidad financiera a crear
     * @return Respuesta si se creo la entidad financiera satisfactoriamente o
     * no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public BigDecimal setEntidadFinanciera(Entidadesfinancieras entidad) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        BigDecimal id;
        try {
            //empiezo la transaccion
            sesion.beginTransaction();

            //creo el query
            id = (BigDecimal) sesion.save(entidad);

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_ENTIDAD_FINANCIERA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae una entidad financiera por su id
     *
     * @param identidadfinanciera EL id de la entidad financiera
     * @return Una entidad financiera
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Entidadesfinancieras getEntidadFinanciera(BigDecimal identidadfinanciera) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Entidadesfinancieras entidad = new Entidadesfinancieras();
        String resp;
        try {
            //empiezo la transaccion
            sesion.beginTransaction();

            //creo el query
            Query elQuery
                    = sesion.createQuery("from Entidadesfinancieras where identidadfinanciera=:identidadfinanciera", Entidadesfinancieras.class);
            elQuery.setParameter("identidadfinanciera", identidadfinanciera);
            entidad = (Entidadesfinancieras) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ENTIDAD_FINANCIERA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return entidad;
    }

    /**
     * Metodo que actualiza una entidad financiera
     *
     * @param entidad La entidad financiera con la información a actualizar
     * @return respuesta si se actualizó la entidad financiera
     * satisfactoriamente o no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public String setEntidadFinancieraM(Entidadesfinancieras entidad) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {
            //empiezo la transaccion
            sesion.beginTransaction();

            //creo el query
            sesion.update(entidad);

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_MODIFICAR_ENTIDAD_FINANCIERA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae una entidad financiera por su nombre
     *
     * @param nombreentidad Nombre de la entidad financiera
     * @return Una entidad financiera
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Entidadesfinancieras getEntidadFinancieraPorNombre(String nombreentidad) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Entidadesfinancieras entidad = new Entidadesfinancieras();

        try {
            //empiezo la transaccion
            sesion.beginTransaction();

            //creo el query
            Query elQuery
                    = sesion.createQuery("from Entidadesfinancieras where nombreentidad=:nombreentidad", Entidadesfinancieras.class);
            elQuery.setParameter("nombreentidad", nombreentidad);
            entidad = (Entidadesfinancieras) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ENTIDAD_FINANCIERA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return entidad;
    }

    /**
     * Metodo que trae una entidad financiera a partir de su nombre, sin incluir
     * la entidad con el id que recibe de parametro
     *
     * @param nombreentidad Nombre de la entidad financiera
     * @param identidadfinanciera Id de la entidad financiera
     * @return una entidad financiera
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Entidadesfinancieras getEntidadFinancieraPorNombreM(String nombreentidad, BigDecimal identidadfinanciera) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Entidadesfinancieras entidad = new Entidadesfinancieras();

        try {
            //empiezo la transaccion
            sesion.beginTransaction();

            //creo el query
            Query elQuery
                    = sesion.createQuery("from Entidadesfinancieras where nombreentidad=:nombreentidad and identidadfinanciera<>:identidadfinanciera", Entidadesfinancieras.class);
            elQuery.setParameter("nombreentidad", nombreentidad);
            elQuery.setParameter("identidadfinanciera", identidadfinanciera);
            entidad = (Entidadesfinancieras) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ENTIDAD_FINANCIERA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return entidad;
    }

    /**
     * Metodo que trae todas las entidades financieras activas de la BD
     *
     * @return Una lista con todas las entidades financieras activas
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Entidadesfinancieras> getEntidadesFinancieras() throws Exception {
        List<Entidadesfinancieras> entidades = new ArrayList();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {

            //empiezo la transaccion
            sesion.beginTransaction();
            //creo el query
            Query<Entidadesfinancieras> elQuery
                    = sesion.createQuery("from Entidadesfinancieras where estado ='1'", Entidadesfinancieras.class);
            //obtener resultados del query
            entidades = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ENTIDADES, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return entidades;
    }

    /**
     * Metodo que borra una entidad financiera por su id
     *
     * @param idEntidadFinanciera El id de la entidad financiera
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void borrarEntidadFinanciera(BigDecimal idEntidadFinanciera) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {

            //empiezo la transaccion
            sesion.beginTransaction();
            //creo el query
            Query elQuery
                    = sesion.createQuery("delete from Entidadesfinancieras where identidadfinanciera =:idEntidadFinanciera");
            elQuery.setParameter("idEntidadFinanciera", idEntidadFinanciera);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_BORRAR_ENTIDAD, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }
}

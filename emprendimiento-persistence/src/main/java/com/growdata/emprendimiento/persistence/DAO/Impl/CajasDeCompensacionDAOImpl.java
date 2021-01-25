/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.CajasDeCompensacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
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
public class CajasDeCompensacionDAOImpl implements CajasDeCompensacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae de la BD todas las cajas de compensación activas
     *
     * @return Lista de Cajas de Compensación
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Cajacompensacion> getCajasDeCompensacion() throws Exception {
        List<Cajacompensacion> cajas = new ArrayList();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Cajacompensacion where idestadocajacompensacion<>0", Cajacompensacion.class);
            //obtengo resultados del query
            cajas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_CAJAS_COMPENSACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return cajas;
    }

    /**
     * Metodo que crea una caja de compensacion
     *
     * @param caja La caja de compensación a crear
     * @return Id de la caja creada
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public BigDecimal setCajaCompensacion(Cajacompensacion caja) throws Exception {
        BigDecimal id;
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            id = (BigDecimal) sesion.save(caja);

            sesion.getTransaction().commit();

        } catch (PersistenceException ex) {
            throw new Exception(
                    MensajesBD.ERROR_CODIGO_CAJA_COMPENSACION_REPETIDO, ex);
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_CAJA_COMPENSACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae una caja de la BD por su id
     *
     * @param idcajacompensacion Id de la caja de compensación
     * @return Respuesta con Caja de Compensación que cumpla con el criterio de
     * búsqueda.
     * @throws Exception Cualquier Excepción que pueda ser lanzada.
     */
    @Override
    public Cajacompensacion getCajaCompensacion(BigDecimal idcajacompensacion) throws Exception {
        Cajacompensacion caja = new Cajacompensacion();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Cajacompensacion where idcajacompensacion=:idcajacompensacion ", Cajacompensacion.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtengo resultados del query
            caja = (Cajacompensacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_CAJA_COMPENSACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return caja;
    }

    /**
     * Metodo que actualiza una caja de compensacion
     *
     * @param caja La caja de compensación con la información a actualizar
     * @return Respuesta si se actualizo la caja o no
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public String setCajaCompensacionM(Cajacompensacion caja) throws Exception {
        String resp = "";
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            sesion.update(caja);

            sesion.getTransaction().commit();
            resp = "1";
        } catch (PersistenceException ex) {
            throw new Exception(
                    MensajesBD.ERROR_CODIGO_CAJA_COMPENSACION_REPETIDO, ex);
        } catch (Exception ex) {
            throw new Exception(
                    MensajesBD.ERROR_MODIFICAR_CAJA_COMPENSACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae una caja de compensación a partir de su nombre
     *
     * @param nombrecajacompensacion Nombre de la caja de compensación
     * @return Una caja de compensación
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public Cajacompensacion getCajaCompensacionPorNombre(String nombrecajacompensacion) throws Exception {
        Cajacompensacion caja = new Cajacompensacion();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Cajacompensacion where nombrecajacompensacion=:nombrecajacompensacion ", Cajacompensacion.class);
            elQuery.setParameter("nombrecajacompensacion", nombrecajacompensacion);
            //obtengo resultados del query
            caja = (Cajacompensacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_CAJA_COMPENSACION, ex);

        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return caja;
    }

    /**
     * Metodo que trae una caja de compensación de la BD a partir de su nombre y
     * que no sea igual al id que le llega de parametro
     *
     * @param nombrecajacompensacion Nombre de la caja de compensación
     * @param idcajacompensacion Id de la caja de compensación
     * @return Una caja de compensación
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public Cajacompensacion getCajaCompensacionPorNombreM(String nombrecajacompensacion, BigDecimal idcajacompensacion) throws Exception {
        Cajacompensacion caja = new Cajacompensacion();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Cajacompensacion where nombrecajacompensacion=:nombrecajacompensacion and idcajacompensacion<>:idcajacompensacion ", Cajacompensacion.class);
            elQuery.setParameter("nombrecajacompensacion", nombrecajacompensacion);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtengo resultados del query
            caja = (Cajacompensacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_CAJA_COMPENSACION, ex);

        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return caja;
    }

    /**
     * Metodo que trae todas las cajas de compensacion de la BD
     *
     * @return Lista con todas las cajas de compensación
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public List<Cajacompensacion> getCajasDeCompensacionAdmin() throws Exception {
        List<Cajacompensacion> cajas = new ArrayList();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Cajacompensacion", Cajacompensacion.class);
            //obtengo resultados del query
            cajas = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_CAJAS_COMPENSACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return cajas;
    }

    /**
     * Metodo que borra una caja de compensacion por su id
     *
     * @param idcajacompensacion id de la caja de compensación
     * @throws Exception Cualquier Excepción que pueda ser lanzada
     */
    @Override
    public void borrarCajaCompensacion(BigDecimal idcajacompensacion) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {

            //empiezo la transaccion
            sesion.beginTransaction();
            //creo el query
            Query elQuery
                    = sesion.createQuery("delete from Cajacompensacion where idcajacompensacion =:idcajacompensacion");
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_BORRAR_CAJA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }
}

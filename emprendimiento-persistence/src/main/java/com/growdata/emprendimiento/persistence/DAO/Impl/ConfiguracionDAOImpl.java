/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ConfiguracionDAO;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
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
public class ConfiguracionDAOImpl implements ConfiguracionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO responsable cargar todas las configuraciones.
     *
     * @return Lista de configuraciones.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Configuracion> getConfiguraciones() throws Exception {
        List<Configuracion> respuesta = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            respuesta = sesion.createQuery("FROM Configuracion ORDER BY idconfiguracion", Configuracion.class).getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return respuesta;
    }

    /**
     * DAO responsable de guardar los cambios en las configuraciones.
     *
     * @param configuraciones Lista de configuraciones
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void setConfiguraciones(List<Configuracion> configuraciones) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            for (Configuracion c : configuraciones) {
                sesion.update(c);
            }
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Metodo que trae una configuración de la BD a partir de su id
     *
     * @param idConfiguracion El id de la configuración
     * @return Una configuración
     * @throws Exception Cualquier exception que pueda ser lanzada
     */
    @Override
    public Configuracion getConfiguracion(BigDecimal idConfiguracion) throws Exception {
        Configuracion respuesta = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("From Configuracion where idconfiguracion=:idConfiguracion", Configuracion.class);
            elQuery.setParameter("idConfiguracion", idConfiguracion);
            respuesta = (Configuracion) elQuery.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return respuesta;
    }
}

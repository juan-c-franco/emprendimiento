/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.LogAuditoriaDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Logauditoria;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class LogAuditoriaDAOImpl implements LogAuditoriaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que guarda un registro en el log de auditoria en la BD
     *
     * @param log El registro del log a guardar
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public void registrarLog(Logauditoria log) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            sesion.save(log);

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_LOG_AU, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Metodo que trae registros del log de auditoria de la BD que se encuentren
     * entre una fecha inicial y una fecha final
     *
     * @param fechaI La fecha inicial
     * @param fechaF La fecha final
     * @return Una lista con los registros del log
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Logauditoria> getLogsXFecha(Date fechaI, Date fechaF) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Logauditoria> logs = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
//            if (fechaI.compareTo(fechaF)==0) {
//                Query elQuery
//                        = sesion.createQuery("from Logauditoria where fecharegistro =:fechaI", Logauditoria.class);
//                elQuery.setParameter("fechaI", fechaI);
//
//                logs = elQuery.getResultList();
//            } else {
            Query elQuery
                    = sesion.createQuery("from Logauditoria where fecharegistro between :fechaI and :fechaF", Logauditoria.class);
            elQuery.setParameter("fechaI", fechaI);
            elQuery.setParameter("fechaF", fechaF);
            logs = elQuery.getResultList();
//            }

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_TRAER_LOG_AU, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return logs;
    }

}

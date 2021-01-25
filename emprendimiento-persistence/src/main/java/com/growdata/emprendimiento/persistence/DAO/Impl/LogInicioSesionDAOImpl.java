/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Loginiciosesion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.growdata.emprendimiento.persistence.DAO.LogInicioSesionDAO;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class LogInicioSesionDAOImpl implements LogInicioSesionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que guarda registros en el log de inicio de sesion en la BD
     *
     * @param log El registro del log a guardar
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public void registrarLog(Loginiciosesion log) throws Exception {

        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            sesion.save(log);

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_LOG, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

    }

}

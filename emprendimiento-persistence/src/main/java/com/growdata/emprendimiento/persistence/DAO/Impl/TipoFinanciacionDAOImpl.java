/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TipoFinanciacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Tipofinanciacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
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
public class TipoFinanciacionDAOImpl implements TipoFinanciacionDAO {

  private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los tipos de financiacion de la BD
     *
     * @return Una lista con los tipos de financiación
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Tipofinanciacion> getTiposFinanciacion() throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Tipofinanciacion> tiposFinanciacion = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Tipofinanciacion", Tipofinanciacion.class);
            //obtengo resultados del query
            tiposFinanciacion = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_TIPOS_FINANCIACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return tiposFinanciacion;
    }

}

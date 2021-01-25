/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TipoDocumentoDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grow Data PC
 */
@Repository
public class TipoDocumentoDAOImpl implements TipoDocumentoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los tipos de documento de la BD
     *
     * @return Una lista con los tipos de documento
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    @Transactional
    public List<Tipodocumentoid> getTipodocumentoid() throws Exception {
        List<Tipodocumentoid> tipoDocumento = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();

            Query<Tipodocumentoid> elQuery
                    = sesion.createQuery("from Tipodocumentoid", Tipodocumentoid.class);

            tipoDocumento = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_TIPO, ex);
        }
        return tipoDocumento;

    }

    @Override
    public Tipodocumentoid getTipoDocumentoIdPorNombre(String nombre) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Tipodocumentoid tipo = new Tipodocumentoid();
        try {
            sesion.beginTransaction();
            Query<Tipodocumentoid> elQuery
                    = sesion.createQuery("from Tipodocumentoid where nombredocumento=:nombre", Tipodocumentoid.class);
            elQuery.setParameter("nombre", nombre);

            tipo = (Tipodocumentoid) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_TIPO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return tipo;
    }

}

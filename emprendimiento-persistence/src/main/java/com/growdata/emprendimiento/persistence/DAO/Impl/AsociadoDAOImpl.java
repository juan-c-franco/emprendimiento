/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
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
public class AsociadoDAOImpl implements AsociadoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO que busca la instacia asociados de un beneficiario.
     *
     * @param idBeneficiario Identificador de Beneficiario
     * @return Asociado que cumpla con el criterior de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Asociados getAsociadoXId(long idBeneficiario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Asociados asociado = new Asociados();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("select a from Asociados a"
                    + " where a.beneficiario.idbeneficiario=:idBeneficiario"
                    + " ORDER BY a.fecharegistro DESC", Asociados.class);
            elQuery.setParameter("idBeneficiario", idBeneficiario);
            elQuery.setMaxResults(1);

            asociado = (Asociados) elQuery.getSingleResult();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ASOCIADO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return asociado;
    }

    /**
     * DAO encargado de ubicar los asociados de cierto emprendimientio por su }
     * idemprendimiento.
     *
     * @param idEmprendimiento Identificador del Emprendimiento
     * @return Lista de Asociados vinculados al Emprendimiento
     * @throws Exception Cualquier Exception
     */
    @Override
    public List<Asociados> getAsociadosPorEmprendimiento(long idEmprendimiento) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Asociados> asociados = new ArrayList<Asociados>();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Asociados where emprendimiento.idemprendimiento=:idEmprendimiento", Asociados.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            asociados = q.getResultList();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return asociados;
    }

    /**
     * DAO encargado de ubicar asociados a un emprendimiento dado su nombre de
     * usuario y un determinado estado de usuario.
     *
     * @param estadoUsuario Estado en el que debe estar el usuario
     * @param userName Nombre del usuario
     * @return Asociado que cumple con los parámetros de entrada.
     * @throws Exception Cualquier Exception
     */
    @Override
    public Asociados getAsociadoPorUserName(BigDecimal estadoUsuario, String userName) throws Exception {
        Asociados response = new Asociados();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select a from Asociados a inner join a.beneficiario b"
                    + " inner join Users u on b.email=u.username where u.enabled=:idEstado and u.username=:userName "
                    + " order by a.fecharegistro desc", Asociados.class);
            q.setParameter("userName", userName);
            q.setParameter("idEstado", estadoUsuario);
            q.setMaxResults(1);
            response = (Asociados) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return response;
    }

    /**
     * Metodo que trae los asociados a un emprendimiento a partir de un id de em
     * prendimiento
     *
     * @param idEmprendimiento el id del emprendimiento
     * @return Una lista con los asociados a un emprendimiento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public List<Asociados> getAsociadosPorEmprendimiento2(long idEmprendimiento) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Asociados> asociados = new ArrayList<Asociados>();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Asociados where emprendimiento.idemprendimiento=:idEmprendimiento", Asociados.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            asociados = q.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return asociados;
    }
}

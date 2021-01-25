/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SeguimientoDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Observacionesseguimiento;
import com.growdata.emprendimiento.persistence.entidad.Paisescomercializa;
import com.growdata.emprendimiento.persistence.entidad.Seguimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 07/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class SeguimientoDAOImpl implements SeguimientoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de guardar información de seguimiento de un emprendimiento formalizado.
     *
     * @param formalizado Datos del Emprendimiento Formalizado
     * @param observaciones Observaciones del Seguimiento
     * @param seguimiento Datos del Seguimiento
     * @param financiacion Datos de la Financiación
     * @param finalizar Parámetro que indica si se va a finalizar el
     * emprendimiento o no.
     * @return Id del Seguimiento
     * @throws PersistenceException Exception de Persistencia que se pueda
     * originar
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public long guardarSeguimientoFormalizado(Formalizado formalizado,
            Observacionesseguimiento observaciones,
            Seguimiento seguimiento, Financiacion financiacion,
            boolean finalizar) throws PersistenceException, Exception {
        long id;
        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();

            if (finalizar) {
                Query q = sesion.createQuery("UPDATE Emprendimiento"
                        + " SET idestadoemprendimiento = 7"
                        + " WHERE idemprendimiento = :id");
                q.setParameter("id", formalizado.getEmprendimiento().getIdemprendimiento());
                q.executeUpdate();
            }

            //Debo crearlo
            if (formalizado.getIdformalizacion() == -1) {
                sesion.save(formalizado);
            } //Lo modifico
            else {
                Query q = sesion.createQuery("delete Paisescomercializa "
                        + "where formalizado.idformalizacion = :f");
                q.setParameter("f", formalizado.getIdformalizacion());
                q.executeUpdate();
                sesion.update(formalizado);
            }

            id = (long) sesion.save(seguimiento);
            sesion.save(observaciones);

            Query elQuery = sesion.createQuery("from Financiacion where idemprendimiento=:idEmprendimiento", Financiacion.class);
            elQuery.setParameter("idEmprendimiento", formalizado.getEmprendimiento().getIdemprendimiento());
            //obtengo resultados del query
            List<Financiacion> aux = elQuery.getResultList();

            if (aux.size() != 0) {
                Financiacion financiacion2 = aux.get(0);
                financiacion2.setCapitaltotal(financiacion.getCapitaltotal());
                financiacion2.setCapitaltrabajo(financiacion.getCapitaltrabajo());
                financiacion2.setEmpleosgenerados(financiacion.getEmpleosgenerados());
                financiacion2.setEmpleosporgenerar(financiacion.getEmpleosporgenerar());
                financiacion2.setMesespuntoequilibrio(financiacion.getMesespuntoequilibrio());
                financiacion2.setRecursospropiosae(financiacion.getRecursospropiosae());
                sesion.update(financiacion2);
            } else {
                throw new Exception(MensajesBD.ERROR_CARGA_FINANCIACION);
            }

            for (Paisescomercializa p : formalizado.getPaisescomercializas()) {
                sesion.save(p);
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (PersistenceException ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } catch (Exception ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * DAO encargado de registrar la información de un Seguimiento No Establecido.
     *
     * @param noEstablecido Información del NoEstablecido
     * @param observaciones Observaciones del Seguimiento
     * @param seguimiento Datos del Seguimiento
     * @param financiacion Datos financieros del Emprendimiento
     * @param finalizar Parámetro que indica si se finaliza o no el
     * Emprendimiento.
     * @return Identificador del Seguimiento
     * @throws PersistenceException Exception de Persistencia que se pueda
     * lanzar.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public long guardarSeguimientoNoEstablecido(Noestablecido noEstablecido,
            Observacionesseguimiento observaciones,
            Seguimiento seguimiento, Financiacion financiacion, boolean finalizar) throws PersistenceException, Exception {
        long id;
        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();

            if (finalizar) {
                Query q = sesion.createQuery("UPDATE Emprendimiento"
                        + " SET idestadoemprendimiento = 7"
                        + " WHERE idemprendimiento = :id");
                q.setParameter("id", noEstablecido.getEmprendimiento().getIdemprendimiento());
                q.executeUpdate();
            }

            //Debo crearlo
            if (noEstablecido.getIdnoestablecido() == new BigDecimal(-1)) {
                sesion.save(noEstablecido);
            } //Lo modifico
            else {
                sesion.update(noEstablecido);
            }

            id = (long) sesion.save(seguimiento);
            sesion.save(observaciones);

            Query elQuery = sesion.createQuery("from Financiacion where idemprendimiento=:idEmprendimiento", Financiacion.class);
            elQuery.setParameter("idEmprendimiento", noEstablecido.getEmprendimiento().getIdemprendimiento());
            //obtengo resultados del query
            List<Financiacion> aux = elQuery.getResultList();

            if (aux.size() != 0) {
                Financiacion financiacion2 = aux.get(0);
                financiacion2.setCapitaltotal(financiacion.getCapitaltotal());
                financiacion2.setCapitaltrabajo(financiacion.getCapitaltrabajo());
                financiacion2.setEmpleosgenerados(financiacion.getEmpleosgenerados());
                financiacion2.setEmpleosporgenerar(financiacion.getEmpleosporgenerar());
                financiacion2.setMesespuntoequilibrio(financiacion.getMesespuntoequilibrio());
                financiacion2.setRecursospropiosae(financiacion.getRecursospropiosae());
                sesion.update(financiacion2);
            } else {
//                sesion.save(financiacion);
                throw new Exception(MensajesBD.ERROR_CARGA_FINANCIACION);
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (PersistenceException ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } catch (Exception ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.DocentesDAO;
import com.growdata.emprendimiento.persistence.entidad.Docentes;
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
 * @author Juan Franco
 */
@Repository
public class DocentesDAOImpl implements DocentesDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Mètodo responsable de ubicar todos los docentes dado un identificador de
     * Capacitaciòn Programa.
     *
     * @param idcapacitacionprograma Identificador de CapacitaciónPrograma.
     * @return Lista de Docentes
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Docentes> getDocentes(long idcapacitacionprograma) throws Exception {
        List<Docentes> docentes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes d"
                            + " INNER JOIN Programacion p ON p.docentes.iddocente = d.iddocente"
                            + " where p.estadosesion.idestadosesion = 1"
                            + " AND p.sedes.idsede = :idSede"
                            + " order by c.nombrecapacitacionprograma", Docentes.class);
            elQuery.setParameter("idcapacitacionprograma", idcapacitacionprograma);
            //obtener  resultado
            docentes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docentes;
    }

    /**
     * Método encargado de traer toda la lista de docentes.
     *
     * @return Lista de Docentes
     * @throws Exception Cualquier Exception que pueda ser lanza.
     */
    @Override
    public List<Docentes> getDocentes() throws Exception {
        List<Docentes> docentes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes d"
                            + " where d.estadodocente.idestadodocente = 1"
                            + " order by d.primernombre, d.segundonombre, d.primerapellido, d.segundoapellido", Docentes.class);
            //obtener  resultado
            docentes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docentes;
    }
    /**
     * Método que crea un docente en la BD
     * @param docente El docente a crear
     * @return El id del docente creado
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long crearDocente(Docentes docente) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            id = (long) sesion.save(docente);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }
    /**
     * Método que actualiza un docente en la BD
     * @param docente El docente a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void modificarDocente(Docentes docente) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();

        try {
            sesion.beginTransaction();
            sesion.update(docente);
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
     * Método que trae un docente de la BD a partir de su id
     * @param id El id del docente a traer
     * @return Un docente
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Docentes traerDocente(long id) throws Exception {
        Docentes docente = new Docentes();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes where iddocente=:id", Docentes.class);
            elQuery.setParameter("id", id);
            //obtener  resultado
            docente = (Docentes) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docente;
    }
    /**
     * Método que trae un docente de la Bd a partir de su email, excluyendo el docente con el id suministrado
     * @param email El email del docente a traer
     * @param id El id del docente a excluir
     * @return Un docente
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Docentes traerDocentePorEmail(String email, long id) throws Exception {
        Docentes docente = new Docentes();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes where email=:email and iddocente!=:id", Docentes.class);
            elQuery.setParameter("id", id);
            elQuery.setParameter("email", email);
            //obtener  resultado
            docente = (Docentes) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docente;
    }
    /**
     * Método que trae un docente de la BD a partir de un número de documento y un tipo de documento,
     * excluyendo el docente con el id suministrado
     * @param numerodocumento El número de documento del docente a traer
     * @param idtipodocumento El id de tipo de documento del docente a traer
     * @param id El id del docente a excluir
     * @return Un docente
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Docentes traerDocentePorDocumento(String numerodocumento, BigDecimal idtipodocumento, long id) throws Exception {
        Docentes docente = new Docentes();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes where numerodocumento=:numerodocumento and idtipodocumento=:idtipodocumento and iddocente!=:id", Docentes.class);
            elQuery.setParameter("id", id);
            elQuery.setParameter("numerodocumento", numerodocumento);
            elQuery.setParameter("idtipodocumento", idtipodocumento);
            //obtener  resultado
            docente = (Docentes) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docente;
    }
    
     /**
     * Método encargado de traer toda la lista de docentes.
     *
     * @return Lista de Docentes
     * @throws Exception Cualquier Exception que pueda ser lanza.
     */
    @Override
    public List<Docentes> getDocentesParametrizar() throws Exception {
        List<Docentes> docentes = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Docentes ", Docentes.class);
            //obtener  resultado
            docentes = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return docentes;
    }

}

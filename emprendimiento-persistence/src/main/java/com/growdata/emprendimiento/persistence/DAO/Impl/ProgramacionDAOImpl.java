/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Franco
 */
@Repository
public class ProgramacionDAOImpl implements ProgramacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Método encargado de ubicar las programaciones según un identificador de
     * Docente.
     *
     * @param iddocente Identificador de Docente.
     * @param desde Fecha de Inicio de búsqueda
     * @return Lista de Programaciones.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Programacion> getProgramaciones(long iddocente, Date desde) throws Exception {
        List<Programacion> programaciones;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            String query = "select p "
                    + " from Programacion p"
                    + " where p.fechainicioprogramacion >=:d AND p.docentes.iddocente =:i";
            Query<Programacion> elQuery;

            elQuery = sesion.createQuery(query);
            elQuery.setParameter("d", desde);
            elQuery.setParameter("i", iddocente);

            programaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return programaciones;
    }

    /**
     * DAO encargado de crear las programaciones
     *
     * @param p Programación a ser creada
     * @return Id de la sesión creada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    @Transactional
    public long saveProgramaciones(Programacion p) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_PROGRAMACIONES");

            call.registerStoredProcedureParameter("DOCENTEID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("ID_S", BigDecimal.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("DOCENTEID", p.getDocentes().getIddocente());
            call.setParameter("ID_S", new BigDecimal(-1));
            call.setParameter("INICIO", p.getFechainicioprogramacion());
            call.setParameter("FIN", p.getFechafinalrogramacion());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            BigDecimal x = (BigDecimal) sesion.save(p);
            id = new Long(x.toString());
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
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
     * DAO encargado de actualizar una programación.
     *
     * @param programacion Programación a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    public void updateProgramaciones(Programacion programacion) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_PROGRAMACIONES");

            call.registerStoredProcedureParameter("DOCENTEID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("ID_S", BigDecimal.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("DOCENTEID", programacion.getDocentes().getIddocente());
            call.setParameter("ID_S", programacion.getIdprogramacion());
            call.setParameter("INICIO", programacion.getFechainicioprogramacion());
            call.setParameter("FIN", programacion.getFechafinalrogramacion());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            Query elQuery
                    = sesion.createQuery("update Programacion set"
                            + " maxasistentes = :maxAsistentes,"
                            + " fechainicioprogramacion = :fechainicio,"
                            + " fechafinalrogramacion = :fechafinal"
                            + " where idprogramacion =:idprogramacion");
            elQuery.setParameter("idprogramacion", programacion.getIdprogramacion());
            elQuery.setParameter("maxAsistentes", programacion.getMaxasistentes());
            elQuery.setParameter("fechainicio", programacion.getFechainicioprogramacion());
            elQuery.setParameter("fechafinal", programacion.getFechafinalrogramacion());

            elQuery.executeUpdate();
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * DAO encargado de colocar las programacion de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento, en estado Cancelada.
     *
     * @param programacion Datos de la Programación.
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void deleteProgramaciones(Programacion programacion) throws HibernateException, Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Programacion set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idprogramacion =:idprogramacion");
            elQuery.setParameter("idprogramacion", programacion.getIdprogramacion());
            elQuery.setParameter("estadosesion", new BigDecimal(3));

            elQuery.executeUpdate();
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Método encargado de ubicar una programción por su identificador.
     * 
     * @param id Identificador de la programación.
     * @return Programación que cumple con las condiciones de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Programacion getProgramacion(BigDecimal id) throws Exception {
        Programacion programacion = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Programacion where idprogramacion=:id ", Programacion.class);
            elQuery.setParameter("id", id);
            programacion = (Programacion) elQuery.getSingleResult();
            
            Query elQuery2
                    = sesion.createQuery("from Capacitacionprograma where idcapacitacionprograma = :idcapacitacion", Capacitacionprograma.class);
            elQuery2.setParameter("idcapacitacion", programacion.getCapacitacionprograma().getIdcapacitacionprograma());
            programacion.setCapacitacionprograma((Capacitacionprograma) elQuery2.getSingleResult());

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return programacion;
    }

    /**
     * Método encargado de ubicar las Programaciones dada su Sede y
     * Capacitación.
     *
     * @param idsede Identificador de la Sede.
     * @param idcapacitacion Identificador de la Capacitación.
     * @param desde Indica desde que fecha se hará la búsqueda.
     * @param vencidas Indica si las sesiones que se desean buscar deben estar
     * en el pasado.
     *
     * @return Lista de Programaciones.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Programacion> getProgramacionPorSedeCapacitacion(BigDecimal idsede,
            long idcapacitacion, Date desde, Short vencidas) throws Exception {
        List<Programacion> programaciones;
        Capacitacionprograma capacitacion = null;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            String query = "select p "
                    + " from Programacion p"
                    + " where p.capacitacionprograma.idcapacitacionprograma = :idcapacitacion"
                    + " and p.idInstitucion = :idsede"
                    + " and p.fechainicioprogramacion >=:desde";
            
            if (vencidas == 0) {
                query += " and p.maxasistentes > SIZE(p.alumnoses)";
            } else {
                query += " and SIZE(p.alumnoses) > 0";
            }
            
            Query<Programacion> elQuery;
            Query<Capacitacionprograma> Q2;

            elQuery = sesion.createQuery(query);
            elQuery.setParameter("idcapacitacion", idcapacitacion);
            elQuery.setParameter("idsede", idsede);
            elQuery.setParameter("desde", desde);

            programaciones = elQuery.getResultList();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return programaciones;
    }

}

package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SesionesComiteDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionemprendimientos;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import com.growdata.emprendimiento.persistence.entidad.Tipoprioridad;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Fecha: 04/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class SesionesComiteDAOImpl implements SesionesComiteDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae las sesiones de un funcionario de la BD en base a su id,
     * una fecha incial y una final
     *
     * @param idFuncionario El id del funcionario
     * @param desde La fecha inicial
     * @param hasta La fecha final
     * @param todas Parametro que dice si se incluyen las sesiones culminadas o
     * no
     * @return Una lista de sesiones de comité
     * @throws Exception Metodo que trae las sesiones de un funcionario en base
     * a su id
     */
    @Override
    public List<Sesioncomite> getSesionesFuncionarioComite(long idFuncionario, Date desde,
            Date hasta, int todas) throws Exception {
        List<Sesioncomite> sesiones;
        Integrantescomite integrante = new Integrantescomite();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            try {
                Query q = sesion.createQuery("from Integrantescomite where idfuncionario=:idfuncionario", Integrantescomite.class);
                q.setParameter("idfuncionario", idFuncionario);
                integrante = (Integrantescomite) q.getSingleResult();

            } catch (NoResultException n) {
                throw new Exception(MensajesBD.ERROR_NO_INTEGRANTE_COMITE, n);
            } catch (Exception ex) {
                if (ex.getMessage().equals(MensajesBD.ERROR_NO_INTEGRANTE_COMITE)) {
                    throw new Exception(MensajesBD.ERROR_NO_INTEGRANTE_COMITE, ex);
                }
                throw new Exception(MensajesBD.ERROR_INTEGRANTE_COMITE, ex);
            }

            String query = "select s "
                    + "from Sesioncomite s "
                    + "where 1 = 1";
            Query<Sesioncomite> elQuery;

            if (todas == 1) {
                query += " AND s.estadosesion.idestadosesion = 4";
            }

            if (desde != null) {
                query += " AND s.fechainicio >= :ini";
            }

            if (hasta != null) {
                query += " AND s.fechainicio < :fin";
            }
            query += " AND s.comiteevaluacion.idcomite =:idcomite";

            elQuery = sesion.createQuery(query);

            if (desde != null) {
                elQuery.setParameter("ini", desde);
            }

            if (hasta != null) {
                elQuery.setParameter("fin", hasta);
            }
            elQuery.setParameter("idcomite", integrante.getComiteevaluacion().getIdcomite());

            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_NO_INTEGRANTE_COMITE)) {
                throw new Exception(MensajesBD.ERROR_NO_INTEGRANTE_COMITE, ex);
            }
            if (ex.getMessage().equals(MensajesBD.ERROR_INTEGRANTE_COMITE)) {
                throw new Exception(MensajesBD.ERROR_INTEGRANTE_COMITE, ex);
            }
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return sesiones;
    }

    /**
     * DAO encargado de ubicar Sesiones Comité por Funcionario.
     *
     * @param idFuncionario Id del Funcionario
     * @param desde Fecha de Inicio de búsqueda
     * @param hasta Fecha Fin de búsqueda
     * @param todas Parámetro que indica si se desean todas las sesiones o solo
     * las Disponibes
     * @return Lista de Sesiones Comité que cumpla con los criterios de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    public List<Sesioncomite> getSesionesFuncionario(long idFuncionario, Date desde,
            Date hasta, int todas) throws Exception {
        List<Sesioncomite> sesiones;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            try {
                Query q = sesion.createQuery("from Integrantescomite where idfuncionario=:idfuncionario", Integrantescomite.class);
                q.setParameter("idfuncionario", idFuncionario);
                Integrantescomite integrante = (Integrantescomite) q.getSingleResult();

            } catch (NoResultException n) {
                throw new Exception(MensajesBD.ERROR_NO_INTEGRANTE_COMITE, n);
            } catch (Exception ex) {
                throw new Exception(MensajesBD.ERROR_INTEGRANTE_COMITE, ex);
            }

            String query = "select s "
                    + "from Sesioncomite s "
                    + "where 1 = 1";
            Query<Sesioncomite> elQuery;

            if (idFuncionario != -1) {
                query += " AND s.funcionario.idfuncionario =:i";
            }

            if (todas == 1) {
                query += " AND s.estadosesion.idestadosesion = 4";
            }

            if (desde != null) {
                query += " AND s.fechainicio >= :ini";
            }

            if (hasta != null) {
                query += " AND s.fechainicio < :fin";
            }

            elQuery = sesion.createQuery(query);

            if (idFuncionario != -1) {
                elQuery.setParameter("i", idFuncionario);
            }

            if (desde != null) {
                elQuery.setParameter("ini", desde);
            }

            if (hasta != null) {
                elQuery.setParameter("fin", hasta);
            }

            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }

        return sesiones;
    }

    /**
     * DAO encargado de guardar una nueva Sesión Comité.
     *
     * @param s Sesión Comité a guardar
     * @param emprendimientos Lista de Emprendimientos a revisar durante la
     * Sesión Comité
     * @return Id de la Sesión Comité
     * @throws Exception Cualquier Exception que se pueda lanzar
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    @Transactional
    public long saveSesiones(Sesioncomite s, List<Emprendimiento> emprendimientos)
            throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_COMITE");

            call.registerStoredProcedureParameter("FUNCIONARIOID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("IDSESION", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("FUNCIONARIOID", s.getFuncionario().getIdfuncionario());
            call.setParameter("INICIO", s.getFechainicio());
            call.setParameter("IDSESION", s.getIdsesioncomite());
            call.setParameter("FIN", s.getFechafinal());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }

            Tipoprioridad tipo = new Tipoprioridad(BigDecimal.ZERO);
            Date fecharegistro = new Date();
            id = (long) sesion.save(s);

            for (Emprendimiento e : emprendimientos) {
                Evaluacionemprendimientos evaluacion = new Evaluacionemprendimientos();
                evaluacion.setEmprendimiento(e);
                evaluacion.setFecharegistro(fecharegistro);
                evaluacion.setTipoprioridad(tipo);
                evaluacion.setSesioncomite(s);
                sesion.save(evaluacion);
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * DAO encargado de cancelar una Sesión Comité.
     *
     * @param s Sesión Comité a cancelar
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier otra posible Exception
     */
    @Override
    public void deleteSesiones(Sesioncomite s) throws HibernateException, Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesioncomite set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idsesioncomite =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesioncomite());
            elQuery.setParameter("estadosesion", new BigDecimal(3));

            elQuery.executeUpdate();

            elQuery
                    = sesion.createQuery("DELETE FROM Evaluacionemprendimientos"
                            + " WHERE sesioncomite.idsesioncomite =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesioncomite());

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
     * DAO encargado de actualizar una Sesiòn Comité.
     *
     * @param s Sesion con los datos a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    public void updateSesiones(Sesioncomite s) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_COMITE");

            call.registerStoredProcedureParameter("FUNCIONARIOID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("IDSESION", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("FUNCIONARIOID", s.getFuncionario().getIdfuncionario());
            call.setParameter("IDSESION", new Long(-1));
            call.setParameter("INICIO", s.getFechainicio());
            call.setParameter("FIN", s.getFechafinal());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            Query elQuery
                    = sesion.createQuery("update Sesioncomite set"
                            + " estadosesion = :estadosesion,"
                            + " fechainicio = :fechainicio,"
                            + " fechafinal = :fechafinal,"
                            + " where idsesion =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesioncomite());
            elQuery.setParameter("estadosesion", s.getEstadosesion());
            elQuery.setParameter("fechainicio", s.getFechainicio());
            elQuery.setParameter("fechafinal", s.getFechafinal());

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
     * DAO encargado de ubicar una Sesión Comité por su identificador.
     *
     * @param id Id de la Sesión Comité a ubicar.
     * @return Sesión Comité ubicada.
     * @throws Exception Cualquier Excepcion que pueda ser lanzada.
     */
    @Override
    public Sesioncomite getSesiones(long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Sesioncomite sesiones = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Sesioncomite where idsesioncomite=:saveIdSesion ", Sesioncomite.class);
            elQuery.setParameter("saveIdSesion", id);
            sesiones = (Sesioncomite) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sesiones;
    }

}

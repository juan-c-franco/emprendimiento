package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
 * @author Andrés Felipe González M Grow Data
 */
@Repository
public class SesionesDAOImpl implements SesionesDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Override
    @Transactional
    public List<Sesiones> getSesiones() {
        Session sesion = sessionFactory.getCurrentSession();
        List<Sesiones> sesiones = null;
        try {
            sesion.beginTransaction();
            //crear query
            int i = 5;
            Query<Sesiones> elQuery
                    = sesion.createQuery("from Sesiones where idfuncionario=:i", Sesiones.class);
            elQuery.setLong("i", i);

            //obtener  resultado
            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return sesiones;
    }

    /**
     * DAO encargado de crear las sesiones de tipo: Sensibilización, Valoración, 
     * Evaluación y Seguimiento.
     *
     * @param s Sesión a ser creada
     * @return Id de la sesión creada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    @Transactional
    public long saveSesiones(Sesiones s) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_SESIONES");

            call.registerStoredProcedureParameter("FUNCIONARIOID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("ID_S", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("FUNCIONARIOID", s.getFuncionario().getIdfuncionario());
            call.setParameter("ID_S", s.getIdsesion());
            call.setParameter("INICIO", s.getFechainicio());
            call.setParameter("FIN", s.getFechafinal());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            id = (long) sesion.save(s);
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
     * DAO encargado de traer de base de datos una Sesion por identificador.
     *
     * @param saveIdSesion Id de la Sesión a traer
     * @return Sesión que cumple con los criterios de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Sesiones getSesiones(long saveIdSesion) throws Exception {
        Sesiones sesiones = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Sesiones where idsesion=:saveIdSesion ", Sesiones.class);
            elQuery.setParameter("saveIdSesion", saveIdSesion);
            sesiones = (Sesiones) elQuery.getSingleResult();
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

    /**
     * DAO encargado de actualizar las sesiones de tipo: Sensibilización, 
     * Valoración, Evaluación y Seguimiento.
     *
     * @param s Sesión a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    public void updateSesiones(Sesiones s) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_SOLAPE_SESIONES");

            call.registerStoredProcedureParameter("FUNCIONARIOID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("INICIO", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("FIN", Timestamp.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("ID_S", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("FUNCIONARIOID", s.getFuncionario().getIdfuncionario());
            call.setParameter("ID_S", s.getIdsesion());
            call.setParameter("INICIO", s.getFechainicio());
            call.setParameter("FIN", s.getFechafinal());

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            Query elQuery
                    = sesion.createQuery("update Sesiones set"
                            + " estadosesion = :estadosesion,"
                            + " descripcion = :descripcion,"
                            + " maxAsistentes = :maxAsistentes,"
                            + " fechainicio = :fechainicio,"
                            + " fechafinal = :fechafinal,"
                            + " ubicacion = :ubicacion "
                            + " where idsesion =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesion());
            elQuery.setParameter("estadosesion", s.getEstadosesion());
            elQuery.setParameter("descripcion", s.getDescripcion());
            elQuery.setParameter("maxAsistentes", s.getMaxAsistentes());
            elQuery.setParameter("fechainicio", s.getFechainicio());
            elQuery.setParameter("fechafinal", s.getFechafinal());
            elQuery.setParameter("ubicacion", s.getUbicacion());

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
     * DAO encargado de colocar las sesiones de tipo: Sensibilización, Valoración, 
     * Evaluación y Seguimiento, en estado Cancelada.
     *
     * @param s Sesión que se desea cancelar
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void deleteSesiones(Sesiones s) throws HibernateException, Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesiones set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idsesion =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesion());
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
     * DAO encargado de traer las sesiones de un determinado funcionario.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Lista de Sesiones que cumplan con el criterio de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Sesiones> getSesionesXFuncionario(long idFuncionario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Sesiones> sesiones = new ArrayList();
        try {
            sesion.beginTransaction();

            Query<Sesiones> elQuery
                    //= sesion.createQuery("from Sesiones where funcionario.idfuncionario=:i", Sesiones.class);
                    = sesion.createQuery("from Sesiones where idfuncionario=:i", Sesiones.class);
            elQuery.setParameter("i", idFuncionario);
            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGAR_SESION_S, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return sesiones;
    }

    /**
     * DAO encargado de traer las sesiones de un determinado funcionario en 
     * estado culminada.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Lista de Sesiones que cumplen con los criterios de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Sesiones> getSesionesVXFuncionario(long idFuncionario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Sesiones> sesiones = new ArrayList();
        try {
            sesion.beginTransaction();

            Query elQuery
                    = sesion.createQuery("from Sesiones where idestadosesion = '1'"
                            + " and idtiposesion = '2' and idfuncionario =:idFuncionario");
            elQuery.setParameter("idFuncionario", idFuncionario);
            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_SESIONES, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sesiones;
    }

    /**
     * DAO encargado de traer sesiones que cumplan con los parametros.
     *
     * @param idFuncionario Identificador del Funcionario
     * @param tiposesion Tipo de la sesión
     * @param desde Fecha de Inicio de búsqueda
     * @param todos Parámetro que indica si se ubican todas las sesiones o solo
     * las Disponibles
     * @return Lista de Sesiones que cumplen con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Sesiones> getSesionesPorFuncionarioTipoSesion(long idFuncionario,
            BigDecimal tiposesion, Date desde, int todos) throws Exception {
        List<Sesiones> sesiones;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            String query = "select s "
                    + "from Sesiones s "
                    + "where s.fechainicio >=:d";
            Query<Sesiones> elQuery;

            if (idFuncionario != -1) {
                query += " AND s.funcionario.idfuncionario =:i";
            }

            if (tiposesion != null) {
                query += " AND s.tiposesion.idtiposesion =:t";
            }

            if (todos == 1) {
                query += " AND s.estadosesion.idestadosesion =:e";
            }

            elQuery = sesion.createQuery(query);
            elQuery.setParameter("d", desde);

            if (idFuncionario != -1) {
                elQuery.setParameter("i", idFuncionario);
            }

            if (tiposesion != null) {
                elQuery.setParameter("t", tiposesion);
            }

            if (todos == 1) {
                elQuery.setParameter("e", BigDecimal.ONE);
            }

            sesiones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return sesiones;
    }

    /**
     * DAO encargado de liberar las sesiones de tipo: Sensibilización, Valoración, 
     * Evaluación y Seguimiento.
     *
     * @param s Sesión a ser liberada
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void liberarSesiones(Sesiones s) throws HibernateException, Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesiones set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idsesion =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesion());
            elQuery.setParameter("estadosesion", new BigDecimal(1));

            elQuery.executeUpdate();

            Query q = sesion.createQuery("DELETE FROM Listaasistencia"
                    + " WHERE sesiones.idsesion =:idsesion");
            q.setParameter("idsesion", s.getIdsesion());

            q.executeUpdate();
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

}

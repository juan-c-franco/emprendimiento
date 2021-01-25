package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EvaluacionemprendimientosDAO;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 10/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class EvaluacionemprendimientosDAOImpl implements EvaluacionemprendimientosDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Servicio calificar los emprendimientos revisados en una Sesión Comité.
     *
     * @param sesionComite Sesión Comité
     * @param aprobados Lista de Calificaciones
     * @param observaciones Lista de Observaciones
     * @param ids Lista de identificadores de Emprendimiento
     * @return id de la Sesión calificada
     * @throws Exception Cualquier Exception lanzada
     * @throws HibernateException Exception lanzada por flush()
     */
    @Override
    public long save(Sesioncomite sesionComite, List<Character> aprobados,
            List<String> observaciones, List<Long> ids) throws Exception, HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        long id = -1;
        try {
            sesion.beginTransaction();
            id = sesionComite.getIdsesioncomite();
            for (int i = 0; i < ids.size(); i++) {
                Query elQuery
                        = sesion.createQuery("UPDATE Evaluacionemprendimientos SET"
                                + " aprobado = :aprobado,"
                                + " observaciones = :observaciones,"
                                + " fechaevaluacion = :fechaevaluacion"
                                + " WHERE emprendimiento.idemprendimiento = :idemprendimiento"
                                + " AND sesioncomite.idsesioncomite = :sesion");
                elQuery.setParameter("aprobado", aprobados.get(i));
                elQuery.setParameter("observaciones", observaciones.get(i));
                elQuery.setParameter("fechaevaluacion", new Date());
                elQuery.setParameter("idemprendimiento", ids.get(i));
                elQuery.setParameter("sesion", sesionComite.getIdsesioncomite());

                elQuery.executeUpdate();

                Query q = sesion.createQuery("UPDATE Emprendimiento SET"
                        + " estadoemprendimiento.idestadoemprendimiento = :edo"
                        + " WHERE idemprendimiento = :id");
                q.setParameter("id", ids.get(i));
                q.setParameter("edo", (aprobados.get(i) == '1' ? new BigDecimal(5) : BigDecimal.ONE));
                q.executeUpdate();
            }

            Query q2 = sesion.createQuery("UPDATE Sesioncomite SET"
                    + " urlacta = :path,"
                    + " estadosesion.idestadosesion = 2"
                    + " WHERE idsesioncomite = :id");
            q2.setParameter("id", sesionComite.getIdsesioncomite());
            q2.setParameter("path", sesionComite.getUrlacta());
            q2.executeUpdate();

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
}

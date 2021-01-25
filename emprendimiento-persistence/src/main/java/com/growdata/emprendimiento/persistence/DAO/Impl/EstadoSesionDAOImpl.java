package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.EstadoSesionDAO;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoSesionDAOImpl implements EstadoSesionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de ubicar las entidades Estadosesion a través de su nombre.
     *
     * @param nombreEstadoSesion Nombre del Estado de la Sesión
     * @return Estadosesion que cumpla con los criterios de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Estadosesion getEstadoSesion(String nombreEstadoSesion) throws Exception {
        Estadosesion estadoSesion = new Estadosesion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Estadosesion where nombreestadosesion=:nombreEstadoSesion ", Estadosesion.class);
            q.setParameter("nombreEstadoSesion", nombreEstadoSesion);
            estadoSesion = (Estadosesion) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return estadoSesion;
    }
}

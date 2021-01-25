package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Felipe Gonzalez
 */
@Repository
public class PlantillaMailDAOImpl implements PlantillaMailDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae una plantilla de email a partir de su id
     *
     * @param id El id de la plantilla
     * @return Una plantilla de email
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public PlantillaMail consultaPlantillaXId(long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        PlantillaMail plantilla = null;
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from PlantillaMail where id =:id", PlantillaMail.class);
            elQuery.setParameter("id", id);
            plantilla = (PlantillaMail) elQuery.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return plantilla;
    }

}

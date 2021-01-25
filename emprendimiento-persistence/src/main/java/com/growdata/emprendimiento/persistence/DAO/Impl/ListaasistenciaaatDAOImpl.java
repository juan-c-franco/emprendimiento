package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ListaasistenciaaatDAO;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 22/01/2019
 *
 * @author Juan Carlos Franco
 */
@Repository
public class ListaasistenciaaatDAOImpl implements ListaasistenciaaatDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los asistentes de una sesion de la BD a partir de un id
     * de sesion
     *
     * @param idSesion El id de la sesión
     * @return Una lista con los asistentes
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    @Transactional
    public List<Listaasistenciaaat> getLista(long idSesion) throws Exception {
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();

        List<Listaasistenciaaat> listaAsistencia = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query<Listaasistenciaaat> elQuery
                    = sesion.createQuery("from Listaasistenciaaat "
                            + "where sesionacompanamientoat.idsesionacompanamientoat=:idsesion", Listaasistenciaaat.class);
            elQuery.setParameter("idsesion", idSesion);
            //obtengo resultados del query
            listaAsistencia = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaAsistencia;

    }

}

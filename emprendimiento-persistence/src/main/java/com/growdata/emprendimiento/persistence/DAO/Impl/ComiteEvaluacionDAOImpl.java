package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ComiteEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 04/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class ComiteEvaluacionDAOImpl implements ComiteEvaluacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de ubicar un Comité de Evaluación dado uno de los 
     * funcionarios que pertenece al mismo.
     *
     * @param idFuncionario Identificador del Funcionario
     * @return Comité de Evaluación que cumpla con el criterio de búsqueda.
     * @throws Exception Cualquier Exception
     */
    @Override
    public Comiteevaluacion getComitePorIdFuncionario(long idFuncionario) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Comiteevaluacion comite = new Comiteevaluacion();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("select c"
                            + " from Comiteevaluacion c"
                            + " INNER JOIN Integrantescomite i ON i.comiteevaluacion.idcomite = c.idcomite"
                            + " WHERE i.funcionario.idfuncionario = :idF", Comiteevaluacion.class);
            elQuery.setParameter("idF", idFuncionario);
            //obtener  resultado
            comite = (Comiteevaluacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return comite;
    }

}

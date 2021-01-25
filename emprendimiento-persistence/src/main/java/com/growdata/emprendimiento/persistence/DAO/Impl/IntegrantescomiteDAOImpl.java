/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.IntegrantescomiteDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class IntegrantescomiteDAOImpl implements IntegrantescomiteDAO {

  private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae una lista de integrantes de comité de la BD a partir del
     * id de un funcionario
     *
     * @param idFuncionario El id del funcionario
     * @return Una lista de integrantes de comité
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Integrantescomite> getIntegrantesComitePorIdFuncionario(long idFuncionario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Integrantescomite> integrantes = new ArrayList();
        Integrantescomite integrante = new Integrantescomite();
        try {
            sesion.beginTransaction();
            Query<Integrantescomite> elQuery2 = sesion.createQuery(""
                    + "select i1 from Integrantescomite i1"
                    + " inner join Cajacompensacion ca on i1.comiteevaluacion.cajacompensacion.idcajacompensacion = ca.idcajacompensacion"
                    + " inner join Funcionario fu on fu.cajacompensacion.idcajacompensacion = ca.idcajacompensacion"
                    + " where fu.idfuncionario=:idFuncionario");
            elQuery2.setParameter("idFuncionario", idFuncionario);
            integrantes = elQuery2.getResultList();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_INTEGRANTES_COMITE, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return integrantes;
    }
}

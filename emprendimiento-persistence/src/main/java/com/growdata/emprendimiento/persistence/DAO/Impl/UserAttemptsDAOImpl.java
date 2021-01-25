/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.UserAttemptsDAO;
import com.growdata.emprendimiento.persistence.entidad.UserAttempts;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Repository
public class UserAttemptsDAOImpl implements UserAttemptsDAO{
private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    /**
     * Metodo que trae los intentos de login fallidos de la BD a partir de un username
     * @param username El username al que se le van a traer los intentos fallidos
     * @return Los intentos fallidos de un username
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public UserAttempts getUserAttempts(String username) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        UserAttempts userAttempts;
        try{
            session.beginTransaction();
            Query elQuery =
                    session.createQuery("from UserAttempts where username=:username",UserAttempts.class);
            elQuery.setParameter("username",username);
            userAttempts = (UserAttempts) elQuery.getSingleResult();
            session.getTransaction().commit();
        }catch(Exception ex){
            throw ex;
        }
        return userAttempts;
    }
}

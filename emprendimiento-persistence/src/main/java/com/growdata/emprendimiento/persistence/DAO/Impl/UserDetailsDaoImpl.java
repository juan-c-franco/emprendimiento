/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;
import com.growdata.emprendimiento.persistence.DAO.UserDetailsDao;
import com.growdata.emprendimiento.persistence.commons.CredencialesMalasException;
import com.growdata.emprendimiento.persistence.entidad.UserAttempts;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.BadCredentialsException;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Repository
public class UserDetailsDaoImpl extends JdbcDaoSupport implements UserDetailsDao {

//    private SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE username = ?";
    private static final String SQL_USERS_COUNT = "SELECT count(*) FROM USERS WHERE username = ?";
    private static final String SQL_USERS_UPDATE_UNLOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE accountNonLocked = 0";
    private static final String SQL_USER_ATTEMPTS_GET = "SELECT * FROM USER_ATTEMPTS WHERE username = ?";
    private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO USER_ATTEMPTS (USERNAME, ATTEMPTS, LASTMODIFIED) VALUES(?,?,?)";
    private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = attempts + 1, lastmodified = ? WHERE username = ?";
    private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username = ?";
    private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS2 = "UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE attempts = ?";
    private static final int MAX_ATTEMPTS = 3;

    @Autowired
    private DataSource securityDataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(securityDataSource);
    }

    /**
     * Metodo que crea o actualiza los intentos fallidos de un usuario a partir
     * de su username
     *
     * @param username El nombre de usuario
     * @return El objeto que contiene los intentos fallidos de login
     */
    @Override
    public UserAttempts updateFailAttempts(String username) {

        UserAttempts user = getUserAttempts(username);
        if (user == null) {
            if (isUserExists(username)) {
                // if no record, insert a new
                getJdbcTemplate().update(SQL_USER_ATTEMPTS_INSERT, new Object[]{username, 1, new Date()});
            }
        } else {

            if (isUserExists(username)) {
                // update attempts count, +1
                getJdbcTemplate().update(SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS, new Object[]{new Date(), username});
            }

            if (user.getAttempts() + 1 >= MAX_ATTEMPTS) {
                // locked user
                getJdbcTemplate().update(SQL_USERS_UPDATE_LOCKED, new Object[]{false, username});
                // throw exception
                throw new LockedException("La cuenta de usuario ha sido bloqueada! <br><br>Username : "
                        + username + "<br>Último Intento de login : " + user.getLastModified());
            } else {
                user = getUserAttempts(username);
                int intentos = MAX_ATTEMPTS - user.getAttempts();
                throw new CredencialesMalasException("Usuario/Contraseña Incorrectos <br> Tras 3 intentos fallidos la cuenta será bloqueada<br> "
                        + "Usuario: " + user.getUsername() + "<br>"
                        + "Intentos Restantes: " + intentos);
            }

        }
        return user;
    }
//    @Override
//    public void updateFailAttempts(String username) {
//        Session sesion = sessionFactory.getCurrentSession();
//        UserAttempts user = getUserAttempts(username);
//        try {
//            sesion.beginTransaction();
//            if (user == null) {
//                if (isUserExists(username)) {
//                    UserAttempts intentos = new UserAttempts();
//                    intentos.setAttempts(1);
//                    intentos.setUsername(username);
//                    intentos.setLastModified(new Date());
//                    sesion.save(intentos);
//                    sesion.getTransaction().commit();
//
//                }
//            } else {
//
//                if (isUserExists(username)) {
//                    // update attempts count, +1
//                    Query elQuery = sesion.createQuery("UPDATE USER_ATTEMPTS SET attempts = attempts + 1, lastmodified =:fecha WHERE username =:username");
//                    elQuery.setParameter("fecha", new Date());
//                    elQuery.setParameter("username", username);
//                    elQuery.executeUpdate();
//                    sesion.getTransaction().commit();
//
//                }
//
//                if (user.getAttempts() + 1 >= MAX_ATTEMPTS) {
//                    // locked user
//                    Query elQuery = sesion.createQuery("UPDATE USERS SET accountNonLocked =:bloquear WHERE username =:username");
//                    elQuery.setParameter("username", username);
//                    elQuery.setParameter("bloquear", false);
//                    elQuery.executeUpdate();
//                    sesion.getTransaction().commit();
//                    // throw exception
//                    throw new LockedException("User Account is locked!");
//                }
//
//            }
//        } catch (Exception ex) {
//            
//        } finally {
//            if (sesion != null && sesion.isOpen()) {
//                sesion.close();
//            }
//        }
//
//    }

    /**
     * Metodo que trae los intentos fallidos de un usuario a partir de su
     * username
     *
     * @param username El nombre de usuario
     * @return Los intentos fallidos
     */
    @Override
    public UserAttempts getUserAttempts(String username) {

        try {

            UserAttempts userAttempts = getJdbcTemplate().queryForObject(SQL_USER_ATTEMPTS_GET,
                    new Object[]{username}, new RowMapper<UserAttempts>() {
                public UserAttempts mapRow(ResultSet rs, int rowNum) throws SQLException {

                    UserAttempts user = new UserAttempts();
                    user.setIdUserAttempts(rs.getInt("id_user_attempts"));
                    user.setUsername(rs.getString("username"));
                    user.setAttempts(rs.getInt("attempts"));
                    user.setLastModified(rs.getDate("lastModified"));

                    return user;
                }

            });
            return userAttempts;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }
//    @Override
//    public UserAttempts getUserAttempts(String username) {
//        Session sesion = sessionFactory.getCurrentSession();
//        UserAttempts userAttempts = new UserAttempts();
//        try {
//            sesion.beginTransaction();
//            Query elQuery
//                    = sesion.createQuery("FROM USER_ATTEMPTS WHERE username =:username");
//            elQuery.setParameter("username", username);
//            userAttempts = (UserAttempts) elQuery.getSingleResult();
//            sesion.getTransaction().commit();
//        } catch (Exception ex) {
//            
//        } finally {
//            if (sesion != null && sesion.isOpen()) {
//                sesion.close();
//            }
//        }
//        return userAttempts;
//    }

    /**
     * Metodo que resetea los intentos fallidos de un usuario a partir de su
     * username
     *
     * @param username El nombre de usuario
     */
    @Override
    public void resetFailAttempts(String username) {

        getJdbcTemplate().update(
                SQL_USER_ATTEMPTS_RESET_ATTEMPTS, new Object[]{username});

    }
//    @Override
//    public void resetFailAttempts(String username) {
//        Session sesion = sessionFactory.getCurrentSession();
//
//        try {
//            sesion.beginTransaction();
//            Query elQuery
//                    = sesion.createQuery("UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username =:username");
//            elQuery.setParameter("username", username);
//            elQuery.executeUpdate();
//            sesion.getTransaction().commit();
//        } catch (Exception ex) {
//            
//        } finally {
//            if (sesion != null && sesion.isOpen()) {
//                sesion.close();
//            }
//        }
//    }

    /**
     * Metodo que revisa que el usuario exista a partir de su username
     *
     * @param username El nombre de usuario
     * @return Respuesta si el usuario existe o no
     */
    private boolean isUserExists(String username) {

        boolean result = false;

        int count = getJdbcTemplate().queryForObject(
                SQL_USERS_COUNT, new Object[]{username}, Integer.class);
        if (count > 0) {
            result = true;
        }

        return result;
    }
//    private boolean isUserExists(String username) {
//        Session sesion = sessionFactory.getCurrentSession();
//        boolean result = false;
//        int contador;
//        try {
//            sesion.beginTransaction();
//            Query elQuery
//                    = sesion.createQuery("SELECT count(*) FROM USERS WHERE username =:username");
//            elQuery.setParameter("username", username);
//            contador = elQuery.getMaxResults();
//            sesion.getTransaction().commit();
//            if (contador > 0) {
//                result = true;
//            }
//        } catch (Exception ex) {
//            
//        } finally {
//            if (sesion != null && sesion.isOpen()) {
//                sesion.close();
//            }
//        }
//
//        return result;
//    }

    /**
     * Metodo que desbloquea a los usuarios
     */
    @Override
    public void unblockUsers() {

        getJdbcTemplate().update(SQL_USERS_UPDATE_UNLOCKED, new Object[]{true});
        getJdbcTemplate().update(SQL_USER_ATTEMPTS_RESET_ATTEMPTS2, new Object[]{3});

    }

}

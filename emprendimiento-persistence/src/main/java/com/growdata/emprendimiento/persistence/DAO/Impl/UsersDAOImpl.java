/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.UsersDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import com.growdata.emprendimiento.persistence.entidad.Users;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Emprendedor;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    private SessionFactory sessionFactory2 = HibernateJdbcSimpc.getSession();

    /**
     * Metodo que trae un usuario de la BD a partir de su id
     *
     * @param idUser El id del usuario
     * @return Un usuario
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Users getUser(BigDecimal idUser) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Users user = new Users();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Users where iduser =:idUser", Users.class);
            elQuery.setParameter("idUser", idUser);
            //obtener  resultado
            user = (Users) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return user;
    }

    /**
     * Metodo que guarda las respuestas de la encuesta, crea un usuario y envia
     * notificacion a el beneficiario
     *
     * @param user El usuario a crear
     * @param respuestas Las respuestas de la encuesta
     * @param fecha La fecha de registro
     * @param idEncuesta El id de la encuesta
     * @param gm El tipo de usuario a crear
     * @return El correo del usuario junto con su valor de asistencia
     * @throws Exception Cualquier exception que se pueda lanzar
     */
    @Override
    public CorreosAsistencias crearUser(Users user,
            List<Respuestasencuesta> respuestas, Date fecha, long idEncuesta,
            GroupMembers gm) throws Exception {
        // obetener sesion de hibernate
        Users user2 = new Users();
        Session sesion = sessionFactory.getCurrentSession();
        Session sesion2 = sessionFactory2.getCurrentSession();
        BigDecimal id = null;
        CorreosAsistencias correo = new CorreosAsistencias();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery = sesion.createQuery("from Users where Username =:Username", Users.class);
            elQuery.setParameter("Username", user.getUsername());
            user2 = (Users) elQuery.getSingleResult();
            //obtener  resultado
            respuestas.forEach((r) -> {
                sesion.save(r);
            });
            Query elQuery2
                    = sesion.createQuery("update Encuesta set diligenciada = '1',"
                            + " fechadiligenciamiento=:fecha"
                            + " where idEncuesta =:idEncuesta");
            elQuery2.setParameter("idEncuesta", idEncuesta);
            elQuery2.setParameter("fecha", fecha);
            elQuery2.executeUpdate();

            sesion.getTransaction().commit();
            correo.setValor("0");
            correo.setCorreo(user.getUsername());
        } catch (NoResultException n) {
            try {
                //si no existe el usuario lo creo 
                sesion.save(user);
                sesion.save(gm);
                //Agregando al beneficiario como emprendedor en simpc
                sesion2.beginTransaction();
                Query elQuery4 = sesion.createQuery("from Beneficiario where email=:Username", Beneficiario.class);
                elQuery4.setParameter("Username", user.getUsername());
                Beneficiario beneficiario = (Beneficiario) elQuery4.getSingleResult();
                Query elQuery5 = sesion2.createQuery("from MdFDatosBasicos where Numero_documento=:documento and "
                        + "Tipo_documento=:tipoDocumento", MdFDatosBasicos.class);
                elQuery5.setParameter("documento", beneficiario.getNumerodocumento());
                elQuery5.setParameter("tipoDocumento", beneficiario.getTipodocumentoid().getNombredocumento());
                MdFDatosBasicos basicos = (MdFDatosBasicos) elQuery5.getSingleResult();
                Emprendedor emprendedor = new Emprendedor(basicos, '1', new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                sesion2.save(emprendedor);
                sesion2.getTransaction().commit();
                respuestas.forEach((r) -> {
                    sesion.save(r);
                });
                Query elQuery3
                        = sesion.createQuery("update Encuesta set diligenciada = '1',"
                                + " fechadiligenciamiento=:fecha"
                                + " where idEncuesta =:idEncuesta");
                elQuery3.setParameter("idEncuesta", idEncuesta);
                elQuery3.setParameter("fecha", fecha);
                elQuery3.executeUpdate();
                sesion.flush();
                correo.setValor("1");
                correo.setCorreo(user.getUsername());
                sesion.getTransaction().commit();
            } catch (Exception ex) {
                if (ex.getMessage().equals(MensajesBD.ERROR_USUARIO_EXISTENTE)) {
                    throw new Exception(MensajesBD.ERROR_USUARIO_EXISTENTE, ex);
                } else {
                    sesion.getTransaction().rollback();
                    sesion2.getTransaction().rollback();
                    throw new Exception(MensajesBD.ERROR_CREAR_USUARIO, ex);
                }
            }

        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_USUARIO_EXISTENTE)) {
                throw new Exception(MensajesBD.ERROR_USUARIO_EXISTENTE, ex);
            } else {
                sesion.getTransaction().rollback();
                throw new Exception(MensajesBD.ERROR_CREAR_USUARIO, ex);
            }
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return correo;
    }

    /**
     * Metodo que trae un usuario a partir de su username
     *
     * @param correo El username
     * @return Un usuario
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Users getUserPorCorreo(String correo) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();

        Users user = new Users();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Users where username =:correo", Users.class);
            elQuery.setParameter("correo", correo);
            //obtener  resultado
            user = (Users) elQuery.getSingleResult();
            sesion.getTransaction().commit();

        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return user;
    }

    /**
     * Metodo que actualiza un password en la BD
     *
     * @param user El usuario
     * @param pass El nuevo password
     * @return Respuesta que dice si se actualizo el password exitosamente o no
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public String modificarPassword(Users user, String pass) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        Users user2 = new Users();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Users where username =:username");
            elQuery.setParameter("username", user.getUsername());
            user2 = (Users) elQuery.getSingleResult();
            user2.setPassword(user.getPassword());

            user2.setCredentialsnonexpired(0);

            sesion.update(user2);

            //crear query            
            //obtener  resultado
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            
            throw new Exception(MensajesBD.ERROR_RESTAURAR_CONTRASENA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae un usuario a partir de su username, y su estado
     *
     * @param userName El nombre de usuario
     * @param enabled El estado del usuario
     * @return Un usuario
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Users getUser(String userName, BigDecimal enabled) throws Exception {
        Users user = new Users();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Users where username=:userName and enabled=:enabled ", Users.class);
            q.setParameter("userName", userName);
            q.setParameter("enabled", enabled);
            user = (Users) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return user;
    }

    /**
     * Metodo que actualiza un funcionario
     *
     * @param user El usuario a actualizar
     * @param funcionario El funcionario a actualizar
     * @param gm El tipo de funcionario
     * @return Respuesta si se actualizó el funcionario exitosamente o no
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public String modificarUser(Users user, Funcionario funcionario, GroupMembers gm) throws Exception {

        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {
            sesion.beginTransaction();
            sesion.update(user);
            sesion.update(funcionario);

            Query elQuery = sesion.createQuery("update GroupMembers set groups.id=:groupId where users.username=:userName");
            elQuery.setParameter("groupId", gm.getGroups().getId());
            elQuery.setParameter("userName", gm.getUsers().getUsername());
            elQuery.executeUpdate();

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_USUARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que actualiza una contraseña
     *
     * @param user El usuario con la contraseña a actualizar
     * @return Respuesta si se actualizó la contraseña exitosamente o no
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public String modificarContrasena(Users user) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {
            sesion.beginTransaction();
            sesion.update(user);

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_CONTRASENA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que actualiza una contraseña
     *
     * @param user El usuario con la contraseña a actualizar
     * @return Respuesta si se actualizó la contraseña exitosamente o no
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public String modificarContrasenaObligado(Users user) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        user.setCredentialsnonexpired(1);
        try {
            sesion.beginTransaction();
            sesion.update(user);

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_CONTRASENA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae un usuario a partir de su username
     *
     * @param username El nombre de usuario
     * @return Un usuario
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public Users getUserByUserName(String username) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Users user = new Users();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Users where username =:username", Users.class);
            elQuery.setParameter("username", username);
            //obtener  resultado
            user = (Users) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return user;

    }

    /**
     * Metodo que crea un funcionario
     *
     * @param user El usuario del funcionario a crear
     * @param gm El tipo de funcionario
     * @param funcionario El funcionario a crear
     * @return El correo del funcionario creado
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public CorreosAsistencias crearFuncionario(Users user, GroupMembers gm,
            Funcionario funcionario) throws Exception {
        // obetener sesion de hibernate

        Session sesion = sessionFactory.getCurrentSession();
        long id = -1;
        CorreosAsistencias correo = new CorreosAsistencias();
        try {

            sesion.beginTransaction();
            //si no existe el usuario lo creo 
            sesion.save(user);
            sesion.save(gm);
            id = (long) sesion.save(funcionario);

            sesion.flush();
            correo.setValor("1");
            correo.setCorreo(user.getUsername());
            correo.setIdBeneficiario(id);
            sesion.getTransaction().commit();
//            throw new Exception(MensajesBD.ERROR_USUARIO_EXISTENTE);
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_CREAR_USUARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return correo;
    }
}

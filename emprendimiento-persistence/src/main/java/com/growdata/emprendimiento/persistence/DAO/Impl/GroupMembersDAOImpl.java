/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.GroupMembersDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class GroupMembersDAOImpl implements GroupMembersDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que agrega a un nuevo usuario a los tipos de
     * usuario(Beneficiario,valorador,sensibilizador,etc)
     *
     * @param gm Contiene el id del usuario y el id del tipo de usuario
     * @return Respuesta que dice si se registro correctamente el nuevo miembro
     * de grupo o no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public String agregarGroupMember(GroupMembers gm) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {

            sesion.beginTransaction();
            //crear query
            sesion.save(gm);

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_AGREGAR_GROUP_MEMBER, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * DAO responsable de ubicar el GropMembers correspondiente a un determinado 
     * funcionario por tu nombre de usuario.
     *
     * @param username Nombre de usuario
     * @return GroupMembers que cumpla con los criterios
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public GroupMembers getGroupMember(String username) throws Exception {
        GroupMembers gm = new GroupMembers();
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();

        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from GroupMembers where username=:username", GroupMembers.class);
            elQuery.setParameter("username", username);

            gm = (GroupMembers) elQuery.getSingleResult();

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_GROUP_MEMBER, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return gm;
    }

    /**
     * Metodo que actualiza el tipo de usuario
     *
     * @param gm Contiene el tipo de usuario a actualizar
     * @return Respuesta que dice si se actualizo el tipo de usuario
     * exitosamente o no
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public String modificarGroupMembers(GroupMembers gm) throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {

            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("update GroupMembers set groups.id=:groupId where users.username=:userName");
            elQuery.setParameter("groupId", gm.getGroups().getId());
            elQuery.setParameter("userName", gm.getUsers().getUsername());
            elQuery.executeUpdate();

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_GROUP_MEMBER, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.CategoriaDAO;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    /**
     * M�todo que trae todas las categor�as de la BD
     * @return Una lista de categorias
     */
    @Override
    public List<Categoria> getCategorias() {
        List<Categoria> categoria = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Categoria", Categoria.class);

            categoria = elQuery.getResultList();

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return categoria;
    }
    /**
     * M�todo que crea una categor�a en la BD
     * @param categoria La categor�a a crear
     * @return El id de la categor�a creada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long crearCategoria(Categoria categoria) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();

            id = (long) sesion.save(categoria);

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;

    }
    /**
     * M�todo que actualiza una categor�a en la BD
     * @param categoria La categor�a a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void modificarCategoria(Categoria categoria) throws Exception {

        Session sesion = sessionFactory.getCurrentSession();

        try {
            sesion.beginTransaction();

            sesion.update(categoria);

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

    }
    /**
     * M�todo que trae una categor�a de la BD a partir de su id
     * @param id El id de la categor�a a traer
     * @return Una categor�a
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Categoria traerCategoria(long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Categoria categoria = new Categoria();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Categoria where idcategoria=:id", Categoria.class);
            elQuery.setParameter("id", id);

            categoria = (Categoria) elQuery.getSingleResult();

            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return categoria;
    }
    /**
     * M�todo que trae una categor�a a partir de su nombre, excluyendo la categor�a con el id suministrado
     * @param nombre El nombre de la categor�a a traer
     * @param id El id de la categor�a a excluir
     * @return Una categor�a
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Categoria traerCategoriaporNombre(String nombre, long id) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Categoria categoria = new Categoria();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Categoria where idcategoria!=:id and nombrecategoria =:nombre", Categoria.class);
            elQuery.setParameter("id", id);
            elQuery.setParameter("nombre", nombre);
            categoria = (Categoria) elQuery.getSingleResult();

            sesion.getTransaction().commit();

        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return categoria;
    }

}

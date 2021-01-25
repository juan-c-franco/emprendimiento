/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.ModuloCicloDAO;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Repository
public class ModuloCicloDAOImpl implements ModuloCicloDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Método que trae todos los módulos de la BD
     *
     * @return Una lista de módulos
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Modulociclo> getModulos() throws Exception {
        List<Modulociclo> modulos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Modulociclo", Modulociclo.class);
            //obtener  resultado
            modulos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return modulos;
    }

    /**
     * Método que crea un módulo en la BD
     *
     * @param modulo El módulo a crear
     * @return El id del módulo creado
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long crearModulo(Modulociclo modulo) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        long id;
        try {
            sesion.beginTransaction();
            id = (long) sesion.save(modulo);
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
     * Método que actualiza un módulo en la BD
     *
     * @param modulo El módulo a actualizar
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void modificarModulo(Modulociclo modulo) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();

        try {
            sesion.beginTransaction();
            sesion.update(modulo);
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
     * Método que trae un módulo de la BD a partir de su id
     *
     * @param id El id del módulo a traer
     * @return Un módulo
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Modulociclo traerModulo(long id) throws Exception {
        Modulociclo modulo = new Modulociclo();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Modulociclo where idmodulociclo=:id", Modulociclo.class);
            elQuery.setParameter("id", id);
            //obtener  resultado
            modulo = (Modulociclo) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return modulo;
    }

    /**
     * Método que trae un módulo de la Bd a partir de su nombre y de un id de
     * capacitación, excluyendo el módulo que tenga el id suministrado
     *
     * @param nombre El nombre del módulo a traer
     * @param id El id para excluir un módulo
     * @param idcapacitacionprograma El id de la capacitación
     * @return Un módulo
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Modulociclo traerModuloporNombre(String nombre, long id, long idcapacitacionprograma) throws Exception {
        Modulociclo modulo = new Modulociclo();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Modulociclo where nombremodulociclo=:nombre and idmodulociclo<>:id and capacitacionprograma.idcapacitacionprograma=:idcapacitacionprograma", Modulociclo.class);
            elQuery.setParameter("nombre", nombre);
            elQuery.setParameter("id", id);
            elQuery.setParameter("idcapacitacionprograma", idcapacitacionprograma);
            //obtener  resultado
            modulo = (Modulociclo) elQuery.getSingleResult();
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
        return modulo;
    }

    /**
     * Método encargado de indicar si existe o no un Modulociclo registrado en
     * determinada Programación.
     *
     * @param id Identificador del Modulociclo.
     * @param idProgramacion Identificador de la Programación.
     * @return Verdadero en caso de que el modulo este asociado a la
     * Programación, false en cualquier otro caso.
     */
    @Override
    public Boolean moduloCheck(long id, BigDecimal idProgramacion) {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Modulociclo m"
                            + " inner join Programacion p on p.capacitacionprograma.idcapacitacionprograma = m.capacitacionprograma.idcapacitacionprograma"
                            + " where idmodulociclo = :id"
                            + " and p.idprogramacion = :idProgramacion");
            elQuery.setParameter("id", id);
            elQuery.setParameter("idProgramacion", idProgramacion);
            //obtener  resultado
            elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return true;
    }

}

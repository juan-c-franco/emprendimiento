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
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */
@Repository
public class ModuloCicloDAOImpl implements ModuloCicloDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * M�todo que trae todos los m�dulos de la BD
     *
     * @return Una lista de m�dulos
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
     * M�todo que crea un m�dulo en la BD
     *
     * @param modulo El m�dulo a crear
     * @return El id del m�dulo creado
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
     * M�todo que actualiza un m�dulo en la BD
     *
     * @param modulo El m�dulo a actualizar
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
     * M�todo que trae un m�dulo de la BD a partir de su id
     *
     * @param id El id del m�dulo a traer
     * @return Un m�dulo
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
     * M�todo que trae un m�dulo de la Bd a partir de su nombre y de un id de
     * capacitaci�n, excluyendo el m�dulo que tenga el id suministrado
     *
     * @param nombre El nombre del m�dulo a traer
     * @param id El id para excluir un m�dulo
     * @param idcapacitacionprograma El id de la capacitaci�n
     * @return Un m�dulo
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
     * M�todo encargado de indicar si existe o no un Modulociclo registrado en
     * determinada Programaci�n.
     *
     * @param id Identificador del Modulociclo.
     * @param idProgramacion Identificador de la Programaci�n.
     * @return Verdadero en caso de que el modulo este asociado a la
     * Programaci�n, false en cualquier otro caso.
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

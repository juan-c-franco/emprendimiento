package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.MunicipiosDAO;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Municipios;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Fecha: 03/12/2018
 *
 * @author Juan Carlos Franco
 */
@Repository
public class MunicipiosDAOImpl implements MunicipiosDAO {

    private SessionFactory sessionFactory = HibernateJdbcSimpc.getSession();

    /**
     * DAO que busca los municipios de un determinado departamento.
     *
     * @param iddepartamento Identificador del Departamento
     * @return Lista de Municipios que cumplan con el criterios de búsqueda.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Municipios> getMunicipiosPorDepartamento(BigDecimal iddepartamento) throws Exception {
        List<Municipios> municipios = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Municipios"
                            + " where departamentos.id =:dep"
                            + " order by nombre", Municipios.class);
            //obtener  resultado
            elQuery.setParameter("dep", iddepartamento);
            municipios = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return municipios;
    }

    /**
     * Método encargado de traer un Municipio dado su identificador.
     *
     * @param id Identificador del Municipio
     * @return Municipio encontrado
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Municipios getMunicipioPorId(BigDecimal id) throws Exception {
        Municipios municipio = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Municipios"
                            + " where id =:id");
            //obtener  resultado
            elQuery.setParameter("id", id);
            municipio = (Municipios) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return municipio;
    }
}

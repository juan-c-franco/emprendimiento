/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javassist.tools.reflect.CannotCreateException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Franco
 */
@Repository
public class AlumnosDAOImpl implements AlumnosDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Autowired
    private ProgramacionDAO programacionDAO;

    /**
     * Método encargado de ubicar la lista de alumnos asociados a una
     * Programación.
     *
     * @param idprogramacion Identificador de la Programación
     * @return Lista de Alumnos asociados
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Alumnos> getLista(BigDecimal idprogramacion) throws Exception {
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();

        List<Alumnos> alumnos = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query<Alumnos> elQuery
                    = sesion.createQuery("from Alumnos where programacion.idprogramacion=:idprogramacion", Alumnos.class);
            elQuery.setParameter("idprogramacion", idprogramacion);
            //obtengo resultados del query
            alumnos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return alumnos;
    }

    /**
     * Método encargado de asociar un Beneficiario a una Programación.
     *
     * @param alumno Alumno a ser creado.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public long asociarBeneficiarioProgramacion(Alumnos alumno) throws Exception {
        Programacion p = programacionDAO.getProgramacion(alumno.getProgramacion().getIdprogramacion());
        Session sesion = sessionFactory.getCurrentSession();
        long id = -1;
        try {
            sesion.beginTransaction();
            if (p.getMaxasistentes() <= p.getAlumnoses().size()) {
                throw new CannotCreateException(MensajesBD.ERROR_PROGRAMACION_SIN_CUPOS);
            }

            for (Alumnos a : p.getAlumnoses()) {
                if (a.getBeneficiario().getIdbeneficiario() == alumno.getBeneficiario().getIdbeneficiario()) {
                    throw new CannotCreateException(MensajesBD.ERROR_BENEFICIARIO_YA_AGENDADO);
                }
            }
            BigDecimal aux = (BigDecimal) sesion.save(alumno);
            id = new Long(aux.toString());
            sesion.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
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
     * Método para ubicar un ALumno por su identificador.
     *
     * @param idalumno Identificador del Alumno.
     * @return Alumno que cumple con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Alumnos getAlumno(BigDecimal idalumno) throws Exception {
        Alumnos alumno = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Alumnos where idalumno= :id ", Alumnos.class);
            elQuery.setParameter("id", idalumno);
            alumno = (Alumnos) elQuery.getSingleResult();

            sesion.getTransaction().commit();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return alumno;
    }

    /**
     * Método encargado de ubicar un Alumno por su número de documento de
     * identidad.
     *
     * @param tipo Tipo de documento de identidad.
     * @param numeroDocumento Número de documento de identidad.
     * @return Lista de Alumnos que cumplen con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Alumnos> getAlumnoPorDocumento(String tipo, String numeroDocumento,
            BigDecimal idProgramacion) throws Exception {
        Session sesion = sessionFactory.openSession();

        List<Alumnos> alumnos = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query<Alumnos> elQuery
                    = sesion.createQuery("from Alumnos"
                            + " where beneficiario.tipodocumentoid.nombredocumento = :tipo"
                            + " and beneficiario.numerodocumento = :numeroDocumento"
                            + " and programacion.idprogramacion = :idProgramacion ", Alumnos.class);
            elQuery.setParameter("tipo", tipo);
            elQuery.setParameter("numeroDocumento", numeroDocumento);
            elQuery.setParameter("idProgramacion", idProgramacion);
            //obtengo resultados del query
            alumnos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return alumnos;
    }

}

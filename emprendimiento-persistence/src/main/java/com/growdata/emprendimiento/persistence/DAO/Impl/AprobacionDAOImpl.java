/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.AprobacionDAO;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Franco
 */
@Repository
public class AprobacionDAOImpl implements AprobacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Autowired
    private AlumnosDAO alumnosDAO;
    @Autowired
    private ProgramacionDAO programacionDAO;

    /**
     * Método encargado de registrar asistencias en una Programación.
     *
     * @param registroGlobal Lista de Seguimientosasistencias a ser registradas.
     * @param idProgramacion Identificador de la Programación.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void registrarCalificacionCapacitacion(List<Aprobacion> registroGlobal,
            BigDecimal idProgramacion)
            throws Exception {
        Programacion programacion = programacionDAO.getProgramacion(idProgramacion);
        programacion.setEstadosesion(new Estadosesion(new BigDecimal(2)));
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(programacion);
            for (Aprobacion a : registroGlobal) {
                Query elQuery
                        = sesion.createQuery("from Aprobacion where alumnos.idalumno=:id ", Aprobacion.class);
                elQuery.setParameter("id", a.getAlumnos().getIdalumno());
                List<Aprobacion> list = elQuery.getResultList();

                if (list.size() > 0) {
                    Aprobacion b = list.get(0);
                    b.setCalificacionfuncionario(a.getCalificacionfuncionario());
                    b.setCalificacionfinal((a.getCalificacionfuncionario() == new Short("1")
                            && b.getPorcentajeaprobacionobtenido() >= programacion.getCapacitacionprograma().getCategoria().getPorcentajeaprobacion()
                            ? new Short("1") : new Short("-2")));
                    sesion.update(b);
                } else {
                    sesion.save(a);
                }

            }
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Método encargado de ubicar una Aprobación dado un Alumno
     *
     * @param idalumno Identificador del Alumno.
     * @return Programación que cumple con las condiciones de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Aprobacion getAprobacionPorId(BigDecimal idalumno) throws Exception {
        Aprobacion aprobacion = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("from Aprobacion where alumnos.idalumno=:id ", Aprobacion.class);
            elQuery.setParameter("id", idalumno);
            aprobacion = (Aprobacion) elQuery.getSingleResult();

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
        return aprobacion;
    }

    @Override
    public List<Aprobacion> getAprobacionesPorProgramacion(BigDecimal idProgramacion) throws Exception {
        List<Aprobacion> aprobaciones = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Aprobacion where alumnos.programacion.idprogramacion = :id", Aprobacion.class);
            elQuery.setParameter("id", idProgramacion);
            //obtener  resultado
            aprobaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return aprobaciones;
    }

    /**
     * Método encargado de ubicar todas las Aprobaciones de un beneficiario dado
     * su número de documento de identidad.
     *
     * @param tipo Tipo de documento de Identidad.
     * @param numeroDocumento Número de documento de identidad.
     * @return Lista de Aprobaciones que cumplan con los criterios de consulta.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Aprobacion> getAprobacionesPorNumeroDocumento(String tipo, String numeroDocumento) throws Exception {
        List<Aprobacion> aprobaciones = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Aprobacion"
                            + " where alumnos.beneficiario.tipodocumentoid.nombredocumento = :tipo"
                            + " and alumnos.beneficiario.numerodocumento = :numeroDocumento", Aprobacion.class);
            elQuery.setParameter("tipo", tipo);
            elQuery.setParameter("numeroDocumento", numeroDocumento);
            //obtener  resultado
            aprobaciones = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return aprobaciones;
    }
}

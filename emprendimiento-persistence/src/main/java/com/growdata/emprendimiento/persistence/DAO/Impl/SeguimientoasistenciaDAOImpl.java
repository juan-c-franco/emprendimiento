/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.SeguimientoasistenciaDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import com.growdata.emprendimiento.persistence.entidad.Seguimientoasistencia;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import static java.lang.Math.abs;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Franco
 */
@Repository
public class SeguimientoasistenciaDAOImpl implements SeguimientoasistenciaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Método encargado de registrar asistencias en una Programación.
     *
     * @param registroGlobal Lista de Seguimientosasistencias a ser registradas.
     * @param idprogramacion Identificador de la Programación.
     * @param idFuncionario Identificador del Funcionario.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void registrarAsistenciaCapacitacion(List<Seguimientoasistencia> registroGlobal,
            BigDecimal idprogramacion, long idFuncionario)
            throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Set<BigDecimal> alumnos = new HashSet<BigDecimal>(0);
            for (Seguimientoasistencia s : registroGlobal) {
                alumnos.add(s.getAlumnos().getIdalumno());
                Query elQuery
                        = sesion.createQuery("from Seguimientoasistencia"
                                + " where alumnos.idalumno = :alumno"
                                + " and modulociclo.idmodulociclo = :modulo", Seguimientoasistencia.class);
                elQuery.setParameter("alumno", s.getAlumnos().getIdalumno());
                elQuery.setParameter("modulo", s.getModulociclo().getIdmodulociclo());
                List<Seguimientoasistencia> list = elQuery.getResultList();
                if (list.size() > 0) {
                    Seguimientoasistencia a = list.get(0);
                    a.setCantidadhorasasistencia(s.getCantidadhorasasistencia());
                    a.setFecharegistro(new Date());
                    sesion.update(a);
                } else {
                    sesion.save(s);
                }
            }
            sesion.flush();
            registroGlobal = null;
            for (BigDecimal a : alumnos) {
                Short porcentajeAprobacion = getPorcentajeAprobacion(a, sesion);
                Query elQuery = sesion.createQuery("from Aprobacion where alumnos.idalumno=:id ", Aprobacion.class);
                elQuery.setParameter("id", a);
                List<Aprobacion> list2 = elQuery.getResultList();

                if (list2.size() > 0) {
                    Aprobacion b = list2.get(0);
                    b.setPorcentajeaprobacionobtenido(porcentajeAprobacion);
                    if (porcentajeAprobacion < b.getAlumnos().getProgramacion().getCapacitacionprograma().getCategoria().getPorcentajeaprobacion()) {
                        b.setCalificacionfinal(new Short("-2"));
                    }
                    sesion.update(b);
                } else {
                    Aprobacion b = new Aprobacion(null, new Funcionario(idFuncionario), new Alumnos(a),
                            porcentajeAprobacion, new Short("-1"), new Short("-1"), new Date());

                    sesion.save(b);
                    sesion.flush();
                    elQuery = sesion.createQuery("from Alumnos where idalumno=:idAlumno and programacion.idprogramacion = :idprogramacion", Alumnos.class);
                    elQuery.setParameter("idAlumno", a);
                    elQuery.setParameter("idprogramacion", idprogramacion);
                    List<Alumnos> alumno = elQuery.getResultList();
                    if (porcentajeAprobacion < alumno.get(0).getProgramacion().getCapacitacionprograma().getCategoria().getPorcentajeaprobacion()) {
                        b.setCalificacionfinal(new Short("-2"));
                    }
                    sesion.update(b);
                }
            }

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

    private Short getPorcentajeAprobacion(BigDecimal idAlumno, Session sesion) {
        short intensidadHoraria = 0;
        short cantidadHorasAsistidas = 0;
        Query elQuery = sesion.createQuery("from Seguimientoasistencia"
                + " where alumnos.idalumno = :alumno", Seguimientoasistencia.class);
        elQuery.setParameter("alumno", idAlumno);
        List<Seguimientoasistencia> list = elQuery.getResultList();
        for (Seguimientoasistencia s : list) {
            if (s.getModulociclo().getNombremodulociclo() == null) {
                elQuery = sesion.createQuery("from Modulociclo"
                        + " where idmodulociclo = :id", Modulociclo.class);
                elQuery.setParameter("id", s.getModulociclo().getIdmodulociclo());
                s.setModulociclo((Modulociclo) elQuery.getSingleResult());
            }
            intensidadHoraria += s.getModulociclo().getIntensidadhoraria();
            cantidadHorasAsistidas += (s.getModulociclo().getIntensidadhoraria() >= s.getCantidadhorasasistencia() ? s.getCantidadhorasasistencia() : s.getModulociclo().getIntensidadhoraria());
        }

        Integer porcentaje = 0;
        if (intensidadHoraria != 0) {
            porcentaje = abs(cantidadHorasAsistidas * 100 / intensidadHoraria);
        }

        return new Short(porcentaje.toString());
    }

    /**
     * Método encargado de ubicar un Seguimientoasistencia dado un Alumno y
     * Modulociclo.
     *
     * @param idalumno Identificador del Alumno.
     * @param idmodulociclo Identificador del Modulociclo.
     * @return Lista de Seguimientoasistencia que cumplen con los parámetros de
     * búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Seguimientoasistencia> getSeguimientoAlumnoModulo(BigDecimal idalumno, long idmodulociclo) throws Exception {
        List<Seguimientoasistencia> seguimientos;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            String query = "select s "
                    + " from Seguimientoasistencia s"
                    + " where s.alumnos.idalumno = :alumno"
                    + " and s.modulociclo.idmodulociclo = :modulo";
            Query<Seguimientoasistencia> elQuery;

            elQuery = sesion.createQuery(query);
            elQuery.setParameter("alumno", idalumno);
            elQuery.setParameter("modulo", idmodulociclo);

            seguimientos = elQuery.getResultList();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return seguimientos;
    }

    /**
     * Método encargado de ubicar todos los Seguimientoasistencia de un
     * Beneficiario.
     *
     * @param tipo Tipo de documento de identidad.
     * @param numeroDocumento Número de documento de identidad.
     * @return Lista de Seguimientosasistencia.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Seguimientoasistencia> getSeguimientoNumeroDocumento(String tipo, String numeroDocumento) throws Exception {
        List<Seguimientoasistencia> seguimientos;
        try {
            Session sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            String query = "select s "
                    + " from Seguimientoasistencia s"
                    + " where s.alumnos.beneficiario.numerodocumento = :numeroDocumento"
                    + " and s.alumnos.beneficiario.tipodocumentoid.nombredocumento = :tipo";
            Query<Seguimientoasistencia> elQuery;

            elQuery = sesion.createQuery(query);
            elQuery.setParameter("tipo", tipo);
            elQuery.setParameter("numeroDocumento", numeroDocumento);
            seguimientos = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return seguimientos;
    }

}

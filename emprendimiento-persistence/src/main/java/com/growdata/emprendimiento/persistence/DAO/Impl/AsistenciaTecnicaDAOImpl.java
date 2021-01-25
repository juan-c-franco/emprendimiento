package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.AsistenciaTecnicaDAO;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentos;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Danny Fernando Guerrero Gelpud
 */
@Repository
public class AsistenciaTecnicaDAOImpl implements AsistenciaTecnicaDAO {

    private final SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * DAO encargado de ubicar las sesiones según su funcionario y estado.
     *
     * @param estadosSesion Estados en los que puede estar la sesión
     * @param idFuncionario Identificador del Funcionarioo
     * @return Lista de Sesiones que cumplen con el criterio de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Sesionacompanamientoat> getSesionesAATPorFuncionario(
            List<String> estadosSesion, long idFuncionario) throws Exception {
        List<Sesionacompanamientoat> sesionesAAT = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            String qStr = "from Sesionacompanamientoat where estadosesion.nombreestadosesion in (";
            for (int i = 0; i < estadosSesion.size(); i++) {
                qStr += ":estadoSesion" + i + ",";
            }
            qStr = qStr.substring(0, qStr.length() - 1);
            qStr += ") and funcionario.idfuncionario=:idFuncionario";
            Query q = sesion.createQuery(qStr, Sesionacompanamientoat.class);
            int cant = 0;
            for (String estadoSesion : estadosSesion) {
                q.setParameter("estadoSesion" + cant, estadoSesion);
                cant += 1;
            }

            q.setParameter("idFuncionario", idFuncionario);
            sesionesAAT = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            sesionesAAT = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sesionesAAT;
    }

    /**
     * DAO encargado de actualiza una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param sesionAAT Sesión de Acompañamiento y Asistencia Técnica
     * @return Id de la sesión
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public long updateSesionAAT(Sesionacompanamientoat sesionAAT) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesionacompanamientoat set"
                            + " fechainicio = :fechainicio,"
                            + " fechafinal = :fechafinal,"
                            + " ubicacion = :ubicacion "
                            + " where idsesionacompanamientoat =:idsesionacompanamientoat");
            elQuery.setParameter("idsesionacompanamientoat", sesionAAT.getIdsesionacompanamientoat());
            elQuery.setParameter("fechainicio", sesionAAT.getFechainicio());
            elQuery.setParameter("fechafinal", sesionAAT.getFechafinal());
            elQuery.setParameter("ubicacion", sesionAAT.getUbicacion());

            elQuery.executeUpdate();
            sesion.flush();
            sesion.getTransaction().commit();
            resp = sesionAAT.getIdsesionacompanamientoat();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * DAO encargado de guardar una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param sesionAAT Sesión de Acompañamiento y Asistencia Técnica a ser
     * guardada
     * @return Identificador de la sesión guardada.
     * @throws Exception Cualquier Exception que se pueda generar
     */
    @Override
    public long setSesionAAT(Sesionacompanamientoat sesionAAT) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(sesionAAT);
            sesion.getTransaction().commit();
            resp = sesionAAT.getIdsesionacompanamientoat();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * DAO encargado de verificar que cierta sesion de Acompañamiento y
     * Asistencia Técnica no tenga solape con otras sesiones.
     *
     * @param sesionAAT Sesión de Acompañamiento y Asistencia Técnica
     * @return Lista de Sesiones
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Sesionacompanamientoat> setSesionesAATPorSolapamiento(Sesionacompanamientoat sesionAAT) throws Exception {
        List<Sesionacompanamientoat> sesionesAAT = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Sesionacompanamientoat"
                    + " where (idsesionacompanamientoat!=:idSesion)"
                    + " and (:fechaInicio between fechainicio and fechafinal "
                    + " or :fechaFinal between fechainicio and fechafinal"
                    + " or fechainicio between :fechaInicio and :fechaFinal"
                    + " or fechafinal between :fechaInicio and :fechaFinal) and estadosesion.idestadosesion != 3 "
                    + " and funcionario.idfuncionario=:idFuncionario", Sesionacompanamientoat.class);
//            q.setParameter("estadoSesion", sesionAAT.getEstadosesion().getIdestadosesion());
            q.setParameter("idFuncionario", sesionAAT.getFuncionario().getIdfuncionario());
            q.setParameter("fechaInicio", sesionAAT.getFechainicio());
            q.setParameter("fechaFinal", sesionAAT.getFechafinal());
            q.setParameter("idSesion", sesionAAT.getIdsesionacompanamientoat());
            sesionesAAT = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            sesionesAAT = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sesionesAAT;
    }

    /**
     * DAO encargado de cancelar una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param idSessionAAT Identificador de la sesion a cancelar
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public void deleteSesionAAT(long idSessionAAT) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesionacompanamientoat set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idsesionacompanamientoat =:idsesion");
            elQuery.setParameter("idsesion", idSessionAAT);
            elQuery.setParameter("estadosesion", new BigDecimal(3));

            elQuery.executeUpdate();
            sesion.flush();
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
     * DAO encargado de ubicar una sesion de Acompañamiento y Asistencia Técnica
     * por su Id.
     *
     * @param sesionAATId Identificador de la sesión
     * @return Sesión que cumpla con el criterio de búsqueda.
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Sesionacompanamientoat getSesionAAT(long sesionAATId) throws HibernateException, Exception {
        Sesionacompanamientoat sesionAAT = new Sesionacompanamientoat();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesionAAT = (Sesionacompanamientoat) sesion.get(Sesionacompanamientoat.class, sesionAATId);
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return sesionAAT;
    }

    /**
     * DAO encargado de conseguir un Temas de Acompañamiento y Asistencia
     * Técnica dado su id.
     *
     * @param idTemaRutaAAT Identificador del Temam
     * @return Tema que cumpla con los criterios de búsqueda
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public Temasrutaacompanamientoat getTemaRutaAAT(long idTemaRutaAAT) throws Exception {
        Temasrutaacompanamientoat temaRutaATT = new Temasrutaacompanamientoat();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            temaRutaATT = (Temasrutaacompanamientoat) sesion.get(Temasrutaacompanamientoat.class, idTemaRutaAAT);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return temaRutaATT;
    }

    /**
     * Metodo que trae una lista de asistencias a partir de un id de sesión de
     * comité
     *
     * @param sesionAATId El id de la sesión de comité
     * @return una lista de asistencias
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public List<Listaasistenciaaat> getListaAAT(long sesionAATId) throws Exception {
        List<Listaasistenciaaat> listaasistenciaaat = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Listaasistenciaaat where sesionacompanamientoat.idsesionacompanamientoat=:idSesionAAT", Listaasistenciaaat.class);
            q.setParameter("idSesionAAT", sesionAATId);
            listaasistenciaaat = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            listaasistenciaaat = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaasistenciaaat;
    }

    /**
     * DAO encargado de conseguir las Rutas de Acompañamiento y Asistencia
     * Técnica para un determinado emprendimiento dado su idemprendimiento.
     *
     * @param idEmprendimiento Identificador del Emprendimiento
     * @return Ruta de Acompañamiento y Asistencia Técnica que cumpla con el
     * criterio de búsqueda.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Rutaacompanamientoat getRutaAAT(long idEmprendimiento) throws Exception {
        Rutaacompanamientoat rutaAAT = new Rutaacompanamientoat();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Rutaacompanamientoat where emprendimiento.idemprendimiento=:idEmprendimiento ", Rutaacompanamientoat.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            rutaAAT = (Rutaacompanamientoat) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return rutaAAT;
    }

    /**
     * DAO encargado de vincular una serie de beneficiarios asociados a un
     * emprendimiento a una determinada sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param asociados Lista de Asociados a ser vinculados en la sesión
     * @param sesionAAT Sesión a donde se desean vincular los asociados.
     * @throws NoResultException Lanzada por elQuery.getSingleResult()
     * @throws HibernateException Lanzada por sesion.update(sesionAAT) y
     * sesion.save(listaAAT)
     * @throws Exception Cualquier otra Exception que pueda ser lanzada
     */
    @Override
    public void setListaAAT(List<Asociados> asociados, Sesionacompanamientoat sesionAAT)
            throws NoResultException, HibernateException, Exception {
//        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("FROM Sesionacompanamientoat "
                            + " WHERE idsesionacompanamientoat =:id"
                            + " AND estadosesion.idestadosesion = 1",
                            Sesionacompanamientoat.class);
            elQuery.setParameter("id", sesionAAT.getIdsesionacompanamientoat());
            elQuery.getSingleResult();
            sesion.clear();
            sesion.update(sesionAAT);
            if (asociados != null && asociados.size() > 0) {
                asociados.stream().map((asociado) -> {
                    Listaasistenciaaat listaAAT = new Listaasistenciaaat();
                    listaAAT.setBeneficiario(asociado.getBeneficiario());
                    return listaAAT;
                }).map((listaAAT) -> {
                    listaAAT.setSesionacompanamientoat(sesionAAT);
                    return listaAAT;
                }).map((listaAAT) -> {
                    listaAAT.setFecharegistro(new Date());
                    return listaAAT;
                }).forEachOrdered((listaAAT) -> {
                    sesion.save(listaAAT);
                });
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (NoResultException ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } catch (HibernateException ex) {
            sesion.getTransaction().rollback();
            throw ex;
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
     * DAO encargado de cuantificar la cantidad de horas de sesión de
     * Acompañamiento y Asistencia Técnica se han ejecutado.
     *
     * @param idtemarutaacompanamientoat Identificador del Tema Ruta de
     * Acompañamiento de Asistencia Técnica
     * @param idEmprendimiento Identificador del Emprendimiento
     * @return Cantidad de horas que se aplicaron de dicho tema al
     * emprendimiento.
     * @throws HibernateException Lanzada por q.getSingleResult()
     * @throws Exception Cualquier otro Exception
     */
    @Override
    public float getCantidadHorasEjecutadasPorTema(long idtemarutaacompanamientoat, long idEmprendimiento) throws HibernateException, Exception {
        float response = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select "
                    + "nvl(sum((extract(DAY FROM s.fechafinal-s.fechainicio)*24*60*60) "
                    + "+ (extract(HOUR FROM s.fechafinal-s.fechainicio)*60*60) "
                    + "+ (extract(MINUTE FROM s.fechafinal-s.fechainicio)*60) "
                    + "+ (extract(SECOND FROM s.fechafinal-s.fechainicio))), 0) as cant "
                    + " from Sesionacompanamientoat s "
                    + " where temasrutaacompanamientoat.idtemarutaacompanamientoat = :idtemarutaacompanamientoat "
                    + " and rutaacompanamientoat.emprendimiento.idemprendimiento = :idEmprendimiento "
                    + " and estadosesion.idestadosesion in (2,4)");
            q.setParameter("idtemarutaacompanamientoat", idtemarutaacompanamientoat);
            q.setParameter("idEmprendimiento", idEmprendimiento);
//            q.setParameter("estadoSesion", "Culminada");
            response = ((Long) q.getSingleResult()).floatValue() / 3600;
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return response;
    }

    /**
     * Metodo que trae la lista de asistencia a una sesión a partir de su id
     *
     * @param sesionAATId Id de la sesión
     * @return Una lista de asistencia
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public Listaasistenciaaat getListaAATPorId(long sesionAATId) throws Exception {
        Listaasistenciaaat listaAAT = new Listaasistenciaaat();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            listaAAT = (Listaasistenciaaat) sesion.get(Listaasistenciaaat.class, sesionAATId);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaAAT;
    }

    /**
     * Metodo que registra las asistencias de una sesión determinada
     *
     * @param listasAAT Una lista con las asistencias a registrar
     * @return El id de la sesión de acompañamiento
     * @throws HibernateException Cualquier Exception que hibernate pueda lanzar
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public List<CorreosAsistencias> updateListaAAT(List<Listaasistenciaaat> listasAAT) throws HibernateException, Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            sesion.beginTransaction();
            listasAAT.forEach((l) -> {
                CorreosAsistencias correo = new CorreosAsistencias();
                correo.setCorreo(l.getBeneficiario().getEmail());
                correo.setPrimerApellido(l.getBeneficiario().getPrimerapellido());
                correo.setPrimerNombre(l.getBeneficiario().getPrimernombre());
                correo.setSegundoApellido(l.getBeneficiario().getSegundoapellido());
                correo.setSegundoNombre(l.getBeneficiario().getSegundonombre());
                correo.setIdBeneficiario(l.getBeneficiario().getIdbeneficiario());
                if (l.getRegistroasistencia().equals('1')) {
                    correo.setValor("Si");

                } else if (l.getRegistroasistencia().equals('0')) {
                    correo.setValor("No");
                }
                sesion.update(l);
                correos.add(correo);
            });
            Query elQuery = sesion.createQuery("update Sesionacompanamientoat set idestadosesion = '2' "
                    + "where IDSESIONACOMPANAMIENTOAT =:indice");
            elQuery.setParameter("indice", listasAAT.get(0).getSesionacompanamientoat().getIdsesionacompanamientoat());
            elQuery.executeUpdate();
            sesion.flush();
            sesion.getTransaction().commit();
            resp = listasAAT.get(0).getIdasistenciaacompanamientoat();
        } catch (HibernateException ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return correos;
    }

    /**
     * DAO encargados de ubicar los Temas de Acompañamiento y Asistencia Técnica
     * vinculados a un emprendimiento.
     *
     * @param idEmprendimiento Identificador del Emprendiendimiento
     * @return Lista de Temas Rutas de Acompañamiento y Asistencia Técnica.
     * @throws Exception Cualquier Exception
     */
    @Override
    public List<Temasrutaacompanamientoat> getTemasRutaAAT(long idEmprendimiento) throws Exception {
        List<Temasrutaacompanamientoat> temasRutaAAT = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Temasrutaacompanamientoat where rutaacompanamientoat.emprendimiento.idemprendimiento=:idEmprendimiento", Temasrutaacompanamientoat.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            temasRutaAAT = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            temasRutaAAT = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return temasRutaAAT;
    }

    /**
     * Metodo que actualiza un tema de acompañamiento
     *
     * @param temaRutaAAT tema de ruta de acompañamiento
     * @return El id del tema de ruta de acompañamiento
     * @throws Exception Cualquier Exception
     */
    @Override
    public long updateTemaRutaAAT(Temasrutaacompanamientoat temaRutaAAT) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(temaRutaAAT);
            sesion.flush();
            sesion.getTransaction().commit();
            resp = temaRutaAAT.getIdtemarutaacompanamientoat();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que crea un tema de acompañamiento
     *
     * @param temaRutaAAT Tema de ruta de acompañamiento
     * @return El id del tema de ruta de acompañamiento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public long setTemaRutaAAT(Temasrutaacompanamientoat temaRutaAAT) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(temaRutaAAT);
            sesion.flush();
            sesion.getTransaction().commit();
            resp = temaRutaAAT.getIdtemarutaacompanamientoat();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae un documento a partir de su id
     *
     * @param idDocumentoComite El id del documento de comité
     * @return Un documento de comité
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public Documentos getDocumento(long idDocumentoComite) throws Exception {
        Documentos documentos = new Documentos();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            documentos = (Documentos) sesion.get(Documentos.class, idDocumentoComite);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return documentos;
    }

    /**
     * Metodo que trae un tipo de documento apartir de su id
     *
     * @param idtipodocumento El id del tipo de documento
     * @return Un tipo de documento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public Tipodocumentos getTipoDocumento(BigDecimal idtipodocumento) throws Exception {
        Tipodocumentos tipodocumentos = new Tipodocumentos();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            tipodocumentos = (Tipodocumentos) sesion.get(Tipodocumentos.class, idtipodocumento);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return tipodocumentos;
    }

    /**
     * Metodo que actualiza un documento
     *
     * @param documentos Documento
     * @return El id del documento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public long updateDocumento(Documentos documentos) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(documentos);
            sesion.flush();
            sesion.getTransaction().commit();
            resp = documentos.getIddocumento();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que crea un documento
     *
     * @param documentos Documento
     * @return El id del documento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public long setDocumento(Documentos documentos) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(documentos);
            if (documentos.getEmprendimiento().getEstadoemprendimiento().getIdestadoemprendimiento().intValue() == 10) {
                Query elQuery = sesion.createQuery("update Emprendimiento set IDESTADOEMPRENDIMIENTO = 3 where IDEMPRENDIMIENTO=:IDEMPRENDIMIENTO");
                elQuery.setParameter("IDEMPRENDIMIENTO", documentos.getEmprendimiento().getIdemprendimiento());
                elQuery.executeUpdate();
            }
            sesion.flush();
            sesion.getTransaction().commit();
            resp = documentos.getIddocumento();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae los documentos de un emprendimiento a partir de un id de
     * emprendimiento y un id de tipo de documento
     *
     * @param idEmprendimiento El id del emprendimiento
     * @param idTipoDocumento El id del tipo de documento
     * @return Lista de documentos
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public List<Documentos> getDocumentos(long idEmprendimiento, BigDecimal idTipoDocumento) throws Exception {
        List<Documentos> documentos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Documentos where emprendimiento.idemprendimiento=:idEmprendimiento and tipodocumentos.idtipodocumento=:idTipoDocumento order by iddocumento desc", Documentos.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            q.setParameter("idTipoDocumento", idTipoDocumento);
            documentos = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            documentos = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return documentos;
    }

    /**
     * Metodo que elimina un documento a partir de su id
     *
     * @param idDocumento El id del documento
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public void deleteDocumento(BigDecimal idDocumento) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Documentos documento = (Documentos) sesion.get(Documentos.class, idDocumento.longValue());
            sesion.delete(documento);
            sesion.flush();
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
     * DAO encargado de liberar una sesion de Acompañamiento y Asistencia
     * Técnica.
     *
     * @param s Sesión que se va a liberar
     * @throws HibernateException Exception lanzada por flush()
     * @throws Exception Cualquier Exception que se pueda lanzar
     */
    @Override
    public void liberarSesiones(Sesionacompanamientoat s) throws HibernateException, Exception {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery
                    = sesion.createQuery("update Sesionacompanamientoat set"
                            + " estadosesion.idestadosesion = :estadosesion"
                            + " where idsesionacompanamientoat =:idsesion");
            elQuery.setParameter("idsesion", s.getIdsesionacompanamientoat());
            elQuery.setParameter("estadosesion", new BigDecimal(1));

            elQuery.executeUpdate();

            Query q = sesion.createQuery("DELETE FROM Listaasistenciaaat"
                    + " WHERE sesionacompanamientoat.idsesionacompanamientoat =:idsesion");
            q.setParameter("idsesion", s.getIdsesionacompanamientoat());

            q.executeUpdate();
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    @Override
    public long updateSesionAATAsistencia(Sesionacompanamientoat sesionAAT, List<Listaasistenciaaat> listasAAT) throws Exception {
        long resp = 0;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(sesionAAT);
            for (Listaasistenciaaat t : listasAAT) {
                sesion.update(t);
            }
            sesion.flush();
            sesion.getTransaction().commit();
            resp = sesionAAT.getIdsesionacompanamientoat();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
}

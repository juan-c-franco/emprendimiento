package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.ListaAsistenciaDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.commons.AsistenciasValor2;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.commons.EnviarEmail;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Tipoencuesta;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class ListaAsistenciaDAOImpl implements ListaAsistenciaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Autowired
    private BeneficiarioDAO beneficiarioDAO;

    @Autowired
    private SesionesDAO sesionesDAO;

    /**
     * Metodo que trae los asistentes de una sesion de la BD a partir de un id
     * de sesion
     *
     * @param idsesion El id de la sesión
     * @return Una lista de asistentes
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<Listaasistencia> getLista(long idsesion) throws Exception {
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();

        List<Listaasistencia> listaAsistencia = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query<Listaasistencia> elQuery
                    = sesion.createQuery("from Listaasistencia where idsesion=:idsesion", Listaasistencia.class);
            elQuery.setParameter("idsesion", idsesion);
            //obtengo resultados del query
            listaAsistencia = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_ASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaAsistencia;

    }

    /**
     * Metodo que registra las asistencias de una sesion en BD
     *
     * @param asistencias Una lista con el valor de las asistencias
     * @param vigencia La vigencia de la encuesta
     * @param idsesion El id de la sesión
     * @return Una lista con los correos de los asistentes, sus ids de
     * beneficiario y el id de la encuesta
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List<CorreosAsistencias> registroAsistencias(
            List<AsistenciasValor2> asistencias, int vigencia,
            long idsesion, Tipoencuesta tipoencuesta) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            for (int i = 0; i < asistencias.size(); i++) {

                long indice = asistencias.get(i).getIdasistencia();
                Character valor = asistencias.get(i).getValor();
                Query elQuery
                        = sesion.createQuery("update Listaasistencia set registroasistencia =:valor, fecharegistro= sysdate()"
                                + " where idasistencia =:indice");
                elQuery.setParameter("indice", indice);
                elQuery.setParameter("valor", valor);
                elQuery.executeUpdate();
                // traigo los datos del beneficiario al que le registre la asistencia para enviarle un email
                Query elQuery2 = sesion.createQuery("from Listaasistencia where idasistencia =:indice", Listaasistencia.class);
                elQuery2.setParameter("indice", indice);
                Listaasistencia lista = (Listaasistencia) elQuery2.getSingleResult();
                Encuesta encuesta = new Encuesta();
                encuesta.setBeneficiario(lista.getBeneficiario());
                //consigo la fecha actual
                Date date = new Date();
                encuesta.setFechaenvio(date);
                //sumo 30 dias
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, vigencia);
                Date nuevaFecha = cal.getTime();
                encuesta.setFechavigencia(nuevaFecha);

                
                encuesta.setTipoencuesta(tipoencuesta);
                encuesta.setDiligenciada('0');
                long idEncuesta = (long) sesion.save(encuesta);
                CorreosAsistencias correo = new CorreosAsistencias();
                correo.setIdEncuesta(idEncuesta);
                correo.setIdBeneficiario(lista.getBeneficiario().getIdbeneficiario());
                correo.setCorreo(lista.getBeneficiario().getEmail());
                correo.setPrimerNombre(lista.getBeneficiario().getPrimernombre());
                correo.setSegundoNombre(lista.getBeneficiario().getSegundonombre());
                correo.setPrimerApellido(lista.getBeneficiario().getPrimerapellido());
                correo.setSegundoApellido(lista.getBeneficiario().getSegundoapellido());
                if (valor.equals('1')) {
                    correo.setValor("Si");

                } else if (valor.equals('0')) {
                    correo.setValor("No");

                }
                correos.add(correo);
            }
            Query elQuery3
                    = sesion.createQuery("update Sesiones set idestadosesion = '2'"
                            + " where idsesion =:idsesion");
            elQuery3.setParameter("idsesion", idsesion);
            elQuery3.executeUpdate();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_REGISTRO_ASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return correos;
    }

    @Override
    public List<Listaasistencia> traerNulos(long j) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        List<Listaasistencia> listas = new ArrayList();
        try {
            //empezar transaccion
            sesion.beginTransaction();

            Query<Listaasistencia> elQuery3 = sesion.createQuery("from Listaasistencia where idsesion =:j "
                    + " and registroasistencia = '0'", Listaasistencia.class);
            elQuery3.setParameter("j", j);
            listas = elQuery3.getResultList();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_INASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return listas;
    }

    @Override
    public List<Listaasistencia> getListaInasistentes(int idsesion) throws Exception {
        //Obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        // Session sesion = sessionFactory.getCurrentSession();
        List<Listaasistencia> listaAsistencia = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            //creo el query
            Query<Listaasistencia> elQuery
                    = sesion.createQuery("from Listaasistencia where idsesion=:idsesion"
                            + " and registroasistencia is null", Listaasistencia.class
                    );
            elQuery.setParameter("idsesion", idsesion);
            //obtengo resultados del query
            listaAsistencia = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_INASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return listaAsistencia;

    }

    @Override
    public Listaasistencia registroAsistenciasModificadas(int asistencias) {

        Listaasistencia lista = new Listaasistencia();

        //obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        try {
            //empezar transaccion
            sesion.beginTransaction();
            //creo 
            int indice = asistencias;
            System.out.println("Esto es lo que trae las asistencias-------->" + asistencias);
            Query elQuery
                    = sesion.createQuery("update Listaasistencia set registroasistencia = '1', fecharegistro= sysdate()"
                            + " where idasistencia =:indice");
            elQuery.setLong("indice", indice);
            elQuery.executeUpdate();

            // traigo los datos del beneficiario al que le registre la asistencia para enviarle un email
            Query elQuery2 = sesion.createQuery("from Listaasistencia where idasistencia =:indice", Listaasistencia.class);
            elQuery2.setLong("indice", indice);

            lista = (Listaasistencia) elQuery2.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return lista;

    }

    /**
     * Metodo que crea una encuesta en al BD
     *
     * @param encuesta La encuesta a crear
     * @return Una encuesta
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Encuesta crearEncuesta(Encuesta encuesta) throws Exception {
        Encuesta encuestas = new Encuesta();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        try {

            //empezar transaccion
            sesion.beginTransaction();
            sesion.save(encuesta);
            long id = encuesta.getIdencuesta();
            long a = encuesta.getBeneficiario().getIdbeneficiario();
            Query elQuery = sesion.createQuery("from Encuesta where idbeneficiario =:a and idencuesta=:id ");
            elQuery.setParameter("a", a);
            elQuery.setParameter("id", id);
            encuestas = (Encuesta) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CREAR_ENCUESTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return encuestas;
    }

    /**
     * DAO responsable de asociar un beneficiario a una sesión de
     * Sensibilización.
     *
     * @param lista Información de los beneficiarios y la sesión a donde se
     * vincularán.
     * @param meses_antes Parámetro que indica la cantidad de meses que deben
     * pasar entre un emprendimiento anterior y uno nuevo.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public void asociarBeneficiario(Listaasistencia lista, int meses_antes) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();

        try {
            sesion.beginTransaction();
            // define the stored procedure
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_ASOCIACION_BENEFICARIO");

            call.registerStoredProcedureParameter("EMAIL_BENEFICIARIO", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("SESIONID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("TIPOSESION", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MESES_ANTES", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            // set input parameter
            call.setParameter("EMAIL_BENEFICIARIO", lista.getBeneficiario().getEmail());
            call.setParameter("SESIONID", lista.getSesiones().getIdsesion());
            call.setParameter("TIPOSESION", 1);
            call.setParameter("MESES_ANTES", meses_antes);

            // call the stored procedure and get the result
            call.execute();
            String mensaje = (String) call.getOutputParameterValue("MENSAJE");

            if (!"OK".equals(mensaje)) {
                throw new Exception(mensaje);
            }
            sesion.save(lista);
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
     * DAO responsable de asociar un beneficiario a una sesión de Valoración.
     *
     * @param idSesion Id de la Sesión a vincular los beneficiarios.
     * @param beneficiarios Lista de Beneficiarios a ser vinculados a la sesión
     * @param meses_antes Parámetro que indica la cantidad de meses que deben
     * pasar entre un emprendimiento anterior y uno nuevo.
     * @return Lista de Beneficiarios
     * @throws Exception Cualquier Exception
     * @throws PersistenceException Lanzada por sesion.flush()
     */
    @Override
    public List<Beneficiario> asociarBeneficiarioValoracion(long idSesion, ArrayList<String> beneficiarios,
            int meses_antes) throws Exception, PersistenceException {

        //Traigo la informacion de la base de datos
        Sesiones s;
        List<Beneficiario> lBeneficarios;
        try {
            s = sesionesDAO.getSesiones(idSesion);
            lBeneficarios = new LinkedList<>();
            for (String bId : beneficiarios) {
                Beneficiario b = beneficiarioDAO.getBeneficiarios(Long.parseLong(bId), null, null, null, null, null).get(0);
                if (!new EnviarEmail().validarEmail(b.getEmail())) {
//                if (!enviar.validarEmail(b.getEmail())) {
                    throw new Exception(b.getEmail(), new Throwable("EMAIL INVALIDO"));
                }
                lBeneficarios.add(b);
            }
        } catch (Exception ex) {
            throw ex;
        }

        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_ASOCIACION_BENEFICARIO");

            call.registerStoredProcedureParameter("EMAIL_BENEFICIARIO", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("SESIONID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("TIPOSESION", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MESES_ANTES", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);
            s.setEstadosesion(new Estadosesion(new BigDecimal(4)));
            sesion.update(s);
            for (Beneficiario bene : lBeneficarios) {

//                if (!new EnviarEmail().validarEmail(bene.getEmail())){
//                    throw new Exception("El siguiente email es invalido: " + bene.getEmail());
//                }
                //Verifico si el beneficiario se puede agendara a la sesion
                // set input parameter
                call.setParameter("EMAIL_BENEFICIARIO", bene.getEmail());
                call.setParameter("SESIONID", s.getIdsesion());
                call.setParameter("TIPOSESION", 2);
                call.setParameter("MESES_ANTES", meses_antes);

                // call the stored procedure and get the result
                call.execute();
                String mensaje = (String) call.getOutputParameterValue("MENSAJE");

                if (!"OK".equals(mensaje)) {
                    throw new Exception(mensaje);
                }

                Date date = new Date();
                Listaasistencia lista = new Listaasistencia();
                lista.setBeneficiario(bene);
                lista.setSesiones(s);
                lista.setFecharegistro(date);
                sesion.save(lista);
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (PersistenceException ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } catch (Exception ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return lBeneficarios;
    }

    /**
     * DAO encargado de asociar a un beneficiario a una sesión de tipo:
     * Evaluacion y Financiación, o Puesta en Marcha y Seguimiento.
     *
     * @param idSesion Identificador de la sesión
     * @param beneficiarios Lista de beneficiarios a asociar
     * @param tipoSesion Tipo de sesión
     * @param estadoEmprendimiento Estado del emprendimiento
     * @return Lista de beneficiarios
     * @throws Exception Cualquier Exception que puede ser lanzada.
     * @throws PersistenceException Exception de persistencia que pueda ser
     * lanzada.
     */
    @Override
    public List<Beneficiario> asociarBeneficiarioEvaluacionSeguimiento(long idSesion, ArrayList<String> beneficiarios,
            int tipoSesion, int estadoEmprendimiento) throws Exception, PersistenceException {

        //Traigo la informacion de la base de datos
        Sesiones s;
        List<Beneficiario> lBeneficarios;
        try {
            s = sesionesDAO.getSesiones(idSesion);
            lBeneficarios = new LinkedList<>();
            for (String bId : beneficiarios) {
                Beneficiario b = beneficiarioDAO.getBeneficiarios(Long.parseLong(bId), null, null, null, null, null).get(0);
                if (!new EnviarEmail().validarEmail(b.getEmail())) {
                    throw new Exception(b.getEmail(), new Throwable("EMAIL INVALIDO"));
                }
                lBeneficarios.add(b);
            }
        } catch (Exception ex) {
            throw ex;
        }

        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_ASOCIACION");

            call.registerStoredProcedureParameter("EMAIL_BENEFICIARIO", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("SESIONID", Long.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("TIPOSESION", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("ESTADO_EMPRENDIMIENTO", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);
            s.setEstadosesion(new Estadosesion(new BigDecimal(4)));
            sesion.update(s);
            for (Beneficiario bene : lBeneficarios) {

                call.setParameter("EMAIL_BENEFICIARIO", bene.getEmail());
                call.setParameter("SESIONID", s.getIdsesion());
                call.setParameter("TIPOSESION", tipoSesion);
                call.setParameter("ESTADO_EMPRENDIMIENTO", estadoEmprendimiento);

                // call the stored procedure and get the result
                call.execute();
                String mensaje = (String) call.getOutputParameterValue("MENSAJE");

                if (!"OK".equals(mensaje)) {
                    throw new Exception(mensaje);
                }

                Date date = new Date();
                Listaasistencia lista = new Listaasistencia();
                lista.setBeneficiario(bene);
                lista.setSesiones(s);
                lista.setFecharegistro(date);
                sesion.save(lista);
            }

            sesion.flush();
            sesion.getTransaction().commit();
        } catch (PersistenceException ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } catch (Exception ex) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return lBeneficarios;
    }

    /**
     * Metodo que registra las asistencias de una sesion en la BD
     *
     * @param asistencias Una lista con los valores de asistencia
     * @param vigencia La vigencia de la encuesta
     * @param idsesion El id de la sesión
     * @return Una lista con los correos de los asistentes
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<CorreosAsistencias> registroAsistenciasE(List<AsistenciasValor2> asistencias, int vigencia, long idsesion) throws Exception {
        //obtener sesion de hibernate
        Session sesion = sessionFactory.openSession();
        List<CorreosAsistencias> correos = new ArrayList();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            for (int i = 0; i < asistencias.size(); i++) {

                long indice = asistencias.get(i).getIdasistencia();
                Character valor = asistencias.get(i).getValor();
                Query elQuery
                        = sesion.createQuery("update Listaasistencia set registroasistencia =:valor, fecharegistro= sysdate()"
                                + " where idasistencia =:indice");
                elQuery.setParameter("indice", indice);
                elQuery.setParameter("valor", valor);
                elQuery.executeUpdate();
                // traigo los datos del beneficiario al que le registre la asistencia para enviarle un email
                Query elQuery2 = sesion.createQuery("from Listaasistencia where idasistencia =:indice", Listaasistencia.class);
                elQuery2.setParameter("indice", indice);
                Listaasistencia lista = (Listaasistencia) elQuery2.getSingleResult();
                CorreosAsistencias correo = new CorreosAsistencias();
                correo.setIdBeneficiario(lista.getBeneficiario().getIdbeneficiario());
                correo.setCorreo(lista.getBeneficiario().getEmail());
                correo.setPrimerNombre(lista.getBeneficiario().getPrimernombre());
                correo.setSegundoNombre(lista.getBeneficiario().getSegundonombre());
                correo.setPrimerApellido(lista.getBeneficiario().getPrimerapellido());
                correo.setSegundoApellido(lista.getBeneficiario().getSegundoapellido());
                if (valor.equals('1')) {
                    correo.setValor("Si");

                } else if (valor.equals('0')) {
                    correo.setValor("No");

                }
                correos.add(correo);
            }
            Query elQuery3
                    = sesion.createQuery("update Sesiones set idestadosesion = '2'"
                            + " where idsesion =:idsesion");
            elQuery3.setParameter("idsesion", idsesion);
            elQuery3.executeUpdate();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_REGISTRO_ASISTENTES_SESION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return correos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFFosfec;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFFosfecId;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import static java.lang.Math.abs;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grow Data PC
 */
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Repository
public class BeneficiarioDAOImpl implements BeneficiarioDAO {

    @Autowired
    private Environment env;

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    private SessionFactory sessionFactory1 = HibernateJdbcSimpc.getSession();

    @Override
    public List<Beneficiario> getBeneficiarios() throws Exception {
        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        List<Beneficiario> beneficiarios = null;
        try {
            sesion.beginTransaction();
            //crear query
            Query<Beneficiario> elQuery
                    = sesion.createQuery("from Beneficiario", Beneficiario.class);
            //obtener  resultado
            beneficiarios = elQuery.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return beneficiarios;
    }

    /**
     * DAO encargado de ubicar un beneficiario por su correo electrónico.
     *
     * @param correo Correo Electrónico por el cual se busca al Beneficiario
     * @return Beneficiario que cumple con los criterios de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Beneficiario getBeneficiario(String correo) throws Exception {

        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Beneficiario beneficiario = null;
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Beneficiario where LOWER(email) =:correo", Beneficiario.class);
            elQuery.setParameter("correo", correo);
            //obtener  resultado
            beneficiario = (Beneficiario) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiario;
    }

    /**
     * Metodo que trae un beneficiario de la BD a partir de su Id
     *
     * @param idbeneficiario El id del beneficiario
     * @return Un beneficiario
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Beneficiario getBeneficiarioPorId(long idbeneficiario) throws Exception {

        // obetener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        Beneficiario beneficiario = new Beneficiario();
        try {

            sesion.beginTransaction();
            //crear query
            Query elQuery
                    = sesion.createQuery("from Beneficiario where idbeneficiario =:idbeneficiario", Beneficiario.class);
            elQuery.setParameter("idbeneficiario", idbeneficiario);
            //obtener  resultado
            beneficiario = (Beneficiario) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_BENEFICIARIO2, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiario;
    }

    /**
     * DAO responsable de conseguir un beneficiario dado su número de documento
     * en la base de datos de SIM-PC
     *
     * @param numDoc Número de Documento por el cual se desean ubicar los
     * Beneficiarios.
     * @return Lista de Beneficiarios que cumplen con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    @Transactional
    public List<MdFDatosBasicos> consultaBeneficiario(String numDoc) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        List<MdFDatosBasicos> beneficiarios = new ArrayList();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from MdFDatosBasicos where numeroDocumento=:numDoc", MdFDatosBasicos.class);
            elQuery.setParameter("numDoc", numDoc);

            beneficiarios = elQuery.getResultList();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_BENEFICIARIO);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiarios;
    }

    /**
     * DAO encargado de registrar los datos de un beneficiario en la base de
     * datos de emprendimiento.
     *
     * @param beneficiario Datos del beneficiario que se desea guardar
     * @return Beneficiario que se acaba de guardar
     * @throws ConstraintViolationException Lanzada por
     * sesion.getTransaction().commit()
     * @throws Exception Cualquier Exception
     * @throws PersistenceException Lanzada por sesion.getTransaction().commit()
     */
    @Override
    @Transactional
    public Beneficiario guardarBeneficiario(Beneficiario beneficiario) throws ConstraintViolationException, Exception, PersistenceException {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(beneficiario);
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
        return beneficiario;
    }

    @Override
    @Transactional
    public Beneficiario traerBeneficiario(String numDoc) {
        Session sesion2 = sessionFactory.getCurrentSession();
        Beneficiario beneficiario = null;
        try {
            sesion2.beginTransaction();
            Query elQuery
                    = sesion2.createQuery("from Beneficiario where numerodocumento=:numDoc", Beneficiario.class);
            elQuery.setParameter("numDoc", numDoc);
            beneficiario = (Beneficiario) elQuery.getSingleResult();

            sesion2.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion2 != null && sesion2.isOpen()) {
                sesion2.close();
            }
        }

        return beneficiario;
    }

    /**
     * DAO encargado de ubicar un beneficiario dado su idbeneficiario.
     *
     * @param saveIdBeneficiario Identificador del Beneficiario
     * @return Beneficiario que cumple con el criterio de búsqueda.
     * @throws Exception Cualquier Exception lanzada.
     */
    @Override
    public Beneficiario getBeneficiario(long saveIdBeneficiario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Beneficiario beneficiario = null;
        try {
            sesion.beginTransaction();

            Query elQuery
                    //          = sesion.createQuery("from Sesiones", Sesiones.class);
                    = sesion.createQuery("from Beneficiario where idbeneficiario=:saveIdBeneficiario", Beneficiario.class);
            elQuery.setParameter("saveIdBeneficiario", saveIdBeneficiario);

            beneficiario = (Beneficiario) elQuery.getSingleResult();

            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiario;
    }

    @Override
    public boolean validaBeneficiario(String doc, String email) throws Exception {
        boolean exist = false;
        Session sesion = null;
        Query<Beneficiario> query = null;
        try {
            sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();
            query = sesion.createQuery("from Beneficiario b where b.email=:email or b.numerodocumento=:doc ", Beneficiario.class);
            query.setParameter("doc", doc);
            query.setParameter("email", email);
            if (query.getSingleResult() != null) {
                exist = true;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return exist;
    }

    @Override
    public List<Beneficiario> getNotificaBeneficiarios() throws Exception {
        List<Beneficiario> beneficiarios = null;
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            NativeQuery<Beneficiario> query = sesion.createNativeQuery(
                    "SELECT b.* FROM emprendimiento.listaasistencia lt "
                    + "INNER JOIN emprendimiento.sesiones se "
                    + "ON se.idsesion=lt.idsesion and se.fechainicio>trunc(sysdate) and se.fechainicio<trunc(sysdate+3) "
                    + "INNER JOIN emprendimiento.beneficiario b "
                    + "ON b.idbeneficiario=lt.idbeneficiario", Beneficiario.class);
            beneficiarios = query.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiarios;

    }

    @Override
    public List<Temasrutaacompanamientoat> getTemasRutaAATPorDocBeneficiario(List<String> estadosEmprendimiento, String numeroDocumentoBen) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Temasrutaacompanamientoat> temasRutaAAT = null;
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select tat "
                    + "from Temasrutaacompanamientoat as tat "
                    + "inner join tat.rutaacompanamientoat as rat "
                    + "inner join Emprendimiento as emp on rat.emprendimiento.idemprendimiento = emp.idemprendimiento "
                    + "inner join emp.estadoemprendimiento as ee "
                    + "inner join Asociados as aso on aso.emprendimiento.idemprendimiento=emp.idemprendimiento "
                    + "inner join aso.beneficiario as b "
                    + "where "
                    + "ee.nombreestadoemprendimiento in (:estadoEmp0) "
                    + "and b.numerodocumento=:numeroDocumentoBen ", Temasrutaacompanamientoat.class);
            int cant = 0;
            for (String estadoEmprendimiento : estadosEmprendimiento) {
                q.setParameter("estadoEmp" + cant, estadoEmprendimiento);
                cant += 1;
            }
            q.setParameter("numeroDocumentoBen", numeroDocumentoBen);
            temasRutaAAT = q.getResultList();
            sesion.getTransaction().commit();
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
     * DAO encargado de consultar un Beneficiario y sus Emprendimientos por
     * Número de Documento.
     *
     * @param estadosEmprendimiento Estados del Emprendimiento
     * @param numeroDocumentoBen Número de Documetos
     * @return Datos del Emprendimiento
     * @throws Exception Cualquier Exception que pueda lanzar.
     */
    @Override
    public Object[] getBeneEmprPorDocBeneficiario(
            List<String> estadosEmprendimiento, String numeroDocumentoBen) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Object[] beneEmprAAT = null;
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select b.idbeneficiario, tdoc.descripcion, b.numerodocumento, b.primernombre, b.primerapellido, b.email, b.telefono, b.fecharegistro, "
                    + "emp.idemprendimiento, temp.nombretipoemprendimiento, ee.nombreestadoemprendimiento, emp.nombreemprendimiento, emp.fecharegistro "
                    + "from Emprendimiento as emp "
                    + "inner join emp.estadoemprendimiento as ee "
                    + "inner join emp.tipoemprendimiento as temp "
                    + "inner join Asociados as aso on aso.emprendimiento.idemprendimiento=emp.idemprendimiento "
                    + "inner join aso.beneficiario as b "
                    + "inner join b.tipodocumentoid as tdoc "
                    + "where "
                    + "ee.nombreestadoemprendimiento in (:estadoEmp0) "
                    + "and b.numerodocumento=:numeroDocumentoBen ");
            int cant = 0;
            for (String estadoEmprendimiento : estadosEmprendimiento) {
                q.setParameter("estadoEmp" + cant, estadoEmprendimiento);
                cant += 1;
            }
            q.setParameter("numeroDocumentoBen", numeroDocumentoBen);
            beneEmprAAT = (Object[]) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneEmprAAT;
    }

    /**
     * DAO responsable de conseguir un beneficiario dado sus nombres y apellidos
     * en la base de datos de SIM-PC
     *
     * @param pNombre Primer nombre por el cual se desea ubicar el Beneficiario
     * @param sNombre Segundo nombre por el cual se desea ubicar el Beneficiario
     * @param pApellido Primer apellido por el cual se desea ubicar el
     * Beneficiario
     * @param sApellido Segundo apellido por el cual se desea ubicar el
     * Beneficiario
     * @return Lista de Benenficiarios que cumplen con el criterio de búsqueda
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<MdFDatosBasicos> getBeneficiarioPorNombreYApellido(String pNombre,
            String sNombre, String pApellido, String sApellido) throws Exception {
        List<MdFDatosBasicos> beneficiarios = new ArrayList();
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            pNombre = Normalizer.normalize(pNombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            pApellido = Normalizer.normalize(pApellido, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            String query = "from MdFDatosBasicos"
                    + " where CONVERT(upper(primerNombre), 'US7ASCII') like concat(:pNombre,'%')"
                    + " and CONVERT(upper(primerApellido), 'US7ASCII') like concat(:pApellido,'%')";

            if (sNombre != null && !("".equals(sNombre))) {
                sNombre = Normalizer.normalize(sNombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                query += " and CONVERT(upper(segundoNombre), 'US7ASCII') like concat(:sNombre,'%')";
            }

            if (sApellido != null && !("".equals(sApellido))) {
                sApellido = Normalizer.normalize(sApellido, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                query += " and CONVERT(upper(segundoApellido), 'US7ASCII') like concat(:sApellido,'%')";
            }

            Query elQuery = sesion.createQuery(query, MdFDatosBasicos.class);
            elQuery.setParameter("pNombre", pNombre.toUpperCase());
            elQuery.setParameter("pApellido", pApellido.toUpperCase());

            if (!("".equals(sNombre))) {
                elQuery.setParameter("sNombre", sNombre.toUpperCase());
            }

            if (!("".equals(sApellido))) {
                elQuery.setParameter("sApellido", sApellido.toUpperCase());
            }

            beneficiarios = elQuery.getResultList();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {

            throw new Exception(MensajesBD.ERROR_CARGA_BENEFICIARIO);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiarios;
    }

    @Override
    public Beneficiario getBeneficiarioXId(long idBeneficiario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Beneficiario beneficiario = new Beneficiario();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Beneficiario where idBeneficiario=:idBeneficiario", Beneficiario.class);
            elQuery.setParameter("idBeneficiario", idBeneficiario);

            beneficiario = (Beneficiario) elQuery.getSingleResult();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_BENEFICIARIO2, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiario;
    }

    /**
     * Busca todos los beneficiarios que cumplan con la condicion de los
     * parametros not null enviados.
     *
     * @param idbeneficiario (opcional) Identificador del Beneficiario
     * @param doc (opcional) Número de Documento del Beneficiario
     * @param pNombre (opcional) Primer nombre del Beneficiario
     * @param sNombre (opcional) Segundo nombre del Beneficiario
     * @param pApellido (opcional) Primer apellido del Beneficiario
     * @param sApellido (opcional) Segundo apellido del Beneficiario
     * @return Retorna una lista con los beneficiarios
     * @throws Exception Cualquier Exception
     */
    public List<Beneficiario> getBeneficiarios(
            Long idbeneficiario,
            String doc,
            String pNombre,
            String sNombre,
            String pApellido,
            String sApellido) throws Exception {

        List<Beneficiario> beneficiarios = null;
        Session sesion = sessionFactory.getCurrentSession();

        String query = "SELECT b "
                + "FROM Beneficiario b"
                + " INNER JOIN Users u ON b.email = u.username"
                + " WHERE 1=1";
        if (idbeneficiario != null) {
            query += " and b.idbeneficiario = :i";
        }

        if (doc != null) {
            query += " and b.numerodocumento = :d";
        }

        if (pNombre != null && !pNombre.equals("")) {
            pNombre = Normalizer.normalize(pNombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            query += " and CONVERT(UPPER(b.primernombre), 'US7ASCII') LIKE CONCAT(UPPER(:pn),'%')";
        }

        if (sNombre != null && !sNombre.equals("")) {
            sNombre = Normalizer.normalize(sNombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            query += " and CONVERT(UPPER(b.segundonombre), 'US7ASCII') LIKE CONCAT(UPPER(:sn),'%')";
        }

        if (pApellido != null && !pApellido.equals("")) {
            pApellido = Normalizer.normalize(pApellido, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            query += " and CONVERT(UPPER(b.primerapellido), 'US7ASCII') LIKE CONCAT(UPPER(:pa),'%')";
        }

        if (sApellido != null && !sApellido.equals("")) {
            sApellido = Normalizer.normalize(sApellido, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            query += " and CONVERT(UPPER(b.segundoapellido), 'US7ASCII') LIKE CONCAT(UPPER(:sa),'%')";
        }

        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery(query, Beneficiario.class);

            if (idbeneficiario != null) {
                q.setParameter("i", idbeneficiario);
            }

            if (doc != null) {
                q.setParameter("d", doc);
            }

            if (pNombre != null && !pNombre.equals("")) {
                q.setParameter("pn", pNombre);
            }

            if (sNombre != null && !sNombre.equals("")) {
                q.setParameter("sn", sNombre);
            }

            if (pApellido != null && !pApellido.equals("")) {
                q.setParameter("pa", pApellido);
            }

            if (sApellido != null && !sApellido.equals("")) {
                q.setParameter("sa", sApellido);
            }
            beneficiarios = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return beneficiarios;
    }

    /**
     * Metodo que trae un beneficiario de la BD a partir de su username y su
     * estado
     *
     * @param estadoUsuario El estado del usuario
     * @param userName El username del usuario
     * @return Un beneficiario
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Beneficiario getBeneficiario(BigDecimal estadoUsuario, String userName) throws Exception {
        Beneficiario response = new Beneficiario();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select b from Beneficiario b inner join Users u on b.email=u.username where u.enabled=:idEstado and u.username=:userName ", Beneficiario.class);
            q.setParameter("userName", userName);
            q.setParameter("idEstado", estadoUsuario);
            response = (Beneficiario) q.getSingleResult();
            sesion.getTransaction().commit();
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
     * DAO responsable de consultar el estado de un determinado beneficiario
     * frente a las validaciones configuradas.
     *
     * @param beneficiario Datos del Beneficiario.
     * @param validaciones Configuración de Validaciones.
     * @return Estado el beneficiario frente a cada consulta.
     * @throws Exception Cualquier Exception
     */
    @Override
    public List<String> verificarRequisitos(MdFDatosBasicos beneficiario, List<Configuracion> validaciones) throws Exception {

        List<String> resultado = new ArrayList<>();
        try {
            //Verifico si la validación de SI-MPC está activa y la verifico
            if (validaciones.get(0).getValor() == 1) {
                resultado.add(verificarBeneficiarioSIMPC(beneficiario));
            } else {
                resultado.add(VALIDACION_INACTIVA);
            }

            //Verifico si la validación de cesante está activa y la verifico
            if (validaciones.get(1).getValor() == 1) {
                resultado.add(verificarBeneficiarioCesante(beneficiario));
            } else {
                resultado.add(VALIDACION_INACTIVA);
            }

            //Verifico si la validación de aportes a CCF está activa y la verifico
            if (validaciones.get(2).getValor() == 1) {
                resultado.add(verificarAportesCCF(beneficiario));
            } else {
                resultado.add(VALIDACION_INACTIVA);
            }

            //Verifico si la validación de recobros está activa y la verifico
            if (validaciones.get(3).getValor() == 1) {
                resultado.add(verificarRecobros(beneficiario));
            } else {
                resultado.add(VALIDACION_INACTIVA);
            }

            //Verifico si la validación de prestaciones económicas está activa y la verifico
            if (validaciones.get(4).getValor() == 1) {
                resultado.add(verificarUltimoPeriodoPrestaciones(beneficiario));
            } else {
                resultado.add(VALIDACION_INACTIVA);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return resultado;
    }

    /**
     * Método encargado de verificar si un beneficiario está en la BD de SIMPC
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Si cumple" o "No cumple" Dependiendo del resultado de la
     * consulta.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    private String verificarBeneficiarioSIMPC(MdFDatosBasicos beneficiario) throws Exception {
        String respuesta = NO_CUMPLE;

        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from MdFDatosBasicos where numeroDocumento=:numDoc"
                    + " AND tipoDocumento=:tipoDoc", MdFDatosBasicos.class);
            elQuery.setParameter("numDoc", beneficiario.getNumeroDocumento());
            elQuery.setParameter("tipoDoc", beneficiario.getTipoDocumento());

            elQuery.getSingleResult();
            respuesta = SI_CUMPLE;
        } catch (NoResultException ex) {
            return respuesta;
        } catch (Exception ex) {
            return MensajesBD.ERROR_CARGA_BENEFICIARIO;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return respuesta;
    }

    /**
     * Método encargado de ubicar (si existe) el último período cuando recibio
     * prestaciones sociales un Beneficiario.
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Nunca" o Período en formato yyyy-MM en caso de existir.
     * @throws Exception Cualquier Exception.
     */
    private String verificarUltimoPeriodoPrestaciones(MdFDatosBasicos beneficiario) throws Exception {
        String respuesta = "Nunca";
        Session sesion = sessionFactory1.getCurrentSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            Boolean dirty = false;
            sesion.beginTransaction();
            MdFFosfecId id = new MdFFosfecId(beneficiario.getTipoDocumento(),
                    beneficiario.getNumeroDocumento());
            Query elQuery = sesion.createQuery("from MdFFosfec where id=:id", MdFFosfec.class);
            elQuery.setParameter("id", id);
            List<MdFFosfec> result = elQuery.getResultList();
            Date ultimoPeriodo = new Date(Long.MIN_VALUE);
            for (MdFFosfec f : result) {
                if (f.getPeriodoBeneficioLiquidado() != null) {
                    Date d = (Date) format.parse(f.getPeriodoBeneficioLiquidado());
                    if (d.compareTo(ultimoPeriodo) > 0) {
                        ultimoPeriodo = d;
                        dirty = true;
                    }
                }
            }
            if (dirty) {
                respuesta = format.format(ultimoPeriodo);
            }
        } catch (Exception ex) {
            return MensajesBD.ERROR_CARGA_BENEFICIARIO;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return respuesta;
    }

    /**
     * Método encargado de ubicar (si existe) el último período cuando recibio
     * prestaciones sociales un Beneficiario.
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Nunca" o Período en formato yyyy-MM en caso de existir.
     * @throws Exception Cualquier Exception.
     */
    private String verificarRecobros(MdFDatosBasicos beneficiario) throws Exception {
        String respuesta = "No posee";
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("SELECT NVL("
                    + " (SELECT a.saldodeuda"
                    + " FROM Recobros r"
                    + " JOIN Abonos a ON a.recobros.idrecobro = r.idrecobro"
                    + " JOIN MdFDatosBasicos m ON m.personId = r.mdFDatosBasicos.personId"
                    + " WHERE m.tipoDocumento = :tipoId"
                    + " AND m.numeroDocumento = :numId),"
                    + " r.valorrecobro) AS VALOR"
                    + " FROM Recobros r"
                    + " JOIN MdFDatosBasicos m ON m.personId = r.mdFDatosBasicos.personId"
                    + " WHERE m.tipoDocumento = :tipoId"
                    + " AND m.numeroDocumento = :numId", Long.class);
            elQuery.setParameter("tipoId", beneficiario.getTipoDocumento());
            elQuery.setParameter("numId", beneficiario.getNumeroDocumento());
            Long result = (Long) elQuery.getSingleResult();
            if (result > 0) {
                respuesta = "Si posee";
            }
        } catch (NoResultException ex) {
            respuesta = "No posee";
        } catch (Exception ex) {
            return MensajesBD.ERROR_CARGA_BENEFICIARIO;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return respuesta;
    }

    /**
     * Método responsable de determinado si un beneficiario se encuentra en
     * condición de cesante.
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Si cumple" o "No cumple" Dependiendo del resultado de la
     * consulta.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    private String verificarBeneficiarioCesante(MdFDatosBasicos beneficiario) throws Exception {
        Session sesion = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Date periodoFosfec = getPeriodoFOSFEC(beneficiario, verificarEstadoFOSFEC(beneficiario));
            if (periodoFosfec == null) {
                return MensajesBD.ERROR_BENEFICIARIO_NO_FOSFEC;
            }
            sesion = sessionFactory1.getCurrentSession();
            sesion.beginTransaction();
            int[] cotizacionesSI = {1, 2, 3, 4, 16, 18, 22, 30, 31, 32, 33, 34, 35, 36, 42, 43, 44, 45, 47, 51, 53, 54, 55, 57, 59, 99};
            int len = 26;
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("GET_ULTIMO_PERIODO_SALUD");

            call.registerStoredProcedureParameter("TIPODOC", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("NUMERODOC", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("PERIODO", String.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("TIPOCOTIZANTE", int.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("DEPENDIENTE", int.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("INDEPENDIENTE", int.class, ParameterMode.OUT);

            call.setParameter("TIPODOC", beneficiario.getTipoDocumento());
            call.setParameter("NUMERODOC", beneficiario.getNumeroDocumento());

            // call the stored procedure and get the result
            call.execute();
            Date ultimaSalud = null;
            try {
                ultimaSalud = format.parse((String) call.getOutputParameterValue("PERIODO"));
            } catch (Exception ex) {
                return MensajesBD.ERROR_BENEFICIARIO_NO_PILA;
            }
            int tipoCotizante = (int) call.getOutputParameterValue("TIPOCOTIZANTE");

            /*Tabla 4 - Verificación de Requisito No 1.*/
            //Caso 1: 
            if (periodoFosfec.compareTo(ultimaSalud) > 0) {
                return SI_CUMPLE;
                //Caso 2:
            } else if (periodoFosfec.compareTo(ultimaSalud) <= 0) {
                for (int i = 0; i < len; i++) {
                    if (tipoCotizante == cotizacionesSI[i]) {
                        return SI_CUMPLE;
                    }
                }
                return NO_CUMPLE;
            }
        } catch (NoResultException ex) {
            return MensajesBD.ERROR_BENEFICIARIO_NO_FOSFEC;
        } catch (PersistenceException ex) {
            return MensajesBD.ERROR_BENEFICIARIO_NO_PILA;
        } catch (Exception ex) {
            return MensajesBD.ERROR_CARGA_BENEFICIARIO;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return NO_CUMPLE;
    }

    /**
     * Método responsable de indicar el estado en el que se encuentra el
     * Beneficiario en la tabla FOSFEC
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Si cumple" o "No cumple" Dependiendo del resultado de la
     * consulta.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    private String verificarEstadoFOSFEC(MdFDatosBasicos beneficiario) throws Exception {
        String respuesta = null;
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            MdFFosfecId id = new MdFFosfecId(beneficiario.getTipoDocumento(),
                    beneficiario.getNumeroDocumento());
            Query elQuery = sesion.createQuery("from MdFFosfec where id=:id", MdFFosfec.class);
            elQuery.setParameter("id", id);
            MdFFosfec result = (MdFFosfec) elQuery.getSingleResult();

            /*Tabla 1: Clasificación de estados ? El estado de la persona se valida de acuerdo con valor de
               la variable 26 y variable 28 conjuntamente.*/
            //Condición Postulado
            if ("5".equals(result.getVerificacionRequisitos()) && "4".equals(result.getBeneficiarioDelMecanismo())) {
                return "postulado";
            } //Condición Aprobado
            else if ("1".equals(result.getVerificacionRequisitos()) && "5".equals(result.getBeneficiarioDelMecanismo())) {
                return "aprobado";
            } //Condición Beneficiario
            else if ("1".equals(result.getVerificacionRequisitos())
                    && ("1".equals(result.getBeneficiarioDelMecanismo())
                    || "2".equals(result.getBeneficiarioDelMecanismo()))) {
                return "beneficiario";
            } //Condición Denegado
            else if ("2".equals(result.getVerificacionRequisitos())
                    && "3".equals(result.getBeneficiarioDelMecanismo())) {
                return "denegado";
            } //Condición Desistido
            else if ("3".equals(result.getVerificacionRequisitos())
                    && "3".equals(result.getBeneficiarioDelMecanismo())) {
                return "desistido";
            } //Condición Cancelado
            else if ("4".equals(result.getVerificacionRequisitos())
                    && "3".equals(result.getBeneficiarioDelMecanismo())) {
                return "cancelado";
            } else {
                return MensajesBD.ERROR_BENEFICIARIO_ESTADO_DESC;
            }

        } catch (NoResultException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Método responsable de indicar el periodo FOSFEC dado el Estado de un
     * Beneficiario
     *
     * @param beneficiario Datos del Beneficiario
     * @param estado Estado del Beneficiario
     * @return Período de acuerdo a su estado
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    private Date getPeriodoFOSFEC(MdFDatosBasicos beneficiario, String estado) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            MdFFosfecId id = new MdFFosfecId(beneficiario.getTipoDocumento(),
                    beneficiario.getNumeroDocumento());
            Query elQuery = sesion.createQuery("from MdFFosfec where id=:id", MdFFosfec.class);
            elQuery.setParameter("id", id);

            if ("postulado".equals(estado)) {
                MdFFosfec result = (MdFFosfec) elQuery.getSingleResult();
                return format.parse(format.format(result.getFechaPostulacionMpc()));
            } else if ("aprobado".equals(estado)) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -1);
                return format.parse(format.format(cal.getTime()));
            } else if ("beneficiario".equals(estado)) {
                MdFFosfec result = (MdFFosfec) elQuery.getSingleResult();
                return format.parse(format.format(result.getFechaLiquidacionBeneficio()));
            } else {
                return null;
            }

        } catch (NoResultException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * Método responsable calcular si un beneficiario a realizado suficientes
     * aportes a CCF.
     *
     * @param beneficiario Datos del Beneficiario
     * @return "Si cumple" o "No cumple" Dependiendo del resultado de la
     * consulta.
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    private String verificarAportesCCF(MdFDatosBasicos beneficiario) throws Exception {
        Session sesion = sessionFactory1.getCurrentSession();
        try {
            sesion.beginTransaction();
            StoredProcedureQuery call = sesion.createStoredProcedureQuery("GET_ULTIMO_PERIODO_SALUD");

            call.registerStoredProcedureParameter("TIPODOC", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("NUMERODOC", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("PERIODO", String.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("TIPOCOTIZANTE", int.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("DEPENDIENTE", int.class, ParameterMode.OUT);
            call.registerStoredProcedureParameter("INDEPENDIENTE", int.class, ParameterMode.OUT);

            call.setParameter("TIPODOC", beneficiario.getTipoDocumento());
            call.setParameter("NUMERODOC", beneficiario.getNumeroDocumento());

            // call the stored procedure and get the result
            call.execute();
            int dependiente = (int) call.getOutputParameterValue("DEPENDIENTE");
            int independiente = (int) call.getOutputParameterValue("INDEPENDIENTE");

            if (dependiente < 0 || independiente < 0) {
                return MensajesBD.ERROR_BENEFICIARIO_NO_PILA;
            }

            /*Tabla 6: Verificación del requisito No. 2.*/
            int aportes = dependiente + independiente / 2 - 360;

            if (aportes >= 0) {
                return SI_CUMPLE;
            }
            return MensajesBD.ERROR_APORTES_INSUFICIENTES + Integer.toString(abs(aportes)) + " días.";

        } catch (PersistenceException ex) {
            return MensajesBD.ERROR_BENEFICIARIO_NO_PILA;
        } catch (Exception ex) {
            return MensajesBD.ERROR_CARGA_BENEFICIARIO;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }
}

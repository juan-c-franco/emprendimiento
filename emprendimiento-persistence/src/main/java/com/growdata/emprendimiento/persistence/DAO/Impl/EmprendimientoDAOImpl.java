package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.PaisescomercializaDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadocajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.persistence.entidad.Paisescomercializa;
import com.growdata.emprendimiento.persistence.entidad.Sectorproductivo;
import com.growdata.emprendimiento.persistence.entidad.Tipoconstitucionlegal;
import com.growdata.emprendimiento.persistence.entidad.Tipoemprendimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class EmprendimientoDAOImpl implements EmprendimientoDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private PaisescomercializaDAO paisescomercializaDAO;

    /**
     * DAO que busca emprendimientos por idemprendimiento y
     * estados
     *
     * @param idemprendimiento Identificador del Emprendimiento
     * @param estados Estados en los que puede estar el Emprendimiento
     * @param idCaja Identificador de la Caja de Compensación a la que debe
     * estar vinculado.
     * @return Emprendimiento que cumpla con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Emprendimiento getEmprendimientoXIdYEstado(long idemprendimiento,
            List<String> estados,
            BigDecimal idCaja) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Emprendimiento emprendimiento = new Emprendimiento();
        String eds = "(";
        int y = 0;
        for (String i : estados) {
            if (y != 0) {
                eds += ",";

            }

            eds += Integer.valueOf(i);
            y++;
        }
        eds += ")";

        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Emprendimiento where"
                    + " idemprendimiento=:idemprendimiento"
                    + (idCaja != null ? " and cajacompensacion.idcajacompensacion = :caja" : "")
                    + " and idestadoemprendimiento in " + eds, Emprendimiento.class);
            elQuery.setParameter("idemprendimiento", idemprendimiento);
            if (idCaja != null) {
                elQuery.setParameter("caja", idCaja);
            }

            emprendimiento = (Emprendimiento) elQuery.getSingleResult();
            sesion.getTransaction().commit();
            Set<Formalizado> formal
                    = new HashSet<Formalizado>(0);
            for (Formalizado f : emprendimiento.getFormalizados()) {
                Set<Paisescomercializa> paisescomercializas
                        = new HashSet<Paisescomercializa>(paisescomercializaDAO
                                .getPaisescomercializaPorFormalizado(f.getIdformalizacion()));
                f.setPaisescomercializas(paisescomercializas);
                formal.add(f);
            }
            emprendimiento.setFormalizados(formal);
        } catch (NoResultException n) {
            try {
                Query elQuery2 = sesion.createQuery("from Emprendimiento where"
                        + " idemprendimiento=:idemprendimiento"
                        + (idCaja != null ? " and cajacompensacion.idcajacompensacion = :caja" : ""),
                        Emprendimiento.class);
                elQuery2.setParameter("idemprendimiento", idemprendimiento);
                if (idCaja != null) {
                    elQuery2.setParameter("caja", idCaja);
                }

                emprendimiento = (Emprendimiento) elQuery2.getSingleResult();
                sesion.getTransaction().commit();
                String estadoModificado = MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO;
                estadoModificado = estadoModificado + emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento();
                Estadoemprendimiento estado = new Estadoemprendimiento();
                estado = emprendimiento.getEstadoemprendimiento();
                estado.setNombreestadoemprendimiento(estadoModificado);
                emprendimiento.setEstadoemprendimiento(estado);
                throw new Exception(estadoModificado);

            } catch (NoResultException r) {
                throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, r);
            } catch (Exception ex) {
                if (ex.getMessage().equals(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO)) {
                    throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, ex);
                }
                throw ex;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimiento;
    }

    /**
     * Metodo que trae una lista de emprendimientos a partir de una lista de
     * estados
     *
     * @param estadosEmprendimiento Lista de estados
     * @return Lista de emprendimientos
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Emprendimiento> getEmprendimientosPorEstado(List<String> estadosEmprendimiento) throws Exception {
        List<Emprendimiento> emprendimientos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            String qStr = "from Emprendimiento where estadoemprendimiento.nombreestadoemprendimiento in (";
            for (int i = 0; i < estadosEmprendimiento.size(); i++) {
                qStr += ":estadoEmprendimiento" + i + ",";
            }
            qStr = qStr.substring(0, qStr.length() - 1);
            qStr += ")";
            Query q = sesion.createQuery(qStr, Emprendimiento.class);
            int cant = 0;
            for (String estadoEmprendimiento : estadosEmprendimiento) {
                q.setParameter("estadoEmprendimiento" + cant, estadoEmprendimiento);
                cant += 1;
            }
            emprendimientos = q.getResultList();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            emprendimientos = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimientos;
    }

    /**
     * DAO responsable de obtener un emprendimiento por su idemprendimiento.
     *
     * @param idEmprendimiento Identificador del Emprendimiento
     * @return Emprendimiento que cumple con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Emprendimiento getEmprendimientoPorId(long idEmprendimiento) throws Exception {
        Emprendimiento emprendimiento = new Emprendimiento();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Emprendimiento where idemprendimiento=:idEmprendimiento", Emprendimiento.class);
            q.setParameter("idEmprendimiento", idEmprendimiento);
            emprendimiento = (Emprendimiento) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            emprendimiento = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimiento;
    }

    /**
     * Metodo que trae una lista de emprendimientos a partir de un nombre, unos
     * estados y un id de caja de compensación
     *
     * @param nombreEmprendimiento El nombre del emprendimiento
     * @param estados Los estados en los que el emprendimiento debe estar
     * @param idCaja El id de la caja de compensación
     * @return Una lista de emprendimientos
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Emprendimiento> getEmprendimientoPorNombre(String nombreEmprendimiento, List<String> estados, BigDecimal idCaja) throws Exception {
        List<Emprendimiento> emprendimientos = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        String eds = "(";
        int y = 0;
        for (String i : estados) {
            if (y != 0) {
                eds += ",";

            }

            eds += Integer.valueOf(i);
            y++;
        }
        eds += ")";

        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Emprendimiento where CONVERT(upper(nombreemprendimiento), 'US7ASCII') like concat('%',:nombreEmprendimiento,'%') "
                    + " and cajacompensacion.idcajacompensacion = :caja "
                    + "and idestadoemprendimiento in" + eds, Emprendimiento.class);
            q.setParameter("nombreEmprendimiento", nombreEmprendimiento.toUpperCase());
            q.setParameter("caja", idCaja);
            emprendimientos = q.getResultList();
            if (emprendimientos.size() < 1) {
                Query q2 = sesion.createQuery("from Emprendimiento where upper(nombreemprendimiento) like concat('%',:nombreEmprendimiento,'%') "
                        + " and cajacompensacion.idcajacompensacion = :caja",
                        Emprendimiento.class);
                nombreEmprendimiento = Normalizer.normalize(nombreEmprendimiento, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                q2.setParameter("nombreEmprendimiento", nombreEmprendimiento.toUpperCase());
                q2.setParameter("caja", idCaja);
                emprendimientos = q2.getResultList();
                sesion.getTransaction().commit();
                if (emprendimientos.size() > 0) {

                    for (Emprendimiento e : emprendimientos) {
                        Estadoemprendimiento estado = new Estadoemprendimiento(BigDecimal.TEN, MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO + e.getEstadoemprendimiento().getNombreestadoemprendimiento(), null, null, null);
                        e.setEstadoemprendimiento(estado);
                    }
//                    for (int j = 0; j < emprendimientos.size(); j++){ 
////                    for (Emprendimiento e : emprendimientos) {
//                    //                    String estadoModificado = MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO;
//                    //                    estadoModificado = estadoModificado + e.getEstadoemprendimiento().getNombreestadoemprendimiento();
//                    //                    Estadoemprendimiento estado = new Estadoemprendimiento();
//                    //                    estado = e.getEstadoemprendimiento();
//                    //                    estado.setNombreestadoemprendimiento(estadoModificado);
//                    //                        e.getEstadoemprendimiento().setNombreestadoemprendimiento(MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO + e.getEstadoemprendimiento().getNombreestadoemprendimiento());
//
//                        emprendimientos.get(j).getEstadoemprendimiento().setNombreestadoemprendimiento(MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO + emprendimientos.get(j).getEstadoemprendimiento().getNombreestadoemprendimiento());
//                    }
                } else {
                    throw new NoResultException();
                }
            } else {
                sesion.getTransaction().commit();
            }

        } catch (NoResultException n) {
            throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, n);
        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO)) {
                throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, ex);
            }
            throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimientos;
    }

    /**
     * DAO para registrar un emprendimiento formalizado
     *
     * @param idFuncionario Identificador de Funcionario que registró el
     * emprendimiento
     * @param idcajacompensacion Identificador de la Caja a la que pertenece el
     * Funcionario.
     * @param nombreEmpresa Nombre de la Emprensa
     * @param nit NIT de la Empresa
     * @param nRegistroMercantil Registro Mercantil
     * @param nombreRepresentante Nombre del Representante Legal
     * @param nombreEmprendimiento Nombre del Emprendimiento
     * @param direccion Dirección de la Empresa
     * @param telefono Teléfono de la Empresa
     * @param email Correo Electrónico de la Empresa
     * @param web Página web de la Empresa
     * @param constitucion Tipo de Constitución Legal
     * @param sector Sector Productivo
     * @param tEmprendimiento Tipo de Emprendimiento
     * @param paisesComercializa Paises con los que comercializa
     * @param beneficiarios Lista de Beneficiarios asociados al Emprendimiento
     * @param negInternet Negocios por Internet
     * @param prodServ Productos y Servicios que ofrece
     * @param fechaRenov Fecha de Renovación de Matrícula
     * @param fechaInicio Fecha de Inicio de Labores
     * @param actividad Actividad Internacional
     * @param empDirectos Número de Empleados Directos
     * @param empIndirectos Número de Empleados Indirectos
     * @param meses_antes Parámetro que indica la cantidad de meses que debe
     * pasar un beneficiario entre registrar un nuevo emprendimiento y uno
     * anterior.
     * @param idmunicipio Identificador del Municipio de la Empresa
     * @return Identificador del formalizado
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public long guardarFormalizado(Long idFuncionario,
            BigDecimal idcajacompensacion,
            String nombreEmpresa,
            String nit,
            String nRegistroMercantil,
            String nombreRepresentante,
            String nombreEmprendimiento,
            String direccion,
            Long telefono,
            String email,
            String web,
            BigDecimal constitucion,
            BigDecimal sector,
            BigDecimal tEmprendimiento,
            List<List<String>> paisesComercializa,
            List<String> beneficiarios,
            Character negInternet,
            String prodServ,
            Date fechaRenov,
            Date fechaInicio,
            BigDecimal actividad,
            BigDecimal empDirectos,
            BigDecimal empIndirectos,
            int meses_antes,
            int idmunicipio) throws Exception {
        long idEmprendimiento;
        List<Beneficiario> lBeneficarios;
        try {
            lBeneficarios = new LinkedList<>();
            for (String bId : beneficiarios) {
                lBeneficarios.add(beneficiarioDAO.getBeneficiarios(Long.parseLong(bId), null, null, null, null, null).get(0));
            }
        } catch (Exception ex) {
            throw ex;
        }

        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Estadocajacompensacion estadoCaja = new Estadocajacompensacion(BigDecimal.ONE);
            Cajacompensacion caja = new Cajacompensacion(idcajacompensacion, estadoCaja);
            Estadoemprendimiento estadoEmp = new Estadoemprendimiento(BigDecimal.ONE);
            Tipoemprendimiento tipoEmp = new Tipoemprendimiento(tEmprendimiento);
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setEstadoemprendimiento(estadoEmp);
            emprendimiento.setTipoemprendimiento(tipoEmp);
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setNombreemprendimiento(nombreEmprendimiento);
            emprendimiento.setCajacompensacion(caja);
            emprendimiento.setFormalizado(1);

            idEmprendimiento = (Long) sesion.save(emprendimiento);
            emprendimiento.setIdemprendimiento(idEmprendimiento);

            Tipoconstitucionlegal tipoConstLegal = new Tipoconstitucionlegal();
            tipoConstLegal.setIdtipoconstitucionlegal(constitucion);
            Sectorproductivo sectorProd = new Sectorproductivo();
            sectorProd.setIdsectorproductivo(sector);
            Actividadinternacional actInter = new Actividadinternacional();
            actInter.setIdactividadinternacional(actividad);
            Formalizado formalizado = new Formalizado(0, emprendimiento, tipoConstLegal,
                    sectorProd, actInter, nombreEmpresa, nombreRepresentante, prodServ,
                    negInternet, nRegistroMercantil, fechaRenov, nit, fechaInicio,
                    empDirectos, empIndirectos, direccion, telefono, idmunicipio, email, web);
            Long f = (Long) sesion.save(formalizado);
            String y;
            for (String x : paisesComercializa.get(0)) {
                Paisescomercializa p = new Paisescomercializa();
                Paises pais = new Paises();
                pais.setIdpais(Integer.valueOf(x).intValue());
                p.setFormalizado(formalizado);
                p.setPaises(pais);
                sesion.save(p);
            }

            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_BEN_PARA_EMPRENDIMIENTO");

            call.registerStoredProcedureParameter("EMAIL_BENEFICIARIO", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MESES_ANTES", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            boolean dummy = true;
            for (Beneficiario b : lBeneficarios) {
                call.setParameter("EMAIL_BENEFICIARIO", b.getEmail());
                call.setParameter("MESES_ANTES", meses_antes);

                // call the stored procedure and get the result
                call.execute();
                String mensaje = (String) call.getOutputParameterValue("MENSAJE");

                if (!"OK".equals(mensaje)) {
                    throw new Exception(mensaje);
                }

                Asociados a = new Asociados();
                a.setBeneficiario(b);
                a.setEmprendimiento(emprendimiento);
                a.setFecharegistro(new Date());
                a.setLider('0');
                if (dummy) {
                    a.setLider('1');
                    dummy = false;
                }
                sesion.save(a);
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
        return idEmprendimiento;
    }

    /**
     * DAO para registrar un emprendimiento no establecido
     *
     * @param idFuncionario Identificador del Funcionario que registró el
     * Emprendimiento
     * @param idcajacompensacion Identificador de la caja de compensación a la
     * que está vinculado el Funcionario
     * @param nombreEmprendimiento Nombre del Emprendimiento
     * @param tEmprendimiento Tipo de Emprendimiento
     * @param constitucion Tipo de Constitución Legal
     * @param sector Sector Productivo
     * @param beneficiarios Lista de Beneficiarios asociados al Emprendimiento
     * @param prodServ Productos y Servicios que ofrece
     * @param cuandoInicia Fecha de Inicio de Labores
     * @param observaciones Observaciones sobre la Empresa
     * @param meses_antes Parámetro que indica la cantidad de meses que deben
     * pasar entre que un beneficiario registra un nuevo emprendimiento y uno
     * anterior.
     * @return Identificador del nuevo Emprendimiento
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public long guardarNoEstablecido(Long idFuncionario,
            BigDecimal idcajacompensacion,
            String nombreEmprendimiento,
            BigDecimal tEmprendimiento,
            BigDecimal constitucion,
            BigDecimal sector,
            List<String> beneficiarios,
            String prodServ,
            Date cuandoInicia,
            String observaciones,
            int meses_antes) throws Exception {
        long idEmprendimiento;
        List<Beneficiario> lBeneficarios;
        try {
            lBeneficarios = new LinkedList<>();
            for (String bId : beneficiarios) {
                lBeneficarios.add(beneficiarioDAO.getBeneficiarios(Long.parseLong(bId), null, null, null, null, null).get(0));
            }
        } catch (Exception ex) {
            throw ex;
        }
        //Hago las transaciones en la base de datos
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Estadocajacompensacion estadoCaja = new Estadocajacompensacion(BigDecimal.ONE);
            Cajacompensacion caja = new Cajacompensacion(idcajacompensacion, estadoCaja);
            Estadoemprendimiento estadoEmp = new Estadoemprendimiento(BigDecimal.ONE);
            Tipoemprendimiento tipoEmp = new Tipoemprendimiento(tEmprendimiento);
            Emprendimiento emprendimiento = new Emprendimiento();
            emprendimiento.setEstadoemprendimiento(estadoEmp);
            emprendimiento.setTipoemprendimiento(tipoEmp);
            emprendimiento.setFecharegistro(new Date());
            emprendimiento.setNombreemprendimiento(nombreEmprendimiento);
            emprendimiento.setCajacompensacion(caja);
            emprendimiento.setFormalizado(0);

            idEmprendimiento = (Long) sesion.save(emprendimiento);
            emprendimiento.setIdemprendimiento(idEmprendimiento);

            Tipoconstitucionlegal tipoConstLegal = new Tipoconstitucionlegal();
            tipoConstLegal.setIdtipoconstitucionlegal(constitucion);
            Sectorproductivo sectorProd = new Sectorproductivo();
            sectorProd.setIdsectorproductivo(sector);
            Noestablecido noEstablecido = new Noestablecido(null, emprendimiento,
                    tipoConstLegal, sectorProd, prodServ, cuandoInicia, observaciones);

            StoredProcedureQuery call = sesion.createStoredProcedureQuery("VAL_BEN_PARA_EMPRENDIMIENTO");

            call.registerStoredProcedureParameter("EMAIL_BENEFICIARIO", String.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MESES_ANTES", Integer.class, ParameterMode.IN);
            call.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);

            boolean dummy = true;
            for (Beneficiario b : lBeneficarios) {
                call.setParameter("EMAIL_BENEFICIARIO", b.getEmail());
                call.setParameter("MESES_ANTES", meses_antes);

                // call the stored procedure and get the result
                call.execute();
                String mensaje = (String) call.getOutputParameterValue("MENSAJE");

                if (!"OK".equals(mensaje)) {
                    throw new Exception(mensaje);
                }

                Asociados a = new Asociados();
                a.setBeneficiario(b);
                a.setEmprendimiento(emprendimiento);
                a.setFecharegistro(new Date());
                a.setLider('0');
                if (dummy) {
                    a.setLider('1');
                    dummy = false;
                }
                sesion.save(a);
            }
            sesion.save(noEstablecido);
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
        return idEmprendimiento;
    }

    /**
     * DAO responsable de ubicar un emprendimiento que cumple con los parámetros especificados.
     *
     * @param estadosEmprendimiento Estados en los que puede estar el
     * emprendimiento
     * @param numeroDocumentoBen Número de Documento del Beneficiario
     * @param idCajaCompensacion Identificador de la caja de compensación que
     * realiza la consulta.
     * @return Emprendimiento que cumpla con los criterios de búsqueda
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Emprendimiento getEmprendimientoPorBeneficiarioYFuncionario(
            List<String> estadosEmprendimiento,
            String numeroDocumentoBen, BigDecimal idCajaCompensacion) throws Exception {
        Emprendimiento emprendimiento = new Emprendimiento();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            String qStr = "select e "
                    + "from Asociados as aso "
                    + "inner join aso.beneficiario as b "
                    + "inner join aso.emprendimiento as e "
                    + "inner join e.estadoemprendimiento as ee "
                    //                    + "inner join Rutaacompanamientoat as ra on ra.emprendimiento.idemprendimiento=aso.emprendimiento.idemprendimiento and ra.emprendimiento.idemprendimiento=e.idemprendimiento "
                    //                    + "inner join Sesionacompanamientoat as sa on sa.rutaacompanamientoat.idrutaacompanamientoat = ra.idrutaacompanamientoat.idrutaacompanamientoat "
                    //                    + "inner join sa.estadosesion as es "
                    + "where "
                    + "b.numerodocumento=:numeroDocumentoBen "
                    + " and e.cajacompensacion.idcajacompensacion=:idCaja"
                    //                    + "and sa.funcionario.idfuncionario=:idAsistenteTecnico "
                    + " and ee.nombreestadoemprendimiento in (";
            for (int i = 0; i < estadosEmprendimiento.size(); i++) {
                qStr += ":estadoEmprendimiento" + i + ",";
            }
            qStr = qStr.substring(0, qStr.length() - 1);
            qStr += ")";
            qStr += " order by e.fecharegistro desc";

//            qStr += " and es.nombreestadosesion in (";
//            for (int i = 0; i < estadosSesion.size(); i++) {
//                qStr += ":estadoSesion" + i + ",";
//            }
//            qStr = qStr.substring(0, qStr.length() - 1);
//            qStr += ")";
            Query q = sesion.createQuery(qStr, Emprendimiento.class);
            int cant = 0;
            for (String estadoEmprendimiento : estadosEmprendimiento) {
                q.setParameter("estadoEmprendimiento" + cant, estadoEmprendimiento);
                cant += 1;
            }
//            cant = 0;
//            for (String estadoSesion : estadosSesion) {
//                q.setParameter("estadoSesion" + cant, estadoSesion);
//                cant += 1;
//            }
            q.setParameter("idCaja", idCajaCompensacion);
            q.setParameter("numeroDocumentoBen", numeroDocumentoBen);
            q.setMaxResults(1);
            emprendimiento = (Emprendimiento) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            emprendimiento = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimiento;
    }

    /**
     * DAO encargado de actualizar el estado de un emprendimiento.
     *
     * @param idemprendimiento Identificador del Emprendimiento
     * @param estadoEmprendimiento Estado en el que debe estar el Emprendimiento
     * @throws HibernateException Lanzada por sesion.update(emprendimiento)
     */
    @Override
    public void updateEmprendimiento(long idemprendimiento, Estadoemprendimiento estadoEmprendimiento) throws HibernateException {
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
            emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
            emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            sesion.update(emprendimiento);
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
    }

    /**
     * DAO encargado de obtener el estado actual de un emprendimiento.
     *
     * @param idestadoemprendimiento Identificador del Emprendimiento
     * @return Estado actual del Emprendimiento
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Estadoemprendimiento getEstadoEmprendimiento(BigDecimal idestadoemprendimiento) throws Exception {
        Estadoemprendimiento estadoemprendimiento = new Estadoemprendimiento();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Estadoemprendimiento where idestadoemprendimiento=:idestadoemprendimiento", Estadoemprendimiento.class);
            q.setParameter("idestadoemprendimiento", idestadoemprendimiento);
            estadoemprendimiento = (Estadoemprendimiento) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException nr) {
            estadoemprendimiento = null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return estadoemprendimiento;
    }

    /**
     * Servicio encargado de ubicar los emprendimientos que
     * cumplam con los criterios de búsqueda.
     *
     * @param estados Estados en los que puede estar el emprendimiento.
     * @param idcajacompensacion Identificador de la caja de compensación a la
     * que debe estar vinculado el emprendimiento.
     * @return Lista de Emprendimientos que cumplan con la búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Emprendimiento> getEmprendimientosPorEdo(List<String> estados, BigDecimal idcajacompensacion) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Emprendimiento> emprendimientos = new ArrayList<>();
        String eds = "(";
        int y = 0;
        for (String i : estados) {
            if (y != 0) {
                eds += ",";

            }

            eds += Integer.valueOf(i);
            y++;
        }
        eds += ")";

        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Emprendimiento where idestadoemprendimiento in " + eds + "and idcajacompensacion=:idcajacompensacion", Emprendimiento.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            emprendimientos = elQuery.getResultList();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimientos;
    }

    /**
     * DAO encargado de ubicar los emprendimientos que cumplan con los criterios 
     * de búsqueda.
     *
     * @param idSesionComite Id de la Sesión Comité
     * @param estadoEmprendimiento Estado en los que deben estar los
     * emprendimeintos.
     * @param idcajacompensacion Identificador de la caja de compensación a
     * donde deben estar vinculados los emprendimientos.
     * @return Lista de Emprendimientos que cumplan con los criterios de
     * búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Emprendimiento> getEmprendimientosComite(long idSesionComite,
            int estadoEmprendimiento, BigDecimal idcajacompensacion) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Emprendimiento> emprendimientos = new ArrayList<>();

        try {
            sesion.beginTransaction();
            String q = "SELECT x"
                    + " FROM Emprendimiento x"
                    + " WHERE x.estadoemprendimiento.idestadoemprendimiento = :estadoEmprendimiento"
                    + " AND x.idemprendimiento NOT IN ("
                    + "SELECT e.emprendimiento.idemprendimiento"
                    + " FROM Sesioncomite s"
                    + " INNER JOIN Evaluacionemprendimientos e ON e.sesioncomite.idsesioncomite = s.idsesioncomite"
                    + " WHERE s.fechainicio >= SYSDATE)";

            if (idSesionComite != -1) {
                q += " AND s.idsesioncomite = :id";
            }

            if (idcajacompensacion != null) {
                q += " AND x.cajacompensacion.idcajacompensacion = :idCaja";
            }

            Query elQuery = sesion.createQuery(q, Emprendimiento.class);

            if (idSesionComite != -1) {
                elQuery.setParameter("id", idSesionComite);
            }

            if (idcajacompensacion != null) {
                elQuery.setParameter("idCaja", idcajacompensacion);
            }
            elQuery.setParameter("estadoEmprendimiento", new BigDecimal(estadoEmprendimiento));
            emprendimientos = elQuery.getResultList();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimientos;
    }

    /**
     * DAO responsable de ubicar los emprendimientos
     * vinculados a una Sesión Comité.
     *
     * @param idSesionComite Identificador de la Sesión Comité
     * @return Lista de Emprendimientos vinculados a la sesión comité
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Emprendimiento> getEmprendimientosComitePorIdSesion(long idSesionComite) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Emprendimiento> emprendimientos = new ArrayList<>();

        try {
            sesion.beginTransaction();
            String q = "SELECT x"
                    + " FROM Emprendimiento x"
                    + " INNER JOIN Evaluacionemprendimientos e ON e.emprendimiento.idemprendimiento = x.idemprendimiento"
                    + " INNER JOIN Sesioncomite s ON s.idsesioncomite = e.sesioncomite.idsesioncomite"
                    + " WHERE s.idsesioncomite = :idSesionComite";

            Query elQuery = sesion.createQuery(q, Emprendimiento.class);
            elQuery.setParameter("idSesionComite", idSesionComite);
            emprendimientos = elQuery.getResultList();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimientos;
    }

    /**
     * Metodo que trae un emprendimiento de la BD a partir de su id, unos
     * estados y un id de caja de compensación
     *
     * @param idemprendimiento El id del emprendimiento
     * @param estados Los estados en que el emprendimiento debe estar
     * @param idCaja El id de la caja de compensación
     * @return Un emprendimiento
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Emprendimiento getEmprendimientoXIdYEstado2(long idemprendimiento,
            List<String> estados,
            BigDecimal idCaja) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Emprendimiento emprendimiento = new Emprendimiento();
        String eds = "(";
        int y = 0;
        for (String i : estados) {
            if (y != 0) {
                eds += ",";

            }

            eds += Integer.valueOf(i);
            y++;
        }
        eds += ")";

        try {
            sesion.beginTransaction();
            Query elQuery = sesion.createQuery("from Emprendimiento where"
                    + " idemprendimiento=:idemprendimiento"
                    + (idCaja != null ? " and cajacompensacion.idcajacompensacion = :caja" : "")
                    + " and idestadoemprendimiento in " + eds, Emprendimiento.class);
            elQuery.setParameter("idemprendimiento", idemprendimiento);
            if (idCaja != null) {
                elQuery.setParameter("caja", idCaja);
            }

            emprendimiento = (Emprendimiento) elQuery.getSingleResult();
            sesion.getTransaction().commit();
            Set<Formalizado> formal
                    = new HashSet<Formalizado>(0);
            for (Formalizado f : emprendimiento.getFormalizados()) {
                Set<Paisescomercializa> paisescomercializas
                        = new HashSet<Paisescomercializa>(paisescomercializaDAO
                                .getPaisescomercializaPorFormalizado(f.getIdformalizacion()));
                f.setPaisescomercializas(paisescomercializas);
                formal.add(f);
            }
            emprendimiento.setFormalizados(formal);
        } catch (NoResultException n) {

            try {
                Query elQuery2 = sesion.createQuery("from Emprendimiento where"
                        + " idemprendimiento=:idemprendimiento"
                        + (idCaja != null ? " and cajacompensacion.idcajacompensacion = :caja" : ""),
                        Emprendimiento.class);
                elQuery2.setParameter("idemprendimiento", idemprendimiento);
                if (idCaja != null) {
                    elQuery2.setParameter("caja", idCaja);
                }

                emprendimiento = (Emprendimiento) elQuery2.getSingleResult();
                sesion.getTransaction().commit();
                String estadoModificado = MensajesBD.ERROR_EMPRENDIMIENTO_OTRO_ESTADO;
                estadoModificado = estadoModificado + emprendimiento.getEstadoemprendimiento().getNombreestadoemprendimiento();
                Estadoemprendimiento estado = new Estadoemprendimiento();
                estado = emprendimiento.getEstadoemprendimiento();
                estado.setNombreestadoemprendimiento(estadoModificado);
                emprendimiento.setEstadoemprendimiento(estado);

            } catch (NoResultException r) {
                throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, r);
            } catch (Exception ex) {
                if (ex.getMessage().equals(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO)) {
                    throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, ex);
                }

                throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
            }

        } catch (Exception ex) {
            if (ex.getMessage().equals(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO)) {
                throw new Exception(MensajesBD.ERROR_EMPRENDIMIENTO_NO_ENCONTRADO, ex);
            }

            throw new Exception(MensajesBD.ERROR_CARGA_EMPRENDIMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return emprendimiento;
    }

}

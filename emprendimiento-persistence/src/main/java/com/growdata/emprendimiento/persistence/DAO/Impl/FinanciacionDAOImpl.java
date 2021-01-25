/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.FinanciacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFFosfec;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcSimpc;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class FinanciacionDAOImpl implements FinanciacionDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();
    private SessionFactory sessionFactory1 = HibernateJdbcSimpc.getSession();

    /**
     * Metodo que registra la informacion financiera basica de un emprendimiento
     * y actualiza su estado en la BD
     *
     * @param financiacion Financiación que contiene toda la información
     * financiera basica a registrar
     * @param idemprendimiento El id del emprendimiento
     * @param estadoEmprendimiento El estado al que se actualiza el
     * emprendimiento
     * @param aprobado Dependiendo si es aprobado o no, se actualiza o no el
     * estado del emprendimiento
     * @return El id de la financiación registrada
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long guardarInformacionFinancieraBasica(Financiacion financiacion, long idemprendimiento, Estadoemprendimiento estadoEmprendimiento, String aprobado) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Financiacion financiacion2 = new Financiacion();
        long id = -1;
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery = sesion.createQuery("from Financiacion where idemprendimiento=:idEmprendimiento", Financiacion.class);
            elQuery.setParameter("idEmprendimiento", financiacion.getEmprendimiento().getIdemprendimiento());
            //obtengo resultados del query
            financiacion2 = (Financiacion) elQuery.getSingleResult();

            if (financiacion2 != null) {
                financiacion2.setFuncionario(financiacion.getFuncionario());
                financiacion2.setEmprendimiento(financiacion.getEmprendimiento());
                financiacion2.setCapitaltotal(financiacion.getCapitaltotal());
                financiacion2.setCapitaltrabajo(financiacion.getCapitaltrabajo());
                financiacion2.setCuotaspactadass(financiacion.getCuotaspactadass());
                financiacion2.setEmpleosporgenerar(financiacion.getEmpleosporgenerar());
                financiacion2.setMesespuntoequilibrio(financiacion.getMesespuntoequilibrio());
                financiacion2.setMontofinanciacions(financiacion.getMontofinanciacions());
                financiacion2.setRecursospropiosae(financiacion.getRecursospropiosae());
                financiacion2.setTasaintertess(financiacion.getTasaintertess());
                financiacion2.setTipofinanciacionByIdtipofinanciacions(financiacion.getTipofinanciacionByIdtipofinanciacions());
                sesion.update(financiacion2);
                id = financiacion2.getIdfinanciacion();
                if ("1".equals(aprobado)) {

                    Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
                    emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
                    emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                    sesion.update(emprendimiento);
                }
                sesion.flush();
            }
            sesion.getTransaction().commit();
        } catch (NoResultException ex) {
            id = (long) sesion.save(financiacion);
            if ("1".equals(aprobado)) {
                Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
                emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
                emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                sesion.update(emprendimiento);
            }
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_REGISTRO_FINANCIACION_BASICA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * Metodo que trae la informacion financiera basica de un emprendimiento de
     * la BD a partir de un id de emprendimiento
     *
     * @param idEmprendimiento El id del emprendimiento
     * @return La información financiera
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Financiacion getFinanciacionPorId(long idEmprendimiento) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Financiacion financiacion = new Financiacion();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query

            Query elQuery = sesion.createQuery("from Financiacion where idemprendimiento=:idEmprendimiento", Financiacion.class);
            elQuery.setParameter("idEmprendimiento", idEmprendimiento);
            //obtengo resultados del query
            financiacion = (Financiacion) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FINANCIACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

        return financiacion;
    }

    /**
     * Metodo que registra la información financiera de un emprendimiento y
     * actualiza su estado en la BD
     *
     * @param financiacion Financiación que contiene la información financiera a
     * registrar
     * @param idemprendimiento El id del emprendimiento
     * @param estadoEmprendimiento El estado al que se actualiza el
     * emprendimiento
     * @param validacionActiva Dice si la validacion de fosfec esta activa o no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public void guardarInformacionFinanciera(Financiacion financiacion, long idemprendimiento,
            Estadoemprendimiento estadoEmprendimiento, int validacionActiva) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        Session sesion2 = sessionFactory1.getCurrentSession();
        List<Asociados> asociados = new ArrayList();
        Financiacion financiacion2 = new Financiacion();
        List<MdFFosfec> fosfecs = new ArrayList();
        List<List<MdFFosfec>> listaFosfecs = new ArrayList();
//        Date ahora = new Date();
        Timestamp desde = null;
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(ahora);
//        cal2.add(Calendar.DATE, -1);
//        Date hasta = cal2.getTime();
        Timestamp hasta = new Timestamp(System.currentTimeMillis() - (3600000 * 24));
        Timestamp fechaLiquidacion = null;
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            sesion2.beginTransaction();
            if (financiacion.getTipofinanciacionByIdtipofinanciaciona().getIdtipofinanciacion().intValue() == 1 && validacionActiva == 1) {
                Query elQuery2 = sesion.createQuery("From Asociados where idemprendimiento=:idemprendimiento", Asociados.class);
                elQuery2.setParameter("idemprendimiento", idemprendimiento);
                asociados = elQuery2.getResultList();
                StoredProcedureQuery call = sesion2.createStoredProcedureQuery("GET_PRIMERA_LIQUIDACION");

                call.registerStoredProcedureParameter("TIPODOC", String.class, ParameterMode.IN);
                call.registerStoredProcedureParameter("NUMERODOC", String.class, ParameterMode.IN);
                call.registerStoredProcedureParameter("DESDE", Timestamp.class, ParameterMode.IN);
                call.registerStoredProcedureParameter("FECHA_LIQUIDACION_BENEFICIO", Timestamp.class, ParameterMode.OUT);
                for (Asociados asociado : asociados) {
                    desde = new Timestamp(System.currentTimeMillis() - (50 * 365 * 24 * 3600000));

                    while (hasta.compareTo(new Timestamp(System.currentTimeMillis())) < 0) {
                        fechaLiquidacion = null;

                        call.setParameter("TIPODOC", asociado.getBeneficiario().getTipodocumentoid().getNombredocumento());
                        call.setParameter("NUMERODOC", asociado.getBeneficiario().getNumerodocumento());
                        call.setParameter("DESDE", desde);

                        // call the stored procedure and get the result
                        try {
                            call.execute();
                            fechaLiquidacion = (Timestamp) call.getOutputParameterValue("FECHA_LIQUIDACION_BENEFICIO");
                            if (fechaLiquidacion == null) {
                                break;
                            }
                        } catch (Exception ex) {

                            break;
                        }
                        Calendar cal3 = Calendar.getInstance();
                        cal3.setTime(fechaLiquidacion);
                        cal3.add(Calendar.YEAR, 3);
                        hasta = new Timestamp(cal3.getTime().getTime());
                        desde = hasta;

                    }
                    if (fechaLiquidacion != null) {
                        StoredProcedureQuery call2 = sesion2.createStoredProcedureQuery("GET_CANTIDAD_BENEFICIOS");
                        call2.registerStoredProcedureParameter("TIPODOC", String.class, ParameterMode.IN);
                        call2.registerStoredProcedureParameter("NUMERODOC", String.class, ParameterMode.IN);
                        call2.registerStoredProcedureParameter("DESDE", Timestamp.class, ParameterMode.IN);
                        call2.registerStoredProcedureParameter("NUMERO_BENEFICIOS_LIQUIDADOS", String.class, ParameterMode.OUT);

                        call2.setParameter("TIPODOC", asociado.getBeneficiario().getTipodocumentoid().getNombredocumento());
                        call2.setParameter("NUMERODOC", asociado.getBeneficiario().getNumerodocumento());
                        call2.setParameter("DESDE", fechaLiquidacion);

                        call2.execute();
                        String cantidadBeneficios = (String) call2.getOutputParameterValue("NUMERO_BENEFICIOS_LIQUIDADOS");
                        int cantidadB2 = Integer.parseInt(cantidadBeneficios);
                        if (cantidadB2 >= 6) {
                            throw new Exception(MensajesBD.ERROR_BENEFICIOS_ECONOMICOS);
                        }

                    }
                }
            }

            // creo el query
            Query elQuery = sesion.createQuery("from Financiacion where idfinanciacion=:idFinanciacion", Financiacion.class);
            elQuery.setParameter("idFinanciacion", financiacion.getIdfinanciacion());
            //obtengo resultados del query
            financiacion2 = (Financiacion) elQuery.getSingleResult();
            financiacion.setTipofinanciacionByIdtipofinanciaciona(financiacion.getTipofinanciacionByIdtipofinanciaciona());

            financiacion2.setMontoa(financiacion.getMontoa());

            financiacion2.setTasainteresa(financiacion.getTasainteresa());

            financiacion2.setCuotaspactadasa(financiacion.getCuotaspactadasa());

            financiacion2.setTipofinanciacionByIdtipofinanciaciona(financiacion.getTipofinanciacionByIdtipofinanciaciona());
            Entidadesfinancieras entidad = financiacion.getEntidadesfinancieras();

            financiacion2.setEntidadesfinancieras(financiacion.getEntidadesfinancieras());

            sesion.update(financiacion2);

            Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
            emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
            emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            sesion.update(emprendimiento);
            sesion.flush();
            sesion2.flush();
            sesion.getTransaction().commit();
            sesion2.getTransaction().commit();
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            sesion2.getTransaction().rollback();
            if (ex.getMessage().equals(MensajesBD.ERROR_BENEFICIOS_ECONOMICOS)) {
                throw new Exception(MensajesBD.ERROR_BENEFICIOS_ECONOMICOS);
            }
            throw new Exception(MensajesBD.ERROR_REGISTRO_FINANCIACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }

            if (sesion2 != null && sesion2.isOpen()) {
                sesion2.close();
            }
        }
    }
}

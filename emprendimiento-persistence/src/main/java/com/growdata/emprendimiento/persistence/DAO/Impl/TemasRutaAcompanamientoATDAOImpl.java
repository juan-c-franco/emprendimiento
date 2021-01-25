/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TemasRutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class TemasRutaAcompanamientoATDAOImpl implements TemasRutaAcompanamientoATDAO {

  private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que crea temas de acompañamiento en la BD, y actualiza el estado
     * del emprendimiento
     *
     * @param temasRuta Una lista con los temas a crear
     * @param idemprendimiento El id del emprendimiento
     * @param estadoEmprendimiento El estado al que se va actualizar el
     * emprendimiento
     * @return Un número que dice el estado del proceso
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public long crearTema(List<Temasrutaacompanamientoat> temasRuta,
            long idemprendimiento, Estadoemprendimiento estadoEmprendimiento) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hoy = new Date();
        long id = -1;

        Temasrutaacompanamientoat temaAux = new Temasrutaacompanamientoat();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            for (Temasrutaacompanamientoat t : temasRuta) {
                Query elQuery = sesion.createQuery("from Temasrutaacompanamientoat where"
                        + " idrutaacompanamientoat=:idrutaacompanamientoat and idtema=:idtema", Temasrutaacompanamientoat.class);
                elQuery.setParameter("idrutaacompanamientoat", t.getRutaacompanamientoat().getIdrutaacompanamientoat());
                elQuery.setParameter("idtema", t.getTemasevaluacion().getIdtema());
                List<Temasrutaacompanamientoat> temasAux = elQuery.getResultList();
                if (temasAux.size() > 0) {
                    if (dateFormat.format(hoy).equals(dateFormat.format(temasAux.get(0).getFecharegistro()))) {
                        throw new NoResultException();
                    }
                    temasAux.get(0).setCantidadhorasplaneadas(new BigDecimal(temasAux.get(0).getCantidadhorasplaneadas().longValue() + t.getCantidadhorasplaneadas().longValue()));
                    temasAux.get(0).setFecharegistro(hoy);
                    sesion.update(temasAux.get(0));
                } else {
                    sesion.save(t);

                }
            }
            Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
            emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
            emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            sesion.update(emprendimiento);

//            if (temasAux.size() > 0) {
//
//                for (Temasrutaacompanamientoat temaRuta : temasAux) {
//                    // creo el query
//                    Query elQuery2 = sesion.createQuery("from Temasrutaacompanamientoat where"
//                            + " idrutaacompanamientoat=:idrutaacompanamientoat and idtema=:idtema", Temasrutaacompanamientoat.class);
//                    elQuery2.setParameter("idrutaacompanamientoat", temaRuta.getRutaacompanamientoat().getIdrutaacompanamientoat());
//                    elQuery2.setParameter("idtema", temaRuta.getTemasevaluacion().getIdtema());
//                    temaAux = (Temasrutaacompanamientoat) elQuery.getSingleResult();
//
//                    temaRuta.setCantidadhorasplaneadas(new BigDecimal(temaAux.getCantidadhorasplaneadas().longValue() + temaAux.getCantidadhorasplaneadas().longValue()));
//                    temaAux.setCantidadhorasplaneadas(temaRuta.getCantidadhorasplaneadas());
//
//                    sesion.update(temaAux);
//                }
//                Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
//                emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
//                emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
//                sesion.update(emprendimiento);
//                sesion.flush();
//
//            } else {
//                throw new NoResultException();
//            }
            sesion.getTransaction().commit();
            id = 1;

        } catch (NoResultException ex) {
//            temasRuta.forEach((temaRuta) -> {
//                sesion.save(temaRuta);
//            });
//            Emprendimiento emprendimiento = (Emprendimiento) sesion.get(Emprendimiento.class, idemprendimiento);
//            emprendimiento.setEstadoemprendimiento(estadoEmprendimiento);
//            emprendimiento.setFecharegistro(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
//            sesion.update(emprendimiento);
//            sesion.flush();
//            sesion.getTransaction().commit();
//            id = 1;
            sesion.getTransaction().rollback();
            return id;
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_CREACION_TEMA_ACOMPANAMIENTO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
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
public class TemasRutaCapacitacionDAOImpl implements TemasRutaCapacitacionDAO {

  private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que crea temas de capacitacion en la BD
     *
     * @param temasRuta Una lista con los temas a crear
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public long crearTema(List<Temasrutacapacitacion> temasRuta) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();

        Temasrutacapacitacion temaAux = new Temasrutacapacitacion();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hoy = new Date();
        long id = -1;
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            for (Temasrutacapacitacion t : temasRuta) {
                // creo el query
                Query elQuery = sesion.createQuery("from Temasrutacapacitacion where"
                        + " idrutacapacitacion=:idrutacapacitacion and nombretema=:nombretema", Temasrutacapacitacion.class);
                elQuery.setParameter("idrutacapacitacion", t.getRutacapacitacion().getIdrutacapacitacion());
                elQuery.setParameter("nombretema", t.getNombretema());
                List<Temasrutacapacitacion> temasAux = elQuery.getResultList();
                if(temasAux.size()>0){
                    if(dateFormat.format(hoy).equals(dateFormat.format(temasAux.get(0).getFecharregistro()))){
                        throw new NoResultException();
                    }
                    
                    temasAux.get(0).setCantidadhorasplaneadas(new BigDecimal(t.getCantidadhorasplaneadas().longValue() + temasAux.get(0).getCantidadhorasplaneadas().longValue()));
                    temasAux.get(0).setFecharregistro(hoy);
                    sesion.update(temasAux.get(0));
                }else{
                   sesion.save(t); 
                }
            }
            
            sesion.getTransaction().commit();
            id = 1;

//            if (temasAux.size() > 0) {
//                if (dateFormat.format(hoy).equals(dateFormat.format(temasAux.get(0).getFecharregistro()))) {
//                    return id;
//                }
//                for (Temasrutacapacitacion temaRuta : temasAux) {
//                    Query elQuery2 = sesion.createQuery("from Temasrutacapacitacion where"
//                            + " idrutacapacitacion=:idrutacapacitacion and idtemarutacapacitacion=:idtemarutacapacitacion", Temasrutacapacitacion.class);
//                    elQuery2.setParameter("idrutacapacitacion", temaRuta.getRutacapacitacion().getIdrutacapacitacion());
//                    elQuery2.setParameter("idtemarutacapacitacion", temaRuta.getIdtemarutacapacitacion());
//                    temaAux = (Temasrutacapacitacion) elQuery2.getSingleResult();
//                    temaRuta.setCantidadhorasplaneadas(new BigDecimal(temaRuta.getCantidadhorasplaneadas().longValue() + temaAux.getCantidadhorasplaneadas().longValue()));
//                    temaRuta.setFecharregistro(hoy);
//                    sesion.update(temaRuta);
//                }
//            } else {
//                throw new NoResultException();
//            }

           
        } catch (NoResultException ex) {
//            temasRuta.forEach((temaRuta) -> {
//                sesion.save(temaRuta);
//            });
             sesion.getTransaction().rollback();
             return id;
                      
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_CREACION_TEMA_RUTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;

    }

    /**
     * Metodo que trae los temas de capacitacion de la BD a partir de un id de
     * beneficiario
     *
     * @param idbeneficiario El id del beneficiario
     * @return Una lista con los temas de capacitación
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public List<Temasrutacapacitacion> getTemasRutaCapacitacionPorBeneficiario(long idbeneficiario) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Temasrutacapacitacion> temasRutaCapacitacion = new ArrayList<>();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Temasrutacapacitacion where rutacapacitacion.beneficiario.idbeneficiario=:idbeneficiario", Temasrutacapacitacion.class);
            q.setParameter("idbeneficiario", idbeneficiario);
            temasRutaCapacitacion = q.getResultList();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return temasRutaCapacitacion;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.RespuestasEncuestaDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Respuestasencuesta;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class RespuestasEncuestaDAOImpl implements RespuestasEncuestaDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que guarda una respuesta de la encuesta
     *
     * @param respuesta La respuesta a guardar
     * @return Respuesta si se guardo al respuesta exitosamente o no
     * @throws Exception Cualquier Exception que puede ser lanzada.
     */
    @Override
    public String guardarRespuesta(Respuestasencuesta respuesta) throws Exception {
        String resp = "";
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            sesion.save(respuesta);

            //obtengo resultados del query
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_RESPUESTA, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
}

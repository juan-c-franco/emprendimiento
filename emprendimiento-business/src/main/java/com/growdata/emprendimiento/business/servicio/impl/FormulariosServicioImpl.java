/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.servicio.FormulariosServicio;
import com.growdata.emprendimiento.persistence.DAO.FormulariosDAO;
import com.growdata.emprendimiento.persistence.entidad.Formulariosweb;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class FormulariosServicioImpl implements FormulariosServicio {

    @Autowired
    private FormulariosDAO formulariosDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que trae los formularios
     *
     * @return Una lista con los formularios
     */
    @Override
    @Transactional
    public List<Formulariosweb> getFormularios() {
        try {
            return formulariosDAO.getFormularios();
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
        return null;
    }
}

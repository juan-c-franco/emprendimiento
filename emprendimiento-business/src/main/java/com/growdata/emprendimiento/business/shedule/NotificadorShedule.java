/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.shedule;

import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.UserDetailsDao;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Component
public class NotificadorShedule {

    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private PlantillaMailDAO plantillaMailDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Scheduled(cron = "0 0 7 * * *")
    public void scheduleFixedDelayTask() {
        try {
            notificaBeneficiarios(4, beneficiarioDAO.getNotificaBeneficiarios());
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void desbloquearUsuarios() {
        try {
            userDetailsDao.unblockUsers();
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
    }

    private void notificaBeneficiarios(long idPlantilla, List<Beneficiario> beneficiarios) {
//        EnviarEmail mail = new EnviarEmail();
        try {
            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
            for (Beneficiario beneficiario : beneficiarios) {
                String tempPlantilla = new String(plantilla.getPlantilla());
                tempPlantilla = tempPlantilla.replace("<#nombres#>", beneficiario.getPrimernombre() + " " + beneficiario.getSegundonombre());
                tempPlantilla = tempPlantilla.replace("<#apellidos#>", beneficiario.getPrimerapellido() + " " + beneficiario.getSegundoapellido());
                tempPlantilla = tempPlantilla.replace("<#telefono#>", String.valueOf(beneficiario.getTelefono()));
                tempPlantilla = tempPlantilla.replace("<#documento#>", String.valueOf(beneficiario.getDocumentoses()));
                final String email = beneficiario.getEmail();
                final String asunto = plantilla.getAsunto();
                final String plantillaFinal = tempPlantilla;
//                Runnable runnable = () -> {
//                    mail.enviarEmail(email, asunto, plantillaFinal);
//                };
//                new Thread(runnable).start();

                mail.enviarEmail(email, asunto, plantillaFinal);
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
        }
    }
}

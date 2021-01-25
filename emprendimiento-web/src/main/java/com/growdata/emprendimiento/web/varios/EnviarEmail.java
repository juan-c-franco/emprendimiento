/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @Author Andrés Felipe González Growdata
 */
package com.growdata.emprendimiento.web.varios;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Andrés Felipe González Grow Data
 */
public class EnviarEmail {

    public EnviarEmail() {

    }
    private final Properties propiedades = new Properties();

    //private final String password = "Colombia2018";
    private final String password = "Growdata2018";
    private Session session;

    private void init() {

        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", 587);
        propiedades.put("mail.smtp.mail.sender", "emprendimientopnud@gmail.com");
        propiedades.put("mail.smtp.user", "emprendimientopnud@gmail.com");
        propiedades.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(propiedades);
    }

    /**
     * Metodo para enviar emails
     *
     * @param correo Direccion de correo electrónico
     * @param asunto Asunto
     * @param cuerpo Mensaje del correo electrónico
     * @return Indica si se envio satisfactoriamente el correo.
     */
    public boolean enviarEmail(String correo, String asunto, String cuerpo) {

        init();
        boolean enviado = false;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) propiedades.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport t = session.getTransport("smtp");
            t.connect("emprendimientopnud@gmail.com", password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            enviado = true;

        } catch (MessagingException me) {
        }
        return enviado;
    }

}

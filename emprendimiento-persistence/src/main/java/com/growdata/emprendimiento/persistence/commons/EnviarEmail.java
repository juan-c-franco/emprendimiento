/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @Author AndrÃ©s Felipe GonzÃ¡lez Growdata
 */
package com.growdata.emprendimiento.persistence.commons;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Session;

public class EnviarEmail {

    public EnviarEmail() {

    }
    private final Properties propiedades = new Properties();

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
     * Método para validar si una cadena de carácteres corresponde a un correo
     * electrónico
     *
     * @param correo Cadena de carácteres
     * @return Indica si la cadena es válida según el patrón.
     */
    public boolean validarEmail(String correo) {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}

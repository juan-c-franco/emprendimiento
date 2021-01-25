/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.varios;

import com.growdata.emprendimiento.business.servicio.UserAttemptsServicio;
import com.growdata.emprendimiento.persistence.DAO.UserDetailsDao;
import com.growdata.emprendimiento.persistence.commons.CredencialesMalasException;
import com.growdata.emprendimiento.persistence.entidad.UserAttempts;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserDetailsDao userDetailsDao;
    
    @Autowired
    private UserAttemptsServicio userAttemptsServicio;
    private final int intentosBloqueo = 3;
    @Autowired
    @Qualifier("userDetailsService")
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        try {

            Authentication auth = super.authenticate(authentication);

            //if reach here, means login success, else an exception will be thrown
            //reset the user_attempts
            userDetailsDao.resetFailAttempts(authentication.getName());

            return auth;

        } catch (BadCredentialsException e) {

            //invalid login, update to user_attempts
            userDetailsDao.updateFailAttempts(authentication.getName());
            UserAttempts intentosUsuario = userDetailsDao.getUserAttempts(authentication.getName()); 
            String error ="";
            if(intentosUsuario !=null){
                  int intentos = intentosBloqueo - intentosUsuario.getAttempts();
            error = "Usuario/Contraseña Incorrectos <br> Tras 3 intentos fallidos la cuenta será bloqueada<br> "
                    + "Usuario: "+authentication.getName()+"<br>"
                    + "Intentos Restantes: "+intentos;
            }else{
                error = "Usuario/Contraseña Incorrectos <br> Tras 3 intentos fallidos la cuenta será bloqueada<br> "
                    + "Usuario: "+authentication.getName()+"<br>"
                    + "Intentos Restantes: 3";
            }
          
            throw new CredencialesMalasException(error);

        } catch (LockedException e) {

            //this user is locked!
            String error = "";
            UserAttempts userAttempts
                    = userDetailsDao.getUserAttempts(authentication.getName());

            if (userAttempts != null) {
                Date lastAttempts = userAttempts.getLastModified();
                error = "La cuenta de usuario ha sido bloqueada! <br><br>Username : "
                        + authentication.getName() + "<br>Último Intento de login : " + lastAttempts;
            } else {
                error = e.getMessage();
            }

            throw new LockedException(error);
        } catch (CredentialsExpiredException e) {
            String error = authentication.getName();
            throw new CredentialsExpiredException(error);
        }

    }
}

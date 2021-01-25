/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Grow Data PC
 */
@Configuration
@EnableWebSecurity
public class EmprendimientoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;
    @Autowired
    @Qualifier("authenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String query = "select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id ";
        auth.authenticationProvider(authenticationProvider).jdbcAuthentication().dataSource(securityDataSource).groupAuthoritiesByUsername(query);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/modificarContrasenaObligado2").permitAll()
                .antMatchers("/confirmoCambioClave").permitAll()
                .antMatchers("/restaurarContra").permitAll()
                .antMatchers("/usuarioCreado").permitAll()
                .antMatchers("/crearUsuario").permitAll()
                .antMatchers("/emprendimiento-web/crearUsuario").permitAll()
                .antMatchers("/resetPassword").permitAll()
                .antMatchers("/cambioClave").permitAll()
                .antMatchers("/olvidoContrasena").permitAll()
                .antMatchers("/correoContrasena").permitAll()
                .antMatchers("/sesionExpirada").authenticated()
                .antMatchers("/olvidoContrasenaCorreo").permitAll()
                .antMatchers("/traerSesiones").hasRole("fsensibilizacion")
                .antMatchers("/registrarAsistencia").hasRole("fsensibilizacion")
                .antMatchers("/traerAsistentes").hasRole("fsensibilizacion")
                .antMatchers("/errorFecha").hasRole("fsensibilizacion")
                .antMatchers("/encuestaSensibilizacion").permitAll()
                .antMatchers("/encuestaValoracion").permitAll()
                .antMatchers("/registrarEncuestaValoracion").permitAll()
                .antMatchers("/consultaBeneficiario").hasRole("fsensibilizacion")
                .antMatchers("/findBeneficiario").hasRole("fsensibilizacion")
                .antMatchers("/programarSesion").hasRole("fsensibilizacion")
                .antMatchers("/registroAsistencias").hasRole("fsensibilizacion")
                .antMatchers("/registroAsistencia3").hasRole("fsensibilizacion")
                .antMatchers("/registroAsistenciasModificadas").hasRole("fsensibilizacion")
                .antMatchers("/enviarEncuesta").hasRole("fsensibilizacion")
                .antMatchers("/registroInasistentes").hasRole("fsensibilizacion")
                .antMatchers("/modificarAsistentes").hasRole("fsensibilizacion")
                .antMatchers("/errorEncuesta").hasRole("fsensibilizacion")
                // .antMatchers("/").hasAnyRole("Administrador","Atención CCF")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //                .failureHandler(UserNameCachingAuthenticationFailureHandler())
                .loginPage("/mostrarLogin").failureUrl("/mostrarLogin?error")
                //bloqueo usuarios
                .usernameParameter("username")
                .passwordParameter("password")
                //fin bloqueo
                .loginProcessingUrl("/autenticarUsuario")
                .permitAll()
                .and()
                .logout().permitAll().clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true).logoutSuccessUrl("/mostrarLogin?logout").deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/acceso-denegado")
                .and()
                .sessionManagement()
                .sessionFixation().none()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);
        http.csrf().disable();
        //remember me configuration
        http.rememberMe().
                key("rem-me-key").
                rememberMeParameter("remember-me-param").
                rememberMeCookieName("my-remember-me").
                tokenValiditySeconds(86400);
    }

//     @Bean
//    public AuthenticationFailureHandler UserNameCachingAuthenticationFailureHandler() {
//        return new UserNameCachingAuthenticationFailureHandler();
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.config;

import java.io.IOException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = "com.growdata.emprendimiento.web")
@ComponentScan(basePackages = "com.growdata.emprendimiento.persistence")
@ComponentScan(basePackages = "com.growdata.emprendimiento.business")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
public class EmprendimientoAppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(5242880);//5MB
        return resolver;
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean(destroyMethod = "")
    public DataSource securityDataSource() {
        Context ctx = null;
        Hashtable<String, String> ht = new Hashtable<String, String>();
        DataSource ds = null;
        ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL, "t3://" + env.getProperty("ip.servidor.app"));
        try {
            ctx = new InitialContext(ht);
            ds = (DataSource) ctx.lookup("jdbc/emprendimiento");
        } catch (Exception ex) {
            System.out.println("Problemas con el JNDI");
            
        }
        return ds;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/", "/other-resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    public int traerPropiedadInt(String propiedad) {
        String prop = env.getProperty(propiedad);

        int intProp = Integer.parseInt(prop);
        return intProp;
    }
}

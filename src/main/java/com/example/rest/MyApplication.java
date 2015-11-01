package com.example.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 *
 * @author tada
 */
@ApplicationPath("api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(JspMvcFeature.class);
        register(MvcBeanValidationFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        packages(true, this.getClass().getPackage().getName());
    }
}

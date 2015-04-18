package com.letionik.payless.server;

import com.letionik.payless.server.config.RestEasyAnnotatedContextLoader;
import com.letionik.payless.server.config.SpringApplicationConfiguration;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    private static final String REST_API_PREFIX = "/";

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringApplicationConfiguration.class);
        rootContext.getEnvironment().setDefaultProfiles("local");

        servletContext.addListener(new ResteasyBootstrap());
        servletContext.addListener(new RestEasyAnnotatedContextLoader(rootContext));

        ServletRegistration.Dynamic restEasyDispatcher = servletContext.addServlet("RestEasyHttpServletDispatcher", new HttpServletDispatcher());
        restEasyDispatcher.setLoadOnStartup(1);
        restEasyDispatcher.addMapping(REST_API_PREFIX + "*");

        servletContext.setInitParameter("resteasy.media.type.mappings", "json:application/json");
        servletContext.setInitParameter("resteasy.servlet.mapping.prefix", REST_API_PREFIX);
        servletContext.setInitParameter("PARAMETER_ENCODING", "UTF-8");
	}

}

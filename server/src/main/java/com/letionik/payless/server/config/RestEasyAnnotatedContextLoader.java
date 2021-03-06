package com.letionik.payless.server.config;

import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class RestEasyAnnotatedContextLoader extends ContextLoaderListener {

	private final SpringContextLoaderSupport springContextLoaderSupport = new SpringContextLoaderSupport();

	public RestEasyAnnotatedContextLoader() {
		super();
	}

	public RestEasyAnnotatedContextLoader(WebApplicationContext context) {
		super(context);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		boolean scanProviders = false;
		boolean scanResources = false;

		String sProviders = event.getServletContext().getInitParameter("resteasy.scan.providers");
		if (sProviders != null) {
			scanProviders = Boolean.valueOf(sProviders.trim());
		}
		String scanAll = event.getServletContext().getInitParameter("resteasy.scan");
		if (scanAll != null) {
			boolean shouldScanAll = Boolean.valueOf(scanAll.trim());
			scanProviders = shouldScanAll || scanProviders;
			scanResources = shouldScanAll;
		}
		String sResources = event.getServletContext().getInitParameter("resteasy.scan.resources");
		if (sResources != null) {
			scanResources = Boolean.valueOf(sResources.trim());
		}

		if (scanProviders || scanResources) {
			throw new IllegalArgumentException("You cannot use resteasy.scan, resteasy.scan.resources, "
					+ "or resteasy.scan.providers with the SpringContextLoaderLister"
					+ " as this may cause serious deployment errors in your application");
		}

		super.contextInitialized(event);
	}

	@Override
	protected void customizeContext(
			ServletContext servletContext,
			ConfigurableWebApplicationContext configurableWebApplicationContext) {
		super.customizeContext(servletContext, configurableWebApplicationContext);
		this.springContextLoaderSupport.customizeContext(servletContext, configurableWebApplicationContext);
	}

}
